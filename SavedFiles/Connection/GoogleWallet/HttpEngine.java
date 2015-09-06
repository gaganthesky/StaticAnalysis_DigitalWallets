package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Map;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class HttpEngine
{
  private static final ResponseBody EMPTY_BODY = local1;
  public final boolean bufferRequestBody;
  private BufferedSink bufferedRequestBody;
  private Response cacheResponse;
  private CacheStrategy cacheStrategy;
  private final boolean callerWritesRequestBody;
  final OkHttpClient client;
  private Connection connection;
  private final boolean forWebSocket;
  private Request networkRequest;
  private final Response priorResponse;
  private Sink requestBodyOut;
  private Route route;
  private RouteSelector routeSelector;
  long sentRequestMillis;
  private CacheRequest storeRequest;
  private boolean transparentGzip;
  private Transport transport;
  private final Request userRequest;
  private Response userResponse;

  static
  {
    HttpEngine.1 local1 = new com/squareup/okhttp/internal/http/HttpEngine$1;
    local1.<init>();
  }

  public HttpEngine(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Connection paramConnection, RouteSelector paramRouteSelector, RetryableSink paramRetryableSink, Response paramResponse)
  {
    long l = 4294967295L;
    this.sentRequestMillis = l;
    this.client = paramOkHttpClient;
    this.userRequest = paramRequest;
    this.bufferRequestBody = paramBoolean1;
    this.callerWritesRequestBody = paramBoolean2;
    this.forWebSocket = paramBoolean3;
    this.connection = paramConnection;
    this.routeSelector = paramRouteSelector;
    this.requestBodyOut = paramRetryableSink;
    this.priorResponse = paramResponse;
    Object localObject;
    if (paramConnection != null)
    {
      localObject = Internal.instance;
      ((Internal)localObject).setOwner(paramConnection, this);
      localObject = paramConnection.getRoute();
    }
    for (this.route = ((Route)localObject); ; this.route = ((Route)localObject))
    {
      return;
      localObject = null;
    }
  }

  private Response cacheWritingResponse(CacheRequest paramCacheRequest, Response paramResponse)
    throws IOException
  {
    if (paramCacheRequest == null);
    while (true)
    {
      return paramResponse;
      Sink localSink = paramCacheRequest.body();
      if (localSink != null)
      {
        Object localObject = paramResponse.body();
        BufferedSource localBufferedSource1 = ((ResponseBody)localObject).source();
        BufferedSink localBufferedSink = Okio.buffer(localSink);
        HttpEngine.2 local2 = new com/squareup/okhttp/internal/http/HttpEngine$2;
        local2.<init>(this, localBufferedSource1, paramCacheRequest, localBufferedSink);
        localObject = paramResponse.newBuilder();
        RealResponseBody localRealResponseBody = new com/squareup/okhttp/internal/http/RealResponseBody;
        Headers localHeaders = paramResponse.headers();
        BufferedSource localBufferedSource2 = Okio.buffer(local2);
        localRealResponseBody.<init>(localHeaders, localBufferedSource2);
        localObject = ((Response.Builder)localObject).body(localRealResponseBody);
        paramResponse = ((Response.Builder)localObject).build();
      }
    }
  }

  public final Connection close()
  {
    Object localObject2 = null;
    Object localObject3 = this.bufferedRequestBody;
    Object localObject1;
    if (localObject3 != null)
    {
      localObject3 = this.bufferedRequestBody;
      Util.closeQuietly((Closeable)localObject3);
      localObject3 = this.userResponse;
      if (localObject3 != null)
        break label83;
      localObject3 = this.connection;
      if (localObject3 != null)
      {
        localObject3 = this.connection;
        localObject3 = ((Connection)localObject3).getSocket();
        Util.closeQuietly((Socket)localObject3);
      }
      this.connection = localObject2;
      localObject1 = localObject2;
    }
    while (true)
    {
      return localObject1;
      localObject3 = this.requestBodyOut;
      if (localObject3 == null)
        break;
      localObject3 = this.requestBodyOut;
      Util.closeQuietly((Closeable)localObject3);
      break;
      label83: localObject3 = this.userResponse;
      localObject3 = ((Response)localObject3).body();
      Util.closeQuietly((Closeable)localObject3);
      localObject3 = this.transport;
      Object localObject4;
      if (localObject3 != null)
      {
        localObject3 = this.connection;
        if (localObject3 != null)
        {
          localObject3 = this.transport;
          boolean bool1 = ((Transport)localObject3).canReuseConnection();
          if (!bool1)
          {
            localObject4 = this.connection;
            localObject4 = ((Connection)localObject4).getSocket();
            Util.closeQuietly((Socket)localObject4);
            this.connection = localObject2;
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        localObject4 = this.connection;
        if (localObject4 != null)
        {
          localObject4 = Internal.instance;
          Connection localConnection = this.connection;
          boolean bool2 = ((Internal)localObject4).clearOwner(localConnection);
          if (!bool2)
            this.connection = localObject2;
        }
        localObject1 = this.connection;
        this.connection = localObject2;
      }
    }
  }

  private static Headers combine(Headers paramHeaders1, Headers paramHeaders2)
    throws IOException
  {
    Headers.Builder localBuilder = new com/squareup/okhttp/Headers$Builder;
    localBuilder.<init>();
    int i = 0;
    int j = paramHeaders1.size();
    String str1;
    String str5;
    while (i < j)
    {
      str1 = paramHeaders1.name(i);
      String str2 = paramHeaders1.value(i);
      String str3 = "Warning";
      boolean bool1 = str3.equalsIgnoreCase(str1);
      boolean bool2;
      if (bool1)
      {
        String str4 = "1";
        bool2 = str2.startsWith(str4);
        if (bool2);
      }
      else
      {
        bool2 = OkHeaders.isEndToEnd(str1);
        if (bool2)
        {
          str5 = paramHeaders2.get(str1);
          if (str5 != null);
        }
        else
        {
          localBuilder.add(str1, str2);
        }
      }
      i += 1;
    }
    i = 0;
    j = paramHeaders2.size();
    while (i < j)
    {
      str1 = paramHeaders2.name(i);
      str5 = "Content-Length";
      boolean bool3 = str5.equalsIgnoreCase(str1);
      if (!bool3)
      {
        bool3 = OkHeaders.isEndToEnd(str1);
        if (bool3)
        {
          localObject = paramHeaders2.value(i);
          localBuilder.add(str1, (String)localObject);
        }
      }
      i += 1;
    }
    Object localObject = localBuilder.build();
    return localObject;
  }

  private void connect(Request paramRequest)
    throws IOException
  {
    Object localObject = this.connection;
    if (localObject != null)
    {
      localObject = new java/lang/IllegalStateException;
      ((IllegalStateException)localObject).<init>();
      throw ((Throwable)localObject);
    }
    localObject = this.routeSelector;
    if (localObject == null)
    {
      localObject = this.client;
      localObject = RouteSelector.get(paramRequest, (OkHttpClient)localObject);
      this.routeSelector = ((RouteSelector)localObject);
    }
    localObject = this.routeSelector;
    localObject = ((RouteSelector)localObject).next(this);
    this.connection = ((Connection)localObject);
    localObject = this.connection;
    localObject = ((Connection)localObject).getRoute();
    this.route = ((Route)localObject);
  }

  public final void disconnect()
  {
    Transport localTransport = this.transport;
    if (localTransport != null);
    try
    {
      localTransport = this.transport;
      localTransport.disconnect(this);
      label22: return;
    }
    catch (IOException localIOException)
    {
      break label22;
    }
  }

  public final Request followUpRequest()
    throws IOException
  {
    Object localObject1 = null;
    Object localObject3 = this.userResponse;
    if (localObject3 == null)
    {
      localObject1 = new java/lang/IllegalStateException;
      ((IllegalStateException)localObject1).<init>();
      throw ((Throwable)localObject1);
    }
    localObject3 = getRoute();
    Proxy localProxy;
    if (localObject3 != null)
    {
      localObject3 = getRoute();
      localProxy = ((Route)localObject3).getProxy();
      localObject3 = this.userResponse;
      int i = ((Response)localObject3).code();
      switch (i)
      {
      default:
      case 407:
      case 401:
      case 307:
      case 308:
      case 300:
      case 301:
      case 302:
      case 303:
      }
    }
    while (true)
    {
      return localObject1;
      localObject3 = this.client;
      localProxy = ((OkHttpClient)localObject3).getProxy();
      break;
      localObject1 = localProxy.type();
      localObject3 = Proxy.Type.HTTP;
      if (localObject1 != localObject3)
      {
        localObject1 = new java/net/ProtocolException;
        localObject3 = "Received HTTP_PROXY_AUTH (407) code while not using proxy";
        ((ProtocolException)localObject1).<init>((String)localObject3);
        throw ((Throwable)localObject1);
      }
      localObject1 = this.client;
      localObject1 = ((OkHttpClient)localObject1).getAuthenticator();
      localObject3 = this.userResponse;
      localObject1 = OkHeaders.processAuthHeader((Authenticator)localObject1, (Response)localObject3, localProxy);
      continue;
      localObject3 = this.userRequest;
      localObject3 = ((Request)localObject3).method();
      Object localObject8 = "GET";
      boolean bool3 = ((String)localObject3).equals(localObject8);
      if (!bool3)
      {
        Object localObject4 = this.userRequest;
        localObject4 = ((Request)localObject4).method();
        localObject8 = "HEAD";
        boolean bool4 = ((String)localObject4).equals(localObject8);
        if (!bool4);
      }
      else
      {
        OkHttpClient localOkHttpClient = this.client;
        boolean bool5 = localOkHttpClient.getFollowRedirects();
        if (bool5)
        {
          Object localObject5 = this.userResponse;
          localObject8 = "Location";
          String str1 = ((Response)localObject5).header((String)localObject8);
          if (str1 != null)
          {
            URL localURL = new java/net/URL;
            localObject5 = this.userRequest;
            localObject5 = ((Request)localObject5).url();
            localURL.<init>((URL)localObject5, str1);
            localObject5 = localURL.getProtocol();
            localObject8 = "https";
            boolean bool6 = ((String)localObject5).equals(localObject8);
            if (!bool6)
            {
              String str2 = localURL.getProtocol();
              localObject8 = "http";
              boolean bool7 = str2.equals(localObject8);
              if (!bool7);
            }
            else
            {
              Object localObject6 = localURL.getProtocol();
              localObject8 = this.userRequest;
              localObject8 = ((Request)localObject8).url();
              localObject8 = ((URL)localObject8).getProtocol();
              boolean bool1 = ((String)localObject6).equals(localObject8);
              if (!bool1)
              {
                localObject6 = this.client;
                boolean bool8 = ((OkHttpClient)localObject6).getFollowSslRedirects();
                if (!bool8);
              }
              else
              {
                Object localObject7 = this.userRequest;
                Request.Builder localBuilder = ((Request)localObject7).newBuilder();
                localObject7 = this.userRequest;
                localObject7 = ((Request)localObject7).method();
                boolean bool9 = HttpMethod.permitsRequestBody((String)localObject7);
                if (bool9)
                {
                  String str3 = "GET";
                  localBuilder.method(str3, (RequestBody)localObject1);
                  localObject1 = "Transfer-Encoding";
                  localBuilder.removeHeader((String)localObject1);
                  localObject1 = "Content-Length";
                  localBuilder.removeHeader((String)localObject1);
                  localObject1 = "Content-Type";
                  localBuilder.removeHeader((String)localObject1);
                }
                boolean bool2 = sameConnection(localURL);
                if (!bool2)
                {
                  localObject2 = "Authorization";
                  localBuilder.removeHeader((String)localObject2);
                }
                Object localObject2 = localBuilder.url(localURL);
                localObject2 = ((Request.Builder)localObject2).build();
              }
            }
          }
        }
      }
    }
  }

  public final BufferedSink getBufferedRequestBody()
  {
    BufferedSink localBufferedSink = this.bufferedRequestBody;
    if (localBufferedSink != null);
    while (true)
    {
      return localBufferedSink;
      Sink localSink = getRequestBody();
      if (localSink != null)
      {
        localBufferedSink = Okio.buffer(localSink);
        this.bufferedRequestBody = localBufferedSink;
      }
      else
      {
        localBufferedSink = null;
      }
    }
  }

  public final Connection getConnection()
  {
    Connection localConnection = this.connection;
    return localConnection;
  }

  public final Request getRequest()
  {
    Request localRequest = this.userRequest;
    return localRequest;
  }

  public final Sink getRequestBody()
  {
    Object localObject = this.cacheStrategy;
    if (localObject == null)
    {
      localObject = new java/lang/IllegalStateException;
      ((IllegalStateException)localObject).<init>();
      throw ((Throwable)localObject);
    }
    localObject = this.requestBodyOut;
    return localObject;
  }

  public final Response getResponse()
  {
    Object localObject = this.userResponse;
    if (localObject == null)
    {
      localObject = new java/lang/IllegalStateException;
      ((IllegalStateException)localObject).<init>();
      throw ((Throwable)localObject);
    }
    localObject = this.userResponse;
    return localObject;
  }

  public final Route getRoute()
  {
    Route localRoute = this.route;
    return localRoute;
  }

  public static boolean hasBody(Response paramResponse)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    Object localObject = paramResponse.request();
    localObject = ((Request)localObject).method();
    String str2 = "HEAD";
    boolean bool3 = ((String)localObject).equals(str2);
    if (bool3);
    while (true)
    {
      return bool1;
      int i = paramResponse.code();
      int j = 100;
      if (i >= j)
      {
        j = 200;
        if (i < j);
      }
      else
      {
        j = 204;
        if (i != j)
        {
          j = 304;
          if (i != j)
          {
            bool1 = bool2;
            continue;
          }
        }
      }
      long l1 = OkHeaders.contentLength(paramResponse);
      long l2 = 4294967295L;
      boolean bool4 = l1 < l2;
      if (!bool4)
      {
        String str1 = "chunked";
        String str3 = "Transfer-Encoding";
        str3 = paramResponse.header(str3);
        boolean bool5 = str1.equalsIgnoreCase(str3);
        if (!bool5);
      }
      else
      {
        bool1 = bool2;
      }
    }
  }

  public final boolean hasResponse()
  {
    Response localResponse = this.userResponse;
    if (localResponse != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public static String hostHeader(URL paramURL)
  {
    int i = Util.getEffectivePort(paramURL);
    String str1 = paramURL.getProtocol();
    int j = Util.getDefaultPort(str1);
    if (i != j)
    {
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      String str2 = paramURL.getHost();
      localObject = ((StringBuilder)localObject).append(str2);
      str2 = ":";
      localObject = ((StringBuilder)localObject).append(str2);
      int k = paramURL.getPort();
      localObject = ((StringBuilder)localObject).append(k);
    }
    for (Object localObject = ((StringBuilder)localObject).toString(); ; localObject = paramURL.getHost())
      return localObject;
  }

  private boolean isRecoverable(IOException paramIOException, Connection paramConnection)
  {
    PrintStream localPrintStream2 = 1;
    boolean bool1 = false;
    OkHttpClient localOkHttpClient = this.client;
    boolean bool2 = localOkHttpClient.getRetryOnConnectionFailure();
    if (!bool2);
    while (true)
    {
      return bool1;
      bool2 = paramIOException instanceof SSLPeerUnverifiedException;
      if (!bool2)
      {
        bool2 = paramIOException instanceof SSLHandshakeException;
        boolean bool3;
        if (bool2)
        {
          Throwable localThrowable = paramIOException.getCause();
          bool3 = localThrowable instanceof CertificateException;
          if (bool3);
        }
        else
        {
          bool3 = paramIOException instanceof ProtocolException;
          if (!bool3)
          {
            bool3 = paramIOException instanceof SocketTimeoutException;
            PrintStream localPrintStream1;
            if (bool3)
            {
              localPrintStream1 = System.err;
              Object localObject = new java/lang/StringBuilder;
              String str = "Attempting recover after: ";
              ((StringBuilder)localObject).<init>(str);
              str = paramIOException.getMessage();
              localObject = ((StringBuilder)localObject).append(str);
              localObject = ((StringBuilder)localObject).toString();
              localPrintStream1.println((String)localObject);
              localPrintStream1 = localPrintStream2;
            }
            else
            {
              boolean bool4 = paramIOException instanceof InterruptedIOException;
              if (!bool4)
                localPrintStream1 = localPrintStream2;
            }
          }
        }
      }
    }
  }

  private void maybeCache()
    throws IOException
  {
    Object localObject1 = Internal.instance;
    Object localObject4 = this.client;
    InternalCache localInternalCache = ((Internal)localObject1).internalCache((OkHttpClient)localObject4);
    if (localInternalCache == null);
    while (true)
    {
      return;
      localObject1 = this.userResponse;
      localObject4 = this.networkRequest;
      boolean bool1 = CacheStrategy.isCacheable((Response)localObject1, (Request)localObject4);
      if (!bool1)
      {
        Object localObject2 = this.networkRequest;
        localObject2 = ((Request)localObject2).method();
        boolean bool2 = HttpMethod.invalidatesCache((String)localObject2);
        if (bool2)
          try
          {
            Request localRequest = this.networkRequest;
            localInternalCache.remove(localRequest);
          }
          catch (IOException localIOException)
          {
          }
      }
      else
      {
        Object localObject3 = this.userResponse;
        localObject3 = stripBody((Response)localObject3);
        localObject3 = localInternalCache.put((Response)localObject3);
        this.storeRequest = ((CacheRequest)localObject3);
      }
    }
  }

  private Request networkRequest(Request paramRequest)
    throws IOException
  {
    Request.Builder localBuilder = paramRequest.newBuilder();
    Object localObject1 = "Host";
    localObject1 = paramRequest.header((String)localObject1);
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = "Host";
      localObject3 = paramRequest.url();
      localObject3 = hostHeader((URL)localObject3);
      localBuilder.header((String)localObject1, (String)localObject3);
    }
    localObject1 = this.connection;
    if (localObject1 != null)
    {
      localObject1 = this.connection;
      localObject1 = ((Connection)localObject1).getProtocol();
      localObject3 = Protocol.HTTP_1_0;
      if (localObject1 == localObject3);
    }
    else
    {
      localObject1 = "Connection";
      localObject1 = paramRequest.header((String)localObject1);
      if (localObject1 == null)
      {
        localObject1 = "Connection";
        localObject3 = "Keep-Alive";
        localBuilder.header((String)localObject1, (String)localObject3);
      }
    }
    localObject1 = "Accept-Encoding";
    localObject1 = paramRequest.header((String)localObject1);
    if (localObject1 == null)
    {
      boolean bool = true;
      this.transparentGzip = bool;
      localObject2 = "Accept-Encoding";
      localObject3 = "gzip";
      localBuilder.header((String)localObject2, (String)localObject3);
    }
    Object localObject2 = this.client;
    CookieHandler localCookieHandler = ((OkHttpClient)localObject2).getCookieHandler();
    if (localCookieHandler != null)
    {
      localObject2 = localBuilder.build();
      localObject2 = ((Request)localObject2).headers();
      localObject3 = null;
      Map localMap2 = OkHeaders.toMultimap((Headers)localObject2, (String)localObject3);
      localObject2 = paramRequest.uri();
      Map localMap1 = localCookieHandler.get((URI)localObject2, localMap2);
      OkHeaders.addCookies(localBuilder, localMap1);
    }
    localObject2 = "User-Agent";
    localObject2 = paramRequest.header((String)localObject2);
    if (localObject2 == null)
    {
      localObject2 = "User-Agent";
      localObject3 = Version.userAgent();
      localBuilder.header((String)localObject2, (String)localObject3);
    }
    localObject2 = localBuilder.build();
    return localObject2;
  }

  final boolean permitsRequestBody()
  {
    Object localObject = this.userRequest;
    localObject = ((Request)localObject).method();
    boolean bool = HttpMethod.permitsRequestBody((String)localObject);
    return bool;
  }

  private Response readNetworkResponse()
    throws IOException
  {
    Object localObject1 = this.transport;
    ((Transport)localObject1).finishRequest();
    localObject1 = this.transport;
    localObject1 = ((Transport)localObject1).readResponseHeaders();
    Object localObject3 = this.networkRequest;
    localObject1 = ((Response.Builder)localObject1).request((Request)localObject3);
    localObject3 = this.connection;
    localObject3 = ((Connection)localObject3).getHandshake();
    localObject1 = ((Response.Builder)localObject1).handshake((Handshake)localObject3);
    localObject3 = OkHeaders.SENT_MILLIS;
    long l = this.sentRequestMillis;
    Object localObject4 = Long.toString(l);
    localObject1 = ((Response.Builder)localObject1).header((String)localObject3, (String)localObject4);
    localObject3 = OkHeaders.RECEIVED_MILLIS;
    l = System.currentTimeMillis();
    localObject4 = Long.toString(l);
    localObject1 = ((Response.Builder)localObject1).header((String)localObject3, (String)localObject4);
    Response localResponse = ((Response.Builder)localObject1).build();
    boolean bool = this.forWebSocket;
    if (!bool)
    {
      localObject2 = localResponse.newBuilder();
      localObject3 = this.transport;
      localObject3 = ((Transport)localObject3).openResponseBody(localResponse);
      localObject2 = ((Response.Builder)localObject2).body((ResponseBody)localObject3);
      localResponse = ((Response.Builder)localObject2).build();
    }
    Object localObject2 = Internal.instance;
    localObject3 = this.connection;
    localObject4 = localResponse.protocol();
    ((Internal)localObject2).setProtocol((Connection)localObject3, (Protocol)localObject4);
    return localResponse;
  }

  public final void readResponse()
    throws IOException
  {
    long l6 = 4294967295L;
    Object localObject1 = this.userResponse;
    if (localObject1 != null);
    while (true)
    {
      return;
      localObject1 = this.networkRequest;
      Object localObject8;
      if (localObject1 == null)
      {
        localObject1 = this.cacheResponse;
        if (localObject1 == null)
        {
          localObject1 = new java/lang/IllegalStateException;
          localObject8 = "call sendRequest() first!";
          ((IllegalStateException)localObject1).<init>((String)localObject8);
          throw ((Throwable)localObject1);
        }
      }
      localObject1 = this.networkRequest;
      if (localObject1 != null)
      {
        boolean bool1 = this.forWebSocket;
        Object localObject2;
        if (bool1)
        {
          localObject2 = this.transport;
          localObject8 = this.networkRequest;
          ((Transport)localObject2).writeRequestHeaders((Request)localObject8);
        }
        for (Response localResponse = readNetworkResponse(); ; localResponse = ((HttpEngine.NetworkInterceptorChain)localObject4).proceed((Request)localObject9))
        {
          localObject2 = localResponse.headers();
          receiveHeaders((Headers)localObject2);
          localObject2 = this.cacheResponse;
          if (localObject2 == null)
            break label770;
          localObject2 = this.cacheResponse;
          boolean bool2 = validate((Response)localObject2, localResponse);
          if (!bool2)
            break label752;
          Object localObject3 = this.cacheResponse;
          localObject3 = ((Response)localObject3).newBuilder();
          localObject8 = this.userRequest;
          localObject3 = ((Response.Builder)localObject3).request((Request)localObject8);
          localObject8 = this.priorResponse;
          localObject8 = stripBody((Response)localObject8);
          localObject3 = ((Response.Builder)localObject3).priorResponse((Response)localObject8);
          localObject8 = this.cacheResponse;
          localObject8 = ((Response)localObject8).headers();
          Object localObject10 = localResponse.headers();
          localObject8 = combine((Headers)localObject8, (Headers)localObject10);
          localObject3 = ((Response.Builder)localObject3).headers((Headers)localObject8);
          localObject8 = this.cacheResponse;
          localObject8 = stripBody((Response)localObject8);
          localObject3 = ((Response.Builder)localObject3).cacheResponse((Response)localObject8);
          localObject8 = stripBody(localResponse);
          localObject3 = ((Response.Builder)localObject3).networkResponse((Response)localObject8);
          localObject3 = ((Response.Builder)localObject3).build();
          this.userResponse = ((Response)localObject3);
          localObject3 = localResponse.body();
          ((ResponseBody)localObject3).close();
          releaseConnection();
          localObject3 = Internal.instance;
          localObject8 = this.client;
          InternalCache localInternalCache = ((Internal)localObject3).internalCache((OkHttpClient)localObject8);
          localInternalCache.trackConditionalCacheHit();
          localObject3 = this.cacheResponse;
          localObject8 = this.userResponse;
          localObject8 = stripBody((Response)localObject8);
          localInternalCache.update((Response)localObject3, (Response)localObject8);
          localObject3 = this.userResponse;
          localObject3 = unzip((Response)localObject3);
          this.userResponse = ((Response)localObject3);
          break;
          boolean bool3 = this.callerWritesRequestBody;
          if (bool3)
            break label434;
          localObject4 = new com/squareup/okhttp/internal/http/HttpEngine$NetworkInterceptorChain;
          int i = 0;
          localObject10 = this.networkRequest;
          ((HttpEngine.NetworkInterceptorChain)localObject4).<init>(this, i, (Request)localObject10);
          localObject9 = this.networkRequest;
        }
        label434: Object localObject4 = this.bufferedRequestBody;
        if (localObject4 != null)
        {
          localObject4 = this.bufferedRequestBody;
          localObject4 = ((BufferedSink)localObject4).buffer();
          long l2 = ((Buffer)localObject4).size();
          long l5 = 0L;
          boolean bool4 = l2 < l5;
          if (bool4)
          {
            BufferedSink localBufferedSink = this.bufferedRequestBody;
            localBufferedSink.emit();
          }
        }
        long l3 = this.sentRequestMillis;
        boolean bool5 = l3 < l6;
        if (!bool5)
        {
          Request localRequest = this.networkRequest;
          long l4 = OkHeaders.contentLength(localRequest);
          boolean bool6 = l4 < l6;
          if (!bool6)
          {
            Sink localSink = this.requestBodyOut;
            boolean bool7 = localSink instanceof RetryableSink;
            if (bool7)
            {
              localObject5 = this.requestBodyOut;
              localObject5 = (RetryableSink)localObject5;
              long l1 = ((RetryableSink)localObject5).contentLength();
              localObject5 = this.networkRequest;
              localObject5 = ((Request)localObject5).newBuilder();
              localObject9 = "Content-Length";
              String str = Long.toString(l1);
              localObject5 = ((Request.Builder)localObject5).header((String)localObject9, str);
              localObject5 = ((Request.Builder)localObject5).build();
              this.networkRequest = ((Request)localObject5);
            }
          }
          localObject5 = this.transport;
          localObject9 = this.networkRequest;
          ((Transport)localObject5).writeRequestHeaders((Request)localObject9);
        }
        Object localObject5 = this.requestBodyOut;
        if (localObject5 != null)
        {
          localObject5 = this.bufferedRequestBody;
          if (localObject5 == null)
            break label736;
          localObject5 = this.bufferedRequestBody;
          ((BufferedSink)localObject5).close();
        }
        while (true)
        {
          localObject5 = this.requestBodyOut;
          boolean bool8 = localObject5 instanceof RetryableSink;
          if (bool8)
          {
            localObject9 = this.transport;
            localObject6 = this.requestBodyOut;
            localObject6 = (RetryableSink)localObject6;
            ((Transport)localObject9).writeRequestBody((RetryableSink)localObject6);
          }
          localResponse = readNetworkResponse();
          break;
          label736: localObject6 = this.requestBodyOut;
          ((Sink)localObject6).close();
        }
        label752: Object localObject6 = this.cacheResponse;
        localObject6 = ((Response)localObject6).body();
        Util.closeQuietly((Closeable)localObject6);
        label770: localObject6 = localResponse.newBuilder();
        Object localObject9 = this.userRequest;
        localObject6 = ((Response.Builder)localObject6).request((Request)localObject9);
        localObject9 = this.priorResponse;
        localObject9 = stripBody((Response)localObject9);
        localObject6 = ((Response.Builder)localObject6).priorResponse((Response)localObject9);
        localObject9 = this.cacheResponse;
        localObject9 = stripBody((Response)localObject9);
        localObject6 = ((Response.Builder)localObject6).cacheResponse((Response)localObject9);
        localObject9 = stripBody(localResponse);
        localObject6 = ((Response.Builder)localObject6).networkResponse((Response)localObject9);
        localObject6 = ((Response.Builder)localObject6).build();
        this.userResponse = ((Response)localObject6);
        localObject6 = this.userResponse;
        boolean bool9 = hasBody((Response)localObject6);
        if (bool9)
        {
          maybeCache();
          Object localObject7 = this.storeRequest;
          localObject9 = this.userResponse;
          localObject7 = cacheWritingResponse((CacheRequest)localObject7, (Response)localObject9);
          localObject7 = unzip((Response)localObject7);
          this.userResponse = ((Response)localObject7);
        }
      }
    }
  }

  public final void receiveHeaders(Headers paramHeaders)
    throws IOException
  {
    Object localObject1 = this.client;
    CookieHandler localCookieHandler = ((OkHttpClient)localObject1).getCookieHandler();
    if (localCookieHandler != null)
    {
      localObject1 = this.userRequest;
      localObject1 = ((Request)localObject1).uri();
      Object localObject2 = null;
      localObject2 = OkHeaders.toMultimap(paramHeaders, (String)localObject2);
      localCookieHandler.put((URI)localObject1, (Map)localObject2);
    }
  }

  public final HttpEngine recover(IOException paramIOException)
  {
    Object localObject = this.requestBodyOut;
    localObject = recover(paramIOException, (Sink)localObject);
    return localObject;
  }

  private HttpEngine recover(IOException paramIOException, Sink paramSink)
  {
    Object localObject1 = this.routeSelector;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = this.connection;
      if (localObject1 != null)
      {
        localObject1 = this.routeSelector;
        localObject3 = this.connection;
        ((RouteSelector)localObject1).connectFailed((Connection)localObject3, paramIOException);
      }
    }
    int i;
    HttpEngine localHttpEngine;
    if (paramSink != null)
    {
      boolean bool1 = paramSink instanceof RetryableSink;
      if (!bool1);
    }
    else
    {
      i = 1;
      Object localObject2 = this.routeSelector;
      if (localObject2 == null)
      {
        localObject2 = this.connection;
        if (localObject2 == null);
      }
      else
      {
        localObject2 = this.routeSelector;
        if (localObject2 != null)
        {
          localObject2 = this.routeSelector;
          boolean bool2 = ((RouteSelector)localObject2).hasNext();
          if (!bool2);
        }
        else
        {
          Connection localConnection1 = this.connection;
          boolean bool3 = isRecoverable(paramIOException, localConnection1);
          if ((bool3) && (i != 0))
            break label125;
        }
      }
      localHttpEngine = null;
    }
    while (true)
    {
      return localHttpEngine;
      i = 0;
      break;
      label125: Connection localConnection2 = close();
      localHttpEngine = new com/squareup/okhttp/internal/http/HttpEngine;
      localObject3 = this.client;
      Request localRequest = this.userRequest;
      boolean bool4 = this.bufferRequestBody;
      boolean bool5 = this.callerWritesRequestBody;
      boolean bool6 = this.forWebSocket;
      RouteSelector localRouteSelector = this.routeSelector;
      Object localObject4 = paramSink;
      localObject4 = (RetryableSink)localObject4;
      Response localResponse = this.priorResponse;
      localHttpEngine.<init>((OkHttpClient)localObject3, localRequest, bool4, bool5, bool6, localConnection2, localRouteSelector, (RetryableSink)localObject4, localResponse);
    }
  }

  public final void releaseConnection()
    throws IOException
  {
    Object localObject = this.transport;
    if (localObject != null)
    {
      localObject = this.connection;
      if (localObject != null)
      {
        localObject = this.transport;
        ((Transport)localObject).releaseConnectionOnIdle();
      }
    }
    localObject = null;
    this.connection = ((Connection)localObject);
  }

  public final boolean sameConnection(URL paramURL)
  {
    Object localObject = this.userRequest;
    URL localURL = ((Request)localObject).url();
    localObject = localURL.getHost();
    String str2 = paramURL.getHost();
    boolean bool1 = ((String)localObject).equals(str2);
    if (bool1)
    {
      int i = Util.getEffectivePort(localURL);
      int j = Util.getEffectivePort(paramURL);
      if (i == j)
      {
        String str1 = localURL.getProtocol();
        String str3 = paramURL.getProtocol();
        bool2 = str1.equals(str3);
        if (!bool2);
      }
    }
    for (boolean bool2 = true; ; bool2 = false)
      return bool2;
  }

  public final void sendRequest()
    throws IOException
  {
    Object localObject2 = null;
    Object localObject4 = this.cacheStrategy;
    if (localObject4 != null);
    Object localObject7;
    while (true)
    {
      return;
      localObject4 = this.transport;
      if (localObject4 != null)
      {
        localObject2 = new java/lang/IllegalStateException;
        ((IllegalStateException)localObject2).<init>();
        throw ((Throwable)localObject2);
      }
      localObject4 = this.userRequest;
      Request localRequest1 = networkRequest((Request)localObject4);
      localObject4 = Internal.instance;
      localObject7 = this.client;
      InternalCache localInternalCache = ((Internal)localObject4).internalCache((OkHttpClient)localObject7);
      if (localInternalCache != null);
      long l1;
      IllegalStateException localIllegalStateException;
      for (Object localObject1 = localInternalCache.get(localRequest1); ; localObject1 = localIllegalStateException)
      {
        long l2 = System.currentTimeMillis();
        localObject4 = new com/squareup/okhttp/internal/http/CacheStrategy$Factory;
        ((CacheStrategy.Factory)localObject4).<init>(l2, localRequest1, (Response)localObject1);
        localObject4 = ((CacheStrategy.Factory)localObject4).get();
        this.cacheStrategy = ((CacheStrategy)localObject4);
        localObject4 = this.cacheStrategy;
        localObject4 = ((CacheStrategy)localObject4).networkRequest;
        this.networkRequest = ((Request)localObject4);
        localObject4 = this.cacheStrategy;
        localObject4 = ((CacheStrategy)localObject4).cacheResponse;
        this.cacheResponse = ((Response)localObject4);
        if (localInternalCache != null)
        {
          localObject4 = this.cacheStrategy;
          localInternalCache.trackResponse((CacheStrategy)localObject4);
        }
        if (localObject1 != null)
        {
          localObject4 = this.cacheResponse;
          if (localObject4 == null)
          {
            localObject4 = ((Response)localObject1).body();
            Util.closeQuietly((Closeable)localObject4);
          }
        }
        localObject4 = this.networkRequest;
        if (localObject4 == null)
          break label490;
        localObject2 = this.connection;
        if (localObject2 == null)
        {
          localObject2 = this.networkRequest;
          connect((Request)localObject2);
        }
        localObject2 = Internal.instance;
        localObject4 = this.connection;
        localObject2 = ((Internal)localObject2).newTransport((Connection)localObject4, this);
        this.transport = ((Transport)localObject2);
        boolean bool1 = this.callerWritesRequestBody;
        if (!bool1)
          break;
        bool1 = permitsRequestBody();
        if (!bool1)
          break;
        Sink localSink = this.requestBodyOut;
        if (localSink != null)
          break;
        l1 = OkHeaders.contentLength(localRequest1);
        boolean bool2 = this.bufferRequestBody;
        if (!bool2)
          break label436;
        long l3 = 2147483647L;
        bool2 = l1 < l3;
        if (!bool2)
          break label355;
        localIllegalStateException = new java/lang/IllegalStateException;
        String str = "Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.";
        localIllegalStateException.<init>(str);
        throw localIllegalStateException;
      }
      label355: long l4 = 4294967295L;
      boolean bool3 = l1 < l4;
      if (bool3)
      {
        localObject3 = this.transport;
        Request localRequest2 = this.networkRequest;
        ((Transport)localObject3).writeRequestHeaders(localRequest2);
        localObject3 = new com/squareup/okhttp/internal/http/RetryableSink;
        int i = (int)l1;
        ((RetryableSink)localObject3).<init>(i);
        this.requestBodyOut = ((Sink)localObject3);
      }
      else
      {
        localObject3 = new com/squareup/okhttp/internal/http/RetryableSink;
        ((RetryableSink)localObject3).<init>();
        this.requestBodyOut = ((Sink)localObject3);
        continue;
        label436: localObject3 = this.transport;
        localObject5 = this.networkRequest;
        ((Transport)localObject3).writeRequestHeaders((Request)localObject5);
        localObject3 = this.transport;
        localObject5 = this.networkRequest;
        localObject3 = ((Transport)localObject3).createRequestBody((Request)localObject5, l1);
        this.requestBodyOut = ((Sink)localObject3);
      }
    }
    label490: Object localObject5 = this.connection;
    if (localObject5 != null)
    {
      localObject5 = Internal.instance;
      localObject7 = this.client;
      localObject7 = ((OkHttpClient)localObject7).getConnectionPool();
      Connection localConnection = this.connection;
      ((Internal)localObject5).recycle((ConnectionPool)localObject7, localConnection);
      this.connection = ((Connection)localObject3);
    }
    Object localObject3 = this.cacheResponse;
    if (localObject3 != null)
    {
      localObject3 = this.cacheResponse;
      localObject3 = ((Response)localObject3).newBuilder();
      localObject5 = this.userRequest;
      localObject3 = ((Response.Builder)localObject3).request((Request)localObject5);
      localObject5 = this.priorResponse;
      localObject5 = stripBody((Response)localObject5);
      localObject3 = ((Response.Builder)localObject3).priorResponse((Response)localObject5);
      localObject5 = this.cacheResponse;
      localObject5 = stripBody((Response)localObject5);
      localObject3 = ((Response.Builder)localObject3).cacheResponse((Response)localObject5);
      localObject3 = ((Response.Builder)localObject3).build();
    }
    for (this.userResponse = ((Response)localObject3); ; this.userResponse = ((Response)localObject3))
    {
      localObject3 = this.userResponse;
      localObject3 = unzip((Response)localObject3);
      this.userResponse = ((Response)localObject3);
      break;
      localObject3 = new com/squareup/okhttp/Response$Builder;
      ((Response.Builder)localObject3).<init>();
      localObject5 = this.userRequest;
      localObject3 = ((Response.Builder)localObject3).request((Request)localObject5);
      localObject5 = this.priorResponse;
      localObject5 = stripBody((Response)localObject5);
      localObject3 = ((Response.Builder)localObject3).priorResponse((Response)localObject5);
      localObject5 = Protocol.HTTP_1_1;
      localObject3 = ((Response.Builder)localObject3).protocol((Protocol)localObject5);
      int j = 504;
      localObject3 = ((Response.Builder)localObject3).code(j);
      Object localObject6 = "Unsatisfiable Request (only-if-cached)";
      localObject3 = ((Response.Builder)localObject3).message((String)localObject6);
      localObject6 = EMPTY_BODY;
      localObject3 = ((Response.Builder)localObject3).body((ResponseBody)localObject6);
      localObject3 = ((Response.Builder)localObject3).build();
    }
  }

  private static Response stripBody(Response paramResponse)
  {
    if (paramResponse != null)
    {
      Object localObject = paramResponse.body();
      if (localObject != null)
      {
        localObject = paramResponse.newBuilder();
        ResponseBody localResponseBody = null;
        localObject = ((Response.Builder)localObject).body(localResponseBody);
        paramResponse = ((Response.Builder)localObject).build();
      }
    }
    return paramResponse;
  }

  private Response unzip(Response paramResponse)
    throws IOException
  {
    boolean bool1 = this.transparentGzip;
    Object localObject2;
    Object localObject3;
    if (bool1)
    {
      String str = "gzip";
      localObject2 = this.userResponse;
      localObject3 = "Content-Encoding";
      localObject2 = ((Response)localObject2).header((String)localObject3);
      boolean bool2 = str.equalsIgnoreCase((String)localObject2);
      if (bool2)
        break label51;
    }
    while (true)
    {
      return paramResponse;
      label51: Object localObject1 = paramResponse.body();
      if (localObject1 != null)
      {
        GzipSource localGzipSource = new okio/GzipSource;
        localObject1 = paramResponse.body();
        localObject1 = ((ResponseBody)localObject1).source();
        localGzipSource.<init>((Source)localObject1);
        localObject1 = paramResponse.headers();
        localObject1 = ((Headers)localObject1).newBuilder();
        localObject2 = "Content-Encoding";
        localObject1 = ((Headers.Builder)localObject1).removeAll((String)localObject2);
        localObject2 = "Content-Length";
        localObject1 = ((Headers.Builder)localObject1).removeAll((String)localObject2);
        Headers localHeaders = ((Headers.Builder)localObject1).build();
        localObject1 = paramResponse.newBuilder();
        localObject1 = ((Response.Builder)localObject1).headers(localHeaders);
        localObject2 = new com/squareup/okhttp/internal/http/RealResponseBody;
        localObject3 = Okio.buffer(localGzipSource);
        ((RealResponseBody)localObject2).<init>(localHeaders, (BufferedSource)localObject3);
        localObject1 = ((Response.Builder)localObject1).body((ResponseBody)localObject2);
        paramResponse = ((Response.Builder)localObject1).build();
      }
    }
  }

  private static boolean validate(Response paramResponse1, Response paramResponse2)
  {
    boolean bool1 = true;
    int i = paramResponse2.code();
    int j = 304;
    if (i == j);
    while (true)
    {
      return bool1;
      Headers localHeaders = paramResponse1.headers();
      String str = "Last-Modified";
      Date localDate1 = localHeaders.getDate(str);
      if (localDate1 != null)
      {
        localHeaders = paramResponse2.headers();
        str = "Last-Modified";
        Date localDate2 = localHeaders.getDate(str);
        if (localDate2 != null)
        {
          long l1 = localDate2.getTime();
          long l2 = localDate1.getTime();
          boolean bool2 = l1 < l2;
          if (bool2)
            continue;
        }
      }
      else
      {
        bool1 = false;
      }
    }
  }

  public final void writingRequestHeaders()
  {
    long l1 = this.sentRequestMillis;
    long l3 = 4294967295L;
    boolean bool = l1 < l3;
    if (bool)
    {
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      localIllegalStateException.<init>();
      throw localIllegalStateException;
    }
    long l2 = System.currentTimeMillis();
    this.sentRequestMillis = l2;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     com.squareup.okhttp.internal.http.HttpEngine
 * JD-Core Version:    0.6.2
 */
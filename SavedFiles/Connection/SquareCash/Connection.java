package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpConnection;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpTransport;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.SpdyTransport;
import com.squareup.okhttp.internal.http.Transport;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import com.squareup.okhttp.internal.spdy.SpdyConnection.Builder;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.URL;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Source;

public final class Connection
{
  private boolean connected;
  private Handshake handshake;
  private HttpConnection httpConnection;
  private long idleStartTimeNs;
  private Object owner;
  private final ConnectionPool pool;
  private Protocol protocol;
  private int recycleCount;
  private final Route route;
  private Socket socket;
  private SpdyConnection spdyConnection;

  public Connection(ConnectionPool paramConnectionPool, Route paramRoute)
  {
    boolean bool = false;
    this.connected = bool;
    Protocol localProtocol = Protocol.HTTP_1_1;
    this.protocol = localProtocol;
    this.pool = paramConnectionPool;
    this.route = paramRoute;
  }

  boolean clearOwner()
  {
    synchronized (this.pool)
    {
      Object localObject1 = this.owner;
      if (localObject1 == null)
      {
        boolean bool = false;
        return bool;
      }
      Object localObject2 = null;
      this.owner = localObject2;
      int i = 1;
    }
  }

  void closeIfOwnedBy(Object paramObject)
    throws IOException
  {
    boolean bool = isSpdy();
    Object localObject1;
    if (bool)
    {
      localObject1 = new java/lang/IllegalStateException;
      ((IllegalStateException)localObject1).<init>();
      throw ((Throwable)localObject1);
    }
    synchronized (this.pool)
    {
      localObject1 = this.owner;
      if (localObject1 != paramObject)
        return;
      localObject1 = null;
      this.owner = localObject1;
      localObject1 = this.socket;
      ((Socket)localObject1).close();
    }
  }

  void connect(int paramInt1, int paramInt2, int paramInt3, Request paramRequest)
    throws IOException
  {
    boolean bool1 = this.connected;
    if (bool1)
    {
      localObject1 = new java/lang/IllegalStateException;
      localObject3 = "already connected";
      ((IllegalStateException)localObject1).<init>((String)localObject3);
      throw ((Throwable)localObject1);
    }
    Object localObject1 = this.route;
    localObject1 = ((Route)localObject1).proxy;
    localObject1 = ((Proxy)localObject1).type();
    Object localObject3 = Proxy.Type.DIRECT;
    Object localObject4;
    if (localObject1 != localObject3)
    {
      localObject1 = this.route;
      localObject1 = ((Route)localObject1).proxy;
      localObject1 = ((Proxy)localObject1).type();
      localObject3 = Proxy.Type.HTTP;
      if (localObject1 != localObject3);
    }
    else
    {
      localObject1 = this.route;
      localObject1 = ((Route)localObject1).address;
      localObject1 = ((Address)localObject1).socketFactory;
      localObject1 = ((SocketFactory)localObject1).createSocket();
      this.socket = ((Socket)localObject1);
      localObject1 = this.socket;
      ((Socket)localObject1).setSoTimeout(paramInt2);
      localObject1 = Platform.get();
      localObject3 = this.socket;
      localObject4 = this.route;
      localObject4 = ((Route)localObject4).inetSocketAddress;
      ((Platform)localObject1).connectSocket((Socket)localObject3, (InetSocketAddress)localObject4, paramInt1);
      localObject1 = this.route;
      localObject1 = ((Route)localObject1).address;
      localObject1 = ((Address)localObject1).sslSocketFactory;
      if (localObject1 == null)
        break label251;
      upgradeToTls(paramRequest, paramInt2, paramInt3);
    }
    while (true)
    {
      boolean bool2 = true;
      this.connected = bool2;
      return;
      Object localObject2 = new java/net/Socket;
      localObject3 = this.route;
      localObject3 = ((Route)localObject3).proxy;
      ((Socket)localObject2).<init>((Proxy)localObject3);
      this.socket = ((Socket)localObject2);
      break;
      label251: localObject2 = new com/squareup/okhttp/internal/http/HttpConnection;
      localObject3 = this.pool;
      localObject4 = this.socket;
      ((HttpConnection)localObject2).<init>((ConnectionPool)localObject3, this, (Socket)localObject4);
      this.httpConnection = ((HttpConnection)localObject2);
    }
  }

  void connectAndSetOwner(OkHttpClient paramOkHttpClient, Object paramObject, Request paramRequest)
    throws IOException
  {
    setOwner(paramObject);
    boolean bool1 = isConnected();
    if (!bool1)
    {
      Request localRequest = tunnelRequest(paramRequest);
      int i = paramOkHttpClient.getConnectTimeout();
      int k = paramOkHttpClient.getReadTimeout();
      int n = paramOkHttpClient.getWriteTimeout();
      connect(i, k, n, localRequest);
      boolean bool2 = isSpdy();
      if (bool2)
      {
        localObject = paramOkHttpClient.getConnectionPool();
        ((ConnectionPool)localObject).share(this);
      }
      Object localObject = paramOkHttpClient.routeDatabase();
      Route localRoute = getRoute();
      ((RouteDatabase)localObject).connected(localRoute);
    }
    int j = paramOkHttpClient.getReadTimeout();
    int m = paramOkHttpClient.getWriteTimeout();
    setTimeouts(j, m);
  }

  public Handshake getHandshake()
  {
    Handshake localHandshake = this.handshake;
    return localHandshake;
  }

  long getIdleStartTimeNs()
  {
    SpdyConnection localSpdyConnection1 = this.spdyConnection;
    if (localSpdyConnection1 == null);
    SpdyConnection localSpdyConnection2;
    long l2;
    for (long l1 = this.idleStartTimeNs; ; l2 = localSpdyConnection2.getIdleStartTimeNs())
    {
      return l1;
      localSpdyConnection2 = this.spdyConnection;
    }
  }

  Object getOwner()
  {
    synchronized (this.pool)
    {
      Object localObject1 = this.owner;
      return localObject1;
    }
  }

  public Protocol getProtocol()
  {
    Protocol localProtocol = this.protocol;
    return localProtocol;
  }

  public Route getRoute()
  {
    Route localRoute = this.route;
    return localRoute;
  }

  public Socket getSocket()
  {
    Socket localSocket = this.socket;
    return localSocket;
  }

  void incrementRecycleCount()
  {
    int i = this.recycleCount;
    i += 1;
    this.recycleCount = i;
  }

  boolean isAlive()
  {
    Socket localSocket1 = this.socket;
    boolean bool1 = localSocket1.isClosed();
    if (!bool1)
    {
      Socket localSocket2 = this.socket;
      boolean bool2 = localSocket2.isInputShutdown();
      if (!bool2)
      {
        Socket localSocket3 = this.socket;
        bool3 = localSocket3.isOutputShutdown();
        if (bool3);
      }
    }
    for (boolean bool3 = true; ; bool3 = false)
      return bool3;
  }

  boolean isConnected()
  {
    boolean bool = this.connected;
    return bool;
  }

  boolean isIdle()
  {
    SpdyConnection localSpdyConnection = this.spdyConnection;
    if (localSpdyConnection != null)
    {
      localSpdyConnection = this.spdyConnection;
      bool = localSpdyConnection.isIdle();
      if (!bool)
        break label28;
    }
    label28: for (boolean bool = true; ; bool = false)
      return bool;
  }

  boolean isReadable()
  {
    HttpConnection localHttpConnection = this.httpConnection;
    if (localHttpConnection != null)
      localHttpConnection = this.httpConnection;
    for (boolean bool = localHttpConnection.isReadable(); ; bool = true)
      return bool;
  }

  boolean isSpdy()
  {
    SpdyConnection localSpdyConnection = this.spdyConnection;
    if (localSpdyConnection != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private void makeTunnel(Request paramRequest, int paramInt1, int paramInt2)
    throws IOException
  {
    HttpConnection localHttpConnection = new com/squareup/okhttp/internal/http/HttpConnection;
    Object localObject1 = this.pool;
    Object localObject3 = this.socket;
    localHttpConnection.<init>((ConnectionPool)localObject1, this, (Socket)localObject3);
    localHttpConnection.setTimeouts(paramInt1, paramInt2);
    URL localURL = paramRequest.url();
    localObject1 = new java/lang/StringBuilder;
    ((StringBuilder)localObject1).<init>();
    localObject3 = "CONNECT ";
    localObject1 = ((StringBuilder)localObject1).append((String)localObject3);
    localObject3 = localURL.getHost();
    localObject1 = ((StringBuilder)localObject1).append((String)localObject3);
    localObject3 = ":";
    localObject1 = ((StringBuilder)localObject1).append((String)localObject3);
    int j = localURL.getPort();
    localObject1 = ((StringBuilder)localObject1).append(j);
    String str2 = " HTTP/1.1";
    localObject1 = ((StringBuilder)localObject1).append(str2);
    String str1 = ((StringBuilder)localObject1).toString();
    do
    {
      localObject1 = paramRequest.headers();
      localHttpConnection.writeRequest((Headers)localObject1, str1);
      localHttpConnection.flush();
      localObject1 = localHttpConnection.readResponse();
      localObject1 = ((Response.Builder)localObject1).request(paramRequest);
      Response localResponse = ((Response.Builder)localObject1).build();
      long l1 = OkHeaders.contentLength(localResponse);
      long l2 = 4294967295L;
      boolean bool1 = l1 < l2;
      if (!bool1)
        l1 = 0L;
      Source localSource = localHttpConnection.newFixedLengthSource(l1);
      int i = 2147483647;
      Object localObject4 = TimeUnit.MILLISECONDS;
      Util.skipAll(localSource, i, (TimeUnit)localObject4);
      localSource.close();
      i = localResponse.code();
      switch (i)
      {
      default:
        IOException localIOException = new java/io/IOException;
        localObject4 = new java/lang/StringBuilder;
        ((StringBuilder)localObject4).<init>();
        String str3 = "Unexpected response code for CONNECT: ";
        localObject4 = ((StringBuilder)localObject4).append(str3);
        int k = localResponse.code();
        localObject4 = ((StringBuilder)localObject4).append(k);
        localObject4 = ((StringBuilder)localObject4).toString();
        localIOException.<init>((String)localObject4);
        throw localIOException;
      case 200:
        long l3 = localHttpConnection.bufferSize();
        long l4 = 0L;
        boolean bool2 = l3 < l4;
        if (!bool2)
          break;
        localObject2 = new java/io/IOException;
        localObject5 = "TLS tunnel buffered too many bytes!";
        ((IOException)localObject2).<init>((String)localObject5);
        throw ((Throwable)localObject2);
      case 407:
        localObject2 = this.route;
        localObject2 = ((Route)localObject2).address;
        localObject2 = ((Address)localObject2).authenticator;
        localObject5 = this.route;
        localObject5 = ((Route)localObject5).proxy;
        paramRequest = OkHeaders.processAuthHeader((Authenticator)localObject2, localResponse, (Proxy)localObject5);
      }
    }
    while (paramRequest != null);
    Object localObject2 = new java/io/IOException;
    Object localObject5 = "Failed to authenticate with proxy";
    ((IOException)localObject2).<init>((String)localObject5);
    throw ((Throwable)localObject2);
  }

  Transport newTransport(HttpEngine paramHttpEngine)
    throws IOException
  {
    Object localObject1 = this.spdyConnection;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = new com/squareup/okhttp/internal/http/SpdyTransport;
      localObject2 = this.spdyConnection;
      ((SpdyTransport)localObject1).<init>(paramHttpEngine, (SpdyConnection)localObject2);
    }
    while (true)
    {
      return localObject1;
      localObject1 = new com/squareup/okhttp/internal/http/HttpTransport;
      localObject2 = this.httpConnection;
      ((HttpTransport)localObject1).<init>(paramHttpEngine, (HttpConnection)localObject2);
    }
  }

  int recycleCount()
  {
    int i = this.recycleCount;
    return i;
  }

  void resetIdleStartTime()
  {
    Object localObject = this.spdyConnection;
    if (localObject != null)
    {
      localObject = new java/lang/IllegalStateException;
      String str = "spdyConnection != null";
      ((IllegalStateException)localObject).<init>(str);
      throw ((Throwable)localObject);
    }
    long l = System.nanoTime();
    this.idleStartTimeNs = l;
  }

  void setOwner(Object paramObject)
  {
    boolean bool = isSpdy();
    if (bool);
    while (true)
    {
      return;
      synchronized (this.pool)
      {
        Object localObject1 = this.owner;
        if (localObject1 != null)
        {
          localObject1 = new java/lang/IllegalStateException;
          String str = "Connection already has an owner!";
          ((IllegalStateException)localObject1).<init>(str);
          throw ((Throwable)localObject1);
        }
      }
      this.owner = paramObject;
    }
  }

  void setProtocol(Protocol paramProtocol)
  {
    if (paramProtocol == null)
    {
      IllegalArgumentException localIllegalArgumentException = new java/lang/IllegalArgumentException;
      String str = "protocol == null";
      localIllegalArgumentException.<init>(str);
      throw localIllegalArgumentException;
    }
    this.protocol = paramProtocol;
  }

  void setTimeouts(int paramInt1, int paramInt2)
    throws IOException
  {
    boolean bool = this.connected;
    if (!bool)
    {
      localObject = new java/lang/IllegalStateException;
      String str = "setTimeouts - not connected";
      ((IllegalStateException)localObject).<init>(str);
      throw ((Throwable)localObject);
    }
    Object localObject = this.httpConnection;
    if (localObject != null)
    {
      localObject = this.socket;
      ((Socket)localObject).setSoTimeout(paramInt1);
      localObject = this.httpConnection;
      ((HttpConnection)localObject).setTimeouts(paramInt1, paramInt2);
    }
  }

  public String toString()
  {
    Object localObject1 = new java/lang/StringBuilder;
    ((StringBuilder)localObject1).<init>();
    Object localObject2 = "Connection{";
    localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
    localObject2 = this.route;
    localObject2 = ((Route)localObject2).address;
    localObject2 = ((Address)localObject2).uriHost;
    localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
    localObject2 = ":";
    localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
    localObject2 = this.route;
    localObject2 = ((Route)localObject2).address;
    int i = ((Address)localObject2).uriPort;
    localObject1 = ((StringBuilder)localObject1).append(i);
    Object localObject3 = ", proxy=";
    localObject1 = ((StringBuilder)localObject1).append((String)localObject3);
    localObject3 = this.route;
    localObject3 = ((Route)localObject3).proxy;
    localObject1 = ((StringBuilder)localObject1).append(localObject3);
    localObject3 = " hostAddress=";
    localObject1 = ((StringBuilder)localObject1).append((String)localObject3);
    localObject3 = this.route;
    localObject3 = ((Route)localObject3).inetSocketAddress;
    localObject3 = ((InetSocketAddress)localObject3).getAddress();
    localObject3 = ((InetAddress)localObject3).getHostAddress();
    localObject1 = ((StringBuilder)localObject1).append((String)localObject3);
    localObject3 = " cipherSuite=";
    localObject3 = ((StringBuilder)localObject1).append((String)localObject3);
    localObject1 = this.handshake;
    if (localObject1 != null)
      localObject1 = this.handshake;
    for (localObject1 = ((Handshake)localObject1).cipherSuite(); ; localObject1 = "none")
    {
      localObject1 = ((StringBuilder)localObject3).append((String)localObject1);
      localObject3 = " protocol=";
      localObject1 = ((StringBuilder)localObject1).append((String)localObject3);
      localObject3 = this.protocol;
      localObject1 = ((StringBuilder)localObject1).append(localObject3);
      char c = '}';
      localObject1 = ((StringBuilder)localObject1).append(c);
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
  }

  private Request tunnelRequest(Request paramRequest)
    throws IOException
  {
    Route localRoute = this.route;
    boolean bool = localRoute.requiresTunnel();
    if (!bool)
    {
      localObject1 = null;
      return localObject1;
    }
    Object localObject1 = paramRequest.url();
    String str2 = ((URL)localObject1).getHost();
    localObject1 = paramRequest.url();
    int i = Util.getEffectivePort((URL)localObject1);
    localObject1 = "https";
    int j = Util.getDefaultPort((String)localObject1);
    if (i == j);
    Object localObject2;
    for (String str1 = str2; ; str1 = ((StringBuilder)localObject2).toString())
    {
      localObject2 = new com/squareup/okhttp/Request$Builder;
      ((Request.Builder)localObject2).<init>();
      Object localObject3 = new java/net/URL;
      String str5 = "https";
      String str6 = "/";
      ((URL)localObject3).<init>(str5, str2, i, str6);
      localObject2 = ((Request.Builder)localObject2).url((URL)localObject3);
      localObject3 = "Host";
      localObject2 = ((Request.Builder)localObject2).header((String)localObject3, str1);
      localObject3 = "Proxy-Connection";
      str5 = "Keep-Alive";
      Request.Builder localBuilder = ((Request.Builder)localObject2).header((String)localObject3, str5);
      localObject2 = "User-Agent";
      String str4 = paramRequest.header((String)localObject2);
      if (str4 != null)
      {
        localObject2 = "User-Agent";
        localBuilder.header((String)localObject2, str4);
      }
      localObject2 = "Proxy-Authorization";
      String str3 = paramRequest.header((String)localObject2);
      if (str3 != null)
      {
        localObject2 = "Proxy-Authorization";
        localBuilder.header((String)localObject2, str3);
      }
      localObject2 = localBuilder.build();
      break;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject2 = ((StringBuilder)localObject2).append(str2);
      localObject3 = ":";
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
      localObject2 = ((StringBuilder)localObject2).append(i);
    }
  }

  private void upgradeToTls(Request paramRequest, int paramInt1, int paramInt2)
    throws IOException
  {
    boolean bool3 = true;
    int j = 0;
    Platform localPlatform = Platform.get();
    if (paramRequest != null)
      makeTunnel(paramRequest, paramInt1, paramInt2);
    Object localObject2 = this.route;
    localObject2 = ((Route)localObject2).address;
    localObject2 = ((Address)localObject2).sslSocketFactory;
    Object localObject7 = this.socket;
    Object localObject8 = this.route;
    localObject8 = ((Route)localObject8).address;
    localObject8 = ((Address)localObject8).uriHost;
    Object localObject9 = this.route;
    localObject9 = ((Route)localObject9).address;
    int i = ((Address)localObject9).uriPort;
    localObject2 = ((SSLSocketFactory)localObject2).createSocket((Socket)localObject7, (String)localObject8, i, bool3);
    this.socket = ((Socket)localObject2);
    Object localObject1 = this.socket;
    localObject1 = (SSLSocket)localObject1;
    localObject2 = this.route;
    localObject2 = ((Route)localObject2).connectionSpec;
    localObject7 = this.route;
    ((ConnectionSpec)localObject2).apply((SSLSocket)localObject1, (Route)localObject7);
    try
    {
      ((SSLSocket)localObject1).startHandshake();
      localObject2 = this.route;
      localObject2 = ((Route)localObject2).connectionSpec;
      boolean bool1 = ((ConnectionSpec)localObject2).supportsTlsExtensions();
      if (bool1)
      {
        String str = localPlatform.getSelectedProtocol((SSLSocket)localObject1);
        if (str != null)
        {
          localObject3 = Protocol.get(str);
          this.protocol = ((Protocol)localObject3);
        }
      }
      localPlatform.afterHandshake((SSLSocket)localObject1);
      Object localObject3 = ((SSLSocket)localObject1).getSession();
      localObject3 = Handshake.get((SSLSession)localObject3);
      this.handshake = ((Handshake)localObject3);
      localObject3 = this.route;
      localObject3 = ((Route)localObject3).address;
      localObject3 = ((Address)localObject3).hostnameVerifier;
      localObject7 = this.route;
      localObject7 = ((Route)localObject7).address;
      localObject7 = ((Address)localObject7).uriHost;
      localObject8 = ((SSLSocket)localObject1).getSession();
      boolean bool2 = ((HostnameVerifier)localObject3).verify((String)localObject7, (SSLSession)localObject8);
      if (!bool2)
      {
        Object localObject4 = ((SSLSocket)localObject1).getSession();
        localObject4 = ((SSLSession)localObject4).getPeerCertificates();
        X509Certificate localX509Certificate = localObject4[j];
        localX509Certificate = (X509Certificate)localX509Certificate;
        localObject4 = new javax/net/ssl/SSLPeerUnverifiedException;
        localObject7 = new java/lang/StringBuilder;
        ((StringBuilder)localObject7).<init>();
        localObject8 = "Hostname ";
        localObject7 = ((StringBuilder)localObject7).append((String)localObject8);
        localObject8 = this.route;
        localObject8 = ((Route)localObject8).address;
        localObject8 = ((Address)localObject8).uriHost;
        localObject7 = ((StringBuilder)localObject7).append((String)localObject8);
        localObject8 = " not verified:";
        localObject7 = ((StringBuilder)localObject7).append((String)localObject8);
        localObject8 = "\n    certificate: ";
        localObject7 = ((StringBuilder)localObject7).append((String)localObject8);
        localObject8 = CertificatePinner.pin(localX509Certificate);
        localObject7 = ((StringBuilder)localObject7).append((String)localObject8);
        localObject8 = "\n    DN: ";
        localObject7 = ((StringBuilder)localObject7).append((String)localObject8);
        localObject8 = localX509Certificate.getSubjectDN();
        localObject8 = ((Principal)localObject8).getName();
        localObject7 = ((StringBuilder)localObject7).append((String)localObject8);
        localObject8 = "\n    subjectAltNames: ";
        localObject7 = ((StringBuilder)localObject7).append((String)localObject8);
        localObject8 = OkHostnameVerifier.allSubjectAltNames(localX509Certificate);
        localObject7 = ((StringBuilder)localObject7).append(localObject8);
        localObject7 = ((StringBuilder)localObject7).toString();
        ((SSLPeerUnverifiedException)localObject4).<init>((String)localObject7);
        throw ((Throwable)localObject4);
      }
    }
    finally
    {
      localPlatform.afterHandshake((SSLSocket)localObject1);
    }
    Object localObject6 = this.route;
    localObject6 = ((Route)localObject6).address;
    localObject6 = ((Address)localObject6).certificatePinner;
    localObject7 = this.route;
    localObject7 = ((Route)localObject7).address;
    localObject7 = ((Address)localObject7).uriHost;
    localObject8 = this.handshake;
    localObject8 = ((Handshake)localObject8).peerCertificates();
    ((CertificatePinner)localObject6).check((String)localObject7, (List)localObject8);
    localObject6 = this.protocol;
    localObject7 = Protocol.SPDY_3;
    if (localObject6 != localObject7)
    {
      localObject6 = this.protocol;
      localObject7 = Protocol.HTTP_2;
      if (localObject6 != localObject7);
    }
    else
    {
      ((SSLSocket)localObject1).setSoTimeout(j);
      localObject6 = new com/squareup/okhttp/internal/spdy/SpdyConnection$Builder;
      localObject7 = this.route;
      localObject7 = ((Route)localObject7).address;
      localObject7 = ((Address)localObject7).getUriHost();
      localObject8 = this.socket;
      ((SpdyConnection.Builder)localObject6).<init>((String)localObject7, bool3, (Socket)localObject8);
      localObject7 = this.protocol;
      localObject6 = ((SpdyConnection.Builder)localObject6).protocol((Protocol)localObject7);
      localObject6 = ((SpdyConnection.Builder)localObject6).build();
      this.spdyConnection = ((SpdyConnection)localObject6);
      localObject6 = this.spdyConnection;
      ((SpdyConnection)localObject6).sendConnectionPreface();
    }
    while (true)
    {
      return;
      localObject6 = new com/squareup/okhttp/internal/http/HttpConnection;
      localObject7 = this.pool;
      localObject8 = this.socket;
      ((HttpConnection)localObject6).<init>((ConnectionPool)localObject7, this, (Socket)localObject8);
      this.httpConnection = ((HttpConnection)localObject6);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Square/retargeted/com.squareup.cash_2.5.1_[www.apk-dl.com]/
 * Qualified Name:     com.squareup.okhttp.Connection
 * JD-Core Version:    0.6.2
 */
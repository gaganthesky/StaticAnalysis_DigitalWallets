package org.springframework.http.client;

import android.os.Build.VERSION;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

final class SimpleStreamingClientHttpRequest extends AbstractClientHttpRequest
{
  private static final Boolean olderThanFroyo;
  private OutputStream body;
  private final int chunkSize;
  private final HttpURLConnection connection;

  static
  {
    int i = Build.VERSION.SDK_INT;
    int k = 8;
    if (i < k);
    int j;
    for (i = 1; ; j = 0)
    {
      Boolean localBoolean = Boolean.valueOf(i);
      olderThanFroyo = localBoolean;
      return;
    }
  }

  SimpleStreamingClientHttpRequest(HttpURLConnection paramHttpURLConnection, int paramInt)
  {
    this.connection = paramHttpURLConnection;
    this.chunkSize = paramInt;
    Boolean localBoolean = olderThanFroyo;
    boolean bool = localBoolean.booleanValue();
    if (bool)
    {
      String str1 = "http.keepAlive";
      String str2 = "false";
      System.setProperty(str1, str2);
    }
  }

  protected ClientHttpResponse executeInternal(HttpHeaders paramHttpHeaders)
    throws IOException
  {
    try
    {
      Object localObject = this.body;
      if (localObject != null)
      {
        localObject = this.body;
        ((OutputStream)localObject).close();
      }
      while (true)
      {
        label19: localObject = new org/springframework/http/client/SimpleClientHttpResponse;
        HttpURLConnection localHttpURLConnection = this.connection;
        ((SimpleClientHttpResponse)localObject).<init>(localHttpURLConnection);
        return localObject;
        writeHeaders(paramHttpHeaders);
        localObject = this.connection;
        ((HttpURLConnection)localObject).connect();
      }
    }
    catch (IOException localIOException)
    {
      break label19;
    }
  }

  protected OutputStream getBodyInternal(HttpHeaders paramHttpHeaders)
    throws IOException
  {
    Object localObject1 = this.body;
    Object localObject2;
    if (localObject1 == null)
    {
      long l = paramHttpHeaders.getContentLength();
      int i = (int)l;
      if (i < 0)
        break label99;
      localObject1 = olderThanFroyo;
      boolean bool = ((Boolean)localObject1).booleanValue();
      if (bool)
        break label99;
      localObject2 = this.connection;
      ((HttpURLConnection)localObject2).setFixedLengthStreamingMode(i);
    }
    while (true)
    {
      writeHeaders(paramHttpHeaders);
      localObject2 = this.connection;
      ((HttpURLConnection)localObject2).connect();
      localObject2 = this.connection;
      localObject2 = ((HttpURLConnection)localObject2).getOutputStream();
      this.body = ((OutputStream)localObject2);
      localObject2 = new org/springframework/http/client/SimpleStreamingClientHttpRequest$NonClosingOutputStream;
      OutputStream localOutputStream = this.body;
      SimpleStreamingClientHttpRequest.1 local1 = null;
      ((SimpleStreamingClientHttpRequest.NonClosingOutputStream)localObject2).<init>(localOutputStream, local1);
      return localObject2;
      label99: localObject2 = this.connection;
      int j = this.chunkSize;
      ((HttpURLConnection)localObject2).setChunkedStreamingMode(j);
    }
  }

  public HttpMethod getMethod()
  {
    Object localObject = this.connection;
    localObject = ((HttpURLConnection)localObject).getRequestMethod();
    localObject = HttpMethod.valueOf((String)localObject);
    return localObject;
  }

  public URI getURI()
  {
    Object localObject1;
    try
    {
      localObject1 = this.connection;
      localObject1 = ((HttpURLConnection)localObject1).getURL();
      localObject1 = ((URL)localObject1).toURI();
      return localObject1;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      localObject1 = new java/lang/IllegalStateException;
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      String str = "Could not get HttpURLConnection URI: ";
      localObject2 = ((StringBuilder)localObject2).append(str);
      str = localURISyntaxException.getMessage();
      localObject2 = ((StringBuilder)localObject2).append(str);
      localObject2 = ((StringBuilder)localObject2).toString();
      ((IllegalStateException)localObject1).<init>((String)localObject2, localURISyntaxException);
    }
    throw ((Throwable)localObject1);
  }

  private boolean shouldAllowConnectionReuse(String paramString1, String paramString2)
  {
    Boolean localBoolean = olderThanFroyo;
    boolean bool1 = localBoolean.booleanValue();
    if (bool1)
    {
      String str1 = "Connection";
      boolean bool2 = paramString1.equals(str1);
      if (bool2)
      {
        String str2 = "Keep-Alive";
        bool3 = paramString2.equals(str2);
        if (!bool3);
      }
    }
    for (boolean bool3 = false; ; bool3 = true)
      return bool3;
  }

  private void writeHeaders(HttpHeaders paramHttpHeaders)
  {
    Set localSet = paramHttpHeaders.entrySet();
    Iterator localIterator1 = localSet.iterator();
    boolean bool1 = localIterator1.hasNext();
    if (bool1)
    {
      Object localObject1 = localIterator1.next();
      localObject1 = (Map.Entry)localObject1;
      Object localObject2 = ((Map.Entry)localObject1).getKey();
      localObject2 = (String)localObject2;
      Object localObject4 = ((Map.Entry)localObject1).getValue();
      localObject4 = (List)localObject4;
      Iterator localIterator2 = ((List)localObject4).iterator();
      while (true)
      {
        boolean bool2 = localIterator2.hasNext();
        if (!bool2)
          break;
        Object localObject3 = localIterator2.next();
        localObject3 = (String)localObject3;
        bool2 = shouldAllowConnectionReuse((String)localObject2, (String)localObject3);
        if (bool2)
        {
          HttpURLConnection localHttpURLConnection = this.connection;
          localHttpURLConnection.addRequestProperty((String)localObject2, (String)localObject3);
        }
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     org.springframework.http.client.SimpleStreamingClientHttpRequest
 * JD-Core Version:    0.6.2
 */
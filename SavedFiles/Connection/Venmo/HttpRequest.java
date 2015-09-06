package com.braintreepayments.api.internal;

import com.braintreepayments.api.exceptions.BraintreeSslException;
import com.braintreepayments.api.exceptions.UnexpectedException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.security.Principal;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class HttpRequest
{
  public static boolean DEBUG = false;
  private String mAuthorizationFingerprint;
  private int mConnectTimeout;

  static
  {
    boolean bool = false;
  }

  public HttpRequest(String paramString)
  {
    int i = 0;
    this.mConnectTimeout = i;
    this.mAuthorizationFingerprint = paramString;
  }

  public HttpResponse get(String paramString)
    throws UnexpectedException
  {
    HttpURLConnection localHttpURLConnection = null;
    try
    {
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localObject1 = ((StringBuilder)localObject1).append(paramString);
      str1 = "?authorizationFingerprint=";
      localObject1 = ((StringBuilder)localObject1).append(str1);
      str1 = this.mAuthorizationFingerprint;
      String str2 = "UTF-8";
      str1 = URLEncoder.encode(str1, str2);
      localObject1 = ((StringBuilder)localObject1).append(str1);
      paramString = ((StringBuilder)localObject1).toString();
      localHttpURLConnection = init(paramString);
      localObject1 = "GET";
      localHttpURLConnection.setRequestMethod((String)localObject1);
      localObject1 = handleServerResponse(localHttpURLConnection);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      Object localObject1 = new com/braintreepayments/api/exceptions/UnexpectedException;
      String str1 = localIOException.getMessage();
      ((UnexpectedException)localObject1).<init>(str1);
      throw ((Throwable)localObject1);
    }
    finally
    {
      if (localHttpURLConnection != null)
        localHttpURLConnection.disconnect();
    }
  }

  private static SSLSocketFactory getSslSocketFactory()
    throws BraintreeSslException
  {
    KeyStore localKeyStore;
    try
    {
      String str2 = KeyStore.getDefaultType();
      localKeyStore = KeyStore.getInstance(str2);
      str2 = null;
      localObject4 = null;
      localKeyStore.load(str2, (char[])localObject4);
      str2 = "X.509";
      CertificateFactory localCertificateFactory = CertificateFactory.getInstance(str2);
      InputStream localInputStream = BraintreeGatewayCertificate.getCertInputStream();
      Collection localCollection = localCertificateFactory.generateCertificates(localInputStream);
      Iterator localIterator = localCollection.iterator();
      while (true)
      {
        boolean bool = localIterator.hasNext();
        if (!bool)
          break;
        Object localObject2 = localIterator.next();
        localObject2 = (Certificate)localObject2;
        bool = localObject2 instanceof X509Certificate;
        if (bool)
        {
          Object localObject1 = localObject2;
          localObject1 = (X509Certificate)localObject1;
          localObject3 = localObject1;
          localObject3 = ((X509Certificate)localObject3).getSubjectDN();
          String str1 = ((Principal)localObject3).getName();
          localKeyStore.setCertificateEntry(str1, (Certificate)localObject2);
        }
      }
    }
    catch (Exception localException)
    {
      localObject3 = new com/braintreepayments/api/exceptions/BraintreeSslException;
      ((BraintreeSslException)localObject3).<init>(localException);
      throw ((Throwable)localObject3);
    }
    Object localObject3 = TrustManagerFactory.getDefaultAlgorithm();
    TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance((String)localObject3);
    localTrustManagerFactory.init(localKeyStore);
    localObject3 = "TLS";
    SSLContext localSSLContext = SSLContext.getInstance((String)localObject3);
    localObject3 = null;
    Object localObject4 = localTrustManagerFactory.getTrustManagers();
    SecureRandom localSecureRandom = null;
    localSSLContext.init((KeyManager[])localObject3, (TrustManager[])localObject4, localSecureRandom);
    localObject3 = localSSLContext.getSocketFactory();
    return localObject3;
  }

  public static String getUserAgent()
  {
    String str = "braintree/android/1.4.0";
    return str;
  }

  private HttpResponse handleServerResponse(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    int i = paramHttpURLConnection.getResponseCode();
    int j = 200;
    Object localObject;
    if (i >= j)
    {
      j = 400;
      if (i < j)
        localObject = paramHttpURLConnection.getInputStream();
    }
    for (String str1 = readStream((InputStream)localObject); ; str1 = readStream((InputStream)localObject))
    {
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      String str2 = "Received response code: ";
      localObject = ((StringBuilder)localObject).append(str2);
      localObject = ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
      log((String)localObject);
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      str2 = "Received response: ";
      localObject = ((StringBuilder)localObject).append(str2);
      localObject = ((StringBuilder)localObject).append(str1);
      localObject = ((StringBuilder)localObject).toString();
      log((String)localObject);
      HttpResponse localHttpResponse = new com/braintreepayments/api/internal/HttpResponse;
      localHttpResponse.<init>(i, str1);
      localObject = paramHttpURLConnection.getURL();
      localObject = ((URL)localObject).toString();
      localHttpResponse.setUrl((String)localObject);
      return localHttpResponse;
      localObject = paramHttpURLConnection.getErrorStream();
    }
  }

  protected HttpURLConnection init(String paramString)
    throws IOException
  {
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    Object localObject4 = "Opening url: ";
    localObject2 = ((StringBuilder)localObject2).append((String)localObject4);
    localObject2 = ((StringBuilder)localObject2).append(paramString);
    localObject2 = ((StringBuilder)localObject2).toString();
    log((String)localObject2);
    localObject2 = new java/net/URL;
    ((URL)localObject2).<init>(paramString);
    Object localObject1 = ((URL)localObject2).openConnection();
    localObject1 = (HttpURLConnection)localObject1;
    boolean bool = localObject1 instanceof HttpsURLConnection;
    if (bool)
    {
      localObject3 = localObject1;
      localObject3 = (HttpsURLConnection)localObject3;
      localObject4 = getSslSocketFactory();
      ((HttpsURLConnection)localObject3).setSSLSocketFactory((SSLSocketFactory)localObject4);
    }
    Object localObject3 = "Content-Type";
    localObject4 = "application/json";
    ((HttpURLConnection)localObject1).setRequestProperty((String)localObject3, (String)localObject4);
    localObject3 = "User-Agent";
    localObject4 = getUserAgent();
    ((HttpURLConnection)localObject1).setRequestProperty((String)localObject3, (String)localObject4);
    localObject3 = "Accept-Language";
    localObject4 = Locale.getDefault();
    localObject4 = ((Locale)localObject4).getLanguage();
    ((HttpURLConnection)localObject1).setRequestProperty((String)localObject3, (String)localObject4);
    int i = this.mConnectTimeout;
    ((HttpURLConnection)localObject1).setConnectTimeout(i);
    return localObject1;
  }

  private void log(String paramString)
  {
    boolean bool = DEBUG;
    if (bool);
  }

  // ERROR //
  public HttpResponse post(String paramString1, String paramString2)
    throws UnexpectedException
  {
    // Byte code:
    //   0: nop
    //   1: aconst_null
    //   2: astore_3
    //   3: new 91	org/json/JSONObject
    //   6: astore 8
    //   8: aload 8
    //   10: aload_2
    //   11: invokespecial 299	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14: ldc 155
    //   16: astore 9
    //   18: aload_0
    //   19: getfield 8	com/braintreepayments/api/internal/HttpRequest:mAuthorizationFingerprint	Ljava/lang/String;
    //   22: astore 10
    //   24: aload 8
    //   26: aload 9
    //   28: aload 10
    //   30: invokevirtual 108	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   33: astore 8
    //   35: aload 8
    //   37: invokevirtual 89	org/json/JSONObject:toString	()Ljava/lang/String;
    //   40: astore 6
    //   42: aload_0
    //   43: aload_1
    //   44: invokevirtual 75	com/braintreepayments/api/internal/HttpRequest:init	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   47: astore_3
    //   48: ldc_w 308
    //   51: astore 8
    //   53: aload_3
    //   54: aload 8
    //   56: invokevirtual 294	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   59: iconst_1
    //   60: istore 8
    //   62: aload_3
    //   63: iload 8
    //   65: invokevirtual 58	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   68: new 273	java/io/DataOutputStream
    //   71: astore 5
    //   73: aload_3
    //   74: invokevirtual 34	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   77: astore 8
    //   79: aload 5
    //   81: aload 8
    //   83: invokespecial 193	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: aload 5
    //   88: aload 6
    //   90: invokevirtual 246	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   93: aload 5
    //   95: invokevirtual 214	java/io/DataOutputStream:flush	()V
    //   98: aload 5
    //   100: invokevirtual 219	java/io/DataOutputStream:close	()V
    //   103: aload_0
    //   104: aload_3
    //   105: invokespecial 194	com/braintreepayments/api/internal/HttpRequest:handleServerResponse	(Ljava/net/HttpURLConnection;)Lcom/braintreepayments/api/internal/HttpResponse;
    //   108: astore 7
    //   110: aload 7
    //   112: aload 6
    //   114: invokevirtual 101	com/braintreepayments/api/internal/HttpResponse:setData	(Ljava/lang/String;)V
    //   117: aload_3
    //   118: ifnull +7 -> 125
    //   121: aload_3
    //   122: invokevirtual 27	java/net/HttpURLConnection:disconnect	()V
    //   125: aload 7
    //   127: areturn
    //   128: astore 4
    //   130: new 20	com/braintreepayments/api/exceptions/UnexpectedException
    //   133: astore 8
    //   135: aload 4
    //   137: invokevirtual 290	java/io/IOException:getMessage	()Ljava/lang/String;
    //   140: astore 9
    //   142: aload 8
    //   144: aload 9
    //   146: invokespecial 117	com/braintreepayments/api/exceptions/UnexpectedException:<init>	(Ljava/lang/String;)V
    //   149: aload 8
    //   151: athrow
    //   152: astore 8
    //   154: aload_3
    //   155: ifnull +7 -> 162
    //   158: aload_3
    //   159: invokevirtual 27	java/net/HttpURLConnection:disconnect	()V
    //   162: aload 8
    //   164: athrow
    //   165: astore 4
    //   167: new 20	com/braintreepayments/api/exceptions/UnexpectedException
    //   170: astore 8
    //   172: aload 4
    //   174: invokevirtual 64	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   177: astore 9
    //   179: aload 8
    //   181: aload 9
    //   183: invokespecial 117	com/braintreepayments/api/exceptions/UnexpectedException:<init>	(Ljava/lang/String;)V
    //   186: aload 8
    //   188: athrow
    //   189: nop
    //
    // Exception table:
    //   from	to	target	type
    //   3	8	128	java/io/IOException
    //   14	18	128	java/io/IOException
    //   24	33	128	java/io/IOException
    //   35	40	128	java/io/IOException
    //   42	47	128	java/io/IOException
    //   48	53	128	java/io/IOException
    //   62	68	128	java/io/IOException
    //   73	77	128	java/io/IOException
    //   79	86	128	java/io/IOException
    //   93	98	128	java/io/IOException
    //   103	108	128	java/io/IOException
    //   110	117	128	java/io/IOException
    //   3	8	152	finally
    //   14	18	152	finally
    //   24	33	152	finally
    //   35	40	152	finally
    //   42	47	152	finally
    //   48	53	152	finally
    //   62	68	152	finally
    //   73	77	152	finally
    //   79	86	152	finally
    //   93	98	152	finally
    //   103	108	152	finally
    //   110	117	152	finally
    //   130	135	152	finally
    //   142	149	152	finally
    //   167	172	152	finally
    //   179	186	152	finally
    //   3	8	165	org/json/JSONException
    //   14	18	165	org/json/JSONException
    //   24	33	165	org/json/JSONException
    //   35	40	165	org/json/JSONException
    //   42	47	165	org/json/JSONException
    //   48	53	165	org/json/JSONException
    //   62	68	165	org/json/JSONException
    //   73	77	165	org/json/JSONException
    //   79	86	165	org/json/JSONException
    //   93	98	165	org/json/JSONException
    //   103	108	165	org/json/JSONException
    //   110	117	165	org/json/JSONException
  }

  private String readStream(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
    localByteArrayOutputStream.<init>();
    int j = 1024;
    byte[] arrayOfByte1 = new byte[j];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte1);
      j = -1;
      if (i == j)
        break;
      j = 0;
      localByteArrayOutputStream.write(arrayOfByte1, j, i);
    }
    String str1 = new java/lang/String;
    byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
    String str2 = "UTF-8";
    str1.<init>(arrayOfByte2, str2);
    return str1;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.braintreepayments.api.internal.HttpRequest
 * JD-Core Version:    0.6.2
 */
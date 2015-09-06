package com.paypal.android.sdk;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class R
{
  private final Context a;

  public R(Context paramContext)
  {
    this.a = paramContext;
  }

  public static String a(File paramFile)
  {
    Object localObject = new java/io/RandomAccessFile;
    String str1 = "r";
    ((RandomAccessFile)localObject).<init>(paramFile, str1);
    long l = ((RandomAccessFile)localObject).length();
    int i = (int)l;
    byte[] arrayOfByte = new byte[i];
    ((RandomAccessFile)localObject).readFully(arrayOfByte);
    ((RandomAccessFile)localObject).close();
    localObject = new java/lang/String;
    String str2 = "UTF-8";
    ((String)localObject).<init>(arrayOfByte, str2);
    return localObject;
  }

  public static String a(String paramString)
  {
    try
    {
      String str1 = "UTF-8";
      str1 = URLEncoder.encode(paramString, str1);
      return str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
      {
        Object localObject = new java/lang/StringBuilder;
        String str2 = "unable_to_encode:";
        ((StringBuilder)localObject).<init>(str2);
        localObject = ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
  }

  public static String a(Map paramMap)
  {
    StringBuilder localStringBuilder = new java/lang/StringBuilder;
    localStringBuilder.<init>();
    Object localObject1 = 1;
    Object localObject3 = paramMap.entrySet();
    Iterator localIterator = ((Set)localObject3).iterator();
    localObject3 = localObject1;
    localObject1 = localIterator.hasNext();
    if (localObject1 != 0)
    {
      localObject2 = localIterator.next();
      localObject2 = (Map.Entry)localObject2;
      if (localObject3 == 0)
      {
        str = "&";
        localStringBuilder.append(str);
      }
      int i;
      for (String str = localObject3; ; i = 0)
      {
        Object localObject4 = new java/lang/StringBuilder;
        ((StringBuilder)localObject4).<init>();
        localObject3 = ((Map.Entry)localObject2).getKey();
        localObject3 = (String)localObject3;
        localObject3 = ((StringBuilder)localObject4).append((String)localObject3);
        localObject4 = "=";
        localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
        localObject2 = ((Map.Entry)localObject2).getValue();
        localObject2 = (String)localObject2;
        localObject2 = ((StringBuilder)localObject3).append((String)localObject2);
        localObject2 = ((StringBuilder)localObject2).toString();
        localStringBuilder.append((String)localObject2);
        localObject3 = str;
        break;
      }
    }
    Object localObject2 = localStringBuilder.toString();
    return localObject2;
  }

  public static Header a(String paramString1, List paramList, String paramString2)
  {
    int m = 1;
    Object localObject2 = 0;
    String str1 = "Trace: [%s] %s, %s";
    int j = 3;
    Object localObject3 = new Object[j];
    localObject3[localObject2] = paramString1;
    String str3 = "\"%08.8x: Operation = %80s Duration: %8.2f Iterations: %+4d\"";
    localObject3[m] = str3;
    int k = 2;
    Object localObject5 = "memorySize * 8 + offset";
    localObject3[k] = localObject5;
    localObject3 = String.format(str1, (Object[])localObject3);
    Object localObject4 = new java/util/ArrayList;
    ((ArrayList)localObject4).<init>();
    localObject5 = paramList.iterator();
    String str4;
    while (true)
    {
      boolean bool = ((Iterator)localObject5).hasNext();
      if (!bool)
        break;
      localObject1 = ((Iterator)localObject5).next();
      localObject1 = (Header)localObject1;
      localObject7 = new java/lang/StringBuilder;
      ((StringBuilder)localObject7).<init>();
      str4 = ((Header)localObject1).getName();
      localObject7 = ((StringBuilder)localObject7).append(str4);
      str4 = ": ";
      localObject7 = ((StringBuilder)localObject7).append(str4);
      localObject1 = ((Header)localObject1).getValue();
      localObject1 = ((StringBuilder)localObject7).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject1).toString();
      ((List)localObject4).add(localObject1);
    }
    Collections.sort((List)localObject4);
    Object localObject1 = new java/lang/StringBuilder;
    ((StringBuilder)localObject1).<init>();
    localObject5 = ";";
    localObject4 = ((List)localObject4).toArray();
    localObject4 = TextUtils.join((CharSequence)localObject5, (Object[])localObject4);
    localObject1 = ((StringBuilder)localObject1).append((String)localObject4);
    localObject1 = ((StringBuilder)localObject1).append(paramString2);
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject4 = "HmacSHA1";
    localObject4 = Mac.getInstance((String)localObject4);
    localObject5 = new javax/crypto/spec/SecretKeySpec;
    localObject3 = ((String)localObject3).getBytes();
    Object localObject7 = "HmacSHA1";
    ((SecretKeySpec)localObject5).<init>((byte[])localObject3, (String)localObject7);
    ((Mac)localObject4).init((Key)localObject5);
    localObject1 = ((String)localObject1).getBytes();
    ((Mac)localObject4).update((byte[])localObject1);
    localObject3 = ((Mac)localObject4).doFinal();
    localObject4 = new java/lang/StringBuilder;
    ((StringBuilder)localObject4).<init>();
    Object localObject6 = localObject3.length;
    localObject1 = localObject2;
    while (localObject1 < localObject6)
    {
      byte b = localObject3[localObject1];
      str4 = "%02x";
      Object[] arrayOfObject = new Object[m];
      Object localObject8 = Byte.valueOf(b);
      arrayOfObject[localObject2] = localObject8;
      localObject8 = String.format(str4, arrayOfObject);
      ((StringBuilder)localObject4).append((String)localObject8);
      int i;
      localObject1 += 1;
    }
    BasicHeader localBasicHeader = new org/apache/http/message/BasicHeader;
    String str2 = "PayPal-Item-Id";
    localObject3 = ((StringBuilder)localObject4).toString();
    localBasicHeader.<init>(str2, (String)localObject3);
    return localBasicHeader;
  }

  public static void a(Activity paramActivity)
  {
    boolean bool = a();
    if (bool)
    {
      int i = 8;
      paramActivity.requestWindowFeature(i);
    }
  }

  public static void a(Activity paramActivity, TextView paramTextView, String paramString1, String paramString2, Drawable paramDrawable)
  {
    boolean bool2 = false;
    Object localObject1 = new java/lang/StringBuilder;
    ((StringBuilder)localObject1).<init>();
    localObject1 = ((StringBuilder)localObject1).append(paramString2);
    localObject1 = ((StringBuilder)localObject1).append(paramString1);
    localObject1 = ((StringBuilder)localObject1).toString();
    paramActivity.setTitle((CharSequence)localObject1);
    boolean bool1 = a();
    ActionBar localActionBar;
    if (bool1)
    {
      localActionBar = paramActivity.getActionBar();
      Object localObject2 = bi.c;
      localActionBar.setBackgroundDrawable((Drawable)localObject2);
      localActionBar.setTitle(paramString1);
      localObject2 = Resources.getSystem();
      String str1 = "action_bar_title";
      String str2 = "id";
      String str3 = "android";
      int i = ((Resources)localObject2).getIdentifier(str1, str2, str3);
      Object localObject3 = paramActivity.findViewById(i);
      localObject3 = (TextView)localObject3;
      int k;
      if (localObject3 != null)
      {
        k = -1;
        ((TextView)localObject3).setTextColor(k);
      }
      localActionBar.setDisplayHomeAsUpEnabled(bool2);
      if (paramDrawable != null)
      {
        int j = Build.VERSION.SDK_INT;
        k = 14;
        if (j >= k)
        {
          localActionBar.setIcon(paramDrawable);
          if (paramTextView != null)
          {
            j = 8;
            paramTextView.setVisibility(j);
          }
        }
      }
    }
    while (true)
    {
      return;
      localActionBar.setDisplayShowHomeEnabled(bool2);
      break;
      if (paramTextView != null)
        paramTextView.setText(paramString1);
    }
  }

  // ERROR //
  public static void a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: nop
    //   1: aconst_null
    //   2: astore 4
    //   4: new 416	java/io/FileOutputStream
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: invokespecial 409	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: ldc 38
    //   15: astore_2
    //   16: aload_1
    //   17: aload_2
    //   18: invokevirtual 268	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   21: astore_2
    //   22: aload_3
    //   23: aload_2
    //   24: invokevirtual 310	java/io/FileOutputStream:write	([B)V
    //   27: aload_3
    //   28: invokestatic 26	com/paypal/android/sdk/R:a	(Ljava/io/OutputStream;)V
    //   31: return
    //   32: astore_2
    //   33: aload 4
    //   35: astore_3
    //   36: aload_3
    //   37: invokestatic 26	com/paypal/android/sdk/R:a	(Ljava/io/OutputStream;)V
    //   40: aload_2
    //   41: athrow
    //   42: astore_2
    //   43: goto -7 -> 36
    //   46: nop
    //
    // Exception table:
    //   from	to	target	type
    //   4	8	32	finally
    //   13	16	42	finally
    //   22	27	42	finally
  }

  public static void a(InputStream paramInputStream)
  {
    if (paramInputStream != null);
    try
    {
      paramInputStream.close();
      label9: return;
    }
    catch (IOException localIOException)
    {
      break label9;
    }
  }

  public static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null);
    try
    {
      paramOutputStream.close();
      label9: return;
    }
    catch (IOException localIOException)
    {
      break label9;
    }
  }

  public static void a(Reader paramReader)
  {
    if (paramReader != null);
    try
    {
      paramReader.close();
      label9: return;
    }
    catch (IOException localIOException)
    {
      break label9;
    }
  }

  public final void a(Class paramClass)
  {
    while (true)
    {
      Object localObject2;
      try
      {
        Object localObject1 = this.a;
        localObject1 = ((Context)localObject1).getPackageManager();
        localObject3 = this.a;
        localObject3 = ((Context)localObject3).getPackageName();
        int k = 1;
        localObject1 = ((PackageManager)localObject1).getPackageInfo((String)localObject3, k);
        localObject3 = ((PackageInfo)localObject1).activities;
        if (localObject3 == null)
          break;
        k = localObject3.length;
        int i = 0;
        if (i >= k)
          break;
        Object localObject4 = localObject3[i];
        String str2 = localObject4.name;
        String str3 = paramClass.getName();
        boolean bool = str2.equals(str3);
        if (bool)
        {
          int m = localObject4.getThemeResource();
          int n = 16973840;
          if (m != n)
          {
            RuntimeException localRuntimeException = new java/lang/RuntimeException;
            localObject3 = "Theme for PayPalTouchActivity should be \"@android:style/Theme.Translucent.NoTitleBar\"";
            localRuntimeException.<init>((String)localObject3);
            throw localRuntimeException;
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Object localObject3 = new java/lang/RuntimeException;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        String str1 = "Exception loading manifest";
        localStringBuilder.<init>(str1);
        localObject2 = localNameNotFoundException.getMessage();
        localObject2 = localStringBuilder.append((String)localObject2);
        localObject2 = ((StringBuilder)localObject2).toString();
        ((RuntimeException)localObject3).<init>((String)localObject2);
        throw ((Throwable)localObject3);
      }
      int j;
      localObject2 += 1;
    }
  }

  public static boolean a()
  {
    int i = Build.VERSION.SDK_INT;
    int k = 11;
    if (i >= k);
    int j;
    for (i = 1; ; j = 0)
      return i;
  }

  public static boolean a(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      i = paramCharSequence.length();
      if (i != 0)
        break label20;
    }
    label20: int j;
    for (int i = 1; ; j = 0)
      return i;
  }

  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = a(paramString2);
    Object localObject2;
    if (bool1)
    {
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localObject1 = ((StringBuilder)localObject1).append(paramString3);
      localObject2 = " is empty.";
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
      Log.e(paramString1, (String)localObject1);
    }
    boolean bool2 = d(paramString2);
    if (bool2)
    {
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject2 = ((StringBuilder)localObject2).append(paramString3);
      String str = " contains whitespace.";
      localObject2 = ((StringBuilder)localObject2).append(str);
      localObject2 = ((StringBuilder)localObject2).toString();
      Log.e(paramString1, (String)localObject2);
    }
    if ((!bool1) && (!bool2));
    for (bool1 = true; ; bool1 = false)
      return bool1;
  }

  public static SpannableString b(String paramString)
  {
    Object localObject4 = 1;
    boolean bool4 = false;
    Object localObject1 = Locale.getDefault();
    localObject1 = ((Locale)localObject1).getCountry();
    Locale localLocale = Locale.US;
    localObject1 = ((String)localObject1).toLowerCase(localLocale);
    boolean bool5 = b((CharSequence)localObject1);
    if (!bool5)
    {
      str2 = "jp";
      bool1 = ((String)localObject1).equals(str2);
      if (bool1)
        break label62;
    }
    label62: for (boolean bool1 = bool4; !bool1; localObject2 = localObject4)
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject2 = cs.an;
    String str2 = cq.a((cs)localObject2);
    int i = 2;
    Object[] arrayOfObject = new Object[i];
    boolean bool2 = c(paramString);
    if (bool2)
    {
      String str1 = "ja";
      boolean bool3 = paramString.equals(str1);
      if (!bool3);
    }
    for (Object localObject3 = "https://cms.paypal.com/jp/cgi-bin/marketingweb?cmd=_render-content&content_ID=ua/Legal_Hub_full&locale.x=ja_JP"; ; localObject3 = "https://cms.paypal.com/jp/cgi-bin/marketingweb?cmd=_render-content&content_ID=ua/Legal_Hub_full&locale.x=en_US")
    {
      arrayOfObject[bool4] = localObject3;
      localObject3 = "https://www.paypal.jp/jp/contents/regulation/info/overseas-remittance/";
      arrayOfObject[localObject4] = localObject3;
      Object localObject5 = String.format(str2, arrayOfObject);
      localObject3 = new android/text/SpannableString;
      localObject5 = Html.fromHtml((String)localObject5);
      ((SpannableString)localObject3).<init>((CharSequence)localObject5);
      break;
    }
  }

  public static void b(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    int j = 11;
    if (i >= j)
    {
      i = 1;
      if (i == 0)
        break label34;
      i = 16973934;
      paramActivity.setTheme(i);
    }
    while (true)
    {
      return;
      i = 0;
      break;
      label34: i = 16973836;
      paramActivity.setTheme(i);
    }
  }

  public static boolean b(CharSequence paramCharSequence)
  {
    int j = 1;
    int i = 0;
    int n;
    if (paramCharSequence != null)
    {
      n = paramCharSequence.length();
      if (n != 0);
    }
    else
    {
      i = j;
    }
    while (true)
    {
      return i;
      int k = i;
      while (true)
      {
        if (k >= n)
          break label62;
        char c = paramCharSequence.charAt(k);
        boolean bool = Character.isWhitespace(c);
        if (!bool)
          break;
        int m;
        k += 1;
      }
      label62: i = j;
    }
  }

  public static boolean c(CharSequence paramCharSequence)
  {
    boolean bool = b(paramCharSequence);
    if (!bool);
    for (bool = true; ; bool = false)
      return bool;
  }

  public static boolean d(CharSequence paramCharSequence)
  {
    int i = 0;
    int j = a(paramCharSequence);
    if (j != 0);
    label59: 
    while (true)
    {
      return i;
      int m = paramCharSequence.length();
      j = i;
      while (true)
      {
        if (j >= m)
          break label59;
        char c = paramCharSequence.charAt(j);
        boolean bool = Character.isWhitespace(c);
        if (bool)
        {
          i = 1;
          break;
        }
        int k;
        j += 1;
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.paypal.android.sdk.R
 * JD-Core Version:    0.6.2
 */
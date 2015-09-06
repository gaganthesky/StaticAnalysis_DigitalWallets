package com.crashlytics.android.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class ab
{
  public static final Comparator a = localac;
  private static Boolean b;
  private static final char[] c;
  private static long d = 0L;
  private static Boolean e;

  static
  {
    Object localObject = null;
    b = localObject;
    int i = 16;
    char[] arrayOfChar = new char[i];
    c = arrayOfChar;
    long l = 4294967295L;
    d = l;
    e = localObject;
    ac localac = new com/crashlytics/android/internal/ac;
    localac.<init>();
  }

  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    Resources localResources1 = paramContext.getResources();
    Object localObject = paramContext.getApplicationContext();
    localObject = ((Context)localObject).getApplicationInfo();
    int i = ((ApplicationInfo)localObject).icon;
    Resources localResources2;
    if (i > 0)
      localResources2 = paramContext.getResources();
    String str2;
    for (String str1 = localResources2.getResourcePackageName(i); ; str2 = paramContext.getPackageName())
    {
      int j = localResources1.getIdentifier(paramString1, paramString2, str1);
      return j;
    }
  }

  public static int a(boolean paramBoolean)
  {
    double d3 = 99.0D;
    Object localObject = v.a();
    localObject = ((v)localObject).getContext();
    float f = b((Context)localObject);
    int i;
    if (!paramBoolean)
      i = 1;
    while (true)
    {
      return i;
      if (paramBoolean)
      {
        double d2 = i;
        boolean bool2 = d2 < d3;
        if (!bool2)
          i = 3;
      }
      else
      {
        int j;
        if (paramBoolean)
        {
          double d1 = i;
          boolean bool1 = d1 < d3;
          if (bool1)
            j = 2;
        }
        else
        {
          j = 0;
        }
      }
    }
  }

  public static long a(Context paramContext)
  {
    ActivityManager.MemoryInfo localMemoryInfo = new android/app/ActivityManager$MemoryInfo;
    localMemoryInfo.<init>();
    Object localObject = "activity";
    localObject = paramContext.getSystemService((String)localObject);
    localObject = (ActivityManager)localObject;
    ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
    long l = localMemoryInfo.availMem;
    return l;
  }

  private static long a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = paramString1.split(paramString2);
    int i = 0;
    localObject = localObject[i];
    localObject = ((String)localObject).trim();
    long l1 = Long.parseLong((String)localObject);
    long l2 = paramInt;
    l1 *= l2;
    return l1;
  }

  public static ActivityManager.RunningAppProcessInfo a(String paramString, Context paramContext)
  {
    Object localObject1 = "activity";
    localObject1 = paramContext.getSystemService((String)localObject1);
    localObject1 = (ActivityManager)localObject1;
    localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
    Object localObject3 = null;
    Object localObject2;
    if (localObject1 != null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      boolean bool2;
      do
      {
        boolean bool1 = localIterator.hasNext();
        if (!bool1)
          break;
        localObject2 = localIterator.next();
        localObject2 = (ActivityManager.RunningAppProcessInfo)localObject2;
        String str = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
        bool2 = str.equals(paramString);
      }
      while (!bool2);
    }
    while (true)
    {
      return localObject2;
      localObject2 = localObject3;
    }
  }

  public static SharedPreferences a()
  {
    Object localObject = v.a();
    localObject = ((v)localObject).getContext();
    String str = "com.crashlytics.prefs";
    int i = 0;
    localObject = ((Context)localObject).getSharedPreferences(str, i);
    return localObject;
  }

  public static String a(int paramInt)
  {
    if (paramInt < 0)
    {
      localObject = new java/lang/IllegalArgumentException;
      str = "value must be zero or greater";
      ((IllegalArgumentException)localObject).<init>(str);
      throw ((Throwable)localObject);
    }
    Object localObject = Locale.US;
    String str = "%1$10s";
    int i = 1;
    Object[] arrayOfObject = new Object[i];
    int j = 0;
    Integer localInteger = Integer.valueOf(paramInt);
    arrayOfObject[j] = localInteger;
    localObject = String.format((Locale)localObject, str, arrayOfObject);
    char c1 = ' ';
    char c2 = '0';
    localObject = ((String)localObject).replace(c1, c2);
    return localObject;
  }

  public static String a(Context paramContext, String paramString)
  {
    String str1 = "string";
    int i = a(paramContext, paramString, str1);
    if (i > 0);
    for (String str2 = paramContext.getString(i); ; str2 = "")
      return str2;
  }

  // ERROR //
  private static String a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: nop
    //   1: aconst_null
    //   2: astore_2
    //   3: iconst_1
    //   4: istore 7
    //   6: aload_0
    //   7: invokevirtual 222	java/io/File:exists	()Z
    //   10: istore_3
    //   11: iload_3
    //   12: ifeq +113 -> 125
    //   15: new 243	java/io/BufferedReader
    //   18: astore 4
    //   20: new 491	java/io/FileReader
    //   23: astore_3
    //   24: aload_3
    //   25: aload_0
    //   26: invokespecial 341	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   29: sipush 1024
    //   32: istore 5
    //   34: aload 4
    //   36: aload_3
    //   37: iload 5
    //   39: invokespecial 427	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   42: aload 4
    //   44: invokevirtual 108	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull +67 -> 116
    //   52: ldc 200
    //   54: astore 5
    //   56: aload 5
    //   58: invokestatic 52	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   61: astore 5
    //   63: iconst_2
    //   64: istore 6
    //   66: aload 5
    //   68: aload_3
    //   69: iload 6
    //   71: invokevirtual 517	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;I)[Ljava/lang/String;
    //   74: astore_3
    //   75: aload_3
    //   76: arraylength
    //   77: istore 5
    //   79: iload 5
    //   81: iload 7
    //   83: if_icmple -41 -> 42
    //   86: iconst_0
    //   87: istore 5
    //   89: aload_3
    //   90: iload 5
    //   92: aaload
    //   93: astore 5
    //   95: aload 5
    //   97: aload_1
    //   98: invokevirtual 317	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   101: istore 5
    //   103: iload 5
    //   105: ifeq -63 -> 42
    //   108: iconst_1
    //   109: istore 5
    //   111: aload_3
    //   112: iload 5
    //   114: aaload
    //   115: astore_2
    //   116: ldc 28
    //   118: astore_3
    //   119: aload 4
    //   121: aload_3
    //   122: invokestatic 307	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   125: aload_2
    //   126: areturn
    //   127: astore_3
    //   128: aload_2
    //   129: astore 4
    //   131: invokestatic 458	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   134: astore 5
    //   136: aload 5
    //   138: invokevirtual 91	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   141: astore 5
    //   143: ldc_w 261
    //   146: astore 6
    //   148: new 581	java/lang/StringBuilder
    //   151: astore 7
    //   153: ldc_w 283
    //   156: astore 8
    //   158: aload 7
    //   160: aload 8
    //   162: invokespecial 445	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   165: aload 7
    //   167: aload_0
    //   168: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   171: astore 7
    //   173: aload 7
    //   175: invokevirtual 572	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: astore 7
    //   180: aload 5
    //   182: aload 6
    //   184: aload 7
    //   186: aload_3
    //   187: invokeinterface 348 4 0
    //   192: ldc 28
    //   194: astore_3
    //   195: aload 4
    //   197: aload_3
    //   198: invokestatic 307	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   201: goto -76 -> 125
    //   204: astore_3
    //   205: aload_2
    //   206: astore 4
    //   208: aload_3
    //   209: astore_2
    //   210: ldc 28
    //   212: astore_3
    //   213: aload 4
    //   215: aload_3
    //   216: invokestatic 307	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   219: aload_2
    //   220: athrow
    //   221: astore_2
    //   222: goto -12 -> 210
    //   225: astore_3
    //   226: goto -95 -> 131
    //   229: nop
    //
    // Exception table:
    //   from	to	target	type
    //   15	20	127	java/lang/Exception
    //   24	29	127	java/lang/Exception
    //   34	42	127	java/lang/Exception
    //   15	20	204	finally
    //   24	29	204	finally
    //   34	42	204	finally
    //   42	47	221	finally
    //   52	56	221	finally
    //   66	74	221	finally
    //   75	79	221	finally
    //   89	95	221	finally
    //   111	116	221	finally
    //   131	134	221	finally
    //   136	141	221	finally
    //   143	148	221	finally
    //   153	158	221	finally
    //   165	171	221	finally
    //   173	178	221	finally
    //   180	192	221	finally
    //   42	47	225	java/lang/Exception
    //   52	56	225	java/lang/Exception
    //   66	74	225	java/lang/Exception
    //   75	79	225	java/lang/Exception
    //   89	95	225	java/lang/Exception
    //   111	116	225	java/lang/Exception
  }

  public static String a(InputStream paramInputStream)
    throws IOException
  {
    Object localObject = new java/util/Scanner;
    ((Scanner)localObject).<init>(paramInputStream);
    String str = "\\A";
    localObject = ((Scanner)localObject).useDelimiter(str);
    boolean bool = ((Scanner)localObject).hasNext();
    if (bool);
    for (localObject = ((Scanner)localObject).next(); ; localObject = "")
      return localObject;
  }

  public static String a(String paramString)
  {
    String str = "SHA-1";
    byte[] arrayOfByte = paramString.getBytes();
    str = a(arrayOfByte, str);
    return str;
  }

  public static String a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    i <<= 1;
    char[] arrayOfChar1 = new char[i];
    i = 0;
    while (true)
    {
      int j = paramArrayOfByte.length;
      if (i >= j)
        break;
      j = paramArrayOfByte[i];
      j += 255;
      int k = i << 1;
      char[] arrayOfChar2 = c;
      int n = j >>> 4;
      int m = arrayOfChar2[n];
      arrayOfChar1[k] = m;
      k = i << 1;
      k += 1;
      char[] arrayOfChar3 = c;
      j &= 15;
      j = arrayOfChar3[j];
      arrayOfChar1[k] = j;
      i += 1;
    }
    String str = new java/lang/String;
    str.<init>(arrayOfChar1);
    return str;
  }

  private static String a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      Object localObject1 = MessageDigest.getInstance(paramString);
      ((MessageDigest)localObject1).update(paramArrayOfByte);
      localObject1 = ((MessageDigest)localObject1).digest();
      localObject1 = a((byte[])localObject1);
      return localObject1;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      while (true)
      {
        Object localObject2 = v.a();
        localObject2 = ((v)localObject2).b();
        String str2 = "Crashlytics";
        Object localObject3 = new java/lang/StringBuilder;
        String str3 = "Could not create hashing algorithm: ";
        ((StringBuilder)localObject3).<init>(str3);
        localObject3 = ((StringBuilder)localObject3).append(paramString);
        str3 = ", returning empty string.";
        localObject3 = ((StringBuilder)localObject3).append(str3);
        localObject3 = ((StringBuilder)localObject3).toString();
        ((q)localObject2).a(str2, (String)localObject3, localNoSuchAlgorithmException);
        String str1 = "";
      }
    }
  }

  public static String a(String[] paramArrayOfString)
  {
    Object localObject3 = null;
    Object localObject1;
    if (paramArrayOfString != null)
    {
      int i = paramArrayOfString.length;
      if (i != 0);
    }
    else
    {
      localObject1 = localObject3;
    }
    while (true)
    {
      return localObject1;
      Object localObject4 = new java/util/ArrayList;
      ((ArrayList)localObject4).<init>();
      int m = paramArrayOfString.length;
      int j = 0;
      while (j < m)
      {
        String str1 = paramArrayOfString[j];
        if (str1 != null)
        {
          Object localObject5 = "-";
          String str2 = "";
          str1 = str1.replace((CharSequence)localObject5, str2);
          localObject5 = Locale.US;
          str1 = str1.toLowerCase((Locale)localObject5);
          ((List)localObject4).add(str1);
        }
        j += 1;
      }
      Collections.sort((List)localObject4);
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localObject4 = ((List)localObject4).iterator();
      while (true)
      {
        boolean bool = ((Iterator)localObject4).hasNext();
        if (!bool)
          break;
        localObject2 = ((Iterator)localObject4).next();
        localObject2 = (String)localObject2;
        localStringBuilder.append((String)localObject2);
      }
      Object localObject2 = localStringBuilder.toString();
      int k = ((String)localObject2).length();
      if (k > 0)
        localObject2 = a((String)localObject2);
      else
        localObject2 = localObject3;
    }
  }

  public static void a(int paramInt, String paramString)
  {
    Object localObject1 = v.a();
    localObject1 = ((v)localObject1).getContext();
    boolean bool = e((Context)localObject1);
    if (bool)
    {
      Object localObject2 = v.a();
      localObject2 = ((v)localObject2).b();
      int i = 4;
      String str = "Crashlytics";
      ((q)localObject2).a(i, str, paramString);
    }
  }

  public static void a(Closeable paramCloseable, String paramString)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        Object localObject = v.a();
        localObject = ((v)localObject).b();
        String str = "Crashlytics";
        ((q)localObject).a(str, paramString, localIOException);
      }
    }
  }

  public static void a(Flushable paramFlushable, String paramString)
  {
    if (paramFlushable != null);
    try
    {
      paramFlushable.flush();
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        Object localObject = v.a();
        localObject = ((v)localObject).b();
        String str = "Crashlytics";
        ((q)localObject).a(str, paramString, localIOException);
      }
    }
  }

  public static void a(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    while (true)
    {
      int i = paramInputStream.read(paramArrayOfByte);
      int j = -1;
      if (i == j)
        break;
      j = 0;
      paramOutputStream.write(paramArrayOfByte, j, i);
    }
  }

  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (paramContext != null)
    {
      localObject = paramContext.getResources();
      if (localObject != null)
      {
        String str2 = "bool";
        int j = a(paramContext, paramString, str2);
        if (j <= 0)
          break label41;
        paramBoolean = ((Resources)localObject).getBoolean(j);
      }
    }
    while (true)
    {
      return paramBoolean;
      label41: localObject = "string";
      int i = a(paramContext, paramString, (String)localObject);
      if (i > 0)
      {
        String str1 = paramContext.getString(i);
        paramBoolean = Boolean.parseBoolean(str1);
      }
    }
  }

  public static float b(Context paramContext)
  {
    int k = -1;
    Object localObject = new android/content/IntentFilter;
    String str1 = "android.intent.action.BATTERY_CHANGED";
    ((IntentFilter)localObject).<init>(str1);
    str1 = null;
    localObject = paramContext.registerReceiver(str1, (IntentFilter)localObject);
    str1 = "level";
    int j = ((Intent)localObject).getIntExtra(str1, k);
    String str2 = "scale";
    int i = ((Intent)localObject).getIntExtra(str2, k);
    float f2 = j;
    float f1 = i;
    f1 = f2 / f1;
    return f1;
  }

  public static int b()
  {
    ad localad = ad.a();
    int i = localad.ordinal();
    return i;
  }

  public static long b(String paramString)
  {
    StatFs localStatFs = new android/os/StatFs;
    localStatFs.<init>(paramString);
    int j = localStatFs.getBlockSize();
    long l2 = j;
    j = localStatFs.getBlockCount();
    long l3 = j;
    l3 *= l2;
    int i = localStatFs.getAvailableBlocks();
    long l1 = i;
    l1 *= l2;
    l1 = l3 - l1;
    return l1;
  }

  public static String b(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default:
      str = "?";
    case 7:
    case 3:
    case 6:
    case 4:
    case 2:
    case 5:
    }
    while (true)
    {
      return str;
      str = "A";
      continue;
      str = "D";
      continue;
      str = "E";
      continue;
      str = "I";
      continue;
      str = "V";
      continue;
      str = "W";
    }
  }

  private static String b(InputStream paramInputStream)
  {
    Object localObject2;
    try
    {
      Object localObject1 = "SHA-1";
      localObject1 = MessageDigest.getInstance((String)localObject1);
      int i = 1024;
      localObject3 = new byte[i];
      while (true)
      {
        int j = paramInputStream.read((byte[])localObject3);
        int k = -1;
        if (j == k)
          break;
        k = 0;
        ((MessageDigest)localObject1).update((byte[])localObject3, k, j);
      }
    }
    catch (Exception localException)
    {
      Object localObject3 = v.a();
      localObject3 = ((v)localObject3).b();
      String str1 = "Crashlytics";
      String str2 = "Could not calculate hash for app icon.";
      ((q)localObject3).a(str1, str2, localException);
      localObject2 = "";
    }
    while (true)
    {
      return localObject2;
      localObject2 = ((MessageDigest)localObject2).digest();
      localObject2 = a((byte[])localObject2);
    }
  }

  public static Cipher b(int paramInt, String paramString)
    throws InvalidKeyException
  {
    int k = 32;
    int i = paramString.length();
    if (i < k)
    {
      localObject1 = new java/security/InvalidKeyException;
      localObject2 = "Key must be at least 32 bytes.";
      ((InvalidKeyException)localObject1).<init>((String)localObject2);
      throw ((Throwable)localObject1);
    }
    Object localObject1 = new javax/crypto/spec/SecretKeySpec;
    Object localObject2 = paramString.getBytes();
    int j = 0;
    String str2 = "AES/ECB/PKCS7Padding";
    ((SecretKeySpec)localObject1).<init>((byte[])localObject2, j, k, str2);
    try
    {
      localObject2 = "AES/ECB/PKCS7Padding";
      localObject2 = Cipher.getInstance((String)localObject2);
      j = 1;
      ((Cipher)localObject2).init(j, (Key)localObject1);
      return localObject2;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      localObject2 = v.a();
      localObject2 = ((v)localObject2).b();
      String str1 = "Crashlytics";
      str2 = "Could not create Cipher for AES/ECB/PKCS7Padding - should never happen.";
      ((q)localObject2).a(str1, str2, localGeneralSecurityException);
      localObject2 = new java/lang/RuntimeException;
      ((RuntimeException)localObject2).<init>(localGeneralSecurityException);
    }
    throw ((Throwable)localObject2);
  }

  public static long c()
  {
    synchronized (ab.class)
    {
      long l1 = d;
      long l7 = 4294967295L;
      boolean bool1 = l1 < l7;
      Object localObject1;
      Object localObject4;
      if (!bool1)
      {
        l7 = 0L;
        localObject1 = new java/io/File;
        String str6 = "/proc/meminfo";
        ((File)localObject1).<init>(str6);
        str6 = "MemTotal";
        localObject1 = a((File)localObject1, str6);
        boolean bool5 = TextUtils.isEmpty((CharSequence)localObject1);
        if (!bool5)
        {
          localObject4 = Locale.US;
          localObject4 = ((String)localObject1).toUpperCase((Locale)localObject4);
        }
      }
      else
      {
        try
        {
          localObject1 = "KB";
          boolean bool2 = ((String)localObject4).endsWith((String)localObject1);
          int i;
          long l2;
          if (bool2)
          {
            String str1 = "KB";
            i = 1024;
            l2 = a((String)localObject4, str1, i);
          }
          while (true)
          {
            d = l2;
            l2 = d;
            return l2;
            String str2 = "MB";
            boolean bool3 = ((String)localObject4).endsWith(str2);
            if (bool3)
            {
              String str3 = "MB";
              i = 1048576;
              long l3 = a((String)localObject4, str3, i);
            }
            else
            {
              String str4 = "GB";
              boolean bool4 = ((String)localObject4).endsWith(str4);
              if (bool4)
              {
                String str5 = "GB";
                i = 1073741824;
                long l4 = a((String)localObject4, str5, i);
              }
              else
              {
                Object localObject2 = v.a();
                localObject2 = ((v)localObject2).b();
                localObject5 = "Crashlytics";
                localObject6 = new java/lang/StringBuilder;
                localObject7 = "Unexpected meminfo format while computing RAM: ";
                ((StringBuilder)localObject6).<init>((String)localObject7);
                localObject6 = ((StringBuilder)localObject6).append((String)localObject4);
                localObject6 = ((StringBuilder)localObject6).toString();
                ((q)localObject2).a((String)localObject5, (String)localObject6);
                long l5 = l7;
              }
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          Object localObject5 = v.a();
          localObject5 = ((v)localObject5).b();
          Object localObject6 = "Crashlytics";
          Object localObject7 = new java/lang/StringBuilder;
          String str7 = "Unexpected meminfo format while computing RAM: ";
          ((StringBuilder)localObject7).<init>(str7);
          localObject4 = ((StringBuilder)localObject7).append((String)localObject4);
          localObject4 = ((StringBuilder)localObject4).toString();
          ((q)localObject5).a((String)localObject6, (String)localObject4, localNumberFormatException);
        }
      }
      long l6 = l7;
    }
  }

  public static void c(String paramString)
  {
    Object localObject1 = v.a();
    localObject1 = ((v)localObject1).getContext();
    boolean bool = e((Context)localObject1);
    if (bool)
    {
      Object localObject2 = v.a();
      localObject2 = ((v)localObject2).b();
      String str = "Crashlytics";
      ((q)localObject2).a(str, paramString);
    }
  }

  public static boolean c(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = d();
    if (bool1)
      bool1 = bool2;
    while (true)
    {
      return bool1;
      Object localObject = "sensor";
      localObject = paramContext.getSystemService((String)localObject);
      localObject = (SensorManager)localObject;
      int j = 8;
      localObject = ((SensorManager)localObject).getDefaultSensor(j);
      int i;
      if (localObject != null)
        i = 1;
      else
        i = bool2;
    }
  }

  public static void d(String paramString)
  {
    Object localObject1 = v.a();
    localObject1 = ((v)localObject1).getContext();
    boolean bool = e((Context)localObject1);
    if (bool)
    {
      Object localObject2 = v.a();
      localObject2 = ((v)localObject2).b();
      String str = "Crashlytics";
      ((q)localObject2).d(str, paramString);
    }
  }

  public static boolean d()
  {
    Object localObject = v.a();
    localObject = ((v)localObject).getContext();
    localObject = ((Context)localObject).getContentResolver();
    String str1 = "android_id";
    localObject = Settings.Secure.getString((ContentResolver)localObject, str1);
    str1 = "sdk";
    String str3 = Build.PRODUCT;
    boolean bool2 = str1.equals(str3);
    if (!bool2)
    {
      String str2 = "google_sdk";
      str3 = Build.PRODUCT;
      boolean bool3 = str2.equals(str3);
      if ((!bool3) && (localObject != null))
        break label68;
    }
    label68: for (boolean bool1 = true; ; bool1 = false)
      return bool1;
  }

  public static boolean d(Context paramContext)
  {
    boolean bool1 = false;
    Object localObject = e;
    if (localObject == null)
    {
      localObject = "com.crashlytics.SilenceCrashlyticsLogCat";
      boolean bool3 = a(paramContext, (String)localObject, bool1);
      if (!bool3)
        bool1 = true;
      localBoolean = Boolean.valueOf(bool1);
      e = localBoolean;
    }
    Boolean localBoolean = e;
    boolean bool2 = localBoolean.booleanValue();
    return bool2;
  }

  public static boolean e()
  {
    boolean bool1 = true;
    boolean bool2 = d();
    String str1 = Build.TAGS;
    String str2;
    if ((!bool2) && (str1 != null))
    {
      str2 = "test-keys";
      boolean bool3 = str1.contains(str2);
      if (!bool3);
    }
    while (true)
    {
      return bool1;
      File localFile1 = new java/io/File;
      str2 = "/system/app/Superuser.apk";
      localFile1.<init>(str2);
      boolean bool4 = localFile1.exists();
      if (!bool4)
      {
        File localFile2 = new java/io/File;
        str2 = "/system/xbin/su";
        localFile2.<init>(str2);
        if (!bool2)
        {
          bool2 = localFile2.exists();
          if (bool2);
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }

  public static boolean e(Context paramContext)
  {
    Object localObject = b;
    if (localObject == null)
    {
      localObject = "com.crashlytics.Trace";
      boolean bool3 = false;
      boolean bool1 = a(paramContext, (String)localObject, bool3);
      localBoolean = Boolean.valueOf(bool1);
      b = localBoolean;
    }
    Boolean localBoolean = b;
    boolean bool2 = localBoolean.booleanValue();
    return bool2;
  }

  public static boolean e(String paramString)
  {
    if (paramString != null)
    {
      i = paramString.length();
      if (i != 0)
        break label18;
    }
    label18: int j;
    for (int i = 1; ; j = 0)
      return i;
  }

  public static int f()
  {
    int j = 1;
    int k = 0;
    boolean bool1 = d();
    if (bool1);
    int i;
    for (bool1 = j; ; i = k)
    {
      boolean bool2 = e();
      if (bool2)
        bool1 |= true;
      bool2 = Debug.isDebuggerConnected();
      if (!bool2)
      {
        bool2 = Debug.waitingForDebugger();
        if (!bool2);
      }
      else
      {
        k = j;
      }
      if (k != 0)
        i |= 4;
      return i;
    }
  }

  public static boolean f(Context paramContext)
  {
    ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
    int i = localApplicationInfo.flags;
    i &= 2;
    if (i != 0);
    int j;
    for (i = 1; ; j = 0)
      return i;
  }

  // ERROR //
  public static String g(Context paramContext)
  {
    // Byte code:
    //   0: nop
    //   1: aconst_null
    //   2: astore_1
    //   3: aload_0
    //   4: invokevirtual 586	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7: astore_2
    //   8: aload_0
    //   9: invokestatic 502	com/crashlytics/android/internal/ab:h	(Landroid/content/Context;)I
    //   12: istore_3
    //   13: aload_2
    //   14: iload_3
    //   15: invokevirtual 463	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   18: astore_3
    //   19: aload_3
    //   20: invokestatic 157	com/crashlytics/android/internal/ab:b	(Ljava/io/InputStream;)Ljava/lang/String;
    //   23: astore_2
    //   24: aload_2
    //   25: invokestatic 595	com/crashlytics/android/internal/ab:e	(Ljava/lang/String;)Z
    //   28: istore 4
    //   30: iload 4
    //   32: ifeq +14 -> 46
    //   35: ldc_w 587
    //   38: astore_2
    //   39: aload_3
    //   40: aload_2
    //   41: invokestatic 307	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   44: aload_1
    //   45: areturn
    //   46: aload_2
    //   47: astore_1
    //   48: goto -13 -> 35
    //   51: astore_2
    //   52: aload_1
    //   53: astore_3
    //   54: invokestatic 458	com/crashlytics/android/internal/v:a	()Lcom/crashlytics/android/internal/v;
    //   57: astore 4
    //   59: aload 4
    //   61: invokevirtual 91	com/crashlytics/android/internal/v:b	()Lcom/crashlytics/android/internal/q;
    //   64: astore 4
    //   66: ldc_w 261
    //   69: astore 5
    //   71: ldc_w 291
    //   74: astore 6
    //   76: aload 4
    //   78: aload 5
    //   80: aload 6
    //   82: aload_2
    //   83: invokeinterface 348 4 0
    //   88: ldc_w 587
    //   91: astore_2
    //   92: aload_3
    //   93: aload_2
    //   94: invokestatic 307	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   97: goto -53 -> 44
    //   100: astore_2
    //   101: aload_1
    //   102: astore_3
    //   103: aload_2
    //   104: astore_1
    //   105: ldc_w 587
    //   108: astore_2
    //   109: aload_3
    //   110: aload_2
    //   111: invokestatic 307	com/crashlytics/android/internal/ab:a	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   114: aload_1
    //   115: athrow
    //   116: astore_1
    //   117: goto -12 -> 105
    //   120: astore_2
    //   121: goto -67 -> 54
    //   124: nop
    //
    // Exception table:
    //   from	to	target	type
    //   3	7	51	java/lang/Exception
    //   8	12	51	java/lang/Exception
    //   13	18	51	java/lang/Exception
    //   3	7	100	finally
    //   8	12	100	finally
    //   13	18	100	finally
    //   19	23	116	finally
    //   24	28	116	finally
    //   54	57	116	finally
    //   59	64	116	finally
    //   66	71	116	finally
    //   76	88	116	finally
    //   19	23	120	java/lang/Exception
    //   24	28	120	java/lang/Exception
  }

  public static int h(Context paramContext)
  {
    Object localObject = paramContext.getApplicationContext();
    localObject = ((Context)localObject).getApplicationInfo();
    int i = ((ApplicationInfo)localObject).icon;
    return i;
  }

  public static String i(Context paramContext)
  {
    Object localObject1 = null;
    String str1 = "com.crashlytics.android.build_id";
    String str2 = "string";
    int i = a(paramContext, str1, str2);
    if (i != 0)
    {
      localObject1 = paramContext.getResources();
      localObject1 = ((Resources)localObject1).getString(i);
      Object localObject2 = v.a();
      localObject2 = ((v)localObject2).b();
      str2 = "Crashlytics";
      Object localObject3 = new java/lang/StringBuilder;
      String str3 = "Build ID is: ";
      ((StringBuilder)localObject3).<init>(str3);
      localObject3 = ((StringBuilder)localObject3).append((String)localObject1);
      localObject3 = ((StringBuilder)localObject3).toString();
      ((q)localObject2).a(str2, (String)localObject3);
    }
    return localObject1;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.crashlytics.android.internal.ab
 * JD-Core Version:    0.6.2
 */
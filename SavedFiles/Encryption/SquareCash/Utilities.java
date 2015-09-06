package com.squareup.pollexor;

import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

final class Utilities
{
  private static final String BASE64_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
  private static final int BASE64_UPPER_BOUND = 1610612733;

  static byte[] aes128Encrypt(StringBuilder paramStringBuilder, String paramString)
  {
    char c = '\020';
    Object localObject;
    try
    {
      paramString = normalizeString(paramString, c);
      c = '{';
      int j = 16;
      rightPadString(paramStringBuilder, c, j);
      String str1 = "AES/ECB/NoPadding";
      Cipher localCipher = Cipher.getInstance(str1);
      int i = 1;
      SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
      byte[] arrayOfByte = paramString.getBytes();
      String str2 = "AES";
      localSecretKeySpec.<init>(arrayOfByte, str2);
      localCipher.init(i, localSecretKeySpec);
      localObject = paramStringBuilder.toString();
      localObject = ((String)localObject).getBytes();
      localObject = localCipher.doFinal((byte[])localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      localObject = new java/lang/RuntimeException;
      ((RuntimeException)localObject).<init>(localException);
    }
    throw ((Throwable)localObject);
  }

  public static String base64Encode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      IllegalArgumentException localIllegalArgumentException1 = new java/lang/IllegalArgumentException;
      String str3 = "Input bytes must not be null.";
      localIllegalArgumentException1.<init>(str3);
      throw localIllegalArgumentException1;
    }
    int i1 = paramArrayOfByte.length;
    int i4 = 1610612733;
    if (i1 >= i4)
    {
      IllegalArgumentException localIllegalArgumentException2 = new java/lang/IllegalArgumentException;
      String str4 = "Input bytes length must not exceed 1610612733";
      localIllegalArgumentException2.<init>(str4);
      throw localIllegalArgumentException2;
    }
    int i2 = paramArrayOfByte.length;
    int n = i2 / 3;
    i2 = paramArrayOfByte.length;
    i2 %= 3;
    if (i2 != 0)
      n += 1;
    i2 = n << 2;
    char[] arrayOfChar = new char[i2];
    int j = 0;
    int k = 0;
    while (true)
    {
      i2 = paramArrayOfByte.length;
      if (j >= i2)
        break;
      i2 = paramArrayOfByte[j];
      i2 += 255;
      int m = i2 << 16;
      i2 = j + 1;
      int i5 = paramArrayOfByte.length;
      if (i2 < i5)
      {
        i2 = j + 1;
        i2 = paramArrayOfByte[i2];
        i2 += 255;
        i2 <<= 8;
        m |= i2;
      }
      i2 = j + 2;
      i5 = paramArrayOfByte.length;
      if (i2 < i5)
      {
        i2 = j + 2;
        i2 = paramArrayOfByte[i2];
        i2 += 255;
        m |= i2;
      }
      String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
      i5 = m >> 18;
      i5 &= 63;
      i3 = str1.charAt(i5);
      arrayOfChar[k] = i3;
      i3 = k + 1;
      String str5 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
      i9 = m >> 12;
      i9 &= 63;
      int i6 = str5.charAt(i9);
      arrayOfChar[i3] = i6;
      i3 = k + 2;
      String str6 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
      i9 = m >> 6;
      i9 &= 63;
      int i7 = str6.charAt(i9);
      arrayOfChar[i3] = i7;
      i3 = k + 3;
      String str7 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
      i9 = m & 0x3F;
      i8 = str7.charAt(i9);
      arrayOfChar[i3] = i8;
      j += 3;
      k += 4;
    }
    int i3 = arrayOfChar.length;
    int i8 = n * 3;
    int i9 = paramArrayOfByte.length;
    i8 -= i9;
    int i = i3 - i8;
    while (true)
    {
      i3 = arrayOfChar.length;
      if (i >= i3)
        break;
      i3 = 61;
      arrayOfChar[i] = i3;
      i += 1;
    }
    String str2 = String.valueOf(arrayOfChar);
    return str2;
  }

  static byte[] hmacSha1(StringBuilder paramStringBuilder, String paramString)
  {
    Object localObject;
    try
    {
      localObject = "HmacSHA1";
      Mac localMac = Mac.getInstance((String)localObject);
      localObject = new javax/crypto/spec/SecretKeySpec;
      byte[] arrayOfByte = paramString.getBytes();
      String str = "HmacSHA1";
      ((SecretKeySpec)localObject).<init>(arrayOfByte, str);
      localMac.init((Key)localObject);
      localObject = paramStringBuilder.toString();
      localObject = ((String)localObject).getBytes();
      localObject = localMac.doFinal((byte[])localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      localObject = new java/lang/RuntimeException;
      ((RuntimeException)localObject).<init>(localException);
    }
    throw ((Throwable)localObject);
  }

  static String md5(String paramString)
  {
    Object localObject1;
    if (paramString != null)
    {
      int m = paramString.length();
      if (m != 0);
    }
    else
    {
      localObject1 = new java/lang/IllegalArgumentException;
      String str = "Input string must not be blank.";
      ((IllegalArgumentException)localObject1).<init>(str);
      throw ((Throwable)localObject1);
    }
    Object localObject2;
    try
    {
      localObject1 = "MD5";
      MessageDigest localMessageDigest = MessageDigest.getInstance((String)localObject1);
      localMessageDigest.reset();
      localObject1 = paramString.getBytes();
      localMessageDigest.update((byte[])localObject1);
      byte[] arrayOfByte2 = localMessageDigest.digest();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      byte[] arrayOfByte1 = arrayOfByte2;
      int j = arrayOfByte1.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfByte1[i];
        int n = k + 255;
        n |= 256;
        localObject2 = Integer.toHexString(n);
        int i1 = 1;
        int i2 = 3;
        localObject2 = ((String)localObject2).substring(i1, i2);
        localStringBuilder.append((String)localObject2);
        i += 1;
      }
      localObject2 = localStringBuilder.toString();
      return localObject2;
    }
    catch (Exception localException)
    {
      localObject2 = new java/lang/RuntimeException;
      ((RuntimeException)localObject2).<init>(localException);
    }
    throw ((Throwable)localObject2);
  }

  static String normalizeString(String paramString, int paramInt)
  {
    int m = 0;
    IllegalArgumentException localIllegalArgumentException;
    String str3;
    if (paramString != null)
    {
      int i = paramString.length();
      if (i != 0);
    }
    else
    {
      localIllegalArgumentException = new java/lang/IllegalArgumentException;
      str3 = "Must supply a non-null, non-empty string.";
      localIllegalArgumentException.<init>(str3);
      throw localIllegalArgumentException;
    }
    if (paramInt <= 0)
    {
      localIllegalArgumentException = new java/lang/IllegalArgumentException;
      str3 = "Desired length must be greater than zero.";
      localIllegalArgumentException.<init>(str3);
      throw localIllegalArgumentException;
    }
    int j = paramString.length();
    if (j >= paramInt);
    StringBuilder localStringBuilder;
    String str2;
    for (String str1 = paramString.substring(str3, paramInt); ; str2 = localStringBuilder.substring(str3, paramInt))
    {
      return str1;
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>(paramString);
      while (true)
      {
        int k = localStringBuilder.length();
        if (k >= paramInt)
          break;
        localStringBuilder.append(paramString);
      }
    }
  }

  static void rightPadString(StringBuilder paramStringBuilder, char paramChar, int paramInt)
  {
    String str;
    if (paramStringBuilder == null)
    {
      IllegalArgumentException localIllegalArgumentException1 = new java/lang/IllegalArgumentException;
      str = "Builder input must not be empty.";
      localIllegalArgumentException1.<init>(str);
      throw localIllegalArgumentException1;
    }
    int k = 2;
    if (paramInt < k)
    {
      IllegalArgumentException localIllegalArgumentException2 = new java/lang/IllegalArgumentException;
      str = "Multiple must be greater than one.";
      localIllegalArgumentException2.<init>(str);
      throw localIllegalArgumentException2;
    }
    int m = paramStringBuilder.length();
    m %= paramInt;
    int j = paramInt - m;
    if (j < paramInt)
    {
      int i = j;
      while (i > 0)
      {
        paramStringBuilder.append(paramChar);
        i += -1;
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Square/retargeted/com.squareup.cash_2.5.1_[www.apk-dl.com]/
 * Qualified Name:     com.squareup.pollexor.Utilities
 * JD-Core Version:    0.6.2
 */
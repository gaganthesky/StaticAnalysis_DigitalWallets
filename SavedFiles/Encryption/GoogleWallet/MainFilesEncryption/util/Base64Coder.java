package org.keyczar.util;

import org.keyczar.exceptions.Base64DecodingException;
import org.keyczar.i18n.Messages;

public final class Base64Coder
{
  private static final char[] ALPHABET;
  private static final byte[] DECODE;
  private static final char[] WHITESPACE;

  static
  {
    int j = 64;
    char[] arrayOfChar1 = new char[j];
    ALPHABET = arrayOfChar1;
    int k = 128;
    byte[] arrayOfByte1 = new byte[k];
    DECODE = arrayOfByte1;
    int m = 5;
    Object localObject1 = new char[m];
    WHITESPACE = (char[])localObject1;
    int i = 0;
    Object localObject2;
    while (true)
    {
      localObject1 = DECODE;
      int n = localObject1.length;
      if (i >= n)
        break;
      localObject2 = DECODE;
      int i3 = -1;
      localObject2[i] = i3;
      i += 1;
    }
    i = 0;
    Object localObject3;
    int i6;
    while (true)
    {
      localObject2 = WHITESPACE;
      int i1 = localObject2.length;
      if (i >= i1)
        break;
      localObject3 = DECODE;
      char[] arrayOfChar2 = WHITESPACE;
      int i4 = arrayOfChar2[i];
      i6 = -2;
      localObject3[i4] = i6;
      i += 1;
    }
    i = 0;
    while (true)
    {
      localObject3 = ALPHABET;
      int i2 = localObject3.length;
      if (i >= i2)
        break;
      byte[] arrayOfByte2 = DECODE;
      char[] arrayOfChar3 = ALPHABET;
      int i5 = arrayOfChar3[i];
      i6 = (byte)i;
      arrayOfByte2[i5] = i6;
      i += 1;
    }
  }

  public static byte[] decodeWebSafe(String paramString)
    throws Base64DecodingException
  {
    char[] arrayOfChar = paramString.toCharArray();
    int n = arrayOfChar.length;
    int i7 = n + -1;
    i7 = arrayOfChar[i7];
    int i10 = 61;
    if (i7 == i10)
      n += -1;
    i7 = n + -1;
    i7 = arrayOfChar[i7];
    i10 = 61;
    if (i7 == i10)
      n += -1;
    int i6 = 0;
    i10 = arrayOfChar.length;
    i7 = 0;
    boolean bool2;
    while (i7 < i10)
    {
      int k = arrayOfChar[i7];
      bool2 = isWhiteSpace(k);
      if (bool2)
        i6 += 1;
      i7 += 1;
    }
    n -= i6;
    int i1 = n / 4;
    int i5 = n % 4;
    int i4 = i1 * 3;
    byte[] arrayOfByte;
    int j;
    int i;
    int i2;
    int m;
    int i3;
    switch (i5)
    {
    default:
      arrayOfByte = new byte[i4];
      j = 0;
      i = 0;
      i2 = 0;
      m = 0;
      i3 = i2;
      label196: i7 = n + i6;
      if (m < i7)
      {
        i7 = arrayOfChar[m];
        boolean bool1 = isWhiteSpace(i7);
        if (!bool1)
        {
          i8 = j << 6;
          i10 = arrayOfChar[m];
          i10 = getByte(i10);
          j = i8 | i10;
          i += 1;
        }
        int i8 = 4;
        if (i != i8)
          break label523;
        i2 = i3 + 1;
        i8 = j >> 16;
        i8 = (byte)i8;
        arrayOfByte[i3] = i8;
        i3 = i2 + 1;
        i8 = j >> 8;
        i8 = (byte)i8;
        arrayOfByte[i2] = i8;
        i2 = i3 + 1;
        i8 = (byte)j;
        arrayOfByte[i3] = i8;
        j = 0;
        i = 0;
      }
      break;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      m += 1;
      i3 = i2;
      break label196;
      Base64DecodingException localBase64DecodingException = new org/keyczar/exceptions/Base64DecodingException;
      String str = "Base64Coder.IllegalLength";
      bool2 = true;
      Object[] arrayOfObject = new Object[bool2];
      int i11 = 0;
      Integer localInteger = Integer.valueOf(n);
      arrayOfObject[i11] = localInteger;
      str = Messages.getString(str, arrayOfObject);
      localBase64DecodingException.<init>(str);
      throw localBase64DecodingException;
      i4 += 1;
      break;
      i4 += 2;
      break;
      switch (i)
      {
      default:
        i2 = i3;
      case 2:
      case 3:
      }
      while (true)
      {
        return arrayOfByte;
        int i9 = j >> 4;
        i9 = (byte)i9;
        arrayOfByte[i3] = i9;
        i2 = i3;
        continue;
        i2 = i3 + 1;
        i9 = j >> 10;
        i9 = (byte)i9;
        arrayOfByte[i3] = i9;
        i9 = j >> 2;
        i9 = (byte)i9;
        arrayOfByte[i2] = i9;
      }
      label523: i2 = i3;
    }
  }

  public static String encodeWebSafe(byte[] paramArrayOfByte)
  {
    int i14 = 2;
    int i5 = paramArrayOfByte.length;
    int n = i5 / 3;
    i5 = paramArrayOfByte.length;
    int i4 = i5 % 3;
    int i3 = n << 2;
    switch (i4)
    {
    default:
    case 1:
    case 2:
    }
    char[] arrayOfChar1;
    int k;
    int m;
    int i2;
    int i13;
    int i;
    int i9;
    while (true)
    {
      arrayOfChar1 = new char[i3];
      i1 = 0;
      k = 0;
      int j = 0;
      m = k;
      i2 = i1;
      while (j < n)
      {
        k = m + 1;
        i5 = paramArrayOfByte[m];
        i5 += 255;
        i5 <<= 16;
        m = k + 1;
        i13 = paramArrayOfByte[k];
        i13 += 255;
        i13 <<= 8;
        i5 |= i13;
        k = m + 1;
        i13 = paramArrayOfByte[m];
        i13 += 255;
        i = i5 | i13;
        i1 = i2 + 1;
        char[] arrayOfChar2 = ALPHABET;
        i13 = i >> 18;
        i13 &= 63;
        int i6 = arrayOfChar2[i13];
        arrayOfChar1[i2] = i6;
        i2 = i1 + 1;
        char[] arrayOfChar3 = ALPHABET;
        i13 = i >> 12;
        i13 &= 63;
        int i7 = arrayOfChar3[i13];
        arrayOfChar1[i1] = i7;
        i1 = i2 + 1;
        char[] arrayOfChar4 = ALPHABET;
        i13 = i >> 6;
        i13 &= 63;
        int i8 = arrayOfChar4[i13];
        arrayOfChar1[i2] = i8;
        i2 = i1 + 1;
        char[] arrayOfChar5 = ALPHABET;
        i13 = i & 0x3F;
        i9 = arrayOfChar5[i13];
        arrayOfChar1[i1] = i9;
        j += 1;
        m = k;
      }
      i3 += 2;
      continue;
      i3 += 3;
    }
    if (i4 > 0)
    {
      k = m + 1;
      i9 = paramArrayOfByte[m];
      i9 += 255;
      i = i9 << 16;
      if (i4 == i14)
      {
        i9 = paramArrayOfByte[k];
        i9 += 255;
        i9 <<= 8;
        i |= i9;
      }
      i1 = i2 + 1;
      char[] arrayOfChar6 = ALPHABET;
      i13 = i >> 18;
      i13 &= 63;
      int i10 = arrayOfChar6[i13];
      arrayOfChar1[i2] = i10;
      i2 = i1 + 1;
      char[] arrayOfChar7 = ALPHABET;
      i13 = i >> 12;
      i13 &= 63;
      int i11 = arrayOfChar7[i13];
      arrayOfChar1[i1] = i11;
      if (i4 == i14)
      {
        char[] arrayOfChar8 = ALPHABET;
        i13 = i >> 6;
        i13 &= 63;
        int i12 = arrayOfChar8[i13];
        arrayOfChar1[i2] = i12;
      }
    }
    for (int i1 = i2; ; i1 = i2)
    {
      String str = new java/lang/String;
      str.<init>(arrayOfChar1);
      return str;
      k = m;
    }
  }

  private static byte getByte(int paramInt)
    throws Base64DecodingException
  {
    if (paramInt >= 0)
    {
      int i = 127;
      if (paramInt <= i)
      {
        byte[] arrayOfByte = DECODE;
        int j = arrayOfByte[paramInt];
        int k = -1;
        if (j != k)
          break label70;
      }
    }
    Object localObject = new org/keyczar/exceptions/Base64DecodingException;
    String str = "Base64Coder.IllegalCharacter";
    int m = 1;
    Object[] arrayOfObject = new Object[m];
    int n = 0;
    Integer localInteger = Integer.valueOf(paramInt);
    arrayOfObject[n] = localInteger;
    str = Messages.getString(str, arrayOfObject);
    ((Base64DecodingException)localObject).<init>(str);
    throw ((Throwable)localObject);
    label70: localObject = DECODE;
    byte b = localObject[paramInt];
    return b;
  }

  private static boolean isWhiteSpace(int paramInt)
  {
    byte[] arrayOfByte = DECODE;
    int i = arrayOfByte[paramInt];
    int k = -2;
    if (i == k);
    int j;
    for (i = 1; ; j = 0)
      return i;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.util.Base64Coder
 * JD-Core Version:    0.6.2
 */
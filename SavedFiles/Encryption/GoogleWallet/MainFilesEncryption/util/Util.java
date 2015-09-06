package org.keyczar.util;

import com.google.gson.Gson;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.keyczar.exceptions.Base64DecodingException;
import org.keyczar.exceptions.KeyczarException;

public final class Util
{
  private static final ConcurrentLinkedQueue DIGEST_QUEUE;
  private static final ThreadLocal GSON_THREAD_LOCAL = (ThreadLocal)localObject;
  private static final ConcurrentLinkedQueue RAND_QUEUE;

  static
  {
    Object localObject = new java/util/concurrent/ConcurrentLinkedQueue;
    ((ConcurrentLinkedQueue)localObject).<init>();
    DIGEST_QUEUE = (ConcurrentLinkedQueue)localObject;
    localObject = new java/util/concurrent/ConcurrentLinkedQueue;
    ((ConcurrentLinkedQueue)localObject).<init>();
    RAND_QUEUE = (ConcurrentLinkedQueue)localObject;
    localObject = new org/keyczar/util/Util$1;
    ((Util.1)localObject).<init>();
  }

  public static byte[] cat(byte[][] paramArrayOfByte)
  {
    int m = 0;
    int i = 0;
    int n = paramArrayOfByte.length;
    int k = m;
    byte[] arrayOfByte1;
    int i1;
    while (k < n)
    {
      arrayOfByte1 = paramArrayOfByte[k];
      i1 = arrayOfByte1.length;
      i += i1;
      k += 1;
    }
    byte[] arrayOfByte2 = new byte[i];
    int j = 0;
    n = paramArrayOfByte.length;
    k = m;
    while (k < n)
    {
      arrayOfByte1 = paramArrayOfByte[k];
      i1 = arrayOfByte1.length;
      System.arraycopy(arrayOfByte1, m, arrayOfByte2, j, i1);
      i1 = arrayOfByte1.length;
      j += i1;
      k += 1;
    }
    return arrayOfByte2;
  }

  public static BigInteger decodeBigInteger(String paramString)
    throws Base64DecodingException
  {
    BigInteger localBigInteger = new java/math/BigInteger;
    byte[] arrayOfByte = Base64Coder.decodeWebSafe(paramString);
    localBigInteger.<init>(arrayOfByte);
    return localBigInteger;
  }

  public static byte[] fromInt(int paramInt)
  {
    int i = 4;
    byte[] arrayOfByte = new byte[i];
    i = 0;
    writeInt(paramInt, arrayOfByte, i);
    return arrayOfByte;
  }

  public static Gson gson()
  {
    Object localObject = GSON_THREAD_LOCAL;
    localObject = ((ThreadLocal)localObject).get();
    localObject = (Gson)localObject;
    return localObject;
  }

  public static byte[] hash(byte[][] paramArrayOfByte)
    throws KeyczarException
  {
    Object localObject2 = DIGEST_QUEUE;
    Object localObject1 = ((ConcurrentLinkedQueue)localObject2).poll();
    localObject1 = (MessageDigest)localObject1;
    if (localObject1 == null);
    try
    {
      localObject2 = "SHA-1";
      localObject1 = MessageDigest.getInstance((String)localObject2);
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        byte[] arrayOfByte1 = paramArrayOfByte[i];
        ((MessageDigest)localObject1).update(arrayOfByte1);
        i += 1;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localObject3 = new org/keyczar/exceptions/KeyczarException;
      ((KeyczarException)localObject3).<init>(localNoSuchAlgorithmException);
      throw ((Throwable)localObject3);
    }
    byte[] arrayOfByte2 = ((MessageDigest)localObject1).digest();
    Object localObject3 = DIGEST_QUEUE;
    ((ConcurrentLinkedQueue)localObject3).add(localObject1);
    return arrayOfByte2;
  }

  public static byte[] lenPrefix(byte[] paramArrayOfByte)
  {
    int i;
    if (paramArrayOfByte != null)
    {
      i = paramArrayOfByte.length;
      if (i != 0);
    }
    else
    {
      i = 0;
    }
    Object localObject;
    for (byte[] arrayOfByte = fromInt(i); ; localObject = ((ByteBuffer)localObject).array())
    {
      return arrayOfByte;
      int j = paramArrayOfByte.length;
      j += 4;
      localObject = ByteBuffer.allocate(j);
      int k = paramArrayOfByte.length;
      localObject = ((ByteBuffer)localObject).putInt(k);
      localObject = ((ByteBuffer)localObject).put(paramArrayOfByte);
    }
  }

  public static byte[] lenPrefixPack(byte[][] paramArrayOfByte)
  {
    int j = 0;
    int k = paramArrayOfByte.length;
    k += 1;
    int i = k << 2;
    int m = paramArrayOfByte.length;
    k = j;
    byte[] arrayOfByte1;
    while (k < m)
    {
      arrayOfByte1 = paramArrayOfByte[k];
      int n = arrayOfByte1.length;
      i += n;
      k += 1;
    }
    byte[] arrayOfByte2 = new byte[i];
    ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte2);
    k = paramArrayOfByte.length;
    localByteBuffer.putInt(k);
    k = paramArrayOfByte.length;
    while (j < k)
    {
      arrayOfByte1 = paramArrayOfByte[j];
      m = arrayOfByte1.length;
      localByteBuffer.putInt(m);
      localByteBuffer.put(arrayOfByte1);
      j += 1;
    }
    return arrayOfByte2;
  }

  public static byte[] prefixHash(byte[][] paramArrayOfByte)
    throws KeyczarException
  {
    Object localObject2 = DIGEST_QUEUE;
    Object localObject1 = ((ConcurrentLinkedQueue)localObject2).poll();
    localObject1 = (MessageDigest)localObject1;
    if (localObject1 == null);
    try
    {
      localObject2 = "SHA-1";
      localObject1 = MessageDigest.getInstance((String)localObject2);
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        byte[] arrayOfByte1 = paramArrayOfByte[i];
        int k = arrayOfByte1.length;
        byte[] arrayOfByte3 = fromInt(k);
        ((MessageDigest)localObject1).update(arrayOfByte3);
        ((MessageDigest)localObject1).update(arrayOfByte1);
        i += 1;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localObject3 = new org/keyczar/exceptions/KeyczarException;
      ((KeyczarException)localObject3).<init>(localNoSuchAlgorithmException);
      throw ((Throwable)localObject3);
    }
    byte[] arrayOfByte2 = ((MessageDigest)localObject1).digest();
    Object localObject3 = DIGEST_QUEUE;
    ((ConcurrentLinkedQueue)localObject3).add(localObject1);
    return arrayOfByte2;
  }

  public static void rand(byte[] paramArrayOfByte)
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue = RAND_QUEUE;
    Object localObject = localConcurrentLinkedQueue.poll();
    localObject = (SecureRandom)localObject;
    if (localObject == null)
    {
      localObject = new java/security/SecureRandom;
      ((SecureRandom)localObject).<init>();
    }
    ((SecureRandom)localObject).nextBytes(paramArrayOfByte);
    localConcurrentLinkedQueue = RAND_QUEUE;
    localConcurrentLinkedQueue.add(localObject);
  }

  public static byte[] rand(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    rand(arrayOfByte);
    return arrayOfByte;
  }

  private static int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    int k = paramArrayOfByte[paramInt];
    k += 255;
    k <<= 24;
    int j = k | 0x0;
    paramInt = i + 1;
    k = paramArrayOfByte[i];
    k += 255;
    k <<= 16;
    j |= k;
    i = paramInt + 1;
    k = paramArrayOfByte[paramInt];
    k += 255;
    k <<= 8;
    j |= k;
    k = paramArrayOfByte[i];
    k += 255;
    j |= k;
    return j;
  }

  public static boolean safeArrayEquals(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null))
      if (paramArrayOfByte1 == paramArrayOfByte2)
        bool1 = bool2;
    while (true)
    {
      return bool1;
      int k = paramArrayOfByte1.length;
      int m = paramArrayOfByte2.length;
      if (k == m)
      {
        int j = 0;
        int i = 0;
        while (true)
        {
          k = paramArrayOfByte1.length;
          if (i >= k)
            break;
          k = paramArrayOfByte1[i];
          m = paramArrayOfByte2[i];
          k ^= m;
          k |= j;
          j = (byte)k;
          i += 1;
        }
        if (j == 0)
          bool1 = bool2;
      }
    }
  }

  public static byte[] stripLeadingZeros(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j;
    while (true)
    {
      j = paramArrayOfByte.length;
      if (i >= j)
        break;
      j = paramArrayOfByte[i];
      if (j != 0)
        break;
      i += 1;
    }
    if (i == 0);
    while (true)
    {
      return paramArrayOfByte;
      j = paramArrayOfByte.length;
      j -= i;
      byte[] arrayOfByte = new byte[j];
      j = 0;
      int k = arrayOfByte.length;
      System.arraycopy(paramArrayOfByte, i, arrayOfByte, j, k);
      paramArrayOfByte = arrayOfByte;
    }
  }

  public static int toInt(byte[] paramArrayOfByte)
  {
    int i = 0;
    i = readInt(paramArrayOfByte, i);
    return i;
  }

  private static void writeInt(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt2 + 1;
    int j = paramInt1 >> 24;
    paramArrayOfByte[paramInt2] = j;
    paramInt2 = i + 1;
    j = paramInt1 >> 16;
    j = (byte)j;
    paramArrayOfByte[i] = j;
    i = paramInt2 + 1;
    j = paramInt1 >> 8;
    j = (byte)j;
    paramArrayOfByte[paramInt2] = j;
    j = (byte)paramInt1;
    paramArrayOfByte[i] = j;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.util.Util
 * JD-Core Version:    0.6.2
 */
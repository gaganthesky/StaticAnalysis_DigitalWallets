package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class o
{
  private final SecureRandom kZ;
  private final m ky;

  public o(m paramm, SecureRandom paramSecureRandom)
  {
    this.ky = paramm;
    this.kZ = paramSecureRandom;
  }

  public byte[] b(String paramString)
    throws o.a
  {
    try
    {
      Object localObject = this.ky;
      boolean bool = false;
      localObject = ((m)localObject).a(paramString, bool);
      int i = localObject.length;
      k = 32;
      if (i != k)
      {
        localObject = new com/google/android/gms/internal/o$a;
        ((o.a)localObject).<init>(this);
        throw ((Throwable)localObject);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      o.a locala = new com/google/android/gms/internal/o$a;
      locala.<init>(this, localIllegalArgumentException);
      throw locala;
    }
    int j = 4;
    int k = 16;
    ByteBuffer localByteBuffer = ByteBuffer.wrap(localIllegalArgumentException, j, k);
    j = 16;
    byte[] arrayOfByte = new byte[j];
    localByteBuffer.get(arrayOfByte);
    c(arrayOfByte);
    return arrayOfByte;
  }

  static void c(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (true)
    {
      int j = paramArrayOfByte.length;
      if (i >= j)
        break;
      j = paramArrayOfByte[i];
      j ^= 68;
      j = (byte)j;
      paramArrayOfByte[i] = j;
      i += 1;
    }
  }

  public byte[] c(byte[] paramArrayOfByte, String paramString)
    throws o.a
  {
    int n = 16;
    int i = paramArrayOfByte.length;
    Object localObject1;
    if (i != n)
    {
      localObject1 = new com/google/android/gms/internal/o$a;
      ((o.a)localObject1).<init>(this);
      throw ((Throwable)localObject1);
    }
    Object localObject2;
    try
    {
      localObject1 = this.ky;
      boolean bool = false;
      localObject1 = ((m)localObject1).a(paramString, bool);
      int k = localObject1.length;
      if (k <= n)
      {
        localObject1 = new com/google/android/gms/internal/o$a;
        ((o.a)localObject1).<init>(this);
        throw ((Throwable)localObject1);
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      o.a locala = new com/google/android/gms/internal/o$a;
      locala.<init>(this, localNoSuchAlgorithmException);
      throw locala;
      int m = localNoSuchAlgorithmException.length;
      localObject2 = ByteBuffer.allocate(m);
      ((ByteBuffer)localObject2).put(localNoSuchAlgorithmException);
      ((ByteBuffer)localObject2).flip();
      n = 16;
      byte[] arrayOfByte2 = new byte[n];
      int j = localNoSuchAlgorithmException.length;
      j += -16;
      byte[] arrayOfByte1 = new byte[j];
      ((ByteBuffer)localObject2).get(arrayOfByte2);
      ((ByteBuffer)localObject2).get(arrayOfByte1);
      localObject2 = new javax/crypto/spec/SecretKeySpec;
      Object localObject3 = "AES";
      ((SecretKeySpec)localObject2).<init>(paramArrayOfByte, (String)localObject3);
      localObject3 = "AES/CBC/PKCS5Padding";
      localObject3 = Cipher.getInstance((String)localObject3);
      int i1 = 2;
      IvParameterSpec localIvParameterSpec = new javax/crypto/spec/IvParameterSpec;
      localIvParameterSpec.<init>(arrayOfByte2);
      ((Cipher)localObject3).init(i1, (Key)localObject2, localIvParameterSpec);
      arrayOfByte1 = ((Cipher)localObject3).doFinal(arrayOfByte1);
      return arrayOfByte1;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      localObject2 = new com/google/android/gms/internal/o$a;
      ((o.a)localObject2).<init>(this, localInvalidKeyException);
      throw ((Throwable)localObject2);
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      localObject2 = new com/google/android/gms/internal/o$a;
      ((o.a)localObject2).<init>(this, localIllegalBlockSizeException);
      throw ((Throwable)localObject2);
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      localObject2 = new com/google/android/gms/internal/o$a;
      ((o.a)localObject2).<init>(this, localNoSuchPaddingException);
      throw ((Throwable)localObject2);
    }
    catch (BadPaddingException localBadPaddingException)
    {
      localObject2 = new com/google/android/gms/internal/o$a;
      ((o.a)localObject2).<init>(this, localBadPaddingException);
      throw ((Throwable)localObject2);
    }
    catch (InvalidAlgorithmParameterException localInvalidAlgorithmParameterException)
    {
      localObject2 = new com/google/android/gms/internal/o$a;
      ((o.a)localObject2).<init>(this, localInvalidAlgorithmParameterException);
      throw ((Throwable)localObject2);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localObject2 = new com/google/android/gms/internal/o$a;
      ((o.a)localObject2).<init>(this, localIllegalArgumentException);
    }
    throw ((Throwable)localObject2);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Dwolla/retargeted/com.dwolla.dwolla/
 * Qualified Name:     com.google.android.gms.internal.o
 * JD-Core Version:    0.6.2
 */
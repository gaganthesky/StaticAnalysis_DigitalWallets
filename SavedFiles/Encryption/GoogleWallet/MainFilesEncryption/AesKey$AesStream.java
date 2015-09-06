package org.keyczar;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.keyczar.enums.CipherMode;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.DecryptingStream;
import org.keyczar.interfaces.EncryptingStream;
import org.keyczar.interfaces.SigningStream;
import org.keyczar.interfaces.VerifyingStream;
import org.keyczar.util.Util;

final class AesKey$AesStream
  implements DecryptingStream, EncryptingStream
{
  private final Cipher decryptingCipher;
  private final Cipher encryptingCipher;
  boolean ivRead;
  private final SigningStream signStream;
  final AesKey this$0;

  public AesKey$AesStream(AesKey paramAesKey)
    throws KeyczarException
  {
    int i = 0;
    this.ivRead = i;
    IvParameterSpec localIvParameterSpec = new javax/crypto/spec/IvParameterSpec;
    i = 16;
    Object localObject = new byte[i];
    localIvParameterSpec.<init>((byte[])localObject);
    try
    {
      localObject = AesKey.access$000(paramAesKey);
      localObject = ((CipherMode)localObject).getMode();
      localObject = Cipher.getInstance((String)localObject);
      this.encryptingCipher = ((Cipher)localObject);
      localObject = this.encryptingCipher;
      int j = 1;
      SecretKey localSecretKey = AesKey.access$100(paramAesKey);
      ((Cipher)localObject).init(j, localSecretKey, localIvParameterSpec);
      localObject = AesKey.access$000(paramAesKey);
      localObject = ((CipherMode)localObject).getMode();
      localObject = Cipher.getInstance((String)localObject);
      this.decryptingCipher = ((Cipher)localObject);
      localObject = this.decryptingCipher;
      j = 2;
      localSecretKey = AesKey.access$100(paramAesKey);
      ((Cipher)localObject).init(j, localSecretKey, localIvParameterSpec);
      localObject = AesKey.access$200(paramAesKey);
      localObject = ((HmacKey)localObject).getStream();
      localObject = (SigningStream)localObject;
      this.signStream = ((SigningStream)localObject);
      return;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      localObject = new org/keyczar/exceptions/KeyczarException;
      ((KeyczarException)localObject).<init>(localGeneralSecurityException);
    }
    throw ((Throwable)localObject);
  }

  public final int doFinalDecrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws KeyczarException
  {
    int i = 0;
    boolean bool = this.ivRead;
    int m;
    if (bool)
    {
      m = paramByteBuffer1.remaining();
      if (m != 0);
    }
    while (true)
    {
      return i;
      m = 16;
      byte[] arrayOfByte2 = new byte[m];
      paramByteBuffer1.get(arrayOfByte2);
      Cipher localCipher3 = this.decryptingCipher;
      localCipher3.update(arrayOfByte2);
      this.ivRead = i;
      try
      {
        i = paramByteBuffer1.remaining();
        if (i == 0)
        {
          Cipher localCipher1 = this.decryptingCipher;
          byte[] arrayOfByte1 = localCipher1.doFinal();
          paramByteBuffer2.put(arrayOfByte1);
          int j = arrayOfByte1.length;
          continue;
        }
        Cipher localCipher2 = this.decryptingCipher;
        int k = localCipher2.doFinal(paramByteBuffer1, paramByteBuffer2);
      }
      catch (GeneralSecurityException localGeneralSecurityException)
      {
        KeyczarException localKeyczarException = new org/keyczar/exceptions/KeyczarException;
        localKeyczarException.<init>(localGeneralSecurityException);
        throw localKeyczarException;
      }
    }
  }

  public final int doFinalEncrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws KeyczarException
  {
    try
    {
      Cipher localCipher = this.encryptingCipher;
      int i = localCipher.doFinal(paramByteBuffer1, paramByteBuffer2);
      return i;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      KeyczarException localKeyczarException = new org/keyczar/exceptions/KeyczarException;
      localKeyczarException.<init>(localGeneralSecurityException);
      throw localKeyczarException;
    }
  }

  public final SigningStream getSigningStream()
  {
    SigningStream localSigningStream = this.signStream;
    return localSigningStream;
  }

  public final VerifyingStream getVerifyingStream()
  {
    Object localObject = this.signStream;
    localObject = (VerifyingStream)localObject;
    return localObject;
  }

  public final void initDecrypt(ByteBuffer paramByteBuffer)
  {
    int i = 16;
    byte[] arrayOfByte = new byte[i];
    paramByteBuffer.get(arrayOfByte);
    Cipher localCipher = this.decryptingCipher;
    localCipher.update(arrayOfByte);
    boolean bool = true;
    this.ivRead = bool;
  }

  public final int initEncrypt(ByteBuffer paramByteBuffer)
    throws KeyczarException
  {
    int i = 16;
    byte[] arrayOfByte = new byte[i];
    Util.rand(arrayOfByte);
    try
    {
      Cipher localCipher = this.encryptingCipher;
      ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
      int j = localCipher.update(localByteBuffer, paramByteBuffer);
      return j;
    }
    catch (javax.crypto.ShortBufferException localShortBufferException)
    {
      org.keyczar.exceptions.ShortBufferException localShortBufferException1 = new org/keyczar/exceptions/ShortBufferException;
      localShortBufferException1.<init>(localShortBufferException);
      throw localShortBufferException1;
    }
  }

  public final int maxOutputSize(int paramInt)
  {
    Object localObject = this.this$0;
    localObject = AesKey.access$000((AesKey)localObject);
    int j = 16;
    int i = ((CipherMode)localObject).getOutputSize(j, paramInt);
    return i;
  }

  public final int updateDecrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws KeyczarException
  {
    int k = 16;
    boolean bool1 = this.ivRead;
    if (bool1)
    {
      int i = paramByteBuffer1.remaining();
      if (i >= k)
      {
        byte[] arrayOfByte = new byte[k];
        paramByteBuffer1.get(arrayOfByte);
        Cipher localCipher1 = this.decryptingCipher;
        localCipher1.update(arrayOfByte);
        boolean bool2 = false;
        this.ivRead = bool2;
      }
    }
    try
    {
      Cipher localCipher2 = this.decryptingCipher;
      int j = localCipher2.update(paramByteBuffer1, paramByteBuffer2);
      return j;
    }
    catch (javax.crypto.ShortBufferException localShortBufferException)
    {
      org.keyczar.exceptions.ShortBufferException localShortBufferException1 = new org/keyczar/exceptions/ShortBufferException;
      localShortBufferException1.<init>(localShortBufferException);
      throw localShortBufferException1;
    }
  }

  public final int updateEncrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws KeyczarException
  {
    try
    {
      Cipher localCipher = this.encryptingCipher;
      int i = localCipher.update(paramByteBuffer1, paramByteBuffer2);
      return i;
    }
    catch (javax.crypto.ShortBufferException localShortBufferException)
    {
      org.keyczar.exceptions.ShortBufferException localShortBufferException1 = new org/keyczar/exceptions/ShortBufferException;
      localShortBufferException1.<init>(localShortBufferException);
      throw localShortBufferException1;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.AesKey.AesStream
 * JD-Core Version:    0.6.2
 */
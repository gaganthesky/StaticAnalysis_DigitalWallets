package org.keyczar;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;
import org.keyczar.enums.RsaPadding;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.EncryptingStream;
import org.keyczar.interfaces.SigningStream;
import org.keyczar.interfaces.VerifyingStream;

final class RsaPublicKey$RsaStream
  implements EncryptingStream, VerifyingStream
{
  private Cipher cipher;
  private Signature signature;
  final RsaPublicKey this$0;

  RsaPublicKey$RsaStream(RsaPublicKey paramRsaPublicKey)
    throws KeyczarException
  {
    Object localObject;
    try
    {
      localObject = "SHA1withRSA";
      localObject = Signature.getInstance((String)localObject);
      this.signature = ((Signature)localObject);
      localObject = paramRsaPublicKey.getPadding();
      localObject = ((RsaPadding)localObject).getCryptAlgorithm();
      localObject = Cipher.getInstance((String)localObject);
      this.cipher = ((Cipher)localObject);
      return;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      localObject = new org/keyczar/exceptions/KeyczarException;
      ((KeyczarException)localObject).<init>(localGeneralSecurityException);
    }
    throw ((Throwable)localObject);
  }

  public final int digestSize()
  {
    RsaPublicKey localRsaPublicKey = this.this$0;
    int i = localRsaPublicKey.keySizeInBytes();
    return i;
  }

  public final int doFinalEncrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws KeyczarException
  {
    int i;
    int j;
    try
    {
      Cipher localCipher = this.cipher;
      int i1 = paramByteBuffer1.limit();
      i = localCipher.getOutputSize(i1);
      int k = paramByteBuffer2.limit();
      i1 = paramByteBuffer2.position();
      j = k - i1;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
      Object localObject1 = this.cipher;
      ((Cipher)localObject1).doFinal(paramByteBuffer1, localByteBuffer);
      if (i == j)
      {
        localObject1 = localByteBuffer.array();
        paramByteBuffer2.put((byte[])localObject1);
      }
      while (true)
      {
        return j;
        int m = j + 1;
        if (i != m)
          break;
        byte[] arrayOfByte = localByteBuffer.array();
        i1 = i + -1;
        int n = arrayOfByte[i1];
        if (n != 0)
          break;
        localObject2 = localByteBuffer.array();
        i1 = 0;
        paramByteBuffer2.put((byte[])localObject2, i1, j);
      }
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      localObject2 = new org/keyczar/exceptions/KeyczarException;
      ((KeyczarException)localObject2).<init>(localGeneralSecurityException);
      throw ((Throwable)localObject2);
    }
    Object localObject2 = new org/keyczar/exceptions/KeyczarException;
    Object localObject3 = new java/lang/StringBuilder;
    int i2 = 72;
    ((StringBuilder)localObject3).<init>(i2);
    String str = "Expected ";
    localObject3 = ((StringBuilder)localObject3).append(str);
    localObject3 = ((StringBuilder)localObject3).append(j);
    str = " bytes from encryption operation but got ";
    localObject3 = ((StringBuilder)localObject3).append(str);
    localObject3 = ((StringBuilder)localObject3).append(i);
    localObject3 = ((StringBuilder)localObject3).toString();
    ((KeyczarException)localObject2).<init>((String)localObject3);
    throw ((Throwable)localObject2);
  }

  public final SigningStream getSigningStream()
  {
    RsaPublicKey.RsaStream.1 local1 = new org/keyczar/RsaPublicKey$RsaStream$1;
    local1.<init>(this);
    return local1;
  }

  public final int initEncrypt(ByteBuffer paramByteBuffer)
    throws KeyczarException
  {
    try
    {
      Cipher localCipher = this.cipher;
      int j = 1;
      Object localObject = this.this$0;
      localObject = RsaPublicKey.access$000((RsaPublicKey)localObject);
      localCipher.init(j, (Key)localObject);
      int i = 0;
      return i;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      KeyczarException localKeyczarException = new org/keyczar/exceptions/KeyczarException;
      localKeyczarException.<init>(localInvalidKeyException);
      throw localKeyczarException;
    }
  }

  public final void initVerify()
    throws KeyczarException
  {
    Object localObject1;
    try
    {
      localObject1 = this.signature;
      Object localObject2 = this.this$0;
      localObject2 = RsaPublicKey.access$000((RsaPublicKey)localObject2);
      ((Signature)localObject1).initVerify((PublicKey)localObject2);
      return;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      localObject1 = new org/keyczar/exceptions/KeyczarException;
      ((KeyczarException)localObject1).<init>(localGeneralSecurityException);
    }
    throw ((Throwable)localObject1);
  }

  public final int maxOutputSize(int paramInt)
  {
    RsaPublicKey localRsaPublicKey = this.this$0;
    int i = localRsaPublicKey.keySizeInBytes();
    return i;
  }

  public final int updateEncrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws KeyczarException
  {
    try
    {
      Cipher localCipher = this.cipher;
      int i = localCipher.update(paramByteBuffer1, paramByteBuffer2);
      return i;
    }
    catch (ShortBufferException localShortBufferException)
    {
      KeyczarException localKeyczarException = new org/keyczar/exceptions/KeyczarException;
      localKeyczarException.<init>(localShortBufferException);
      throw localKeyczarException;
    }
  }

  public final void updateVerify(ByteBuffer paramByteBuffer)
    throws KeyczarException
  {
    Object localObject;
    try
    {
      localObject = this.signature;
      ((Signature)localObject).update(paramByteBuffer);
      return;
    }
    catch (SignatureException localSignatureException)
    {
      localObject = new org/keyczar/exceptions/KeyczarException;
      ((KeyczarException)localObject).<init>(localSignatureException);
    }
    throw ((Throwable)localObject);
  }

  public final boolean verify(ByteBuffer paramByteBuffer)
    throws KeyczarException
  {
    try
    {
      Signature localSignature = this.signature;
      byte[] arrayOfByte = paramByteBuffer.array();
      int i = paramByteBuffer.position();
      int j = paramByteBuffer.limit();
      int k = paramByteBuffer.position();
      j -= k;
      boolean bool = localSignature.verify(arrayOfByte, i, j);
      return bool;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      KeyczarException localKeyczarException = new org/keyczar/exceptions/KeyczarException;
      localKeyczarException.<init>(localGeneralSecurityException);
      throw localKeyczarException;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.RsaPublicKey.RsaStream
 * JD-Core Version:    0.6.2
 */
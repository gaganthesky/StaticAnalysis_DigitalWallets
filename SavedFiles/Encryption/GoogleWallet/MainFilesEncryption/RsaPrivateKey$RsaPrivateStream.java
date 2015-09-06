package org.keyczar;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;
import org.keyczar.enums.RsaPadding;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.DecryptingStream;
import org.keyczar.interfaces.EncryptingStream;
import org.keyczar.interfaces.SigningStream;
import org.keyczar.interfaces.VerifyingStream;

final class RsaPrivateKey$RsaPrivateStream
  implements DecryptingStream, EncryptingStream, SigningStream, VerifyingStream
{
  private Cipher cipher;
  private EncryptingStream encryptingStream;
  private Signature signature;
  final RsaPrivateKey this$0;
  private VerifyingStream verifyingStream;

  public RsaPrivateKey$RsaPrivateStream(RsaPrivateKey paramRsaPrivateKey)
    throws KeyczarException
  {
    Object localObject;
    try
    {
      localObject = "SHA1withRSA";
      localObject = Signature.getInstance((String)localObject);
      this.signature = ((Signature)localObject);
      localObject = RsaPrivateKey.access$000(paramRsaPrivateKey);
      localObject = ((RsaPublicKey)localObject).getStream();
      localObject = (VerifyingStream)localObject;
      this.verifyingStream = ((VerifyingStream)localObject);
      localObject = RsaPrivateKey.access$000(paramRsaPrivateKey);
      localObject = ((RsaPublicKey)localObject).getPadding();
      localObject = ((RsaPadding)localObject).getCryptAlgorithm();
      localObject = Cipher.getInstance((String)localObject);
      this.cipher = ((Cipher)localObject);
      localObject = RsaPrivateKey.access$000(paramRsaPrivateKey);
      localObject = ((RsaPublicKey)localObject).getStream();
      localObject = (EncryptingStream)localObject;
      this.encryptingStream = ((EncryptingStream)localObject);
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
    Object localObject = this.this$0;
    localObject = RsaPrivateKey.access$000((RsaPrivateKey)localObject);
    int i = ((RsaPublicKey)localObject).keySizeInBytes();
    return i;
  }

  public final int doFinalDecrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws KeyczarException
  {
    try
    {
      Cipher localCipher = this.cipher;
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

  public final int doFinalEncrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws KeyczarException
  {
    EncryptingStream localEncryptingStream = this.encryptingStream;
    int i = localEncryptingStream.doFinalEncrypt(paramByteBuffer1, paramByteBuffer2);
    return i;
  }

  public final SigningStream getSigningStream()
    throws KeyczarException
  {
    Object localObject = this.encryptingStream;
    localObject = ((EncryptingStream)localObject).getSigningStream();
    return localObject;
  }

  public final VerifyingStream getVerifyingStream()
  {
    RsaPrivateKey.RsaPrivateStream.1 local1 = new org/keyczar/RsaPrivateKey$RsaPrivateStream$1;
    local1.<init>(this);
    return local1;
  }

  public final void initDecrypt(ByteBuffer paramByteBuffer)
    throws KeyczarException
  {
    Object localObject1;
    try
    {
      localObject1 = this.cipher;
      int i = 2;
      Object localObject2 = this.this$0;
      localObject2 = RsaPrivateKey.access$100((RsaPrivateKey)localObject2);
      ((Cipher)localObject1).init(i, (Key)localObject2);
      return;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      localObject1 = new org/keyczar/exceptions/KeyczarException;
      ((KeyczarException)localObject1).<init>(localInvalidKeyException);
    }
    throw ((Throwable)localObject1);
  }

  public final int initEncrypt(ByteBuffer paramByteBuffer)
    throws KeyczarException
  {
    EncryptingStream localEncryptingStream = this.encryptingStream;
    int i = localEncryptingStream.initEncrypt(paramByteBuffer);
    return i;
  }

  public final void initSign()
    throws KeyczarException
  {
    Object localObject1;
    try
    {
      localObject1 = this.signature;
      Object localObject2 = this.this$0;
      localObject2 = RsaPrivateKey.access$100((RsaPrivateKey)localObject2);
      ((Signature)localObject1).initSign((PrivateKey)localObject2);
      return;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      localObject1 = new org/keyczar/exceptions/KeyczarException;
      ((KeyczarException)localObject1).<init>(localGeneralSecurityException);
    }
    throw ((Throwable)localObject1);
  }

  public final void initVerify()
    throws KeyczarException
  {
    VerifyingStream localVerifyingStream = this.verifyingStream;
    localVerifyingStream.initVerify();
  }

  public final int maxOutputSize(int paramInt)
  {
    Object localObject = this.this$0;
    localObject = RsaPrivateKey.access$000((RsaPrivateKey)localObject);
    int i = ((RsaPublicKey)localObject).keySizeInBytes();
    return i;
  }

  public final void sign(ByteBuffer paramByteBuffer)
    throws KeyczarException
  {
    Object localObject;
    try
    {
      localObject = this.signature;
      byte[] arrayOfByte = ((Signature)localObject).sign();
      paramByteBuffer.put(arrayOfByte);
      return;
    }
    catch (SignatureException localSignatureException)
    {
      localObject = new org/keyczar/exceptions/KeyczarException;
      ((KeyczarException)localObject).<init>(localSignatureException);
    }
    throw ((Throwable)localObject);
  }

  public final int updateDecrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
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

  public final int updateEncrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws KeyczarException
  {
    EncryptingStream localEncryptingStream = this.encryptingStream;
    int i = localEncryptingStream.updateEncrypt(paramByteBuffer1, paramByteBuffer2);
    return i;
  }

  public final void updateSign(ByteBuffer paramByteBuffer)
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

  public final void updateVerify(ByteBuffer paramByteBuffer)
    throws KeyczarException
  {
    VerifyingStream localVerifyingStream = this.verifyingStream;
    localVerifyingStream.updateVerify(paramByteBuffer);
  }

  public final boolean verify(ByteBuffer paramByteBuffer)
    throws KeyczarException
  {
    VerifyingStream localVerifyingStream = this.verifyingStream;
    boolean bool = localVerifyingStream.verify(paramByteBuffer);
    return bool;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.RsaPrivateKey.RsaPrivateStream
 * JD-Core Version:    0.6.2
 */
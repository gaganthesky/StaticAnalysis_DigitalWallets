package org.keyczar;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.SigningStream;
import org.keyczar.interfaces.VerifyingStream;

final class DsaPrivateKey$DsaSigningStream
  implements SigningStream, VerifyingStream
{
  private Signature signature;
  final DsaPrivateKey this$0;
  private VerifyingStream verifyingStream;

  public DsaPrivateKey$DsaSigningStream(DsaPrivateKey paramDsaPrivateKey)
    throws KeyczarException
  {
    Object localObject;
    try
    {
      localObject = "SHA1withDSA";
      localObject = Signature.getInstance((String)localObject);
      this.signature = ((Signature)localObject);
      localObject = DsaPrivateKey.access$000(paramDsaPrivateKey);
      localObject = ((DsaPublicKey)localObject).getStream();
      localObject = (VerifyingStream)localObject;
      this.verifyingStream = ((VerifyingStream)localObject);
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
    int i = 48;
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
      localObject2 = DsaPrivateKey.access$100((DsaPrivateKey)localObject2);
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
 * Qualified Name:     org.keyczar.DsaPrivateKey.DsaSigningStream
 * JD-Core Version:    0.6.2
 */
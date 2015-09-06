package org.keyczar;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.VerifyingStream;

final class DsaPublicKey$DsaVerifyingStream
  implements VerifyingStream
{
  private Signature signature;
  final DsaPublicKey this$0;

  public DsaPublicKey$DsaVerifyingStream(DsaPublicKey paramDsaPublicKey)
    throws KeyczarException
  {
    Object localObject;
    try
    {
      localObject = "SHA1withDSA";
      localObject = Signature.getInstance((String)localObject);
      this.signature = ((Signature)localObject);
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

  public final void initVerify()
    throws KeyczarException
  {
    Object localObject1;
    try
    {
      localObject1 = this.signature;
      Object localObject2 = this.this$0;
      localObject2 = DsaPublicKey.access$000((DsaPublicKey)localObject2);
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
 * Qualified Name:     org.keyczar.DsaPublicKey.DsaVerifyingStream
 * JD-Core Version:    0.6.2
 */
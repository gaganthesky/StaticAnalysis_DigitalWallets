package org.keyczar;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.SigningStream;
import org.keyczar.interfaces.VerifyingStream;
import org.keyczar.util.Util;

final class HmacKey$HmacStream
  implements SigningStream, VerifyingStream
{
  private final Mac hmac;
  final HmacKey this$0;

  public HmacKey$HmacStream(HmacKey paramHmacKey)
    throws KeyczarException
  {
    Object localObject;
    try
    {
      localObject = "HMACSHA1";
      localObject = Mac.getInstance((String)localObject);
      this.hmac = ((Mac)localObject);
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
    int i = 20;
    return i;
  }

  public final void initSign()
    throws KeyczarException
  {
    Object localObject1;
    try
    {
      localObject1 = this.hmac;
      Object localObject2 = this.this$0;
      localObject2 = HmacKey.access$000((HmacKey)localObject2);
      ((Mac)localObject1).init((Key)localObject2);
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
    initSign();
  }

  public final void sign(ByteBuffer paramByteBuffer)
  {
    Object localObject = this.hmac;
    localObject = ((Mac)localObject).doFinal();
    paramByteBuffer.put((byte[])localObject);
  }

  public final void updateSign(ByteBuffer paramByteBuffer)
  {
    Mac localMac = this.hmac;
    localMac.update(paramByteBuffer);
  }

  public final void updateVerify(ByteBuffer paramByteBuffer)
  {
    updateSign(paramByteBuffer);
  }

  public final boolean verify(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    byte[] arrayOfByte = new byte[i];
    paramByteBuffer.get(arrayOfByte);
    Object localObject = this.hmac;
    localObject = ((Mac)localObject).doFinal();
    boolean bool = Util.safeArrayEquals((byte[])localObject, arrayOfByte);
    return bool;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.HmacKey.HmacStream
 * JD-Core Version:    0.6.2
 */
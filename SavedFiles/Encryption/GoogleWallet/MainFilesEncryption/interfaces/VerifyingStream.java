package org.keyczar.interfaces;

import java.nio.ByteBuffer;
import org.keyczar.exceptions.KeyczarException;

public abstract interface VerifyingStream extends Stream
{
  public abstract int digestSize();

  public abstract void initVerify()
    throws KeyczarException;

  public abstract void updateVerify(ByteBuffer paramByteBuffer)
    throws KeyczarException;

  public abstract boolean verify(ByteBuffer paramByteBuffer)
    throws KeyczarException;
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.interfaces.VerifyingStream
 * JD-Core Version:    0.6.2
 */
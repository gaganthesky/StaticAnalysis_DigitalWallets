package org.keyczar.interfaces;

import java.nio.ByteBuffer;
import org.keyczar.exceptions.KeyczarException;

public abstract interface SigningStream extends Stream
{
  public abstract int digestSize();

  public abstract void initSign()
    throws KeyczarException;

  public abstract void sign(ByteBuffer paramByteBuffer)
    throws KeyczarException;

  public abstract void updateSign(ByteBuffer paramByteBuffer)
    throws KeyczarException;
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.interfaces.SigningStream
 * JD-Core Version:    0.6.2
 */
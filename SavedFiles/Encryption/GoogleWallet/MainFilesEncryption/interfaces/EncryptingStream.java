package org.keyczar.interfaces;

import java.nio.ByteBuffer;
import org.keyczar.exceptions.KeyczarException;

public abstract interface EncryptingStream extends Stream
{
  public abstract int doFinalEncrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws KeyczarException;

  public abstract SigningStream getSigningStream()
    throws KeyczarException;

  public abstract int initEncrypt(ByteBuffer paramByteBuffer)
    throws KeyczarException;

  public abstract int maxOutputSize(int paramInt);

  public abstract int updateEncrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws KeyczarException;
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.interfaces.EncryptingStream
 * JD-Core Version:    0.6.2
 */
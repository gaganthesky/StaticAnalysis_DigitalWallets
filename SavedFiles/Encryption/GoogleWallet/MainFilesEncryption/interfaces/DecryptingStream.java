package org.keyczar.interfaces;

import java.nio.ByteBuffer;
import org.keyczar.exceptions.KeyczarException;

public abstract interface DecryptingStream extends Stream
{
  public abstract int doFinalDecrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws KeyczarException;

  public abstract VerifyingStream getVerifyingStream();

  public abstract void initDecrypt(ByteBuffer paramByteBuffer)
    throws KeyczarException;

  public abstract int updateDecrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws KeyczarException;
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.interfaces.DecryptingStream
 * JD-Core Version:    0.6.2
 */
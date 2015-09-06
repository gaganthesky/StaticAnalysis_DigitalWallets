package org.keyczar;

import java.nio.ByteBuffer;
import org.apache.log4j.Logger;
import org.keyczar.enums.KeyPurpose;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.exceptions.NoPrimaryKeyException;
import org.keyczar.interfaces.KeyczarReader;
import org.keyczar.interfaces.SigningStream;
import org.keyczar.util.Util;

public class Signer extends Verifier
{
  private static final Logger LOG = (Logger)localObject;
  private final StreamQueue SIGN_QUEUE;

  static
  {
    Object localObject = Signer.class;
    localObject = Logger.getLogger((Class)localObject);
  }

  public Signer(KeyczarReader paramKeyczarReader)
    throws KeyczarException
  {
    super(paramKeyczarReader);
    StreamQueue localStreamQueue = new org/keyczar/StreamQueue;
    localStreamQueue.<init>();
    this.SIGN_QUEUE = localStreamQueue;
  }

  public final byte[] attachedSign(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws KeyczarException
  {
    int m = 0;
    KeyczarKey localKeyczarKey = getPrimaryKey();
    if (localKeyczarKey == null)
    {
      localObject2 = new org/keyczar/exceptions/NoPrimaryKeyException;
      ((NoPrimaryKeyException)localObject2).<init>();
      throw ((Throwable)localObject2);
    }
    Object localObject2 = this.SIGN_QUEUE;
    Object localObject1 = ((StreamQueue)localObject2).poll();
    localObject1 = (SigningStream)localObject1;
    if (localObject1 == null)
    {
      localObject1 = localKeyczarKey.getStream();
      localObject1 = (SigningStream)localObject1;
    }
    ((SigningStream)localObject1).initSign();
    byte[] arrayOfByte1 = Util.fromInt(m);
    int i = paramArrayOfByte2.length;
    if (i > 0)
      arrayOfByte1 = Util.lenPrefix(paramArrayOfByte2);
    Object localObject3 = ByteBuffer.wrap(paramArrayOfByte1);
    ((SigningStream)localObject1).updateSign((ByteBuffer)localObject3);
    localObject3 = ByteBuffer.wrap(arrayOfByte1);
    ((SigningStream)localObject1).updateSign((ByteBuffer)localObject3);
    localObject3 = FORMAT_BYTES;
    localObject3 = ByteBuffer.wrap((byte[])localObject3);
    ((SigningStream)localObject1).updateSign((ByteBuffer)localObject3);
    int j = ((SigningStream)localObject1).digestSize();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(j);
    localByteBuffer.mark();
    ((SigningStream)localObject1).sign(localByteBuffer);
    j = localByteBuffer.position();
    localByteBuffer.limit(j);
    j = 4;
    Object localObject4 = new byte[j][];
    byte[] arrayOfByte3 = FORMAT_BYTES;
    localObject4[m] = arrayOfByte3;
    int k = 1;
    byte[] arrayOfByte4 = localKeyczarKey.hash();
    localObject4[k] = arrayOfByte4;
    k = 2;
    arrayOfByte4 = Util.lenPrefix(paramArrayOfByte1);
    localObject4[k] = arrayOfByte4;
    k = 3;
    arrayOfByte4 = localByteBuffer.array();
    localObject4[k] = arrayOfByte4;
    byte[] arrayOfByte2 = Util.cat((byte[][])localObject4);
    localObject4 = this.SIGN_QUEUE;
    ((StreamQueue)localObject4).add(localObject1);
    return arrayOfByte2;
  }

  final boolean isAcceptablePurpose(KeyPurpose paramKeyPurpose)
  {
    KeyPurpose localKeyPurpose = KeyPurpose.SIGN_AND_VERIFY;
    if (paramKeyPurpose == localKeyPurpose);
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.Signer
 * JD-Core Version:    0.6.2
 */
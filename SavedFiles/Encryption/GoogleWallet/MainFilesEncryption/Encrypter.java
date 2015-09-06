package org.keyczar;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.log4j.Logger;
import org.keyczar.enums.KeyPurpose;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.exceptions.NoPrimaryKeyException;
import org.keyczar.i18n.Messages;
import org.keyczar.interfaces.EncryptingStream;
import org.keyczar.interfaces.KeyczarReader;
import org.keyczar.interfaces.SigningStream;
import org.keyczar.util.Base64Coder;

public class Encrypter extends Keyczar
{
  private static final Logger LOG = (Logger)localObject;
  private final StreamQueue ENCRYPT_QUEUE;

  static
  {
    Object localObject = Encrypter.class;
    localObject = Logger.getLogger((Class)localObject);
  }

  public Encrypter(KeyczarReader paramKeyczarReader)
    throws KeyczarException
  {
    super(paramKeyczarReader);
    StreamQueue localStreamQueue = new org/keyczar/StreamQueue;
    localStreamQueue.<init>();
    this.ENCRYPT_QUEUE = localStreamQueue;
  }

  private int ciphertextSize(int paramInt)
    throws KeyczarException
  {
    Object localObject2 = this.ENCRYPT_QUEUE;
    Object localObject1 = ((StreamQueue)localObject2).poll();
    localObject1 = (EncryptingStream)localObject1;
    if (localObject1 == null)
    {
      KeyczarKey localKeyczarKey = getPrimaryKey();
      if (localKeyczarKey == null)
      {
        localObject2 = new org/keyczar/exceptions/NoPrimaryKeyException;
        ((NoPrimaryKeyException)localObject2).<init>();
        throw ((Throwable)localObject2);
      }
      localObject1 = localKeyczarKey.getStream();
      localObject1 = (EncryptingStream)localObject1;
    }
    SigningStream localSigningStream = ((EncryptingStream)localObject1).getSigningStream();
    int j = ((EncryptingStream)localObject1).maxOutputSize(paramInt);
    j += 5;
    int k = localSigningStream.digestSize();
    int i = j + k;
    StreamQueue localStreamQueue = this.ENCRYPT_QUEUE;
    localStreamQueue.add(localObject1);
    return i;
  }

  public final String encrypt(String paramString)
    throws KeyczarException
  {
    Object localObject;
    try
    {
      localObject = "UTF-8";
      localObject = paramString.getBytes((String)localObject);
      localObject = encrypt((byte[])localObject);
      localObject = Base64Coder.encodeWebSafe((byte[])localObject);
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localObject = new org/keyczar/exceptions/KeyczarException;
      ((KeyczarException)localObject).<init>(localUnsupportedEncodingException);
    }
    throw ((Throwable)localObject);
  }

  private void encrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws KeyczarException
  {
    int i1 = 1024;
    Object localObject2 = LOG;
    String str = "Encrypter.Encrypting";
    int k = 1;
    Object[] arrayOfObject = new Object[k];
    int m = 0;
    int n = paramByteBuffer1.remaining();
    Integer localInteger = Integer.valueOf(n);
    arrayOfObject[m] = localInteger;
    str = Messages.getString(str, arrayOfObject);
    ((Logger)localObject2).debug(str);
    KeyczarKey localKeyczarKey = getPrimaryKey();
    if (localKeyczarKey == null)
    {
      localObject2 = new org/keyczar/exceptions/NoPrimaryKeyException;
      ((NoPrimaryKeyException)localObject2).<init>();
      throw ((Throwable)localObject2);
    }
    localObject2 = this.ENCRYPT_QUEUE;
    Object localObject1 = ((StreamQueue)localObject2).poll();
    localObject1 = (EncryptingStream)localObject1;
    if (localObject1 == null)
    {
      localObject1 = localKeyczarKey.getStream();
      localObject1 = (EncryptingStream)localObject1;
    }
    SigningStream localSigningStream = ((EncryptingStream)localObject1).getSigningStream();
    localSigningStream.initSign();
    paramByteBuffer2.mark();
    ByteBuffer localByteBuffer3 = paramByteBuffer2.asReadOnlyBuffer();
    localKeyczarKey.copyHeader(paramByteBuffer2);
    ((EncryptingStream)localObject1).initEncrypt(paramByteBuffer2);
    ByteBuffer localByteBuffer2 = paramByteBuffer1.asReadOnlyBuffer();
    while (true)
    {
      i = localByteBuffer2.remaining();
      if (i <= i1)
        break;
      ByteBuffer localByteBuffer1 = localByteBuffer2.slice();
      localByteBuffer1.limit(i1);
      ((EncryptingStream)localObject1).updateEncrypt(localByteBuffer1, paramByteBuffer2);
      i = localByteBuffer2.position();
      i += 1024;
      localByteBuffer2.position(i);
      i = paramByteBuffer2.position();
      localByteBuffer3.limit(i);
      localSigningStream.updateSign(localByteBuffer3);
      i = paramByteBuffer2.position();
      localByteBuffer3.position(i);
    }
    ((EncryptingStream)localObject1).doFinalEncrypt(localByteBuffer2, paramByteBuffer2);
    int i = paramByteBuffer2.position();
    int j = localSigningStream.digestSize();
    i += j;
    paramByteBuffer2.limit(i);
    i = paramByteBuffer2.position();
    localByteBuffer3.limit(i);
    localSigningStream.updateSign(localByteBuffer3);
    localSigningStream.sign(paramByteBuffer2);
    StreamQueue localStreamQueue = this.ENCRYPT_QUEUE;
    localStreamQueue.add(localObject1);
  }

  public final byte[] encrypt(byte[] paramArrayOfByte)
    throws KeyczarException
  {
    int i = paramArrayOfByte.length;
    i = ciphertextSize(i);
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(i);
    ByteBuffer localByteBuffer2 = ByteBuffer.wrap(paramArrayOfByte);
    encrypt(localByteBuffer2, localByteBuffer1);
    localByteBuffer1.reset();
    int j = localByteBuffer1.remaining();
    byte[] arrayOfByte = new byte[j];
    localByteBuffer1.get(arrayOfByte);
    return arrayOfByte;
  }

  boolean isAcceptablePurpose(KeyPurpose paramKeyPurpose)
  {
    KeyPurpose localKeyPurpose = KeyPurpose.ENCRYPT;
    if (paramKeyPurpose != localKeyPurpose)
    {
      localKeyPurpose = KeyPurpose.DECRYPT_AND_ENCRYPT;
      if (paramKeyPurpose != localKeyPurpose)
        break label23;
    }
    label23: for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.Encrypter
 * JD-Core Version:    0.6.2
 */
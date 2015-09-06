package org.keyczar;

import java.nio.ByteBuffer;
import org.apache.log4j.Logger;
import org.keyczar.enums.KeyPurpose;
import org.keyczar.exceptions.BadVersionException;
import org.keyczar.exceptions.InvalidSignatureException;
import org.keyczar.exceptions.KeyNotFoundException;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.exceptions.ShortCiphertextException;
import org.keyczar.i18n.Messages;
import org.keyczar.interfaces.DecryptingStream;
import org.keyczar.interfaces.KeyczarReader;
import org.keyczar.interfaces.Stream;
import org.keyczar.interfaces.VerifyingStream;

public class Crypter extends Encrypter
{
  private static final Logger LOG = (Logger)localObject;
  private final StreamCache CRYPT_CACHE;

  static
  {
    Object localObject = Crypter.class;
    localObject = Logger.getLogger((Class)localObject);
  }

  public Crypter(KeyczarReader paramKeyczarReader)
    throws KeyczarException
  {
    super(paramKeyczarReader);
    StreamCache localStreamCache = new org/keyczar/StreamCache;
    localStreamCache.<init>();
    this.CRYPT_CACHE = localStreamCache;
  }

  private void decrypt(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
    throws KeyczarException
  {
    ByteBuffer localByteBuffer4 = paramByteBuffer1.asReadOnlyBuffer();
    Logger localLogger = LOG;
    String str = "Crypter.Decrypting";
    int i2 = 1;
    Object[] arrayOfObject = new Object[i2];
    int i3 = 0;
    int i4 = localByteBuffer4.remaining();
    Integer localInteger = Integer.valueOf(i4);
    arrayOfObject[i3] = localInteger;
    str = Messages.getString(str, arrayOfObject);
    localLogger.debug(str);
    int i = localByteBuffer4.remaining();
    int i1 = 5;
    Object localObject2;
    if (i < i1)
    {
      localObject2 = new org/keyczar/exceptions/ShortCiphertextException;
      i1 = localByteBuffer4.remaining();
      ((ShortCiphertextException)localObject2).<init>(i1);
      throw ((Throwable)localObject2);
    }
    byte b = localByteBuffer4.get();
    if (b != 0)
    {
      localObject2 = new org/keyczar/exceptions/BadVersionException;
      ((BadVersionException)localObject2).<init>(b);
      throw ((Throwable)localObject2);
    }
    int j = 4;
    byte[] arrayOfByte = new byte[j];
    localByteBuffer4.get(arrayOfByte);
    KeyczarKey localKeyczarKey = getKey(arrayOfByte);
    if (localKeyczarKey == null)
    {
      localObject3 = new org/keyczar/exceptions/KeyNotFoundException;
      ((KeyNotFoundException)localObject3).<init>(arrayOfByte);
      throw ((Throwable)localObject3);
    }
    localByteBuffer4.mark();
    Object localObject3 = this.CRYPT_CACHE;
    Object localObject1 = ((StreamCache)localObject3).get(localKeyczarKey);
    localObject1 = (DecryptingStream)localObject1;
    if (localObject1 == null)
    {
      localObject1 = localKeyczarKey.getStream();
      localObject1 = (DecryptingStream)localObject1;
    }
    VerifyingStream localVerifyingStream = ((DecryptingStream)localObject1).getVerifyingStream();
    int k = localByteBuffer4.remaining();
    i1 = localVerifyingStream.digestSize();
    if (k < i1)
    {
      ShortCiphertextException localShortCiphertextException = new org/keyczar/exceptions/ShortCiphertextException;
      i1 = localByteBuffer4.remaining();
      localShortCiphertextException.<init>(i1);
      throw localShortCiphertextException;
    }
    int m = localByteBuffer4.limit();
    i1 = localVerifyingStream.digestSize();
    m -= i1;
    localByteBuffer4.position(m);
    ByteBuffer localByteBuffer5 = localByteBuffer4.slice();
    localByteBuffer4.reset();
    m = localByteBuffer4.limit();
    i1 = localVerifyingStream.digestSize();
    m -= i1;
    localByteBuffer4.limit(m);
    ((DecryptingStream)localObject1).initDecrypt(localByteBuffer4);
    ByteBuffer localByteBuffer3 = paramByteBuffer1.asReadOnlyBuffer();
    m = localByteBuffer4.position();
    localByteBuffer3.limit(m);
    localVerifyingStream.initVerify();
    localVerifyingStream.updateVerify(localByteBuffer3);
    paramByteBuffer2.mark();
    while (true)
    {
      m = localByteBuffer4.remaining();
      i1 = 1024;
      if (m <= i1)
        break;
      ByteBuffer localByteBuffer2 = localByteBuffer4.slice();
      m = 1024;
      localByteBuffer2.limit(m);
      localByteBuffer1 = paramByteBuffer2;
      ((DecryptingStream)localObject1).updateDecrypt(localByteBuffer2, localByteBuffer1);
      localByteBuffer2.rewind();
      localVerifyingStream.updateVerify(localByteBuffer2);
      m = localByteBuffer4.position();
      m += 1024;
      localByteBuffer4.position(m);
    }
    localByteBuffer4.mark();
    localVerifyingStream.updateVerify(localByteBuffer4);
    boolean bool = localVerifyingStream.verify(localByteBuffer5);
    if (!bool)
    {
      InvalidSignatureException localInvalidSignatureException = new org/keyczar/exceptions/InvalidSignatureException;
      localInvalidSignatureException.<init>();
      throw localInvalidSignatureException;
    }
    localByteBuffer4.reset();
    ByteBuffer localByteBuffer1 = paramByteBuffer2;
    ((DecryptingStream)localObject1).doFinalDecrypt(localByteBuffer4, localByteBuffer1);
    int n = paramByteBuffer2.position();
    localByteBuffer1 = paramByteBuffer2;
    localByteBuffer1.limit(n);
    StreamCache localStreamCache = this.CRYPT_CACHE;
    localStreamCache.put(localKeyczarKey, (Stream)localObject1);
  }

  public final byte[] decrypt(byte[] paramArrayOfByte)
    throws KeyczarException
  {
    int i = paramArrayOfByte.length;
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(i);
    ByteBuffer localByteBuffer2 = ByteBuffer.wrap(paramArrayOfByte);
    decrypt(localByteBuffer2, localByteBuffer1);
    localByteBuffer1.reset();
    int j = localByteBuffer1.remaining();
    byte[] arrayOfByte = new byte[j];
    localByteBuffer1.get(arrayOfByte);
    return arrayOfByte;
  }

  final boolean isAcceptablePurpose(KeyPurpose paramKeyPurpose)
  {
    KeyPurpose localKeyPurpose = KeyPurpose.DECRYPT_AND_ENCRYPT;
    if (paramKeyPurpose == localKeyPurpose);
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.Crypter
 * JD-Core Version:    0.6.2
 */
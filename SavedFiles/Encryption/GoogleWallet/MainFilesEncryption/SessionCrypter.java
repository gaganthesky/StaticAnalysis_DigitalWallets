package org.keyczar;

import org.keyczar.exceptions.KeyczarException;
import org.keyczar.keyparams.AesKeyParameters;
import org.keyczar.keyparams.KeyParameters;

public final class SessionCrypter
{
  private final byte[] sessionMaterial;
  private final Crypter symmetricCrypter;

  public SessionCrypter(Encrypter paramEncrypter)
    throws KeyczarException
  {
    Object localObject = DefaultKeyType.AES;
    KeyParameters localKeyParameters = null;
    localObject = ((DefaultKeyType)localObject).applyDefaultParameters(localKeyParameters);
    localObject = (AesKeyParameters)localObject;
    AesKey localAesKey = AesKey.generate((AesKeyParameters)localObject);
    ImportedKeyReader localImportedKeyReader = new org/keyczar/ImportedKeyReader;
    localImportedKeyReader.<init>(localAesKey);
    localObject = new org/keyczar/Crypter;
    ((Crypter)localObject).<init>(localImportedKeyReader);
    this.symmetricCrypter = ((Crypter)localObject);
    localObject = localAesKey.getEncoded();
    localObject = paramEncrypter.encrypt((byte[])localObject);
    this.sessionMaterial = ((byte[])localObject);
  }

  public final byte[] decrypt(byte[] paramArrayOfByte)
    throws KeyczarException
  {
    Object localObject = this.symmetricCrypter;
    localObject = ((Crypter)localObject).decrypt(paramArrayOfByte);
    return localObject;
  }

  public final byte[] encrypt(byte[] paramArrayOfByte)
    throws KeyczarException
  {
    Object localObject = this.symmetricCrypter;
    localObject = ((Crypter)localObject).encrypt(paramArrayOfByte);
    return localObject;
  }

  public final byte[] getSessionMaterial()
  {
    byte[] arrayOfByte = this.sessionMaterial;
    return arrayOfByte;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.SessionCrypter
 * JD-Core Version:    0.6.2
 */
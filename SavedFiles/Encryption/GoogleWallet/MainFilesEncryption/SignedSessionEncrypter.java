package org.keyczar;

import java.util.concurrent.atomic.AtomicReference;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.keyparams.AesKeyParameters;
import org.keyczar.keyparams.KeyParameters;
import org.keyczar.util.Base64Coder;
import org.keyczar.util.Util;

public final class SignedSessionEncrypter
{
  private final Encrypter encrypter;
  private final AtomicReference session;
  private final Signer signer;

  public SignedSessionEncrypter(Encrypter paramEncrypter, Signer paramSigner)
  {
    AtomicReference localAtomicReference = new java/util/concurrent/atomic/AtomicReference;
    localAtomicReference.<init>();
    this.session = localAtomicReference;
    this.encrypter = paramEncrypter;
    this.signer = paramSigner;
  }

  private static String buildNonce()
  {
    int i = 16;
    byte[] arrayOfByte = new byte[i];
    Util.rand(arrayOfByte);
    String str = Base64Coder.encodeWebSafe(arrayOfByte);
    return str;
  }

  private static AesKey buildSessionKey(AesKeyParameters paramAesKeyParameters)
    throws KeyczarException
  {
    DefaultKeyType localDefaultKeyType = DefaultKeyType.AES;
    int i = paramAesKeyParameters.getKeySize();
    boolean bool = localDefaultKeyType.isAcceptableSize(i);
    if (!bool)
    {
      localObject = new org/keyczar/exceptions/KeyczarException;
      String str = "Unsupported key size requested for session";
      ((KeyczarException)localObject).<init>(str);
      throw ((Throwable)localObject);
    }
    Object localObject = AesKey.generate(paramAesKeyParameters);
    return localObject;
  }

  public final byte[] encrypt(byte[] paramArrayOfByte)
    throws KeyczarException
  {
    Object localObject2 = this.session;
    localObject2 = ((AtomicReference)localObject2).get();
    if (localObject2 == null)
    {
      localObject2 = new org/keyczar/exceptions/KeyczarException;
      localObject3 = "Session not initialized.";
      ((KeyczarException)localObject2).<init>((String)localObject3);
      throw ((Throwable)localObject2);
    }
    localObject2 = this.session;
    Object localObject1 = ((AtomicReference)localObject2).get();
    localObject1 = (SessionMaterial)localObject1;
    ImportedKeyReader localImportedKeyReader = new org/keyczar/ImportedKeyReader;
    localObject2 = ((SessionMaterial)localObject1).getKey();
    localImportedKeyReader.<init>((AesKey)localObject2);
    Crypter localCrypter = new org/keyczar/Crypter;
    localCrypter.<init>(localImportedKeyReader);
    byte[] arrayOfByte = localCrypter.encrypt(paramArrayOfByte);
    localObject2 = this.signer;
    Object localObject3 = ((SessionMaterial)localObject1).getNonce();
    localObject3 = Base64Coder.decodeWebSafe((String)localObject3);
    localObject2 = ((Signer)localObject2).attachedSign(arrayOfByte, (byte[])localObject3);
    return localObject2;
  }

  public final String newSession()
    throws KeyczarException
  {
    Object localObject = DefaultKeyType.AES;
    KeyParameters localKeyParameters = null;
    localObject = ((DefaultKeyType)localObject).applyDefaultParameters(localKeyParameters);
    localObject = (AesKeyParameters)localObject;
    localObject = newSession((AesKeyParameters)localObject);
    return localObject;
  }

  private String newSession(AesKeyParameters paramAesKeyParameters)
    throws KeyczarException
  {
    SessionMaterial localSessionMaterial = new org/keyczar/SessionMaterial;
    Object localObject = buildSessionKey(paramAesKeyParameters);
    String str = buildNonce();
    localSessionMaterial.<init>((AesKey)localObject, str);
    localObject = this.session;
    ((AtomicReference)localObject).set(localSessionMaterial);
    localObject = this.encrypter;
    str = localSessionMaterial.toString();
    localObject = ((Encrypter)localObject).encrypt(str);
    return localObject;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.SignedSessionEncrypter
 * JD-Core Version:    0.6.2
 */
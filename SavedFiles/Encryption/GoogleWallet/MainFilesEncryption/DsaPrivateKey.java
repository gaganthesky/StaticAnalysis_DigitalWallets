package org.keyczar;

import com.google.gson.Gson;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAPrivateKeySpec;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.Stream;
import org.keyczar.util.Base64Coder;
import org.keyczar.util.Util;

public class DsaPrivateKey extends KeyczarKey
{
  private DSAPrivateKey jcePrivateKey;
  private final DsaPublicKey publicKey;
  private final String x;

  private DsaPrivateKey()
  {
    super(i);
    this.publicKey = localObject;
    this.x = localObject;
  }

  private KeyczarPublicKey getPublic()
  {
    DsaPublicKey localDsaPublicKey = this.publicKey;
    return localDsaPublicKey;
  }

  protected final Stream getStream()
    throws KeyczarException
  {
    DsaPrivateKey.DsaSigningStream localDsaSigningStream = new org/keyczar/DsaPrivateKey$DsaSigningStream;
    localDsaSigningStream.<init>(this);
    return localDsaSigningStream;
  }

  protected final byte[] hash()
  {
    Object localObject = getPublic();
    localObject = ((KeyczarPublicKey)localObject).hash();
    return localObject;
  }

  private DsaPrivateKey initFromJson()
    throws KeyczarException
  {
    Object localObject = this.publicKey;
    ((DsaPublicKey)localObject).initFromJson();
    BigInteger localBigInteger4 = new java/math/BigInteger;
    localObject = this.x;
    localObject = Base64Coder.decodeWebSafe((String)localObject);
    localBigInteger4.<init>((byte[])localObject);
    BigInteger localBigInteger2 = new java/math/BigInteger;
    localObject = this.publicKey;
    localObject = ((DsaPublicKey)localObject).p;
    localObject = Base64Coder.decodeWebSafe((String)localObject);
    localBigInteger2.<init>((byte[])localObject);
    BigInteger localBigInteger3 = new java/math/BigInteger;
    localObject = this.publicKey;
    localObject = ((DsaPublicKey)localObject).q;
    localObject = Base64Coder.decodeWebSafe((String)localObject);
    localBigInteger3.<init>((byte[])localObject);
    BigInteger localBigInteger1 = new java/math/BigInteger;
    localObject = this.publicKey;
    localObject = ((DsaPublicKey)localObject).g;
    localObject = Base64Coder.decodeWebSafe((String)localObject);
    localBigInteger1.<init>((byte[])localObject);
    try
    {
      localObject = "DSA";
      KeyFactory localKeyFactory = KeyFactory.getInstance((String)localObject);
      DSAPrivateKeySpec localDSAPrivateKeySpec = new java/security/spec/DSAPrivateKeySpec;
      localDSAPrivateKeySpec.<init>(localBigInteger4, localBigInteger2, localBigInteger3, localBigInteger1);
      localObject = localKeyFactory.generatePrivate(localDSAPrivateKeySpec);
      localObject = (DSAPrivateKey)localObject;
      this.jcePrivateKey = ((DSAPrivateKey)localObject);
      return this;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      localObject = new org/keyczar/exceptions/KeyczarException;
      ((KeyczarException)localObject).<init>(localGeneralSecurityException);
    }
    throw ((Throwable)localObject);
  }

  static DsaPrivateKey read(String paramString)
    throws KeyczarException
  {
    Object localObject2 = Util.gson();
    DsaPrivateKey localDsaPrivateKey = DsaPrivateKey.class;
    Object localObject1 = ((Gson)localObject2).fromJson(paramString, localDsaPrivateKey);
    localObject1 = (DsaPrivateKey)localObject1;
    localObject2 = ((DsaPrivateKey)localObject1).initFromJson();
    return localObject2;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.DsaPrivateKey
 * JD-Core Version:    0.6.2
 */
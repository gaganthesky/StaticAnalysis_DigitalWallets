package org.keyczar;

import com.google.gson.Gson;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.Stream;
import org.keyczar.util.Util;

public class RsaPrivateKey extends KeyczarKey
{
  private final String crtCoefficient;
  private RSAPrivateCrtKey jcePrivateKey;
  private final String primeExponentP;
  private final String primeExponentQ;
  private final String primeP;
  private final String primeQ;
  private final String privateExponent;
  private final RsaPublicKey publicKey;

  private RsaPrivateKey()
  {
    super(i);
    this.publicKey = localObject;
    this.privateExponent = localObject;
    this.primeP = localObject;
    this.primeQ = localObject;
    this.primeExponentP = localObject;
    this.primeExponentQ = localObject;
    this.crtCoefficient = localObject;
    this.jcePrivateKey = localObject;
  }

  protected final Stream getStream()
    throws KeyczarException
  {
    RsaPrivateKey.RsaPrivateStream localRsaPrivateStream = new org/keyczar/RsaPrivateKey$RsaPrivateStream;
    localRsaPrivateStream.<init>(this);
    return localRsaPrivateStream;
  }

  protected final byte[] hash()
  {
    Object localObject = this.publicKey;
    localObject = ((RsaPublicKey)localObject).hash();
    return localObject;
  }

  private RsaPrivateKey initFromJson()
    throws KeyczarException
  {
    Object localObject1 = this.publicKey;
    ((RsaPublicKey)localObject1).initFromJson();
    try
    {
      localObject1 = "RSA";
      KeyFactory localKeyFactory = KeyFactory.getInstance((String)localObject1);
      RSAPrivateCrtKeySpec localRSAPrivateCrtKeySpec = new java/security/spec/RSAPrivateCrtKeySpec;
      localObject1 = this.publicKey;
      localObject1 = ((RsaPublicKey)localObject1).modulus;
      localObject1 = Util.decodeBigInteger((String)localObject1);
      Object localObject2 = this.publicKey;
      localObject2 = ((RsaPublicKey)localObject2).publicExponent;
      localObject2 = Util.decodeBigInteger((String)localObject2);
      Object localObject3 = this.privateExponent;
      localObject3 = Util.decodeBigInteger((String)localObject3);
      Object localObject4 = this.primeP;
      localObject4 = Util.decodeBigInteger((String)localObject4);
      Object localObject5 = this.primeQ;
      localObject5 = Util.decodeBigInteger((String)localObject5);
      Object localObject6 = this.primeExponentP;
      localObject6 = Util.decodeBigInteger((String)localObject6);
      Object localObject7 = this.primeExponentQ;
      localObject7 = Util.decodeBigInteger((String)localObject7);
      Object localObject8 = this.crtCoefficient;
      localObject8 = Util.decodeBigInteger((String)localObject8);
      localRSAPrivateCrtKeySpec.<init>((BigInteger)localObject1, (BigInteger)localObject2, (BigInteger)localObject3, (BigInteger)localObject4, (BigInteger)localObject5, (BigInteger)localObject6, (BigInteger)localObject7, (BigInteger)localObject8);
      localObject1 = localKeyFactory.generatePrivate(localRSAPrivateCrtKeySpec);
      localObject1 = (RSAPrivateCrtKey)localObject1;
      this.jcePrivateKey = ((RSAPrivateCrtKey)localObject1);
      return this;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      localObject1 = new org/keyczar/exceptions/KeyczarException;
      ((KeyczarException)localObject1).<init>(localGeneralSecurityException);
    }
    throw ((Throwable)localObject1);
  }

  static RsaPrivateKey read(String paramString)
    throws KeyczarException
  {
    Object localObject2 = Util.gson();
    RsaPrivateKey localRsaPrivateKey = RsaPrivateKey.class;
    Object localObject1 = ((Gson)localObject2).fromJson(paramString, localRsaPrivateKey);
    localObject1 = (RsaPrivateKey)localObject1;
    localObject2 = ((RsaPrivateKey)localObject1).initFromJson();
    return localObject2;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.RsaPrivateKey
 * JD-Core Version:    0.6.2
 */
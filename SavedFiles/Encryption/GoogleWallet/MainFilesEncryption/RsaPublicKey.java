package org.keyczar;

import com.google.gson.Gson;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import org.keyczar.enums.RsaPadding;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.exceptions.UnsupportedTypeException;
import org.keyczar.interfaces.KeyType;
import org.keyczar.interfaces.Stream;
import org.keyczar.util.Util;

public class RsaPublicKey extends KeyczarPublicKey
{
  private final byte[] hash;
  private RSAPublicKey jcePublicKey;
  final String modulus;
  final RsaPadding padding;
  final String publicExponent;

  private RsaPublicKey()
  {
    super(i);
    i = 4;
    byte[] arrayOfByte = new byte[i];
    this.hash = arrayOfByte;
    this.publicExponent = localObject;
    this.modulus = localObject;
    this.padding = localObject;
  }

  public final RsaPadding getPadding()
  {
    RsaPadding localRsaPadding1 = this.padding;
    if (localRsaPadding1 != null)
    {
      localRsaPadding1 = this.padding;
      RsaPadding localRsaPadding2 = RsaPadding.OAEP;
      if (localRsaPadding1 != localRsaPadding2)
        break label30;
    }
    label30: for (localRsaPadding1 = RsaPadding.OAEP; ; localRsaPadding1 = RsaPadding.PKCS)
      return localRsaPadding1;
  }

  protected final Stream getStream()
    throws KeyczarException
  {
    RsaPublicKey.RsaStream localRsaStream = new org/keyczar/RsaPublicKey$RsaStream;
    localRsaStream.<init>(this);
    return localRsaStream;
  }

  private static KeyType getType()
  {
    DefaultKeyType localDefaultKeyType = DefaultKeyType.RSA_PUB;
    return localDefaultKeyType;
  }

  public final byte[] hash()
  {
    byte[] arrayOfByte = this.hash;
    return arrayOfByte;
  }

  final RsaPublicKey initFromJson()
    throws KeyczarException
  {
    Object localObject1 = this.modulus;
    localObject1 = Util.decodeBigInteger((String)localObject1);
    Object localObject2 = this.publicExponent;
    localObject2 = Util.decodeBigInteger((String)localObject2);
    initializeJceKey((BigInteger)localObject1, (BigInteger)localObject2);
    initializeHash();
    return this;
  }

  private void initializeHash()
    throws KeyczarException
  {
    int j = 0;
    Object localObject1 = getPadding();
    Object localObject2 = this.jcePublicKey;
    localObject1 = ((RsaPadding)localObject1).computeFullHash((RSAPublicKey)localObject2);
    localObject2 = this.hash;
    byte[] arrayOfByte = this.hash;
    int i = arrayOfByte.length;
    System.arraycopy(localObject1, j, localObject2, j, i);
  }

  private void initializeJceKey(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    throws KeyczarException
  {
    Object localObject;
    try
    {
      RSAPublicKeySpec localRSAPublicKeySpec = new java/security/spec/RSAPublicKeySpec;
      localRSAPublicKeySpec.<init>(paramBigInteger1, paramBigInteger2);
      localObject = "RSA";
      localObject = KeyFactory.getInstance((String)localObject);
      localObject = ((KeyFactory)localObject).generatePublic(localRSAPublicKeySpec);
      localObject = (RSAPublicKey)localObject;
      this.jcePublicKey = ((RSAPublicKey)localObject);
      return;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      localObject = new org/keyczar/exceptions/KeyczarException;
      ((KeyczarException)localObject).<init>(localGeneralSecurityException);
    }
    throw ((Throwable)localObject);
  }

  final int keySizeInBytes()
  {
    Object localObject = this.jcePublicKey;
    localObject = ((RSAPublicKey)localObject).getModulus();
    int i = ((BigInteger)localObject).bitLength();
    i /= 8;
    return i;
  }

  static RsaPublicKey read(String paramString)
    throws KeyczarException
  {
    Object localObject2 = Util.gson();
    Object localObject3 = RsaPublicKey.class;
    Object localObject1 = ((Gson)localObject2).fromJson(paramString, (Class)localObject3);
    localObject1 = (RsaPublicKey)localObject1;
    localObject2 = getType();
    localObject3 = DefaultKeyType.RSA_PUB;
    if (localObject2 != localObject3)
    {
      localObject2 = new org/keyczar/exceptions/UnsupportedTypeException;
      localObject3 = getType();
      ((UnsupportedTypeException)localObject2).<init>((KeyType)localObject3);
      throw ((Throwable)localObject2);
    }
    localObject2 = ((RsaPublicKey)localObject1).initFromJson();
    return localObject2;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.RsaPublicKey
 * JD-Core Version:    0.6.2
 */
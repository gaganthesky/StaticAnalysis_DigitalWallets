package org.keyczar;

import com.google.gson.Gson;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.KeySpec;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.Stream;
import org.keyczar.util.Base64Coder;
import org.keyczar.util.Util;

public class DsaPublicKey extends KeyczarPublicKey
{
  final String g;
  private final byte[] hash;
  private DSAPublicKey jcePublicKey;
  final String p;
  final String q;
  final String y;

  private DsaPublicKey()
  {
    super(i);
    i = 4;
    byte[] arrayOfByte = new byte[i];
    this.hash = arrayOfByte;
    this.jcePublicKey = localObject;
    this.g = localObject;
    this.q = localObject;
    this.p = localObject;
    this.y = localObject;
  }

  protected final Stream getStream()
    throws KeyczarException
  {
    DsaPublicKey.DsaVerifyingStream localDsaVerifyingStream = new org/keyczar/DsaPublicKey$DsaVerifyingStream;
    localDsaVerifyingStream.<init>(this);
    return localDsaVerifyingStream;
  }

  public final byte[] hash()
  {
    byte[] arrayOfByte = this.hash;
    return arrayOfByte;
  }

  final void initFromJson()
    throws KeyczarException
  {
    BigInteger localBigInteger4 = new java/math/BigInteger;
    Object localObject = this.y;
    localObject = Base64Coder.decodeWebSafe((String)localObject);
    localBigInteger4.<init>((byte[])localObject);
    BigInteger localBigInteger2 = new java/math/BigInteger;
    localObject = this.p;
    localObject = Base64Coder.decodeWebSafe((String)localObject);
    localBigInteger2.<init>((byte[])localObject);
    BigInteger localBigInteger3 = new java/math/BigInteger;
    localObject = this.q;
    localObject = Base64Coder.decodeWebSafe((String)localObject);
    localBigInteger3.<init>((byte[])localObject);
    BigInteger localBigInteger1 = new java/math/BigInteger;
    localObject = this.g;
    localObject = Base64Coder.decodeWebSafe((String)localObject);
    localBigInteger1.<init>((byte[])localObject);
    initializeJceKey(localBigInteger4, localBigInteger2, localBigInteger3, localBigInteger1);
    initializeHash();
  }

  private void initializeHash()
    throws KeyczarException
  {
    int m = 0;
    DSAPublicKey localDSAPublicKey = this.jcePublicKey;
    DSAParams localDSAParams = localDSAPublicKey.getParams();
    int i = 4;
    Object localObject1 = new byte[i][];
    Object localObject2 = localDSAParams.getP();
    localObject2 = ((BigInteger)localObject2).toByteArray();
    localObject2 = Util.stripLeadingZeros((byte[])localObject2);
    localObject1[m] = localObject2;
    int j = 1;
    Object localObject3 = localDSAParams.getQ();
    localObject3 = ((BigInteger)localObject3).toByteArray();
    localObject3 = Util.stripLeadingZeros((byte[])localObject3);
    localObject1[j] = localObject3;
    j = 2;
    localObject3 = localDSAParams.getG();
    localObject3 = ((BigInteger)localObject3).toByteArray();
    localObject3 = Util.stripLeadingZeros((byte[])localObject3);
    localObject1[j] = localObject3;
    j = 3;
    localObject3 = this.jcePublicKey;
    localObject3 = ((DSAPublicKey)localObject3).getY();
    localObject3 = ((BigInteger)localObject3).toByteArray();
    localObject3 = Util.stripLeadingZeros((byte[])localObject3);
    localObject1[j] = localObject3;
    byte[] arrayOfByte1 = Util.prefixHash((byte[][])localObject1);
    localObject1 = this.hash;
    byte[] arrayOfByte2 = this.hash;
    int k = arrayOfByte2.length;
    System.arraycopy(arrayOfByte1, m, localObject1, m, k);
  }

  private void initializeJceKey(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
    throws KeyczarException
  {
    Object localObject;
    try
    {
      localObject = "DSA";
      KeyFactory localKeyFactory = KeyFactory.getInstance((String)localObject);
      localObject = new java/security/spec/DSAPublicKeySpec;
      ((DSAPublicKeySpec)localObject).<init>(paramBigInteger1, paramBigInteger2, paramBigInteger3, paramBigInteger4);
      localObject = localKeyFactory.generatePublic((KeySpec)localObject);
      localObject = (DSAPublicKey)localObject;
      this.jcePublicKey = ((DSAPublicKey)localObject);
      return;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      localObject = new org/keyczar/exceptions/KeyczarException;
      ((KeyczarException)localObject).<init>(localGeneralSecurityException);
    }
    throw ((Throwable)localObject);
  }

  static DsaPublicKey read(String paramString)
    throws KeyczarException
  {
    Gson localGson = Util.gson();
    DsaPublicKey localDsaPublicKey = DsaPublicKey.class;
    Object localObject = localGson.fromJson(paramString, localDsaPublicKey);
    localObject = (DsaPublicKey)localObject;
    ((DsaPublicKey)localObject).initFromJson();
    return localObject;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.DsaPublicKey
 * JD-Core Version:    0.6.2
 */
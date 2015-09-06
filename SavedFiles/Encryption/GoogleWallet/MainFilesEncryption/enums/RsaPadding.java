package org.keyczar.enums;

import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.util.Util;

public enum RsaPadding
{
  private static final RsaPadding[] $VALUES = arrayOfRsaPadding;
  private final String cryptAlgorithm;

  static
  {
    int k = 1;
    int j = 0;
    RsaPadding localRsaPadding = new org/keyczar/enums/RsaPadding;
    Object localObject = "OAEP";
    String str = "RSA/ECB/OAEPWITHSHA1ANDMGF1PADDING";
    localRsaPadding.<init>((String)localObject, j, str);
    OAEP = localRsaPadding;
    localRsaPadding = new org/keyczar/enums/RsaPadding;
    localObject = "PKCS";
    str = "RSA/ECB/PKCS1PADDING";
    localRsaPadding.<init>((String)localObject, k, str);
    PKCS = localRsaPadding;
    int i = 2;
    RsaPadding[] arrayOfRsaPadding = new RsaPadding[i];
    localObject = OAEP;
    arrayOfRsaPadding[j] = localObject;
    localObject = PKCS;
    arrayOfRsaPadding[k] = localObject;
  }

  private RsaPadding(String paramString)
  {
    this.cryptAlgorithm = paramString;
  }

  public final byte[] computeFullHash(RSAPublicKey paramRSAPublicKey)
    throws KeyczarException
  {
    int n = 2;
    int m = 1;
    int k = 0;
    int[] arrayOfInt = RsaPadding.1.$SwitchMap$org$keyczar$enums$RsaPadding;
    int j = ordinal();
    int i = arrayOfInt[j];
    Object localObject2;
    switch (i)
    {
    default:
      localObject1 = new org/keyczar/exceptions/KeyczarException;
      localObject2 = "Bug! Unknown padding type";
      ((KeyczarException)localObject1).<init>((String)localObject2);
      throw ((Throwable)localObject1);
    case 1:
      localObject1 = new byte[n][];
      localObject2 = paramRSAPublicKey.getModulus();
      localObject2 = ((BigInteger)localObject2).toByteArray();
      localObject2 = Util.stripLeadingZeros((byte[])localObject2);
      localObject1[k] = localObject2;
      localObject2 = paramRSAPublicKey.getPublicExponent();
      localObject2 = ((BigInteger)localObject2).toByteArray();
      localObject2 = Util.stripLeadingZeros((byte[])localObject2);
      localObject1[m] = localObject2;
    case 2:
    }
    for (Object localObject1 = Util.prefixHash((byte[][])localObject1); ; localObject1 = Util.prefixHash((byte[][])localObject1))
    {
      return localObject1;
      localObject1 = new byte[n][];
      localObject2 = paramRSAPublicKey.getModulus();
      localObject2 = ((BigInteger)localObject2).toByteArray();
      localObject1[k] = localObject2;
      localObject2 = paramRSAPublicKey.getPublicExponent();
      localObject2 = ((BigInteger)localObject2).toByteArray();
      localObject1[m] = localObject2;
    }
  }

  public final String getCryptAlgorithm()
  {
    String str = this.cryptAlgorithm;
    return str;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.enums.RsaPadding
 * JD-Core Version:    0.6.2
 */
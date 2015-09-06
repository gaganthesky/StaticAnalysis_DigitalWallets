package org.keyczar;

import com.google.gson.Gson;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.keyczar.enums.CipherMode;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.Stream;
import org.keyczar.keyparams.AesKeyParameters;
import org.keyczar.util.Base64Coder;
import org.keyczar.util.Util;

public class AesKey extends KeyczarKey
{
  private static final CipherMode DEFAULT_MODE = (CipherMode)localObject;
  private static final DefaultKeyType KEY_TYPE;
  private SecretKey aesKey;
  private final String aesKeyString;
  private final byte[] hash;
  private final HmacKey hmacKey;
  private final CipherMode mode;

  static
  {
    Object localObject = DefaultKeyType.AES;
    KEY_TYPE = (DefaultKeyType)localObject;
    localObject = CipherMode.CBC;
  }

  private AesKey()
  {
    super(i);
    i = 4;
    byte[] arrayOfByte = new byte[i];
    this.hash = arrayOfByte;
    this.aesKeyString = localObject;
    this.hmacKey = localObject;
    this.mode = localObject;
  }

  private AesKey(byte[] paramArrayOfByte, HmacKey paramHmacKey)
    throws KeyczarException
  {
    super(i);
    i = 4;
    Object localObject = new byte[i];
    this.hash = ((byte[])localObject);
    localObject = Base64Coder.encodeWebSafe(paramArrayOfByte);
    this.aesKeyString = ((String)localObject);
    localObject = DEFAULT_MODE;
    this.mode = ((CipherMode)localObject);
    this.hmacKey = paramHmacKey;
    initJceKey(paramArrayOfByte);
  }

  static AesKey generate(AesKeyParameters paramAesKeyParameters)
    throws KeyczarException
  {
    AesKey localAesKey = new org/keyczar/AesKey;
    int i = paramAesKeyParameters.getKeySize();
    i /= 8;
    byte[] arrayOfByte = Util.rand(i);
    HmacKey localHmacKey = paramAesKeyParameters.getHmacKey();
    localAesKey.<init>(arrayOfByte, localHmacKey);
    return localAesKey;
  }

  final byte[] getEncoded()
  {
    int i = 2;
    Object localObject1 = new byte[i][];
    int j = 0;
    Object localObject2 = this.aesKey;
    localObject2 = ((SecretKey)localObject2).getEncoded();
    localObject1[j] = localObject2;
    j = 1;
    localObject2 = this.hmacKey;
    localObject2 = ((HmacKey)localObject2).getEncoded();
    localObject1[j] = localObject2;
    localObject1 = Util.lenPrefixPack((byte[][])localObject1);
    return localObject1;
  }

  protected final Stream getStream()
    throws KeyczarException
  {
    AesKey.AesStream localAesStream = new org/keyczar/AesKey$AesStream;
    localAesStream.<init>(this);
    return localAesStream;
  }

  protected final byte[] hash()
  {
    byte[] arrayOfByte = this.hash;
    return arrayOfByte;
  }

  private void initJceKey(byte[] paramArrayOfByte)
    throws KeyczarException
  {
    int n = 0;
    SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
    String str = "AES";
    localSecretKeySpec.<init>(paramArrayOfByte, str);
    this.aesKey = localSecretKeySpec;
    int i = 3;
    Object localObject1 = new byte[i][];
    int j = 16;
    byte[] arrayOfByte2 = Util.fromInt(j);
    localObject1[n] = arrayOfByte2;
    int k = 1;
    localObject1[k] = paramArrayOfByte;
    k = 2;
    Object localObject2 = this.hmacKey;
    localObject2 = ((HmacKey)localObject2).getEncoded();
    localObject1[k] = localObject2;
    byte[] arrayOfByte1 = Util.hash((byte[][])localObject1);
    localObject1 = this.hash;
    byte[] arrayOfByte3 = this.hash;
    int m = arrayOfByte3.length;
    System.arraycopy(arrayOfByte1, n, localObject1, n, m);
  }

  static AesKey read(String paramString)
    throws KeyczarException
  {
    Object localObject2 = Util.gson();
    AesKey localAesKey = AesKey.class;
    Object localObject1 = ((Gson)localObject2).fromJson(paramString, localAesKey);
    localObject1 = (AesKey)localObject1;
    localObject2 = ((AesKey)localObject1).hmacKey;
    ((HmacKey)localObject2).initFromJson();
    localObject2 = ((AesKey)localObject1).aesKeyString;
    localObject2 = Base64Coder.decodeWebSafe((String)localObject2);
    ((AesKey)localObject1).initJceKey((byte[])localObject2);
    return localObject1;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.AesKey
 * JD-Core Version:    0.6.2
 */
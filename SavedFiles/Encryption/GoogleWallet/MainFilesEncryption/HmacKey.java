package org.keyczar;

import com.google.gson.Gson;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.Stream;
import org.keyczar.keyparams.KeyParameters;
import org.keyczar.util.Base64Coder;
import org.keyczar.util.Util;

public class HmacKey extends KeyczarKey
{
  private final byte[] hash;
  private SecretKey hmacKey;
  private final String hmacKeyString;

  private HmacKey()
  {
    super(i);
    i = 4;
    byte[] arrayOfByte = new byte[i];
    this.hash = arrayOfByte;
    arrayOfByte = null;
    this.hmacKeyString = arrayOfByte;
  }

  private HmacKey(byte[] paramArrayOfByte)
    throws KeyczarException
  {
    super(i);
    i = 4;
    Object localObject = new byte[i];
    this.hash = ((byte[])localObject);
    localObject = Base64Coder.encodeWebSafe(paramArrayOfByte);
    this.hmacKeyString = ((String)localObject);
    initJceKey(paramArrayOfByte);
  }

  static HmacKey generate(KeyParameters paramKeyParameters)
    throws KeyczarException
  {
    HmacKey localHmacKey = new org/keyczar/HmacKey;
    int i = paramKeyParameters.getKeySize();
    i /= 8;
    byte[] arrayOfByte = Util.rand(i);
    localHmacKey.<init>(arrayOfByte);
    return localHmacKey;
  }

  final byte[] getEncoded()
  {
    Object localObject = this.hmacKey;
    localObject = ((SecretKey)localObject).getEncoded();
    return localObject;
  }

  protected final Stream getStream()
    throws KeyczarException
  {
    HmacKey.HmacStream localHmacStream = new org/keyczar/HmacKey$HmacStream;
    localHmacStream.<init>(this);
    return localHmacStream;
  }

  protected final byte[] hash()
  {
    byte[] arrayOfByte = this.hash;
    return arrayOfByte;
  }

  final void initFromJson()
    throws KeyczarException
  {
    Object localObject = this.hmacKeyString;
    localObject = Base64Coder.decodeWebSafe((String)localObject);
    initJceKey((byte[])localObject);
  }

  private void initJceKey(byte[] paramArrayOfByte)
    throws KeyczarException
  {
    int k = 0;
    SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
    Object localObject2 = "HMACSHA1";
    localSecretKeySpec.<init>(paramArrayOfByte, (String)localObject2);
    this.hmacKey = localSecretKeySpec;
    int i = 1;
    Object localObject1 = new byte[i][];
    localObject1[k] = paramArrayOfByte;
    localObject1 = Util.hash((byte[][])localObject1);
    localObject2 = this.hash;
    byte[] arrayOfByte = this.hash;
    int j = arrayOfByte.length;
    System.arraycopy(localObject1, k, localObject2, k, j);
  }

  static HmacKey read(String paramString)
    throws KeyczarException
  {
    Gson localGson = Util.gson();
    HmacKey localHmacKey = HmacKey.class;
    Object localObject = localGson.fromJson(paramString, localHmacKey);
    localObject = (HmacKey)localObject;
    ((HmacKey)localObject).initFromJson();
    return localObject;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.HmacKey
 * JD-Core Version:    0.6.2
 */
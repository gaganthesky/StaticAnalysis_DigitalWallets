package org.keyczar;

import java.util.Arrays;
import java.util.List;
import org.keyczar.interfaces.KeyType;
import org.keyczar.interfaces.KeyType.Builder;
import org.keyczar.keyparams.KeyParameters;

public enum DefaultKeyType
  implements KeyType
{
  private static final DefaultKeyType[] $VALUES = arrayOfDefaultKeyType;
  private final List acceptableSizes;

  static
  {
    int i23 = 4;
    int i22 = 3;
    int i21 = 2;
    int i20 = 0;
    int i19 = 1;
    DefaultKeyType localDefaultKeyType1 = new org/keyczar/DefaultKeyType;
    Object localObject1 = "AES";
    Object localObject2 = new Integer[i22];
    int m = 128;
    Integer localInteger1 = Integer.valueOf(m);
    localObject2[i20] = localInteger1;
    int n = 192;
    Integer localInteger2 = Integer.valueOf(n);
    localObject2[i19] = localInteger2;
    int i1 = 256;
    Integer localInteger3 = Integer.valueOf(i1);
    localObject2[i21] = localInteger3;
    localObject2 = Arrays.asList((Object[])localObject2);
    localDefaultKeyType1.<init>((String)localObject1, i20, (List)localObject2);
    AES = localDefaultKeyType1;
    localDefaultKeyType1 = new org/keyczar/DefaultKeyType;
    localObject1 = "HMAC_SHA1";
    localObject2 = new Integer[i19];
    int i2 = 256;
    Integer localInteger4 = Integer.valueOf(i2);
    localObject2[i20] = localInteger4;
    localObject2 = Arrays.asList((Object[])localObject2);
    localDefaultKeyType1.<init>((String)localObject1, i19, (List)localObject2);
    HMAC_SHA1 = localDefaultKeyType1;
    localDefaultKeyType1 = new org/keyczar/DefaultKeyType;
    localObject1 = "DSA_PRIV";
    localObject2 = new Integer[i19];
    int i3 = 1024;
    Integer localInteger5 = Integer.valueOf(i3);
    localObject2[i20] = localInteger5;
    localObject2 = Arrays.asList((Object[])localObject2);
    localDefaultKeyType1.<init>((String)localObject1, i21, (List)localObject2);
    DSA_PRIV = localDefaultKeyType1;
    localDefaultKeyType1 = new org/keyczar/DefaultKeyType;
    localObject1 = "DSA_PUB";
    localObject2 = new Integer[i19];
    int i4 = 1024;
    Integer localInteger6 = Integer.valueOf(i4);
    localObject2[i20] = localInteger6;
    localObject2 = Arrays.asList((Object[])localObject2);
    localDefaultKeyType1.<init>((String)localObject1, i22, (List)localObject2);
    DSA_PUB = localDefaultKeyType1;
    localDefaultKeyType1 = new org/keyczar/DefaultKeyType;
    localObject1 = "RSA_PRIV";
    localObject2 = new Integer[i22];
    int i5 = 4096;
    Integer localInteger7 = Integer.valueOf(i5);
    localObject2[i20] = localInteger7;
    int i6 = 2048;
    Integer localInteger8 = Integer.valueOf(i6);
    localObject2[i19] = localInteger8;
    int i7 = 1024;
    Object localObject3 = Integer.valueOf(i7);
    localObject2[i21] = localObject3;
    localObject2 = Arrays.asList((Object[])localObject2);
    localDefaultKeyType1.<init>((String)localObject1, i23, (List)localObject2);
    RSA_PRIV = localDefaultKeyType1;
    localDefaultKeyType1 = new org/keyczar/DefaultKeyType;
    localObject1 = "RSA_PUB";
    int k = 5;
    localObject3 = new Integer[i22];
    int i8 = 4096;
    Integer localInteger9 = Integer.valueOf(i8);
    localObject3[i20] = localInteger9;
    int i9 = 2048;
    Integer localInteger10 = Integer.valueOf(i9);
    localObject3[i19] = localInteger10;
    int i10 = 1024;
    Integer localInteger11 = Integer.valueOf(i10);
    localObject3[i21] = localInteger11;
    localObject3 = Arrays.asList((Object[])localObject3);
    localDefaultKeyType1.<init>((String)localObject1, k, (List)localObject3);
    RSA_PUB = localDefaultKeyType1;
    localDefaultKeyType1 = new org/keyczar/DefaultKeyType;
    localObject1 = "EC_PRIV";
    k = 6;
    localObject3 = new Integer[i23];
    int i11 = 256;
    Integer localInteger12 = Integer.valueOf(i11);
    localObject3[i20] = localInteger12;
    int i12 = 384;
    Integer localInteger13 = Integer.valueOf(i12);
    localObject3[i19] = localInteger13;
    int i13 = 521;
    Integer localInteger14 = Integer.valueOf(i13);
    localObject3[i21] = localInteger14;
    int i14 = 192;
    Integer localInteger15 = Integer.valueOf(i14);
    localObject3[i22] = localInteger15;
    localObject3 = Arrays.asList((Object[])localObject3);
    localDefaultKeyType1.<init>((String)localObject1, k, (List)localObject3);
    EC_PRIV = localDefaultKeyType1;
    localDefaultKeyType1 = new org/keyczar/DefaultKeyType;
    localObject1 = "EC_PUB";
    k = 7;
    localObject3 = new Integer[i23];
    int i15 = 256;
    Integer localInteger16 = Integer.valueOf(i15);
    localObject3[i20] = localInteger16;
    int i16 = 384;
    Integer localInteger17 = Integer.valueOf(i16);
    localObject3[i19] = localInteger17;
    int i17 = 521;
    Integer localInteger18 = Integer.valueOf(i17);
    localObject3[i21] = localInteger18;
    int i18 = 192;
    Integer localInteger19 = Integer.valueOf(i18);
    localObject3[i22] = localInteger19;
    localObject3 = Arrays.asList((Object[])localObject3);
    localDefaultKeyType1.<init>((String)localObject1, k, (List)localObject3);
    EC_PUB = localDefaultKeyType1;
    localDefaultKeyType1 = new org/keyczar/DefaultKeyType;
    localObject1 = "TEST";
    k = 8;
    localObject3 = new Integer[i19];
    localInteger19 = Integer.valueOf(i19);
    localObject3[i20] = localInteger19;
    localObject3 = Arrays.asList((Object[])localObject3);
    localDefaultKeyType1.<init>((String)localObject1, k, (List)localObject3);
    TEST = localDefaultKeyType1;
    int i = 9;
    DefaultKeyType[] arrayOfDefaultKeyType = new DefaultKeyType[i];
    localObject1 = AES;
    arrayOfDefaultKeyType[i20] = localObject1;
    localObject1 = HMAC_SHA1;
    arrayOfDefaultKeyType[i19] = localObject1;
    localObject1 = DSA_PRIV;
    arrayOfDefaultKeyType[i21] = localObject1;
    localObject1 = DSA_PUB;
    arrayOfDefaultKeyType[i22] = localObject1;
    localObject1 = RSA_PRIV;
    arrayOfDefaultKeyType[i23] = localObject1;
    int j = 5;
    DefaultKeyType localDefaultKeyType2 = RSA_PUB;
    arrayOfDefaultKeyType[j] = localDefaultKeyType2;
    j = 6;
    localDefaultKeyType2 = EC_PRIV;
    arrayOfDefaultKeyType[j] = localDefaultKeyType2;
    j = 7;
    localDefaultKeyType2 = EC_PUB;
    arrayOfDefaultKeyType[j] = localDefaultKeyType2;
    j = 8;
    localDefaultKeyType2 = TEST;
    arrayOfDefaultKeyType[j] = localDefaultKeyType2;
  }

  private DefaultKeyType(List<Integer> paramList)
  {
    this.acceptableSizes = paramList;
  }

  public final KeyParameters applyDefaultParameters(KeyParameters paramKeyParameters)
  {
    int[] arrayOfInt = DefaultKeyType.1.$SwitchMap$org$keyczar$DefaultKeyType;
    int j = ordinal();
    int i = arrayOfInt[j];
    Object localObject;
    switch (i)
    {
    default:
      localObject = new org/keyczar/DefaultKeyType$DefaultingKeyParameters;
      ((DefaultKeyType.DefaultingKeyParameters)localObject).<init>(this, paramKeyParameters);
    case 1:
    case 2:
    }
    while (true)
    {
      return localObject;
      localObject = new org/keyczar/DefaultKeyType$DefaultingRsaKeyParameters;
      ((DefaultKeyType.DefaultingRsaKeyParameters)localObject).<init>(this, paramKeyParameters);
      continue;
      localObject = new org/keyczar/DefaultKeyType$DefaultingAesKeyParameters;
      ((DefaultKeyType.DefaultingAesKeyParameters)localObject).<init>(this, paramKeyParameters);
    }
  }

  public final KeyType.Builder getBuilder()
  {
    DefaultKeyType.DefaultKeyBuilder localDefaultKeyBuilder = new org/keyczar/DefaultKeyType$DefaultKeyBuilder;
    DefaultKeyType.1 local1 = null;
    localDefaultKeyBuilder.<init>(this, local1);
    return localDefaultKeyBuilder;
  }

  public final String getName()
  {
    String str = name();
    return str;
  }

  final boolean isAcceptableSize(int paramInt)
  {
    List localList = this.acceptableSizes;
    Integer localInteger = Integer.valueOf(paramInt);
    boolean bool = localList.contains(localInteger);
    return bool;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.DefaultKeyType
 * JD-Core Version:    0.6.2
 */
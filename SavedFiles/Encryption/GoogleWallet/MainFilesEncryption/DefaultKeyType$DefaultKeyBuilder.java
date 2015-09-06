package org.keyczar;

import org.keyczar.exceptions.KeyczarException;
import org.keyczar.exceptions.UnsupportedTypeException;
import org.keyczar.interfaces.KeyType.Builder;

final class DefaultKeyType$DefaultKeyBuilder
  implements KeyType.Builder
{
  final DefaultKeyType this$0;

  private DefaultKeyType$DefaultKeyBuilder(DefaultKeyType paramDefaultKeyType)
  {
  }

  DefaultKeyType$DefaultKeyBuilder(DefaultKeyType paramDefaultKeyType, DefaultKeyType.1 param1)
  {
    this(paramDefaultKeyType);
  }

  public final KeyczarKey read(String paramString)
    throws KeyczarException
  {
    int[] arrayOfInt = DefaultKeyType.1.$SwitchMap$org$keyczar$DefaultKeyType;
    DefaultKeyType localDefaultKeyType1 = this.this$0;
    int j = localDefaultKeyType1.ordinal();
    int i = arrayOfInt[j];
    Object localObject;
    switch (i)
    {
    default:
      localObject = new org/keyczar/exceptions/UnsupportedTypeException;
      DefaultKeyType localDefaultKeyType2 = this.this$0;
      ((UnsupportedTypeException)localObject).<init>(localDefaultKeyType2);
      throw ((Throwable)localObject);
    case 2:
      localObject = AesKey.read(paramString);
    case 3:
    case 4:
    case 5:
    case 1:
    case 6:
    }
    while (true)
    {
      return localObject;
      localObject = HmacKey.read(paramString);
      continue;
      localObject = DsaPrivateKey.read(paramString);
      continue;
      localObject = DsaPublicKey.read(paramString);
      continue;
      localObject = RsaPrivateKey.read(paramString);
      continue;
      localObject = RsaPublicKey.read(paramString);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.DefaultKeyType.DefaultKeyBuilder
 * JD-Core Version:    0.6.2
 */
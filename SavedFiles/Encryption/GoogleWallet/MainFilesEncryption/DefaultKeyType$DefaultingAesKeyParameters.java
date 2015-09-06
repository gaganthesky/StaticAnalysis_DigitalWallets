package org.keyczar;

import org.keyczar.exceptions.KeyczarException;
import org.keyczar.keyparams.AesKeyParameters;
import org.keyczar.keyparams.KeyParameters;

final class DefaultKeyType$DefaultingAesKeyParameters extends DefaultKeyType.DefaultingKeyParameters
  implements AesKeyParameters
{
  final DefaultKeyType this$0;

  public DefaultKeyType$DefaultingAesKeyParameters(DefaultKeyType paramDefaultKeyType, KeyParameters paramKeyParameters)
  {
    super(paramDefaultKeyType, paramKeyParameters);
  }

  public final HmacKey getHmacKey()
    throws KeyczarException
  {
    Object localObject = DefaultKeyType.HMAC_SHA1;
    KeyParameters localKeyParameters = null;
    localObject = ((DefaultKeyType)localObject).applyDefaultParameters(localKeyParameters);
    localObject = HmacKey.generate((KeyParameters)localObject);
    return localObject;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.DefaultKeyType.DefaultingAesKeyParameters
 * JD-Core Version:    0.6.2
 */
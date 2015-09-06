package org.keyczar.keyparams;

import org.keyczar.HmacKey;
import org.keyczar.exceptions.KeyczarException;

public abstract interface AesKeyParameters extends KeyParameters
{
  public abstract HmacKey getHmacKey()
    throws KeyczarException;
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.keyparams.AesKeyParameters
 * JD-Core Version:    0.6.2
 */
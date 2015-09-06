package org.keyczar.interfaces;

import org.keyczar.KeyczarKey;
import org.keyczar.exceptions.KeyczarException;

public abstract interface KeyType$Builder
{
  public abstract KeyczarKey read(String paramString)
    throws KeyczarException;
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.interfaces.KeyType.Builder
 * JD-Core Version:    0.6.2
 */
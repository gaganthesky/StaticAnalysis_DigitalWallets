package org.keyczar.keyparams;

import org.keyczar.exceptions.KeyczarException;

public abstract interface KeyParameters
{
  public abstract int getKeySize()
    throws KeyczarException;
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.keyparams.KeyParameters
 * JD-Core Version:    0.6.2
 */
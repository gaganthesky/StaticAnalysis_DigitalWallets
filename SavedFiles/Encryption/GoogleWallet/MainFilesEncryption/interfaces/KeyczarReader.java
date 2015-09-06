package org.keyczar.interfaces;

import org.keyczar.exceptions.KeyczarException;

public abstract interface KeyczarReader
{
  public abstract String getKey(int paramInt)
    throws KeyczarException;

  public abstract String getMetadata()
    throws KeyczarException;
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.interfaces.KeyczarReader
 * JD-Core Version:    0.6.2
 */
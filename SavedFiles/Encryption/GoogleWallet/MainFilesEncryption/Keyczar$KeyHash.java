package org.keyczar;

import org.keyczar.util.Util;

final class Keyczar$KeyHash
{
  private byte[] data;
  final Keyczar this$0;

  private Keyczar$KeyHash(Keyczar paramKeyczar, byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = 4;
    if (i != j)
    {
      IllegalArgumentException localIllegalArgumentException = new java/lang/IllegalArgumentException;
      localIllegalArgumentException.<init>();
      throw localIllegalArgumentException;
    }
    this.data = paramArrayOfByte;
  }

  Keyczar$KeyHash(Keyczar paramKeyczar, byte[] paramArrayOfByte, Keyczar.1 param1)
  {
    this(paramKeyczar, paramArrayOfByte);
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool = paramObject instanceof KeyHash;
    if (bool)
    {
      i = paramObject.hashCode();
      int k = hashCode();
      if (i != k);
    }
    int j;
    for (int i = 1; ; j = 0)
      return i;
  }

  public final int hashCode()
  {
    byte[] arrayOfByte = this.data;
    int i = Util.toInt(arrayOfByte);
    return i;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.Keyczar.KeyHash
 * JD-Core Version:    0.6.2
 */
package org.keyczar;

import com.google.gson.Gson;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.Stream;
import org.keyczar.util.Util;

public abstract class KeyczarKey
{
  final int size;

  protected KeyczarKey(int paramInt)
  {
    this.size = paramInt;
  }

  final void copyHeader(ByteBuffer paramByteBuffer)
  {
    byte b = 0;
    paramByteBuffer.put(b);
    byte[] arrayOfByte = hash();
    paramByteBuffer.put(arrayOfByte);
  }

  public boolean equals(Object paramObject)
  {
    Object localObject1 = paramObject;
    try
    {
      localObject1 = (KeyczarKey)localObject1;
      Object localObject2 = localObject1;
      byte[] arrayOfByte1 = localObject2.hash();
      byte[] arrayOfByte2 = hash();
      boolean bool = Arrays.equals(arrayOfByte1, arrayOfByte2);
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      while (true)
        int i = 0;
    }
  }

  protected abstract Stream getStream()
    throws KeyczarException;

  protected abstract byte[] hash();

  public int hashCode()
  {
    byte[] arrayOfByte = hash();
    int i = Util.toInt(arrayOfByte);
    return i;
  }

  public String toString()
  {
    Object localObject = Util.gson();
    localObject = ((Gson)localObject).toJson(this);
    return localObject;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.KeyczarKey
 * JD-Core Version:    0.6.2
 */
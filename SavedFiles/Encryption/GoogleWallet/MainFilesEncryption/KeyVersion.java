package org.keyczar;

import com.google.gson.Gson;
import org.keyczar.enums.KeyStatus;
import org.keyczar.util.Util;

public final class KeyVersion
{
  private boolean exportable;
  private KeyStatus status;
  private int versionNumber;

  private KeyVersion()
  {
    this.exportable = i;
    KeyStatus localKeyStatus = KeyStatus.ACTIVE;
    this.status = localKeyStatus;
    this.versionNumber = i;
  }

  public KeyVersion(int paramInt, KeyStatus paramKeyStatus, boolean paramBoolean)
  {
    this.exportable = i;
    KeyStatus localKeyStatus = KeyStatus.ACTIVE;
    this.status = localKeyStatus;
    this.versionNumber = i;
    this.versionNumber = paramInt;
    this.status = paramKeyStatus;
    this.exportable = paramBoolean;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    boolean bool2 = paramObject instanceof KeyVersion;
    if (!bool2);
    while (true)
    {
      return bool1;
      Object localObject = paramObject;
      localObject = (KeyVersion)localObject;
      int i = getVersionNumber();
      int j = ((KeyVersion)localObject).getVersionNumber();
      if (i == j)
        bool1 = true;
    }
  }

  public final KeyStatus getStatus()
  {
    KeyStatus localKeyStatus = this.status;
    return localKeyStatus;
  }

  public final int getVersionNumber()
  {
    int i = this.versionNumber;
    return i;
  }

  public final int hashCode()
  {
    int i = this.versionNumber;
    return i;
  }

  public final String toString()
  {
    Object localObject = Util.gson();
    localObject = ((Gson)localObject).toJson(this);
    return localObject;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.KeyVersion
 * JD-Core Version:    0.6.2
 */
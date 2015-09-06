package org.keyczar.enums;

public enum KeyStatus
{
  private static final KeyStatus[] $VALUES = arrayOfKeyStatus;
  private String name;
  private int value;

  static
  {
    int m = 2;
    int k = 1;
    int j = 0;
    KeyStatus localKeyStatus = new org/keyczar/enums/KeyStatus;
    Object localObject = "PRIMARY";
    String str = "primary";
    localKeyStatus.<init>((String)localObject, j, j, str);
    PRIMARY = localKeyStatus;
    localKeyStatus = new org/keyczar/enums/KeyStatus;
    localObject = "ACTIVE";
    str = "active";
    localKeyStatus.<init>((String)localObject, k, k, str);
    ACTIVE = localKeyStatus;
    localKeyStatus = new org/keyczar/enums/KeyStatus;
    localObject = "INACTIVE";
    str = "inactive";
    localKeyStatus.<init>((String)localObject, m, m, str);
    INACTIVE = localKeyStatus;
    int i = 3;
    KeyStatus[] arrayOfKeyStatus = new KeyStatus[i];
    localObject = PRIMARY;
    arrayOfKeyStatus[j] = localObject;
    localObject = ACTIVE;
    arrayOfKeyStatus[k] = localObject;
    localObject = INACTIVE;
    arrayOfKeyStatus[m] = localObject;
  }

  private KeyStatus(int paramInt, String paramString)
  {
    this.value = paramInt;
    this.name = paramString;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.enums.KeyStatus
 * JD-Core Version:    0.6.2
 */
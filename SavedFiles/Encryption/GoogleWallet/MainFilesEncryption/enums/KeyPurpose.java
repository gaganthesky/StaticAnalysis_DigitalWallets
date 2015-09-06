package org.keyczar.enums;

public enum KeyPurpose
{
  private static final KeyPurpose[] $VALUES = arrayOfKeyPurpose;
  private String name;
  private int value;

  static
  {
    int i2 = 4;
    int i1 = 3;
    int n = 2;
    int m = 1;
    int k = 0;
    KeyPurpose localKeyPurpose = new org/keyczar/enums/KeyPurpose;
    Object localObject = "DECRYPT_AND_ENCRYPT";
    String str1 = "crypt";
    localKeyPurpose.<init>((String)localObject, k, k, str1);
    DECRYPT_AND_ENCRYPT = localKeyPurpose;
    localKeyPurpose = new org/keyczar/enums/KeyPurpose;
    localObject = "ENCRYPT";
    str1 = "encrypt";
    localKeyPurpose.<init>((String)localObject, m, m, str1);
    ENCRYPT = localKeyPurpose;
    localKeyPurpose = new org/keyczar/enums/KeyPurpose;
    localObject = "SIGN_AND_VERIFY";
    str1 = "sign";
    localKeyPurpose.<init>((String)localObject, n, n, str1);
    SIGN_AND_VERIFY = localKeyPurpose;
    localKeyPurpose = new org/keyczar/enums/KeyPurpose;
    localObject = "VERIFY";
    str1 = "verify";
    localKeyPurpose.<init>((String)localObject, i1, i1, str1);
    VERIFY = localKeyPurpose;
    localKeyPurpose = new org/keyczar/enums/KeyPurpose;
    localObject = "TEST";
    int j = 127;
    String str2 = "test";
    localKeyPurpose.<init>((String)localObject, i2, j, str2);
    TEST = localKeyPurpose;
    int i = 5;
    KeyPurpose[] arrayOfKeyPurpose = new KeyPurpose[i];
    localObject = DECRYPT_AND_ENCRYPT;
    arrayOfKeyPurpose[k] = localObject;
    localObject = ENCRYPT;
    arrayOfKeyPurpose[m] = localObject;
    localObject = SIGN_AND_VERIFY;
    arrayOfKeyPurpose[n] = localObject;
    localObject = VERIFY;
    arrayOfKeyPurpose[i1] = localObject;
    localObject = TEST;
    arrayOfKeyPurpose[i2] = localObject;
  }

  private KeyPurpose(int paramInt, String paramString)
  {
    this.value = paramInt;
    this.name = paramString;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.enums.KeyPurpose
 * JD-Core Version:    0.6.2
 */
package org.keyczar.enums;

public enum CipherMode
{
  private static final CipherMode[] $VALUES = arrayOfCipherMode;
  private String jceMode;
  private int value;

  static
  {
    int i5 = 3;
    int i4 = 2;
    int m = 1;
    int j = 0;
    CipherMode localCipherMode1 = new org/keyczar/enums/CipherMode;
    Object localObject = "CBC";
    String str1 = "AES/CBC/PKCS5Padding";
    int k = j;
    localCipherMode1.<init>((String)localObject, j, k, str1, m);
    CBC = localCipherMode1;
    CipherMode localCipherMode2 = new org/keyczar/enums/CipherMode;
    str1 = "CTR";
    String str2 = "AES/CTR/NoPadding";
    int n = m;
    int i1 = m;
    localCipherMode2.<init>(str1, m, n, str2, i1);
    CTR = localCipherMode2;
    CipherMode localCipherMode3 = new org/keyczar/enums/CipherMode;
    str2 = "ECB";
    String str3 = "AES/ECB/NoPadding";
    i1 = i4;
    int i2 = i4;
    int i3 = j;
    localCipherMode3.<init>(str2, i1, i2, str3, i3);
    ECB = localCipherMode3;
    localCipherMode3 = new org/keyczar/enums/CipherMode;
    str2 = "DET_CBC";
    str3 = "AES/CBC/PKCS5Padding";
    i1 = i5;
    i2 = i5;
    i3 = j;
    localCipherMode3.<init>(str2, i1, i2, str3, i3);
    DET_CBC = localCipherMode3;
    int i = 4;
    CipherMode[] arrayOfCipherMode = new CipherMode[i];
    localObject = CBC;
    arrayOfCipherMode[j] = localObject;
    localObject = CTR;
    arrayOfCipherMode[m] = localObject;
    localObject = ECB;
    arrayOfCipherMode[i4] = localObject;
    localObject = DET_CBC;
    arrayOfCipherMode[i5] = localObject;
  }

  private CipherMode(int paramInt, String paramString, boolean paramBoolean)
  {
    this.value = paramInt;
    this.jceMode = paramString;
  }

  public final String getMode()
  {
    String str = this.jceMode;
    return str;
  }

  public final int getOutputSize(int paramInt1, int paramInt2)
  {
    CipherMode localCipherMode1 = CBC;
    if (this == localCipherMode1)
    {
      int i = paramInt2 / paramInt1;
      i += 2;
      paramInt1 *= i;
    }
    while (true)
    {
      return paramInt1;
      CipherMode localCipherMode2 = ECB;
      if (this != localCipherMode2)
      {
        localCipherMode2 = CTR;
        if (this == localCipherMode2)
        {
          int j = paramInt1 / 2;
          paramInt1 = paramInt2 + j;
        }
        else
        {
          CipherMode localCipherMode3 = DET_CBC;
          if (this == localCipherMode3)
          {
            int k = paramInt2 / paramInt1;
            k += 1;
            paramInt1 *= k;
          }
          else
          {
            paramInt1 = 0;
          }
        }
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.enums.CipherMode
 * JD-Core Version:    0.6.2
 */
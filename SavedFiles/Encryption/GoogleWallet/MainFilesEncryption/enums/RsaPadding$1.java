package org.keyczar.enums;

final class RsaPadding$1
{
  static final int[] $SwitchMap$org$keyczar$enums$RsaPadding = arrayOfInt;

  static
  {
    RsaPadding[] arrayOfRsaPadding = RsaPadding.values();
    int i = arrayOfRsaPadding.length;
    int[] arrayOfInt = new int[i];
    try
    {
      arrayOfInt = $SwitchMap$org$keyczar$enums$RsaPadding;
      RsaPadding localRsaPadding1 = RsaPadding.OAEP;
      int j = localRsaPadding1.ordinal();
      int m = 1;
      arrayOfInt[j] = m;
      try
      {
        label35: arrayOfInt = $SwitchMap$org$keyczar$enums$RsaPadding;
        RsaPadding localRsaPadding2 = RsaPadding.PKCS;
        int k = localRsaPadding2.ordinal();
        m = 2;
        arrayOfInt[k] = m;
        label54: return;
      }
      catch (NoSuchFieldError localNoSuchFieldError1)
      {
        break label54;
      }
    }
    catch (NoSuchFieldError localNoSuchFieldError2)
    {
      break label35;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.enums.RsaPadding.1
 * JD-Core Version:    0.6.2
 */
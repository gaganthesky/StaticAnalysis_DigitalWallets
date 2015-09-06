package org.keyczar;

final class DefaultKeyType$1
{
  static final int[] $SwitchMap$org$keyczar$DefaultKeyType = arrayOfInt;

  static
  {
    DefaultKeyType[] arrayOfDefaultKeyType = DefaultKeyType.values();
    int i = arrayOfDefaultKeyType.length;
    int[] arrayOfInt = new int[i];
    try
    {
      arrayOfInt = $SwitchMap$org$keyczar$DefaultKeyType;
      DefaultKeyType localDefaultKeyType1 = DefaultKeyType.RSA_PRIV;
      int j = localDefaultKeyType1.ordinal();
      int i3 = 1;
      arrayOfInt[j] = i3;
      try
      {
        label35: arrayOfInt = $SwitchMap$org$keyczar$DefaultKeyType;
        DefaultKeyType localDefaultKeyType2 = DefaultKeyType.AES;
        int k = localDefaultKeyType2.ordinal();
        i3 = 2;
        arrayOfInt[k] = i3;
        try
        {
          label54: arrayOfInt = $SwitchMap$org$keyczar$DefaultKeyType;
          DefaultKeyType localDefaultKeyType3 = DefaultKeyType.HMAC_SHA1;
          int m = localDefaultKeyType3.ordinal();
          i3 = 3;
          arrayOfInt[m] = i3;
          try
          {
            label73: arrayOfInt = $SwitchMap$org$keyczar$DefaultKeyType;
            DefaultKeyType localDefaultKeyType4 = DefaultKeyType.DSA_PRIV;
            int n = localDefaultKeyType4.ordinal();
            i3 = 4;
            arrayOfInt[n] = i3;
            try
            {
              label92: arrayOfInt = $SwitchMap$org$keyczar$DefaultKeyType;
              DefaultKeyType localDefaultKeyType5 = DefaultKeyType.DSA_PUB;
              int i1 = localDefaultKeyType5.ordinal();
              i3 = 5;
              arrayOfInt[i1] = i3;
              try
              {
                label111: arrayOfInt = $SwitchMap$org$keyczar$DefaultKeyType;
                DefaultKeyType localDefaultKeyType6 = DefaultKeyType.RSA_PUB;
                int i2 = localDefaultKeyType6.ordinal();
                i3 = 6;
                arrayOfInt[i2] = i3;
                label131: return;
              }
              catch (NoSuchFieldError localNoSuchFieldError1)
              {
                break label131;
              }
            }
            catch (NoSuchFieldError localNoSuchFieldError2)
            {
              break label111;
            }
          }
          catch (NoSuchFieldError localNoSuchFieldError3)
          {
            break label92;
          }
        }
        catch (NoSuchFieldError localNoSuchFieldError4)
        {
          break label73;
        }
      }
      catch (NoSuchFieldError localNoSuchFieldError5)
      {
        break label54;
      }
    }
    catch (NoSuchFieldError localNoSuchFieldError6)
    {
      break label35;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.DefaultKeyType.1
 * JD-Core Version:    0.6.2
 */
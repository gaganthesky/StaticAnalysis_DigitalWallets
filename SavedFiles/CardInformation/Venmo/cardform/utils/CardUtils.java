package com.braintreepayments.cardform.utils;

public class CardUtils
{
  public static boolean isLuhnValid(String paramString)
  {
    int i1 = 1;
    Object localObject2 = 0;
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>(paramString);
    localStringBuffer = localStringBuffer.reverse();
    String str1 = localStringBuffer.toString();
    int m = str1.length();
    int n = 0;
    int j = 0;
    int k = 0;
    Object localObject1;
    if (k < m)
    {
      char c = str1.charAt(k);
      boolean bool = Character.isDigit(c);
      if (!bool)
      {
        IllegalArgumentException localIllegalArgumentException = new java/lang/IllegalArgumentException;
        String str2 = "Not a digit: '%s'";
        localObject1 = new Object[i1];
        Character localCharacter = Character.valueOf(c);
        localObject1[localObject2] = localCharacter;
        localObject1 = String.format(str2, (Object[])localObject1);
        localIllegalArgumentException.<init>((String)localObject1);
        throw localIllegalArgumentException;
      }
      i2 = 10;
      int i = Character.digit(c, i2);
      i2 = k % 2;
      if (i2 == 0)
        n += i;
      while (true)
      {
        k += 1;
        break;
        i2 = i / 5;
        int i3 = i * 2;
        i3 %= 10;
        i2 += i3;
        j += i2;
      }
    }
    int i2 = n + j;
    i2 %= 10;
    if (i2 == 0);
    while (true)
    {
      return localObject1;
      localObject1 = localObject2;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.braintreepayments.cardform.utils.CardUtils
 * JD-Core Version:    0.6.2
 */
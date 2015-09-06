package com.braintreepayments.cardform.utils;

import android.text.TextUtils;
import com.braintreepayments.cardform.R.drawable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum CardType
{
  private static final CardType[] $VALUES;
  private static final int[] AMEX_SPACE_INDICES;
  private static final int[] DEFAULT_SPACE_INDICES = arrayOfInt2;
  private final int mFrontResource;
  private final int mMaxCardLength;
  private final int mMinCardLength;
  private final Pattern mPattern;
  private final int mSecurityCodeLength;

  static
  {
    CardType localCardType1 = new com/braintreepayments/cardform/utils/CardType;
    String str1 = "VISA";
    int n = 0;
    String str2 = "^4\\d*";
    int i1 = R.drawable.bt_visa;
    int i2 = 16;
    int i3 = 16;
    int i4 = 3;
    localCardType1.<init>(str1, n, str2, i1, i2, i3, i4);
    VISA = localCardType1;
    localCardType1 = new com/braintreepayments/cardform/utils/CardType;
    str1 = "MASTERCARD";
    n = 1;
    str2 = "^5[1-5]\\d*";
    i1 = R.drawable.bt_mastercard;
    i2 = 16;
    i3 = 16;
    i4 = 3;
    localCardType1.<init>(str1, n, str2, i1, i2, i3, i4);
    MASTERCARD = localCardType1;
    localCardType1 = new com/braintreepayments/cardform/utils/CardType;
    str1 = "DISCOVER";
    n = 2;
    str2 = "^(6011|65|64[4-9]|622)\\d*";
    i1 = R.drawable.bt_discover;
    i2 = 16;
    i3 = 16;
    i4 = 3;
    localCardType1.<init>(str1, n, str2, i1, i2, i3, i4);
    DISCOVER = localCardType1;
    localCardType1 = new com/braintreepayments/cardform/utils/CardType;
    str1 = "AMEX";
    n = 3;
    str2 = "^3[47]\\d*";
    i1 = R.drawable.bt_amex;
    i2 = 15;
    i3 = 15;
    i4 = 4;
    localCardType1.<init>(str1, n, str2, i1, i2, i3, i4);
    AMEX = localCardType1;
    localCardType1 = new com/braintreepayments/cardform/utils/CardType;
    str1 = "DINERS_CLUB";
    n = 4;
    str2 = "^(36|38|30[0-5])\\d*";
    i1 = R.drawable.bt_diners;
    i2 = 14;
    i3 = 14;
    i4 = 3;
    localCardType1.<init>(str1, n, str2, i1, i2, i3, i4);
    DINERS_CLUB = localCardType1;
    localCardType1 = new com/braintreepayments/cardform/utils/CardType;
    str1 = "JCB";
    n = 5;
    str2 = "^35\\d*";
    i1 = R.drawable.bt_jcb;
    i2 = 16;
    i3 = 16;
    i4 = 3;
    localCardType1.<init>(str1, n, str2, i1, i2, i3, i4);
    JCB = localCardType1;
    localCardType1 = new com/braintreepayments/cardform/utils/CardType;
    str1 = "MAESTRO";
    n = 6;
    str2 = "^(5018|5020|5038|6304|6759|676[1-3])\\d*";
    i1 = R.drawable.bt_maestro;
    i2 = 12;
    i3 = 19;
    i4 = 3;
    localCardType1.<init>(str1, n, str2, i1, i2, i3, i4);
    MAESTRO = localCardType1;
    localCardType1 = new com/braintreepayments/cardform/utils/CardType;
    str1 = "UNION_PAY";
    n = 7;
    str2 = "^62\\d*";
    i1 = R.drawable.bt_card_highlighted;
    i2 = 16;
    i3 = 19;
    i4 = 3;
    localCardType1.<init>(str1, n, str2, i1, i2, i3, i4);
    UNION_PAY = localCardType1;
    localCardType1 = new com/braintreepayments/cardform/utils/CardType;
    str1 = "UNKNOWN";
    n = 8;
    str2 = "";
    i1 = R.drawable.bt_card_highlighted;
    i2 = 12;
    i3 = 19;
    i4 = 3;
    localCardType1.<init>(str1, n, str2, i1, i2, i3, i4);
    UNKNOWN = localCardType1;
    int i = 9;
    CardType[] arrayOfCardType = new CardType[i];
    int m = 0;
    CardType localCardType2 = VISA;
    arrayOfCardType[m] = localCardType2;
    m = 1;
    localCardType2 = MASTERCARD;
    arrayOfCardType[m] = localCardType2;
    m = 2;
    localCardType2 = DISCOVER;
    arrayOfCardType[m] = localCardType2;
    m = 3;
    localCardType2 = AMEX;
    arrayOfCardType[m] = localCardType2;
    m = 4;
    localCardType2 = DINERS_CLUB;
    arrayOfCardType[m] = localCardType2;
    m = 5;
    localCardType2 = JCB;
    arrayOfCardType[m] = localCardType2;
    m = 6;
    localCardType2 = MAESTRO;
    arrayOfCardType[m] = localCardType2;
    m = 7;
    localCardType2 = UNION_PAY;
    arrayOfCardType[m] = localCardType2;
    m = 8;
    localCardType2 = UNKNOWN;
    arrayOfCardType[m] = localCardType2;
    $VALUES = arrayOfCardType;
    int j = 2;
    int[] arrayOfInt1 = new int[j];
    arrayOfInt1[0] = 4;
    arrayOfInt1[1] = 10;
    AMEX_SPACE_INDICES = arrayOfInt1;
    int k = 3;
    int[] arrayOfInt2 = new int[k];
    arrayOfInt2[0] = 4;
    arrayOfInt2[1] = 8;
    arrayOfInt2[2] = 12;
  }

  private CardType(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Pattern localPattern = Pattern.compile(paramString);
    this.mPattern = localPattern;
    this.mFrontResource = paramInt1;
    this.mMinCardLength = paramInt2;
    this.mMaxCardLength = paramInt3;
    this.mSecurityCodeLength = paramInt4;
  }

  public static CardType forCardNumber(String paramString)
  {
    CardType[] arrayOfCardType = values();
    int j = arrayOfCardType.length;
    int i = 0;
    CardType localCardType;
    if (i < j)
    {
      localCardType = arrayOfCardType[i];
      Pattern localPattern = localCardType.getPattern();
      Matcher localMatcher = localPattern.matcher(paramString);
      boolean bool = localMatcher.matches();
      if (!bool);
    }
    while (true)
    {
      return localCardType;
      i += 1;
      break;
      localCardType = UNKNOWN;
    }
  }

  public int getFrontResource()
  {
    int i = this.mFrontResource;
    return i;
  }

  public int getMaxCardLength()
  {
    int i = this.mMaxCardLength;
    return i;
  }

  public Pattern getPattern()
  {
    Pattern localPattern = this.mPattern;
    return localPattern;
  }

  public int getSecurityCodeLength()
  {
    int i = this.mSecurityCodeLength;
    return i;
  }

  public int getSecurityCodeResource()
  {
    CardType localCardType = AMEX;
    if (this == localCardType);
    for (int i = R.drawable.bt_cid_highlighted; ; i = R.drawable.bt_cvv_highlighted)
      return i;
  }

  public int[] getSpaceIndices()
  {
    Object localObject = AMEX;
    if (this == localObject);
    for (localObject = AMEX_SPACE_INDICES; ; localObject = DEFAULT_SPACE_INDICES)
      return localObject;
  }

  public boolean validate(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = TextUtils.isEmpty(paramString);
    if (bool2);
    while (true)
    {
      return bool1;
      int i = paramString.length();
      int j = this.mMinCardLength;
      if (i >= j)
      {
        j = this.mMaxCardLength;
        if (i <= j)
        {
          Object localObject = this.mPattern;
          localObject = ((Pattern)localObject).matcher(paramString);
          boolean bool3 = ((Matcher)localObject).matches();
          if (bool3)
            bool1 = CardUtils.isLuhnValid(paramString);
        }
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.braintreepayments.cardform.utils.CardType
 * JD-Core Version:    0.6.2
 */
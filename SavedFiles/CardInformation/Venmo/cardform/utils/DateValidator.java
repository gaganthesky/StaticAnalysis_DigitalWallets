package com.braintreepayments.cardform.utils;

import android.text.TextUtils;
import java.util.Calendar;

public class DateValidator
{
  private static final DateValidator INSTANCE = localDateValidator;
  private final Calendar mCalendar;

  static
  {
    DateValidator localDateValidator = new com/braintreepayments/cardform/utils/DateValidator;
    Calendar localCalendar = Calendar.getInstance();
    localDateValidator.<init>(localCalendar);
  }

  protected DateValidator(Calendar paramCalendar)
  {
    this.mCalendar = paramCalendar;
  }

  private int getCurrentMonth()
  {
    Calendar localCalendar = this.mCalendar;
    int j = 2;
    int i = localCalendar.get(j);
    i += 1;
    return i;
  }

  private int getCurrentTwoDigitYear()
  {
    Calendar localCalendar = this.mCalendar;
    int j = 1;
    int i = localCalendar.get(j);
    i %= 100;
    return i;
  }

  public static boolean isValid(String paramString1, String paramString2)
  {
    DateValidator localDateValidator = INSTANCE;
    boolean bool = localDateValidator.isValidHelper(paramString1, paramString2);
    return bool;
  }

  protected boolean isValidHelper(String paramString1, String paramString2)
  {
    int i1 = 1;
    boolean bool1 = false;
    boolean bool2 = TextUtils.isEmpty(paramString1);
    if (bool2);
    int k;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool2 = TextUtils.isEmpty(paramString2);
            }
            while (bool2);
            bool2 = TextUtils.isDigitsOnly(paramString1);
          }
          while (!bool2);
          bool2 = TextUtils.isDigitsOnly(paramString2);
        }
        while (!bool2);
        k = Integer.parseInt(paramString1);
      }
      while (k < i1);
      i2 = 12;
    }
    while (k > i2);
    int j = getCurrentTwoDigitYear();
    int n = paramString2.length();
    int i2 = 2;
    if (n == i2);
    for (int m = Integer.parseInt(paramString2); ; m = i2 & 0x64)
    {
      if (m == j)
      {
        i2 = getCurrentMonth();
        if (k < i2)
          break;
      }
      if (m < j)
      {
        int i = m + 100;
        i2 = i - j;
        int i3 = 20;
        if (i2 > i3)
          break;
      }
      bool1 = i1;
      break;
      i2 = 4;
      if (n != i2)
        break;
      i2 = Integer.parseInt(paramString2);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.braintreepayments.cardform.utils.DateValidator
 * JD-Core Version:    0.6.2
 */
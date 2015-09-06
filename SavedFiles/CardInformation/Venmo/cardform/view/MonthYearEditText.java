package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import com.braintreepayments.cardform.utils.DateValidator;

public class MonthYearEditText extends FloatingLabelEditText
{
  private boolean mChangeWasAddition;

  public MonthYearEditText(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public MonthYearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  public MonthYearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void addDateSlash(Editable paramEditable)
  {
    int n = 2;
    int i = 2;
    int j = paramEditable.length();
    if (n <= j)
    {
      SlashSpan localSlashSpan = new com/braintreepayments/cardform/view/SlashSpan;
      localSlashSpan.<init>();
      int k = 1;
      int m = 33;
      paramEditable.setSpan(localSlashSpan, k, n, m);
    }
  }

  public void afterTextChanged(Editable paramEditable)
  {
    int i6 = 0;
    boolean bool1 = this.mChangeWasAddition;
    if (bool1)
    {
      int k = paramEditable.length();
      int i2 = 1;
      if (k == i2)
      {
        k = paramEditable.charAt(i6);
        m = Character.getNumericValue(k);
        int i3 = 2;
        if (m >= i3)
          prependLeadingZero(paramEditable);
      }
    }
    int m = paramEditable.length();
    SlashSpan localSlashSpan = SlashSpan.class;
    Object[] arrayOfObject2 = paramEditable.getSpans(i6, m, localSlashSpan);
    Object[] arrayOfObject1 = arrayOfObject2;
    int j = arrayOfObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfObject1[i];
      paramEditable.removeSpan(localObject);
      i += 1;
    }
    boolean bool2 = this.mRightToLeftLanguage;
    if (!bool2)
      addDateSlash(paramEditable);
    super.afterTextChanged(paramEditable);
    int n = getSelectionStart();
    int i4 = 4;
    if (n == i4)
    {
      String str1 = paramEditable.toString();
      String str2 = "20";
      boolean bool3 = str1.endsWith(str2);
      if (!bool3);
    }
    else
    {
      int i1 = getSelectionStart();
      int i5 = 6;
      if (i1 != i5)
        return;
    }
    focusNext();
  }

  public String getMonth()
  {
    int k = 2;
    String str1 = getString();
    int i = str1.length();
    if (i < k);
    int j;
    for (String str2 = ""; ; str2 = str2.substring(j, k))
    {
      return str2;
      str2 = getString();
      j = 0;
    }
  }

  private String getString()
  {
    Editable localEditable = getText();
    if (localEditable != null);
    for (String str = localEditable.toString(); ; str = "")
      return str;
  }

  public String getYear()
  {
    String str1 = getString();
    int i = str1.length();
    int j = 4;
    if (i != j)
    {
      i = str1.length();
      j = 6;
      if (i != j);
    }
    else
    {
      str2 = getString();
      j = 2;
    }
    for (String str2 = str2.substring(j); ; str2 = "")
      return str2;
  }

  private void init()
  {
    int i = 2;
    setInputType(i);
    i = 1;
    InputFilter[] arrayOfInputFilter = new InputFilter[i];
    i = 0;
    InputFilter.LengthFilter localLengthFilter = new android/text/InputFilter$LengthFilter;
    int j = 6;
    localLengthFilter.<init>(j);
    arrayOfInputFilter[i] = localLengthFilter;
    setFilters(arrayOfInputFilter);
  }

  public boolean isValid()
  {
    String str1 = getMonth();
    String str2 = getYear();
    boolean bool = DateValidator.isValid(str1, str2);
    return bool;
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (paramInt3 > paramInt2);
    for (boolean bool = true; ; bool = false)
    {
      this.mChangeWasAddition = bool;
      return;
    }
  }

  private void prependLeadingZero(Editable paramEditable)
  {
    int j = 0;
    char c = paramEditable.charAt(j);
    int i = 1;
    String str = "0";
    Editable localEditable = paramEditable.replace(j, i, str);
    localEditable.append(c);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.braintreepayments.cardform.view.MonthYearEditText
 * JD-Core Version:    0.6.2
 */
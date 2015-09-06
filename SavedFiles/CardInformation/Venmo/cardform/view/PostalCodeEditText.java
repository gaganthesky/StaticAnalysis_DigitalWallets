package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;

public class PostalCodeEditText extends FloatingLabelEditText
{
  public PostalCodeEditText(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public PostalCodeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  public PostalCodeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void init()
  {
    int i = 112;
    setInputType(i);
    i = 1;
    InputFilter[] arrayOfInputFilter = new InputFilter[i];
    i = 0;
    InputFilter.LengthFilter localLengthFilter = new android/text/InputFilter$LengthFilter;
    int j = 16;
    localLengthFilter.<init>(j);
    arrayOfInputFilter[i] = localLengthFilter;
    setFilters(arrayOfInputFilter);
  }

  public boolean isValid()
  {
    Object localObject = getText();
    localObject = localObject.toString();
    int i = ((String)localObject).length();
    if (i > 0);
    int j;
    for (i = 1; ; j = 0)
      return i;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.braintreepayments.cardform.view.PostalCodeEditText
 * JD-Core Version:    0.6.2
 */
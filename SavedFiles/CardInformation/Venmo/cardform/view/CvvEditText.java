package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View;
import com.braintreepayments.cardform.R.drawable;
import com.braintreepayments.cardform.utils.CardType;

public class CvvEditText extends FloatingLabelEditText
{
  private boolean mAlwaysDisplayHint;
  private CardType mCardType;

  public CvvEditText(Context paramContext)
  {
    super(paramContext);
    boolean bool = false;
    this.mAlwaysDisplayHint = bool;
    init();
  }

  public CvvEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = false;
    this.mAlwaysDisplayHint = bool;
    init();
  }

  public CvvEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = false;
    this.mAlwaysDisplayHint = bool;
    init();
  }

  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    CardType localCardType = this.mCardType;
    if (localCardType == null);
    while (true)
    {
      return;
      localCardType = this.mCardType;
      int i = localCardType.getSecurityCodeLength();
      int j = paramEditable.length();
      if (i == j)
      {
        i = getSelectionStart();
        j = paramEditable.length();
        if (i == j)
        {
          validate();
          boolean bool = isValid();
          if (bool)
            focusNext();
        }
      }
    }
  }

  private int getSecurityCodeLength()
  {
    CardType localCardType1 = this.mCardType;
    if (localCardType1 == null);
    CardType localCardType2;
    int j;
    for (int i = 3; ; j = localCardType2.getSecurityCodeLength())
    {
      return i;
      localCardType2 = this.mCardType;
    }
  }

  private void init()
  {
    int i = 2;
    setInputType(i);
    i = 1;
    InputFilter[] arrayOfInputFilter = new InputFilter[i];
    int j = 0;
    InputFilter.LengthFilter localLengthFilter = new android/text/InputFilter$LengthFilter;
    int k = 3;
    localLengthFilter.<init>(k);
    arrayOfInputFilter[j] = localLengthFilter;
    setFilters(arrayOfInputFilter);
  }

  public boolean isValid()
  {
    Object localObject = getText();
    localObject = localObject.toString();
    int i = ((String)localObject).length();
    int k = getSecurityCodeLength();
    if (i == k);
    int j;
    for (i = 1; ; j = 0)
      return i;
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    int j = 0;
    super.onFocusChange(paramView, paramBoolean);
    int i = 0;
    if (!paramBoolean)
    {
      boolean bool1 = this.mAlwaysDisplayHint;
      if (!bool1);
    }
    else
    {
      CardType localCardType1 = this.mCardType;
      if (localCardType1 != null)
        break label65;
      i = R.drawable.bt_cvv_highlighted;
    }
    boolean bool2 = this.mRightToLeftLanguage;
    if (bool2)
      setCompoundDrawablesWithIntrinsicBounds(i, j, j, j);
    while (true)
    {
      return;
      label65: CardType localCardType2 = this.mCardType;
      i = localCardType2.getSecurityCodeResource();
      break;
      setCompoundDrawablesWithIntrinsicBounds(j, j, i, j);
    }
  }

  public void setAlwaysDisplayHint(boolean paramBoolean)
  {
    this.mAlwaysDisplayHint = paramBoolean;
    invalidate();
  }

  public void setCardType(CardType paramCardType)
  {
    this.mCardType = paramCardType;
    int i = 1;
    InputFilter[] arrayOfInputFilter = new InputFilter[i];
    i = 0;
    InputFilter.LengthFilter localLengthFilter = new android/text/InputFilter$LengthFilter;
    int j = paramCardType.getSecurityCodeLength();
    localLengthFilter.<init>(j);
    arrayOfInputFilter[i] = localLengthFilter;
    setFilters(arrayOfInputFilter);
    invalidate();
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.braintreepayments.cardform.view.CvvEditText
 * JD-Core Version:    0.6.2
 */
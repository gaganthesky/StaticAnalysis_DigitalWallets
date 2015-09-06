package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import com.braintreepayments.cardform.R.drawable;
import com.braintreepayments.cardform.utils.CardType;

public class CardEditText extends FloatingLabelEditText
{
  private CardType mCardType;
  private CardEditText.OnCardTypeChangedListener mOnCardTypeChangedListener;

  public CardEditText(Context paramContext)
  {
    super(paramContext);
    CardType localCardType = CardType.UNKNOWN;
    this.mCardType = localCardType;
    init();
  }

  public CardEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    CardType localCardType = CardType.UNKNOWN;
    this.mCardType = localCardType;
    init();
  }

  public CardEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    CardType localCardType = CardType.UNKNOWN;
    this.mCardType = localCardType;
    init();
  }

  private void addSpans(Editable paramEditable, int[] paramArrayOfInt)
  {
    int m = paramEditable.length();
    int[] arrayOfInt = paramArrayOfInt;
    int k = arrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      int j = arrayOfInt[i];
      if (j <= m)
      {
        SpaceSpan localSpaceSpan = new com/braintreepayments/cardform/view/SpaceSpan;
        localSpaceSpan.<init>();
        int n = j + -1;
        int i1 = 33;
        paramEditable.setSpan(localSpaceSpan, n, j, i1);
      }
      i += 1;
    }
  }

  public void afterTextChanged(Editable paramEditable)
  {
    int k = 0;
    int i1 = paramEditable.length();
    SpaceSpan localSpaceSpan = SpaceSpan.class;
    Object[] arrayOfObject2 = paramEditable.getSpans(k, i1, localSpaceSpan);
    Object[] arrayOfObject1 = arrayOfObject2;
    int j = arrayOfObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = arrayOfObject1[i];
      paramEditable.removeSpan(localObject1);
      i += 1;
    }
    updateCardType();
    CardType localCardType = this.mCardType;
    int m = localCardType.getFrontResource();
    setCardIcon(m);
    boolean bool1 = this.mRightToLeftLanguage;
    if (!bool1)
    {
      localObject2 = this.mCardType;
      localObject2 = ((CardType)localObject2).getSpaceIndices();
      addSpans(paramEditable, (int[])localObject2);
    }
    super.afterTextChanged(paramEditable);
    Object localObject2 = this.mCardType;
    int n = ((CardType)localObject2).getMaxCardLength();
    i1 = getSelectionStart();
    if (n == i1)
    {
      validate();
      boolean bool2 = isValid();
      if (bool2)
        focusNext();
    }
  }

  public CardType getCardType()
  {
    CardType localCardType = this.mCardType;
    return localCardType;
  }

  private void init()
  {
    int i = 2;
    setInputType(i);
    i = R.drawable.bt_card_highlighted;
    setCardIcon(i);
  }

  public boolean isValid()
  {
    CardType localCardType = this.mCardType;
    Object localObject = getText();
    localObject = localObject.toString();
    boolean bool = localCardType.validate((String)localObject);
    return bool;
  }

  private void setCardIcon(int paramInt)
  {
    int i = 0;
    boolean bool = this.mRightToLeftLanguage;
    if (bool)
      setCompoundDrawablesWithIntrinsicBounds(paramInt, i, i, i);
    while (true)
    {
      return;
      setCompoundDrawablesWithIntrinsicBounds(i, i, paramInt, i);
    }
  }

  public void setOnCardTypeChangedListener(CardEditText.OnCardTypeChangedListener paramOnCardTypeChangedListener)
  {
    this.mOnCardTypeChangedListener = paramOnCardTypeChangedListener;
  }

  private void updateCardType()
  {
    Object localObject1 = getText();
    localObject1 = localObject1.toString();
    CardType localCardType1 = CardType.forCardNumber((String)localObject1);
    localObject1 = this.mCardType;
    if (localObject1 != localCardType1)
    {
      this.mCardType = localCardType1;
      int i = 1;
      InputFilter[] arrayOfInputFilter = new InputFilter[i];
      i = 0;
      Object localObject2 = new android/text/InputFilter$LengthFilter;
      CardType localCardType2 = this.mCardType;
      int j = localCardType2.getMaxCardLength();
      ((InputFilter.LengthFilter)localObject2).<init>(j);
      arrayOfInputFilter[i] = localObject2;
      setFilters(arrayOfInputFilter);
      invalidate();
      CardEditText.OnCardTypeChangedListener localOnCardTypeChangedListener = this.mOnCardTypeChangedListener;
      if (localOnCardTypeChangedListener != null)
      {
        localOnCardTypeChangedListener = this.mOnCardTypeChangedListener;
        localObject2 = this.mCardType;
        localOnCardTypeChangedListener.onCardTypeChanged((CardType)localObject2);
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.braintreepayments.cardform.view.CardEditText
 * JD-Core Version:    0.6.2
 */
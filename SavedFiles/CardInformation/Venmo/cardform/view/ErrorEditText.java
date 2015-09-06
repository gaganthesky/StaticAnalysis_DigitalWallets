package com.braintreepayments.cardform.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import com.braintreepayments.cardform.R.drawable;

public class ErrorEditText extends EditText
{
  private boolean mError;

  public ErrorEditText(Context paramContext)
  {
    super(paramContext);
    boolean bool = false;
    this.mError = bool;
  }

  public ErrorEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = false;
    this.mError = bool;
  }

  public ErrorEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = false;
    this.mError = bool;
  }

  public void clearError()
  {
    int i = 0;
    this.mError = i;
    i = R.drawable.bt_field_selector;
    setBackground(i);
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    clearError();
  }

  private void setBackground(int paramInt)
  {
    int i = getPaddingBottom();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int m = getPaddingTop();
    setBackgroundResource(paramInt);
    setPadding(j, m, k, i);
  }

  public void setError()
  {
    int i = 1;
    this.mError = i;
    i = R.drawable.bt_field_error_selector;
    setBackground(i);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.braintreepayments.cardform.view.ErrorEditText
 * JD-Core Version:    0.6.2
 */
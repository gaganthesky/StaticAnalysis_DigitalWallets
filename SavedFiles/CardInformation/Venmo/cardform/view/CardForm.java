package com.braintreepayments.cardform.view;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.braintreepayments.cardform.OnCardFormFieldFocusedListener;
import com.braintreepayments.cardform.OnCardFormSubmitListener;
import com.braintreepayments.cardform.OnCardFormValidListener;
import com.braintreepayments.cardform.R.id;
import com.braintreepayments.cardform.R.layout;
import com.braintreepayments.cardform.R.string;
import com.braintreepayments.cardform.utils.CardType;

public class CardForm extends LinearLayout
  implements View.OnClickListener, View.OnFocusChangeListener, TextView.OnEditorActionListener, CardEditText.OnCardTypeChangedListener, FloatingLabelEditText.OnTextChangedListener
{
  private CardEditText mCardNumber;
  private boolean mCardNumberRequired;
  private boolean mCvvRequired;
  private CvvEditText mCvvView;
  private boolean mExpirationRequired;
  private MonthYearEditText mExpirationView;
  private OnCardFormFieldFocusedListener mOnCardFormFieldFocusedListener;
  private OnCardFormSubmitListener mOnCardFormSubmitListener;
  private OnCardFormValidListener mOnCardFormValidListener;
  private PostalCodeEditText mPostalCode;
  private boolean mPostalCodeRequired;
  private boolean mValid;

  public CardForm(Context paramContext)
  {
    super(paramContext);
    boolean bool = false;
    this.mValid = bool;
    init();
  }

  public CardForm(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = false;
    this.mValid = bool;
    init();
  }

  public CardForm(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = false;
    this.mValid = bool;
    init();
  }

  public CardForm(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    boolean bool = false;
    this.mValid = bool;
    init();
  }

  public void closeSoftKeyboard()
  {
    Object localObject1 = getContext();
    Object localObject2 = "input_method";
    localObject1 = ((Context)localObject1).getSystemService((String)localObject2);
    localObject1 = (InputMethodManager)localObject1;
    localObject2 = getWindowToken();
    int i = 0;
    ((InputMethodManager)localObject1).hideSoftInputFromWindow((IBinder)localObject2, i);
  }

  public String getCardNumber()
  {
    Object localObject = this.mCardNumber;
    localObject = ((CardEditText)localObject).getText();
    localObject = localObject.toString();
    return localObject;
  }

  public String getCvv()
  {
    Object localObject = this.mCvvView;
    localObject = ((CvvEditText)localObject).getText();
    localObject = localObject.toString();
    return localObject;
  }

  public String getExpirationMonth()
  {
    Object localObject = this.mExpirationView;
    localObject = ((MonthYearEditText)localObject).getMonth();
    return localObject;
  }

  public String getExpirationYear()
  {
    Object localObject = this.mExpirationView;
    localObject = ((MonthYearEditText)localObject).getYear();
    return localObject;
  }

  public String getPostalCode()
  {
    Object localObject = this.mPostalCode;
    localObject = ((PostalCodeEditText)localObject).getText();
    localObject = localObject.toString();
    return localObject;
  }

  private void init()
  {
    int n = 1;
    Context localContext = getContext();
    int i1 = R.layout.bt_card_form_fields;
    inflate(localContext, i1, this);
    int i = R.id.bt_card_form_card_number;
    Object localObject1 = findViewById(i);
    localObject1 = (CardEditText)localObject1;
    this.mCardNumber = ((CardEditText)localObject1);
    int j = R.id.bt_card_form_expiration;
    Object localObject2 = findViewById(j);
    localObject2 = (MonthYearEditText)localObject2;
    this.mExpirationView = ((MonthYearEditText)localObject2);
    int k = R.id.bt_card_form_cvv;
    Object localObject3 = findViewById(k);
    localObject3 = (CvvEditText)localObject3;
    this.mCvvView = ((CvvEditText)localObject3);
    int m = R.id.bt_card_form_postal_code;
    Object localObject4 = findViewById(m);
    localObject4 = (PostalCodeEditText)localObject4;
    this.mPostalCode = ((PostalCodeEditText)localObject4);
    localObject4 = this.mCardNumber;
    ((CardEditText)localObject4).setFocusChangeListener(this);
    localObject4 = this.mExpirationView;
    ((MonthYearEditText)localObject4).setFocusChangeListener(this);
    localObject4 = this.mCvvView;
    ((CvvEditText)localObject4).setFocusChangeListener(this);
    localObject4 = this.mPostalCode;
    ((PostalCodeEditText)localObject4).setFocusChangeListener(this);
    localObject4 = this.mCardNumber;
    ((CardEditText)localObject4).setOnClickListener(this);
    localObject4 = this.mExpirationView;
    ((MonthYearEditText)localObject4).setOnClickListener(this);
    localObject4 = this.mCvvView;
    ((CvvEditText)localObject4).setOnClickListener(this);
    localObject4 = this.mPostalCode;
    ((PostalCodeEditText)localObject4).setOnClickListener(this);
    localObject4 = this.mCardNumber;
    ((CardEditText)localObject4).setOnCardTypeChangedListener(this);
    localObject4 = getContext();
    i1 = R.string.bt_default_action_label;
    String str = ((Context)localObject4).getString(i1);
    localObject4 = this;
    i1 = n;
    boolean bool1 = n;
    boolean bool2 = n;
    ((CardForm)localObject4).setRequiredFields(n, i1, bool1, bool2, str);
  }

  public boolean isValid()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = true;
    boolean bool4 = this.mCardNumberRequired;
    boolean bool5;
    if (bool4)
    {
      if (bool1)
      {
        CardEditText localCardEditText = this.mCardNumber;
        bool5 = localCardEditText.isValid();
        if (bool5)
          bool1 = bool2;
      }
    }
    else
    {
      bool5 = this.mExpirationRequired;
      if (bool5)
      {
        if (!bool1)
          break label154;
        MonthYearEditText localMonthYearEditText = this.mExpirationView;
        bool6 = localMonthYearEditText.isValid();
        if (!bool6)
          break label154;
        bool1 = bool2;
      }
      label77: boolean bool6 = this.mCvvRequired;
      if (bool6)
      {
        if (!bool1)
          break label159;
        CvvEditText localCvvEditText = this.mCvvView;
        bool7 = localCvvEditText.isValid();
        if (!bool7)
          break label159;
        bool1 = bool2;
      }
      label112: boolean bool7 = this.mPostalCodeRequired;
      if (bool7)
      {
        if (!bool1)
          break label164;
        PostalCodeEditText localPostalCodeEditText = this.mPostalCode;
        boolean bool8 = localPostalCodeEditText.isValid();
        if (!bool8)
          break label164;
      }
    }
    label154: label159: label164: for (bool1 = bool2; ; bool1 = bool3)
    {
      return bool1;
      bool1 = bool3;
      break;
      bool1 = bool3;
      break label77;
      bool1 = bool3;
      break label112;
    }
  }

  public void onCardTypeChanged(CardType paramCardType)
  {
    CvvEditText localCvvEditText = this.mCvvView;
    localCvvEditText.setCardType(paramCardType);
  }

  public void onClick(View paramView)
  {
    OnCardFormFieldFocusedListener localOnCardFormFieldFocusedListener = this.mOnCardFormFieldFocusedListener;
    if (localOnCardFormFieldFocusedListener != null)
    {
      localOnCardFormFieldFocusedListener = this.mOnCardFormFieldFocusedListener;
      localOnCardFormFieldFocusedListener.onCardFormFieldFocused(paramView);
    }
  }

  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 2;
    if (paramInt == i)
    {
      OnCardFormSubmitListener localOnCardFormSubmitListener = this.mOnCardFormSubmitListener;
      if (localOnCardFormSubmitListener != null)
      {
        localOnCardFormSubmitListener = this.mOnCardFormSubmitListener;
        localOnCardFormSubmitListener.onCardFormSubmit();
      }
    }
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      OnCardFormFieldFocusedListener localOnCardFormFieldFocusedListener = this.mOnCardFormFieldFocusedListener;
      if (localOnCardFormFieldFocusedListener != null)
      {
        localOnCardFormFieldFocusedListener = this.mOnCardFormFieldFocusedListener;
        localOnCardFormFieldFocusedListener.onCardFormFieldFocused(paramView);
      }
    }
  }

  public void onRestoreInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Object localObject = this.mCardNumber;
      String str = "com.braintreepayments.cardform.EXTRA_CARD_NUMBER_TEXT";
      restoreText(paramBundle, (TextView)localObject, str);
      localObject = this.mCvvView;
      str = "com.braintreepayments.cardform.EXTRA_CVV_TEXT";
      restoreText(paramBundle, (TextView)localObject, str);
      localObject = this.mExpirationView;
      str = "com.braintreepayments.cardform.EXTRA_EXPIRATION_TEXT";
      restoreText(paramBundle, (TextView)localObject, str);
      localObject = this.mPostalCode;
      str = "com.braintreepayments.cardform.EXTRA_POSTAL_CODE_TEXT";
      restoreText(paramBundle, (TextView)localObject, str);
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    String str = "com.braintreepayments.cardform.EXTRA_CARD_NUMBER_TEXT";
    Object localObject = this.mCardNumber;
    localObject = ((CardEditText)localObject).getText();
    paramBundle.putCharSequence(str, (CharSequence)localObject);
    str = "com.braintreepayments.cardform.EXTRA_CVV_TEXT";
    localObject = this.mCvvView;
    localObject = ((CvvEditText)localObject).getText();
    paramBundle.putCharSequence(str, (CharSequence)localObject);
    str = "com.braintreepayments.cardform.EXTRA_EXPIRATION_TEXT";
    localObject = this.mExpirationView;
    localObject = ((MonthYearEditText)localObject).getText();
    paramBundle.putCharSequence(str, (CharSequence)localObject);
    str = "com.braintreepayments.cardform.EXTRA_POSTAL_CODE_TEXT";
    localObject = this.mPostalCode;
    localObject = ((PostalCodeEditText)localObject).getText();
    paramBundle.putCharSequence(str, (CharSequence)localObject);
  }

  public void onTextChanged(Editable paramEditable)
  {
    boolean bool1 = isValid();
    boolean bool2 = this.mValid;
    if (bool2 != bool1)
    {
      this.mValid = bool1;
      OnCardFormValidListener localOnCardFormValidListener = this.mOnCardFormValidListener;
      if (localOnCardFormValidListener != null)
      {
        localOnCardFormValidListener = this.mOnCardFormValidListener;
        localOnCardFormValidListener.onCardFormValid(bool1);
      }
    }
  }

  private void requestEditTextFocus(EditText paramEditText)
  {
    paramEditText.requestFocus();
    Object localObject = getContext();
    String str = "input_method";
    localObject = ((Context)localObject).getSystemService(str);
    localObject = (InputMethodManager)localObject;
    int i = 1;
    ((InputMethodManager)localObject).showSoftInput(paramEditText, i);
  }

  private void restoreText(Bundle paramBundle, TextView paramTextView, String paramString)
  {
    boolean bool = paramBundle.containsKey(paramString);
    if (bool)
    {
      CharSequence localCharSequence = paramBundle.getCharSequence(paramString);
      paramTextView.setText(localCharSequence);
    }
  }

  public void setCardNumberError()
  {
    boolean bool = this.mCardNumberRequired;
    if (bool)
    {
      CardEditText localCardEditText = this.mCardNumber;
      localCardEditText.setError();
      localCardEditText = this.mCardNumber;
      requestEditTextFocus(localCardEditText);
    }
  }

  public void setCvvError()
  {
    boolean bool1 = this.mCvvRequired;
    if (bool1)
    {
      CvvEditText localCvvEditText1 = this.mCvvView;
      localCvvEditText1.setError();
      boolean bool2 = this.mCardNumberRequired;
      if (!bool2)
      {
        bool2 = this.mExpirationRequired;
        if (!bool2);
      }
      else
      {
        CardEditText localCardEditText = this.mCardNumber;
        boolean bool3 = localCardEditText.isFocused();
        if (bool3)
          return;
        MonthYearEditText localMonthYearEditText = this.mExpirationView;
        boolean bool4 = localMonthYearEditText.isFocused();
        if (bool4)
          return;
      }
      CvvEditText localCvvEditText2 = this.mCvvView;
      requestEditTextFocus(localCvvEditText2);
    }
  }

  public void setEnabled(boolean paramBoolean)
  {
    Object localObject = this.mCardNumber;
    ((CardEditText)localObject).setEnabled(paramBoolean);
    localObject = this.mExpirationView;
    ((MonthYearEditText)localObject).setEnabled(paramBoolean);
    localObject = this.mCvvView;
    ((CvvEditText)localObject).setEnabled(paramBoolean);
    localObject = this.mPostalCode;
    ((PostalCodeEditText)localObject).setEnabled(paramBoolean);
  }

  public void setExpirationError()
  {
    boolean bool1 = this.mExpirationRequired;
    if (bool1)
    {
      MonthYearEditText localMonthYearEditText1 = this.mExpirationView;
      localMonthYearEditText1.setError();
      boolean bool2 = this.mCardNumberRequired;
      if (bool2)
      {
        CardEditText localCardEditText = this.mCardNumber;
        boolean bool3 = localCardEditText.isFocused();
        if (bool3);
      }
      else
      {
        MonthYearEditText localMonthYearEditText2 = this.mExpirationView;
        requestEditTextFocus(localMonthYearEditText2);
      }
    }
  }

  private void setIMEOptionsForLastEditTestField(EditText paramEditText, String paramString)
  {
    int i = 2;
    paramEditText.setImeOptions(i);
    paramEditText.setImeActionLabel(paramString, i);
    paramEditText.setOnEditorActionListener(this);
  }

  public void setOnCardFormSubmitListener(OnCardFormSubmitListener paramOnCardFormSubmitListener)
  {
    this.mOnCardFormSubmitListener = paramOnCardFormSubmitListener;
  }

  public void setOnCardFormValidListener(OnCardFormValidListener paramOnCardFormValidListener)
  {
    this.mOnCardFormValidListener = paramOnCardFormValidListener;
  }

  public void setOnFormFieldFocusedListener(OnCardFormFieldFocusedListener paramOnCardFormFieldFocusedListener)
  {
    this.mOnCardFormFieldFocusedListener = paramOnCardFormFieldFocusedListener;
  }

  public void setPostalCodeError()
  {
    boolean bool1 = this.mPostalCodeRequired;
    if (bool1)
    {
      PostalCodeEditText localPostalCodeEditText1 = this.mPostalCode;
      localPostalCodeEditText1.setError();
      boolean bool2 = this.mCardNumberRequired;
      if (!bool2)
      {
        bool2 = this.mExpirationRequired;
        if (!bool2)
        {
          bool2 = this.mCvvRequired;
          if (!bool2)
            break label88;
        }
      }
      CardEditText localCardEditText = this.mCardNumber;
      boolean bool3 = localCardEditText.isFocused();
      if (!bool3)
      {
        MonthYearEditText localMonthYearEditText = this.mExpirationView;
        boolean bool4 = localMonthYearEditText.isFocused();
        if (!bool4)
        {
          CvvEditText localCvvEditText = this.mCvvView;
          boolean bool5 = localCvvEditText.isFocused();
          if (!bool5)
          {
            label88: PostalCodeEditText localPostalCodeEditText2 = this.mPostalCode;
            requestEditTextFocus(localPostalCodeEditText2);
          }
        }
      }
    }
  }

  public void setRequiredFields(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    int j = 5;
    int i = 8;
    this.mCardNumberRequired = paramBoolean1;
    this.mExpirationRequired = paramBoolean2;
    this.mCvvRequired = paramBoolean3;
    this.mPostalCodeRequired = paramBoolean4;
    Object localObject;
    if (paramBoolean1)
    {
      localObject = this.mCardNumber;
      ((CardEditText)localObject).setTextChangedListener(this);
      if (!paramBoolean2)
        break label177;
      localObject = this.mExpirationView;
      ((MonthYearEditText)localObject).setTextChangedListener(this);
      label61: if ((!paramBoolean3) && (!paramBoolean4))
        break label193;
      localObject = this.mExpirationView;
      ((MonthYearEditText)localObject).setImeOptions(j);
      label83: if (!paramBoolean3)
        break label227;
      localObject = this.mCvvView;
      ((CvvEditText)localObject).setTextChangedListener(this);
      if (!paramBoolean4)
        break label210;
      localObject = this.mCvvView;
      ((CvvEditText)localObject).setImeOptions(j);
      label117: if (!paramBoolean4)
        break label243;
      localObject = this.mPostalCode;
      ((PostalCodeEditText)localObject).setTextChangedListener(this);
      localObject = this.mPostalCode;
      setIMEOptionsForLastEditTestField((EditText)localObject, paramString);
    }
    while (true)
    {
      localObject = this.mCardNumber;
      ((CardEditText)localObject).setOnCardTypeChangedListener(this);
      return;
      localObject = this.mCardNumber;
      ((CardEditText)localObject).setVisibility(i);
      break;
      label177: localObject = this.mExpirationView;
      ((MonthYearEditText)localObject).setVisibility(i);
      break label61;
      label193: localObject = this.mExpirationView;
      setIMEOptionsForLastEditTestField((EditText)localObject, paramString);
      break label83;
      label210: localObject = this.mCvvView;
      setIMEOptionsForLastEditTestField((EditText)localObject, paramString);
      break label117;
      label227: localObject = this.mCvvView;
      ((CvvEditText)localObject).setVisibility(i);
      break label117;
      label243: localObject = this.mPostalCode;
      ((PostalCodeEditText)localObject).setVisibility(i);
    }
  }

  public void validate()
  {
    boolean bool1 = this.mCardNumberRequired;
    if (bool1)
    {
      CardEditText localCardEditText = this.mCardNumber;
      localCardEditText.validate();
    }
    boolean bool2 = this.mExpirationRequired;
    if (bool2)
    {
      MonthYearEditText localMonthYearEditText = this.mExpirationView;
      localMonthYearEditText.validate();
    }
    boolean bool3 = this.mCvvRequired;
    if (bool3)
    {
      CvvEditText localCvvEditText = this.mCvvView;
      localCvvEditText.validate();
    }
    boolean bool4 = this.mPostalCodeRequired;
    if (bool4)
    {
      PostalCodeEditText localPostalCodeEditText = this.mPostalCode;
      localPostalCodeEditText.validate();
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.braintreepayments.cardform.view.CardForm
 * JD-Core Version:    0.6.2
 */
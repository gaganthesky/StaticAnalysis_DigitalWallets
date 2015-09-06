package com.braintreepayments.cardform.view;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.braintreepayments.cardform.R.color;
import com.braintreepayments.cardform.R.dimen;

public abstract class FloatingLabelEditText extends ErrorEditText
  implements TextWatcher, View.OnFocusChangeListener
{
  private ValueAnimator mAlphaAnimator;
  private int mAnimatedHintColor;
  private float mAnimatedHintHeight;
  private ValueAnimator mFocusColorAnimator;
  private int mHintAlpha;
  private ValueAnimator mHintAnimator;
  private TextPaint mHintPaint;
  private float mHorizontalTextOffset;
  private ValueAnimator mInactiveColorAnimator;
  private View.OnFocusChangeListener mOnFocusChangeListener;
  private FloatingLabelEditText.OnTextChangedListener mOnTextChangedListener;
  private int mPreviousTextLength;
  protected boolean mRightToLeftLanguage;

  public FloatingLabelEditText(Context paramContext)
  {
    super(paramContext);
    TextPaint localTextPaint = new android/text/TextPaint;
    localTextPaint.<init>();
    this.mHintPaint = localTextPaint;
    float f = -1.0F;
    this.mAnimatedHintHeight = f;
    init();
  }

  public FloatingLabelEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextPaint localTextPaint = new android/text/TextPaint;
    localTextPaint.<init>();
    this.mHintPaint = localTextPaint;
    float f = -1.0F;
    this.mAnimatedHintHeight = f;
    init();
  }

  public FloatingLabelEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TextPaint localTextPaint = new android/text/TextPaint;
    localTextPaint.<init>();
    this.mHintPaint = localTextPaint;
    float f = -1.0F;
    this.mAnimatedHintHeight = f;
    init();
  }

  public void afterTextChanged(Editable paramEditable)
  {
    FloatingLabelEditText.OnTextChangedListener localOnTextChangedListener = this.mOnTextChangedListener;
    if (localOnTextChangedListener != null)
    {
      localOnTextChangedListener = this.mOnTextChangedListener;
      localOnTextChangedListener.onTextChanged(paramEditable);
    }
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void focusNext()
  {
    int j = 2;
    int i = getImeActionId();
    if (i == j);
    while (true)
    {
      return;
      View localView = focusSearch(j);
      if (localView != null)
        localView.requestFocus();
    }
  }

  protected void handleTextColorOnFocus(boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    int j = 11;
    Object localObject;
    if (i >= j)
    {
      localObject = Looper.myLooper();
      if (localObject != null)
      {
        if (!paramBoolean)
          break label35;
        localObject = this.mFocusColorAnimator;
        ((ValueAnimator)localObject).start();
      }
    }
    while (true)
    {
      return;
      label35: localObject = this.mInactiveColorAnimator;
      ((ValueAnimator)localObject).start();
    }
  }

  private void init()
  {
    boolean bool = isRightToLeftLanguage();
    this.mRightToLeftLanguage = bool;
    addTextChangedListener(this);
    Editable localEditable = getText();
    int i = localEditable.length();
    this.mPreviousTextLength = i;
    i = Build.VERSION.SDK_INT;
    int j = 11;
    if (i >= j)
      setupAnimations();
  }

  private boolean isRightToLeftLanguage()
  {
    int i = 1;
    int j = Build.VERSION.SDK_INT;
    int m = 17;
    if (j >= m)
    {
      Object localObject = getResources();
      localObject = ((Resources)localObject).getConfiguration();
      int k = ((Configuration)localObject).getLayoutDirection();
      if (k != i);
    }
    while (true)
    {
      return i;
      i = 0;
    }
  }

  public abstract boolean isValid();

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Editable localEditable = getText();
    int i = localEditable.length();
    if (i > 0)
    {
      Object localObject = this.mHintPaint;
      int j = this.mAnimatedHintColor;
      ((TextPaint)localObject).setColor(j);
      localObject = this.mHintPaint;
      TextPaint localTextPaint1 = getPaint();
      float f2 = localTextPaint1.getTextSize();
      float f4 = 2.0F;
      f2 *= f4;
      f4 = 3.0F;
      f2 /= f4;
      ((TextPaint)localObject).setTextSize(f2);
      localObject = this.mHintPaint;
      int k = this.mHintAlpha;
      ((TextPaint)localObject).setAlpha(k);
      localObject = getHint();
      String str = ((CharSequence)localObject).toString();
      float f1 = this.mHorizontalTextOffset;
      float f3 = this.mAnimatedHintHeight;
      TextPaint localTextPaint2 = this.mHintPaint;
      paramCanvas.drawText(str, f1, f3, localTextPaint2);
    }
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    handleTextColorOnFocus(paramBoolean);
    setErrorOnFocusChange(paramBoolean);
    View.OnFocusChangeListener localOnFocusChangeListener = this.mOnFocusChangeListener;
    if (localOnFocusChangeListener != null)
    {
      localOnFocusChangeListener = this.mOnFocusChangeListener;
      localOnFocusChangeListener.onFocusChange(paramView, paramBoolean);
    }
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    int i = Build.VERSION.SDK_INT;
    int m = 14;
    if (i >= m)
    {
      Looper localLooper = Looper.myLooper();
      if (localLooper != null)
      {
        int j = this.mPreviousTextLength;
        if (j == 0)
        {
          j = paramCharSequence.length();
          if (j > 0)
          {
            ValueAnimator localValueAnimator1 = this.mHintAnimator;
            boolean bool = localValueAnimator1.isStarted();
            if (!bool)
            {
              ValueAnimator localValueAnimator2 = this.mHintAnimator;
              localValueAnimator2.start();
              localValueAnimator2 = this.mFocusColorAnimator;
              localValueAnimator2.start();
              localValueAnimator2 = this.mAlphaAnimator;
              localValueAnimator2.start();
            }
          }
        }
      }
    }
    int k = paramCharSequence.length();
    this.mPreviousTextLength = k;
  }

  protected void setErrorOnFocusChange(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      boolean bool = isValid();
      if (!bool)
        setError();
    }
  }

  public void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.mOnFocusChangeListener = paramOnFocusChangeListener;
  }

  public void setTextChangedListener(FloatingLabelEditText.OnTextChangedListener paramOnTextChangedListener)
  {
    this.mOnTextChangedListener = paramOnTextChangedListener;
  }

  private void setupAnimations()
  {
    long l = 300L;
    int i2 = 1;
    int i1 = 0;
    int n = 2;
    Resources localResources = getResources();
    int k = R.dimen.bt_floating_edit_text_horizontal_offset;
    float f2 = localResources.getDimension(k);
    this.mHorizontalTextOffset = f2;
    float f1 = getTextSize();
    Object localObject1 = new float[n];
    float f3 = 1.75F;
    f3 *= f1;
    localObject1[i1] = f3;
    localObject1[i2] = f1;
    localObject1 = ValueAnimator.ofFloat((float[])localObject1);
    this.mHintAnimator = ((ValueAnimator)localObject1);
    localObject1 = this.mHintAnimator;
    Object localObject3 = new com/braintreepayments/cardform/view/FloatingLabelEditText$1;
    ((FloatingLabelEditText.1)localObject3).<init>(this);
    ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject3);
    localObject1 = this.mHintAnimator;
    ((ValueAnimator)localObject1).setDuration(l);
    int m = R.color.bt_light_gray;
    int j = localResources.getColor(m);
    m = R.color.bt_blue;
    int i = localResources.getColor(m);
    FloatingLabelEditText.2 local2 = new com/braintreepayments/cardform/view/FloatingLabelEditText$2;
    local2.<init>(this);
    Object localObject2 = new int[n];
    localObject2[i1] = j;
    localObject2[i2] = i;
    localObject2 = ValueAnimator.ofInt((int[])localObject2);
    this.mFocusColorAnimator = ((ValueAnimator)localObject2);
    localObject2 = this.mFocusColorAnimator;
    localObject3 = new android/animation/ArgbEvaluator;
    ((ArgbEvaluator)localObject3).<init>();
    ((ValueAnimator)localObject2).setEvaluator((TypeEvaluator)localObject3);
    localObject2 = this.mFocusColorAnimator;
    ((ValueAnimator)localObject2).addUpdateListener(local2);
    localObject2 = this.mFocusColorAnimator;
    ((ValueAnimator)localObject2).setDuration(l);
    localObject2 = new int[n];
    localObject2[i1] = i;
    localObject2[i2] = j;
    localObject2 = ValueAnimator.ofInt((int[])localObject2);
    this.mInactiveColorAnimator = ((ValueAnimator)localObject2);
    localObject2 = this.mInactiveColorAnimator;
    localObject3 = new android/animation/ArgbEvaluator;
    ((ArgbEvaluator)localObject3).<init>();
    ((ValueAnimator)localObject2).setEvaluator((TypeEvaluator)localObject3);
    localObject2 = this.mInactiveColorAnimator;
    ((ValueAnimator)localObject2).addUpdateListener(local2);
    localObject2 = this.mInactiveColorAnimator;
    ((ValueAnimator)localObject2).setDuration(l);
    localObject2 = new int[n];
    localObject2[0] = 0;
    localObject2[1] = 255;
    localObject2 = ValueAnimator.ofInt((int[])localObject2);
    this.mAlphaAnimator = ((ValueAnimator)localObject2);
    localObject2 = this.mAlphaAnimator;
    localObject3 = new com/braintreepayments/cardform/view/FloatingLabelEditText$3;
    ((FloatingLabelEditText.3)localObject3).<init>(this);
    ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject3);
    setOnFocusChangeListener(this);
  }

  public void validate()
  {
    boolean bool = isValid();
    if (bool)
      clearError();
    while (true)
    {
      return;
      setError();
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.braintreepayments.cardform.view.FloatingLabelEditText
 * JD-Core Version:    0.6.2
 */
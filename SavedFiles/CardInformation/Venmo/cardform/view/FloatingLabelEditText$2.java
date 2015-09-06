package com.braintreepayments.cardform.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class FloatingLabelEditText$2
  implements ValueAnimator.AnimatorUpdateListener
{
  final FloatingLabelEditText this$0;

  FloatingLabelEditText$2(FloatingLabelEditText paramFloatingLabelEditText)
  {
  }

  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    FloatingLabelEditText localFloatingLabelEditText2 = this.this$0;
    Object localObject = paramValueAnimator.getAnimatedValue();
    localObject = (Integer)localObject;
    int i = ((Integer)localObject).intValue();
    FloatingLabelEditText.access$102(localFloatingLabelEditText2, i);
    FloatingLabelEditText localFloatingLabelEditText1 = this.this$0;
    localFloatingLabelEditText1.invalidate();
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.braintreepayments.cardform.view.FloatingLabelEditText.2
 * JD-Core Version:    0.6.2
 */
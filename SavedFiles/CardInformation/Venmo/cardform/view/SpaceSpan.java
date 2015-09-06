package com.braintreepayments.cardform.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;

public class SpaceSpan extends ReplacementSpan
{
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    Object localObject1 = new java/lang/StringBuilder;
    ((StringBuilder)localObject1).<init>();
    Object localObject2 = paramCharSequence.subSequence(paramInt1, paramInt2);
    localObject1 = ((StringBuilder)localObject1).append(localObject2);
    localObject2 = " ";
    localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
    localObject1 = ((StringBuilder)localObject1).toString();
    float f = paramInt4;
    paramCanvas.drawText((String)localObject1, paramFloat, f, paramPaint);
  }

  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    String str = " ";
    int j = 0;
    int k = 1;
    float f1 = paramPaint.measureText(str, j, k);
    float f2 = paramPaint.measureText(paramCharSequence, paramInt1, paramInt2);
    float f3 = f1 + f2;
    int i = (int)f3;
    return i;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.braintreepayments.cardform.view.SpaceSpan
 * JD-Core Version:    0.6.2
 */
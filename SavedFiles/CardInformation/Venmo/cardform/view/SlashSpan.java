package com.braintreepayments.cardform.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;

public class SlashSpan extends ReplacementSpan
{
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    Object localObject1 = new java/lang/StringBuilder;
    ((StringBuilder)localObject1).<init>();
    Object localObject2 = paramCharSequence.subSequence(paramInt1, paramInt2);
    localObject1 = ((StringBuilder)localObject1).append(localObject2);
    localObject2 = " / ";
    localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
    localObject1 = ((StringBuilder)localObject1).toString();
    float f = paramInt4;
    paramCanvas.drawText((String)localObject1, paramFloat, f, paramPaint);
  }

  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    int k = 1;
    int j = 0;
    String str1 = " ";
    float f4 = paramPaint.measureText(str1, j, k);
    float f6 = 2.0F;
    float f1 = f4 * f6;
    String str2 = "/";
    float f2 = paramPaint.measureText(str2, j, k);
    float f3 = paramPaint.measureText(paramCharSequence, paramInt1, paramInt2);
    float f5 = f1 + f2;
    f5 += f3;
    int i = (int)f5;
    return i;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.braintreepayments.cardform.view.SlashSpan
 * JD-Core Version:    0.6.2
 */
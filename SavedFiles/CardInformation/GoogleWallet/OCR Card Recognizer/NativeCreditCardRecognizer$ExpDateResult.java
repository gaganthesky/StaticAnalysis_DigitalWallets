package com.google.android.libraries.commerce.ocr.cv.localrecognition;

public class NativeCreditCardRecognizer$ExpDateResult
{
  private final double confidence;
  private final int[] digitPosX;
  private final int[] digitPosY;
  private final String expDate;
  private final int predictionStatus;

  public NativeCreditCardRecognizer$ExpDateResult(String paramString, int paramInt, double paramDouble, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.expDate = paramString;
    this.predictionStatus = paramInt;
    this.confidence = paramDouble;
    this.digitPosX = paramArrayOfInt1;
    this.digitPosY = paramArrayOfInt2;
  }

  public double getConfidence()
  {
    double d = this.confidence;
    return d;
  }

  public int[] getDigitPosX()
  {
    int[] arrayOfInt = this.digitPosX;
    return arrayOfInt;
  }

  public int[] getDigitPosY()
  {
    int[] arrayOfInt = this.digitPosY;
    return arrayOfInt;
  }

  public String getExpirationDate()
  {
    String str = this.expDate;
    return str;
  }

  public int getPredictionStatus()
  {
    int i = this.predictionStatus;
    return i;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     com.google.android.libraries.commerce.ocr.cv.localrecognition.NativeCreditCardRecognizer.ExpDateResult
 * JD-Core Version:    0.6.2
 */
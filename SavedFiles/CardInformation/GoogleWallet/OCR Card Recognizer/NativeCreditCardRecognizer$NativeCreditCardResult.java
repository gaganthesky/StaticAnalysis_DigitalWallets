package com.google.android.libraries.commerce.ocr.cv.localrecognition;

public class NativeCreditCardRecognizer$NativeCreditCardResult
{
  private final double meanDigitConfidence;
  private final double minDigitConfidence;
  private final int[] numbers;

  public NativeCreditCardRecognizer$NativeCreditCardResult(int[] paramArrayOfInt, double paramDouble1, double paramDouble2)
  {
    this.minDigitConfidence = paramDouble1;
    this.meanDigitConfidence = paramDouble2;
    this.numbers = paramArrayOfInt;
  }

  public double getMeanDigitConfidence()
  {
    double d = this.meanDigitConfidence;
    return d;
  }

  public double getMinDigitConfidence()
  {
    double d = this.minDigitConfidence;
    return d;
  }

  public int[] getNumbers()
  {
    int[] arrayOfInt = this.numbers;
    return arrayOfInt;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     com.google.android.libraries.commerce.ocr.cv.localrecognition.NativeCreditCardRecognizer.NativeCreditCardResult
 * JD-Core Version:    0.6.2
 */
package com.google.android.libraries.commerce.ocr.cv.localrecognition;

public class NativeCreditCardRecognizer$CreditCardResult
{
  public String cardNumber;
  public int dominantRgbColor;
  public double expirationDateConfidence;
  public int expirationDateNumDigits;
  public int expirationDatePredictionStatus;
  public int expirationMonth;
  public int expirationYear;
  public double meanDigitConfidence;
  public double minDigitConfidence;

  public void clearCardNumber()
  {
    String str = "";
    this.cardNumber = str;
  }

  public void clearExpirationDate()
  {
    int i = 0;
    this.expirationYear = i;
    this.expirationMonth = i;
  }

  public String getCardNumber()
  {
    String str = this.cardNumber;
    return str;
  }

  public int getDominantRgbColor()
  {
    int i = this.dominantRgbColor;
    return i;
  }

  public double getExpirationDateConfidence()
  {
    double d = this.expirationDateConfidence;
    return d;
  }

  public int getExpirationDateNumDigits()
  {
    int i = this.expirationDateNumDigits;
    return i;
  }

  public int getExpirationDatePredictionStatus()
  {
    int i = this.expirationDatePredictionStatus;
    return i;
  }

  public int getExpirationMonth()
  {
    int i = this.expirationMonth;
    return i;
  }

  public int getExpirationYear()
  {
    int i = this.expirationYear;
    return i;
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
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     com.google.android.libraries.commerce.ocr.cv.localrecognition.NativeCreditCardRecognizer.CreditCardResult
 * JD-Core Version:    0.6.2
 */
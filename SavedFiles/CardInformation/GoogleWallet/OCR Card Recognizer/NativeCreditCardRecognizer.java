package com.google.android.libraries.commerce.ocr.cv.localrecognition;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

public class NativeCreditCardRecognizer
{
  private static final String TAG = "NativeCreditCardRecognizer";
  private final AssetManager assetManager;

  public NativeCreditCardRecognizer(Context paramContext)
  {
    AssetManager localAssetManager = paramContext.getAssets();
    this.assetManager = localAssetManager;
  }

  public native NativeCreditCardRecognizer.NativeCreditCardResult getCreditCardNumbers(byte[] paramArrayOfByte, AssetManager paramAssetManager);

  public native NativeCreditCardRecognizer.ExpDateResult getExpirationDate(byte[] paramArrayOfByte, AssetManager paramAssetManager);

  protected int getExpirationMonth(String paramString)
  {
    int i = 0;
    int k = 2;
    String str = paramString.substring(i, k);
    int j = Integer.parseInt(str);
    return j;
  }

  protected int getExpirationYear(String paramString)
  {
    int i = paramString.length();
    switch (i)
    {
    case 6:
    case 7:
    default:
      i = 0;
    case 5:
    case 8:
    }
    while (true)
    {
      return i;
      i = 3;
      int m = 5;
      String str1 = paramString.substring(i, m);
      int j = Integer.parseInt(str1);
      continue;
      j = 6;
      m = 8;
      String str2 = paramString.substring(j, m);
      int k = Integer.parseInt(str2);
    }
  }

  public NativeCreditCardRecognizer.CreditCardResult recognizeCard(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    Object localObject2 = "NativeCreditCardRecognizer";
    String str5 = "making local request for OCR";
    Log.v((String)localObject2, str5);
    Object localObject1 = this;
    localObject2 = ((NativeCreditCardRecognizer)localObject1).assetManager;
    localObject1 = this;
    byte[] arrayOfByte = paramArrayOfByte1;
    NativeCreditCardRecognizer.NativeCreditCardResult localNativeCreditCardResult = ((NativeCreditCardRecognizer)localObject1).getCreditCardNumbers(arrayOfByte, (AssetManager)localObject2);
    NativeCreditCardRecognizer.ExpDateResult localExpDateResult = new com/google/android/libraries/commerce/ocr/cv/localrecognition/NativeCreditCardRecognizer$ExpDateResult;
    localObject2 = "";
    int n = 0;
    double d3 = 0.0D;
    int i4 = 0;
    int[] arrayOfInt1 = new int[i4];
    int i5 = 0;
    int[] arrayOfInt2 = new int[i5];
    localExpDateResult.<init>((String)localObject2, n, d3, arrayOfInt1, arrayOfInt2);
    if (paramBoolean)
    {
      localObject1 = this;
      localObject2 = ((NativeCreditCardRecognizer)localObject1).assetManager;
      localObject1 = this;
      arrayOfByte = paramArrayOfByte2;
      localExpDateResult = ((NativeCreditCardRecognizer)localObject1).getExpirationDate(arrayOfByte, (AssetManager)localObject2);
    }
    int[] arrayOfInt3 = localNativeCreditCardResult.getNumbers();
    StringBuilder localStringBuilder = new java/lang/StringBuilder;
    localObject1 = arrayOfInt3;
    int i = localObject1.length;
    localObject1 = localStringBuilder;
    ((StringBuilder)localObject1).<init>(i);
    int i9 = 0;
    while (true)
    {
      localObject1 = arrayOfInt3;
      i = localObject1.length;
      if (i9 >= i)
        break;
      i = arrayOfInt3[i9];
      localObject1 = localStringBuilder;
      ((StringBuilder)localObject1).append(i);
      i9 += 1;
    }
    String str8 = localStringBuilder.toString();
    String str1 = "NativeCreditCardRecognizer";
    n = str8.length();
    Object localObject4 = new java/lang/StringBuilder;
    int i2 = 56;
    ((StringBuilder)localObject4).<init>(i2);
    String str6 = "Number received on Java side is ";
    localObject4 = ((StringBuilder)localObject4).append(str6);
    Object localObject3 = ((StringBuilder)localObject4).append(n);
    localObject4 = " digits long.";
    localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
    localObject3 = ((StringBuilder)localObject3).toString();
    Log.v(str1, (String)localObject3);
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    int i3;
    if (paramBoolean)
    {
      int j = localExpDateResult.getPredictionStatus();
      if (j > 0)
      {
        String str7 = localExpDateResult.getExpirationDate();
        localObject3 = "NativeCreditCardRecognizer";
        localObject4 = "Got expiration date: ";
        String str2 = String.valueOf(str7);
        i3 = str2.length();
        if (i3 == 0)
          break label583;
        str2 = ((String)localObject4).concat(str2);
        Log.v((String)localObject3, str2);
        localObject1 = this;
        i6 = ((NativeCreditCardRecognizer)localObject1).getExpirationMonth(str7);
        localObject1 = this;
        i7 = ((NativeCreditCardRecognizer)localObject1).getExpirationYear(str7);
        if ((i6 <= 0) || (i7 <= 0))
          break label598;
        i8 = 1;
      }
    }
    label401: NativeCreditCardRecognizer.CreditCardResult localCreditCardResult = new com/google/android/libraries/commerce/ocr/cv/localrecognition/NativeCreditCardRecognizer$CreditCardResult;
    localCreditCardResult.<init>();
    localCreditCardResult.cardNumber = str8;
    double d1 = localNativeCreditCardResult.getMinDigitConfidence();
    localCreditCardResult.minDigitConfidence = d1;
    d1 = localNativeCreditCardResult.getMeanDigitConfidence();
    localCreditCardResult.meanDigitConfidence = d1;
    localObject3 = "NativeCreditCardRecognizer";
    localObject4 = "Has expiration date = ";
    if (i8 != 0)
    {
      String str3 = "true";
      label463: str3 = String.valueOf(str3);
      i3 = str3.length();
      if (i3 == 0)
        break label611;
      str3 = ((String)localObject4).concat(str3);
      label491: Log.v((String)localObject3, str3);
      if (i8 != 0)
      {
        localCreditCardResult.expirationMonth = i6;
        localCreditCardResult.expirationYear = i7;
        str3 = localExpDateResult.getExpirationDate();
        k = str3.length();
        int i1 = 5;
        if (k != i1)
          break label626;
      }
    }
    label583: label598: label611: label626: int m;
    for (int k = 4; ; m = 6)
    {
      localCreditCardResult.expirationDateNumDigits = k;
      k = localExpDateResult.getPredictionStatus();
      localCreditCardResult.expirationDatePredictionStatus = k;
      double d2 = localExpDateResult.getConfidence();
      localCreditCardResult.expirationDateConfidence = d2;
      return localCreditCardResult;
      String str4 = new java/lang/String;
      str4.<init>((String)localObject4);
      break;
      i8 = 0;
      break label401;
      str4 = "false";
      break label463;
      str4 = new java/lang/String;
      str4.<init>((String)localObject4);
      break label491;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     com.google.android.libraries.commerce.ocr.cv.localrecognition.NativeCreditCardRecognizer
 * JD-Core Version:    0.6.2
 */
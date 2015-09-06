package com.paypal.android.p2pmobile.fragment.wallet;

import com.paypal.android.p2pmobile.core.AppIntentFactory.GiftCardOperation;

class AddGiftCardFragment$5
{
  static final int[] $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$GiftCardOperation = arrayOfInt;

  static
  {
    AppIntentFactory.GiftCardOperation[] arrayOfGiftCardOperation = AppIntentFactory.GiftCardOperation.values();
    int i = arrayOfGiftCardOperation.length;
    int[] arrayOfInt = new int[i];
    try
    {
      arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$GiftCardOperation;
      AppIntentFactory.GiftCardOperation localGiftCardOperation1 = AppIntentFactory.GiftCardOperation.CREATE_GIFT_CARD_INTERMEDIATE;
      int j = localGiftCardOperation1.ordinal();
      int m = 1;
      arrayOfInt[j] = m;
      try
      {
        label35: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$GiftCardOperation;
        AppIntentFactory.GiftCardOperation localGiftCardOperation2 = AppIntentFactory.GiftCardOperation.CREATE_GIFT_CARD_NOK;
        int k = localGiftCardOperation2.ordinal();
        m = 2;
        arrayOfInt[k] = m;
        label54: return;
      }
      catch (NoSuchFieldError localNoSuchFieldError1)
      {
        break label54;
      }
    }
    catch (NoSuchFieldError localNoSuchFieldError2)
    {
      break label35;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddGiftCardFragment.5
 * JD-Core Version:    0.6.2
 */
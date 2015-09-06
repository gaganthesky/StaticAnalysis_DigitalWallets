package com.paypal.android.p2pmobile.fragment.wallet;

import com.paypal.android.p2pmobile.core.AppIntentFactory.GiftCardOperation;
import com.paypal.android.p2pmobile.core.AppIntentFactory.LoyaltyCardOperation;
import com.paypal.android.p2pmobile.core.AppIntentFactory.WalletOperation;

class WalletFragment$13
{
  static final int[] $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$GiftCardOperation = (int[])localObject1;
  static final int[] $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$LoyaltyCardOperation;
  static final int[] $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation;

  static
  {
    AppIntentFactory.GiftCardOperation[] arrayOfGiftCardOperation = AppIntentFactory.GiftCardOperation.values();
    int i = arrayOfGiftCardOperation.length;
    Object localObject1 = new int[i];
    try
    {
      localObject1 = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$GiftCardOperation;
      AppIntentFactory.GiftCardOperation localGiftCardOperation1 = AppIntentFactory.GiftCardOperation.CREATE_GIFT_CARD_OK;
      int m = localGiftCardOperation1.ordinal();
      int i11 = 1;
      localObject1[m] = i11;
      try
      {
        label35: localObject1 = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$GiftCardOperation;
        AppIntentFactory.GiftCardOperation localGiftCardOperation2 = AppIntentFactory.GiftCardOperation.DELETE_GIFT_CARD_OK;
        int n = localGiftCardOperation2.ordinal();
        i11 = 2;
        localObject1[n] = i11;
        try
        {
          label54: localObject1 = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$GiftCardOperation;
          AppIntentFactory.GiftCardOperation localGiftCardOperation3 = AppIntentFactory.GiftCardOperation.DELETE_GIFT_CARD_NOK;
          int i1 = localGiftCardOperation3.ordinal();
          i11 = 3;
          localObject1[i1] = i11;
          label73: localObject1 = AppIntentFactory.LoyaltyCardOperation.values();
          int j = localObject1.length;
          Object localObject2 = new int[j];
          $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$LoyaltyCardOperation = (int[])localObject2;
          try
          {
            localObject2 = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$LoyaltyCardOperation;
            AppIntentFactory.LoyaltyCardOperation localLoyaltyCardOperation1 = AppIntentFactory.LoyaltyCardOperation.CREATE_LOYALTY_CARD_OK;
            int i2 = localLoyaltyCardOperation1.ordinal();
            i11 = 1;
            localObject2[i2] = i11;
            try
            {
              label107: localObject2 = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$LoyaltyCardOperation;
              AppIntentFactory.LoyaltyCardOperation localLoyaltyCardOperation2 = AppIntentFactory.LoyaltyCardOperation.DELETE_LOYALTY_CARD_OK;
              int i3 = localLoyaltyCardOperation2.ordinal();
              i11 = 2;
              localObject2[i3] = i11;
              try
              {
                label126: localObject2 = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$LoyaltyCardOperation;
                AppIntentFactory.LoyaltyCardOperation localLoyaltyCardOperation3 = AppIntentFactory.LoyaltyCardOperation.UPDATE_LOYALTY_CARD_OK;
                int i4 = localLoyaltyCardOperation3.ordinal();
                i11 = 3;
                localObject2[i4] = i11;
                label145: localObject2 = AppIntentFactory.WalletOperation.values();
                int k = localObject2.length;
                int[] arrayOfInt = new int[k];
                $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation = arrayOfInt;
                try
                {
                  arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation;
                  AppIntentFactory.WalletOperation localWalletOperation1 = AppIntentFactory.WalletOperation.GET_ACCOUNT_DETAILS_OK;
                  int i5 = localWalletOperation1.ordinal();
                  i11 = 1;
                  arrayOfInt[i5] = i11;
                  try
                  {
                    label179: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation;
                    AppIntentFactory.WalletOperation localWalletOperation2 = AppIntentFactory.WalletOperation.DELETE_BANK_OK;
                    int i6 = localWalletOperation2.ordinal();
                    i11 = 2;
                    arrayOfInt[i6] = i11;
                    try
                    {
                      label198: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation;
                      AppIntentFactory.WalletOperation localWalletOperation3 = AppIntentFactory.WalletOperation.DELETE_CARD_OK;
                      int i7 = localWalletOperation3.ordinal();
                      i11 = 3;
                      arrayOfInt[i7] = i11;
                      try
                      {
                        label217: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation;
                        AppIntentFactory.WalletOperation localWalletOperation4 = AppIntentFactory.WalletOperation.CREATE_CARD_OK;
                        int i8 = localWalletOperation4.ordinal();
                        i11 = 4;
                        arrayOfInt[i8] = i11;
                        try
                        {
                          label236: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation;
                          AppIntentFactory.WalletOperation localWalletOperation5 = AppIntentFactory.WalletOperation.UPDATE_CARD_OK;
                          int i9 = localWalletOperation5.ordinal();
                          i11 = 5;
                          arrayOfInt[i9] = i11;
                          try
                          {
                            label255: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation;
                            AppIntentFactory.WalletOperation localWalletOperation6 = AppIntentFactory.WalletOperation.UPDATE_CARD_NOK;
                            int i10 = localWalletOperation6.ordinal();
                            i11 = 6;
                            arrayOfInt[i10] = i11;
                            label275: return;
                          }
                          catch (NoSuchFieldError localNoSuchFieldError1)
                          {
                            break label275;
                          }
                        }
                        catch (NoSuchFieldError localNoSuchFieldError2)
                        {
                          break label255;
                        }
                      }
                      catch (NoSuchFieldError localNoSuchFieldError3)
                      {
                        break label236;
                      }
                    }
                    catch (NoSuchFieldError localNoSuchFieldError4)
                    {
                      break label217;
                    }
                  }
                  catch (NoSuchFieldError localNoSuchFieldError5)
                  {
                    break label198;
                  }
                }
                catch (NoSuchFieldError localNoSuchFieldError6)
                {
                  break label179;
                }
              }
              catch (NoSuchFieldError localNoSuchFieldError7)
              {
                break label145;
              }
            }
            catch (NoSuchFieldError localNoSuchFieldError8)
            {
              break label126;
            }
          }
          catch (NoSuchFieldError localNoSuchFieldError9)
          {
            break label107;
          }
        }
        catch (NoSuchFieldError localNoSuchFieldError10)
        {
          break label73;
        }
      }
      catch (NoSuchFieldError localNoSuchFieldError11)
      {
        break label54;
      }
    }
    catch (NoSuchFieldError localNoSuchFieldError12)
    {
      break label35;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WalletFragment.13
 * JD-Core Version:    0.6.2
 */
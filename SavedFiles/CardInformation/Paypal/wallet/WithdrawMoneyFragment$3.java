package com.paypal.android.p2pmobile.fragment.wallet;

import com.paypal.android.p2pmobile.core.AppIntentFactory.WalletOperation;

class WithdrawMoneyFragment$3
{
  static final int[] $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation = (int[])localObject;
  static final int[] $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$WithdrawMoneyFragment$DialogType;

  static
  {
    AppIntentFactory.WalletOperation[] arrayOfWalletOperation = AppIntentFactory.WalletOperation.values();
    int i = arrayOfWalletOperation.length;
    Object localObject = new int[i];
    try
    {
      localObject = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation;
      AppIntentFactory.WalletOperation localWalletOperation = AppIntentFactory.WalletOperation.GET_ACCOUNT_DETAILS_OK;
      int k = localWalletOperation.ordinal();
      int i4 = 1;
      localObject[k] = i4;
      label35: localObject = WithdrawMoneyFragment.DialogType.values();
      int j = localObject.length;
      int[] arrayOfInt = new int[j];
      $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$WithdrawMoneyFragment$DialogType = arrayOfInt;
      try
      {
        arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$WithdrawMoneyFragment$DialogType;
        WithdrawMoneyFragment.DialogType localDialogType1 = WithdrawMoneyFragment.DialogType.PleaseWait;
        int m = localDialogType1.ordinal();
        i4 = 1;
        arrayOfInt[m] = i4;
        try
        {
          label69: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$WithdrawMoneyFragment$DialogType;
          WithdrawMoneyFragment.DialogType localDialogType2 = WithdrawMoneyFragment.DialogType.Error;
          int n = localDialogType2.ordinal();
          i4 = 2;
          arrayOfInt[n] = i4;
          try
          {
            label88: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$WithdrawMoneyFragment$DialogType;
            WithdrawMoneyFragment.DialogType localDialogType3 = WithdrawMoneyFragment.DialogType.Success;
            int i1 = localDialogType3.ordinal();
            i4 = 3;
            arrayOfInt[i1] = i4;
            try
            {
              label107: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$WithdrawMoneyFragment$DialogType;
              WithdrawMoneyFragment.DialogType localDialogType4 = WithdrawMoneyFragment.DialogType.Proceed;
              int i2 = localDialogType4.ordinal();
              i4 = 4;
              arrayOfInt[i2] = i4;
              try
              {
                label126: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$WithdrawMoneyFragment$DialogType;
                WithdrawMoneyFragment.DialogType localDialogType5 = WithdrawMoneyFragment.DialogType.Proceed_UK_User;
                int i3 = localDialogType5.ordinal();
                i4 = 5;
                arrayOfInt[i3] = i4;
                label145: return;
              }
              catch (NoSuchFieldError localNoSuchFieldError1)
              {
                break label145;
              }
            }
            catch (NoSuchFieldError localNoSuchFieldError2)
            {
              break label126;
            }
          }
          catch (NoSuchFieldError localNoSuchFieldError3)
          {
            break label107;
          }
        }
        catch (NoSuchFieldError localNoSuchFieldError4)
        {
          break label88;
        }
      }
      catch (NoSuchFieldError localNoSuchFieldError5)
      {
        break label69;
      }
    }
    catch (NoSuchFieldError localNoSuchFieldError6)
    {
      break label35;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WithdrawMoneyFragment.3
 * JD-Core Version:    0.6.2
 */
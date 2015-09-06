package com.paypal.android.p2pmobile.fragment.wallet;

import com.paypal.android.p2pmobile.core.AppIntentFactory.WalletOperation;

class AddCardFragment$11
{
  static final int[] $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation = (int[])localObject1;
  static final int[] $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddCardFragment$CurrentDateTextView;
  static final int[] $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddCardFragment$DialogType;

  static
  {
    AppIntentFactory.WalletOperation[] arrayOfWalletOperation = AppIntentFactory.WalletOperation.values();
    int i = arrayOfWalletOperation.length;
    Object localObject1 = new int[i];
    try
    {
      localObject1 = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation;
      AppIntentFactory.WalletOperation localWalletOperation1 = AppIntentFactory.WalletOperation.CREATE_CARD_OK;
      int m = localWalletOperation1.ordinal();
      int i9 = 1;
      localObject1[m] = i9;
      try
      {
        label35: localObject1 = $SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation;
        AppIntentFactory.WalletOperation localWalletOperation2 = AppIntentFactory.WalletOperation.CREATE_CARD_NOK;
        int n = localWalletOperation2.ordinal();
        i9 = 2;
        localObject1[n] = i9;
        label54: localObject1 = AddCardFragment.CurrentDateTextView.values();
        int j = localObject1.length;
        Object localObject2 = new int[j];
        $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddCardFragment$CurrentDateTextView = (int[])localObject2;
        try
        {
          localObject2 = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddCardFragment$CurrentDateTextView;
          AddCardFragment.CurrentDateTextView localCurrentDateTextView1 = AddCardFragment.CurrentDateTextView.BirthDate;
          int i1 = localCurrentDateTextView1.ordinal();
          i9 = 1;
          localObject2[i1] = i9;
          try
          {
            label88: localObject2 = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddCardFragment$CurrentDateTextView;
            AddCardFragment.CurrentDateTextView localCurrentDateTextView2 = AddCardFragment.CurrentDateTextView.ExpirationDate;
            int i2 = localCurrentDateTextView2.ordinal();
            i9 = 2;
            localObject2[i2] = i9;
            try
            {
              label107: localObject2 = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddCardFragment$CurrentDateTextView;
              AddCardFragment.CurrentDateTextView localCurrentDateTextView3 = AddCardFragment.CurrentDateTextView.StartDate;
              int i3 = localCurrentDateTextView3.ordinal();
              i9 = 3;
              localObject2[i3] = i9;
              label126: localObject2 = AddCardFragment.DialogType.values();
              int k = localObject2.length;
              int[] arrayOfInt = new int[k];
              $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddCardFragment$DialogType = arrayOfInt;
              try
              {
                arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddCardFragment$DialogType;
                AddCardFragment.DialogType localDialogType1 = AddCardFragment.DialogType.AddCardSuccess;
                int i4 = localDialogType1.ordinal();
                i9 = 1;
                arrayOfInt[i4] = i9;
                try
                {
                  label160: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddCardFragment$DialogType;
                  AddCardFragment.DialogType localDialogType2 = AddCardFragment.DialogType.AddCardFailed;
                  int i5 = localDialogType2.ordinal();
                  i9 = 2;
                  arrayOfInt[i5] = i9;
                  try
                  {
                    label179: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddCardFragment$DialogType;
                    AddCardFragment.DialogType localDialogType3 = AddCardFragment.DialogType.PleaseWaitAddCard;
                    int i6 = localDialogType3.ordinal();
                    i9 = 3;
                    arrayOfInt[i6] = i9;
                    try
                    {
                      label198: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddCardFragment$DialogType;
                      AddCardFragment.DialogType localDialogType4 = AddCardFragment.DialogType.SessionTimeout;
                      int i7 = localDialogType4.ordinal();
                      i9 = 4;
                      arrayOfInt[i7] = i9;
                      try
                      {
                        label217: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddCardFragment$DialogType;
                        AddCardFragment.DialogType localDialogType5 = AddCardFragment.DialogType.VerificationCodeHelp;
                        int i8 = localDialogType5.ordinal();
                        i9 = 5;
                        arrayOfInt[i8] = i9;
                        label236: return;
                      }
                      catch (NoSuchFieldError localNoSuchFieldError1)
                      {
                        break label236;
                      }
                    }
                    catch (NoSuchFieldError localNoSuchFieldError2)
                    {
                      break label217;
                    }
                  }
                  catch (NoSuchFieldError localNoSuchFieldError3)
                  {
                    break label198;
                  }
                }
                catch (NoSuchFieldError localNoSuchFieldError4)
                {
                  break label179;
                }
              }
              catch (NoSuchFieldError localNoSuchFieldError5)
              {
                break label160;
              }
            }
            catch (NoSuchFieldError localNoSuchFieldError6)
            {
              break label126;
            }
          }
          catch (NoSuchFieldError localNoSuchFieldError7)
          {
            break label107;
          }
        }
        catch (NoSuchFieldError localNoSuchFieldError8)
        {
          break label88;
        }
      }
      catch (NoSuchFieldError localNoSuchFieldError9)
      {
        break label54;
      }
    }
    catch (NoSuchFieldError localNoSuchFieldError10)
    {
      break label35;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddCardFragment.11
 * JD-Core Version:    0.6.2
 */
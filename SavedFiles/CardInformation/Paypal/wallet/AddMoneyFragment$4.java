package com.paypal.android.p2pmobile.fragment.wallet;

import com.paypal.android.base.server.cip.CIPGetStatusRequest.Status;

class AddMoneyFragment$4
{
  static final int[] $SwitchMap$com$paypal$android$base$server$cip$CIPGetStatusRequest$Status = (int[])localObject1;
  static final int[] $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddMoneyFragment$DialogType;
  static final int[] $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddMoneyFragment$State;

  static
  {
    CIPGetStatusRequest.Status[] arrayOfStatus = CIPGetStatusRequest.Status.values();
    int i = arrayOfStatus.length;
    Object localObject1 = new int[i];
    try
    {
      localObject1 = $SwitchMap$com$paypal$android$base$server$cip$CIPGetStatusRequest$Status;
      CIPGetStatusRequest.Status localStatus1 = CIPGetStatusRequest.Status.SUCCESS;
      int m = localStatus1.ordinal();
      int i12 = 1;
      localObject1[m] = i12;
      try
      {
        label35: localObject1 = $SwitchMap$com$paypal$android$base$server$cip$CIPGetStatusRequest$Status;
        CIPGetStatusRequest.Status localStatus2 = CIPGetStatusRequest.Status.VERIFICATION_NEEDED;
        int n = localStatus2.ordinal();
        i12 = 2;
        localObject1[n] = i12;
        try
        {
          label54: localObject1 = $SwitchMap$com$paypal$android$base$server$cip$CIPGetStatusRequest$Status;
          CIPGetStatusRequest.Status localStatus3 = CIPGetStatusRequest.Status.IN_PROGRESS_REVIEW;
          int i1 = localStatus3.ordinal();
          i12 = 3;
          localObject1[i1] = i12;
          try
          {
            label73: localObject1 = $SwitchMap$com$paypal$android$base$server$cip$CIPGetStatusRequest$Status;
            CIPGetStatusRequest.Status localStatus4 = CIPGetStatusRequest.Status.IN_PROGRESS_DECLINED;
            int i2 = localStatus4.ordinal();
            i12 = 4;
            localObject1[i2] = i12;
            try
            {
              label92: localObject1 = $SwitchMap$com$paypal$android$base$server$cip$CIPGetStatusRequest$Status;
              CIPGetStatusRequest.Status localStatus5 = CIPGetStatusRequest.Status.FAILED;
              int i3 = localStatus5.ordinal();
              i12 = 5;
              localObject1[i3] = i12;
              label111: localObject1 = AddMoneyFragment.State.values();
              int j = localObject1.length;
              Object localObject2 = new int[j];
              $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddMoneyFragment$State = (int[])localObject2;
              try
              {
                localObject2 = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddMoneyFragment$State;
                AddMoneyFragment.State localState1 = AddMoneyFragment.State.IDLE;
                int i4 = localState1.ordinal();
                i12 = 1;
                localObject2[i4] = i12;
                try
                {
                  label145: localObject2 = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddMoneyFragment$State;
                  AddMoneyFragment.State localState2 = AddMoneyFragment.State.GET_CIP;
                  int i5 = localState2.ordinal();
                  i12 = 2;
                  localObject2[i5] = i12;
                  try
                  {
                    label164: localObject2 = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddMoneyFragment$State;
                    AddMoneyFragment.State localState3 = AddMoneyFragment.State.GET_FUNDING_SOURCES;
                    int i6 = localState3.ordinal();
                    i12 = 3;
                    localObject2[i6] = i12;
                    label183: localObject2 = AddMoneyFragment.DialogType.values();
                    int k = localObject2.length;
                    int[] arrayOfInt = new int[k];
                    $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddMoneyFragment$DialogType = arrayOfInt;
                    try
                    {
                      arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddMoneyFragment$DialogType;
                      AddMoneyFragment.DialogType localDialogType1 = AddMoneyFragment.DialogType.PleaseWait;
                      int i7 = localDialogType1.ordinal();
                      i12 = 1;
                      arrayOfInt[i7] = i12;
                      try
                      {
                        label217: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddMoneyFragment$DialogType;
                        AddMoneyFragment.DialogType localDialogType2 = AddMoneyFragment.DialogType.Error;
                        int i8 = localDialogType2.ordinal();
                        i12 = 2;
                        arrayOfInt[i8] = i12;
                        try
                        {
                          label236: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddMoneyFragment$DialogType;
                          AddMoneyFragment.DialogType localDialogType3 = AddMoneyFragment.DialogType.Success;
                          int i9 = localDialogType3.ordinal();
                          i12 = 3;
                          arrayOfInt[i9] = i12;
                          try
                          {
                            label255: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddMoneyFragment$DialogType;
                            AddMoneyFragment.DialogType localDialogType4 = AddMoneyFragment.DialogType.CIPVerification;
                            int i10 = localDialogType4.ordinal();
                            i12 = 4;
                            arrayOfInt[i10] = i12;
                            try
                            {
                              label274: arrayOfInt = $SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddMoneyFragment$DialogType;
                              AddMoneyFragment.DialogType localDialogType5 = AddMoneyFragment.DialogType.CIPError;
                              int i11 = localDialogType5.ordinal();
                              i12 = 5;
                              arrayOfInt[i11] = i12;
                              label293: return;
                            }
                            catch (NoSuchFieldError localNoSuchFieldError1)
                            {
                              break label293;
                            }
                          }
                          catch (NoSuchFieldError localNoSuchFieldError2)
                          {
                            break label274;
                          }
                        }
                        catch (NoSuchFieldError localNoSuchFieldError3)
                        {
                          break label255;
                        }
                      }
                      catch (NoSuchFieldError localNoSuchFieldError4)
                      {
                        break label236;
                      }
                    }
                    catch (NoSuchFieldError localNoSuchFieldError5)
                    {
                      break label217;
                    }
                  }
                  catch (NoSuchFieldError localNoSuchFieldError6)
                  {
                    break label183;
                  }
                }
                catch (NoSuchFieldError localNoSuchFieldError7)
                {
                  break label164;
                }
              }
              catch (NoSuchFieldError localNoSuchFieldError8)
              {
                break label145;
              }
            }
            catch (NoSuchFieldError localNoSuchFieldError9)
            {
              break label111;
            }
          }
          catch (NoSuchFieldError localNoSuchFieldError10)
          {
            break label92;
          }
        }
        catch (NoSuchFieldError localNoSuchFieldError11)
        {
          break label73;
        }
      }
      catch (NoSuchFieldError localNoSuchFieldError12)
      {
        break label54;
      }
    }
    catch (NoSuchFieldError localNoSuchFieldError13)
    {
      break label35;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddMoneyFragment.4
 * JD-Core Version:    0.6.2
 */
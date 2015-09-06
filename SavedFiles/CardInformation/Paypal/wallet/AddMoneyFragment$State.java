package com.paypal.android.p2pmobile.fragment.wallet;

 enum AddMoneyFragment$State
{
  private static final State[] $VALUES = arrayOfState;

  static
  {
    int m = 2;
    int k = 1;
    int j = 0;
    State localState = new com/paypal/android/p2pmobile/fragment/wallet/AddMoneyFragment$State;
    Object localObject = "IDLE";
    localState.<init>((String)localObject, j);
    IDLE = localState;
    localState = new com/paypal/android/p2pmobile/fragment/wallet/AddMoneyFragment$State;
    localObject = "GET_FUNDING_SOURCES";
    localState.<init>((String)localObject, k);
    GET_FUNDING_SOURCES = localState;
    localState = new com/paypal/android/p2pmobile/fragment/wallet/AddMoneyFragment$State;
    localObject = "GET_CIP";
    localState.<init>((String)localObject, m);
    GET_CIP = localState;
    int i = 3;
    State[] arrayOfState = new State[i];
    localObject = IDLE;
    arrayOfState[j] = localObject;
    localObject = GET_FUNDING_SOURCES;
    arrayOfState[k] = localObject;
    localObject = GET_CIP;
    arrayOfState[m] = localObject;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddMoneyFragment.State
 * JD-Core Version:    0.6.2
 */
package com.paypal.android.p2pmobile.fragment.wallet;

 enum WithdrawMoneyFragment$State
{
  private static final State[] $VALUES = arrayOfState;

  static
  {
    int n = 3;
    int m = 2;
    int k = 1;
    int j = 0;
    State localState = new com/paypal/android/p2pmobile/fragment/wallet/WithdrawMoneyFragment$State;
    Object localObject = "GET_WITHDRAW_OPTIONS";
    localState.<init>((String)localObject, j);
    GET_WITHDRAW_OPTIONS = localState;
    localState = new com/paypal/android/p2pmobile/fragment/wallet/WithdrawMoneyFragment$State;
    localObject = "IDLE";
    localState.<init>((String)localObject, k);
    IDLE = localState;
    localState = new com/paypal/android/p2pmobile/fragment/wallet/WithdrawMoneyFragment$State;
    localObject = "ANALYZE_WITHDRAW";
    localState.<init>((String)localObject, m);
    ANALYZE_WITHDRAW = localState;
    localState = new com/paypal/android/p2pmobile/fragment/wallet/WithdrawMoneyFragment$State;
    localObject = "PERFORM_WITHDRAW";
    localState.<init>((String)localObject, n);
    PERFORM_WITHDRAW = localState;
    int i = 4;
    State[] arrayOfState = new State[i];
    localObject = GET_WITHDRAW_OPTIONS;
    arrayOfState[j] = localObject;
    localObject = IDLE;
    arrayOfState[k] = localObject;
    localObject = ANALYZE_WITHDRAW;
    arrayOfState[m] = localObject;
    localObject = PERFORM_WITHDRAW;
    arrayOfState[n] = localObject;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WithdrawMoneyFragment.State
 * JD-Core Version:    0.6.2
 */
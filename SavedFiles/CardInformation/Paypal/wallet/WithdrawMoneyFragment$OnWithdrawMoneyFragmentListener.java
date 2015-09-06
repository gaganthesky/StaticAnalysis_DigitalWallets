package com.paypal.android.p2pmobile.fragment.wallet;

import com.paypal.android.p2pmobile.common.OnFragmentStateChange;

public abstract interface WithdrawMoneyFragment$OnWithdrawMoneyFragmentListener extends OnFragmentStateChange
{
  public abstract void onWithdrawMoneyFinish();

  public abstract void refreshAccountModel();

  public abstract void stopProgressLoader();
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener
 * JD-Core Version:    0.6.2
 */
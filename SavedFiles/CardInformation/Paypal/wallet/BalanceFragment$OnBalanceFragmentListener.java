package com.paypal.android.p2pmobile.fragment.wallet;

import com.paypal.android.p2pmobile.common.OnFragmentStateChange;

public abstract interface BalanceFragment$OnBalanceFragmentListener extends OnFragmentStateChange
{
  public abstract void onAddMoney(Class<?> paramClass);

  public abstract void onWithdrawMoney(Class<?> paramClass);

  public abstract void stopProgressLoader();
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.BalanceFragment.OnBalanceFragmentListener
 * JD-Core Version:    0.6.2
 */
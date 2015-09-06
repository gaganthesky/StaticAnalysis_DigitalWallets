package com.paypal.android.p2pmobile.fragment.wallet;

import com.paypal.android.p2pmobile.common.FundingSourceSelector;

class WithdrawMoneyFragment$2
  implements Runnable
{
  final WithdrawMoneyFragment this$0;

  WithdrawMoneyFragment$2(WithdrawMoneyFragment paramWithdrawMoneyFragment)
  {
  }

  public void run()
  {
    Object localObject = this.this$0;
    localObject = WithdrawMoneyFragment.access$200((WithdrawMoneyFragment)localObject);
    int i = WithdrawMoneyFragment.access$100();
    ((FundingSourceSelector)localObject).setSpinnerSelection(i);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WithdrawMoneyFragment.2
 * JD-Core Version:    0.6.2
 */
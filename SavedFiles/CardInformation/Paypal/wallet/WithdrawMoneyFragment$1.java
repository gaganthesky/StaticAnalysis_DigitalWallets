package com.paypal.android.p2pmobile.fragment.wallet;

class WithdrawMoneyFragment$1
  implements Runnable
{
  final WithdrawMoneyFragment this$0;

  WithdrawMoneyFragment$1(WithdrawMoneyFragment paramWithdrawMoneyFragment)
  {
  }

  public void run()
  {
    Object localObject = this.this$0;
    localObject = WithdrawMoneyFragment.access$000((WithdrawMoneyFragment)localObject);
    ((WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener)localObject).onWithdrawMoneyFinish();
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WithdrawMoneyFragment.1
 * JD-Core Version:    0.6.2
 */
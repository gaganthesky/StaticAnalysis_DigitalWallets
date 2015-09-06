package com.paypal.android.p2pmobile.fragment.wallet;

import android.view.View;
import android.view.View.OnClickListener;

class BalanceFragment$2
  implements View.OnClickListener
{
  final BalanceFragment this$0;

  BalanceFragment$2(BalanceFragment paramBalanceFragment)
  {
  }

  public void onClick(View paramView)
  {
    BalanceFragment localBalanceFragment = this.this$0;
    BalanceFragment.OnBalanceFragmentListener localOnBalanceFragmentListener = BalanceFragment.access$000(localBalanceFragment);
    if (localOnBalanceFragmentListener != null)
    {
      localBalanceFragment = BalanceFragment.class;
      localOnBalanceFragmentListener.onWithdrawMoney(localBalanceFragment);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.BalanceFragment.2
 * JD-Core Version:    0.6.2
 */
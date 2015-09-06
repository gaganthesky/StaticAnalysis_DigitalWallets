package com.paypal.android.p2pmobile.fragment.wallet;

import android.view.View;
import android.view.View.OnClickListener;
import com.paypal.android.p2pmobile.utils.ViewUtility;

class WalletFragment$6
  implements View.OnClickListener
{
  final WalletFragment this$0;

  WalletFragment$6(WalletFragment paramWalletFragment)
  {
  }

  public void onClick(View paramView)
  {
    boolean bool = ViewUtility.isBaseActivityResumed(paramView);
    if (!bool);
    while (true)
    {
      return;
      Object localObject = this.this$0;
      localObject = WalletFragment.access$000((WalletFragment)localObject);
      ((WalletFragment.OnContainerFragmentListener)localObject).onBalance();
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WalletFragment.6
 * JD-Core Version:    0.6.2
 */
package com.paypal.android.p2pmobile.fragment.wallet;

import android.view.View;
import android.view.View.OnClickListener;

class WalletFragment$10
  implements View.OnClickListener
{
  final WalletFragment this$0;

  WalletFragment$10(WalletFragment paramWalletFragment)
  {
  }

  public void onClick(View paramView)
  {
    Object localObject = this.this$0;
    localObject = WalletFragment.access$000((WalletFragment)localObject);
    WalletFragment localWalletFragment = WalletFragment.class;
    ((WalletFragment.OnContainerFragmentListener)localObject).onWithdrawMoney(localWalletFragment);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WalletFragment.10
 * JD-Core Version:    0.6.2
 */
package com.paypal.android.p2pmobile.fragment.wallet;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class WalletFragment$11
  implements View.OnClickListener
{
  final WalletFragment this$0;

  WalletFragment$11(WalletFragment paramWalletFragment)
  {
  }

  public void onClick(View paramView)
  {
    Object localObject = paramView.getParent();
    localObject = (ViewGroup)localObject;
    if (localObject != null)
      ((ViewGroup)localObject).removeView(paramView);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WalletFragment.11
 * JD-Core Version:    0.6.2
 */
package com.paypal.android.p2pmobile.fragment.wallet;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class WalletFragment$4
  implements AdapterView.OnItemClickListener
{
  final WalletFragment this$0;

  WalletFragment$4(WalletFragment paramWalletFragment)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.this$0;
    localObject = WalletFragment.access$000((WalletFragment)localObject);
    ((WalletFragment.OnContainerFragmentListener)localObject).onPSBDetails(paramInt);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WalletFragment.4
 * JD-Core Version:    0.6.2
 */
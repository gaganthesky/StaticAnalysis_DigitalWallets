package com.paypal.android.p2pmobile.fragment.wallet;

import android.view.View;
import android.view.View.OnClickListener;

class WalletArtifactDetailsFragment$1
  implements View.OnClickListener
{
  final WalletArtifactDetailsFragment this$0;

  WalletArtifactDetailsFragment$1(WalletArtifactDetailsFragment paramWalletArtifactDetailsFragment)
  {
  }

  public void onClick(View paramView)
  {
    Object localObject = this.this$0;
    localObject = WalletArtifactDetailsFragment.access$000((WalletArtifactDetailsFragment)localObject);
    ((WalletArtifactDetailsFragment.OnWalletArtifactDetailsFragmentListener)localObject).onVerifyCard();
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WalletArtifactDetailsFragment.1
 * JD-Core Version:    0.6.2
 */
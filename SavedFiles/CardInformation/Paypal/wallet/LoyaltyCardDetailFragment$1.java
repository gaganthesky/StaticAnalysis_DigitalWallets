package com.paypal.android.p2pmobile.fragment.wallet;

import android.view.View;
import android.view.View.OnClickListener;

class LoyaltyCardDetailFragment$1
  implements View.OnClickListener
{
  final LoyaltyCardDetailFragment this$0;

  LoyaltyCardDetailFragment$1(LoyaltyCardDetailFragment paramLoyaltyCardDetailFragment)
  {
  }

  public void onClick(View paramView)
  {
    Object localObject1 = this.this$0;
    localObject1 = LoyaltyCardDetailFragment.access$200((LoyaltyCardDetailFragment)localObject1);
    Object localObject2 = this.this$0;
    localObject2 = LoyaltyCardDetailFragment.access$000((LoyaltyCardDetailFragment)localObject2);
    LoyaltyCardDetailFragment localLoyaltyCardDetailFragment = this.this$0;
    int i = LoyaltyCardDetailFragment.access$100(localLoyaltyCardDetailFragment);
    ((LoyaltyCardDetailFragment.OnLoyaltyDetailsFragmentListener)localObject1).openTermsAndConditionsView((String)localObject2, i);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.LoyaltyCardDetailFragment.1
 * JD-Core Version:    0.6.2
 */
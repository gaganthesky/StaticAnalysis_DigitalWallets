package com.paypal.android.p2pmobile.fragment.wallet;

import android.support.v7.widget.SearchView.OnQueryTextListener;

class LoyaltyCardSearchFragment$3
  implements SearchView.OnQueryTextListener
{
  final LoyaltyCardSearchFragment this$0;

  LoyaltyCardSearchFragment$3(LoyaltyCardSearchFragment paramLoyaltyCardSearchFragment)
  {
  }

  public boolean onQueryTextChange(String paramString)
  {
    boolean bool = true;
    LoyaltyCardSearchFragment localLoyaltyCardSearchFragment = this.this$0;
    localLoyaltyCardSearchFragment.doProgramSearch(paramString, bool);
    return bool;
  }

  public boolean onQueryTextSubmit(String paramString)
  {
    boolean bool = true;
    return bool;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.LoyaltyCardSearchFragment.3
 * JD-Core Version:    0.6.2
 */
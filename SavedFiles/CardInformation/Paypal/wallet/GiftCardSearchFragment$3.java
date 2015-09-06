package com.paypal.android.p2pmobile.fragment.wallet;

import android.support.v7.widget.SearchView.OnQueryTextListener;

class GiftCardSearchFragment$3
  implements SearchView.OnQueryTextListener
{
  final GiftCardSearchFragment this$0;

  GiftCardSearchFragment$3(GiftCardSearchFragment paramGiftCardSearchFragment)
  {
  }

  public boolean onQueryTextChange(String paramString)
  {
    boolean bool = true;
    GiftCardSearchFragment localGiftCardSearchFragment = this.this$0;
    localGiftCardSearchFragment.doProgramSearch(paramString, bool);
    return bool;
  }

  public boolean onQueryTextSubmit(String paramString)
  {
    boolean bool = true;
    return bool;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.GiftCardSearchFragment.3
 * JD-Core Version:    0.6.2
 */
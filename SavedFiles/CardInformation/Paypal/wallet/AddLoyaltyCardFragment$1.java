package com.paypal.android.p2pmobile.fragment.wallet;

import android.text.TextUtils;

class AddLoyaltyCardFragment$1
  implements Runnable
{
  final AddLoyaltyCardFragment this$0;

  AddLoyaltyCardFragment$1(AddLoyaltyCardFragment paramAddLoyaltyCardFragment)
  {
  }

  public void run()
  {
    Object localObject1 = this.this$0;
    localObject1 = AddLoyaltyCardFragment.access$000((AddLoyaltyCardFragment)localObject1);
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    Object localObject2;
    if (bool)
    {
      localObject2 = this.this$0;
      localObject2 = AddLoyaltyCardFragment.access$100((AddLoyaltyCardFragment)localObject2);
      if (localObject2 != null)
      {
        localObject2 = this.this$0;
        localObject2 = AddLoyaltyCardFragment.access$100((AddLoyaltyCardFragment)localObject2);
        ((AddLoyaltyCardFragment.OnAddLoyaltyCardFragmentListener)localObject2).toggleKeyBoard();
      }
    }
    while (true)
    {
      return;
      localObject2 = this.this$0;
      AddLoyaltyCardFragment.access$200((AddLoyaltyCardFragment)localObject2);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddLoyaltyCardFragment.1
 * JD-Core Version:    0.6.2
 */
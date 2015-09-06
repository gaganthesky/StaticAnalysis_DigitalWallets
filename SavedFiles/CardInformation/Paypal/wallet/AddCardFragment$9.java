package com.paypal.android.p2pmobile.fragment.wallet;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnFocusChangeListener;

class AddCardFragment$9
  implements View.OnFocusChangeListener
{
  final AddCardFragment this$0;

  AddCardFragment$9(AddCardFragment paramAddCardFragment)
  {
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    String str1 = Build.VERSION.RELEASE;
    String str2 = "2.3.6";
    boolean bool = str1.equals(str2);
    if (bool)
    {
      AddCardFragment localAddCardFragment = this.this$0;
      AddCardFragment.access$1000(localAddCardFragment, paramView, paramBoolean);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddCardFragment.9
 * JD-Core Version:    0.6.2
 */
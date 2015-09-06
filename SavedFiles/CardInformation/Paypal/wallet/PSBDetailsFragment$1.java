package com.paypal.android.p2pmobile.fragment.wallet;

import android.view.View;
import android.view.View.OnClickListener;

class PSBDetailsFragment$1
  implements View.OnClickListener
{
  final PSBDetailsFragment this$0;

  PSBDetailsFragment$1(PSBDetailsFragment paramPSBDetailsFragment)
  {
  }

  public void onClick(View paramView)
  {
    Object localObject = this.this$0;
    localObject = PSBDetailsFragment.access$000((PSBDetailsFragment)localObject);
    ((PSBDetailsFragment.OnPSBDetailsFragmentListener)localObject).showPSBTermsAndConditions();
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.PSBDetailsFragment.1
 * JD-Core Version:    0.6.2
 */
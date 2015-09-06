package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;

class GiftCardProgramTermsFragment$2$1
  implements DialogInterface.OnClickListener
{
  final GiftCardProgramTermsFragment.2 this$1;

  GiftCardProgramTermsFragment$2$1(GiftCardProgramTermsFragment.2 param2)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
    Object localObject = this.this$1;
    localObject = ((GiftCardProgramTermsFragment.2)localObject).this$0;
    boolean bool = false;
    GiftCardProgramTermsFragment.access$402((GiftCardProgramTermsFragment)localObject, bool);
    localObject = this.this$1;
    localObject = ((GiftCardProgramTermsFragment.2)localObject).this$0;
    localObject = ((GiftCardProgramTermsFragment)localObject).getActivity();
    ((FragmentActivity)localObject).finish();
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.GiftCardProgramTermsFragment.2.1
 * JD-Core Version:    0.6.2
 */
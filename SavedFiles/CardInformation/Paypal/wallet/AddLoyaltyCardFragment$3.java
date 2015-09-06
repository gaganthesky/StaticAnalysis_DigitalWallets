package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.paypal.android.base.server.tracking.TrackPage.Link;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.activity.loyaltycard.LoyaltyCardScannerActivity;

class AddLoyaltyCardFragment$3
  implements View.OnClickListener
{
  final AddLoyaltyCardFragment this$0;

  AddLoyaltyCardFragment$3(AddLoyaltyCardFragment paramAddLoyaltyCardFragment)
  {
  }

  public void onClick(View paramView)
  {
    int i = 1;
    Object localObject1 = TrackPage.Point.LoyaltyCardAddCardAddDetails;
    Object localObject3 = TrackPage.Link.SanBarCode;
    PayPalApp.logLinkPress((TrackPage.Point)localObject1, (TrackPage.Link)localObject3);
    localObject1 = this.this$0;
    boolean bool = AddLoyaltyCardFragment.access$600((AddLoyaltyCardFragment)localObject1);
    if (bool);
    while (true)
    {
      return;
      Object localObject2 = this.this$0;
      AddLoyaltyCardFragment.access$602((AddLoyaltyCardFragment)localObject2, i);
      Intent localIntent = new android/content/Intent;
      localObject2 = this.this$0;
      localObject2 = ((AddLoyaltyCardFragment)localObject2).getActivity();
      localObject3 = LoyaltyCardScannerActivity.class;
      localIntent.<init>((Context)localObject2, (Class)localObject3);
      localObject2 = this.this$0;
      ((AddLoyaltyCardFragment)localObject2).startActivityForResult(localIntent, i);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddLoyaltyCardFragment.3
 * JD-Core Version:    0.6.2
 */
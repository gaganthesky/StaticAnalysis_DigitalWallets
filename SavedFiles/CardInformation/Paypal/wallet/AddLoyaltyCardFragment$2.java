package com.paypal.android.p2pmobile.fragment.wallet;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import com.paypal.android.base.server.tracking.TrackPage.Link;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.p2pmobile.PayPalApp;

class AddLoyaltyCardFragment$2
  implements View.OnClickListener
{
  final AddLoyaltyCardFragment this$0;

  AddLoyaltyCardFragment$2(AddLoyaltyCardFragment paramAddLoyaltyCardFragment)
  {
  }

  public void onClick(View paramView)
  {
    Object localObject1 = this.this$0;
    localObject1 = AddLoyaltyCardFragment.access$300((AddLoyaltyCardFragment)localObject1);
    int i = ((ImageButton)localObject1).getVisibility();
    int j = 8;
    Object localObject2;
    TrackPage.Link localLink;
    String str;
    if (i == j)
    {
      localObject2 = TrackPage.Point.LoyaltyCardAddCardAddDetailsNoBarCode;
      localLink = TrackPage.Link.AddCard;
      PayPalApp.logLinkPress((TrackPage.Point)localObject2, localLink);
      localObject2 = this.this$0;
      localObject2 = AddLoyaltyCardFragment.access$400((AddLoyaltyCardFragment)localObject2);
      if (localObject2 == null)
        break label117;
      localObject2 = this.this$0;
      localObject2 = AddLoyaltyCardFragment.access$400((AddLoyaltyCardFragment)localObject2);
      localObject2 = ((EditText)localObject2).getText();
      if (localObject2 == null)
        break label117;
      localObject2 = this.this$0;
      localObject2 = AddLoyaltyCardFragment.access$400((AddLoyaltyCardFragment)localObject2);
      localObject2 = ((EditText)localObject2).getText();
      str = localObject2.toString();
      label94: if (str != null)
        break label122;
    }
    while (true)
    {
      return;
      localObject2 = TrackPage.Point.LoyaltyCardAddCardAddDetails;
      localLink = TrackPage.Link.AddCard;
      PayPalApp.logLinkPress((TrackPage.Point)localObject2, localLink);
      break;
      label117: str = null;
      break label94;
      label122: localObject2 = this.this$0;
      AddLoyaltyCardFragment.access$500((AddLoyaltyCardFragment)localObject2, str);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddLoyaltyCardFragment.2
 * JD-Core Version:    0.6.2
 */
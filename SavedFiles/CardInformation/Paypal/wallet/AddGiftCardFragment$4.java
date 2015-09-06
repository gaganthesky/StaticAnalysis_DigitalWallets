package com.paypal.android.p2pmobile.fragment.wallet;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.paypal.android.base.server.tracking.TrackPage.Link;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.utils.ViewUtility;
import java.util.Map;

class AddGiftCardFragment$4
  implements View.OnKeyListener
{
  final AddGiftCardFragment this$0;

  AddGiftCardFragment$4(AddGiftCardFragment paramAddGiftCardFragment)
  {
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    int i = 4;
    if (paramInt == i)
    {
      Object localObject1 = TrackPage.Point.GiftCardBackOfCardImage;
      TrackPage.Link localLink = TrackPage.Link.Back;
      Object localObject2 = this.this$0;
      localObject2 = AddGiftCardFragment.access$500((AddGiftCardFragment)localObject2);
      PayPalApp.logLinkPress((TrackPage.Point)localObject1, localLink, (Map)localObject2);
      localObject1 = this.this$0;
      localObject1 = AddGiftCardFragment.access$600((AddGiftCardFragment)localObject1);
      int j = 2131428074;
      ViewUtility.showOrHide((View)localObject1, j, bool);
      bool = true;
    }
    return bool;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddGiftCardFragment.4
 * JD-Core Version:    0.6.2
 */
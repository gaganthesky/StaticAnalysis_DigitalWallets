package com.paypal.android.p2pmobile.fragment.wallet;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.paypal.android.base.server.tracking.TrackPage.Link;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.account.model.MutableCredebitCard;
import com.paypal.android.p2pmobile.PayPalApp;

class ConfirmCSCFragment$2
  implements View.OnClickListener
{
  final ConfirmCSCFragment this$0;

  ConfirmCSCFragment$2(ConfirmCSCFragment paramConfirmCSCFragment)
  {
  }

  public void onClick(View paramView)
  {
    Object localObject1 = this.this$0;
    localObject1 = ConfirmCSCFragment.access$100((ConfirmCSCFragment)localObject1);
    Editable localEditable = ((EditText)localObject1).getText();
    if (localEditable != null)
    {
      localObject1 = TrackPage.Point.SecurityCodeChallenge;
      Object localObject2 = TrackPage.Link.DoneButton;
      PayPalApp.logLinkPress((TrackPage.Point)localObject1, (TrackPage.Link)localObject2);
      localObject1 = this.this$0;
      localObject1 = ConfirmCSCFragment.access$200((ConfirmCSCFragment)localObject1);
      localObject2 = localEditable.toString();
      ((MutableCredebitCard)localObject1).setCvvNumber((String)localObject2);
      localObject1 = this.this$0;
      localObject1 = ConfirmCSCFragment.access$300((ConfirmCSCFragment)localObject1);
      ((ConfirmCSCFragment.OnConfirmCSCFragmentListener)localObject1).closeSoftKeyboard();
      localObject1 = this.this$0;
      localObject1 = ConfirmCSCFragment.access$300((ConfirmCSCFragment)localObject1);
      localObject2 = this.this$0;
      localObject2 = ConfirmCSCFragment.access$200((ConfirmCSCFragment)localObject2);
      ((ConfirmCSCFragment.OnConfirmCSCFragmentListener)localObject1).onConfirmEditCard((MutableCredebitCard)localObject2);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.ConfirmCSCFragment.2
 * JD-Core Version:    0.6.2
 */
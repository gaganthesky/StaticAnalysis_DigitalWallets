package com.paypal.android.p2pmobile.fragment.wallet;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.account.model.Artifact;
import com.paypal.android.foundation.account.model.CredebitCard.Id;
import com.paypal.android.foundation.core.model.UniqueId;
import com.paypal.android.p2pmobile.PayPalApp;

class WalletFragment$1
  implements AdapterView.OnItemClickListener
{
  final WalletFragment this$0;

  WalletFragment$1(WalletFragment paramWalletFragment)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject3 = TrackPage.Point.CardDetails;
    PayPalApp.logPageView((TrackPage.Point)localObject3);
    Object localObject1 = paramAdapterView.getItemAtPosition(paramInt);
    localObject1 = (Artifact)localObject1;
    if (localObject1 != null)
    {
      Object localObject2 = ((Artifact)localObject1).getUniqueId();
      localObject2 = (CredebitCard.Id)localObject2;
      localObject3 = this.this$0;
      localObject3 = WalletFragment.access$000((WalletFragment)localObject3);
      ((WalletFragment.OnContainerFragmentListener)localObject3).onWalletArtifactDetails((UniqueId)localObject2);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WalletFragment.1
 * JD-Core Version:    0.6.2
 */
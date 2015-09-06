package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.paypal.android.base.server.tracking.TrackPage.Link;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.account.model.LoyaltyProgram;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.activity.loyaltycard.LoyaltyCardScannerActivity;
import com.paypal.android.p2pmobile.services.ILoyaltyCardService;

class LoyaltyCardSearchFragment$2
  implements AdapterView.OnItemClickListener
{
  final LoyaltyCardSearchFragment this$0;

  LoyaltyCardSearchFragment$2(LoyaltyCardSearchFragment paramLoyaltyCardSearchFragment)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int j = 0;
    String str2 = null;
    Object localObject1 = LoyaltyCardSearchFragment.access$000();
    Object localObject4 = new java/lang/StringBuilder;
    ((StringBuilder)localObject4).<init>();
    Object localObject5 = "item clicked a position: ";
    localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
    localObject4 = ((StringBuilder)localObject4).append(paramInt);
    localObject4 = ((StringBuilder)localObject4).toString();
    localObject5 = new Object[j];
    ((DebugLogger)localObject1).debug((String)localObject4, (Object[])localObject5);
    localObject1 = paramView.getTag();
    if (localObject1 == null);
    while (true)
    {
      return;
      localObject1 = paramView.getTag();
      String str1 = localObject1.toString();
      if (str1 != null)
      {
        localObject1 = LoyaltyCardSearchFragment.access$000();
        localObject4 = new java/lang/StringBuilder;
        ((StringBuilder)localObject4).<init>();
        localObject5 = "item promotion code: ";
        localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
        localObject4 = ((StringBuilder)localObject4).append(str1);
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject5 = new Object[j];
        ((DebugLogger)localObject1).debug((String)localObject4, (Object[])localObject5);
        localObject1 = this.this$0;
        localObject1 = LoyaltyCardSearchFragment.access$300((LoyaltyCardSearchFragment)localObject1);
        LoyaltyProgram localLoyaltyProgram = ((ILoyaltyCardService)localObject1).getLoyaltyProgram(str1);
        boolean bool1 = localLoyaltyProgram.isUserParticipating();
        if (!bool1)
        {
          bool1 = localLoyaltyProgram.isBarcodeSupported();
          Object localObject3;
          if (bool1)
          {
            Object localObject2 = this.this$0;
            localObject2 = ((LoyaltyCardSearchFragment)localObject2).getActivity();
            boolean bool2 = LoyaltyCardScannerActivity.isScanningEnabled((Context)localObject2);
            if (bool2)
            {
              Intent localIntent = new android/content/Intent;
              localObject3 = this.this$0;
              localObject3 = ((LoyaltyCardSearchFragment)localObject3).getActivity();
              localObject4 = LoyaltyCardScannerActivity.class;
              localIntent.<init>((Context)localObject3, (Class)localObject4);
              localObject3 = this.this$0;
              ((LoyaltyCardSearchFragment)localObject3).mPromoCode = str1;
              localObject3 = this.this$0;
              int i = 1;
              ((LoyaltyCardSearchFragment)localObject3).startActivityForResult(localIntent, i);
              localObject3 = TrackPage.Point.LoyaltyCardSelectMerchant;
              TrackPage.Link localLink = TrackPage.Link.MerchantName;
              localObject5 = this.this$0;
              localObject5 = ((LoyaltyCardSearchFragment)localObject5).mPromoCode;
              PayPalApp.logLinkPress((TrackPage.Point)localObject3, localLink, (String)localObject5);
            }
          }
          else
          {
            localObject3 = this.this$0;
            ((LoyaltyCardSearchFragment)localObject3).mPromoCode = str2;
            localObject3 = this.this$0;
            localObject3 = LoyaltyCardSearchFragment.access$400((LoyaltyCardSearchFragment)localObject3);
            ((LoyaltyCardSearchFragment.OnLoyaltyCardSearchFragmentListener)localObject3).onLoyaltyProgramAdd(localLoyaltyProgram, str2, str2);
          }
        }
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.LoyaltyCardSearchFragment.2
 * JD-Core Version:    0.6.2
 */
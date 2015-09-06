package com.paypal.android.p2pmobile.fragment.wallet;

import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;

class LoyaltyProgramTermsFragment$2
  implements Runnable
{
  final LoyaltyProgramTermsFragment this$0;

  LoyaltyProgramTermsFragment$2(LoyaltyProgramTermsFragment paramLoyaltyProgramTermsFragment)
  {
  }

  public void run()
  {
    Object localObject1 = this.this$0;
    localObject1 = LoyaltyProgramTermsFragment.access$100((LoyaltyProgramTermsFragment)localObject1);
    Object localObject2 = this.this$0;
    localObject2 = LoyaltyProgramTermsFragment.access$000((LoyaltyProgramTermsFragment)localObject2);
    ((FrameLayout)localObject1).addView((View)localObject2);
    localObject1 = this.this$0;
    localObject1 = LoyaltyProgramTermsFragment.access$000((LoyaltyProgramTermsFragment)localObject1);
    localObject2 = this.this$0;
    localObject2 = LoyaltyProgramTermsFragment.access$200((LoyaltyProgramTermsFragment)localObject2);
    ((WebView)localObject1).loadUrl((String)localObject2);
    localObject1 = this.this$0;
    localObject1 = LoyaltyProgramTermsFragment.access$300((LoyaltyProgramTermsFragment)localObject1);
    localObject2 = this.this$0;
    localObject2 = ((LoyaltyProgramTermsFragment)localObject2).mHtmlRunnableData;
    ((Handler)localObject1).removeCallbacks((Runnable)localObject2);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.LoyaltyProgramTermsFragment.2
 * JD-Core Version:    0.6.2
 */
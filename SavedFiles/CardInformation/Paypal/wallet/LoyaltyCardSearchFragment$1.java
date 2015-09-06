package com.paypal.android.p2pmobile.fragment.wallet;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.paypal.android.foundation.core.log.DebugLogger;

class LoyaltyCardSearchFragment$1
  implements AbsListView.OnScrollListener
{
  final LoyaltyCardSearchFragment this$0;

  LoyaltyCardSearchFragment$1(LoyaltyCardSearchFragment paramLoyaltyCardSearchFragment)
  {
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    int n = 0;
    if (paramInt == 0)
    {
      DebugLogger localDebugLogger = LoyaltyCardSearchFragment.access$000();
      Object localObject1 = Thread.currentThread();
      localObject1 = ((Thread)localObject1).getName();
      Object localObject2 = new Object[n];
      localDebugLogger.debug((String)localObject1, (Object[])localObject2);
      localDebugLogger = LoyaltyCardSearchFragment.access$000();
      localObject1 = "Scroll state: SCROLL_STATE_IDLE";
      localObject2 = new Object[n];
      localDebugLogger.debug((String)localObject1, (Object[])localObject2);
      localDebugLogger = LoyaltyCardSearchFragment.access$000();
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localObject2 = "Last position: ";
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
      int k = paramAbsListView.getLastVisiblePosition();
      localObject1 = ((StringBuilder)localObject1).append(k);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject3 = new Object[n];
      localDebugLogger.debug((String)localObject1, (Object[])localObject3);
      localDebugLogger = LoyaltyCardSearchFragment.access$000();
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localObject3 = "Item count: ";
      localObject1 = ((StringBuilder)localObject1).append((String)localObject3);
      int m = paramAbsListView.getCount();
      localObject1 = ((StringBuilder)localObject1).append(m);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object[] arrayOfObject = new Object[n];
      localDebugLogger.debug((String)localObject1, arrayOfObject);
      int i = paramAbsListView.getLastVisiblePosition();
      int j = paramAbsListView.getCount();
      j += -1;
      if (i >= j)
      {
        LoyaltyCardSearchFragment localLoyaltyCardSearchFragment = this.this$0;
        LoyaltyCardSearchFragment.access$108(localLoyaltyCardSearchFragment);
        localLoyaltyCardSearchFragment = this.this$0;
        LoyaltyCardSearchFragment.access$200(localLoyaltyCardSearchFragment);
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.LoyaltyCardSearchFragment.1
 * JD-Core Version:    0.6.2
 */
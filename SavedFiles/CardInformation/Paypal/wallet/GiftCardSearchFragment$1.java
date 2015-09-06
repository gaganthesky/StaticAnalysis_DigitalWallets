package com.paypal.android.p2pmobile.fragment.wallet;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.paypal.android.foundation.core.log.DebugLogger;

class GiftCardSearchFragment$1
  implements AbsListView.OnScrollListener
{
  final GiftCardSearchFragment this$0;

  GiftCardSearchFragment$1(GiftCardSearchFragment paramGiftCardSearchFragment)
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
      DebugLogger localDebugLogger = GiftCardSearchFragment.access$000();
      Object localObject1 = Thread.currentThread();
      localObject1 = ((Thread)localObject1).getName();
      Object localObject2 = new Object[n];
      localDebugLogger.debug((String)localObject1, (Object[])localObject2);
      localDebugLogger = GiftCardSearchFragment.access$000();
      localObject1 = "Scroll state: SCROLL_STATE_IDLE";
      localObject2 = new Object[n];
      localDebugLogger.debug((String)localObject1, (Object[])localObject2);
      localDebugLogger = GiftCardSearchFragment.access$000();
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localObject2 = "Last position: ";
      localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
      int k = paramAbsListView.getLastVisiblePosition();
      localObject1 = ((StringBuilder)localObject1).append(k);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject3 = new Object[n];
      localDebugLogger.debug((String)localObject1, (Object[])localObject3);
      localDebugLogger = GiftCardSearchFragment.access$000();
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
        GiftCardSearchFragment localGiftCardSearchFragment1 = this.this$0;
        GiftCardSearchFragment.access$108(localGiftCardSearchFragment1);
        localGiftCardSearchFragment1 = this.this$0;
        boolean bool = GiftCardSearchFragment.access$200(localGiftCardSearchFragment1);
        if (!bool)
        {
          GiftCardSearchFragment localGiftCardSearchFragment2 = this.this$0;
          GiftCardSearchFragment.access$300(localGiftCardSearchFragment2);
        }
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.GiftCardSearchFragment.1
 * JD-Core Version:    0.6.2
 */
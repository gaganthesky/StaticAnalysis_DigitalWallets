package com.paypal.android.p2pmobile.fragment.wallet;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.paypal.android.foundation.account.model.GiftProgram;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.p2pmobile.managers.GiftCardManager;

class GiftCardSearchFragment$2
  implements AdapterView.OnItemClickListener
{
  final GiftCardSearchFragment this$0;

  GiftCardSearchFragment$2(GiftCardSearchFragment paramGiftCardSearchFragment)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String str2 = null;
    int i = 0;
    Object localObject1 = GiftCardSearchFragment.access$000();
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    Object localObject3 = "item clicked a position: ";
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
    localObject2 = ((StringBuilder)localObject2).append(paramInt);
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject3 = new Object[i];
    ((DebugLogger)localObject1).debug((String)localObject2, (Object[])localObject3);
    localObject1 = paramView.getTag();
    if (localObject1 == null);
    while (true)
    {
      return;
      localObject1 = paramView.getTag();
      String str1 = localObject1.toString();
      if (str1 != null)
      {
        localObject1 = GiftCardSearchFragment.access$000();
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject3 = "gift item promotion code: ";
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        localObject2 = ((StringBuilder)localObject2).append(str1);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new Object[i];
        ((DebugLogger)localObject1).debug((String)localObject2, (Object[])localObject3);
        localObject1 = this.this$0;
        localObject1 = GiftCardSearchFragment.access$400((GiftCardSearchFragment)localObject1);
        GiftProgram localGiftProgram = ((GiftCardManager)localObject1).getGiftCardProgram(str1);
        if (localGiftProgram != null)
        {
          localObject1 = this.this$0;
          localObject1 = GiftCardSearchFragment.access$500((GiftCardSearchFragment)localObject1);
          ((GiftCardSearchFragment.OnGiftCardSearchFragmentListener)localObject1).onGiftCardProgramAdd(localGiftProgram, str2, str2);
        }
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.GiftCardSearchFragment.2
 * JD-Core Version:    0.6.2
 */
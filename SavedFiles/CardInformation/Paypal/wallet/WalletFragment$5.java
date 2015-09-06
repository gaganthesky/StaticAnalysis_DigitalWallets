package com.paypal.android.p2pmobile.fragment.wallet;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.paypal.android.foundation.core.log.DebugLogger;

class WalletFragment$5
  implements AdapterView.OnItemClickListener
{
  final WalletFragment this$0;

  WalletFragment$5(WalletFragment paramWalletFragment)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = WalletFragment.access$100();
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    String str = "The gift card index: ";
    localObject2 = ((StringBuilder)localObject2).append(str);
    localObject2 = ((StringBuilder)localObject2).append(paramInt);
    localObject2 = ((StringBuilder)localObject2).toString();
    int i = 0;
    Object[] arrayOfObject = new Object[i];
    ((DebugLogger)localObject1).debug((String)localObject2, arrayOfObject);
    localObject1 = this.this$0;
    localObject1 = WalletFragment.access$000((WalletFragment)localObject1);
    ((WalletFragment.OnContainerFragmentListener)localObject1).onGiftCardDetails(paramInt);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WalletFragment.5
 * JD-Core Version:    0.6.2
 */
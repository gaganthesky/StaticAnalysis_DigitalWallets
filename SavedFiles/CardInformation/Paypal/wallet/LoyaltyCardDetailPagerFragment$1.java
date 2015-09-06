package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.paypal.android.p2pmobile.services.ILoyaltyCardService;
import com.paypal.android.p2pmobile.services.LoyaltyCardService;

class LoyaltyCardDetailPagerFragment$1
  implements ServiceConnection
{
  final LoyaltyCardDetailPagerFragment this$0;

  LoyaltyCardDetailPagerFragment$1(LoyaltyCardDetailPagerFragment paramLoyaltyCardDetailPagerFragment)
  {
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    LoyaltyCardDetailPagerFragment localLoyaltyCardDetailPagerFragment = this.this$0;
    ILoyaltyCardService localILoyaltyCardService = LoyaltyCardService.getLoyaltyCardService(paramIBinder);
    LoyaltyCardDetailPagerFragment.access$002(localLoyaltyCardDetailPagerFragment, localILoyaltyCardService);
    localLoyaltyCardDetailPagerFragment = this.this$0;
    localLoyaltyCardDetailPagerFragment.updateAdapterItems();
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    LoyaltyCardDetailPagerFragment localLoyaltyCardDetailPagerFragment = this.this$0;
    ILoyaltyCardService localILoyaltyCardService = null;
    LoyaltyCardDetailPagerFragment.access$002(localLoyaltyCardDetailPagerFragment, localILoyaltyCardService);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.LoyaltyCardDetailPagerFragment.1
 * JD-Core Version:    0.6.2
 */
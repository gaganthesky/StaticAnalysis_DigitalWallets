package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.paypal.android.p2pmobile.services.ILoyaltyCardService;
import com.paypal.android.p2pmobile.services.LoyaltyCardService;

class LoyaltyCardSearchFragment$4
  implements ServiceConnection
{
  final LoyaltyCardSearchFragment this$0;

  LoyaltyCardSearchFragment$4(LoyaltyCardSearchFragment paramLoyaltyCardSearchFragment)
  {
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    LoyaltyCardSearchFragment localLoyaltyCardSearchFragment1 = this.this$0;
    ILoyaltyCardService localILoyaltyCardService = LoyaltyCardService.getLoyaltyCardService(paramIBinder);
    LoyaltyCardSearchFragment.access$302(localLoyaltyCardSearchFragment1, localILoyaltyCardService);
    localLoyaltyCardSearchFragment1 = this.this$0;
    boolean bool = LoyaltyCardSearchFragment.access$500(localLoyaltyCardSearchFragment1);
    if (bool)
    {
      LoyaltyCardSearchFragment localLoyaltyCardSearchFragment2 = this.this$0;
      LoyaltyCardSearchFragment.access$600(localLoyaltyCardSearchFragment2);
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    LoyaltyCardSearchFragment localLoyaltyCardSearchFragment = this.this$0;
    ILoyaltyCardService localILoyaltyCardService = null;
    LoyaltyCardSearchFragment.access$302(localLoyaltyCardSearchFragment, localILoyaltyCardService);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.LoyaltyCardSearchFragment.4
 * JD-Core Version:    0.6.2
 */
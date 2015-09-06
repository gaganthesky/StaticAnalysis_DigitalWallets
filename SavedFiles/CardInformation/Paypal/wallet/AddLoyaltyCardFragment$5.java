package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.paypal.android.p2pmobile.services.ILoyaltyCardService;
import com.paypal.android.p2pmobile.services.LoyaltyCardService;

class AddLoyaltyCardFragment$5
  implements ServiceConnection
{
  final AddLoyaltyCardFragment this$0;

  AddLoyaltyCardFragment$5(AddLoyaltyCardFragment paramAddLoyaltyCardFragment)
  {
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AddLoyaltyCardFragment localAddLoyaltyCardFragment = this.this$0;
    ILoyaltyCardService localILoyaltyCardService = LoyaltyCardService.getLoyaltyCardService(paramIBinder);
    AddLoyaltyCardFragment.access$802(localAddLoyaltyCardFragment, localILoyaltyCardService);
    localAddLoyaltyCardFragment = this.this$0;
    AddLoyaltyCardFragment.access$900(localAddLoyaltyCardFragment);
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    AddLoyaltyCardFragment localAddLoyaltyCardFragment = this.this$0;
    ILoyaltyCardService localILoyaltyCardService = null;
    AddLoyaltyCardFragment.access$802(localAddLoyaltyCardFragment, localILoyaltyCardService);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddLoyaltyCardFragment.5
 * JD-Core Version:    0.6.2
 */
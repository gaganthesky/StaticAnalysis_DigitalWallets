package com.paypal.android.p2pmobile.fragment.wallet;

import com.paypal.android.p2pmobile.common.OnFragmentStateChange;
import com.paypal.android.p2pmobile.fragment.BaseFragment;

public abstract interface LoyaltyCardDetailPagerFragment$OnLoyaltyCardDetailPagerFragmentListener extends OnFragmentStateChange
{
  public abstract void onLoyaltyItemEdit(BaseFragment paramBaseFragment, String paramString, int paramInt1, int paramInt2);

  public abstract void startProgressLoader();

  public abstract void stopProgressLoader();
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.LoyaltyCardDetailPagerFragment.OnLoyaltyCardDetailPagerFragmentListener
 * JD-Core Version:    0.6.2
 */
package com.paypal.android.p2pmobile.fragment.wallet;

import com.paypal.android.foundation.core.model.UniqueId;
import com.paypal.android.p2pmobile.common.OnFragmentStateChange;

public abstract interface WalletFragment$OnContainerFragmentListener extends OnFragmentStateChange
{
  public abstract void hideProgressDialog();

  public abstract void onAddMoney(Class<?> paramClass);

  public abstract void onBalance();

  public abstract void onCreditAccountSummary();

  public abstract void onGiftCardDetails(int paramInt);

  public abstract void onLoyaltyCardDetails(int paramInt);

  public abstract void onPSBDetails(int paramInt);

  public abstract void onWalletArtifactDetails(UniqueId paramUniqueId);

  public abstract void onWithdrawMoney(Class<?> paramClass);

  public abstract void popFragmentBackStack();

  public abstract void popFragmentBackStack(String paramString);

  public abstract void refreshAccountModel();

  public abstract int showProgressDialog(String paramString);

  public abstract void stopProgressLoader();
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WalletFragment.OnContainerFragmentListener
 * JD-Core Version:    0.6.2
 */
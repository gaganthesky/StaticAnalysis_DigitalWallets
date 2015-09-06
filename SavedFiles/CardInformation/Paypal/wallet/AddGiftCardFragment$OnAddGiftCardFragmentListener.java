package com.paypal.android.p2pmobile.fragment.wallet;

import com.paypal.android.foundation.account.model.GiftCard.Id;
import com.paypal.android.p2pmobile.common.OnFragmentStateChange;

public abstract interface AddGiftCardFragment$OnAddGiftCardFragmentListener extends OnFragmentStateChange
{
  public abstract void hideProgressDialog();

  public abstract void onAddCardFailure(String paramString);

  public abstract void onAddCardSuccess(GiftCard.Id paramId);

  public abstract void onTermsAndCondition(String paramString);

  public abstract void popFragmentBackStack();

  public abstract void popFragmentBackStack(String paramString);

  public abstract void refreshAccountModel();

  public abstract void removeAddedGiftCardSilently(GiftCard.Id paramId, boolean paramBoolean);

  public abstract void stopProgressLoader();

  public abstract void toggleKeyBoard();
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddGiftCardFragment.OnAddGiftCardFragmentListener
 * JD-Core Version:    0.6.2
 */
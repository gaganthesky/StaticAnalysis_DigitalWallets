package com.paypal.android.p2pmobile.fragment.wallet;

import com.paypal.android.foundation.account.model.MutableCredebitCard;
import com.paypal.android.p2pmobile.common.OnFragmentStateChange;

public abstract interface ConfirmCSCFragment$OnConfirmCSCFragmentListener extends OnFragmentStateChange
{
  public abstract void closeSoftKeyboard();

  public abstract void onConfirmEditCard(MutableCredebitCard paramMutableCredebitCard);
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.ConfirmCSCFragment.OnConfirmCSCFragmentListener
 * JD-Core Version:    0.6.2
 */
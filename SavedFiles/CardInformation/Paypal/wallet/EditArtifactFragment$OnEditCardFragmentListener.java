package com.paypal.android.p2pmobile.fragment.wallet;

import com.paypal.android.foundation.account.model.MutableCredebitCard;
import com.paypal.android.foundation.core.model.UniqueId;
import com.paypal.android.p2pmobile.common.OnFragmentStateChange;

public abstract interface EditArtifactFragment$OnEditCardFragmentListener extends OnFragmentStateChange
{
  public abstract void hideProgressDialog();

  public abstract void onCancelEditCredebit();

  public abstract void onRemoveWalletArtifact(UniqueId paramUniqueId);

  public abstract void onVerifyCSC(MutableCredebitCard paramMutableCredebitCard);
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.EditArtifactFragment.OnEditCardFragmentListener
 * JD-Core Version:    0.6.2
 */
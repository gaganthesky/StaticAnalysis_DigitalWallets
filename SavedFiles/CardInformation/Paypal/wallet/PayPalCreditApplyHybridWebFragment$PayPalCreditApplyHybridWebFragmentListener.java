package com.paypal.android.p2pmobile.fragment.wallet;

import android.net.http.SslError;
import com.paypal.android.p2pmobile.common.OnFragmentStateChange;

public abstract interface PayPalCreditApplyHybridWebFragment$PayPalCreditApplyHybridWebFragmentListener extends OnFragmentStateChange
{
  public abstract void handleBMLApplyResult(PayPalCreditApplyHybridWebFragment.BMLSignupResult paramBMLSignupResult);

  public abstract void onWebViewSSLError(SslError paramSslError);
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.PayPalCreditApplyHybridWebFragment.PayPalCreditApplyHybridWebFragmentListener
 * JD-Core Version:    0.6.2
 */
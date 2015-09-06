package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.paypal.android.base.server.tracking.TrackPage.Link;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.account.AccountModel;
import com.paypal.android.foundation.core.model.Email;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.activity.WalletActivity;
import com.paypal.android.p2pmobile.events.GMGetUserDetailsSucceededEvent;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import java.util.List;

public class PayPalCreditApplyFragment extends BaseFragment
  implements View.OnClickListener
{
  private static final String LOG_TAG = (String)localObject;
  private static final String SEE_TERMS_URL = "https://www.securecheckout.billmelater.com/paycapture-content/fetch?hash=AU826TU8&content=/bmlweb/ppwpsiw.html";
  private PayPalCreditApplyHybridWebFragment.BMLEntryPoint mEntryPoint;

  static
  {
    Object localObject = PayPalCreditApplyFragment.class;
    localObject = ((Class)localObject).getSimpleName();
  }

  private void launchBMLTerms()
  {
    Intent localIntent = new android/content/Intent;
    String str = "android.intent.action.VIEW";
    Object localObject = "https://www.securecheckout.billmelater.com/paycapture-content/fetch?hash=AU826TU8&content=/bmlweb/ppwpsiw.html";
    localObject = Uri.parse((String)localObject);
    localIntent.<init>(str, (Uri)localObject);
    startActivity(localIntent);
  }

  public static PayPalCreditApplyFragment newInstance()
  {
    PayPalCreditApplyFragment localPayPalCreditApplyFragment = new com/paypal/android/p2pmobile/fragment/wallet/PayPalCreditApplyFragment;
    localPayPalCreditApplyFragment.<init>();
    return localPayPalCreditApplyFragment;
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    default:
    case 2131428639:
    case 2131428643:
    }
    while (true)
    {
      return;
      Object localObject = TrackPage.Point.BmlIntro;
      TrackPage.Link localLink = TrackPage.Link.Signup;
      PayPalApp.logLinkPress((TrackPage.Point)localObject, localLink);
      localObject = AccountModel.getInstance();
      localObject = ((AccountModel)localObject).getEmails();
      int j = 0;
      localObject = ((List)localObject).get(j);
      localObject = (Email)localObject;
      localObject = ((Email)localObject).getEmailAddress();
      String str = null;
      PayPalApp.startGetUserDetails((String)localObject, str);
      continue;
      launchBMLTerms();
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    TrackPage.Point localPoint = TrackPage.Point.BmlIntro;
    PayPalApp.logPageView(localPoint);
    int i = 2130903324;
    ViewGroup localViewGroup = null;
    View localView = paramLayoutInflater.inflate(i, localViewGroup);
    i = 2131428639;
    Object localObject1 = localView.findViewById(i);
    localObject1 = (Button)localObject1;
    ((Button)localObject1).setOnClickListener(this);
    i = 2131428643;
    Object localObject2 = localView.findViewById(i);
    localObject2 = (TextView)localObject2;
    ((TextView)localObject2).setOnClickListener(this);
    boolean bool = true;
    subscribeToEvents(bool);
    return localView;
  }

  public void onGMGetUserDetailsSuccess(GMGetUserDetailsSucceededEvent paramGMGetUserDetailsSucceededEvent)
  {
    Object localObject = getActivity();
    localObject = (WalletActivity)localObject;
    PayPalCreditApplyHybridWebFragment.BMLEntryPoint localBMLEntryPoint = this.mEntryPoint;
    ((WalletActivity)localObject).onPayPalCreditApplyHybridView(localBMLEntryPoint);
  }

  public void setEntryPoint(PayPalCreditApplyHybridWebFragment.BMLEntryPoint paramBMLEntryPoint)
  {
    this.mEntryPoint = paramBMLEntryPoint;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.PayPalCreditApplyFragment
 * JD-Core Version:    0.6.2
 */
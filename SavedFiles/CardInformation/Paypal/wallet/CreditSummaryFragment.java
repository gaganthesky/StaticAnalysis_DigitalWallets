package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.account.AccountModel;
import com.paypal.android.foundation.account.model.Artifact;
import com.paypal.android.foundation.account.model.CreditAccount;
import com.paypal.android.foundation.core.model.MoneyValue;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.tracking.AdConversionManager;
import com.paypal.android.p2pmobile.tracking.AdConversionManager.Event;
import com.paypal.android.p2pmobile.utils.DateUtils;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class CreditSummaryFragment extends BaseFragment
{
  private CreditAccount mAccount;

  private Artifact getCreditAccount()
  {
    AccountModel localAccountModel = AccountModel.getInstance();
    List localList = localAccountModel.getArtifacts();
    Iterator localIterator = localList.iterator();
    boolean bool;
    Object localObject;
    do
    {
      bool = localIterator.hasNext();
      if (!bool)
        break;
      localObject = localIterator.next();
      localObject = (Artifact)localObject;
      bool = localObject instanceof CreditAccount;
    }
    while (!bool);
    while (true)
    {
      return localObject;
      localObject = null;
    }
  }

  private void logPageView()
  {
    CreditAccount localCreditAccount = this.mAccount;
    Object localObject1;
    if (localCreditAccount != null)
    {
      localCreditAccount = this.mAccount;
      boolean bool1 = localCreditAccount.isBml();
      if (!bool1)
        break label33;
      localObject1 = TrackPage.Point.BmlAccountDetails;
      PayPalApp.logPageView((TrackPage.Point)localObject1);
    }
    while (true)
    {
      return;
      label33: localObject1 = this.mAccount;
      boolean bool2 = ((CreditAccount)localObject1).isEbayMastercard();
      Object localObject2;
      if (bool2)
      {
        localObject2 = TrackPage.Point.EbayMasterCardAccountDetails;
        PayPalApp.logPageView((TrackPage.Point)localObject2);
      }
      else
      {
        localObject2 = this.mAccount;
        boolean bool3 = ((CreditAccount)localObject2).isPaypalPluscard();
        Object localObject3;
        if (bool3)
        {
          localObject3 = TrackPage.Point.PlusCardAccountDetails;
          PayPalApp.logPageView((TrackPage.Point)localObject3);
        }
        else
        {
          localObject3 = this.mAccount;
          boolean bool4 = ((CreditAccount)localObject3).isBuyerCredit();
          if (bool4)
          {
            TrackPage.Point localPoint = TrackPage.Point.PaypalSmartConnectAccountDetails;
            PayPalApp.logPageView(localPoint);
          }
        }
      }
    }
  }

  public static CreditSummaryFragment newInstance()
  {
    CreditSummaryFragment localCreditSummaryFragment = new com/paypal/android/p2pmobile/fragment/wallet/CreditSummaryFragment;
    localCreditSummaryFragment.<init>();
    return localCreditSummaryFragment;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    int i = 2130903190;
    Object localObject2 = null;
    View localView = paramLayoutInflater.inflate(i, (ViewGroup)localObject2);
    Object localObject1 = getCreditAccount();
    if (localObject1 != null)
    {
      localObject1 = (CreditAccount)localObject1;
      this.mAccount = ((CreditAccount)localObject1);
      if (localView != null)
      {
        populateView(localView);
        logPageView();
      }
    }
    FragmentActivity localFragmentActivity = getActivity();
    localObject2 = AdConversionManager.Event.WALLET_CHECK_PAYPAL_CREDIT_BALANCE;
    AdConversionManager.track(localFragmentActivity, (AdConversionManager.Event)localObject2);
    return localView;
  }

  private void populateView(View paramView)
  {
    int i = 2131427915;
    Object localObject2 = paramView.findViewById(i);
    localObject2 = (TextView)localObject2;
    MovementMethod localMovementMethod = LinkMovementMethod.getInstance();
    ((TextView)localObject2).setMovementMethod(localMovementMethod);
    int j = 2131427913;
    Object localObject1 = paramView.findViewById(j);
    localObject1 = (TextView)localObject1;
    CreditAccount localCreditAccount = this.mAccount;
    boolean bool1 = localCreditAccount.isBml();
    String str2;
    String str4;
    String str5;
    String str3;
    String str1;
    Object localObject4;
    if (bool1)
    {
      Object localObject3 = getResources();
      int i3 = 2131494712;
      localObject3 = ((Resources)localObject3).getString(i3);
      localObject3 = Html.fromHtml((String)localObject3);
      ((TextView)localObject2).setText((CharSequence)localObject3);
      localObject3 = getResources();
      i3 = 2131494711;
      localObject3 = ((Resources)localObject3).getString(i3);
      ((TextView)localObject1).setText((CharSequence)localObject3);
      localObject3 = this.mAccount;
      if (localObject3 != null)
      {
        str2 = null;
        localObject3 = this.mAccount;
        localObject3 = ((CreditAccount)localObject3).getMinimumPaymentDate();
        if (localObject3 != null)
        {
          localObject3 = this.mAccount;
          localObject3 = ((CreditAccount)localObject3).getMinimumPaymentDate();
          Locale localLocale = PayPalApp.getLocale();
          boolean bool2 = true;
          str2 = DateUtils.getMediumFormat((Date)localObject3, localLocale, bool2);
        }
        localObject3 = this.mAccount;
        localObject3 = ((CreditAccount)localObject3).getMinimumPaymentAmount();
        str4 = ((MoneyValue)localObject3).getFormattedLong();
        localObject3 = this.mAccount;
        localObject3 = ((CreditAccount)localObject3).getCurrentBalance();
        str5 = ((MoneyValue)localObject3).getFormattedLong();
        localObject3 = this.mAccount;
        localObject3 = ((CreditAccount)localObject3).getLastStatementBalance();
        str3 = ((MoneyValue)localObject3).getFormattedLong();
        localObject3 = this.mAccount;
        localObject3 = ((CreditAccount)localObject3).getAvailableCredit();
        str1 = ((MoneyValue)localObject3).getFormattedLong();
        int k = 2131427909;
        localObject4 = paramView.findViewById(k);
        localObject4 = (TextView)localObject4;
        if (str2 == null)
          break label463;
      }
    }
    while (true)
    {
      ((TextView)localObject4).setText(str2);
      int m = 2131427910;
      Object localObject5 = paramView.findViewById(m);
      localObject5 = (TextView)localObject5;
      ((TextView)localObject5).setText(str4);
      int n = 2131427911;
      Object localObject6 = paramView.findViewById(n);
      localObject6 = (TextView)localObject6;
      ((TextView)localObject6).setText(str5);
      int i1 = 2131427912;
      Object localObject7 = paramView.findViewById(i1);
      localObject7 = (TextView)localObject7;
      ((TextView)localObject7).setText(str3);
      int i2 = 2131427914;
      Object localObject8 = paramView.findViewById(i2);
      localObject8 = (TextView)localObject8;
      ((TextView)localObject8).setText(str1);
      return;
      localObject8 = getResources();
      int i4 = 2131494710;
      localObject8 = ((Resources)localObject8).getString(i4);
      ((TextView)localObject1).setText((CharSequence)localObject8);
      localObject8 = getResources();
      i4 = 2131494713;
      localObject8 = ((Resources)localObject8).getString(i4);
      localObject8 = Html.fromHtml((String)localObject8);
      ((TextView)localObject2).setText((CharSequence)localObject8);
      break;
      label463: Resources localResources = getResources();
      int i5 = 2131494704;
      str2 = localResources.getString(i5);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.CreditSummaryFragment
 * JD-Core Version:    0.6.2
 */
package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.account.AccountModel;
import com.paypal.android.foundation.account.model.AccountBalance;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.foundation.core.model.MoneyBalance;
import com.paypal.android.foundation.core.model.MoneyValue;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.common.PerCountryData;
import com.paypal.android.p2pmobile.core.AppIntentFactory.WalletOperation;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.tracking.AdConversionManager;
import com.paypal.android.p2pmobile.tracking.AdConversionManager.Event;
import com.paypal.android.p2pmobile.utils.ViewUtility;
import java.util.Iterator;
import java.util.List;

public class BalanceFragment extends BaseFragment
{
  private static final DebugLogger L = (DebugLogger)localObject;
  private View mRootView;

  static
  {
    Object localObject = BalanceFragment.class;
    localObject = DebugLogger.getLogger((Class)localObject);
  }

  private BalanceFragment.OnBalanceFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (BalanceFragment.OnBalanceFragmentListener)localObject;
    return localObject;
  }

  public static BalanceFragment newInstance()
  {
    BalanceFragment localBalanceFragment = new com/paypal/android/p2pmobile/fragment/wallet/BalanceFragment;
    localBalanceFragment.<init>();
    return localBalanceFragment;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    boolean bool4 = true;
    subscribeToWalletOperationBroadcasts(bool4);
    int k = 2130903143;
    boolean bool5 = false;
    Object localObject1 = paramLayoutInflater.inflate(k, paramViewGroup, bool5);
    this.mRootView = ((View)localObject1);
    localObject1 = TrackPage.Point.Balance;
    PayPalApp.logPageView((TrackPage.Point)localObject1);
    localObject1 = this.mRootView;
    int m = 2131427806;
    localObject1 = ((View)localObject1).findViewById(m);
    BalanceFragment.1 local1 = new com/paypal/android/p2pmobile/fragment/wallet/BalanceFragment$1;
    local1.<init>(this);
    ((View)localObject1).setOnClickListener(local1);
    localObject1 = this.mRootView;
    int n = 2131427807;
    localObject1 = ((View)localObject1).findViewById(n);
    BalanceFragment.2 local2 = new com/paypal/android/p2pmobile/fragment/wallet/BalanceFragment$2;
    local2.<init>(this);
    ((View)localObject1).setOnClickListener(local2);
    localObject1 = this.mRootView;
    int i1 = 2131427802;
    boolean bool6 = false;
    ViewUtility.showOrHide((View)localObject1, i1, bool6);
    localObject1 = getResources();
    localObject1 = ((Resources)localObject1).getDisplayMetrics();
    float f1 = ((DisplayMetrics)localObject1).density;
    i1 = 14;
    int i = ViewUtility.convertDpToPixels(f1, i1);
    Object localObject2 = getResources();
    localObject2 = ((Resources)localObject2).getDisplayMetrics();
    float f2 = ((DisplayMetrics)localObject2).density;
    i1 = 16;
    int j = ViewUtility.convertDpToPixels(f2, i1);
    Object localObject3 = this.mRootView;
    i1 = 2131427801;
    localObject3 = ((View)localObject3).findViewById(i1);
    ((View)localObject3).setPadding(i, j, i, j);
    boolean bool1 = PayPalApp.supportsAddFunds();
    boolean bool3 = PayPalApp.supportsWithdraw();
    boolean bool2 = PayPalApp.supportsDepositCheck();
    if ((!bool1) && (!bool3) && (!bool2))
    {
      localObject3 = this.mRootView;
      i1 = 2131427513;
      bool6 = false;
      ViewUtility.showOrHide((View)localObject3, i1, bool6);
      localObject3 = this.mRootView;
      i1 = 2131427805;
      bool6 = false;
      ViewUtility.showOrHide((View)localObject3, i1, bool6);
    }
    while (true)
    {
      AccountModel localAccountModel = AccountModel.getInstance();
      if (localAccountModel != null)
        renderBalanceSection(localAccountModel);
      localObject3 = getActivity();
      AdConversionManager.Event localEvent = AdConversionManager.Event.WALLET_CHECK_BALANCE;
      AdConversionManager.track((Context)localObject3, localEvent);
      localObject3 = this.mRootView;
      return localObject3;
      localObject3 = this.mRootView;
      int i2 = 2131427513;
      bool6 = true;
      ViewUtility.showOrHide((View)localObject3, i2, bool6);
      localObject3 = this.mRootView;
      i2 = 2131427805;
      bool6 = true;
      ViewUtility.showOrHide((View)localObject3, i2, bool6);
      localObject3 = this.mRootView;
      i2 = 2131427806;
      ViewUtility.showOrHide((View)localObject3, i2, bool1);
      localObject3 = this.mRootView;
      i2 = 2131427807;
      ViewUtility.showOrHide((View)localObject3, i2, bool3);
    }
  }

  protected void onWalletOperation(AppIntentFactory.WalletOperation paramWalletOperation, Intent paramIntent)
  {
    AccountModel localAccountModel = AccountModel.getInstance();
    Object localObject = L;
    String str = "onWalletOperation called";
    int k = 0;
    Object[] arrayOfObject = new Object[k];
    ((DebugLogger)localObject).debug(str, arrayOfObject);
    localObject = BalanceFragment.3.$SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation;
    int j = paramWalletOperation.ordinal();
    int i = localObject[j];
    switch (i)
    {
    default:
    case 1:
    }
    while (true)
    {
      BalanceFragment.OnBalanceFragmentListener localOnBalanceFragmentListener = getLocalListener();
      if (localOnBalanceFragmentListener != null)
        localOnBalanceFragmentListener.stopProgressLoader();
      return;
      renderBalanceSection(localAccountModel);
    }
  }

  public void renderBalanceSection(AccountModel paramAccountModel)
  {
    int i2 = 2131493552;
    int i1 = 1;
    AccountBalance localAccountBalance = paramAccountModel.getBalance();
    String str2 = null;
    String str3 = null;
    if (localAccountBalance != null)
    {
      Object localObject3 = localAccountBalance.getConvertedBalance();
      localObject3 = ((MoneyBalance)localObject3).getAvailable();
      str2 = ((MoneyValue)localObject3).getFormattedLong();
      localObject3 = localAccountBalance.getConvertedBalance();
      localObject3 = ((MoneyBalance)localObject3).getTotal();
      str3 = ((MoneyValue)localObject3).getFormattedLong();
    }
    if (str2 != null)
    {
      int i = str2.length();
      if (i >= i1);
    }
    else
    {
      str2 = getString(i2);
    }
    if (str3 != null)
    {
      int j = str3.length();
      if (j >= i1);
    }
    else
    {
      str3 = getString(i2);
    }
    Object localObject4 = this.mRootView;
    i1 = 2131427803;
    localObject4 = ((View)localObject4).findViewById(i1);
    localObject4 = (TextView)localObject4;
    ((TextView)localObject4).setText(str3);
    localObject4 = this.mRootView;
    i1 = 2131427804;
    localObject4 = ((View)localObject4).findViewById(i1);
    localObject4 = (TextView)localObject4;
    ((TextView)localObject4).setText(str2);
    localObject4 = this.mRootView;
    i1 = 2131427787;
    Object localObject2 = ((View)localObject4).findViewById(i1);
    localObject2 = (LinearLayout)localObject2;
    ((LinearLayout)localObject2).removeAllViews();
    if (localAccountBalance != null)
    {
      List localList = localAccountBalance.getCurrencyBalances();
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (true)
        {
          boolean bool = localIterator.hasNext();
          if (!bool)
            break;
          Object localObject1 = localIterator.next();
          localObject1 = (MoneyBalance)localObject1;
          Object localObject5 = ((MoneyBalance)localObject1).getAvailable();
          String str1 = ((MoneyValue)localObject5).getFormattedLong();
          localObject5 = ((MoneyBalance)localObject1).getPending();
          String str4 = ((MoneyValue)localObject5).getFormattedLong();
          localObject5 = PayPalApp.getContext();
          LayoutInflater localLayoutInflater = LayoutInflater.from((Context)localObject5);
          int k = 2130903144;
          i1 = 0;
          View localView = localLayoutInflater.inflate(k, (ViewGroup)localObject2, i1);
          k = 2131427788;
          Object localObject6 = localView.findViewById(k);
          localObject6 = (TextView)localObject6;
          String str5 = ((MoneyBalance)localObject1).getCurrencyCode();
          str5 = PerCountryData.getLocalizedName(str5);
          ((TextView)localObject6).setText(str5);
          int m = 2131427791;
          Object localObject7 = localView.findViewById(m);
          localObject7 = (TextView)localObject7;
          ((TextView)localObject7).setText(str1);
          int n = 2131427794;
          Object localObject8 = localView.findViewById(n);
          localObject8 = (TextView)localObject8;
          ((TextView)localObject8).setText(str4);
          ((LinearLayout)localObject2).addView(localView);
        }
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.BalanceFragment
 * JD-Core Version:    0.6.2
 */
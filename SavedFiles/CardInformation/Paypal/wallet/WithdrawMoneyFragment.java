package com.paypal.android.p2pmobile.fragment.wallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.paypal.android.base.common.Country;
import com.paypal.android.base.common.MoneySpec;
import com.paypal.android.base.common.WithdrawObject;
import com.paypal.android.base.common.WithdrawObject.WithdrawLimitType;
import com.paypal.android.base.server.Dispatchable2;
import com.paypal.android.base.server.gmapi.GMAnalyzeWithdrawReq2;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.base.server_request.ErrorBase;
import com.paypal.android.foundation.account.AccountModel;
import com.paypal.android.foundation.account.model.AccountBalance;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.foundation.core.model.MoneyBalance;
import com.paypal.android.foundation.core.model.MoneyValue;
import com.paypal.android.foundation.core.model.MutableMoneyValue;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.common.AccountSpinnerAdapter;
import com.paypal.android.p2pmobile.common.FieldEditor;
import com.paypal.android.p2pmobile.common.FundingSourceSelector;
import com.paypal.android.p2pmobile.common.MoneySpecEditor;
import com.paypal.android.p2pmobile.common.MoneySpecEditor.Mode;
import com.paypal.android.p2pmobile.common.MoneySpecSpinnerAdapter;
import com.paypal.android.p2pmobile.common.OnFieldCallback;
import com.paypal.android.p2pmobile.common.PayPalUser;
import com.paypal.android.p2pmobile.core.AppIntentFactory.WalletOperation;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.fragment.dialogs.AccountActivitySuccessDialog;
import com.paypal.android.p2pmobile.fragment.dialogs.MessageDialog;
import com.paypal.android.p2pmobile.fragment.dialogs.PPButtonDialogFragmentInterface;
import com.paypal.android.p2pmobile.fragment.dialogs.PPDialogFragment;
import com.paypal.android.p2pmobile.fragment.dialogs.WaitDialog;
import com.paypal.android.p2pmobile.fragment.dialogs.WithdrawMoneyConfirmationDialog;
import com.paypal.android.p2pmobile.fragment.dialogs.YesNoDialog;
import com.paypal.android.p2pmobile.tracking.PayPalFeedbackManager;
import com.paypal.android.p2pmobile.tracking.PayPalFeedbackManager.PointSystemError;
import com.paypal.android.p2pmobile.utils.LegacyConversionUtils;
import com.paypal.android.p2pmobile.utils.MiscUtils;
import com.paypal.android.p2pmobile.utils.UI;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;

public class WithdrawMoneyFragment extends BaseFragment
  implements View.OnClickListener, TextView.OnEditorActionListener, OnFieldCallback, AdapterView.OnItemSelectedListener, PPButtonDialogFragmentInterface
{
  private static final DebugLogger L;
  private static int sAsynchHackPosition = 0;
  private FundingSourceSelector mBalanceSelector;
  private FundingSourceSelector mBankSelector;
  private WithdrawMoneyFragment.WithdrawMoneyDataLayer mDataLayer;
  private boolean mDoPostponedWithdrawMoneyFinish;
  private boolean mFinishAfterDialog;
  private ErrorBase mLastError;
  private MoneySpecEditor mMoneyEditor;
  private View mRootView;
  private int mSelectedDestPosition;
  private int mSelectedSrcPosition;
  private WithdrawMoneyFragment.State mState;
  private boolean mWithdrawAllowed;
  private WithdrawObject mWithdrawObject;

  static
  {
    Object localObject = WithdrawMoneyFragment.class;
    localObject = DebugLogger.getLogger((Class)localObject);
    L = (DebugLogger)localObject;
    int i = 0;
  }

  public WithdrawMoneyFragment()
  {
    Object localObject = null;
    this.mWithdrawObject = localObject;
    boolean bool = true;
    this.mWithdrawAllowed = bool;
    this.mFinishAfterDialog = i;
    this.mSelectedSrcPosition = i;
    this.mSelectedDestPosition = i;
    WithdrawMoneyFragment.State localState = WithdrawMoneyFragment.State.IDLE;
    this.mState = localState;
  }

  private void analyzeWithdraw()
  {
    Object localObject1 = WithdrawMoneyFragment.DialogType.PleaseWait;
    Object localObject2 = null;
    int i = 2131493401;
    Object localObject3 = getString(i);
    boolean bool = false;
    showDialog((WithdrawMoneyFragment.DialogType)localObject1, (String)localObject2, (String)localObject3, bool);
    localObject1 = WithdrawMoneyFragment.State.ANALYZE_WITHDRAW;
    this.mState = ((WithdrawMoneyFragment.State)localObject1);
    localObject1 = this.mWithdrawObject;
    localObject2 = this.mMoneyEditor;
    localObject2 = ((MoneySpecEditor)localObject2).getAmount();
    localObject2 = LegacyConversionUtils.getAmountString((MutableMoneyValue)localObject2);
    ((WithdrawObject)localObject1).setPaymentAmount((String)localObject2);
    localObject1 = this.mDataLayer;
    localObject2 = this.mDataLayer;
    localObject3 = this.mWithdrawObject;
    long l = ((WithdrawMoneyFragment.WithdrawMoneyDataLayer)localObject2).doGMAnalyzeWithdrawReq((WithdrawObject)localObject3, this);
    ((WithdrawMoneyFragment.WithdrawMoneyDataLayer)localObject1).track(l);
  }

  private void analyzeWithdrawOK(WithdrawObject paramWithdrawObject)
  {
    int n = 2131493433;
    MoneySpec localMoneySpec1 = paramWithdrawObject.getPaymentAmount();
    MoneySpec localMoneySpec2 = paramWithdrawObject.getFee();
    String str1 = paramWithdrawObject.getClearingPeriod();
    boolean bool1 = PayPalApp.haveUser();
    Object localObject1;
    Object localObject4;
    Object localObject5;
    if (!bool1)
    {
      localObject1 = L;
      localObject4 = "No user";
      n = 0;
      localObject5 = new Object[n];
      ((DebugLogger)localObject1).debug((String)localObject4, (Object[])localObject5);
      localObject1 = getListener();
      localObject1 = (WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener)localObject1;
      ((WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener)localObject1).onWithdrawMoneyFinish();
    }
    while (true)
    {
      return;
      PayPalUser localPayPalUser = PayPalApp.getCurrentUser();
      localObject1 = "GB";
      localObject4 = localPayPalUser.getUserCountry();
      localObject4 = ((Country)localObject4).getCode();
      boolean bool2 = ((String)localObject1).equals(localObject4);
      String str2;
      String str6;
      String str4;
      if (bool2)
      {
        str2 = "";
        String str3;
        if (str1 != null)
        {
          int i = 2131493431;
          str3 = getString(i);
          localObject4 = "%1";
        }
        int j;
        for (str2 = str3.replace((CharSequence)localObject4, str1); ; str2 = getString(j))
        {
          boolean bool3 = localMoneySpec2.isZero();
          if (!bool3)
          {
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            localObject2 = ((StringBuilder)localObject2).append(str2);
            localObject4 = " ";
            localObject2 = ((StringBuilder)localObject2).append((String)localObject4);
            localObject4 = getString(localObject5);
            localObject5 = "%1";
            str6 = localMoneySpec2.format();
            localObject4 = ((String)localObject4).replace((CharSequence)localObject5, str6);
            localObject2 = ((StringBuilder)localObject2).append((String)localObject4);
            str2 = ((StringBuilder)localObject2).toString();
          }
          Object localObject2 = WithdrawMoneyFragment.DialogType.Proceed_UK_User;
          int k = 2131493415;
          str4 = getString(k);
          showDialog((WithdrawMoneyFragment.DialogType)localObject2, str4, str2);
          break;
          j = 2131493432;
        }
      }
      boolean bool4 = localMoneySpec2.isZero();
      if (bool4)
      {
        performWithdraw();
      }
      else
      {
        Object localObject3 = getString(localObject5);
        str4 = "%1";
        localObject5 = localMoneySpec2.format();
        str2 = ((String)localObject3).replace(str4, (CharSequence)localObject5);
        localObject3 = TrackPage.Point.WithdrawConfirm;
        PayPalApp.logPageView((TrackPage.Point)localObject3);
        localObject3 = WithdrawMoneyFragment.DialogType.Proceed;
        int m = 2131493430;
        String str5 = getString(m);
        localObject5 = "%1";
        str6 = localMoneySpec1.format();
        str5 = str5.replace((CharSequence)localObject5, str6);
        showDialog((WithdrawMoneyFragment.DialogType)localObject3, str5, str2);
      }
    }
  }

  private void analzyeWithdrawFailure(GMAnalyzeWithdrawReq2 paramGMAnalyzeWithdrawReq2)
  {
    String str4 = "10879";
    Object localObject1 = str4;
    Object localObject3 = paramGMAnalyzeWithdrawReq2;
    boolean bool1 = MiscUtils.hasErrorWithCode((String)localObject1, (Dispatchable2)localObject3);
    double d3;
    int i;
    Currency localCurrency;
    Iterator localIterator;
    Object localObject2;
    Object localObject24;
    String str12;
    String str3;
    Object localObject12;
    Object localObject21;
    Object localObject4;
    String str1;
    if (bool1)
    {
      d3 = -1.0D;
      double d2 = -1.0D;
      i = 0;
      Object localObject9 = WithdrawMoneyFragment.State.IDLE;
      localObject1 = localObject9;
      localObject3 = this;
      ((WithdrawMoneyFragment)localObject3).mState = ((WithdrawMoneyFragment.State)localObject1);
      localObject1 = this;
      localObject1 = ((WithdrawMoneyFragment)localObject1).mWithdrawObject;
      localObject9 = localObject1;
      localObject9 = ((WithdrawObject)localObject9).getPaymentAmount();
      localCurrency = ((MoneySpec)localObject9).getCurrency();
      localObject1 = this;
      localObject1 = ((WithdrawMoneyFragment)localObject1).mWithdrawObject;
      localObject9 = localObject1;
      String str10 = localCurrency.getCurrencyCode();
      String str2 = ((WithdrawObject)localObject9).getLimitMax(str10);
      if (str2 != null)
      {
        int j = str2.length();
        if (j > 0)
          d3 = Double.parseDouble(str2);
      }
      AccountModel localAccountModel = AccountModel.getInstance();
      AccountBalance localAccountBalance = localAccountModel.getBalance();
      double d5;
      if (localAccountBalance != null)
      {
        List localList = localAccountBalance.getCurrencyBalances();
        if (localList != null)
        {
          localIterator = localList.iterator();
          while (true)
          {
            boolean bool2 = localIterator.hasNext();
            if (!bool2)
              break;
            Object localObject5 = localIterator.next();
            localObject5 = (MoneyBalance)localObject5;
            MoneyValue localMoneyValue = ((MoneyBalance)localObject5).getAvailable();
            if (localMoneyValue != null)
            {
              String str5 = localMoneyValue.getCurrencyCode();
              str10 = localCurrency.getCurrencyCode();
              boolean bool3 = str5.equalsIgnoreCase(str10);
              if (bool3)
              {
                long l2 = localMoneyValue.getValue();
                long l1 = l2;
                double d1 = l1;
                d5 = d1;
                double d4 = localMoneyValue.getScale();
                d1 = d4;
                d1 = d1;
                double d6 = d1;
                d2 = d5 / d6;
              }
            }
          }
        }
      }
      boolean bool4 = d3 < d2;
      if (bool4)
      {
        d5 = -1.0D;
        bool4 = d3 < d5;
        if (bool4)
        {
          i = 0;
          if (i == 0)
            break label506;
          Object localObject10 = 2131493417;
          localObject2 = this;
          localObject3 = localObject10;
          String str6 = ((WithdrawMoneyFragment)localObject2).getString(localObject3);
          String str11 = "%1";
          localObject24 = new com/paypal/android/base/common/MoneySpec;
          str12 = Double.toString(d2);
          String str13 = localCurrency.getCurrencyCode();
          ((MoneySpec)localObject24).<init>(str12, str13);
          localObject24 = ((MoneySpec)localObject24).format();
          str3 = str6.replace(str11, (CharSequence)localObject24);
          Object localObject11 = 0;
          localObject2 = localObject11;
          localObject3 = this;
          ((WithdrawMoneyFragment)localObject3).mFinishAfterDialog = localObject2;
          String str7 = "10818";
          localObject2 = str7;
          localObject3 = paramGMAnalyzeWithdrawReq2;
          boolean bool5 = MiscUtils.hasErrorWithCode((String)localObject2, (Dispatchable2)localObject3);
          if (!bool5)
          {
            localObject12 = WithdrawMoneyFragment.DialogType.Error;
            Object localObject20 = 2131493166;
            localObject2 = this;
            localObject3 = localObject20;
            localObject21 = ((WithdrawMoneyFragment)localObject2).getString(localObject3);
            localObject2 = this;
            localObject3 = localObject12;
            localObject4 = localObject21;
            str1 = str3;
            ((WithdrawMoneyFragment)localObject2).showDialog((WithdrawMoneyFragment.DialogType)localObject3, (String)localObject4, str1);
            localObject12 = TrackPage.Point.WithdrawStart;
            localObject21 = paramGMAnalyzeWithdrawReq2.getLastError();
            localObject2 = localObject12;
            localObject3 = localObject21;
            localObject4 = str3;
            PayPalApp.logError((TrackPage.Point)localObject2, (ErrorBase)localObject3, (String)localObject4);
            localObject12 = WithdrawMoneyFragment.State.IDLE;
            localObject2 = localObject12;
            localObject3 = this;
            ((WithdrawMoneyFragment)localObject3).mState = ((WithdrawMoneyFragment.State)localObject2);
          }
        }
      }
    }
    while (true)
    {
      return;
      i = 1;
      break;
      label506: Object localObject8 = null;
      localObject2 = this;
      localObject2 = ((WithdrawMoneyFragment)localObject2).mWithdrawObject;
      localObject12 = localObject2;
      localObject12 = ((WithdrawObject)localObject12).getPeriodicLimits();
      localIterator = ((List)localObject12).iterator();
      Object localObject6;
      boolean bool7;
      do
      {
        boolean bool6 = localIterator.hasNext();
        if (!bool6)
          break;
        localObject6 = localIterator.next();
        localObject6 = (MoneySpec)localObject6;
        String str8 = ((MoneySpec)localObject6).getCurrencyString();
        localObject2 = this;
        localObject2 = ((WithdrawMoneyFragment)localObject2).mWithdrawObject;
        localObject21 = localObject2;
        localObject21 = ((WithdrawObject)localObject21).getPaymentAmount();
        localObject21 = ((MoneySpec)localObject21).getCurrency();
        localObject21 = ((Currency)localObject21).getCurrencyCode();
        bool7 = str8.equals(localObject21);
      }
      while (!bool7);
      localObject8 = localObject6;
      localObject2 = this;
      localObject2 = ((WithdrawMoneyFragment)localObject2).mWithdrawObject;
      Object localObject13 = localObject2;
      localObject13 = ((WithdrawObject)localObject13).getLimitType();
      localObject21 = WithdrawObject.WithdrawLimitType.Annual;
      localObject2 = localObject13;
      localObject3 = localObject21;
      Object localObject7;
      if (localObject2 == localObject3)
        localObject7 = 2131493420;
      while (true)
      {
        Object localObject14 = 2131493416;
        localObject2 = this;
        localObject3 = localObject14;
        localObject15 = ((WithdrawMoneyFragment)localObject2).getString(localObject3);
        localObject21 = "%3";
        localObject24 = new com/paypal/android/base/common/MoneySpec;
        str12 = Double.toString(d3);
        localObject2 = localObject24;
        localObject3 = str12;
        localObject4 = localCurrency;
        ((MoneySpec)localObject2).<init>((String)localObject3, (Currency)localObject4);
        localObject24 = ((MoneySpec)localObject24).format();
        localObject15 = ((String)localObject15).replace((CharSequence)localObject21, (CharSequence)localObject24);
        localObject21 = "%2";
        localObject2 = this;
        localObject3 = localObject7;
        localObject24 = ((WithdrawMoneyFragment)localObject2).getString(localObject3);
        str3 = ((String)localObject15).replace((CharSequence)localObject21, (CharSequence)localObject24);
        if (localObject8 == null)
          break;
        localObject15 = "%1";
        localObject21 = localObject8.format();
        localObject2 = str3;
        localObject3 = localObject15;
        localObject4 = localObject21;
        str3 = ((String)localObject2).replace((CharSequence)localObject3, (CharSequence)localObject4);
        break;
        localObject2 = this;
        localObject2 = ((WithdrawMoneyFragment)localObject2).mWithdrawObject;
        localObject15 = localObject2;
        localObject15 = ((WithdrawObject)localObject15).getLimitType();
        localObject21 = WithdrawObject.WithdrawLimitType.Monthly;
        localObject2 = localObject15;
        localObject3 = localObject21;
        if (localObject2 == localObject3)
          localObject7 = 2131493419;
        else
          localObject7 = 2131493418;
      }
      Object localObject15 = "10881";
      localObject2 = localObject15;
      localObject3 = paramGMAnalyzeWithdrawReq2;
      boolean bool8 = MiscUtils.hasErrorWithCode((String)localObject2, (Dispatchable2)localObject3);
      Object localObject18;
      if (bool8)
      {
        Object localObject16 = "10881";
        localObject2 = localObject16;
        localObject3 = paramGMAnalyzeWithdrawReq2;
        localObject16 = MiscUtils.getErrorByCode((String)localObject2, (Dispatchable2)localObject3);
        str3 = MiscUtils.mapToLocalizedError((ErrorBase)localObject16);
        Object localObject17 = 0;
        localObject2 = localObject17;
        localObject3 = this;
        ((WithdrawMoneyFragment)localObject3).mFinishAfterDialog = localObject2;
        String str9 = "10818";
        localObject2 = str9;
        localObject3 = paramGMAnalyzeWithdrawReq2;
        boolean bool9 = MiscUtils.hasErrorWithCode((String)localObject2, (Dispatchable2)localObject3);
        if (!bool9)
        {
          localObject18 = WithdrawMoneyFragment.DialogType.Error;
          Object localObject22 = 2131493166;
          localObject2 = this;
          localObject3 = localObject22;
          Object localObject23 = ((WithdrawMoneyFragment)localObject2).getString(localObject3);
          localObject2 = this;
          localObject3 = localObject18;
          localObject4 = localObject23;
          str1 = str3;
          ((WithdrawMoneyFragment)localObject2).showDialog((WithdrawMoneyFragment.DialogType)localObject3, (String)localObject4, str1);
          localObject18 = TrackPage.Point.WithdrawStart;
          localObject23 = paramGMAnalyzeWithdrawReq2.getLastError();
          localObject2 = localObject18;
          localObject3 = localObject23;
          localObject4 = str3;
          PayPalApp.logError((TrackPage.Point)localObject2, (ErrorBase)localObject3, (String)localObject4);
        }
      }
      else
      {
        localObject18 = "10818";
        localObject2 = localObject18;
        localObject3 = paramGMAnalyzeWithdrawReq2;
        boolean bool10 = MiscUtils.hasErrorWithCode((String)localObject2, (Dispatchable2)localObject3);
        if (!bool10)
        {
          showErrorView();
          PayPalFeedbackManager localPayPalFeedbackManager = new com/paypal/android/p2pmobile/tracking/PayPalFeedbackManager;
          Object localObject19 = getActivity();
          localObject2 = localObject19;
          localPayPalFeedbackManager.<init>((Activity)localObject2);
          localObject19 = PayPalFeedbackManager.PointSystemError.WithdrawMoneyError;
          localObject2 = localObject19;
          localPayPalFeedbackManager.registerError((PayPalFeedbackManager.PointSystemError)localObject2);
        }
      }
    }
  }

  private boolean canWithdrawFunds()
  {
    List localList = getBalances();
    MoneySpecEditor localMoneySpecEditor = this.mMoneyEditor;
    if (localMoneySpecEditor != null)
    {
      localMoneySpecEditor = this.mMoneyEditor;
      boolean bool1 = localMoneySpecEditor.validAmount();
      if (bool1)
      {
        WithdrawObject localWithdrawObject = this.mWithdrawObject;
        if ((localWithdrawObject != null) && (localList != null))
        {
          bool2 = localList.isEmpty();
          if (!bool2)
          {
            bool2 = this.mWithdrawAllowed;
            if (!bool2);
          }
        }
      }
    }
    for (boolean bool2 = true; ; bool2 = false)
      return bool2;
  }

  private void dismissDialog(WithdrawMoneyFragment.DialogType paramDialogType)
  {
    FragmentManager localFragmentManager = getFragmentManager();
    String str = paramDialogType.name();
    Object localObject = localFragmentManager.findFragmentByTag(str);
    localObject = (DialogFragment)localObject;
    if (localObject != null)
      ((DialogFragment)localObject).dismiss();
  }

  private void dismissSuccess()
  {
    FragmentManager localFragmentManager = getFragmentManager();
    Object localObject2 = AccountActivitySuccessDialog.class;
    localObject2 = ((Class)localObject2).getName();
    Object localObject1 = localFragmentManager.findFragmentByTag((String)localObject2);
    localObject1 = (DialogFragment)localObject1;
    if (localObject1 != null)
      ((DialogFragment)localObject1).dismiss();
  }

  private List<MoneyValue> getBalances()
  {
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    AccountModel localAccountModel = AccountModel.getInstance();
    AccountBalance localAccountBalance = localAccountModel.getBalance();
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
          Object localObject = localIterator.next();
          localObject = (MoneyBalance)localObject;
          MoneyValue localMoneyValue = ((MoneyBalance)localObject).getAvailable();
          if (localMoneyValue != null)
          {
            localMoneyValue = ((MoneyBalance)localObject).getAvailable();
            localArrayList.add(localMoneyValue);
          }
        }
      }
    }
    return localArrayList;
  }

  public Activity getHostActivity()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return localFragmentActivity;
  }

  private WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener)localObject;
    return localObject;
  }

  private void getWithdrawOptions()
  {
    String str = null;
    Object localObject1 = WithdrawMoneyFragment.State.GET_WITHDRAW_OPTIONS;
    this.mState = ((WithdrawMoneyFragment.State)localObject1);
    localObject1 = WithdrawMoneyFragment.DialogType.PleaseWait;
    int i = 2131493401;
    Object localObject2 = getString(i);
    showDialog((WithdrawMoneyFragment.DialogType)localObject1, str, (String)localObject2);
    localObject1 = this.mDataLayer;
    localObject2 = this.mDataLayer;
    long l = ((WithdrawMoneyFragment.WithdrawMoneyDataLayer)localObject2).doGMGetWithdrawOptionsReq(str);
    ((WithdrawMoneyFragment.WithdrawMoneyDataLayer)localObject1).track(l);
  }

  private boolean hasUsableBalance()
  {
    List localList = getBalances();
    Iterator localIterator = localList.iterator();
    do
    {
      bool = localIterator.hasNext();
      if (!bool)
        break;
      Object localObject = localIterator.next();
      localObject = (MoneyValue)localObject;
      bool = ((MoneyValue)localObject).isPositive();
    }
    while (!bool);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public static WithdrawMoneyFragment newInstance()
  {
    WithdrawMoneyFragment localWithdrawMoneyFragment = new com/paypal/android/p2pmobile/fragment/wallet/WithdrawMoneyFragment;
    localWithdrawMoneyFragment.<init>();
    return localWithdrawMoneyFragment;
  }

  public void onCancel(DialogFragment paramDialogFragment)
  {
    boolean bool = this.mFinishAfterDialog;
    if (bool)
    {
      Object localObject = getListener();
      localObject = (WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener)localObject;
      ((WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener)localObject).onWithdrawMoneyFinish();
    }
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    default:
    case 2131428935:
    }
    while (true)
    {
      return;
      analyzeWithdraw();
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    WithdrawMoneyFragment.WithdrawMoneyDataLayer localWithdrawMoneyDataLayer = new com/paypal/android/p2pmobile/fragment/wallet/WithdrawMoneyFragment$WithdrawMoneyDataLayer;
    localWithdrawMoneyDataLayer.<init>(this, this);
    this.mDataLayer = localWithdrawMoneyDataLayer;
    localWithdrawMoneyDataLayer = this.mDataLayer;
    String str = "mDataLayer";
    localWithdrawMoneyDataLayer.onCreate(str, paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool3 = true;
    TrackPage.Point localPoint = TrackPage.Point.WithdrawStart;
    PayPalApp.logPageView(localPoint);
    subscribeToWalletOperationBroadcasts(bool3);
    int i = 2130903402;
    boolean bool2 = false;
    Object localObject1 = paramLayoutInflater.inflate(i, paramViewGroup, bool2);
    this.mRootView = ((View)localObject1);
    renderBalanceHeader();
    Object localObject2 = new com/paypal/android/p2pmobile/common/FundingSourceSelector;
    localObject1 = this.mRootView;
    int k = 2131428937;
    localObject1 = ((View)localObject1).findViewById(k);
    localObject1 = (ViewGroup)localObject1;
    k = 2131493422;
    ((FundingSourceSelector)localObject2).<init>(this, (ViewGroup)localObject1, bool3, k);
    this.mBalanceSelector = ((FundingSourceSelector)localObject2);
    localObject2 = new com/paypal/android/p2pmobile/common/FundingSourceSelector;
    localObject1 = this.mRootView;
    k = 2131427639;
    localObject1 = ((View)localObject1).findViewById(k);
    localObject1 = (ViewGroup)localObject1;
    k = 2131493423;
    ((FundingSourceSelector)localObject2).<init>(this, (ViewGroup)localObject1, bool3, k);
    this.mBankSelector = ((FundingSourceSelector)localObject2);
    localObject2 = new com/paypal/android/p2pmobile/common/MoneySpecEditor;
    localObject1 = this.mRootView;
    k = 2131427640;
    localObject1 = ((View)localObject1).findViewById(k);
    localObject1 = (ViewGroup)localObject1;
    MoneySpecEditor.Mode localMode = MoneySpecEditor.Mode.Entry;
    ((MoneySpecEditor)localObject2).<init>(this, (ViewGroup)localObject1, bool3, localMode);
    this.mMoneyEditor = ((MoneySpecEditor)localObject2);
    localObject1 = this.mMoneyEditor;
    ((MoneySpecEditor)localObject1).hideElements();
    localObject1 = this.mRootView;
    int j = 2131427795;
    localObject1 = ((View)localObject1).findViewById(j);
    j = 8;
    ((View)localObject1).setVisibility(j);
    if (paramBundle == null)
      getWithdrawOptions();
    while (true)
    {
      boolean bool1 = PayPalApp.haveUser();
      if (bool1)
      {
        setupWithdrawDestSpinner();
        setupWithdrawSrcSpinner();
        bool1 = canWithdrawFunds();
        updateWithdrawFundsClickable(bool1);
      }
      View localView = this.mRootView;
      return localView;
      restoreInstanceState(paramBundle);
    }
  }

  public void onDismiss(DialogFragment paramDialogFragment)
  {
    boolean bool = this.mFinishAfterDialog;
    if (bool)
    {
      bool = paramDialogFragment instanceof WaitDialog;
      if (!bool)
      {
        Object localObject = getListener();
        if (localObject != null)
        {
          localObject = getListener();
          localObject = (WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener)localObject;
          ((WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener)localObject).onWithdrawMoneyFinish();
        }
      }
    }
  }

  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    return bool;
  }

  public void onFieldChanged(FieldEditor paramFieldEditor)
  {
    boolean bool = canWithdrawFunds();
    updateWithdrawFundsClickable(bool);
  }

  public void onFieldSelected(FieldEditor paramFieldEditor)
  {
  }

  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Adapter localAdapter = paramAdapterView.getAdapter();
    boolean bool = localAdapter instanceof AccountSpinnerAdapter;
    Object localObject;
    if (bool)
    {
      localObject = this.mWithdrawObject;
      ((WithdrawObject)localObject).setFundsId(paramInt);
      this.mSelectedDestPosition = paramInt;
    }
    while (true)
    {
      return;
      localObject = paramAdapterView.getItemAtPosition(paramInt);
      localObject = (MoneyValue)localObject;
      String str = ((MoneyValue)localObject).getCurrencyCode();
      localObject = this.mWithdrawObject;
      ((WithdrawObject)localObject).setPaymentCurrencyID(str);
      this.mSelectedSrcPosition = paramInt;
      localObject = this.mMoneyEditor;
      Currency localCurrency = Currency.getInstance(str);
      ((MoneySpecEditor)localObject).changeCurrencyCode(localCurrency);
    }
  }

  public void onNegativeClick(PPDialogFragment paramPPDialogFragment)
  {
    boolean bool = this.mFinishAfterDialog;
    if (bool)
    {
      Object localObject = getListener();
      localObject = (WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener)localObject;
      ((WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener)localObject).onWithdrawMoneyFinish();
    }
    while (true)
    {
      return;
      dismissSuccess();
      getWithdrawOptions();
    }
  }

  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
  }

  public void onPositiveClick(PPDialogFragment paramPPDialogFragment)
  {
    boolean bool = paramPPDialogFragment instanceof YesNoDialog;
    if (!bool)
    {
      bool = paramPPDialogFragment instanceof WithdrawMoneyConfirmationDialog;
      if (!bool);
    }
    else
    {
      performWithdraw();
    }
  }

  public void onResume()
  {
    super.onResume();
    renderBalanceHeader();
    boolean bool = this.mDoPostponedWithdrawMoneyFinish;
    if (bool)
    {
      bool = false;
      this.mDoPostponedWithdrawMoneyFinish = bool;
      View localView = this.mRootView;
      WithdrawMoneyFragment.1 local1 = new com/paypal/android/p2pmobile/fragment/wallet/WithdrawMoneyFragment$1;
      local1.<init>(this);
      localView.post(local1);
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Object localObject1 = this.mDataLayer;
    Object localObject2 = "mDataLayer";
    ((WithdrawMoneyFragment.WithdrawMoneyDataLayer)localObject1).onSaveInstanceState((String)localObject2, paramBundle);
    localObject1 = "mWithdrawObject";
    localObject2 = this.mWithdrawObject;
    paramBundle.putParcelable((String)localObject1, (Parcelable)localObject2);
    localObject1 = "mWithdrawAllowed";
    boolean bool = this.mWithdrawAllowed;
    paramBundle.putBoolean((String)localObject1, bool);
    localObject1 = "mFinishAfterDialog";
    bool = this.mFinishAfterDialog;
    paramBundle.putBoolean((String)localObject1, bool);
    localObject1 = "selectedSrcPosition";
    int i = this.mSelectedSrcPosition;
    paramBundle.putInt((String)localObject1, i);
    localObject1 = "selectedDestPosition";
    i = this.mSelectedDestPosition;
    paramBundle.putInt((String)localObject1, i);
    localObject1 = "state";
    WithdrawMoneyFragment.State localState = this.mState;
    int j = localState.ordinal();
    paramBundle.putInt((String)localObject1, j);
    localObject1 = this.mMoneyEditor;
    if (localObject1 != null)
    {
      localObject1 = this.mMoneyEditor;
      MutableMoneyValue localMutableMoneyValue = ((MoneySpecEditor)localObject1).getAmount();
      localObject1 = "withdrawFundsAmount";
      paramBundle.putParcelable((String)localObject1, localMutableMoneyValue);
    }
  }

  public void onShowEditable(FieldEditor paramFieldEditor)
  {
  }

  public void onShowNonEditable(FieldEditor paramFieldEditor)
  {
  }

  public void onStart()
  {
    int i = 1;
    super.onStart();
    WithdrawMoneyFragment.WithdrawMoneyDataLayer localWithdrawMoneyDataLayer = this.mDataLayer;
    boolean bool = localWithdrawMoneyDataLayer.onStart();
    if (!bool)
    {
      FragmentActivity localFragmentActivity = getActivity();
      localFragmentActivity.setResult(i);
      this.mDoPostponedWithdrawMoneyFinish = i;
    }
  }

  public void onStop()
  {
    super.onStop();
    WithdrawMoneyFragment.WithdrawMoneyDataLayer localWithdrawMoneyDataLayer = this.mDataLayer;
    localWithdrawMoneyDataLayer.onStop();
  }

  protected void onWalletOperation(AppIntentFactory.WalletOperation paramWalletOperation, Intent paramIntent)
  {
    Object localObject = L;
    String str = "onWalletOperation called";
    int k = 0;
    Object[] arrayOfObject = new Object[k];
    ((DebugLogger)localObject).debug(str, arrayOfObject);
    localObject = WithdrawMoneyFragment.3.$SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation;
    int j = paramWalletOperation.ordinal();
    int i = localObject[j];
    switch (i)
    {
    default:
    case 1:
    }
    while (true)
    {
      WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener localOnWithdrawMoneyFragmentListener = getLocalListener();
      if (localOnWithdrawMoneyFragmentListener != null)
      {
        boolean bool = isResumed();
        if (bool)
        {
          bool = isVisible();
          if (bool)
            localOnWithdrawMoneyFragmentListener.stopProgressLoader();
        }
      }
      return;
      renderBalanceHeader();
    }
  }

  public void performWithdraw()
  {
    Object localObject1 = WithdrawMoneyFragment.DialogType.PleaseWait;
    Object localObject2 = null;
    int i = 2131493401;
    Object localObject3 = getString(i);
    boolean bool = false;
    showDialog((WithdrawMoneyFragment.DialogType)localObject1, (String)localObject2, (String)localObject3, bool);
    localObject1 = WithdrawMoneyFragment.State.PERFORM_WITHDRAW;
    this.mState = ((WithdrawMoneyFragment.State)localObject1);
    localObject1 = this.mDataLayer;
    localObject2 = this.mDataLayer;
    localObject3 = this.mWithdrawObject;
    long l = ((WithdrawMoneyFragment.WithdrawMoneyDataLayer)localObject2).doGMWithdrawReq((WithdrawObject)localObject3, this);
    ((WithdrawMoneyFragment.WithdrawMoneyDataLayer)localObject1).track(l);
  }

  private void renderBalanceHeader()
  {
    int i = 2131493552;
    String str = getString(i);
    AccountModel localAccountModel = AccountModel.getInstance();
    if (localAccountModel != null)
    {
      AccountBalance localAccountBalance = localAccountModel.getBalance();
      if (localAccountBalance != null)
      {
        localObject = localAccountBalance.getConvertedBalance();
        localObject = ((MoneyBalance)localObject).getAvailable();
        str = ((MoneyValue)localObject).getFormattedLong();
      }
    }
    Object localObject = this.mRootView;
    int j = 2131427798;
    UI.setText((View)localObject, j, str);
  }

  private void restoreInstanceState(Bundle paramBundle)
  {
    Object localObject2 = "mWithdrawObject";
    localObject2 = paramBundle.getParcelable((String)localObject2);
    localObject2 = (WithdrawObject)localObject2;
    this.mWithdrawObject = ((WithdrawObject)localObject2);
    localObject2 = "mWithdrawAllowed";
    boolean bool1 = paramBundle.getBoolean((String)localObject2);
    this.mWithdrawAllowed = bool1;
    String str1 = "mFinishAfterDialog";
    boolean bool2 = paramBundle.getBoolean(str1);
    this.mFinishAfterDialog = bool2;
    String str2 = "selectedSrcPosition";
    int i = paramBundle.getInt(str2);
    this.mSelectedSrcPosition = i;
    String str3 = "selectedDestPosition";
    int j = paramBundle.getInt(str3);
    this.mSelectedDestPosition = j;
    Object localObject3 = WithdrawMoneyFragment.State.values();
    String str4 = "state";
    int k = paramBundle.getInt(str4);
    localObject3 = localObject3[k];
    this.mState = ((WithdrawMoneyFragment.State)localObject3);
    localObject3 = "withdrawFundsAmount";
    Object localObject1 = paramBundle.getParcelable((String)localObject3);
    localObject1 = (MutableMoneyValue)localObject1;
    if (localObject1 != null)
    {
      localObject3 = this.mMoneyEditor;
      ((MoneySpecEditor)localObject3).setAmount((MutableMoneyValue)localObject1);
    }
  }

  private void setupWithdrawDestSpinner()
  {
    int i = 1;
    Object localObject1 = this.mWithdrawObject;
    if (localObject1 != null)
    {
      localObject1 = this.mBankSelector;
      Object localObject2 = new com/paypal/android/p2pmobile/common/AccountSpinnerAdapter;
      FragmentActivity localFragmentActivity = getActivity();
      Object localObject3 = this.mWithdrawObject;
      localObject3 = ((WithdrawObject)localObject3).getWithdrawDestOptions();
      ((AccountSpinnerAdapter)localObject2).<init>(localFragmentActivity, (List)localObject3);
      ((FundingSourceSelector)localObject1).setAdapter((SpinnerAdapter)localObject2);
      localObject1 = this.mBankSelector;
      localObject2 = this.mWithdrawObject;
      localObject2 = ((WithdrawObject)localObject2).getWithdrawDestOptions();
      int m = ((List)localObject2).size();
      if (m <= i)
        break label111;
    }
    while (true)
    {
      ((FundingSourceSelector)localObject1).setEnabled(i);
      FundingSourceSelector localFundingSourceSelector = this.mBankSelector;
      localFundingSourceSelector.setOnItemSelectedListener(this);
      localFundingSourceSelector = this.mBankSelector;
      int k = this.mSelectedDestPosition;
      localFundingSourceSelector.setSpinnerSelection(k);
      return;
      label111: int j = 0;
    }
  }

  private void setupWithdrawSrcSpinner()
  {
    int n = 1;
    Object localObject1 = this.mWithdrawObject;
    if (localObject1 == null)
      return;
    List localList = getBalances();
    localObject1 = this.mBalanceSelector;
    Object localObject3 = new com/paypal/android/p2pmobile/common/MoneySpecSpinnerAdapter;
    Object localObject5 = getActivity();
    ((MoneySpecSpinnerAdapter)localObject3).<init>((Activity)localObject5, localList);
    ((FundingSourceSelector)localObject1).setAdapter((SpinnerAdapter)localObject3);
    localObject3 = this.mBalanceSelector;
    int i = localList.size();
    if (i > n);
    int m;
    for (i = n; ; m = 0)
    {
      ((FundingSourceSelector)localObject3).setEnabled(i);
      FundingSourceSelector localFundingSourceSelector = this.mBalanceSelector;
      localFundingSourceSelector.setOnItemSelectedListener(this);
      int j = this.mSelectedSrcPosition;
      sAsynchHackPosition = j;
      Handler localHandler = new android/os/Handler;
      localHandler.<init>();
      localObject3 = new com/paypal/android/p2pmobile/fragment/wallet/WithdrawMoneyFragment$2;
      ((WithdrawMoneyFragment.2)localObject3).<init>(this);
      long l = 100L;
      localHandler.postDelayed((Runnable)localObject3, l);
      boolean bool = canWithdrawFunds();
      updateWithdrawFundsClickable(bool);
      bool = hasUsableBalance();
      if (bool)
        break;
      this.mFinishAfterDialog = n;
      int k = 2131493417;
      Object localObject2 = getString(k);
      String str2 = "%1";
      double d = 0.0D;
      Object localObject4 = Double.valueOf(d);
      localObject5 = PayPalApp.getCurrentCurrency();
      localObject5 = ((Currency)localObject5).getCurrencyCode();
      localObject4 = MutableMoneyValue.createIfValid((Number)localObject4, (String)localObject5);
      localObject4 = ((MutableMoneyValue)localObject4).getFormatted();
      String str1 = ((String)localObject2).replace(str2, (CharSequence)localObject4);
      localObject2 = WithdrawMoneyFragment.DialogType.Error;
      int i1 = 2131493166;
      String str3 = getString(i1);
      showDialog((WithdrawMoneyFragment.DialogType)localObject2, str3, str1);
      localObject2 = TrackPage.Point.WithdrawStart;
      str3 = null;
      PayPalApp.logError((TrackPage.Point)localObject2, str3, str1);
      break;
    }
  }

  private void showDialog(WithdrawMoneyFragment.DialogType paramDialogType, String paramString1, String paramString2)
  {
    boolean bool = true;
    showDialog(paramDialogType, paramString1, paramString2, bool);
  }

  private void showDialog(WithdrawMoneyFragment.DialogType paramDialogType, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = getFragmentManager();
    String str1 = paramDialogType.name();
    Fragment localFragment = ((FragmentManager)localObject1).findFragmentByTag(str1);
    if (localFragment != null)
    {
      localObject1 = getFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject1).beginTransaction();
      localFragmentTransaction.remove(localFragment);
      localFragmentTransaction.commit();
    }
    int i1 = 0;
    localObject1 = WithdrawMoneyFragment.3.$SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$WithdrawMoneyFragment$DialogType;
    int j = paramDialogType.ordinal();
    int i = localObject1[j];
    Object localObject2;
    Object localObject3;
    Object localObject4;
    switch (i)
    {
    default:
      localObject2 = L;
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>();
      String str2 = "Unknown dialog ";
      localObject3 = ((StringBuilder)localObject3).append(str2);
      str2 = paramDialogType.toString();
      localObject3 = ((StringBuilder)localObject3).append(str2);
      localObject3 = ((StringBuilder)localObject3).toString();
      int k = 0;
      localObject4 = new Object[k];
      ((DebugLogger)localObject2).debug((String)localObject3, (Object[])localObject4);
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return;
      localObject2 = WithdrawMoneyFragment.class;
      localObject2 = ((Class)localObject2).getName();
      Object localObject6 = WaitDialog.newInstance(paramString2, (String)localObject2, paramBoolean);
      if (localObject6 != null)
      {
        localObject2 = getFragmentManager();
        localObject3 = paramDialogType.name();
        ((DialogFragment)localObject6).show((FragmentManager)localObject2, (String)localObject3);
        continue;
        localObject2 = WithdrawMoneyFragment.class;
        localObject2 = ((Class)localObject2).getName();
        localObject6 = MessageDialog.newInstance(paramString2, (String)localObject2);
        if (localObject6 != null)
        {
          localObject2 = getFragmentManager();
          localObject3 = paramDialogType.name();
          ((DialogFragment)localObject6).show((FragmentManager)localObject2, (String)localObject3);
          continue;
          localObject2 = TrackPage.Point.WithdrawDone;
          PayPalApp.logPageView((TrackPage.Point)localObject2);
          localObject2 = WithdrawMoneyFragment.class;
          localObject2 = ((Class)localObject2).getName();
          localObject2 = AccountActivitySuccessDialog.newInstance(paramString1, paramString2, (String)localObject2);
          localObject3 = getFragmentManager();
          localObject4 = AccountActivitySuccessDialog.class;
          localObject4 = ((Class)localObject4).getName();
          ((AccountActivitySuccessDialog)localObject2).show((FragmentManager)localObject3, (String)localObject4);
          continue;
          localObject2 = TrackPage.Point.WithdrawConfirm;
          PayPalApp.logPageView((TrackPage.Point)localObject2);
          int m = 2131493757;
          int n = 2131493725;
          localObject2 = WithdrawMoneyFragment.class;
          String str3 = ((Class)localObject2).getName();
          String str4 = paramDialogType.name();
          localObject2 = paramString1;
          localObject3 = paramString2;
          localObject2 = YesNoDialog.newInstance((String)localObject2, (String)localObject3, m, n, str3, str4);
          localObject3 = getFragmentManager();
          Object localObject5 = paramDialogType.name();
          ((YesNoDialog)localObject2).show((FragmentManager)localObject3, (String)localObject5);
          continue;
          localObject2 = TrackPage.Point.WithdrawConfirm;
          PayPalApp.logPageView((TrackPage.Point)localObject2);
          localObject2 = WithdrawMoneyFragment.class;
          localObject2 = ((Class)localObject2).getName();
          localObject2 = WithdrawMoneyConfirmationDialog.newInstance(paramString1, paramString2, (String)localObject2);
          localObject3 = getFragmentManager();
          localObject5 = WithdrawMoneyConfirmationDialog.class;
          localObject5 = ((Class)localObject5).getName();
          ((WithdrawMoneyConfirmationDialog)localObject2).show((FragmentManager)localObject3, (String)localObject5);
        }
      }
    }
  }

  private void showErrorView()
  {
    int k = 2131493767;
    Object localObject1 = L;
    Object localObject4 = new java/lang/StringBuilder;
    ((StringBuilder)localObject4).<init>();
    Object localObject5 = "last error ";
    localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
    localObject5 = this.mLastError;
    localObject5 = ((ErrorBase)localObject5).getLongMessage();
    localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
    localObject4 = ((StringBuilder)localObject4).toString();
    int j = 0;
    Object[] arrayOfObject = new Object[j];
    ((DebugLogger)localObject1).debug((String)localObject4, arrayOfObject);
    localObject1 = this.mLastError;
    if (localObject1 != null)
    {
      localObject1 = this.mLastError;
      String str2 = ((ErrorBase)localObject1).getErrorCode();
      boolean bool1 = TextUtils.isEmpty(str2);
      if (!bool1)
      {
        String str4 = "01011";
        boolean bool2 = str2.equals(str4);
        if (bool2)
        {
          PayPalFeedbackManager localPayPalFeedbackManager = new com/paypal/android/p2pmobile/tracking/PayPalFeedbackManager;
          localObject2 = getHostActivity();
          localPayPalFeedbackManager.<init>((Activity)localObject2);
          localObject2 = PayPalFeedbackManager.PointSystemError.WithdrawMoneyError;
          localPayPalFeedbackManager.registerError((PayPalFeedbackManager.PointSystemError)localObject2);
        }
      }
    }
    Object localObject2 = this.mLastError;
    String str1 = MiscUtils.mapToLocalizedError((ErrorBase)localObject2);
    if (str1 != null)
    {
      localObject2 = WithdrawMoneyFragment.DialogType.Error;
      localObject4 = getString(k);
      showDialog((WithdrawMoneyFragment.DialogType)localObject2, (String)localObject4, str1);
      localObject2 = TrackPage.Point.WithdrawStart;
      localObject4 = this.mLastError;
      PayPalApp.logError((TrackPage.Point)localObject2, (ErrorBase)localObject4, str1);
    }
    while (true)
    {
      return;
      int i = 2131493769;
      String str3 = getString(i);
      Object localObject3 = WithdrawMoneyFragment.DialogType.Error;
      localObject4 = getString(k);
      showDialog((WithdrawMoneyFragment.DialogType)localObject3, (String)localObject4, str3);
      localObject3 = TrackPage.Point.WithdrawStart;
      localObject4 = this.mLastError;
      PayPalApp.logError((TrackPage.Point)localObject3, (ErrorBase)localObject4, str3);
    }
  }

  private void updateWithdrawFundsClickable(boolean paramBoolean)
  {
    View localView = this.mRootView;
    int i = 2131428935;
    Object localObject = localView.findViewById(i);
    localObject = (Button)localObject;
    boolean bool;
    if (paramBoolean)
    {
      bool = true;
      ((Button)localObject).setEnabled(bool);
      ((Button)localObject).setOnClickListener(this);
    }
    while (true)
    {
      return;
      bool = false;
      ((Button)localObject).setEnabled(bool);
      View.OnClickListener localOnClickListener = null;
      ((Button)localObject).setOnClickListener(localOnClickListener);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WithdrawMoneyFragment
 * JD-Core Version:    0.6.2
 */
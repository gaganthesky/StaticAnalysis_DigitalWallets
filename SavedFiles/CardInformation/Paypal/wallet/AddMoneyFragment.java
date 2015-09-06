package com.paypal.android.p2pmobile.fragment.wallet;

import android.app.Activity;
import android.content.Context;
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
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.paypal.android.base.Core.APIName;
import com.paypal.android.base.Logging;
import com.paypal.android.base.common.AbstractFundingSourceObject;
import com.paypal.android.base.common.CurrencyUtil;
import com.paypal.android.base.common.WithdrawObject;
import com.paypal.android.base.exceptions.InvalidArgumentException;
import com.paypal.android.base.metarequest.LoginMetaRequest;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.base.server_request.ErrorBase;
import com.paypal.android.base.server_request.ServerRequest2;
import com.paypal.android.foundation.account.AccountModel;
import com.paypal.android.foundation.account.model.AccountBalance;
import com.paypal.android.foundation.core.model.MoneyBalance;
import com.paypal.android.foundation.core.model.MoneyValue;
import com.paypal.android.foundation.core.model.MutableMoneyValue;
import com.paypal.android.foundation.core.operations.OperationListener;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.activity.cip.CIPVerifyActivity;
import com.paypal.android.p2pmobile.common.AccountSpinnerAdapter;
import com.paypal.android.p2pmobile.common.FieldEditor;
import com.paypal.android.p2pmobile.common.FundingSourceSelector;
import com.paypal.android.p2pmobile.common.MoneySpecEditor;
import com.paypal.android.p2pmobile.common.MoneySpecEditor.Mode;
import com.paypal.android.p2pmobile.common.OnFieldCallback;
import com.paypal.android.p2pmobile.common.PayPalUser;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.fragment.dialogs.AccountActivitySuccessDialog;
import com.paypal.android.p2pmobile.fragment.dialogs.MessageDialog;
import com.paypal.android.p2pmobile.fragment.dialogs.PPButtonDialogFragmentInterface;
import com.paypal.android.p2pmobile.fragment.dialogs.PPDialogFragment;
import com.paypal.android.p2pmobile.fragment.dialogs.WaitDialog;
import com.paypal.android.p2pmobile.tracking.AdConversionManager;
import com.paypal.android.p2pmobile.tracking.AdConversionManager.Event;
import com.paypal.android.p2pmobile.tracking.PayPalFeedbackManager;
import com.paypal.android.p2pmobile.tracking.PayPalFeedbackManager.PointSystemError;
import com.paypal.android.p2pmobile.utils.InputUtils;
import com.paypal.android.p2pmobile.utils.LegacyConversionUtils;
import com.paypal.android.p2pmobile.utils.MiscUtils;
import com.paypal.android.p2pmobile.utils.UI;
import java.util.ArrayList;
import java.util.Currency;

public class AddMoneyFragment extends BaseFragment
  implements View.OnClickListener, TextView.OnEditorActionListener, OnFieldCallback, AdapterView.OnItemSelectedListener, PPButtonDialogFragmentInterface
{
  private static final String LOG_TAG = (String)localObject;
  private AbstractFundingSourceObject addFundsSource;
  private ArrayList addFundsSources;
  private FundingSourceSelector bankSelector;
  private boolean cipStatusOk;
  private boolean finishAfterDialog;
  private AddMoneyFragment.MyDataLayer mDataLayer;
  private Core.APIName mFailedRequest;
  private MoneySpecEditor mMoneyEditor;
  private View mRootView;
  private int mSelectedPosition;
  private AddMoneyFragment.State state;
  String successMessage;
  private boolean successState;
  String title;
  private WithdrawObject withdrawObject;

  static
  {
    Object localObject = AddMoneyFragment.class;
    localObject = ((Class)localObject).getSimpleName();
  }

  public AddMoneyFragment()
  {
    Object localObject = "";
    this.title = ((String)localObject);
    localObject = "";
    this.successMessage = ((String)localObject);
    localObject = AddMoneyFragment.State.IDLE;
    this.state = ((AddMoneyFragment.State)localObject);
  }

  private void addFunds()
  {
    Object localObject1 = LOG_TAG;
    Object localObject3 = "addFunds";
    Logging.d((String)localObject1, (String)localObject3);
    localObject1 = this.addFundsSource;
    localObject1 = ((AbstractFundingSourceObject)localObject1).getCurrency();
    String str2 = ((Currency)localObject1).getCurrencyCode();
    localObject1 = this.addFundsSource;
    String str1 = ((AbstractFundingSourceObject)localObject1).getAmount();
    int i = 2131493766;
    String str3 = getString(i);
    try
    {
      localObject2 = "%1";
      localObject3 = CurrencyUtil.formatAmountWithCurrencySymbolAndCurrencyCode(str1, str2);
      str3 = str3.replace((CharSequence)localObject2, (CharSequence)localObject3);
      localObject2 = "%2";
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>();
      localObject3 = ((StringBuilder)localObject3).append(str2);
      String str4 = " ";
      localObject3 = ((StringBuilder)localObject3).append(str4);
      int j = 2131493771;
      Object localObject4 = getString(j);
      localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
      localObject3 = ((StringBuilder)localObject3).toString();
      str3 = str3.replace((CharSequence)localObject2, (CharSequence)localObject3);
      localObject2 = this.withdrawObject;
      if (localObject2 != null)
      {
        localObject2 = this.mDataLayer;
        localObject3 = this.mDataLayer;
        localObject4 = this.withdrawObject;
        localObject4 = ((WithdrawObject)localObject4).getWithdrawToken();
        Object localObject5 = null;
        long l = ((AddMoneyFragment.MyDataLayer)localObject3).doGMAddFundsReq((String)localObject4, localObject5);
        ((AddMoneyFragment.MyDataLayer)localObject2).track(l);
      }
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Object localObject2 = "%1";
        str3 = str3.replace((CharSequence)localObject2, str1);
      }
    }
  }

  public void analyzeAddFunds()
    throws InvalidArgumentException
  {
    Object localObject3 = null;
    Object localObject1 = LOG_TAG;
    Object localObject2 = "analyzeAddFunds";
    Logging.d((String)localObject1, (String)localObject2);
    localObject1 = this.mDataLayer;
    localObject2 = this.mDataLayer;
    AbstractFundingSourceObject localAbstractFundingSourceObject = this.addFundsSource;
    long l = ((AddMoneyFragment.MyDataLayer)localObject2).doGMAnalyzeAddFundsReq(localAbstractFundingSourceObject, localObject3);
    ((AddMoneyFragment.MyDataLayer)localObject1).track(l);
    localObject1 = AddMoneyFragment.DialogType.PleaseWait;
    int i = 2131493402;
    String str = getString(i);
    showDialog((AddMoneyFragment.DialogType)localObject1, localObject3, str);
  }

  private boolean canAddFunds()
  {
    boolean bool = false;
    Object localObject1 = this.addFundsSource;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = LOG_TAG;
      localObject3 = "canAddFunds addFundsSource is null";
      Logging.d((String)localObject1, (String)localObject3);
    }
    while (true)
    {
      return bool;
      localObject1 = this.addFundsSource;
      localObject1 = ((AbstractFundingSourceObject)localObject1).getAmount();
      if (localObject1 != null)
      {
        localObject1 = this.addFundsSource;
        localObject1 = ((AbstractFundingSourceObject)localObject1).getAmount();
        int j = ((String)localObject1).length();
        if (j > 0)
        {
          String str = LOG_TAG;
          Object localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          localObject3 = "canAddFunds found amt ";
          localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
          localObject3 = this.addFundsSource;
          localObject3 = ((AbstractFundingSourceObject)localObject3).getAmount();
          localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
          localObject2 = ((StringBuilder)localObject2).toString();
          Logging.d(str, (String)localObject2);
          int i = 1;
        }
      }
    }
  }

  private void dismissDialog(AddMoneyFragment.DialogType paramDialogType)
  {
    Object localObject2 = getFragmentManager();
    String str = "Dialog";
    Object localObject1 = ((FragmentManager)localObject2).findFragmentByTag(str);
    localObject1 = (DialogFragment)localObject1;
    localObject2 = LOG_TAG;
    str = "dismissDialog";
    Logging.d((String)localObject2, str);
    if (localObject1 != null)
    {
      localObject2 = LOG_TAG;
      str = "found and dismissed";
      Logging.d((String)localObject2, str);
      ((DialogFragment)localObject1).dismiss();
    }
  }

  private void getCIPStatus()
  {
    AddMoneyFragment.State localState = AddMoneyFragment.State.GET_CIP;
    this.state = localState;
    boolean bool1 = PayPalApp.haveUser();
    Object localObject1;
    Object localObject2;
    if (bool1)
    {
      bool1 = PayPalApp.isCIPEnabled();
      if (bool1)
      {
        PayPalUser localPayPalUser = PayPalApp.getCurrentUser();
        boolean bool2 = localPayPalUser.isCIPEligible();
        if (bool2)
        {
          bool2 = this.cipStatusOk;
          if (!bool2)
          {
            localObject1 = this.mDataLayer;
            localObject2 = this.mDataLayer;
            Object localObject3 = null;
            long l = ((AddMoneyFragment.MyDataLayer)localObject2).doGetCIPStatus(localObject3);
            ((AddMoneyFragment.MyDataLayer)localObject1).track(l);
          }
        }
      }
    }
    while (true)
    {
      return;
      localObject1 = LOG_TAG;
      localObject2 = "No user";
      Logging.e((String)localObject1, (String)localObject2);
      localObject1 = getActivity();
      if (localObject1 == null)
      {
        localObject1 = LOG_TAG;
        localObject2 = "Cannot refresh account model, getActivity() returned null.";
        Logging.w((String)localObject1, (String)localObject2);
      }
      else
      {
        localObject1 = getActivity();
        localObject2 = new com/paypal/android/p2pmobile/fragment/wallet/AddMoneyFragment$1;
        ((AddMoneyFragment.1)localObject2).<init>(this);
        PayPalApp.refreshAccountModel((Activity)localObject1, (OperationListener)localObject2);
      }
    }
  }

  private void getFundingOptions()
  {
    String str2 = null;
    Object localObject1 = LOG_TAG;
    String str1 = "getFundingOptions";
    Logging.d((String)localObject1, str1);
    localObject1 = AddMoneyFragment.State.GET_FUNDING_SOURCES;
    this.state = ((AddMoneyFragment.State)localObject1);
    localObject1 = AddMoneyFragment.DialogType.PleaseWait;
    int i = 2131493401;
    Object localObject2 = getString(i);
    showDialog((AddMoneyFragment.DialogType)localObject1, str2, (String)localObject2);
    localObject1 = this.mDataLayer;
    localObject2 = this.mDataLayer;
    long l = ((AddMoneyFragment.MyDataLayer)localObject2).doGMGetAddFundsOptionsReq(str2);
    ((AddMoneyFragment.MyDataLayer)localObject1).track(l);
  }

  public Activity getHostActivity()
  {
    FragmentActivity localFragmentActivity = getActivity();
    return localFragmentActivity;
  }

  private AddMoneyFragment.OnAddMoneyFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (AddMoneyFragment.OnAddMoneyFragmentListener)localObject;
    return localObject;
  }

  public static AddMoneyFragment newInstance()
  {
    AddMoneyFragment localAddMoneyFragment = new com/paypal/android/p2pmobile/fragment/wallet/AddMoneyFragment;
    localAddMoneyFragment.<init>();
    return localAddMoneyFragment;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    showView();
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default:
    case 51:
    }
    while (true)
    {
      return;
      int i = -1;
      Handler localHandler;
      Object localObject;
      if (paramInt2 == i)
      {
        localHandler = new android/os/Handler;
        localHandler.<init>();
        localObject = new com/paypal/android/p2pmobile/fragment/wallet/AddMoneyFragment$2;
        ((AddMoneyFragment.2)localObject).<init>(this);
        localHandler.post((Runnable)localObject);
      }
      else if (paramInt2 == 0)
      {
        localHandler = new android/os/Handler;
        localHandler.<init>();
        localObject = new com/paypal/android/p2pmobile/fragment/wallet/AddMoneyFragment$3;
        ((AddMoneyFragment.3)localObject).<init>(this);
        long l = 500L;
        localHandler.postDelayed((Runnable)localObject, l);
      }
    }
  }

  public void onCancel(DialogFragment paramDialogFragment)
  {
    Object localObject = getActivity();
    localObject = ((FragmentActivity)localObject).getSupportFragmentManager();
    ((FragmentManager)localObject).popBackStackImmediate();
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    switch (i)
    {
    default:
      localObject = LOG_TAG;
      String str1 = "View id we are not using";
      Logging.d((String)localObject, str1);
    case 2131427637:
    }
    while (true)
    {
      return;
      localObject = getHostActivity();
      InputUtils.hideSoftInputFromWindow((Activity)localObject, paramView);
      localObject = this.mMoneyEditor;
      boolean bool = false;
      ((MoneySpecEditor)localObject).setEditable(bool);
      localObject = this.mMoneyEditor;
      if (localObject != null)
      {
        localObject = this.mMoneyEditor;
        MutableMoneyValue localMutableMoneyValue = ((MoneySpecEditor)localObject).getAmount();
        updateAddFundsSource(localMutableMoneyValue);
      }
      try
      {
        analyzeAddFunds();
      }
      catch (InvalidArgumentException localInvalidArgumentException)
      {
        localObject = LOG_TAG;
        String str2 = "Invalid argument trying to analyzeAddFunds()";
        Logging.e((String)localObject, str2);
      }
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AddMoneyFragment.MyDataLayer localMyDataLayer = new com/paypal/android/p2pmobile/fragment/wallet/AddMoneyFragment$MyDataLayer;
    localMyDataLayer.<init>(this, this);
    this.mDataLayer = localMyDataLayer;
    localMyDataLayer = this.mDataLayer;
    String str = "mDataLayer";
    localMyDataLayer.onCreate(str, paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool2 = true;
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    int i = 2130903088;
    Object localObject2 = null;
    Object localObject1 = paramLayoutInflater.inflate(i, (ViewGroup)localObject2);
    this.mRootView = ((View)localObject1);
    localObject1 = TrackPage.Point.AddFundsStart;
    PayPalApp.logPageView((TrackPage.Point)localObject1);
    renderBalanceHeader();
    localObject2 = new com/paypal/android/p2pmobile/common/FundingSourceSelector;
    localObject1 = this.mRootView;
    int j = 2131427639;
    localObject1 = ((View)localObject1).findViewById(j);
    localObject1 = (ViewGroup)localObject1;
    j = 2131493413;
    ((FundingSourceSelector)localObject2).<init>(this, (ViewGroup)localObject1, bool2, j);
    this.bankSelector = ((FundingSourceSelector)localObject2);
    localObject2 = new com/paypal/android/p2pmobile/common/MoneySpecEditor;
    localObject1 = this.mRootView;
    j = 2131427640;
    localObject1 = ((View)localObject1).findViewById(j);
    localObject1 = (ViewGroup)localObject1;
    MoneySpecEditor.Mode localMode = MoneySpecEditor.Mode.Entry;
    ((MoneySpecEditor)localObject2).<init>(this, (ViewGroup)localObject1, bool2, localMode);
    this.mMoneyEditor = ((MoneySpecEditor)localObject2);
    localObject1 = this.mMoneyEditor;
    ((MoneySpecEditor)localObject1).hideElements();
    if (paramBundle != null)
      onRestoreInstanceState(paramBundle);
    boolean bool1 = canAddFunds();
    updateAddFundsClickable(bool1);
    View localView = this.mRootView;
    return localView;
  }

  public void onDismiss(DialogFragment paramDialogFragment)
  {
    boolean bool = this.finishAfterDialog;
    if (bool)
    {
      Object localObject = getActivity();
      localObject = ((FragmentActivity)localObject).getSupportFragmentManager();
      ((FragmentManager)localObject).popBackStackImmediate();
    }
  }

  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    return bool;
  }

  public void onFieldChanged(FieldEditor paramFieldEditor)
  {
    MoneySpecEditor localMoneySpecEditor = this.mMoneyEditor;
    if (localMoneySpecEditor == null);
    while (true)
    {
      return;
      localMoneySpecEditor = this.mMoneyEditor;
      MutableMoneyValue localMutableMoneyValue = localMoneySpecEditor.getAmount();
      updateAddFundsSource(localMutableMoneyValue);
      boolean bool = canAddFunds();
      updateAddFundsClickable(bool);
    }
  }

  public void onFieldSelected(FieldEditor paramFieldEditor)
  {
  }

  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.addFundsSource;
    String str = ((AbstractFundingSourceObject)localObject).getAmount();
    localObject = this.addFundsSources;
    localObject = ((ArrayList)localObject).get(paramInt);
    localObject = (AbstractFundingSourceObject)localObject;
    this.addFundsSource = ((AbstractFundingSourceObject)localObject);
    this.mSelectedPosition = paramInt;
    localObject = this.addFundsSource;
    ((AbstractFundingSourceObject)localObject).setAmount(str);
  }

  private void onLoginSuccess(LoginMetaRequest paramLoginMetaRequest)
  {
    Object localObject1 = AddMoneyFragment.DialogType.PleaseWait;
    dismissDialog((AddMoneyFragment.DialogType)localObject1);
    localObject1 = LOG_TAG;
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    Object localObject3 = "onLoginSuccess, m_failed_request: ";
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
    localObject3 = this.mFailedRequest;
    localObject2 = ((StringBuilder)localObject2).append(localObject3);
    localObject2 = ((StringBuilder)localObject2).toString();
    Logging.d((String)localObject1, (String)localObject2);
    if (paramLoginMetaRequest != null)
    {
      if (paramLoginMetaRequest != null)
      {
        boolean bool = paramLoginMetaRequest.isSuccess();
        if (!bool);
      }
    }
    else
    {
      int[] arrayOfInt = AddMoneyFragment.4.$SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddMoneyFragment$State;
      localObject2 = this.state;
      int j = ((AddMoneyFragment.State)localObject2).ordinal();
      int i = arrayOfInt[j];
      switch (i)
      {
      case 1:
      default:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      return;
      getCIPStatus();
      continue;
      getFundingOptions();
    }
  }

  public void onNegativeClick(PPDialogFragment paramPPDialogFragment)
  {
    boolean bool = paramPPDialogFragment instanceof AccountActivitySuccessDialog;
    if (bool)
    {
      reset();
      paramPPDialogFragment.dismiss();
    }
    while (true)
    {
      return;
      bool = this.finishAfterDialog;
      if (bool)
      {
        Object localObject = getListener();
        localObject = (AddMoneyFragment.OnAddMoneyFragmentListener)localObject;
        ((AddMoneyFragment.OnAddMoneyFragmentListener)localObject).onAddMoneyFinish();
      }
    }
  }

  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool3 = true;
    boolean bool1 = super.onOptionsItemSelected(paramMenuItem);
    if (bool1);
    while (true)
    {
      return bool3;
      Object localObject = this.mMoneyEditor;
      ((MoneySpecEditor)localObject).clear();
      localObject = LOG_TAG;
      String str = "onOptionsItemSelected setting button to false";
      Logging.d((String)localObject, str);
      boolean bool2 = false;
      updateAddFundsClickable(bool2);
    }
  }

  public void onPositiveClick(PPDialogFragment paramPPDialogFragment)
  {
    boolean bool1 = this.finishAfterDialog;
    if (bool1)
    {
      Object localObject1 = getListener();
      localObject1 = (AddMoneyFragment.OnAddMoneyFragmentListener)localObject1;
      ((AddMoneyFragment.OnAddMoneyFragmentListener)localObject1).onAddMoneyFinish();
    }
    while (true)
    {
      return;
      boolean bool2 = paramPPDialogFragment instanceof MessageDialog;
      if (bool2)
      {
        String str2 = paramPPDialogFragment.getInstanceTag();
        boolean bool3 = TextUtils.isEmpty(str2);
        if (!bool3)
        {
          String str1 = paramPPDialogFragment.getInstanceTag();
          Object localObject2 = AddMoneyFragment.DialogType.CIPError;
          localObject2 = ((AddMoneyFragment.DialogType)localObject2).toString();
          boolean bool4 = str1.equals(localObject2);
          Object localObject3;
          if (bool4)
          {
            localObject3 = getListener();
            localObject3 = (AddMoneyFragment.OnAddMoneyFragmentListener)localObject3;
            ((AddMoneyFragment.OnAddMoneyFragmentListener)localObject3).onAddMoneyFinish();
          }
          else
          {
            localObject3 = AddMoneyFragment.DialogType.CIPVerification;
            localObject3 = ((AddMoneyFragment.DialogType)localObject3).toString();
            boolean bool5 = str1.equals(localObject3);
            if (bool5)
            {
              Intent localIntent = new android/content/Intent;
              FragmentActivity localFragmentActivity = getActivity();
              CIPVerifyActivity localCIPVerifyActivity = CIPVerifyActivity.class;
              localIntent.<init>(localFragmentActivity, localCIPVerifyActivity);
              int i = 51;
              startActivityForResult(localIntent, i);
            }
          }
        }
      }
    }
  }

  private void onRestoreInstanceState(Bundle paramBundle)
  {
    if (paramBundle == null);
    while (true)
    {
      return;
      Object localObject2 = LOG_TAG;
      String str2 = "restoring app state";
      Logging.d((String)localObject2, str2);
      localObject2 = "addFundsSource";
      localObject2 = paramBundle.getParcelable((String)localObject2);
      localObject2 = (AbstractFundingSourceObject)localObject2;
      this.addFundsSource = ((AbstractFundingSourceObject)localObject2);
      localObject2 = "addFundsSources";
      localObject2 = paramBundle.getParcelableArrayList((String)localObject2);
      this.addFundsSources = ((ArrayList)localObject2);
      localObject2 = "selectedPosition";
      int i = paramBundle.getInt((String)localObject2);
      this.mSelectedPosition = i;
      String str1 = "successMessage";
      str1 = paramBundle.getString(str1);
      this.successMessage = str1;
      str1 = "title";
      str1 = paramBundle.getString(str1);
      this.title = str1;
      str1 = "cipOk";
      boolean bool1 = paramBundle.getBoolean(str1);
      this.cipStatusOk = bool1;
      Object localObject3 = AddMoneyFragment.State.values();
      str2 = "state";
      int j = paramBundle.getInt(str2);
      localObject3 = localObject3[j];
      this.state = ((AddMoneyFragment.State)localObject3);
      localObject3 = "finishAfterDialog";
      boolean bool2 = paramBundle.getBoolean((String)localObject3);
      this.finishAfterDialog = bool2;
      Object localObject4 = this.addFundsSources;
      if (localObject4 != null)
      {
        localObject4 = LOG_TAG;
        localObject5 = new java/lang/StringBuilder;
        ((StringBuilder)localObject5).<init>();
        Object localObject6 = "fslist size ";
        localObject5 = ((StringBuilder)localObject5).append((String)localObject6);
        localObject6 = this.addFundsSources;
        int k = ((ArrayList)localObject6).size();
        localObject5 = ((StringBuilder)localObject5).append(k);
        localObject5 = ((StringBuilder)localObject5).toString();
        Logging.d((String)localObject4, (String)localObject5);
        setupAccountTab();
      }
      localObject4 = "addFundsAmount";
      Object localObject1 = paramBundle.getParcelable((String)localObject4);
      localObject1 = (MutableMoneyValue)localObject1;
      if (localObject1 != null)
      {
        localObject4 = this.mMoneyEditor;
        ((MoneySpecEditor)localObject4).setAmount((MutableMoneyValue)localObject1);
        updateAddFundsSource((MutableMoneyValue)localObject1);
      }
      localObject4 = LOG_TAG;
      Object localObject5 = new java/lang/StringBuilder;
      ((StringBuilder)localObject5).<init>();
      String str3 = "Restoring button ";
      localObject5 = ((StringBuilder)localObject5).append(str3);
      boolean bool4 = canAddFunds();
      localObject5 = ((StringBuilder)localObject5).append(bool4);
      localObject5 = ((StringBuilder)localObject5).toString();
      Logging.d((String)localObject4, (String)localObject5);
      boolean bool3 = canAddFunds();
      updateAddFundsClickable(bool3);
    }
  }

  public void onResume()
  {
    super.onResume();
    renderBalanceHeader();
    Object localObject = this.mMoneyEditor;
    ((MoneySpecEditor)localObject).format();
    localObject = AddMoneyFragment.DialogType.PleaseWait;
    dismissDialog((AddMoneyFragment.DialogType)localObject);
    getFundingOptions();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Object localObject1 = this.mDataLayer;
    Object localObject2 = "mDataLayer";
    ((AddMoneyFragment.MyDataLayer)localObject1).onSaveInstanceState((String)localObject2, paramBundle);
    localObject1 = this.mMoneyEditor;
    if (localObject1 != null)
    {
      localObject1 = this.mMoneyEditor;
      MutableMoneyValue localMutableMoneyValue = ((MoneySpecEditor)localObject1).getAmount();
      localObject1 = "addFundsAmount";
      paramBundle.putParcelable((String)localObject1, localMutableMoneyValue);
      updateAddFundsSource(localMutableMoneyValue);
    }
    localObject1 = "addFundsSource";
    localObject2 = this.addFundsSource;
    paramBundle.putParcelable((String)localObject1, (Parcelable)localObject2);
    localObject1 = "addFundsSources";
    localObject2 = this.addFundsSources;
    paramBundle.putParcelableArrayList((String)localObject1, (ArrayList)localObject2);
    localObject1 = "selectedPosition";
    int i = this.mSelectedPosition;
    paramBundle.putInt((String)localObject1, i);
    localObject1 = "successMessage";
    String str = this.successMessage;
    paramBundle.putString((String)localObject1, str);
    localObject1 = "title";
    str = this.title;
    paramBundle.putString((String)localObject1, str);
    localObject1 = "finishAfterDialog";
    boolean bool = this.finishAfterDialog;
    paramBundle.putBoolean((String)localObject1, bool);
    localObject1 = "cipOk";
    bool = this.cipStatusOk;
    paramBundle.putBoolean((String)localObject1, bool);
    localObject1 = "state";
    AddMoneyFragment.State localState = this.state;
    int j = localState.ordinal();
    paramBundle.putInt((String)localObject1, j);
  }

  public void onShowEditable(FieldEditor paramFieldEditor)
  {
  }

  public void onShowNonEditable(FieldEditor paramFieldEditor)
  {
  }

  public void onStart()
  {
    super.onStart();
    AddMoneyFragment.MyDataLayer localMyDataLayer = this.mDataLayer;
    boolean bool = localMyDataLayer.onStart();
    if (!bool)
    {
      Object localObject = getActivity();
      int i = 1;
      ((FragmentActivity)localObject).setResult(i);
      localObject = getLocalListener();
      ((AddMoneyFragment.OnAddMoneyFragmentListener)localObject).onAddMoneyFinish();
    }
  }

  public void onStop()
  {
    super.onStop();
    AddMoneyFragment.MyDataLayer localMyDataLayer = this.mDataLayer;
    localMyDataLayer.onStop();
  }

  private void renderBalanceHeader()
  {
    int i = 2131493552;
    String str1 = getString(i);
    String str2 = getString(i);
    AccountModel localAccountModel = AccountModel.getInstance();
    if (localAccountModel != null)
    {
      AccountBalance localAccountBalance = localAccountModel.getBalance();
      if (localAccountBalance != null)
      {
        localObject = localAccountBalance.getConvertedBalance();
        localObject = ((MoneyBalance)localObject).getAvailable();
        str1 = ((MoneyValue)localObject).getFormattedLong();
        localObject = localAccountBalance.getConvertedBalance();
        localObject = ((MoneyBalance)localObject).getTotal();
        str2 = ((MoneyValue)localObject).getFormattedLong();
      }
    }
    Object localObject = this.mRootView;
    int j = 2131427798;
    UI.setText((View)localObject, j, str1);
    localObject = this.mRootView;
    j = 2131427796;
    UI.setText((View)localObject, j, str2);
  }

  private void reset()
  {
    MoneySpecEditor localMoneySpecEditor = this.mMoneyEditor;
    localMoneySpecEditor.clear();
    getFundingOptions();
  }

  protected void setupAccountTab()
  {
    int k = 1;
    Object localObject1 = this.addFundsSources;
    int m = this.mSelectedPosition;
    localObject1 = ((ArrayList)localObject1).get(m);
    localObject1 = (AbstractFundingSourceObject)localObject1;
    this.addFundsSource = ((AbstractFundingSourceObject)localObject1);
    localObject1 = this.bankSelector;
    Object localObject2 = new com/paypal/android/p2pmobile/common/AccountSpinnerAdapter;
    Activity localActivity = getHostActivity();
    ArrayList localArrayList = this.addFundsSources;
    ((AccountSpinnerAdapter)localObject2).<init>(localActivity, localArrayList);
    ((FundingSourceSelector)localObject1).setAdapter((SpinnerAdapter)localObject2);
    localObject2 = this.bankSelector;
    localObject1 = this.addFundsSources;
    int i = ((ArrayList)localObject1).size();
    if (i > k);
    int j;
    for (i = k; ; j = 0)
    {
      ((FundingSourceSelector)localObject2).setEnabled(i);
      FundingSourceSelector localFundingSourceSelector = this.bankSelector;
      localFundingSourceSelector.setOnItemSelectedListener(this);
      localFundingSourceSelector = this.bankSelector;
      k = this.mSelectedPosition;
      localFundingSourceSelector.setSpinnerSelection(k);
      return;
    }
  }

  private void showDialog(AddMoneyFragment.DialogType paramDialogType, int paramInt1, int paramInt2)
  {
    String str1 = getString(paramInt1);
    String str2 = getString(paramInt2);
    showDialog(paramDialogType, str1, str2);
  }

  private void showDialog(AddMoneyFragment.DialogType paramDialogType, String paramString1, String paramString2)
  {
    int n = 0;
    Object localObject2 = LOG_TAG;
    String str2 = "showDialog";
    Logging.d((String)localObject2, str2);
    localObject2 = getFragmentManager();
    str2 = "Dialog";
    Fragment localFragment = ((FragmentManager)localObject2).findFragmentByTag(str2);
    if (localFragment != null)
    {
      localObject2 = getFragmentManager();
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject2).beginTransaction();
      localFragmentTransaction.remove(localFragment);
      localFragmentTransaction.commit();
    }
    int i = 0;
    localObject2 = AddMoneyFragment.4.$SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddMoneyFragment$DialogType;
    int m = paramDialogType.ordinal();
    int j = localObject2[m];
    Object localObject4;
    Object localObject5;
    switch (j)
    {
    default:
      String str1 = LOG_TAG;
      localObject4 = new java/lang/StringBuilder;
      ((StringBuilder)localObject4).<init>();
      localObject5 = "Unknown dialog ";
      localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
      localObject5 = paramDialogType.toString();
      localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
      localObject4 = ((StringBuilder)localObject4).toString();
      Logging.e(str1, (String)localObject4);
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return;
      int k = 2131493401;
      localObject4 = AddMoneyFragment.class;
      localObject4 = ((Class)localObject4).getName();
      Object localObject1 = WaitDialog.newInstance(k, (String)localObject4);
      if (localObject1 != null)
      {
        Object localObject3 = getFragmentManager();
        localObject4 = "Dialog";
        ((DialogFragment)localObject1).show((FragmentManager)localObject3, (String)localObject4);
        localObject3 = LOG_TAG;
        localObject4 = "showing Please Wait";
        Logging.d((String)localObject3, (String)localObject4);
        continue;
        localObject3 = AddMoneyFragment.class;
        localObject3 = ((Class)localObject3).getName();
        localObject1 = MessageDialog.newInstance(paramString2, (String)localObject3);
        if (localObject1 != null)
        {
          localObject3 = getFragmentManager();
          localObject4 = "Dialog";
          ((DialogFragment)localObject1).show((FragmentManager)localObject3, (String)localObject4);
          continue;
          localObject3 = TrackPage.Point.AddFundsDone;
          PayPalApp.logPageView((TrackPage.Point)localObject3);
          localObject3 = AddMoneyFragment.class;
          localObject3 = ((Class)localObject3).getName();
          localObject3 = AccountActivitySuccessDialog.newInstance(paramString1, paramString2, (String)localObject3);
          localObject4 = getFragmentManager();
          localObject5 = AccountActivitySuccessDialog.class;
          localObject5 = ((Class)localObject5).getName();
          ((AccountActivitySuccessDialog)localObject3).show((FragmentManager)localObject4, (String)localObject5);
          continue;
          localObject3 = AddMoneyFragment.class;
          localObject3 = ((Class)localObject3).getName();
          localObject4 = AddMoneyFragment.DialogType.CIPVerification;
          localObject4 = ((AddMoneyFragment.DialogType)localObject4).toString();
          localObject1 = MessageDialog.newInstance(paramString1, paramString2, localObject5, (String)localObject3, (String)localObject4);
          localObject3 = getFragmentManager();
          localObject4 = "Dialog";
          ((DialogFragment)localObject1).show((FragmentManager)localObject3, (String)localObject4);
          continue;
          localObject3 = AddMoneyFragment.class;
          localObject3 = ((Class)localObject3).getName();
          localObject4 = AddMoneyFragment.DialogType.CIPError;
          localObject4 = ((AddMoneyFragment.DialogType)localObject4).toString();
          localObject1 = MessageDialog.newInstance(paramString2, localObject5, (String)localObject3, (String)localObject4);
          localObject3 = getFragmentManager();
          localObject4 = "Dialog";
          ((DialogFragment)localObject1).show((FragmentManager)localObject3, (String)localObject4);
        }
      }
    }
  }

  private void showErrorView(ServerRequest2 paramServerRequest2)
  {
    int j = 2131493767;
    ErrorBase localErrorBase = paramServerRequest2.getLastError();
    Object localObject3;
    Object localObject1;
    if (localErrorBase != null)
    {
      String str2 = localErrorBase.getErrorCode();
      String str4 = LOG_TAG;
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>();
      String str6 = "last error ";
      localObject3 = ((StringBuilder)localObject3).append(str6);
      str6 = localErrorBase.getLongMessage();
      localObject3 = ((StringBuilder)localObject3).append(str6);
      str6 = " Error code: ";
      localObject3 = ((StringBuilder)localObject3).append(str6);
      str6 = localErrorBase.getErrorCode();
      localObject3 = ((StringBuilder)localObject3).append(str6);
      localObject3 = ((StringBuilder)localObject3).toString();
      Logging.d(str4, (String)localObject3);
      boolean bool1 = TextUtils.isEmpty(str2);
      if (!bool1)
      {
        String str5 = "01011";
        boolean bool2 = str2.equals(str5);
        if (bool2)
        {
          PayPalFeedbackManager localPayPalFeedbackManager = new com/paypal/android/p2pmobile/tracking/PayPalFeedbackManager;
          localObject1 = getHostActivity();
          localPayPalFeedbackManager.<init>((Activity)localObject1);
          localObject1 = PayPalFeedbackManager.PointSystemError.AddMoneyError;
          localPayPalFeedbackManager.registerError((PayPalFeedbackManager.PointSystemError)localObject1);
        }
      }
    }
    String str1 = MiscUtils.mapToLocalizedError(localErrorBase);
    if (str1 != null)
    {
      localObject1 = AddMoneyFragment.DialogType.Error;
      localObject3 = getString(j);
      showDialog((AddMoneyFragment.DialogType)localObject1, (String)localObject3, str1);
      localObject1 = TrackPage.Point.AddFundsStart;
      PayPalApp.logError((TrackPage.Point)localObject1, localErrorBase, str1);
    }
    while (true)
    {
      return;
      int i = 2131493769;
      String str3 = getString(i);
      Object localObject2 = TrackPage.Point.AddFundsStart;
      PayPalApp.logError((TrackPage.Point)localObject2, localErrorBase, str3);
      localObject2 = AddMoneyFragment.DialogType.Error;
      localObject3 = getString(j);
      showDialog((AddMoneyFragment.DialogType)localObject2, (String)localObject3, str3);
    }
  }

  private void showSuccessView()
  {
    Object localObject1 = LOG_TAG;
    Object localObject3 = "show success view for add money";
    Logging.d((String)localObject1, (String)localObject3);
    localObject1 = this.addFundsSource;
    localObject1 = ((AbstractFundingSourceObject)localObject1).getAmount();
    String str1;
    if (localObject1 != null)
    {
      localObject1 = this.addFundsSource;
      str1 = ((AbstractFundingSourceObject)localObject1).getAmount();
    }
    while (true)
    {
      boolean bool1 = false;
      boolean bool2 = PayPalApp.haveUser();
      label71: label80: Object localObject2;
      if (bool2)
      {
        PayPalUser localPayPalUser = PayPalApp.getCurrentUser();
        bool1 = localPayPalUser.isInCommercialCountry();
        if (!bool1)
          break label469;
        int i = 2131493400;
        String str2 = getString(i);
        this.successMessage = str2;
        if (!bool1)
          break label477;
        int j = 2131493406;
        localObject2 = getString(j);
        this.title = ((String)localObject2);
        localObject2 = LOG_TAG;
        localObject3 = this.successMessage;
        Logging.d((String)localObject2, (String)localObject3);
      }
      try
      {
        localObject2 = this.successMessage;
        localObject3 = "%1";
        Object localObject4 = this.addFundsSource;
        localObject4 = ((AbstractFundingSourceObject)localObject4).getCurrency();
        localObject4 = ((Currency)localObject4).getCurrencyCode();
        localObject4 = CurrencyUtil.formatAmountWithCurrencySymbolAndCurrencyCode(str1, (String)localObject4);
        localObject2 = ((String)localObject2).replace((CharSequence)localObject3, (CharSequence)localObject4);
        this.successMessage = ((String)localObject2);
        localObject2 = this.successMessage;
        localObject3 = "%2";
        localObject4 = this.addFundsSource;
        localObject4 = ((AbstractFundingSourceObject)localObject4).toString();
        localObject2 = ((String)localObject2).replace((CharSequence)localObject3, (CharSequence)localObject4);
        this.successMessage = ((String)localObject2);
        localObject2 = LOG_TAG;
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        localObject4 = this.addFundsSource;
        localObject4 = ((AbstractFundingSourceObject)localObject4).getmID();
        localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
        localObject4 = ":";
        localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
        localObject4 = this.addFundsSource;
        localObject4 = ((AbstractFundingSourceObject)localObject4).getDisplayID();
        localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
        localObject4 = ":";
        localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
        localObject4 = this.addFundsSource;
        localObject4 = ((AbstractFundingSourceObject)localObject4).getSubType();
        localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
        localObject4 = ":";
        localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
        localObject4 = this.addFundsSource;
        localObject4 = ((AbstractFundingSourceObject)localObject4).getMethod();
        localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
        localObject3 = ((StringBuilder)localObject3).toString();
        Logging.d((String)localObject2, (String)localObject3);
        localObject2 = AddMoneyFragment.DialogType.Success;
        localObject3 = this.title;
        localObject4 = this.successMessage;
        showDialog((AddMoneyFragment.DialogType)localObject2, (String)localObject3, (String)localObject4);
        localObject2 = this.mMoneyEditor;
        ((MoneySpecEditor)localObject2).clear();
        localObject2 = getActivity();
        localObject3 = AdConversionManager.Event.WALLET_ADD_BALANCE;
        AdConversionManager.track((Context)localObject2, (AdConversionManager.Event)localObject3);
        return;
        str1 = "";
        continue;
        localObject2 = LOG_TAG;
        localObject3 = "showSuccessView: no user";
        Logging.d((String)localObject2, (String)localObject3);
        break label71;
        label469: int k = 2131493399;
        break label80;
        label477: k = 2131493405;
      }
      catch (Exception localException)
      {
        while (true)
        {
          String str3 = this.successMessage;
          localObject3 = "%1";
          str3 = str3.replace((CharSequence)localObject3, str1);
          this.successMessage = str3;
        }
      }
    }
  }

  private void showView()
  {
    String str1 = LOG_TAG;
    Object localObject = new java/lang/StringBuilder;
    ((StringBuilder)localObject).<init>();
    String str2 = "currentState: ";
    localObject = ((StringBuilder)localObject).append(str2);
    boolean bool3 = this.successState;
    localObject = ((StringBuilder)localObject).append(bool3);
    localObject = ((StringBuilder)localObject).toString();
    Logging.d(str1, (String)localObject);
    boolean bool1 = this.successState;
    if (!bool1)
    {
      View localView = this.mRootView;
      int i = 2131427638;
      localView = localView.findViewById(i);
      i = 0;
      localView.setVisibility(i);
      boolean bool2 = canAddFunds();
      updateAddFundsClickable(bool2);
      MoneySpecEditor localMoneySpecEditor = this.mMoneyEditor;
      localMoneySpecEditor.clear();
    }
    while (true)
    {
      return;
      showSuccessView();
    }
  }

  private void updateAddFundsClickable(boolean paramBoolean)
  {
    View localView = this.mRootView;
    int i = 2131427637;
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

  private void updateAddFundsSource(MutableMoneyValue paramMutableMoneyValue)
  {
    AbstractFundingSourceObject localAbstractFundingSourceObject = this.addFundsSource;
    Object localObject1;
    Object localObject2;
    if (localAbstractFundingSourceObject != null)
    {
      boolean bool = paramMutableMoneyValue.isPositive();
      if (bool)
      {
        localObject1 = this.addFundsSource;
        localObject2 = LegacyConversionUtils.getAmountString(paramMutableMoneyValue);
        ((AbstractFundingSourceObject)localObject1).setAmount((String)localObject2);
        localObject1 = this.addFundsSource;
        localObject2 = paramMutableMoneyValue.getCurrencyCode();
        localObject2 = Currency.getInstance((String)localObject2);
        ((AbstractFundingSourceObject)localObject1).setCurrency((Currency)localObject2);
      }
    }
    while (true)
    {
      return;
      localObject1 = this.addFundsSource;
      localObject2 = "";
      ((AbstractFundingSourceObject)localObject1).setAmount((String)localObject2);
      break;
      localObject1 = LOG_TAG;
      localObject2 = "addFundsSource is null???";
      Logging.d((String)localObject1, (String)localObject2);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddMoneyFragment
 * JD-Core Version:    0.6.2
 */
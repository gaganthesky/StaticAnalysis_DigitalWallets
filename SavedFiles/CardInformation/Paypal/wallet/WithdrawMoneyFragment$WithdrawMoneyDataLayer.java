package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Context;
import android.support.v4.app.Fragment;
import com.paypal.android.base.common.Country;
import com.paypal.android.base.common.MoneySpec;
import com.paypal.android.base.common.WithdrawObject;
import com.paypal.android.base.server.gmapi.GMAnalyzeWithdrawReq2;
import com.paypal.android.base.server.gmapi.GMGetWithdrawOptionsReq2;
import com.paypal.android.base.server.gmapi.GMWithdrawReq2;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.base.server_request.ErrorBase;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.common.DataLayer;
import com.paypal.android.p2pmobile.common.MoneySpecEditor;
import com.paypal.android.p2pmobile.common.PayPalUser;
import com.paypal.android.p2pmobile.common.PerCountryData;
import com.paypal.android.p2pmobile.tracking.AdConversionManager;
import com.paypal.android.p2pmobile.tracking.AdConversionManager.Event;
import com.paypal.android.p2pmobile.utils.MiscUtils;
import java.util.List;

class WithdrawMoneyFragment$WithdrawMoneyDataLayer extends DataLayer
{
  final WithdrawMoneyFragment this$0;

  public WithdrawMoneyFragment$WithdrawMoneyDataLayer(WithdrawMoneyFragment paramWithdrawMoneyFragment, Fragment paramFragment)
  {
    super(paramFragment);
  }

  public void onRequestError(GMAnalyzeWithdrawReq2 paramGMAnalyzeWithdrawReq2)
  {
    stopTracking(paramGMAnalyzeWithdrawReq2);
    WithdrawMoneyFragment localWithdrawMoneyFragment = this.this$0;
    Object localObject = WithdrawMoneyFragment.DialogType.PleaseWait;
    WithdrawMoneyFragment.access$300(localWithdrawMoneyFragment, (WithdrawMoneyFragment.DialogType)localObject);
    localWithdrawMoneyFragment = this.this$0;
    localObject = paramGMAnalyzeWithdrawReq2.getLastError();
    WithdrawMoneyFragment.access$902(localWithdrawMoneyFragment, (ErrorBase)localObject);
    localWithdrawMoneyFragment = this.this$0;
    WithdrawMoneyFragment.access$1400(localWithdrawMoneyFragment, paramGMAnalyzeWithdrawReq2);
  }

  public void onRequestError(GMGetWithdrawOptionsReq2 paramGMGetWithdrawOptionsReq2)
  {
    stopTracking(paramGMGetWithdrawOptionsReq2);
    Object localObject1 = this.this$0;
    Object localObject3 = WithdrawMoneyFragment.DialogType.PleaseWait;
    WithdrawMoneyFragment.access$300((WithdrawMoneyFragment)localObject1, (WithdrawMoneyFragment.DialogType)localObject3);
    localObject1 = this.this$0;
    localObject3 = paramGMGetWithdrawOptionsReq2.getLastError();
    WithdrawMoneyFragment.access$902((WithdrawMoneyFragment)localObject1, (ErrorBase)localObject3);
    localObject1 = this.this$0;
    boolean bool3 = true;
    WithdrawMoneyFragment.access$1002((WithdrawMoneyFragment)localObject1, bool3);
    localObject1 = this.this$0;
    localObject1 = WithdrawMoneyFragment.access$900((WithdrawMoneyFragment)localObject1);
    localObject1 = ((ErrorBase)localObject1).getErrorCode();
    String str2 = "10876";
    boolean bool1 = ((String)localObject1).equals(str2);
    Object localObject2;
    Object localObject4;
    if (bool1)
    {
      localObject2 = this.this$0;
      int i = 2131493424;
      String str1 = ((WithdrawMoneyFragment)localObject2).getString(i);
      localObject2 = this.this$0;
      localObject4 = WithdrawMoneyFragment.DialogType.Error;
      Object localObject5 = this.this$0;
      int j = 2131493767;
      localObject5 = ((WithdrawMoneyFragment)localObject5).getString(j);
      WithdrawMoneyFragment.access$1100((WithdrawMoneyFragment)localObject2, (WithdrawMoneyFragment.DialogType)localObject4, (String)localObject5, str1);
      localObject2 = TrackPage.Point.WithdrawStart;
      localObject4 = this.this$0;
      localObject4 = WithdrawMoneyFragment.access$900((WithdrawMoneyFragment)localObject4);
      PayPalApp.logError((TrackPage.Point)localObject2, (ErrorBase)localObject4, str1);
    }
    while (true)
    {
      return;
      localObject2 = "10818";
      boolean bool2 = MiscUtils.hasErrorWithCode((String)localObject2, paramGMGetWithdrawOptionsReq2);
      if (!bool2)
      {
        WithdrawMoneyFragment localWithdrawMoneyFragment = this.this$0;
        WithdrawMoneyFragment.access$1200(localWithdrawMoneyFragment);
        localWithdrawMoneyFragment = this.this$0;
        localObject4 = WithdrawMoneyFragment.State.IDLE;
        WithdrawMoneyFragment.access$402(localWithdrawMoneyFragment, (WithdrawMoneyFragment.State)localObject4);
      }
    }
  }

  public void onRequestError(GMWithdrawReq2 paramGMWithdrawReq2)
  {
    stopTracking(paramGMWithdrawReq2);
    Object localObject1 = this.this$0;
    Object localObject2 = WithdrawMoneyFragment.DialogType.PleaseWait;
    WithdrawMoneyFragment.access$300((WithdrawMoneyFragment)localObject1, (WithdrawMoneyFragment.DialogType)localObject2);
    localObject1 = this.this$0;
    localObject2 = paramGMWithdrawReq2.getLastError();
    WithdrawMoneyFragment.access$902((WithdrawMoneyFragment)localObject1, (ErrorBase)localObject2);
    localObject1 = this.this$0;
    boolean bool2 = false;
    WithdrawMoneyFragment.access$1002((WithdrawMoneyFragment)localObject1, bool2);
    localObject1 = "10818";
    boolean bool1 = MiscUtils.hasErrorWithCode((String)localObject1, paramGMWithdrawReq2);
    if (!bool1)
    {
      WithdrawMoneyFragment localWithdrawMoneyFragment = this.this$0;
      WithdrawMoneyFragment.access$1200(localWithdrawMoneyFragment);
      localWithdrawMoneyFragment = this.this$0;
      WithdrawMoneyFragment.State localState = WithdrawMoneyFragment.State.IDLE;
      WithdrawMoneyFragment.access$402(localWithdrawMoneyFragment, localState);
    }
  }

  public void onRequestOK(GMAnalyzeWithdrawReq2 paramGMAnalyzeWithdrawReq2)
  {
    stopTracking(paramGMAnalyzeWithdrawReq2);
    WithdrawMoneyFragment localWithdrawMoneyFragment = this.this$0;
    Object localObject = WithdrawMoneyFragment.DialogType.PleaseWait;
    WithdrawMoneyFragment.access$300(localWithdrawMoneyFragment, (WithdrawMoneyFragment.DialogType)localObject);
    localWithdrawMoneyFragment = this.this$0;
    localObject = WithdrawMoneyFragment.State.IDLE;
    WithdrawMoneyFragment.access$402(localWithdrawMoneyFragment, (WithdrawMoneyFragment.State)localObject);
    localWithdrawMoneyFragment = this.this$0;
    localObject = paramGMAnalyzeWithdrawReq2.getWithdrawObject();
    WithdrawMoneyFragment.access$502(localWithdrawMoneyFragment, (WithdrawObject)localObject);
    localWithdrawMoneyFragment = this.this$0;
    localObject = this.this$0;
    localObject = WithdrawMoneyFragment.access$500((WithdrawMoneyFragment)localObject);
    WithdrawMoneyFragment.access$1300(localWithdrawMoneyFragment, (WithdrawObject)localObject);
  }

  public void onRequestOK(GMGetWithdrawOptionsReq2 paramGMGetWithdrawOptionsReq2)
  {
    stopTracking(paramGMGetWithdrawOptionsReq2);
    Object localObject1 = this.this$0;
    Object localObject2 = WithdrawMoneyFragment.DialogType.PleaseWait;
    WithdrawMoneyFragment.access$300((WithdrawMoneyFragment)localObject1, (WithdrawMoneyFragment.DialogType)localObject2);
    localObject1 = this.this$0;
    localObject2 = WithdrawMoneyFragment.State.IDLE;
    WithdrawMoneyFragment.access$402((WithdrawMoneyFragment)localObject1, (WithdrawMoneyFragment.State)localObject2);
    localObject1 = this.this$0;
    localObject2 = paramGMGetWithdrawOptionsReq2.getWithdrawObject();
    WithdrawMoneyFragment.access$502((WithdrawMoneyFragment)localObject1, (WithdrawObject)localObject2);
    localObject1 = this.this$0;
    boolean bool = false;
    WithdrawMoneyFragment.access$602((WithdrawMoneyFragment)localObject1, bool);
    localObject1 = this.this$0;
    localObject1 = WithdrawMoneyFragment.access$500((WithdrawMoneyFragment)localObject1);
    localObject1 = ((WithdrawObject)localObject1).getWithdrawDestOptions();
    if (localObject1 != null)
    {
      localObject1 = this.this$0;
      localObject1 = WithdrawMoneyFragment.access$500((WithdrawMoneyFragment)localObject1);
      localObject1 = ((WithdrawObject)localObject1).getWithdrawDestOptions();
      int i = ((List)localObject1).size();
      if (i > 0)
      {
        localWithdrawMoneyFragment = this.this$0;
        bool = true;
        WithdrawMoneyFragment.access$602(localWithdrawMoneyFragment, bool);
      }
    }
    WithdrawMoneyFragment localWithdrawMoneyFragment = this.this$0;
    WithdrawMoneyFragment.access$700(localWithdrawMoneyFragment);
    localWithdrawMoneyFragment = this.this$0;
    WithdrawMoneyFragment.access$800(localWithdrawMoneyFragment);
  }

  public void onRequestOK(GMWithdrawReq2 paramGMWithdrawReq2)
  {
    int n = 2131493429;
    int m = 2131493427;
    boolean bool6 = false;
    stopTracking(paramGMWithdrawReq2);
    boolean bool1 = false;
    Object localObject1 = this.this$0;
    Object localObject5 = WithdrawMoneyFragment.State.IDLE;
    WithdrawMoneyFragment.access$402((WithdrawMoneyFragment)localObject1, (WithdrawMoneyFragment.State)localObject5);
    localObject1 = this.this$0;
    localObject5 = WithdrawMoneyFragment.DialogType.PleaseWait;
    WithdrawMoneyFragment.access$300((WithdrawMoneyFragment)localObject1, (WithdrawMoneyFragment.DialogType)localObject5);
    localObject1 = this.this$0;
    localObject1 = WithdrawMoneyFragment.access$500((WithdrawMoneyFragment)localObject1);
    MoneySpec localMoneySpec1 = ((WithdrawObject)localObject1).getPaymentAmount();
    localObject1 = this.this$0;
    localObject1 = WithdrawMoneyFragment.access$500((WithdrawMoneyFragment)localObject1);
    MoneySpec localMoneySpec2 = ((WithdrawObject)localObject1).getFee();
    boolean bool3 = PayPalApp.haveUser();
    PayPalUser localPayPalUser;
    String str3;
    boolean bool2;
    Object localObject6;
    Object localObject7;
    label249: Object localObject3;
    if (bool3)
    {
      localPayPalUser = PayPalApp.getCurrentUser();
      bool1 = localPayPalUser.isInCommercialCountry();
      str1 = "";
      localObject5 = this.this$0;
      if (!bool1)
        break label523;
      int i = 2131493426;
      str3 = ((WithdrawMoneyFragment)localObject5).getString(i);
      String str4 = "GB";
      localObject5 = localPayPalUser.getUserCountry();
      localObject5 = ((Country)localObject5).getCode();
      bool2 = str4.equals(localObject5);
      if (localMoneySpec2 == null)
        break label530;
      boolean bool4 = localMoneySpec2.isZero();
      if (bool4)
        break label530;
      Object localObject2 = this.this$0;
      int k = 2131493428;
      localObject2 = ((WithdrawMoneyFragment)localObject2).getString(k);
      localObject6 = "%1";
      localObject7 = localMoneySpec1.format();
      localObject2 = ((String)localObject2).replace((CharSequence)localObject6, (CharSequence)localObject7);
      localObject6 = "%2";
      localObject7 = localMoneySpec2.format();
      str1 = ((String)localObject2).replace((CharSequence)localObject6, (CharSequence)localObject7);
      if (!bool2)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject2 = ((StringBuilder)localObject2).append(str1);
        localObject6 = " ";
        localObject2 = ((StringBuilder)localObject2).append((String)localObject6);
        str1 = ((StringBuilder)localObject2).toString();
        localObject2 = "HK";
        localObject6 = localPayPalUser.getUserCountry();
        localObject6 = ((Country)localObject6).getCode();
        boolean bool5 = ((String)localObject2).equals(localObject6);
        if (!bool5)
          break label683;
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        localObject3 = ((StringBuilder)localObject3).append(str1);
        localObject6 = this.this$0;
        localObject6 = ((WithdrawMoneyFragment)localObject6).getString(n);
        localObject3 = ((StringBuilder)localObject3).append((String)localObject6);
      }
    }
    label523: label530: Object localObject4;
    for (String str1 = ((StringBuilder)localObject3).toString(); ; str1 = ((StringBuilder)localObject4).toString())
    {
      localObject3 = this.this$0;
      WithdrawMoneyFragment.access$1002((WithdrawMoneyFragment)localObject3, bool6);
      localObject3 = this.this$0;
      localObject6 = WithdrawMoneyFragment.DialogType.Success;
      WithdrawMoneyFragment.access$1100((WithdrawMoneyFragment)localObject3, (WithdrawMoneyFragment.DialogType)localObject6, str3, str1);
      localObject3 = this.this$0;
      localObject3 = WithdrawMoneyFragment.access$000((WithdrawMoneyFragment)localObject3);
      ((WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener)localObject3).refreshAccountModel();
      localObject3 = this.this$0;
      localObject3 = WithdrawMoneyFragment.access$1700((WithdrawMoneyFragment)localObject3);
      ((MoneySpecEditor)localObject3).clear();
      localObject3 = getActivity();
      localObject6 = AdConversionManager.Event.WALLET_WITHDRAW_MONEY_COMPLETE;
      AdConversionManager.track((Context)localObject3, (AdConversionManager.Event)localObject6);
      while (true)
      {
        return;
        localObject3 = WithdrawMoneyFragment.access$1500();
        localObject6 = "No user";
        localObject7 = new Object[bool6];
        ((DebugLogger)localObject3).debug((String)localObject6, (Object[])localObject7);
        localObject3 = this.this$0;
        localObject3 = WithdrawMoneyFragment.access$1600((WithdrawMoneyFragment)localObject3);
        localObject3 = (WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener)localObject3;
        ((WithdrawMoneyFragment.OnWithdrawMoneyFragmentListener)localObject3).onWithdrawMoneyFinish();
      }
      int j = 2131493425;
      break;
      if (bool2)
      {
        localObject4 = this.this$0;
        localObject4 = ((WithdrawMoneyFragment)localObject4).getString(localObject7);
        localObject6 = "%1";
        localObject7 = localMoneySpec1.format();
        localObject4 = ((String)localObject4).replace((CharSequence)localObject6, (CharSequence)localObject7);
        localObject6 = "%2";
        localObject7 = this.this$0;
        localObject7 = WithdrawMoneyFragment.access$500((WithdrawMoneyFragment)localObject7);
        localObject7 = ((WithdrawObject)localObject7).getFundingSourceString();
        str1 = ((String)localObject4).replace((CharSequence)localObject6, (CharSequence)localObject7);
        break label249;
      }
      localObject4 = this.this$0;
      localObject4 = ((WithdrawMoneyFragment)localObject4).getString(localObject7);
      localObject6 = "%1";
      localObject7 = localMoneySpec1.format();
      localObject4 = ((String)localObject4).replace((CharSequence)localObject6, (CharSequence)localObject7);
      localObject6 = "%2";
      localObject7 = this.this$0;
      localObject7 = WithdrawMoneyFragment.access$500((WithdrawMoneyFragment)localObject7);
      localObject7 = ((WithdrawObject)localObject7).getFundingSourceString();
      str1 = ((String)localObject4).replace((CharSequence)localObject6, (CharSequence)localObject7);
      break label249;
      label683: localObject4 = localPayPalUser.getUserCountry();
      String str2 = PerCountryData.getWithdrawProcessRange((Country)localObject4);
      localObject4 = "-";
      localObject6 = "&#8211;";
      str2 = str2.replace((CharSequence)localObject4, (CharSequence)localObject6);
      localObject4 = new java/lang/StringBuilder;
      ((StringBuilder)localObject4).<init>();
      localObject4 = ((StringBuilder)localObject4).append(str1);
      localObject6 = this.this$0;
      localObject6 = ((WithdrawMoneyFragment)localObject6).getString(n);
      localObject7 = "%1";
      localObject6 = ((String)localObject6).replace((CharSequence)localObject7, str2);
      localObject4 = ((StringBuilder)localObject4).append((String)localObject6);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WithdrawMoneyFragment.WithdrawMoneyDataLayer
 * JD-Core Version:    0.6.2
 */
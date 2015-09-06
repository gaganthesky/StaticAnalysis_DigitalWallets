package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.paypal.android.base.Core.APIName;
import com.paypal.android.base.Logging;
import com.paypal.android.base.common.WithdrawObject;
import com.paypal.android.base.metarequest.LoginMetaRequest;
import com.paypal.android.base.server.NetworkUtils;
import com.paypal.android.base.server.cip.CIPGetStatusRequest;
import com.paypal.android.base.server.cip.CIPGetStatusRequest.Status;
import com.paypal.android.base.server.gmapi.GMAddFundsReq;
import com.paypal.android.base.server.gmapi.GMAnalyzeAddFundsReq;
import com.paypal.android.base.server.gmapi.GMGetAddFundsOptionsReq;
import com.paypal.android.base.server.tracking.TrackPage.Link;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.base.server_request.ErrorBase;
import com.paypal.android.base.server_request.ServerRequest2;
import com.paypal.android.foundation.core.model.MutableMoneyValue;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.common.DataLayer;
import com.paypal.android.p2pmobile.common.MoneySpecEditor;
import com.paypal.android.p2pmobile.common.PayPalUser;
import com.paypal.android.p2pmobile.utils.MiscUtils;
import com.paypal.android.p2pmobile.utils.TrackListener;
import com.paypal.android.p2pmobile.utils.WalletDialogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class AddMoneyFragment$MyDataLayer extends DataLayer
{
  final AddMoneyFragment this$0;

  public AddMoneyFragment$MyDataLayer(AddMoneyFragment paramAddMoneyFragment, Fragment paramFragment)
  {
    super(paramFragment);
  }

  public void onGMAddFundsReqError(GMAddFundsReq paramGMAddFundsReq)
  {
    Object localObject = AddMoneyFragment.access$300();
    String str1 = "onGMAddFundsReqError";
    Logging.d((String)localObject, str1);
    localObject = this.this$0;
    localObject = AddMoneyFragment.access$400((AddMoneyFragment)localObject);
    ((MyDataLayer)localObject).stopTracking(paramGMAddFundsReq);
    localObject = this.this$0;
    boolean bool2 = false;
    AddMoneyFragment.access$802((AddMoneyFragment)localObject, bool2);
    localObject = AddMoneyFragment.access$300();
    String str2 = "onGMGetAddFundsReqError";
    Logging.d((String)localObject, str2);
    localObject = "10818";
    boolean bool1 = MiscUtils.hasErrorWithCode((String)localObject, paramGMAddFundsReq);
    if (!bool1)
    {
      AddMoneyFragment localAddMoneyFragment = this.this$0;
      AddMoneyFragment.access$900(localAddMoneyFragment, paramGMAddFundsReq);
    }
  }

  public void onGMAddFundsReqOK(GMAddFundsReq paramGMAddFundsReq)
  {
    Object localObject1 = AddMoneyFragment.access$300();
    Object localObject2 = "OnGmAddFundsReqOK";
    Logging.d((String)localObject1, (String)localObject2);
    localObject1 = this.this$0;
    localObject1 = AddMoneyFragment.access$400((AddMoneyFragment)localObject1);
    ((MyDataLayer)localObject1).stopTracking(paramGMAddFundsReq);
    localObject1 = this.this$0;
    localObject2 = AddMoneyFragment.DialogType.PleaseWait;
    AddMoneyFragment.access$500((AddMoneyFragment)localObject1, (AddMoneyFragment.DialogType)localObject2);
    localObject1 = this.this$0;
    boolean bool = true;
    AddMoneyFragment.access$602((AddMoneyFragment)localObject1, bool);
    localObject1 = this.this$0;
    AddMoneyFragment.access$700((AddMoneyFragment)localObject1);
  }

  public void onGMAnalyzeAddFundsReqError(GMAnalyzeAddFundsReq paramGMAnalyzeAddFundsReq)
  {
    Object localObject1 = AddMoneyFragment.access$300();
    Object localObject2 = "onGMGetAnalyzeAddFundsReqError";
    Logging.d((String)localObject1, (String)localObject2);
    localObject1 = this.this$0;
    localObject1 = AddMoneyFragment.access$400((AddMoneyFragment)localObject1);
    ((MyDataLayer)localObject1).stopTracking(paramGMAnalyzeAddFundsReq);
    localObject1 = this.this$0;
    localObject2 = AddMoneyFragment.DialogType.PleaseWait;
    AddMoneyFragment.access$500((AddMoneyFragment)localObject1, (AddMoneyFragment.DialogType)localObject2);
    localObject1 = this.this$0;
    boolean bool2 = false;
    AddMoneyFragment.access$802((AddMoneyFragment)localObject1, bool2);
    localObject1 = "10818";
    boolean bool1 = MiscUtils.hasErrorWithCode((String)localObject1, paramGMAnalyzeAddFundsReq);
    if (!bool1)
    {
      AddMoneyFragment localAddMoneyFragment = this.this$0;
      AddMoneyFragment.access$900(localAddMoneyFragment, paramGMAnalyzeAddFundsReq);
    }
  }

  public void onGMAnalyzeAddFundsReqOK(GMAnalyzeAddFundsReq paramGMAnalyzeAddFundsReq)
  {
    Object localObject1 = AddMoneyFragment.access$300();
    Object localObject2 = "onGMAnalyzeAddFundsReqOK";
    Logging.d((String)localObject1, (String)localObject2);
    localObject1 = this.this$0;
    localObject1 = AddMoneyFragment.access$400((AddMoneyFragment)localObject1);
    ((MyDataLayer)localObject1).stopTracking(paramGMAnalyzeAddFundsReq);
    localObject1 = this.this$0;
    localObject2 = paramGMAnalyzeAddFundsReq.getWithdrawObject();
    AddMoneyFragment.access$1002((AddMoneyFragment)localObject1, (WithdrawObject)localObject2);
    localObject1 = this.this$0;
    AddMoneyFragment.access$1100((AddMoneyFragment)localObject1);
  }

  public void onGMGetAddFundsOptionsReqError(GMGetAddFundsOptionsReq paramGMGetAddFundsOptionsReq)
  {
    boolean bool4 = true;
    Object localObject1 = AddMoneyFragment.access$300();
    Object localObject3 = "onGMGetAddFundsOptionsReqError";
    Logging.d((String)localObject1, (String)localObject3);
    localObject1 = this.this$0;
    localObject1 = AddMoneyFragment.access$400((AddMoneyFragment)localObject1);
    ((MyDataLayer)localObject1).stopTracking(paramGMGetAddFundsOptionsReq);
    ErrorBase localErrorBase = paramGMGetAddFundsOptionsReq.getLastError();
    localObject1 = localErrorBase.getErrorCode();
    localObject3 = "10891";
    boolean bool1 = ((String)localObject1).equals(localObject3);
    Object localObject2;
    Object localObject4;
    if (!bool1)
    {
      String str2 = localErrorBase.getErrorCode();
      localObject3 = "10888";
      boolean bool2 = str2.equals(localObject3);
      if (!bool2);
    }
    else
    {
      localObject2 = this.this$0;
      localObject3 = AddMoneyFragment.State.IDLE;
      AddMoneyFragment.access$1602((AddMoneyFragment)localObject2, (AddMoneyFragment.State)localObject3);
      localObject2 = this.this$0;
      AddMoneyFragment.access$802((AddMoneyFragment)localObject2, bool4);
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject3 = this.this$0;
      int i = 2131493884;
      localObject3 = ((AddMoneyFragment)localObject3).getString(i);
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
      localObject3 = "\n";
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
      localObject3 = this.this$0;
      i = 2131493885;
      localObject3 = ((AddMoneyFragment)localObject3).getString(i);
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
      String str1 = ((StringBuilder)localObject2).toString();
      localObject2 = this.this$0;
      localObject3 = AddMoneyFragment.DialogType.Error;
      localObject4 = this.this$0;
      int j = 2131493767;
      localObject4 = ((AddMoneyFragment)localObject4).getString(j);
      AddMoneyFragment.access$1700((AddMoneyFragment)localObject2, (AddMoneyFragment.DialogType)localObject3, (String)localObject4, str1);
      localObject2 = TrackPage.Point.AddFundsStart;
      PayPalApp.logError((TrackPage.Point)localObject2, localErrorBase, str1);
    }
    while (true)
    {
      return;
      localObject2 = "10818";
      boolean bool3 = MiscUtils.hasErrorWithCode((String)localObject2, paramGMGetAddFundsOptionsReq);
      if (!bool3)
      {
        AddMoneyFragment localAddMoneyFragment = this.this$0;
        AddMoneyFragment.access$900(localAddMoneyFragment, paramGMGetAddFundsOptionsReq);
        localAddMoneyFragment = this.this$0;
        AddMoneyFragment.access$802(localAddMoneyFragment, localObject4);
      }
    }
  }

  public void onGMGetAddFundsOptionsReqOK(GMGetAddFundsOptionsReq paramGMGetAddFundsOptionsReq)
  {
    Object localObject1 = AddMoneyFragment.access$300();
    Object localObject2 = "onGMGetAddFundsOptionsReqOK";
    Logging.d((String)localObject1, (String)localObject2);
    localObject1 = this.this$0;
    localObject1 = AddMoneyFragment.access$400((AddMoneyFragment)localObject1);
    ((MyDataLayer)localObject1).stopTracking(paramGMGetAddFundsOptionsReq);
    localObject1 = this.this$0;
    AddMoneyFragment.access$1200((AddMoneyFragment)localObject1);
    localObject2 = this.this$0;
    localObject1 = paramGMGetAddFundsOptionsReq.getFundingSources();
    localObject1 = (ArrayList)localObject1;
    AddMoneyFragment.access$1302((AddMoneyFragment)localObject2, (ArrayList)localObject1);
    localObject1 = this.this$0;
    localObject2 = AddMoneyFragment.DialogType.PleaseWait;
    AddMoneyFragment.access$500((AddMoneyFragment)localObject1, (AddMoneyFragment.DialogType)localObject2);
    localObject1 = this.this$0;
    ((AddMoneyFragment)localObject1).setupAccountTab();
    localObject1 = this.this$0;
    localObject1 = AddMoneyFragment.access$1400((AddMoneyFragment)localObject1);
    if (localObject1 != null)
    {
      localObject1 = this.this$0;
      localObject1 = AddMoneyFragment.access$1400((AddMoneyFragment)localObject1);
      MutableMoneyValue localMutableMoneyValue = ((MoneySpecEditor)localObject1).getAmount();
      localObject1 = this.this$0;
      AddMoneyFragment.access$1500((AddMoneyFragment)localObject1, localMutableMoneyValue);
    }
  }

  public void onLoginMetaRequestComplete(LoginMetaRequest paramLoginMetaRequest)
  {
    AddMoneyFragment localAddMoneyFragment = this.this$0;
    AddMoneyFragment.access$000(localAddMoneyFragment, paramLoginMetaRequest);
  }

  public void onPreconditionsUnsatisfied(ServerRequest2 paramServerRequest2)
  {
    Object localObject1 = AddMoneyFragment.access$300();
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    String str = "in AddFunds.onPreconditionsUnsatisfied: ";
    localObject2 = ((StringBuilder)localObject2).append(str);
    str = paramServerRequest2.toString();
    localObject2 = ((StringBuilder)localObject2).append(str);
    localObject2 = ((StringBuilder)localObject2).toString();
    Logging.d((String)localObject1, (String)localObject2);
    localObject1 = this.this$0;
    localObject2 = paramServerRequest2.getAPIName();
    AddMoneyFragment.access$2002((AddMoneyFragment)localObject1, (Core.APIName)localObject2);
    super.onPreconditionsUnsatisfied(paramServerRequest2);
  }

  public void onRequestError(CIPGetStatusRequest paramCIPGetStatusRequest, Object paramObject)
  {
    stopTracking(paramCIPGetStatusRequest);
    boolean bool1 = NetworkUtils.hasExpiredSessionTokenError(paramCIPGetStatusRequest);
    if (!bool1)
    {
      bool1 = NetworkUtils.hasUnexpectedXMLError(paramCIPGetStatusRequest);
      if (!bool1)
        break label29;
    }
    while (true)
    {
      return;
      label29: AddMoneyFragment localAddMoneyFragment = this.this$0;
      Object localObject3 = AddMoneyFragment.State.IDLE;
      AddMoneyFragment.access$1602(localAddMoneyFragment, (AddMoneyFragment.State)localObject3);
      int i = 2131494483;
      List localList = paramCIPGetStatusRequest.getAllErrors();
      Iterator localIterator = localList.iterator();
      while (true)
      {
        boolean bool2 = localIterator.hasNext();
        if (!bool2)
          break;
        Object localObject1 = localIterator.next();
        localObject1 = (ErrorBase)localObject1;
        String str = ((ErrorBase)localObject1).getErrorCode();
        localObject3 = "01006";
        boolean bool3 = str.equalsIgnoreCase((String)localObject3);
        if (bool3)
          i = 2131493769;
      }
      Object localObject2 = this.this$0;
      localObject3 = AddMoneyFragment.DialogType.CIPError;
      int j = 2131494482;
      AddMoneyFragment.access$1900((AddMoneyFragment)localObject2, (AddMoneyFragment.DialogType)localObject3, j, i);
      localObject2 = TrackPage.Point.AddFundsStart;
      localObject3 = null;
      PayPalApp.logError((TrackPage.Point)localObject2, (ErrorBase)localObject3, i);
    }
  }

  public void onRequestOK(CIPGetStatusRequest paramCIPGetStatusRequest, Object paramObject)
  {
    Map localMap = null;
    int i4 = 2131494487;
    int j = 2131494484;
    int i3 = 2131494482;
    Object localObject1 = AddMoneyFragment.access$300();
    Object localObject3 = new java/lang/StringBuilder;
    ((StringBuilder)localObject3).<init>();
    Object localObject5 = "add money cip sts: ";
    localObject3 = ((StringBuilder)localObject3).append((String)localObject5);
    localObject5 = paramCIPGetStatusRequest.getStatus();
    localObject3 = ((StringBuilder)localObject3).append(localObject5);
    localObject3 = ((StringBuilder)localObject3).toString();
    Logging.d((String)localObject1, (String)localObject3);
    localObject1 = this.this$0;
    localObject3 = AddMoneyFragment.DialogType.PleaseWait;
    AddMoneyFragment.access$500((AddMoneyFragment)localObject1, (AddMoneyFragment.DialogType)localObject3);
    stopTracking(paramCIPGetStatusRequest);
    localObject1 = AddMoneyFragment.4.$SwitchMap$com$paypal$android$base$server$cip$CIPGetStatusRequest$Status;
    localObject3 = paramCIPGetStatusRequest.getStatus();
    int m = ((CIPGetStatusRequest.Status)localObject3).ordinal();
    int i = localObject1[m];
    switch (i)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return;
      AddMoneyFragment localAddMoneyFragment = this.this$0;
      AddMoneyFragment.State localState = AddMoneyFragment.State.IDLE;
      AddMoneyFragment.access$1602(localAddMoneyFragment, localState);
      localAddMoneyFragment = this.this$0;
      int k = 1;
      AddMoneyFragment.access$1802(localAddMoneyFragment, k);
      continue;
      boolean bool1 = PayPalApp.haveUser();
      if (bool1)
      {
        PayPalUser localPayPalUser = PayPalApp.getCurrentUser();
        boolean bool2 = localPayPalUser.isBusinessAccount();
        Object localObject2;
        Object localObject4;
        if (!bool2)
        {
          localObject2 = this.this$0;
          localObject4 = AddMoneyFragment.DialogType.CIPVerification;
          int i1 = 2131494485;
          AddMoneyFragment.access$1900((AddMoneyFragment)localObject2, (AddMoneyFragment.DialogType)localObject4, k, i1);
        }
        else
        {
          TrackListener localTrackListener = new com/paypal/android/p2pmobile/utils/TrackListener;
          localObject2 = TrackPage.Point.CIPBusinessAccountMessage;
          localObject4 = TrackPage.Link.GoToWebsite;
          TrackPage.Link localLink = TrackPage.Link.CancelButton;
          localTrackListener.<init>((TrackPage.Point)localObject2, (TrackPage.Link)localObject4, localLink, localMap);
          localObject2 = this.this$0;
          localObject2 = ((AddMoneyFragment)localObject2).getHostActivity();
          int n = 2131494493;
          int i2 = 2131494494;
          i3 = 2131493725;
          String str = "https://www.paypal.com/us/cgi-bin/webscr?cmd=%5fadd%2dfunds&nav=0%2e1";
          WalletDialogUtil.displayBrowserConfirmationDialogWithCancelButton((Context)localObject2, k, n, i2, i3, str, localTrackListener);
          localObject2 = this.this$0;
          localObject2 = ((AddMoneyFragment)localObject2).getHostActivity();
          localObject2 = (FragmentActivity)localObject2;
          localObject2 = ((FragmentActivity)localObject2).getSupportFragmentManager();
          ((FragmentManager)localObject2).popBackStackImmediate();
          continue;
          localObject2 = this.this$0;
          AddMoneyFragment.DialogType localDialogType = AddMoneyFragment.DialogType.CIPError;
          n = 2131494489;
          AddMoneyFragment.access$1900((AddMoneyFragment)localObject2, localDialogType, i3, n);
          continue;
          localObject2 = this.this$0;
          localDialogType = AddMoneyFragment.DialogType.CIPError;
          n = 2131494488;
          AddMoneyFragment.access$1900((AddMoneyFragment)localObject2, localDialogType, i3, n);
          continue;
          localObject2 = this.this$0;
          localDialogType = AddMoneyFragment.DialogType.CIPError;
          n = 2131494486;
          AddMoneyFragment.access$1900((AddMoneyFragment)localObject2, localDialogType, n, str);
          localObject2 = TrackPage.Point.AddFundsStart;
          PayPalApp.logError((TrackPage.Point)localObject2, localMap, str);
        }
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddMoneyFragment.MyDataLayer
 * JD-Core Version:    0.6.2
 */
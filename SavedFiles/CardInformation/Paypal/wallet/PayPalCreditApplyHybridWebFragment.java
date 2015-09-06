package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Context;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.paypal.android.base.Core;
import com.paypal.android.base.Core.APIName;
import com.paypal.android.base.api_url.OperationUrl;
import com.paypal.android.base.server.NetworkUtils;
import com.paypal.android.foundation.account.AccountModel;
import com.paypal.android.foundation.account.model.Token;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.common.web.ppcredit.WebHybridBridge;
import com.paypal.android.p2pmobile.common.web.ppcredit.WebHybridClient;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.preferences.GlobalPreferences;

public class PayPalCreditApplyHybridWebFragment extends BaseFragment
{
  private static final String BML_HARD_DECLINE = "hardDecline";
  private static final String BML_SIGNUP_FLOW_URL_TEMPLATE = "%s?session_token=%s&isNative=true&flowOrigin=mid&device=android&appVersion=5.0.0-1&locale.x=en";
  private static final String BML_SUCCESS = "SUCCESS";
  private static final String INTERFACE_NAME = "ppAndroid";
  private static final String LOG_TAG = (String)localObject;
  private PayPalCreditApplyHybridWebFragment.BMLEntryPoint mEntryPoint;
  private boolean mHasLoadedTwice;
  private final WebHybridBridge mListener;
  private ProgressBar mSpinner;
  private WebView mWeb;

  static
  {
    Object localObject = PayPalCreditApplyHybridWebFragment.class;
    localObject = ((Class)localObject).getSimpleName();
  }

  public PayPalCreditApplyHybridWebFragment()
  {
    WebHybridBridge localWebHybridBridge = new com/paypal/android/p2pmobile/common/web/ppcredit/WebHybridBridge;
    localWebHybridBridge.<init>(this);
    this.mListener = localWebHybridBridge;
  }

  private void handleBMLApplyResult(PayPalCreditApplyHybridWebFragment.BMLSignupResult paramBMLSignupResult)
  {
    Object localObject = getListener();
    localObject = (PayPalCreditApplyHybridWebFragment.PayPalCreditApplyHybridWebFragmentListener)localObject;
    ((PayPalCreditApplyHybridWebFragment.PayPalCreditApplyHybridWebFragmentListener)localObject).handleBMLApplyResult(paramBMLSignupResult);
  }

  public static PayPalCreditApplyHybridWebFragment newInstance()
  {
    PayPalCreditApplyHybridWebFragment localPayPalCreditApplyHybridWebFragment = new com/paypal/android/p2pmobile/fragment/wallet/PayPalCreditApplyHybridWebFragment;
    localPayPalCreditApplyHybridWebFragment.<init>();
    return localPayPalCreditApplyHybridWebFragment;
  }

  public void onBMLSignupComplete(String paramString)
  {
    String str = "SUCCESS";
    boolean bool1 = paramString.equals(str);
    Object localObject;
    if (bool1)
    {
      localObject = PayPalCreditApplyHybridWebFragment.BMLSignupResult.dropDownSuccess;
      handleBMLApplyResult((PayPalCreditApplyHybridWebFragment.BMLSignupResult)localObject);
    }
    while (true)
    {
      return;
      localObject = "hardDecline";
      boolean bool2 = paramString.equals(localObject);
      PayPalCreditApplyHybridWebFragment.BMLSignupResult localBMLSignupResult;
      if (bool2)
      {
        localBMLSignupResult = PayPalCreditApplyHybridWebFragment.BMLSignupResult.dropDownDecline;
        handleBMLApplyResult(localBMLSignupResult);
      }
      else
      {
        localBMLSignupResult = PayPalCreditApplyHybridWebFragment.BMLSignupResult.cancel;
        handleBMLApplyResult(localBMLSignupResult);
      }
    }
  }

  public boolean onBackPressed()
  {
    WebView localWebView1 = this.mWeb;
    boolean bool1 = localWebView1.canGoBack();
    if (bool1)
    {
      WebView localWebView2 = this.mWeb;
      localWebView2.goBack();
      localWebView2 = this.mWeb;
      boolean bool2 = localWebView2.canGoBack();
      if (!bool2)
      {
        Object localObject = getActivity();
        localObject = ((FragmentActivity)localObject).getSupportFragmentManager();
        ((FragmentManager)localObject).popBackStackImmediate();
      }
    }
    for (boolean bool3 = true; ; bool3 = false)
      return bool3;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool3 = true;
    int m = 0;
    int i = 2130903244;
    Object localObject4 = null;
    View localView = paramLayoutInflater.inflate(i, (ViewGroup)localObject4);
    i = 2131427512;
    Object localObject1 = localView.findViewById(i);
    localObject1 = (WebView)localObject1;
    this.mWeb = ((WebView)localObject1);
    int j = 2131428189;
    Object localObject2 = localView.findViewById(j);
    localObject2 = (ProgressBar)localObject2;
    this.mSpinner = ((ProgressBar)localObject2);
    localObject2 = this.mWeb;
    ((WebView)localObject2).clearCache(bool3);
    localObject2 = this.mWeb;
    localObject2 = ((WebView)localObject2).getSettings();
    localObject4 = Core.getContext();
    localObject4 = NetworkUtils.getUserAgent((Context)localObject4);
    ((WebSettings)localObject2).setUserAgentString((String)localObject4);
    localObject2 = this.mWeb;
    ((WebView)localObject2).setScrollBarStyle(m);
    localObject2 = this.mWeb;
    localObject2 = ((WebView)localObject2).getSettings();
    ((WebSettings)localObject2).setJavaScriptEnabled(bool3);
    localObject2 = this.mWeb;
    localObject2 = ((WebView)localObject2).getSettings();
    ((WebSettings)localObject2).setUseWideViewPort(m);
    localObject2 = this.mWeb;
    localObject4 = new com/paypal/android/p2pmobile/common/web/ppcredit/WebHybridClient;
    ((WebHybridClient)localObject4).<init>(this);
    ((WebView)localObject2).setWebViewClient((WebViewClient)localObject4);
    localObject2 = this.mWeb;
    localObject4 = this.mListener;
    String str4 = "ppAndroid";
    ((WebView)localObject2).addJavascriptInterface(localObject4, str4);
    localObject2 = AccountModel.getInstance();
    localObject2 = ((AccountModel)localObject2).getSessionToken();
    String str2 = ((Token)localObject2).getTokenValue();
    localObject2 = Core.APIName.BmlFlowURL;
    localObject4 = Core.getAPIServer();
    String str1 = OperationUrl.get((Core.APIName)localObject2, (String)localObject4);
    localObject2 = "%s?session_token=%s&isNative=true&flowOrigin=mid&device=android&appVersion=5.0.0-1&locale.x=en";
    int k = 2;
    Object[] arrayOfObject = new Object[k];
    arrayOfObject[m] = str1;
    arrayOfObject[bool3] = str2;
    String str3 = String.format((String)localObject2, arrayOfObject);
    boolean bool1 = PayPalApp.getDebug();
    if (bool1)
    {
      GlobalPreferences localGlobalPreferences = PayPalApp.getPrefs();
      boolean bool2 = localGlobalPreferences.isSimulateSSLSecurityBreach();
      if (bool2)
      {
        localObject3 = PayPalApp.getPrefs();
        str3 = ((GlobalPreferences)localObject3).getSimulateSSLSecurityBreachURL();
      }
    }
    Object localObject3 = this.mWeb;
    ((WebView)localObject3).loadUrl(str3);
    return localView;
  }

  public void onUpdateTitle(String paramString)
  {
  }

  public void onWebViewSSLError(SslError paramSslError)
  {
    Object localObject = getListener();
    localObject = (PayPalCreditApplyHybridWebFragment.PayPalCreditApplyHybridWebFragmentListener)localObject;
    if (localObject != null)
      ((PayPalCreditApplyHybridWebFragment.PayPalCreditApplyHybridWebFragmentListener)localObject).onWebViewSSLError(paramSslError);
  }

  public void reload()
  {
    WebView localWebView = this.mWeb;
    Object localObject = this.mWeb;
    localObject = ((WebView)localObject).getUrl();
    localWebView.loadUrl((String)localObject);
    boolean bool = true;
    this.mHasLoadedTwice = bool;
  }

  public void setEntryPoint(PayPalCreditApplyHybridWebFragment.BMLEntryPoint paramBMLEntryPoint)
  {
    this.mEntryPoint = paramBMLEntryPoint;
  }

  public void setLoading(boolean paramBoolean)
  {
    ProgressBar localProgressBar2 = 8;
    ProgressBar localProgressBar3 = 0;
    int i;
    if (!paramBoolean)
    {
      i = this.mHasLoadedTwice;
      if (i == 0)
      {
        reload();
        return;
      }
    }
    WebView localWebView = this.mWeb;
    label37: ProgressBar localProgressBar1;
    if (paramBoolean)
    {
      i = localProgressBar2;
      localWebView.setVisibility(i);
      localProgressBar1 = this.mSpinner;
      if (!paramBoolean)
        break label67;
    }
    while (true)
    {
      localProgressBar1.setVisibility(localProgressBar3);
      break;
      localProgressBar1 = localProgressBar3;
      break label37;
      label67: localProgressBar3 = localProgressBar2;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.PayPalCreditApplyHybridWebFragment
 * JD-Core Version:    0.6.2
 */
package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.p2pmobile.fragment.BaseFragment;

public class LoyaltyProgramTermsFragment extends BaseFragment
{
  private static final DebugLogger L = (DebugLogger)localObject;
  private Handler mHandler;
  final Runnable mHtmlRunnableData;
  private FrameLayout mLayout;
  public ProgressBar mProgressBar;
  private View mRoot;
  private String mUrl;
  private WebView mWebView;

  static
  {
    Object localObject = LoyaltyProgramTermsFragment.class;
    localObject = DebugLogger.getLogger((Class)localObject);
  }

  public LoyaltyProgramTermsFragment()
  {
    LoyaltyProgramTermsFragment.2 local2 = new com/paypal/android/p2pmobile/fragment/wallet/LoyaltyProgramTermsFragment$2;
    local2.<init>(this);
    this.mHtmlRunnableData = local2;
  }

  private WebView createWebView()
  {
    int j = -1;
    WebView localWebView = new android/webkit/WebView;
    Object localObject = getLocalListener();
    localObject = ((LoyaltyProgramTermsFragment.OnLoyaltyProgramTermsFragmentListener)localObject).getBaseActivity();
    localWebView.<init>((Context)localObject);
    this.mWebView = localWebView;
    RelativeLayout.LayoutParams localLayoutParams = new android/widget/RelativeLayout$LayoutParams;
    localLayoutParams.<init>(j, j);
    localWebView = this.mWebView;
    localWebView.setLayoutParams(localLayoutParams);
    localWebView = this.mWebView;
    int i = 8;
    localWebView.setVisibility(i);
    localWebView = this.mWebView;
    return localWebView;
  }

  private LoyaltyProgramTermsFragment.OnLoyaltyProgramTermsFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (LoyaltyProgramTermsFragment.OnLoyaltyProgramTermsFragmentListener)localObject;
    return localObject;
  }

  public static LoyaltyProgramTermsFragment newInstance()
  {
    LoyaltyProgramTermsFragment localLoyaltyProgramTermsFragment = new com/paypal/android/p2pmobile/fragment/wallet/LoyaltyProgramTermsFragment;
    localLoyaltyProgramTermsFragment.<init>();
    return localLoyaltyProgramTermsFragment;
  }

  public void onCreate(Bundle paramBundle)
  {
    Object localObject = L;
    String str = "Creating LoyaltyProgramTermsFragment ";
    int i = 0;
    Object[] arrayOfObject = new Object[i];
    ((DebugLogger)localObject).debug(str, arrayOfObject);
    super.onCreate(paramBundle);
    localObject = new android/os/Handler;
    ((Handler)localObject).<init>();
    this.mHandler = ((Handler)localObject);
    localObject = getArguments();
    if (localObject != null)
    {
      localObject = getArguments();
      str = "termsUrl";
      localObject = ((Bundle)localObject).getString(str);
      this.mUrl = ((String)localObject);
    }
    while (true)
    {
      return;
      if (paramBundle != null)
      {
        localObject = "termsUrl";
        localObject = paramBundle.getString((String)localObject);
        this.mUrl = ((String)localObject);
      }
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    DebugLogger localDebugLogger = L;
    String str = "Creating LoyaltyProgramTermsFragment view";
    int k = 0;
    Object[] arrayOfObject = new Object[k];
    localDebugLogger.debug(str, arrayOfObject);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    int i = 2130903267;
    str = null;
    Object localObject = paramLayoutInflater.inflate(i, str);
    this.mRoot = ((View)localObject);
    localObject = this.mRoot;
    if (localObject != null)
    {
      localObject = this.mRoot;
      int j = 2131427981;
      localObject = ((View)localObject).findViewById(j);
      localObject = (ProgressBar)localObject;
      this.mProgressBar = ((ProgressBar)localObject);
      localObject = createWebView();
      this.mWebView = ((WebView)localObject);
      localObject = this.mRoot;
      j = 2131428247;
      localObject = ((View)localObject).findViewById(j);
      localObject = (FrameLayout)localObject;
      this.mLayout = ((FrameLayout)localObject);
      localObject = this.mLayout;
      if (localObject != null)
      {
        localObject = this.mWebView;
        LoyaltyProgramTermsFragment.1 local1 = new com/paypal/android/p2pmobile/fragment/wallet/LoyaltyProgramTermsFragment$1;
        local1.<init>(this);
        ((WebView)localObject).setWebViewClient(local1);
        localObject = this.mWebView;
        localObject = ((WebView)localObject).getSettings();
        boolean bool = true;
        ((WebSettings)localObject).setJavaScriptEnabled(bool);
        presentTermsView();
      }
    }
    localObject = this.mRoot;
    return localObject;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    Object localObject = L;
    String str = "Saving the instance";
    int i = 0;
    Object[] arrayOfObject = new Object[i];
    ((DebugLogger)localObject).debug(str, arrayOfObject);
    super.onSaveInstanceState(paramBundle);
    localObject = "termsUrl";
    str = this.mUrl;
    paramBundle.putString((String)localObject, str);
  }

  private void presentTermsView()
  {
    LoyaltyProgramTermsFragment.3 local3 = new com/paypal/android/p2pmobile/fragment/wallet/LoyaltyProgramTermsFragment$3;
    local3.<init>(this);
    local3.start();
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.LoyaltyProgramTermsFragment
 * JD-Core Version:    0.6.2
 */
package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.p2pmobile.fragment.BaseFragment;

public class GiftCardProgramTermsFragment extends BaseFragment
{
  public static final String BUNDLE_KEY_URL = "url";
  private static final DebugLogger L = (DebugLogger)localObject;
  private Handler mHandler;
  final Runnable mHtmlRunnableData;
  private boolean mIsShowingDialog;
  private FrameLayout mLayout;
  public ProgressBar mProgressBar;
  private String mUrl;
  private WebView mWebView;

  static
  {
    Object localObject = GiftCardProgramTermsFragment.class;
    localObject = DebugLogger.getLogger((Class)localObject);
  }

  public GiftCardProgramTermsFragment()
  {
    GiftCardProgramTermsFragment.1 local1 = new com/paypal/android/p2pmobile/fragment/wallet/GiftCardProgramTermsFragment$1;
    local1.<init>(this);
    this.mHtmlRunnableData = local1;
  }

  private GiftCardProgramTermsFragment.OnGiftCardProgramTermsFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (GiftCardProgramTermsFragment.OnGiftCardProgramTermsFragmentListener)localObject;
    return localObject;
  }

  public static GiftCardProgramTermsFragment newInstance()
  {
    GiftCardProgramTermsFragment localGiftCardProgramTermsFragment = new com/paypal/android/p2pmobile/fragment/wallet/GiftCardProgramTermsFragment;
    localGiftCardProgramTermsFragment.<init>();
    return localGiftCardProgramTermsFragment;
  }

  public void onCreate(Bundle paramBundle)
  {
    Object localObject = L;
    String str = "Creating GiftCardProgramTermsFragment ";
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
      str = "url";
      localObject = ((Bundle)localObject).getString(str);
      this.mUrl = ((String)localObject);
    }
    while (true)
    {
      return;
      if (paramBundle != null)
      {
        localObject = "url";
        localObject = paramBundle.getString((String)localObject);
        this.mUrl = ((String)localObject);
      }
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int n = -1;
    Object localObject1 = L;
    Object localObject4 = "Creating GiftCardProgramTermsFragment view";
    int m = 0;
    Object[] arrayOfObject = new Object[m];
    ((DebugLogger)localObject1).debug((String)localObject4, arrayOfObject);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    localObject1 = TrackPage.Point.GiftCardTermsAndCondition;
    setTrackPage((TrackPage.Point)localObject1);
    int i = 2130903267;
    localObject4 = null;
    View localView = paramLayoutInflater.inflate(i, (ViewGroup)localObject4);
    if (localView != null)
    {
      i = 2131427981;
      Object localObject2 = localView.findViewById(i);
      localObject2 = (ProgressBar)localObject2;
      this.mProgressBar = ((ProgressBar)localObject2);
      localObject2 = new android/webkit/WebView;
      localObject4 = getLocalListener();
      localObject4 = ((GiftCardProgramTermsFragment.OnGiftCardProgramTermsFragmentListener)localObject4).getBaseActivity();
      ((WebView)localObject2).<init>((Context)localObject4);
      this.mWebView = ((WebView)localObject2);
      localObject2 = this.mWebView;
      localObject4 = new android/widget/RelativeLayout$LayoutParams;
      ((RelativeLayout.LayoutParams)localObject4).<init>(n, n);
      ((WebView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject2 = this.mWebView;
      int k = 8;
      ((WebView)localObject2).setVisibility(k);
      int j = 2131428247;
      Object localObject3 = localView.findViewById(j);
      localObject3 = (FrameLayout)localObject3;
      this.mLayout = ((FrameLayout)localObject3);
      localObject3 = this.mLayout;
      if (localObject3 != null)
      {
        localObject3 = this.mWebView;
        GiftCardProgramTermsFragment.2 local2 = new com/paypal/android/p2pmobile/fragment/wallet/GiftCardProgramTermsFragment$2;
        local2.<init>(this);
        ((WebView)localObject3).setWebViewClient(local2);
        localObject3 = this.mWebView;
        localObject3 = ((WebView)localObject3).getSettings();
        boolean bool = true;
        ((WebSettings)localObject3).setJavaScriptEnabled(bool);
        GiftCardProgramTermsFragment.3 local3 = new com/paypal/android/p2pmobile/fragment/wallet/GiftCardProgramTermsFragment$3;
        local3.<init>(this);
        local3.start();
      }
    }
    return localView;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    Object localObject = L;
    String str = "Saving the instance";
    int i = 0;
    Object[] arrayOfObject = new Object[i];
    ((DebugLogger)localObject).debug(str, arrayOfObject);
    super.onSaveInstanceState(paramBundle);
    localObject = "url";
    str = this.mUrl;
    paramBundle.putString((String)localObject, str);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.GiftCardProgramTermsFragment
 * JD-Core Version:    0.6.2
 */
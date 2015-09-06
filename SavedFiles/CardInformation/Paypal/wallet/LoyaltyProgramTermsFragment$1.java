package com.paypal.android.p2pmobile.fragment.wallet;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

class LoyaltyProgramTermsFragment$1 extends WebViewClient
{
  final LoyaltyProgramTermsFragment this$0;

  LoyaltyProgramTermsFragment$1(LoyaltyProgramTermsFragment paramLoyaltyProgramTermsFragment)
  {
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    Object localObject = this.this$0;
    localObject = LoyaltyProgramTermsFragment.access$000((LoyaltyProgramTermsFragment)localObject);
    int i = 0;
    ((WebView)localObject).setVisibility(i);
    localObject = this.this$0;
    localObject = ((LoyaltyProgramTermsFragment)localObject).mProgressBar;
    i = 4;
    ((ProgressBar)localObject).setVisibility(i);
  }

  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    Object localObject = this.this$0;
    localObject = ((LoyaltyProgramTermsFragment)localObject).mProgressBar;
    int i = 0;
    ((ProgressBar)localObject).setVisibility(i);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.LoyaltyProgramTermsFragment.1
 * JD-Core Version:    0.6.2
 */
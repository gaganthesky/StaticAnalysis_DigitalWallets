package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.paypal.android.p2pmobile.common.MailTo;
import com.paypal.android.p2pmobile.utils.IntentUtils;
import com.paypal.android.p2pmobile.utils.WalletDialogUtil;

class GiftCardProgramTermsFragment$2 extends WebViewClient
{
  final GiftCardProgramTermsFragment this$0;

  GiftCardProgramTermsFragment$2(GiftCardProgramTermsFragment paramGiftCardProgramTermsFragment)
  {
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    Object localObject = this.this$0;
    localObject = GiftCardProgramTermsFragment.access$000((GiftCardProgramTermsFragment)localObject);
    int i = 0;
    ((WebView)localObject).setVisibility(i);
    localObject = this.this$0;
    localObject = ((GiftCardProgramTermsFragment)localObject).mProgressBar;
    i = 4;
    ((ProgressBar)localObject).setVisibility(i);
  }

  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    Object localObject = this.this$0;
    localObject = ((GiftCardProgramTermsFragment)localObject).mProgressBar;
    int i = 0;
    ((ProgressBar)localObject).setVisibility(i);
  }

  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    DialogInterface.OnClickListener localOnClickListener1 = null;
    GiftCardProgramTermsFragment.2.1 local1 = new com/paypal/android/p2pmobile/fragment/wallet/GiftCardProgramTermsFragment$2$1;
    local1.<init>(this);
    GiftCardProgramTermsFragment localGiftCardProgramTermsFragment = this.this$0;
    boolean bool1 = GiftCardProgramTermsFragment.access$400(localGiftCardProgramTermsFragment);
    if (!bool1)
    {
      Object localObject = this.this$0;
      boolean bool2 = true;
      GiftCardProgramTermsFragment.access$402((GiftCardProgramTermsFragment)localObject, bool2);
      localObject = this.this$0;
      localObject = ((GiftCardProgramTermsFragment)localObject).getActivity();
      int i = 2131493201;
      int j = 2131493171;
      int k = 2131493757;
      int m = -1;
      DialogInterface.OnClickListener localOnClickListener2 = localOnClickListener1;
      WalletDialogUtil.displayGenericDialog((Context)localObject, i, j, k, m, local1, localOnClickListener1, localOnClickListener2);
    }
    paramSslErrorHandler.cancel();
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool5 = true;
    String str5 = "tel:";
    boolean bool1 = paramString.startsWith(str5);
    Intent localIntent3;
    Object localObject1;
    Object localObject4;
    if (bool1)
    {
      localIntent3 = new android/content/Intent;
      localObject1 = "android.intent.action.DIAL";
      localObject4 = Uri.parse(paramString);
      localIntent3.<init>((String)localObject1, (Uri)localObject4);
      localObject1 = this.this$0;
      ((GiftCardProgramTermsFragment)localObject1).startActivity(localIntent3);
    }
    while (true)
    {
      return bool5;
      localObject1 = "mailto:";
      boolean bool2 = paramString.startsWith((String)localObject1);
      Object localObject2;
      if (bool2)
      {
        MailTo localMailTo = MailTo.parse(paramString);
        String str1 = localMailTo.getTo();
        String str4 = localMailTo.getSubject();
        String str2 = localMailTo.getBody();
        String str3 = localMailTo.getCc();
        localIntent3 = new android/content/Intent;
        localObject2 = "android.intent.action.SEND";
        localIntent3.<init>((String)localObject2);
        localObject2 = "android.intent.extra.EMAIL";
        localObject4 = new String[bool5];
        int i = 0;
        localObject4[i] = str1;
        localIntent3.putExtra((String)localObject2, (String[])localObject4);
        localObject2 = "android.intent.extra.TEXT";
        localIntent3.putExtra((String)localObject2, str2);
        localObject2 = "android.intent.extra.SUBJECT";
        localIntent3.putExtra((String)localObject2, str4);
        localObject2 = "android.intent.extra.CC";
        localIntent3.putExtra((String)localObject2, str3);
        localObject2 = "message/rfc822";
        localIntent3.setType((String)localObject2);
        Intent localIntent2 = IntentUtils.chooserIntentFromMailtoIntent(localIntent3);
        localObject2 = this.this$0;
        ((GiftCardProgramTermsFragment)localObject2).startActivity(localIntent2);
      }
      else
      {
        localObject2 = "http:";
        boolean bool3 = paramString.startsWith((String)localObject2);
        if (!bool3)
        {
          String str6 = "https:";
          boolean bool4 = paramString.startsWith(str6);
          if (!bool4);
        }
        else
        {
          Intent localIntent1 = new android/content/Intent;
          Object localObject3 = "android.intent.action.VIEW";
          localObject4 = Uri.parse(paramString);
          localIntent1.<init>((String)localObject3, (Uri)localObject4);
          localObject3 = this.this$0;
          ((GiftCardProgramTermsFragment)localObject3).startActivity(localIntent1);
        }
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.GiftCardProgramTermsFragment.2
 * JD-Core Version:    0.6.2
 */
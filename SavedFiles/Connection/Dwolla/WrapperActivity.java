package com.dwolla.dwolla.primary;

import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dwolla.dwolla.util.Application;
import com.dwolla.dwolla.util.BetterWebClient;

public class WrapperActivity extends android.app.Activity
    implements com.dwolla.dwolla.util.BetterWebClient.Events, android.view.View.OnClickListener
{

    private static final java.lang.String dwollaLabs = "https://mobile.dwollalabs.com/";
    private static final java.lang.String keyPrevURL = "previously visited url";
    private android.widget.LinearLayout empty;
    private android.widget.LinearLayout push;
    private android.widget.LinearLayout stats;
    private android.widget.TextView statsValue;
    private android.webkit.WebView webView;

    public WrapperActivity()
    {
    }

    private java.lang.String getErrorMessage(int i)
    {
        switch(i)
        {
        default:
            return "ERROR_UNKNOWN";

        case -1: 
            return "ERROR_UNKNOWN";

        case -2: 
            return "ERROR_HOST_LOOKUP";

        case -3: 
            return "ERROR_UNSUPPORTED_AUTH_SCHEME";

        case -4: 
            return "ERROR_AUTH";

        case -5: 
            return "ERROR_PROXY_AUTHENTICATION";

        case -6: 
            return "ERROR_CONNECT";

        case -7: 
            return "ERROR_IO";

        case -8: 
            return "ERROR_TIMEOUT";

        case -9: 
            return "ERROR_REDIRECT_LOOP";

        case -10: 
            return "ERROR_UNSUPPORTED_SCHEME";

        case -11: 
            return "ERROR_FAILED_SSL_HANDSHAKE";

        case -12: 
            return "ERROR_BAD_URL";

        case -13: 
            return "ERROR_FILE";

        case -14: 
            return "ERROR_FILE_NOT_FOUND";

        case -15: 
            return "ERROR_TOO_MANY_REQUEST";
        }
    }

    private void toggleCustomError(boolean flag)
    {
        if(flag)
        {
            webView.setVisibility(8);
            empty.setVisibility(0);
            stats.setAnimation(android.view.animation.AnimationUtils.loadAnimation(this, 0x7f040000));
            return;
        } else
        {
            webView.setVisibility(0);
            empty.setVisibility(8);
            return;
        }
    }

    private void toggleStats()
    {
        switch(statsValue.getVisibility())
        {
        default:
            return;

        case 0: // '\\0'
            statsValue.setVisibility(4);
            return;

        case 4: // '\\004'
            statsValue.setVisibility(0);
            break;
        }
    }

    public void onBackPressed()
    {
        if(webView.canGoBack())
        {
            webView.goBack();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onClick(android.view.View view)
    {
        switch(view.getId())
        {
        case 2131361797: 
        default:
            return;
        }
    }

    protected void onCreate(android.os.Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030001);
        if(getActionBar() != null)
            getActionBar().hide();
        webView = (android.webkit.WebView)findViewById(0x7f0a0003);
        empty = (android.widget.LinearLayout)findViewById(0x7f0a0004);
        push = (android.widget.LinearLayout)findViewById(0x7f0a0005);
        stats = (android.widget.LinearLayout)findViewById(0x7f0a0008);
        statsValue = (android.widget.TextView)findViewById(0x7f0a000a);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setGeolocationEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setUserAgentString("com.dwolla.android");
        webView.setWebViewClient(com.dwolla.dwolla.util.Application.getWebClient());
        webView.setWebChromeClient(com.dwolla.dwolla.util.Application.getChromeClient());
        webView.loadUrl("https://mobile.dwollalabs.com/");
    }

    public void onError(android.webkit.WebView webview, int i, java.lang.String s, java.lang.String s1)
    {
    }

    public void onFinish(android.webkit.WebView webview, java.lang.String s)
    {
    }

    protected void onPause()
    {
        super.onPause();
        webView.onPause();
        com.dwolla.dwolla.util.BetterWebClient.unregister();
        com.dwolla.dwolla.util.Application.getPrefsEdit().putString("previously visited url", webView.getUrl()).commit();
    }

    protected void onResume()
    {
        super.onResume();
        webView.onResume();
        com.dwolla.dwolla.util.BetterWebClient.register(this);
        if(com.dwolla.dwolla.util.Application.getPrefs().contains("previously visited url"))
            webView.loadUrl(com.dwolla.dwolla.util.Application.getPrefs().getString("previously visited url", "https://mobile.dwollalabs.com/"));
    }

    protected void onStop()
    {
        super.onStop();
        com.dwolla.dwolla.util.BetterWebClient.unregister();
    }
}




/* Location:           /home/gagan/Desktop/Output2/Dwolla/retargeted/com.dwolla.dwolla.src/com/dwolla/dwolla/primary
 * Qualified Name:     com.dwolla.dwolla.primary.WrapperActivity
 * JD-Core Version:    0.6.2
 */


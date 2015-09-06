package com.removed.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import com.removed.util.MyUtils;
import com.removed.util.ThreadPoolManager;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Home_Search_webview extends Fragment
{
  private int count;
  private String filePath;
  Handler handler;
  private boolean isRunning;
  private boolean keyword_from_web;
  public Boolean keyword_is_searched;
  public long last_key_time;
  protected ThreadPoolManager mThreadPoolManager;
  public List responseList;
  private ImageView search_delete;
  private WebView searchwebview;
  private Handler switchHandler;
  private Runnable switchTask;
  String url;
  private Button webbtnSearch;
  private AutoCompleteTextView webetSearch;
  Home_Search_webview.Mywebview webviewclient;

  public Home_Search_webview()
  {
    Object localObject1 = new com/removed/fragment/Home_Search_webview$1;
    ((Home_Search_webview.1)localObject1).<init>(this);
    this.handler = ((Handler)localObject1);
    this.count = i;
    localObject1 = "http://www.appeggs.com/_201404/app_api_center/keyword_search.php";
    this.url = ((String)localObject1);
    localObject1 = new java/lang/StringBuilder;
    Object localObject3 = Environment.getExternalStorageDirectory();
    localObject3 = ((File)localObject3).getAbsolutePath();
    localObject3 = String.valueOf(localObject3);
    ((StringBuilder)localObject1).<init>((String)localObject3);
    localObject3 = "/com.ywh.imgcache";
    localObject1 = ((StringBuilder)localObject1).append((String)localObject3);
    localObject1 = ((StringBuilder)localObject1).toString();
    this.filePath = ((String)localObject1);
    long l = 0L;
    this.last_key_time = l;
    Object localObject2 = Boolean.valueOf(i);
    this.keyword_is_searched = ((Boolean)localObject2);
    this.keyword_from_web = i;
    localObject2 = new android/os/Handler;
    ((Handler)localObject2).<init>();
    this.switchHandler = ((Handler)localObject2);
    localObject2 = new com/removed/fragment/Home_Search_webview$2;
    ((Home_Search_webview.2)localObject2).<init>(this);
    this.switchTask = ((Runnable)localObject2);
    localObject2 = ThreadPoolManager.getInstance();
    this.mThreadPoolManager = ((ThreadPoolManager)localObject2);
  }

  public void change_search_keyword()
  {
    int i = this.count;
    i += 1;
    this.count = i;
    i = this.count;
    List localList2 = MyUtils.hot_keyword_list;
    int k = localList2.size();
    if (i >= k)
    {
      List localList1 = MyUtils.hot_keyword_list;
      int j = localList1.size();
      j += -1;
      this.count = j;
      j = 0;
      this.isRunning = j;
    }
    Object localObject2 = this.webetSearch;
    Object localObject1 = MyUtils.hot_keyword_list;
    int n = this.count;
    localObject1 = ((List)localObject1).get(n);
    localObject1 = (CharSequence)localObject1;
    ((AutoCompleteTextView)localObject2).setText((CharSequence)localObject1);
    localObject1 = this.webetSearch;
    localObject2 = this.webetSearch;
    localObject2 = ((AutoCompleteTextView)localObject2).getText();
    int m = ((Editable)localObject2).length();
    ((AutoCompleteTextView)localObject1).setSelection(m);
  }

  public void getAutoCompleteTextView()
  {
    Object localObject = MyUtils.hot_keyword_list;
    if (localObject == null)
    {
      localObject = new com/removed/fragment/Home_Search_webview$6;
      ((Home_Search_webview.6)localObject).<init>(this);
      int i = 0;
      Void[] arrayOfVoid = new Void[i];
      ((Home_Search_webview.6)localObject).execute(arrayOfVoid);
    }
  }

  public List<String> getChange_keyword(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramString == null)
      localObject1 = localObject2;
    while (true)
    {
      return localObject1;
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(paramString);
        if (localJSONObject != null)
        {
          String str1 = "status";
          int j = localJSONObject.getInt(str1);
          int k = 1;
          if (j == k)
          {
            String str2 = "keywords";
            JSONArray localJSONArray = localJSONObject.getJSONArray(str2);
            localObject1 = new java/util/ArrayList;
            ((ArrayList)localObject1).<init>();
            int i = 0;
            while (true)
            {
              int m = localJSONArray.length();
              if (i >= m)
                break;
              String str3 = localJSONArray.getString(i);
              ((List)localObject1).add(str3);
              i += 1;
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localObject1 = localObject2;
      }
    }
  }

  private void init(View paramView)
  {
    Timer localTimer = new java/util/Timer;
    localTimer.<init>();
    Home_Search_webview.7 local7 = new com/removed/fragment/Home_Search_webview$7;
    local7.<init>(this);
    long l1 = 0L;
    long l2 = 100L;
    localTimer.schedule(local7, l1, l2);
    AutoCompleteTextView localAutoCompleteTextView = this.webetSearch;
    Object localObject = new com/removed/fragment/Home_Search_webview$8;
    ((Home_Search_webview.8)localObject).<init>(this);
    localAutoCompleteTextView.setOnKeyListener((View.OnKeyListener)localObject);
    localAutoCompleteTextView = this.webetSearch;
    localObject = new com/removed/fragment/Home_Search_webview$9;
    ((Home_Search_webview.9)localObject).<init>(this);
    localAutoCompleteTextView.addTextChangedListener((TextWatcher)localObject);
    localAutoCompleteTextView = this.webetSearch;
    localObject = new com/removed/fragment/Home_Search_webview$10;
    ((Home_Search_webview.10)localObject).<init>(this);
    localAutoCompleteTextView.setOnItemClickListener((AdapterView.OnItemClickListener)localObject);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool2 = true;
    int i = 2130903113;
    boolean bool1 = false;
    View localView = paramLayoutInflater.inflate(i, paramViewGroup, bool1);
    i = 2131099752;
    Object localObject1 = localView.findViewById(i);
    localObject1 = (WebView)localObject1;
    this.searchwebview = ((WebView)localObject1);
    int j = 2131099748;
    Object localObject2 = localView.findViewById(j);
    localObject2 = (AutoCompleteTextView)localObject2;
    this.webetSearch = ((AutoCompleteTextView)localObject2);
    int k = 2131099750;
    Object localObject3 = localView.findViewById(k);
    localObject3 = (ImageView)localObject3;
    this.search_delete = ((ImageView)localObject3);
    localObject3 = this.webetSearch;
    int n = 2131361808;
    ((AutoCompleteTextView)localObject3).setTextColor(n);
    int m = 2131099749;
    Object localObject4 = localView.findViewById(m);
    localObject4 = (Button)localObject4;
    this.webbtnSearch = ((Button)localObject4);
    init(localView);
    getAutoCompleteTextView();
    localObject4 = this.searchwebview;
    WebSettings localWebSettings = ((WebView)localObject4).getSettings();
    localWebSettings.setJavaScriptEnabled(bool2);
    localWebSettings.setDomStorageEnabled(bool2);
    long l = 8388608L;
    localWebSettings.setAppCacheMaxSize(l);
    String str = this.filePath;
    localWebSettings.setAppCachePath(str);
    localWebSettings.setAllowFileAccess(bool2);
    localWebSettings.setAppCacheEnabled(bool2);
    Object localObject5 = this.searchwebview;
    Object localObject6 = this.url;
    ((WebView)localObject5).loadUrl((String)localObject6);
    localObject5 = new com/removed/fragment/Home_Search_webview$Mywebview;
    ((Home_Search_webview.Mywebview)localObject5).<init>(this);
    this.webviewclient = ((Home_Search_webview.Mywebview)localObject5);
    localObject5 = this.searchwebview;
    localObject6 = this.webviewclient;
    ((WebView)localObject5).setWebViewClient((WebViewClient)localObject6);
    localObject5 = this.webbtnSearch;
    localObject6 = new com/removed/fragment/Home_Search_webview$3;
    ((Home_Search_webview.3)localObject6).<init>(this);
    ((Button)localObject5).setOnClickListener((View.OnClickListener)localObject6);
    localObject5 = this.search_delete;
    localObject6 = new com/removed/fragment/Home_Search_webview$4;
    ((Home_Search_webview.4)localObject6).<init>(this);
    ((ImageView)localObject5).setOnClickListener((View.OnClickListener)localObject6);
    localObject5 = this.webetSearch;
    localObject6 = new com/removed/fragment/Home_Search_webview$5;
    ((Home_Search_webview.5)localObject6).<init>(this);
    ((AutoCompleteTextView)localObject5).setOnClickListener((View.OnClickListener)localObject6);
    return localView;
  }

  public void onPause()
  {
    super.onPause();
    Activity localActivity = getActivity();
    MobclickAgent.onPause(localActivity);
  }

  public void onResume()
  {
    int i = MyUtils.hot_keyword_count;
    if (i > 0)
      change_search_keyword();
    Object localObject = this.searchwebview;
    String str = "javascript:load_search_history()";
    ((WebView)localObject).loadUrl(str);
    localObject = "search/view/";
    MyUtils.ga_tongji((String)localObject);
    localObject = getActivity();
    MobclickAgent.onResume((Context)localObject);
    super.onResume();
  }
}

/* Location:           /home/gagan/Desktop/Output2/Lemon/retargeted/com.lemonhq/
 * Qualified Name:     com.removed.fragment.Home_Search_webview
 * JD-Core Version:    0.6.2
 */
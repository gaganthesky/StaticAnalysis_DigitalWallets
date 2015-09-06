package com.paypal.android.p2pmobile.fragment.wallet;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.account.model.GiftProgram;
import com.paypal.android.foundation.account.model.Merchant;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.adapters.GiftCardMerchantAdapter;
import com.paypal.android.p2pmobile.core.AppContext;
import com.paypal.android.p2pmobile.core.AppIntentFactory.GiftCardOperation;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.managers.GiftCardManager;
import com.paypal.android.p2pmobile.utils.SearchUtils;
import com.paypal.android.p2pmobile.utils.ViewUtility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GiftCardSearchFragment extends BaseFragment
{
  private static final DebugLogger L = (DebugLogger)localObject;
  private int mBatch;
  private View mEmptySearch;
  private GiftCardMerchantAdapter mGiftCardMerchantAdapter;
  private ListView mMerchantListView;
  private String mQuery;
  private View mRoot;
  private boolean mSearchMode;
  private SearchView mSearchView;

  static
  {
    Object localObject = GiftCardSearchFragment.class;
    localObject = DebugLogger.getLogger((Class)localObject);
  }

  public void doProgramSearch(String paramString, boolean paramBoolean)
  {
    int j = 0;
    View localView = this.mRoot;
    int i = 2131428118;
    ViewUtility.showOrHide(localView, i, j);
    this.mQuery = paramString;
    boolean bool1 = TextUtils.isEmpty(paramString);
    HashMap localHashMap;
    Object localObject2;
    if (!bool1)
    {
      bool1 = true;
      this.mSearchMode = bool1;
      List localList1 = search(paramString);
      bool1 = localList1.isEmpty();
      showOrHideNoMatchesFound(bool1);
      localHashMap = new java/util/HashMap;
      localHashMap.<init>();
      bool1 = TextUtils.isEmpty(paramString);
      if (!bool1)
      {
        String str = "insr";
        localHashMap.put(str, paramString);
      }
      boolean bool2 = localList1.isEmpty();
      if (bool2)
      {
        localObject2 = TrackPage.Point.GiftCardSearchNoResult;
        PayPalApp.logPageView((TrackPage.Point)localObject2, localHashMap);
        localObject2 = this.mMerchantListView;
        Object localObject1 = ((ListView)localObject2).getAdapter();
        localObject1 = (GiftCardMerchantAdapter)localObject1;
        if (localObject1 == null)
        {
          localObject1 = setupAdapter(localList1);
          localObject2 = this.mMerchantListView;
          ((ListView)localObject2).setAdapter((ListAdapter)localObject1);
        }
        ((GiftCardMerchantAdapter)localObject1).setItems(localList1);
        ((GiftCardMerchantAdapter)localObject1).notifyDataSetChanged();
      }
    }
    while (true)
    {
      return;
      localObject2 = TrackPage.Point.GiftCardSearchResult;
      PayPalApp.logPageView((TrackPage.Point)localObject2, localHashMap);
      break;
      this.mSearchMode = j;
      this.mBatch = j;
      localObject2 = getGiftCardManager();
      i = this.mBatch;
      List localList2 = ((GiftCardManager)localObject2).getGiftCardPrograms(i);
      boolean bool3 = localList2.isEmpty();
      if (bool3)
      {
        localObject3 = this.mRoot;
        i = 2131428119;
        Object localObject4 = getResources();
        int k = 2131494964;
        localObject4 = ((Resources)localObject4).getString(k);
        ViewUtility.setText((View)localObject3, i, (CharSequence)localObject4);
      }
      Object localObject3 = this.mMerchantListView;
      GiftCardMerchantAdapter localGiftCardMerchantAdapter = setupAdapter(localList2);
      ((ListView)localObject3).setAdapter(localGiftCardMerchantAdapter);
    }
  }

  private GiftCardManager getGiftCardManager()
  {
    Object localObject = PayPalApp.getApp();
    FragmentActivity localFragmentActivity = getActivity();
    localObject = ((PayPalApp)localObject).getGiftCardManager(localFragmentActivity);
    return localObject;
  }

  private GiftCardSearchFragment.OnGiftCardSearchFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (GiftCardSearchFragment.OnGiftCardSearchFragmentListener)localObject;
    return localObject;
  }

  private void loadMorePrograms()
  {
    populateProgramListView();
  }

  private void modifySearchDialog(Menu paramMenu)
  {
    int i3 = 2130837922;
    boolean bool = false;
    FragmentActivity localFragmentActivity = getActivity();
    Object localObject8 = "search";
    Object localObject4 = localFragmentActivity.getSystemService((String)localObject8);
    localObject4 = (SearchManager)localObject4;
    int i = 2131428948;
    MenuItem localMenuItem = paramMenu.findItem(i);
    Object localObject6 = MenuItemCompat.getActionView(localMenuItem);
    localObject6 = (SearchView)localObject6;
    this.mSearchView = ((SearchView)localObject6);
    localObject6 = this.mQuery;
    if (localObject6 != null)
    {
      localObject6 = this.mSearchView;
      localObject8 = this.mQuery;
      ((SearchView)localObject6).setQuery((CharSequence)localObject8, bool);
    }
    localObject6 = this.mSearchView;
    ((SearchView)localObject6).setIconifiedByDefault(bool);
    localObject6 = this.mSearchView;
    localObject8 = new com/paypal/android/p2pmobile/fragment/wallet/GiftCardSearchFragment$3;
    ((GiftCardSearchFragment.3)localObject8).<init>(this);
    ((SearchView)localObject6).setOnQueryTextListener((SearchView.OnQueryTextListener)localObject8);
    localObject6 = this.mSearchView;
    if (localObject6 != null)
    {
      localObject6 = this.mSearchView;
      localObject6 = ((SearchView)localObject6).getContext();
      if (localObject6 != null)
      {
        int j = Build.VERSION.SDK_INT;
        int i1 = 11;
        if (j >= i1)
        {
          localObject7 = this.mSearchView;
          Object localObject9 = getActivity();
          localObject9 = ((FragmentActivity)localObject9).getComponentName();
          localObject9 = ((SearchManager)localObject4).getSearchableInfo((ComponentName)localObject9);
          ((SearchView)localObject7).setSearchableInfo((SearchableInfo)localObject9);
        }
        Object localObject7 = this.mSearchView;
        localObject7 = ((SearchView)localObject7).getContext();
        Resources localResources1 = ((Context)localObject7).getResources();
        if (localResources1 != null)
        {
          localObject7 = this.mSearchView;
          int i2 = 2131427480;
          Object localObject5 = ((SearchView)localObject7).findViewById(i2);
          localObject5 = (EditText)localObject5;
          if (localObject5 != null)
          {
            localObject7 = AppContext.getRobotoLight();
            ((EditText)localObject5).setTypeface((Typeface)localObject7);
            localObject7 = getResources();
            i2 = 2131230778;
            int k = ((Resources)localObject7).getColor(i2);
            ((EditText)localObject5).setTextColor(k);
            Resources localResources2 = getResources();
            i2 = 2131231099;
            int m = localResources2.getColor(i2);
            ((EditText)localObject5).setHintTextColor(m);
            m = 2131494954;
            ((EditText)localObject5).setHint(m);
            m = 3;
            ((EditText)localObject5).setImeOptions(m);
          }
          SearchView localSearchView = this.mSearchView;
          i2 = 2131427476;
          Object localObject2 = localSearchView.findViewById(i2);
          localObject2 = (ImageView)localObject2;
          if (localObject2 != null)
            ((ImageView)localObject2).setImageResource(i3);
          localSearchView = this.mSearchView;
          i2 = 2131427478;
          Object localObject3 = localSearchView.findViewById(i2);
          localObject3 = (ImageView)localObject3;
          if (localObject3 != null)
            ((ImageView)localObject3).setImageResource(i3);
          localSearchView = this.mSearchView;
          i2 = 2131427481;
          Object localObject1 = localSearchView.findViewById(i2);
          localObject1 = (ImageView)localObject1;
          if (localObject1 != null)
          {
            int n = 2130838124;
            ((ImageView)localObject1).setImageResource(n);
          }
        }
      }
    }
  }

  public static GiftCardSearchFragment newInstance()
  {
    GiftCardSearchFragment localGiftCardSearchFragment = new com/paypal/android/p2pmobile/fragment/wallet/GiftCardSearchFragment;
    localGiftCardSearchFragment.<init>();
    return localGiftCardSearchFragment;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    boolean bool = true;
    setHasOptionsMenu(bool);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      String str = "mQuery";
      str = paramBundle.getString(str);
      this.mQuery = str;
    }
    int i = 0;
    this.mBatch = i;
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    Object localObject = getActivity();
    localObject = ((FragmentActivity)localObject).getMenuInflater();
    int i = 2131689475;
    ((MenuInflater)localObject).inflate(i, paramMenu);
    modifySearchDialog(paramMenu);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool2 = false;
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    DebugLogger localDebugLogger = L;
    String str = "Creating Gift search fragment";
    Object[] arrayOfObject = new Object[bool2];
    localDebugLogger.debug(str, arrayOfObject);
    boolean bool1 = true;
    subscribeToWalletOperationBroadcasts(bool1);
    TrackPage.Point localPoint = TrackPage.Point.GiftCardSearchMain;
    setTrackPage(localPoint);
    int i = 2130903230;
    Object localObject1 = paramLayoutInflater.inflate(i, paramViewGroup, bool2);
    this.mRoot = ((View)localObject1);
    localObject1 = this.mRoot;
    if (localObject1 == null);
    for (localObject1 = null; ; localObject1 = this.mRoot)
    {
      return localObject1;
      localObject1 = this.mRoot;
      int j = 2131427996;
      localObject1 = ((View)localObject1).findViewById(j);
      localObject1 = (ListView)localObject1;
      this.mMerchantListView = ((ListView)localObject1);
      localObject1 = this.mRoot;
      j = 2131428116;
      localObject1 = ((View)localObject1).findViewById(j);
      this.mEmptySearch = ((View)localObject1);
      localObject1 = this.mMerchantListView;
      Object localObject2 = this.mEmptySearch;
      ((ListView)localObject1).setEmptyView((View)localObject2);
      localObject1 = this.mMerchantListView;
      localObject2 = new com/paypal/android/p2pmobile/fragment/wallet/GiftCardSearchFragment$1;
      ((GiftCardSearchFragment.1)localObject2).<init>(this);
      ((ListView)localObject1).setOnScrollListener((AbsListView.OnScrollListener)localObject2);
      localObject1 = this.mMerchantListView;
      localObject2 = new com/paypal/android/p2pmobile/fragment/wallet/GiftCardSearchFragment$2;
      ((GiftCardSearchFragment.2)localObject2).<init>(this);
      ((ListView)localObject1).setOnItemClickListener((AdapterView.OnItemClickListener)localObject2);
    }
  }

  protected void onGiftCardOperation(AppIntentFactory.GiftCardOperation paramGiftCardOperation, Intent paramIntent)
  {
    int n = 2131428119;
    int m = 2131428118;
    boolean bool = false;
    int[] arrayOfInt = GiftCardSearchFragment.4.$SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$GiftCardOperation;
    int j = paramGiftCardOperation.ordinal();
    int i = arrayOfInt[j];
    switch (i)
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      View localView = this.mRoot;
      ViewUtility.showOrHide(localView, m, bool);
      populateProgramListView();
      continue;
      localView = this.mRoot;
      ViewUtility.showOrHide(localView, m, bool);
      localView = this.mRoot;
      ViewUtility.showOrHide(localView, n, bool);
      localView = this.mRoot;
      Object localObject = getResources();
      int k = 2131494964;
      localObject = ((Resources)localObject).getString(k);
      ViewUtility.setText(localView, n, (CharSequence)localObject);
    }
  }

  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean)
    {
      String str1 = this.mQuery;
      if (str1 != null)
      {
        str1 = this.mQuery;
        int i = str1.length();
        if (i > 0)
        {
          String str2 = this.mQuery;
          boolean bool = true;
          doProgramSearch(str2, bool);
        }
      }
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    String str1 = this.mQuery;
    if (str1 != null)
    {
      str1 = "mQuery";
      String str2 = this.mQuery;
      paramBundle.putString(str1, str2);
    }
  }

  private void populateProgramListView()
  {
    boolean bool1 = this.mSearchMode;
    List localList;
    int i;
    label54: Object localObject1;
    if (bool1)
    {
      GiftCardManager localGiftCardManager = getGiftCardManager();
      localList = localGiftCardManager.getGiftCardPrograms();
      boolean bool2 = this.mSearchMode;
      if (!bool2)
        break label114;
      String str = this.mQuery;
      if (str == null)
        break label109;
      str = this.mQuery;
      int j = str.length();
      if (j <= 0)
        break label109;
      i = 1;
      if (i != 0)
      {
        localObject1 = this.mQuery;
        localList = search((String)localObject1);
      }
      localObject1 = this.mMerchantListView;
      GiftCardMerchantAdapter localGiftCardMerchantAdapter1 = setupAdapter(localList);
      ((ListView)localObject1).setAdapter(localGiftCardMerchantAdapter1);
    }
    while (true)
    {
      return;
      localObject1 = getGiftCardManager();
      int m = this.mBatch;
      localList = ((GiftCardManager)localObject1).getGiftCardPrograms(m);
      break;
      label109: i = 0;
      break label54;
      label114: int k = this.mBatch;
      Object localObject2;
      if (k == 0)
      {
        localObject2 = this.mMerchantListView;
        GiftCardMerchantAdapter localGiftCardMerchantAdapter2 = setupAdapter(localList);
        ((ListView)localObject2).setAdapter(localGiftCardMerchantAdapter2);
      }
      else
      {
        localObject2 = this.mGiftCardMerchantAdapter;
        ((GiftCardMerchantAdapter)localObject2).addAllItems(localList);
      }
    }
  }

  private List<GiftProgram> search(String paramString)
  {
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    GiftCardManager localGiftCardManager = getGiftCardManager();
    Object localObject2 = localGiftCardManager.getGiftCardPrograms();
    paramString = paramString.trim();
    boolean bool1 = TextUtils.isEmpty(paramString);
    if (bool1);
    while (true)
    {
      return localObject2;
      paramString = paramString.toLowerCase();
      Iterator localIterator = ((List)localObject2).iterator();
      while (true)
      {
        bool1 = localIterator.hasNext();
        if (!bool1)
          break;
        Object localObject1 = localIterator.next();
        localObject1 = (GiftProgram)localObject1;
        Merchant localMerchant = ((GiftProgram)localObject1).getIssuingMerchant();
        String str1 = localMerchant.getName();
        String str2 = ((GiftProgram)localObject1).getName();
        int i = paramString.length();
        int j = 1;
        if (i == j)
        {
          boolean bool2 = SearchUtils.matchesFirstCharacter(str1, paramString);
          if (!bool2)
          {
            bool2 = SearchUtils.matchesFirstCharacter(str2, paramString);
            if (!bool2);
          }
          else
          {
            localArrayList.add(localObject1);
          }
        }
        else
        {
          if (str1 != null)
          {
            String str3 = str1.toLowerCase();
            boolean bool3 = str3.contains(paramString);
            if (bool3);
          }
          else
          {
            if (str2 == null)
              continue;
            String str4 = str2.toLowerCase();
            boolean bool4 = str4.contains(paramString);
            if (!bool4)
              continue;
          }
          localArrayList.add(localObject1);
        }
      }
      localObject2 = localArrayList;
    }
  }

  private GiftCardMerchantAdapter setupAdapter(List<GiftProgram> paramList)
  {
    GiftCardMerchantAdapter localGiftCardMerchantAdapter = new com/paypal/android/p2pmobile/adapters/GiftCardMerchantAdapter;
    FragmentActivity localFragmentActivity = getActivity();
    localGiftCardMerchantAdapter.<init>(localFragmentActivity, paramList);
    this.mGiftCardMerchantAdapter = localGiftCardMerchantAdapter;
    localGiftCardMerchantAdapter = this.mGiftCardMerchantAdapter;
    return localGiftCardMerchantAdapter;
  }

  private void showOrHideNoMatchesFound(boolean paramBoolean)
  {
    View localView1 = this.mRoot;
    int j = 2131428117;
    ViewUtility.showOrHide(localView1, j, paramBoolean);
    localView1 = this.mRoot;
    j = 2131428120;
    ViewUtility.showOrHide(localView1, j, paramBoolean);
    View localView3 = this.mRoot;
    int m = 2131428119;
    if (!paramBoolean);
    int i;
    for (boolean bool = true; ; i = 0)
    {
      ViewUtility.showOrHide(localView3, m, bool);
      View localView2 = this.mRoot;
      int k = 2131428121;
      ViewUtility.showOrHide(localView2, k, paramBoolean);
      localView2 = this.mRoot;
      k = 2131428122;
      ViewUtility.showOrHide(localView2, k, paramBoolean);
      return;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.GiftCardSearchFragment
 * JD-Core Version:    0.6.2
 */
package com.paypal.android.p2pmobile.fragment.wallet;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
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
import com.ebay.redlasersdk.BarcodeResult;
import com.paypal.android.base.server.tracking.TrackPage.Link;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.account.model.LoyaltyProgram;
import com.paypal.android.foundation.account.model.Merchant;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.adapters.LoyaltyCardMerchantAdapter;
import com.paypal.android.p2pmobile.core.AppContext;
import com.paypal.android.p2pmobile.core.AppIntentFactory.LoyaltyCardOperation;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.services.ILoyaltyCardService;
import com.paypal.android.p2pmobile.services.LoyaltyCardService;
import com.paypal.android.p2pmobile.utils.ViewUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoyaltyCardSearchFragment extends BaseFragment
{
  private static final DebugLogger L = (DebugLogger)localObject;
  protected static final int SCAN_REQUEST_ID_ADD_LOYALTY_CARD = 1;
  private int mBatch;
  private View mEmptySearch;
  private boolean mIsBoundToLoyaltyCardService;
  private boolean mIsSearchViewSearch;
  private LoyaltyCardMerchantAdapter mLoyaltyCardMerchantAdapter;
  private ILoyaltyCardService mLoyaltyCardService;
  private ServiceConnection mLoyaltyCardServiceConnection;
  private ListView mMerchantListView;
  String mPromoCode;
  private String mQuery;
  private View mRoot;
  private boolean mSearchMode;
  private SearchView mSearchView;

  static
  {
    Object localObject = LoyaltyCardSearchFragment.class;
    localObject = DebugLogger.getLogger((Class)localObject);
  }

  public LoyaltyCardSearchFragment()
  {
    boolean bool = true;
    this.mIsSearchViewSearch = bool;
    this.mBatch = i;
    this.mSearchMode = i;
    LoyaltyCardSearchFragment.4 local4 = null;
    this.mPromoCode = local4;
    local4 = new com/paypal/android/p2pmobile/fragment/wallet/LoyaltyCardSearchFragment$4;
    local4.<init>(this);
    this.mLoyaltyCardServiceConnection = local4;
  }

  private void bindToLoyaltyCardService()
  {
    Intent localIntent = new android/content/Intent;
    FragmentActivity localFragmentActivity = getActivity();
    Object localObject = LoyaltyCardService.class;
    localIntent.<init>(localFragmentActivity, (Class)localObject);
    localFragmentActivity = getActivity();
    localObject = this.mLoyaltyCardServiceConnection;
    int i = 1;
    boolean bool = localFragmentActivity.bindService(localIntent, (ServiceConnection)localObject, i);
    this.mIsBoundToLoyaltyCardService = bool;
  }

  public void doProgramSearch(String paramString, boolean paramBoolean)
  {
    int j = 0;
    View localView1 = this.mRoot;
    int i = 2131428118;
    ViewUtility.showOrHide(localView1, i, j);
    this.mQuery = paramString;
    this.mIsSearchViewSearch = paramBoolean;
    boolean bool1 = TextUtils.isEmpty(paramString);
    Object localObject2;
    if (!bool1)
    {
      bool1 = true;
      this.mSearchMode = bool1;
      List localList = search(paramString);
      View localView2 = this.mRoot;
      i = 2131428239;
      j = localList.isEmpty();
      ViewUtility.showOrHide(localView2, i, j);
      boolean bool2 = localList.isEmpty();
      if (bool2)
      {
        localObject2 = TrackPage.Point.LoyaltyCardSearchNoResult;
        PayPalApp.logPageView((TrackPage.Point)localObject2);
        localObject2 = this.mMerchantListView;
        Object localObject1 = ((ListView)localObject2).getAdapter();
        localObject1 = (LoyaltyCardMerchantAdapter)localObject1;
        if (localObject1 == null)
        {
          localObject1 = setupAdapter(localList);
          localObject2 = this.mMerchantListView;
          ((ListView)localObject2).setAdapter((ListAdapter)localObject1);
        }
        ((LoyaltyCardMerchantAdapter)localObject1).setItems(localList);
        ((LoyaltyCardMerchantAdapter)localObject1).notifyDataSetChanged();
      }
    }
    while (true)
    {
      return;
      localObject2 = TrackPage.Point.LoyaltyCardSearchResult;
      PayPalApp.logPageView((TrackPage.Point)localObject2);
      break;
      this.mSearchMode = j;
      this.mBatch = j;
      localObject2 = this.mLoyaltyCardService;
      if (localObject2 != null)
      {
        localObject2 = this.mMerchantListView;
        Object localObject3 = this.mLoyaltyCardService;
        int k = this.mBatch;
        localObject3 = ((ILoyaltyCardService)localObject3).getLoyaltyPrograms(k);
        localObject3 = setupAdapter((List)localObject3);
        ((ListView)localObject2).setAdapter((ListAdapter)localObject3);
      }
    }
  }

  private LoyaltyCardSearchFragment.OnLoyaltyCardSearchFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (LoyaltyCardSearchFragment.OnLoyaltyCardSearchFragmentListener)localObject;
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
    localObject8 = new com/paypal/android/p2pmobile/fragment/wallet/LoyaltyCardSearchFragment$3;
    ((LoyaltyCardSearchFragment.3)localObject8).<init>(this);
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
            m = 2131494923;
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

  public static LoyaltyCardSearchFragment newInstance()
  {
    LoyaltyCardSearchFragment localLoyaltyCardSearchFragment = new com/paypal/android/p2pmobile/fragment/wallet/LoyaltyCardSearchFragment;
    localLoyaltyCardSearchFragment.<init>();
    return localLoyaltyCardSearchFragment;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    boolean bool = true;
    setHasOptionsMenu(bool);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject5 = null;
    int k = 0;
    int i = 1;
    Object localObject4;
    LoyaltyProgram localLoyaltyProgram;
    Object localObject3;
    if (i == paramInt1)
    {
      i = -1;
      if (i != paramInt2)
        break label253;
      String str4 = "com.ebay.redlasersdk.results";
      ArrayList localArrayList = paramIntent.getParcelableArrayListExtra(str4);
      if (localArrayList != null)
      {
        boolean bool1 = localArrayList.isEmpty();
        if (!bool1)
        {
          Object localObject1 = localArrayList.get(k);
          localObject1 = (BarcodeResult)localObject1;
          String str1 = ((BarcodeResult)localObject1).barcodeString;
          localObject1 = localArrayList.get(k);
          localObject1 = (BarcodeResult)localObject1;
          int j = ((BarcodeResult)localObject1).barcodeType;
          String str2 = String.valueOf(j);
          Object localObject2 = "promo_code";
          String str3 = paramIntent.getStringExtra((String)localObject2);
          localObject2 = L;
          localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>();
          localObject5 = "item promotion code: ";
          localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
          localObject4 = ((StringBuilder)localObject4).append(str3);
          localObject4 = ((StringBuilder)localObject4).toString();
          localObject5 = new Object[k];
          ((DebugLogger)localObject2).debug((String)localObject4, (Object[])localObject5);
          localObject2 = this.mLoyaltyCardService;
          localObject4 = this.mPromoCode;
          localLoyaltyProgram = ((ILoyaltyCardService)localObject2).getLoyaltyProgram((String)localObject4);
          boolean bool2 = localLoyaltyProgram.isUserParticipating();
          if (!bool2)
          {
            localObject3 = getLocalListener();
            ((LoyaltyCardSearchFragment.OnLoyaltyCardSearchFragmentListener)localObject3).onLoyaltyProgramAdd(localLoyaltyProgram, str1, str2);
            localObject3 = TrackPage.Point.LoyaltyCardAddCardAddScan;
            localObject4 = TrackPage.Link.Scan;
            PayPalApp.logLinkPress((TrackPage.Point)localObject3, (TrackPage.Link)localObject4);
          }
        }
      }
    }
    while (true)
    {
      return;
      label253: if (paramInt2 == 0)
      {
        localObject3 = this.mLoyaltyCardService;
        localObject4 = this.mPromoCode;
        localLoyaltyProgram = ((ILoyaltyCardService)localObject3).getLoyaltyProgram((String)localObject4);
        boolean bool3 = localLoyaltyProgram.isUserParticipating();
        if (!bool3)
        {
          LoyaltyCardSearchFragment.OnLoyaltyCardSearchFragmentListener localOnLoyaltyCardSearchFragmentListener = getLocalListener();
          localOnLoyaltyCardSearchFragmentListener.onLoyaltyProgramAdd(localLoyaltyProgram, (String)localObject5, (String)localObject5);
        }
      }
    }
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
    TrackPage.Point localPoint = TrackPage.Point.LoyaltyCardSelectMerchant;
    setTrackPage(localPoint);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    Object localObject = getActivity();
    localObject = ((FragmentActivity)localObject).getMenuInflater();
    int i = 2131689478;
    ((MenuInflater)localObject).inflate(i, paramMenu);
    modifySearchDialog(paramMenu);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool2 = false;
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    DebugLogger localDebugLogger = L;
    String str = "Creating loyalty search fragment";
    Object[] arrayOfObject = new Object[bool2];
    localDebugLogger.debug(str, arrayOfObject);
    boolean bool1 = true;
    subscribeToWalletOperationBroadcasts(bool1);
    int i = 2130903265;
    Object localObject1 = paramLayoutInflater.inflate(i, paramViewGroup, bool2);
    this.mRoot = ((View)localObject1);
    localObject1 = this.mRoot;
    if (localObject1 != null)
    {
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
      localObject2 = new com/paypal/android/p2pmobile/fragment/wallet/LoyaltyCardSearchFragment$1;
      ((LoyaltyCardSearchFragment.1)localObject2).<init>(this);
      ((ListView)localObject1).setOnScrollListener((AbsListView.OnScrollListener)localObject2);
      localObject1 = this.mMerchantListView;
      localObject2 = new com/paypal/android/p2pmobile/fragment/wallet/LoyaltyCardSearchFragment$2;
      ((LoyaltyCardSearchFragment.2)localObject2).<init>(this);
      ((ListView)localObject1).setOnItemClickListener((AdapterView.OnItemClickListener)localObject2);
    }
    localObject1 = this.mRoot;
    return localObject1;
  }

  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
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

  protected void onLoyaltyCardOperation(AppIntentFactory.LoyaltyCardOperation paramLoyaltyCardOperation, Intent paramIntent)
  {
    int[] arrayOfInt = LoyaltyCardSearchFragment.5.$SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$LoyaltyCardOperation;
    int j = paramLoyaltyCardOperation.ordinal();
    int i = arrayOfInt[j];
    switch (i)
    {
    default:
    case 1:
    }
    while (true)
    {
      return;
      populateProgramListView();
    }
  }

  public void onPause()
  {
    unbindFromLoyaltyCardService();
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
    bindToLoyaltyCardService();
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
    label56: Object localObject1;
    if (bool1)
    {
      ILoyaltyCardService localILoyaltyCardService = this.mLoyaltyCardService;
      localList = localILoyaltyCardService.getLoyaltyPrograms();
      boolean bool2 = this.mSearchMode;
      if (!bool2)
        break label118;
      String str = this.mQuery;
      if (str == null)
        break label113;
      str = this.mQuery;
      int j = str.length();
      if (j <= 0)
        break label113;
      i = 1;
      if (i != 0)
      {
        localObject1 = this.mQuery;
        localList = search((String)localObject1);
      }
      localObject1 = this.mMerchantListView;
      LoyaltyCardMerchantAdapter localLoyaltyCardMerchantAdapter1 = setupAdapter(localList);
      ((ListView)localObject1).setAdapter(localLoyaltyCardMerchantAdapter1);
    }
    while (true)
    {
      return;
      localObject1 = this.mLoyaltyCardService;
      int m = this.mBatch;
      localList = ((ILoyaltyCardService)localObject1).getLoyaltyPrograms(m);
      break;
      label113: i = 0;
      break label56;
      label118: int k = this.mBatch;
      Object localObject2;
      if (k == 0)
      {
        localObject2 = this.mMerchantListView;
        LoyaltyCardMerchantAdapter localLoyaltyCardMerchantAdapter2 = setupAdapter(localList);
        ((ListView)localObject2).setAdapter(localLoyaltyCardMerchantAdapter2);
      }
      else
      {
        localObject2 = this.mLoyaltyCardMerchantAdapter;
        ((LoyaltyCardMerchantAdapter)localObject2).addAllItems(localList);
      }
    }
  }

  private List<LoyaltyProgram> search(String paramString)
  {
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    ILoyaltyCardService localILoyaltyCardService = this.mLoyaltyCardService;
    List localList = localILoyaltyCardService.getLoyaltyPrograms();
    Iterator localIterator = localList.iterator();
    while (true)
    {
      boolean bool1 = localIterator.hasNext();
      if (!bool1)
        break;
      Object localObject1 = localIterator.next();
      localObject1 = (LoyaltyProgram)localObject1;
      Object localObject2 = ((LoyaltyProgram)localObject1).getMerchant();
      String str1 = ((Merchant)localObject2).getName();
      String str2 = ((LoyaltyProgram)localObject1).getName();
      String str4;
      if (str1 != null)
      {
        localObject2 = str1.toLowerCase();
        str4 = paramString.toLowerCase();
        boolean bool2 = ((String)localObject2).contains(str4);
        if (bool2);
      }
      else
      {
        if (str2 == null)
          continue;
        String str3 = str2.toLowerCase();
        str4 = paramString.toLowerCase();
        boolean bool3 = str3.contains(str4);
        if (!bool3)
          continue;
      }
      localArrayList.add(localObject1);
    }
    return localArrayList;
  }

  private LoyaltyCardMerchantAdapter setupAdapter(List<LoyaltyProgram> paramList)
  {
    LoyaltyCardMerchantAdapter localLoyaltyCardMerchantAdapter = new com/paypal/android/p2pmobile/adapters/LoyaltyCardMerchantAdapter;
    FragmentActivity localFragmentActivity = getActivity();
    localLoyaltyCardMerchantAdapter.<init>(localFragmentActivity, paramList);
    this.mLoyaltyCardMerchantAdapter = localLoyaltyCardMerchantAdapter;
    localLoyaltyCardMerchantAdapter = this.mLoyaltyCardMerchantAdapter;
    return localLoyaltyCardMerchantAdapter;
  }

  private void unbindFromLoyaltyCardService()
  {
    boolean bool1 = this.mIsBoundToLoyaltyCardService;
    if (bool1)
    {
      FragmentActivity localFragmentActivity = getActivity();
      ServiceConnection localServiceConnection = this.mLoyaltyCardServiceConnection;
      localFragmentActivity.unbindService(localServiceConnection);
      boolean bool2 = false;
      this.mIsBoundToLoyaltyCardService = bool2;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.LoyaltyCardSearchFragment
 * JD-Core Version:    0.6.2
 */
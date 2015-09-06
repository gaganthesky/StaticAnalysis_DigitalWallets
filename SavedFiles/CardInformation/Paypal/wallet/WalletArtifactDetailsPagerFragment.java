package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.account.model.Artifact;
import com.paypal.android.foundation.core.model.UniqueId;
import com.paypal.android.p2pmobile.activity.BaseActivity;
import com.paypal.android.p2pmobile.adapters.WalletArtifactDetailsPagerAdapter;
import com.paypal.android.p2pmobile.core.AppIntentFactory.WalletAction;
import com.paypal.android.p2pmobile.fragment.BaseFragment;

public class WalletArtifactDetailsPagerFragment extends BaseFragment
{
  private static final String BUNDLE_KEY_SELECTED_INDEX = "selected_index";
  private static final String BUNDLE_KEY_UNIQUE_ID = "unique_id";
  private static final String LOG_TAG = (String)localObject;
  private WalletArtifactDetailsPagerAdapter mAdapter;
  private ViewPager mPager;
  private int mSelectedIndex;
  private UniqueId mUniqueId;

  static
  {
    Object localObject = WalletArtifactDetailsPagerFragment.class;
    localObject = ((Class)localObject).getSimpleName();
  }

  public WalletArtifactDetailsPagerFragment()
  {
    int i = 0;
    this.mSelectedIndex = i;
    Object localObject = null;
    this.mUniqueId = localObject;
  }

  private final WalletArtifactDetailsPagerFragment.OnWalletArtifactDetailsPagerFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (WalletArtifactDetailsPagerFragment.OnWalletArtifactDetailsPagerFragmentListener)localObject;
    return localObject;
  }

  public static WalletArtifactDetailsPagerFragment newInstance(UniqueId paramUniqueId, int paramInt)
  {
    WalletArtifactDetailsPagerFragment localWalletArtifactDetailsPagerFragment = new com/paypal/android/p2pmobile/fragment/wallet/WalletArtifactDetailsPagerFragment;
    localWalletArtifactDetailsPagerFragment.<init>();
    Bundle localBundle = new android/os/Bundle;
    localBundle.<init>();
    String str = "selected_index";
    localBundle.putInt(str, paramInt);
    str = "unique_id";
    localBundle.putParcelable(str, paramUniqueId);
    localWalletArtifactDetailsPagerFragment.setArguments(localBundle);
    return localWalletArtifactDetailsPagerFragment;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    TrackPage.Point localPoint = TrackPage.Point.CardDetails;
    setTrackPage(localPoint);
    subscribeToWalletOperationBroadcasts(bool);
    int i = 2130903396;
    View localView = paramLayoutInflater.inflate(i, paramViewGroup, bool);
    i = 2131428108;
    Object localObject1 = localView.findViewById(i);
    localObject1 = (ViewPager)localObject1;
    this.mPager = ((ViewPager)localObject1);
    localObject1 = this.mPager;
    Object localObject3 = this.mAdapter;
    ((ViewPager)localObject1).setAdapter((PagerAdapter)localObject3);
    localObject1 = getArguments();
    localObject3 = "selected_index";
    int j = ((Bundle)localObject1).getInt((String)localObject3);
    this.mSelectedIndex = j;
    Object localObject2 = getArguments();
    localObject3 = "unique_id";
    localObject2 = ((Bundle)localObject2).getParcelable((String)localObject3);
    localObject2 = (UniqueId)localObject2;
    this.mUniqueId = ((UniqueId)localObject2);
    localObject2 = this.mPager;
    int k = this.mSelectedIndex;
    ((ViewPager)localObject2).setCurrentItem(k);
    return localView;
  }

  public void onDestroy()
  {
    WalletArtifactDetailsPagerAdapter localWalletArtifactDetailsPagerAdapter1 = this.mAdapter;
    if (localWalletArtifactDetailsPagerAdapter1 == null)
      super.onDestroy();
    while (true)
    {
      return;
      Object localObject = getActivity();
      boolean bool = localObject instanceof BaseActivity;
      if (bool)
      {
        localObject = (BaseActivity)localObject;
        bool = ((BaseActivity)localObject).isActivityDestroyed();
        if (!bool)
        {
          WalletArtifactDetailsPagerAdapter localWalletArtifactDetailsPagerAdapter2 = this.mAdapter;
          localWalletArtifactDetailsPagerAdapter2.clearOldSubFragments();
        }
      }
      super.onDestroy();
    }
  }

  public void onResume()
  {
    super.onResume();
    ViewPager localViewPager = this.mPager;
    WalletArtifactDetailsPagerAdapter localWalletArtifactDetailsPagerAdapter = this.mAdapter;
    localViewPager.setOnPageChangeListener(localWalletArtifactDetailsPagerAdapter);
  }

  protected void onWalletAction(AppIntentFactory.WalletAction paramWalletAction, Intent paramIntent)
  {
    int[] arrayOfInt = WalletArtifactDetailsPagerFragment.1.$SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletAction;
    int k = paramWalletAction.ordinal();
    int j = arrayOfInt[k];
    switch (j)
    {
    default:
    case 1:
    }
    while (true)
    {
      return;
      try
      {
        Object localObject = this.mPager;
        int i = ((ViewPager)localObject).getCurrentItem();
        localObject = this.mAdapter;
        Artifact localArtifact = ((WalletArtifactDetailsPagerAdapter)localObject).getArtifactAt(i);
        localObject = localArtifact.getUniqueId();
        this.mUniqueId = ((UniqueId)localObject);
        localObject = getLocalListener();
        UniqueId localUniqueId = this.mUniqueId;
        ((WalletArtifactDetailsPagerFragment.OnWalletArtifactDetailsPagerFragmentListener)localObject).onEditWalletArtifact(this, localUniqueId);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }

  public void setAdapter(WalletArtifactDetailsPagerAdapter paramWalletArtifactDetailsPagerAdapter)
  {
    this.mAdapter = paramWalletArtifactDetailsPagerAdapter;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WalletArtifactDetailsPagerFragment
 * JD-Core Version:    0.6.2
 */
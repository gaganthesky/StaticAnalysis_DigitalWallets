package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.paypal.android.foundation.account.AccountModel;
import com.paypal.android.foundation.account.model.PayPalSpecificBalance;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.p2pmobile.activity.BaseActivity;
import com.paypal.android.p2pmobile.adapters.PSBDetailsPagerAdapter;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import java.util.List;

public class PSBDetailPagerFragment extends BaseFragment
{
  private static final String BUNDLE_KEY_SELECTED_INDEX = "selected_index";
  private static final DebugLogger L = (DebugLogger)localObject;
  private PSBDetailsPagerAdapter mAdapter;
  private ViewPager mPager;
  private int mSelectedIndex;

  static
  {
    Object localObject = PSBDetailPagerFragment.class;
    localObject = DebugLogger.getLogger((Class)localObject);
  }

  public PSBDetailPagerFragment()
  {
    int i = 0;
    this.mSelectedIndex = i;
  }

  private final PSBDetailPagerFragment.OnPSBDetailPagerFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (PSBDetailPagerFragment.OnPSBDetailPagerFragmentListener)localObject;
    return localObject;
  }

  public static PSBDetailPagerFragment newInstance(int paramInt)
  {
    Object localObject = L;
    String str = "Creating new instance of PSBDetailPagerFragment";
    int i = 0;
    Object[] arrayOfObject = new Object[i];
    ((DebugLogger)localObject).debug(str, arrayOfObject);
    PSBDetailPagerFragment localPSBDetailPagerFragment = new com/paypal/android/p2pmobile/fragment/wallet/PSBDetailPagerFragment;
    localPSBDetailPagerFragment.<init>();
    Bundle localBundle = new android/os/Bundle;
    localBundle.<init>();
    localObject = "selected_index";
    localBundle.putInt((String)localObject, paramInt);
    localPSBDetailPagerFragment.setArguments(localBundle);
    return localPSBDetailPagerFragment;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 0);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    PSBDetailPagerFragment.OnPSBDetailPagerFragmentListener localOnPSBDetailPagerFragmentListener = getLocalListener();
    if (localOnPSBDetailPagerFragmentListener != null)
    {
      localOnPSBDetailPagerFragmentListener = getLocalListener();
      localOnPSBDetailPagerFragmentListener.stopProgressLoader();
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool = false;
    DebugLogger localDebugLogger = L;
    Object localObject2 = "Creating view for PSBDetailPagerFragment";
    Object localObject3 = new Object[bool];
    localDebugLogger.debug((String)localObject2, (Object[])localObject3);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    subscribeToWalletOperationBroadcasts(bool);
    int j = 2130903333;
    View localView = paramLayoutInflater.inflate(j, paramViewGroup, bool);
    j = 2131428674;
    Object localObject1 = localView.findViewById(j);
    localObject1 = (ViewPager)localObject1;
    this.mPager = ((ViewPager)localObject1);
    localObject1 = getArguments();
    localObject2 = "selected_index";
    int i = ((Bundle)localObject1).getInt((String)localObject2);
    localObject1 = L;
    localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    localObject3 = "onCreateView index:";
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
    localObject2 = ((StringBuilder)localObject2).append(i);
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject3 = new Object[bool];
    ((DebugLogger)localObject1).debug((String)localObject2, (Object[])localObject3);
    this.mSelectedIndex = i;
    localObject1 = this.mPager;
    int k = this.mSelectedIndex;
    ((ViewPager)localObject1).setCurrentItem(k);
    localObject1 = this.mPager;
    PSBDetailsPagerAdapter localPSBDetailsPagerAdapter = this.mAdapter;
    ((ViewPager)localObject1).setAdapter(localPSBDetailsPagerAdapter);
    updateAdapterItems();
    return localView;
  }

  public void onDestroy()
  {
    PSBDetailsPagerAdapter localPSBDetailsPagerAdapter1 = this.mAdapter;
    if (localPSBDetailsPagerAdapter1 != null)
    {
      Object localObject = getActivity();
      boolean bool = localObject instanceof BaseActivity;
      if (bool)
      {
        localObject = (BaseActivity)localObject;
        bool = ((BaseActivity)localObject).isActivityDestroyed();
        if (!bool)
        {
          PSBDetailsPagerAdapter localPSBDetailsPagerAdapter2 = this.mAdapter;
          localPSBDetailsPagerAdapter2.clearOldSubFragments();
        }
      }
    }
    super.onDestroy();
  }

  public void onPause()
  {
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
  }

  public void setAdapter(PSBDetailsPagerAdapter paramPSBDetailsPagerAdapter)
  {
    this.mAdapter = paramPSBDetailsPagerAdapter;
  }

  public void updateAdapterItems()
  {
    Object localObject1 = AccountModel.getInstance();
    Object localObject2 = PayPalSpecificBalance.class;
    List localList = ((AccountModel)localObject1).getArtifactsByType((Class)localObject2);
    if (localList == null);
    while (true)
    {
      return;
      localObject1 = this.mAdapter;
      setAdapter((PSBDetailsPagerAdapter)localObject1);
      localObject1 = this.mPager;
      localObject2 = this.mAdapter;
      ((ViewPager)localObject1).setOnPageChangeListener((ViewPager.OnPageChangeListener)localObject2);
      localObject1 = this.mAdapter;
      ((PSBDetailsPagerAdapter)localObject1).setItems(localList);
      localObject1 = this.mAdapter;
      ((PSBDetailsPagerAdapter)localObject1).notifyDataSetChanged();
      localObject1 = this.mPager;
      int i = this.mSelectedIndex;
      ((ViewPager)localObject1).setCurrentItem(i);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.PSBDetailPagerFragment
 * JD-Core Version:    0.6.2
 */
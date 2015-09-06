package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.paypal.android.foundation.account.model.LoyaltyCard;
import com.paypal.android.foundation.account.model.LoyaltyCard.Id;
import com.paypal.android.foundation.account.model.LoyaltyProgram;
import com.paypal.android.foundation.account.model.MutableBarcode;
import com.paypal.android.foundation.account.model.MutableLoyaltyCard;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.p2pmobile.activity.BaseActivity;
import com.paypal.android.p2pmobile.activity.BaseChoreographer;
import com.paypal.android.p2pmobile.activity.WalletActivity;
import com.paypal.android.p2pmobile.adapters.LoyaltyCardDetailsPagerAdapter;
import com.paypal.android.p2pmobile.core.AppIntentFactory.WalletAction;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.services.ILoyaltyCardService;
import com.paypal.android.p2pmobile.services.LoyaltyCardService;
import java.util.List;

public class LoyaltyCardDetailPagerFragment extends BaseFragment
{
  private static final String BUNDLE_KEY_SELECTED_INDEX = "selected_index";
  private static final DebugLogger L = (DebugLogger)localObject;
  private LoyaltyCardDetailsPagerAdapter mAdapter;
  private boolean mIsBoundToLoyaltyCardService;
  private ILoyaltyCardService mLoyaltyCardService;
  private ServiceConnection mLoyaltyCardServiceConnection;
  private ViewPager mPager;
  private int mSelectedIndex;
  private float mWindowBrightness;

  static
  {
    Object localObject = LoyaltyCardDetailPagerFragment.class;
    localObject = DebugLogger.getLogger((Class)localObject);
  }

  public LoyaltyCardDetailPagerFragment()
  {
    int i = 0;
    this.mSelectedIndex = i;
    LoyaltyCardDetailPagerFragment.1 local1 = new com/paypal/android/p2pmobile/fragment/wallet/LoyaltyCardDetailPagerFragment$1;
    local1.<init>(this);
    this.mLoyaltyCardServiceConnection = local1;
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

  private void deleteLoyaltyArtifact(Intent paramIntent)
  {
    ILoyaltyCardService localILoyaltyCardService = this.mLoyaltyCardService;
    if (localILoyaltyCardService != null)
    {
      int i = 2131494921;
      int j = 1;
      Object[] arrayOfObject = new Object[j];
      int k = 0;
      String str2 = "card";
      arrayOfObject[k] = str2;
      Object localObject = getString(i, arrayOfObject);
      showProgressDialog((String)localObject);
      localObject = "loyalty_card_name";
      String str1 = paramIntent.getStringExtra((String)localObject);
      localObject = this.mLoyaltyCardService;
      ((ILoyaltyCardService)localObject).deleteLoyaltyCard(str1);
    }
  }

  private final LoyaltyCardDetailPagerFragment.OnLoyaltyCardDetailPagerFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (LoyaltyCardDetailPagerFragment.OnLoyaltyCardDetailPagerFragmentListener)localObject;
    return localObject;
  }

  private void increaseWindowBrightness()
  {
    FragmentActivity localFragmentActivity = getActivity();
    Window localWindow = localFragmentActivity.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    float f = localLayoutParams.screenBrightness;
    this.mWindowBrightness = f;
    f = 1.0F;
    localLayoutParams.screenBrightness = f;
    localWindow.setAttributes(localLayoutParams);
  }

  public static LoyaltyCardDetailPagerFragment newInstance(int paramInt)
  {
    Object localObject = L;
    String str = "Creating new instance of LoyaltyCardDetailPagerFragment";
    int i = 0;
    Object[] arrayOfObject = new Object[i];
    ((DebugLogger)localObject).debug(str, arrayOfObject);
    LoyaltyCardDetailPagerFragment localLoyaltyCardDetailPagerFragment = new com/paypal/android/p2pmobile/fragment/wallet/LoyaltyCardDetailPagerFragment;
    localLoyaltyCardDetailPagerFragment.<init>();
    Bundle localBundle = new android/os/Bundle;
    localBundle.<init>();
    localObject = "selected_index";
    localBundle.putInt((String)localObject, paramInt);
    localLoyaltyCardDetailPagerFragment.setArguments(localBundle);
    return localLoyaltyCardDetailPagerFragment;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 0);
    while (true)
    {
      return;
      int i = 61;
      if (i == paramInt1)
      {
        Object localObject;
        if (paramIntent != null)
        {
          i = 1;
          if (i == paramInt2)
          {
            LoyaltyCardDetailPagerFragment.OnLoyaltyCardDetailPagerFragmentListener localOnLoyaltyCardDetailPagerFragmentListener = getLocalListener();
            localOnLoyaltyCardDetailPagerFragmentListener.startProgressLoader();
            deleteLoyaltyArtifact(paramIntent);
          }
          else
          {
            int j = 2;
            if (j == paramInt2)
            {
              localObject = getLocalListener();
              ((LoyaltyCardDetailPagerFragment.OnLoyaltyCardDetailPagerFragmentListener)localObject).startProgressLoader();
              updateLoyaltyArtifact(paramIntent);
            }
          }
        }
        else
        {
          localObject = L;
          String str = "Intent data is null for either delete or update for the loyalty service. Ignoring U/D operation";
          int k = 0;
          Object[] arrayOfObject = new Object[k];
          ((DebugLogger)localObject).error(str, arrayOfObject);
        }
      }
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bindToLoyaltyCardService();
    LoyaltyCardDetailPagerFragment.OnLoyaltyCardDetailPagerFragmentListener localOnLoyaltyCardDetailPagerFragmentListener = getLocalListener();
    localOnLoyaltyCardDetailPagerFragmentListener.stopProgressLoader();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool = false;
    DebugLogger localDebugLogger = L;
    String str = "Creating view for LoyaltyCardDetailPagerFragment";
    Object[] arrayOfObject = new Object[bool];
    localDebugLogger.debug(str, arrayOfObject);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    subscribeToWalletOperationBroadcasts(bool);
    int j = 2130903258;
    View localView = paramLayoutInflater.inflate(j, paramViewGroup, bool);
    j = 2131428108;
    Object localObject = localView.findViewById(j);
    localObject = (ViewPager)localObject;
    this.mPager = ((ViewPager)localObject);
    localObject = getArguments();
    str = "selected_index";
    int i = ((Bundle)localObject).getInt(str);
    this.mSelectedIndex = i;
    localObject = this.mPager;
    int k = this.mSelectedIndex;
    ((ViewPager)localObject).setCurrentItem(k);
    localObject = this.mPager;
    LoyaltyCardDetailsPagerAdapter localLoyaltyCardDetailsPagerAdapter = this.mAdapter;
    ((ViewPager)localObject).setAdapter(localLoyaltyCardDetailsPagerAdapter);
    return localView;
  }

  public void onDestroy()
  {
    LoyaltyCardDetailsPagerAdapter localLoyaltyCardDetailsPagerAdapter1 = this.mAdapter;
    if (localLoyaltyCardDetailsPagerAdapter1 != null)
    {
      Object localObject = getActivity();
      boolean bool = localObject instanceof BaseActivity;
      if (bool)
      {
        localObject = (BaseActivity)localObject;
        bool = ((BaseActivity)localObject).isActivityDestroyed();
        if (!bool)
        {
          LoyaltyCardDetailsPagerAdapter localLoyaltyCardDetailsPagerAdapter2 = this.mAdapter;
          localLoyaltyCardDetailsPagerAdapter2.clearOldSubFragments();
        }
      }
    }
    unbindFromLoyaltyCardService();
    super.onDestroy();
  }

  public void onPause()
  {
    super.onPause();
    resetWindowBrightness();
  }

  public void onResume()
  {
    super.onResume();
    increaseWindowBrightness();
  }

  protected void onWalletAction(AppIntentFactory.WalletAction paramWalletAction, Intent paramIntent)
  {
    int[] arrayOfInt = LoyaltyCardDetailPagerFragment.2.$SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletAction;
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
      boolean bool = this.mIsBoundToLoyaltyCardService;
      if (bool)
        try
        {
          localObject2 = this.mAdapter;
          int i = ((LoyaltyCardDetailsPagerAdapter)localObject2).getSelectedPosition();
          localObject2 = this.mLoyaltyCardService;
          localObject2 = ((ILoyaltyCardService)localObject2).getLoyaltyCards();
          Object localObject1 = ((List)localObject2).get(i);
          localObject1 = (LoyaltyCard)localObject1;
          localObject2 = getLocalListener();
          localObject3 = ((LoyaltyCard)localObject1).getUniqueId();
          localObject3 = ((LoyaltyCard.Id)localObject3).getValue();
          m = 61;
          ((LoyaltyCardDetailPagerFragment.OnLoyaltyCardDetailPagerFragmentListener)localObject2).onLoyaltyItemEdit(this, (String)localObject3, i, m);
        }
        catch (Exception localException)
        {
          Object localObject2 = L;
          Object localObject3 = "mIsBoundToLoyaltyCardService is false which means no service to bind to. Cannot perform edit";
          int m = 0;
          Object[] arrayOfObject = new Object[m];
          ((DebugLogger)localObject2).debug((String)localObject3, arrayOfObject);
        }
    }
  }

  private void resetWindowBrightness()
  {
    FragmentActivity localFragmentActivity = getActivity();
    Window localWindow = localFragmentActivity.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    float f = this.mWindowBrightness;
    localLayoutParams.screenBrightness = f;
    localWindow.setAttributes(localLayoutParams);
  }

  public void setAdapter(LoyaltyCardDetailsPagerAdapter paramLoyaltyCardDetailsPagerAdapter)
  {
    this.mAdapter = paramLoyaltyCardDetailsPagerAdapter;
  }

  private void showProgressDialog(String paramString)
  {
    Object localObject = getActivity();
    localObject = (WalletActivity)localObject;
    localObject = ((WalletActivity)localObject).getCurrentChoreograph();
    ((BaseChoreographer)localObject).showProgressDialog(paramString);
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
      Object localObject = null;
      this.mLoyaltyCardService = localObject;
    }
  }

  public void updateAdapterItems()
  {
    Object localObject = this.mLoyaltyCardService;
    List localList = ((ILoyaltyCardService)localObject).getLoyaltyCards();
    localObject = this.mAdapter;
    setAdapter((LoyaltyCardDetailsPagerAdapter)localObject);
    localObject = this.mPager;
    LoyaltyCardDetailsPagerAdapter localLoyaltyCardDetailsPagerAdapter = this.mAdapter;
    ((ViewPager)localObject).setOnPageChangeListener(localLoyaltyCardDetailsPagerAdapter);
    localObject = this.mAdapter;
    ((LoyaltyCardDetailsPagerAdapter)localObject).setItems(localList);
    localObject = this.mAdapter;
    ((LoyaltyCardDetailsPagerAdapter)localObject).notifyDataSetChanged();
    localObject = this.mPager;
    int i = this.mSelectedIndex;
    ((ViewPager)localObject).setCurrentItem(i);
  }

  private void updateLoyaltyArtifact(Intent paramIntent)
  {
    ILoyaltyCardService localILoyaltyCardService = this.mLoyaltyCardService;
    if (localILoyaltyCardService != null)
    {
      int i = 2131494941;
      Object localObject1 = getString(i);
      showProgressDialog((String)localObject1);
      localObject1 = "loyalty_card_name";
      String str1 = paramIntent.getStringExtra((String)localObject1);
      localObject1 = this.mLoyaltyCardService;
      LoyaltyCard localLoyaltyCard = ((ILoyaltyCardService)localObject1).getLoyaltyCard(str1);
      MutableLoyaltyCard localMutableLoyaltyCard = new com/paypal/android/foundation/account/model/MutableLoyaltyCard;
      localMutableLoyaltyCard.<init>(localLoyaltyCard);
      localObject1 = localLoyaltyCard.getLoyaltyProgram();
      boolean bool1 = ((LoyaltyProgram)localObject1).isBarcodeSupported();
      if (bool1)
      {
        String str4 = "loyalty_card_barcode_value";
        str3 = paramIntent.getStringExtra(str4);
        str4 = "loyalty_card_barcode_type";
        String str2 = paramIntent.getStringExtra(str4);
        boolean bool2 = TextUtils.isEmpty(str3);
        if (!bool2)
        {
          bool2 = TextUtils.isEmpty(str2);
          if (!bool2)
          {
            MutableBarcode localMutableBarcode = new com/paypal/android/foundation/account/model/MutableBarcode;
            localMutableBarcode.<init>();
            localMutableBarcode.setValue(str3);
            localMutableBarcode.setType(str2);
            localMutableLoyaltyCard.setBarcode(localMutableBarcode);
          }
        }
      }
      Object localObject2 = "loyalty_card_value";
      String str3 = paramIntent.getStringExtra((String)localObject2);
      localMutableLoyaltyCard.setCardNumber(str3);
      localObject2 = this.mLoyaltyCardService;
      ((ILoyaltyCardService)localObject2).updateLoyaltyCard(localMutableLoyaltyCard);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.LoyaltyCardDetailPagerFragment
 * JD-Core Version:    0.6.2
 */
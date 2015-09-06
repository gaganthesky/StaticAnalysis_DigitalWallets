package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.account.AccountModel;
import com.paypal.android.foundation.account.model.AccountBalance;
import com.paypal.android.foundation.account.model.AccountModelAvailability;
import com.paypal.android.foundation.account.model.Artifact;
import com.paypal.android.foundation.account.model.BankAccount;
import com.paypal.android.foundation.account.model.CredebitCard;
import com.paypal.android.foundation.account.model.CreditAccount;
import com.paypal.android.foundation.account.model.GiftCard;
import com.paypal.android.foundation.account.model.GiftCard.Id;
import com.paypal.android.foundation.account.model.GiftProgram;
import com.paypal.android.foundation.account.model.LoyaltyCard;
import com.paypal.android.foundation.account.model.PayPalSpecificBalance;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.foundation.core.message.FailureMessage;
import com.paypal.android.foundation.core.model.MoneyBalance;
import com.paypal.android.foundation.core.model.MoneyValue;
import com.paypal.android.foundation.core.model.MutableMoneyValue;
import com.paypal.android.foundation.core.model.UniqueId;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.adapters.WalletArtifactAdapter;
import com.paypal.android.p2pmobile.config.Config;
import com.paypal.android.p2pmobile.config.GiftCardConfig;
import com.paypal.android.p2pmobile.config.LoyaltyConfig;
import com.paypal.android.p2pmobile.config.PSBConfig;
import com.paypal.android.p2pmobile.core.AppContext;
import com.paypal.android.p2pmobile.core.AppIntentFactory;
import com.paypal.android.p2pmobile.core.AppIntentFactory.GiftCardOperation;
import com.paypal.android.p2pmobile.core.AppIntentFactory.LoyaltyCardOperation;
import com.paypal.android.p2pmobile.core.AppIntentFactory.WalletOperation;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.managers.GiftCardManager;
import com.paypal.android.p2pmobile.preferences.GlobalPreferences;
import com.paypal.android.p2pmobile.tracking.AdConversionManager;
import com.paypal.android.p2pmobile.tracking.AdConversionManager.Event;
import com.paypal.android.p2pmobile.tracking.GiftCardTrackingHelper;
import com.paypal.android.p2pmobile.utils.AccountModelUtil;
import com.paypal.android.p2pmobile.utils.FragmentUtils;
import com.paypal.android.p2pmobile.utils.ViewUtility;
import com.paypal.android.p2pmobile.widgets.ExpandableHeightGridView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WalletFragment extends BaseFragment
{
  private static final DebugLogger L;
  public static Comparator LoyaltyCardComparator = (Comparator)localObject;
  private ExpandableHeightGridView mBankAccountsGridView;
  private ExpandableHeightGridView mGiftCardsGridView;
  private ExpandableHeightGridView mLoyaltyCardsGridView;
  private ExpandableHeightGridView mPSBsGridView;
  private ExpandableHeightGridView mPaymentCardsGridView;
  private int[] mRobotoBoldIds;
  private int[] mRobotoLightIds;
  private View mView;

  static
  {
    Object localObject = WalletFragment.class;
    localObject = DebugLogger.getLogger((Class)localObject);
    L = (DebugLogger)localObject;
    localObject = new com/paypal/android/p2pmobile/fragment/wallet/WalletFragment$12;
    ((WalletFragment.12)localObject).<init>();
  }

  public WalletFragment()
  {
    int i = 3;
    int[] arrayOfInt1 = new int[i];
    arrayOfInt1[0] = 2131428042;
    arrayOfInt1[1] = 2131427913;
    arrayOfInt1[2] = 2131427914;
    this.mRobotoLightIds = arrayOfInt1;
    int j = 2;
    int[] arrayOfInt2 = new int[j];
    arrayOfInt2[0] = 2131428048;
    arrayOfInt2[1] = 2131428045;
    this.mRobotoBoldIds = arrayOfInt2;
  }

  private List<Artifact> getBankAccounts()
  {
    AccountModel localAccountModel = AccountModel.getInstance();
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    List localList = localAccountModel.getArtifacts();
    Iterator localIterator = localList.iterator();
    while (true)
    {
      boolean bool = localIterator.hasNext();
      if (!bool)
        break;
      Object localObject = localIterator.next();
      localObject = (Artifact)localObject;
      bool = localObject instanceof BankAccount;
      if (bool)
        localArrayList.add(localObject);
    }
    return localArrayList;
  }

  private List<Artifact> getCredebitAccounts()
  {
    AccountModel localAccountModel = AccountModel.getInstance();
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    List localList = localAccountModel.getArtifacts();
    Iterator localIterator = localList.iterator();
    while (true)
    {
      boolean bool = localIterator.hasNext();
      if (!bool)
        break;
      Object localObject = localIterator.next();
      localObject = (Artifact)localObject;
      bool = localObject instanceof CredebitCard;
      if (bool)
        localArrayList.add(localObject);
    }
    return localArrayList;
  }

  private Artifact getCreditAccount()
  {
    AccountModel localAccountModel = AccountModel.getInstance();
    List localList = localAccountModel.getArtifacts();
    Iterator localIterator = localList.iterator();
    boolean bool;
    Object localObject;
    do
    {
      bool = localIterator.hasNext();
      if (!bool)
        break;
      localObject = localIterator.next();
      localObject = (Artifact)localObject;
      bool = localObject instanceof CreditAccount;
    }
    while (!bool);
    while (true)
    {
      return localObject;
      localObject = null;
    }
  }

  public GiftCardManager getGiftCardManager()
  {
    Object localObject = PayPalApp.getApp();
    FragmentActivity localFragmentActivity = getActivity();
    localObject = ((PayPalApp)localObject).getGiftCardManager(localFragmentActivity);
    return localObject;
  }

  private List<GiftCard> getGiftCards()
  {
    Object localObject = AccountModel.getInstance();
    GiftCard localGiftCard = GiftCard.class;
    localObject = ((AccountModel)localObject).getArtifactsByType(localGiftCard);
    return localObject;
  }

  private WalletFragment.OnContainerFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (WalletFragment.OnContainerFragmentListener)localObject;
    return localObject;
  }

  private List<LoyaltyCard> getLoyaltyCards()
  {
    AccountModel localAccountModel = AccountModel.getInstance();
    Object localObject = LoyaltyCard.class;
    localObject = localAccountModel.getArtifactsByType((Class)localObject);
    return localObject;
  }

  private void hideProgressDialogs()
  {
    Object localObject = getActivity();
    localObject = ((FragmentActivity)localObject).getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
    localObject = getActivity();
    localObject = ((FragmentActivity)localObject).getSupportFragmentManager();
    String str = "dialog";
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(str);
    if (localFragment != null)
    {
      localFragmentTransaction.remove(localFragment);
      localFragmentTransaction.commit();
    }
    while (true)
    {
      return;
      localObject = getLocalListener();
      ((WalletFragment.OnContainerFragmentListener)localObject).hideProgressDialog();
    }
  }

  public static WalletFragment newInstance()
  {
    WalletFragment localWalletFragment = new com/paypal/android/p2pmobile/fragment/wallet/WalletFragment;
    localWalletFragment.<init>();
    return localWalletFragment;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i8 = 0;
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    subscribeToWalletOperationBroadcasts(i8);
    TrackPage.Point localPoint = TrackPage.Point.WalletMain;
    setTrackPage(localPoint);
    int i = 2130903218;
    ViewGroup localViewGroup = null;
    Object localObject = paramLayoutInflater.inflate(i, localViewGroup);
    this.mView = ((View)localObject);
    updateBtnVisibility();
    localObject = this.mView;
    int j = 2131428049;
    localObject = ((View)localObject).findViewById(j);
    localObject = (ExpandableHeightGridView)localObject;
    this.mPaymentCardsGridView = ((ExpandableHeightGridView)localObject);
    localObject = this.mPaymentCardsGridView;
    WalletFragment.1 local1 = new com/paypal/android/p2pmobile/fragment/wallet/WalletFragment$1;
    local1.<init>(this);
    ((ExpandableHeightGridView)localObject).setOnItemClickListener(local1);
    localObject = this.mView;
    int k = 2131428046;
    localObject = ((View)localObject).findViewById(k);
    localObject = (ExpandableHeightGridView)localObject;
    this.mBankAccountsGridView = ((ExpandableHeightGridView)localObject);
    localObject = this.mBankAccountsGridView;
    WalletFragment.2 local2 = new com/paypal/android/p2pmobile/fragment/wallet/WalletFragment$2;
    local2.<init>(this);
    ((ExpandableHeightGridView)localObject).setOnItemClickListener(local2);
    localObject = this.mView;
    int m = 2131428051;
    localObject = ((View)localObject).findViewById(m);
    localObject = (ExpandableHeightGridView)localObject;
    this.mLoyaltyCardsGridView = ((ExpandableHeightGridView)localObject);
    localObject = this.mLoyaltyCardsGridView;
    WalletFragment.3 local3 = new com/paypal/android/p2pmobile/fragment/wallet/WalletFragment$3;
    local3.<init>(this);
    ((ExpandableHeightGridView)localObject).setOnItemClickListener(local3);
    localObject = this.mView;
    int n = 2131428056;
    localObject = ((View)localObject).findViewById(n);
    localObject = (ExpandableHeightGridView)localObject;
    this.mPSBsGridView = ((ExpandableHeightGridView)localObject);
    localObject = this.mPSBsGridView;
    WalletFragment.4 local4 = new com/paypal/android/p2pmobile/fragment/wallet/WalletFragment$4;
    local4.<init>(this);
    ((ExpandableHeightGridView)localObject).setOnItemClickListener(local4);
    localObject = this.mView;
    int i1 = 2131428053;
    localObject = ((View)localObject).findViewById(i1);
    localObject = (ExpandableHeightGridView)localObject;
    this.mGiftCardsGridView = ((ExpandableHeightGridView)localObject);
    localObject = this.mGiftCardsGridView;
    WalletFragment.5 local5 = new com/paypal/android/p2pmobile/fragment/wallet/WalletFragment$5;
    local5.<init>(this);
    ((ExpandableHeightGridView)localObject).setOnItemClickListener(local5);
    localObject = this.mView;
    int i2 = 2131428036;
    localObject = ((View)localObject).findViewById(i2);
    localObject = (ScrollView)localObject;
    ((ScrollView)localObject).smoothScrollTo(i8, i8);
    localObject = this.mView;
    Typeface localTypeface = AppContext.getRobotoLight();
    int[] arrayOfInt = this.mRobotoLightIds;
    ViewUtility.applyTypefaceToTextViews((View)localObject, localTypeface, arrayOfInt);
    localObject = this.mView;
    localTypeface = AppContext.getRobotoBold();
    arrayOfInt = this.mRobotoBoldIds;
    ViewUtility.applyTypefaceToTextViews((View)localObject, localTypeface, arrayOfInt);
    localObject = this.mView;
    int i3 = 2131427800;
    localObject = ((View)localObject).findViewById(i3);
    WalletFragment.6 local6 = new com/paypal/android/p2pmobile/fragment/wallet/WalletFragment$6;
    local6.<init>(this);
    ((View)localObject).setOnClickListener(local6);
    localObject = this.mView;
    int i4 = 2131428037;
    localObject = ((View)localObject).findViewById(i4);
    WalletFragment.7 local7 = new com/paypal/android/p2pmobile/fragment/wallet/WalletFragment$7;
    local7.<init>(this);
    ((View)localObject).setOnClickListener(local7);
    localObject = this.mView;
    int i5 = 2131428040;
    localObject = ((View)localObject).findViewById(i5);
    WalletFragment.8 local8 = new com/paypal/android/p2pmobile/fragment/wallet/WalletFragment$8;
    local8.<init>(this);
    ((View)localObject).setOnClickListener(local8);
    localObject = this.mView;
    int i6 = 2131427806;
    localObject = ((View)localObject).findViewById(i6);
    WalletFragment.9 local9 = new com/paypal/android/p2pmobile/fragment/wallet/WalletFragment$9;
    local9.<init>(this);
    ((View)localObject).setOnClickListener(local9);
    localObject = this.mView;
    int i7 = 2131427807;
    localObject = ((View)localObject).findViewById(i7);
    WalletFragment.10 local10 = new com/paypal/android/p2pmobile/fragment/wallet/WalletFragment$10;
    local10.<init>(this);
    ((View)localObject).setOnClickListener(local10);
    localObject = this.mView;
    return localObject;
  }

  protected void onGiftCardOperation(AppIntentFactory.GiftCardOperation paramGiftCardOperation, Intent paramIntent)
  {
    int i = 0;
    String str3 = null;
    int[] arrayOfInt = WalletFragment.13.$SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$GiftCardOperation;
    int i2 = paramGiftCardOperation.ordinal();
    int j = arrayOfInt[i2];
    Object localObject6;
    switch (j)
    {
    default:
      localObject6 = getLocalListener();
      ((WalletFragment.OnContainerFragmentListener)localObject6).stopProgressLoader();
      hideProgressDialogs();
      if (i != 0)
      {
        if (str3 != null)
          break label705;
        localObject6 = getLocalListener();
        ((WalletFragment.OnContainerFragmentListener)localObject6).popFragmentBackStack();
      }
      break;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      renderGiftCards();
      localObject6 = "data";
      Object localObject1 = paramIntent;
      Object localObject5 = ((Intent)localObject1).getParcelableExtra((String)localObject6);
      localObject5 = (GiftCard.Id)localObject5;
      if (localObject5 == null)
      {
        localObject6 = L;
        String str4 = "Create Gift Card - id is missing!";
        Object localObject18 = 0;
        localObject1 = localObject18;
        localObject1 = new Object[localObject1];
        Object localObject19 = localObject1;
        ((DebugLogger)localObject6).error(str4, localObject19);
      }
      else
      {
        localObject6 = AccountModel.getInstance();
        Object localObject4 = ((AccountModel)localObject6).getArtifactById((UniqueId)localObject5);
        localObject4 = (GiftCard)localObject4;
        TrackPage.Point localPoint;
        MoneyValue localMoneyValue;
        String str2;
        label242: GiftProgram localGiftProgram;
        if (localObject4 != null)
        {
          localPoint = TrackPage.Point.GiftCardAddDone;
          localObject6 = ((GiftCard)localObject4).getGiftProgram();
          boolean bool2 = ((GiftProgram)localObject6).isBalanceSupported();
          if (!bool2)
            break label479;
          localMoneyValue = ((GiftCard)localObject4).getBalance();
          if (localMoneyValue != null)
            break label319;
          localPoint = TrackPage.Point.GiftCardAddDoneBalanceUnknown;
          int k = 2131494948;
          localObject1 = this;
          str2 = ((WalletFragment)localObject1).getString(k);
          localGiftProgram = ((GiftCard)localObject4).getGiftProgram();
          boolean bool1 = localGiftProgram.isBalanceSupported();
          if (!bool1)
            break label502;
        }
        label319: label479: label502: for (Object localObject7 = "addcardautomatedbalance"; ; localObject8 = "addcardmanualbalance")
        {
          Map localMap = GiftCardTrackingHelper.getAdditionalParameters(localGiftProgram, (String)localObject7);
          PayPalApp.logPageView(localPoint, localMap);
          localObject7 = getActivity();
          Object localObject11 = 1;
          localObject1 = localObject11;
          localObject7 = Toast.makeText((Context)localObject7, str2, localObject1);
          ((Toast)localObject7).show();
          i = 1;
          str3 = "wallet.container.card.details";
          break;
          localPoint = TrackPage.Point.GiftCardAddDoneBalanceKnown;
          boolean bool3 = localMoneyValue.isPositive();
          if (!bool3)
          {
            double d = 0.0D;
            Double localDouble = Double.valueOf(d);
            Object localObject12 = PayPalApp.getCurrentCurrency();
            localObject12 = ((Currency)localObject12).getCurrencyCode();
            MutableMoneyValue localMutableMoneyValue = MutableMoneyValue.createIfValid(localDouble, (String)localObject12);
            m = 2131494947;
            Object localObject13 = 1;
            localObject1 = localObject13;
            localObject1 = new Object[localObject1];
            Object localObject14 = localObject1;
            i3 = 0;
            str5 = localMutableMoneyValue.getFormatted();
            localObject14[i3] = str5;
            localObject1 = this;
            localObject2 = localObject14;
            str2 = ((WalletFragment)localObject1).getString(m, localObject2);
            break label242;
          }
          int m = 2131494947;
          Object localObject15 = 1;
          localObject1 = localObject15;
          localObject1 = new Object[localObject1];
          Object localObject16 = localObject1;
          int i3 = 0;
          String str5 = localMoneyValue.getFormatted();
          localObject16[i3] = str5;
          localObject1 = this;
          Object localObject2 = localObject16;
          str2 = ((WalletFragment)localObject1).getString(m, localObject2);
          break label242;
          localPoint = TrackPage.Point.GiftCardAddDoneBalanceUnknown;
          m = 2131494948;
          localObject1 = this;
          str2 = ((WalletFragment)localObject1).getString(m);
          break label242;
        }
        Object localObject8 = getLocalListener();
        ((WalletFragment.OnContainerFragmentListener)localObject8).hideProgressDialog();
        renderGiftCards();
        localObject8 = "data";
        localObject1 = paramIntent;
        Object localObject3 = ((Intent)localObject1).getParcelableExtra((String)localObject8);
        localObject3 = (Bundle)localObject3;
        localObject8 = "delete_silently";
        Object localObject17 = 0;
        localObject1 = localObject17;
        boolean bool4 = ((Bundle)localObject3).getBoolean((String)localObject8, localObject1);
        if (!bool4)
        {
          int n = 2131494952;
          localObject1 = this;
          str2 = ((WalletFragment)localObject1).getString(n);
          localObject9 = getActivity();
          localObject17 = 0;
          localObject1 = localObject17;
          localObject9 = Toast.makeText((Context)localObject9, str2, localObject1);
          ((Toast)localObject9).show();
          localObject9 = TrackPage.Point.GiftCardRemoveCardDone;
          PayPalApp.logPageView((TrackPage.Point)localObject9);
        }
        i = 0;
        str3 = "wallet.container.giftcard.details";
        break;
        Object localObject9 = getLocalListener();
        ((WalletFragment.OnContainerFragmentListener)localObject9).hideProgressDialog();
        int i1 = 2131494855;
        localObject1 = this;
        Object localObject10 = ((WalletFragment)localObject1).getString(i1);
        localObject1 = paramIntent;
        String str1 = AppIntentFactory.getFailureMessage((Intent)localObject1, (String)localObject10);
        localObject10 = getActivity();
        localObject17 = 0;
        localObject1 = localObject17;
        localObject10 = Toast.makeText((Context)localObject10, str1, localObject1);
        ((Toast)localObject10).show();
        break;
        label705: localObject10 = getLocalListener();
        ((WalletFragment.OnContainerFragmentListener)localObject10).popFragmentBackStack(str3);
      }
    }
  }

  public void onHiddenChanged(boolean paramBoolean)
  {
    int j = 0;
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean)
    {
      Object localObject = this.mView;
      int i = 2131428036;
      localObject = ((View)localObject).findViewById(i);
      localObject = (ScrollView)localObject;
      ((ScrollView)localObject).smoothScrollTo(j, j);
    }
  }

  protected void onLoyaltyCardOperation(AppIntentFactory.LoyaltyCardOperation paramLoyaltyCardOperation, Intent paramIntent)
  {
    int i3 = 2131494855;
    int i2 = 0;
    int i = 0;
    String str4 = null;
    int[] arrayOfInt = WalletFragment.13.$SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$LoyaltyCardOperation;
    int i1 = paramLoyaltyCardOperation.ordinal();
    int j = arrayOfInt[i1];
    String str2;
    String str1;
    switch (j)
    {
    default:
      boolean bool1 = AppIntentFactory.LoyaltyCardOperation.isError(paramLoyaltyCardOperation);
      label120: Object localObject2;
      if (bool1)
      {
        String str5 = "failureMessage";
        Object localObject1 = paramIntent.getParcelableExtra(str5);
        localObject1 = (FailureMessage)localObject1;
        if (localObject1 != null)
        {
          str2 = ((FailureMessage)localObject1).getMessage();
          boolean bool2 = TextUtils.isEmpty(str2);
          if (bool2)
            break label356;
          str1 = str2;
          localObject2 = getActivity();
          localObject2 = Toast.makeText((Context)localObject2, str1, i2);
          ((Toast)localObject2).show();
        }
      }
      else
      {
        label141: localObject2 = getLocalListener();
        ((WalletFragment.OnContainerFragmentListener)localObject2).stopProgressLoader();
        hideProgressDialogs();
        if (i != 0)
        {
          if (str4 != null)
            break label366;
          localObject2 = getLocalListener();
          ((WalletFragment.OnContainerFragmentListener)localObject2).popFragmentBackStack();
        }
      }
      break;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      int k = 2131494920;
      String str3 = getString(k);
      Object localObject3 = getActivity();
      localObject3 = Toast.makeText((Context)localObject3, str3, i2);
      ((Toast)localObject3).show();
      i = 1;
      renderLoyaltyCards();
      str4 = "wallet.container.card.details";
      localObject3 = getActivity();
      AdConversionManager.Event localEvent = AdConversionManager.Event.WALLET_ADD_LOYALTY_CARD;
      AdConversionManager.track((Context)localObject3, localEvent);
      break label141;
      int m = 2131494921;
      str3 = getString(m);
      Object localObject4 = getActivity();
      localObject4 = Toast.makeText((Context)localObject4, str3, i2);
      ((Toast)localObject4).show();
      i = 1;
      renderLoyaltyCards();
      str4 = "wallet.container.loyalty.details";
      break label141;
      int n = 2131494919;
      str3 = getString(n);
      Object localObject5 = getActivity();
      localObject5 = Toast.makeText((Context)localObject5, str3, i2);
      ((Toast)localObject5).show();
      i = 1;
      str4 = "wallet.container.loyalty.details";
      break label141;
      str2 = getString(i3);
      break;
      label356: str1 = getString(i3);
      break label120;
      label366: localObject5 = getLocalListener();
      ((WalletFragment.OnContainerFragmentListener)localObject5).popFragmentBackStack(str4);
    }
  }

  public void onResume()
  {
    super.onResume();
    updateBtnVisibility();
    renderServiceAvailabilityWarning();
    Object localObject1 = AccountModel.getInstance();
    AccountModelAvailability localAccountModelAvailability = ((AccountModel)localObject1).getAvailability();
    localObject1 = getActivity();
    if ((localObject1 != null) && (localAccountModelAvailability != null))
    {
      boolean bool1 = localAccountModelAvailability.isGiftCardsAvailable();
      if (bool1)
      {
        Object localObject2 = Config.getInstance();
        localObject2 = ((Config)localObject2).getGiftCardConfig();
        boolean bool2 = ((GiftCardConfig)localObject2).isGiftCardEnabled();
        if (bool2)
        {
          GiftCardManager localGiftCardManager = getGiftCardManager();
          bool2 = localGiftCardManager.hasPendingOperations();
          if (bool2)
          {
            bool2 = localGiftCardManager.isDeleteOperationPending();
            if (bool2)
            {
              WalletFragment.OnContainerFragmentListener localOnContainerFragmentListener = getLocalListener();
              int i = 2131493472;
              String str = getString(i);
              localOnContainerFragmentListener.showProgressDialog(str);
            }
          }
        }
      }
    }
  }

  protected void onWalletOperation(AppIntentFactory.WalletOperation paramWalletOperation, Intent paramIntent)
  {
    int j = 0;
    int k = 0;
    String str5 = null;
    AccountModel localAccountModel = AccountModel.getInstance();
    int i = 0;
    Object localObject3 = null;
    Object localObject5 = null;
    renderServiceAvailabilityWarning();
    int[] arrayOfInt = WalletFragment.13.$SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation;
    int i1 = paramWalletOperation.ordinal();
    int m = arrayOfInt[i1];
    Object localObject1;
    Object localObject2;
    Object localObject4;
    String str2;
    Object localObject21;
    switch (m)
    {
    default:
      boolean bool3 = AppIntentFactory.WalletOperation.isError(paramWalletOperation);
      if (bool3)
      {
        String str6 = paramWalletOperation.name();
        String str8 = "GET_ACCOUNT_DETAILS_NOK";
        boolean bool4 = str6.equalsIgnoreCase(str8);
        if (!bool4)
        {
          String str7 = "failureMessage";
          localObject1 = paramIntent;
          localObject2 = str7;
          boolean bool5 = ((Intent)localObject1).hasExtra((String)localObject2);
          if (!bool5)
            break label1014;
          localObject6 = "failureMessage";
          localObject1 = paramIntent;
          localObject2 = localObject6;
          localObject4 = ((Intent)localObject1).getParcelableExtra((String)localObject2);
          localObject4 = (FailureMessage)localObject4;
          if (localObject4 == null)
            break label992;
          str2 = ((FailureMessage)localObject4).getMessage();
          localObject6 = getActivity();
          localObject21 = 0;
          localObject1 = localObject6;
          localObject2 = localObject21;
          localObject6 = Toast.makeText((Context)localObject1, str2, localObject2);
          ((Toast)localObject6).show();
        }
      }
      label219: Object localObject6 = getLocalListener();
      if (localObject6 != null)
      {
        localObject6 = getLocalListener();
        ((WalletFragment.OnContainerFragmentListener)localObject6).stopProgressLoader();
        hideProgressDialogs();
        if (j != 0)
        {
          if (str5 != null)
            break label1061;
          localObject6 = getLocalListener();
          ((WalletFragment.OnContainerFragmentListener)localObject6).popFragmentBackStack();
        }
      }
      break;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    }
    while (true)
    {
      if ((k != 0) && (localObject5 != null))
        ((BaseFragment)localObject5).showErrorMessageBanner((String)localObject3);
      return;
      Object localObject7 = 2131493552;
      localObject1 = this;
      localObject2 = localObject7;
      String str1 = ((WalletFragment)localObject1).getString(localObject2);
      localObject7 = 2131493552;
      localObject1 = this;
      localObject2 = localObject7;
      String str4 = ((WalletFragment)localObject1).getString(localObject2);
      if (localAccountModel != null)
      {
        AccountBalance localAccountBalance = localAccountModel.getBalance();
        if (localAccountBalance != null)
        {
          localObject8 = localAccountBalance.getConvertedBalance();
          localObject8 = ((MoneyBalance)localObject8).getAvailable();
          str1 = ((MoneyValue)localObject8).getFormattedLong();
          localObject8 = localAccountBalance.getConvertedBalance();
          localObject8 = ((MoneyBalance)localObject8).getTotal();
          str4 = ((MoneyValue)localObject8).getFormattedLong();
        }
      }
      localObject1 = this;
      ((WalletFragment)localObject1).renderEntireContainerScreen(str1, str4);
      boolean bool1 = AccountModelUtil.hasFundingSourceArtifacts();
      Object localObject8 = PayPalApp.getPrefs();
      boolean bool2 = ((GlobalPreferences)localObject8).getHaveShownOverlay();
      if ((bool1) || (bool2))
        break label219;
      boolean bool6 = possibleAvailabilityIssue();
      if (bool6)
        break label219;
      showNoFundingOverlay();
      GlobalPreferences localGlobalPreferences = PayPalApp.getPrefs();
      localObject21 = 1;
      localGlobalPreferences.setHaveShownOverlay(localObject21);
      break label219;
      Object localObject9 = 2131494695;
      localObject1 = this;
      localObject2 = localObject9;
      String str3 = ((WalletFragment)localObject1).getString(localObject2);
      Object localObject10 = getActivity();
      localObject21 = 0;
      localObject1 = localObject10;
      localObject2 = localObject21;
      localObject10 = Toast.makeText((Context)localObject1, str3, localObject2);
      ((Toast)localObject10).show();
      j = 1;
      renderBankAccount();
      str5 = "wallet.container.card.details";
      break label219;
      Object localObject11 = 2131494694;
      localObject1 = this;
      localObject2 = localObject11;
      str3 = ((WalletFragment)localObject1).getString(localObject2);
      Object localObject12 = getActivity();
      localObject21 = 0;
      localObject1 = localObject12;
      localObject2 = localObject21;
      localObject12 = Toast.makeText((Context)localObject1, str3, localObject2);
      ((Toast)localObject12).show();
      j = 1;
      renderPaymentCards();
      str5 = "wallet.container.card.details";
      break label219;
      Object localObject13 = 2131493438;
      localObject1 = this;
      localObject2 = localObject13;
      str3 = ((WalletFragment)localObject1).getString(localObject2);
      Object localObject14 = getActivity();
      localObject21 = 0;
      localObject1 = localObject14;
      localObject2 = localObject21;
      localObject14 = Toast.makeText((Context)localObject1, str3, localObject2);
      ((Toast)localObject14).show();
      j = 1;
      renderPaymentCards();
      break label219;
      Object localObject15 = 2131493473;
      localObject1 = this;
      localObject2 = localObject15;
      str3 = ((WalletFragment)localObject1).getString(localObject2);
      Object localObject16 = getActivity();
      localObject21 = 0;
      localObject1 = localObject16;
      localObject2 = localObject21;
      localObject16 = Toast.makeText((Context)localObject1, str3, localObject2);
      ((Toast)localObject16).show();
      j = 1;
      renderPaymentCards();
      str5 = "wallet.container.card.details";
      break label219;
      localObject16 = "failureMessage";
      localObject1 = paramIntent;
      localObject2 = localObject16;
      localObject4 = ((Intent)localObject1).getParcelableExtra((String)localObject2);
      localObject4 = (FailureMessage)localObject4;
      Object localObject22;
      if (localObject4 != null)
      {
        str2 = ((FailureMessage)localObject4).getMessage();
        localObject16 = ((FailureMessage)localObject4).getSuggestion();
        if (localObject16 != null)
        {
          localObject16 = ((FailureMessage)localObject4).getSuggestion();
          int n = ((String)localObject16).length();
          if (n > 0)
          {
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>();
            localObject1 = localStringBuilder;
            localStringBuilder = ((StringBuilder)localObject1).append(str2);
            localObject22 = "  ";
            localStringBuilder = localStringBuilder.append((String)localObject22);
            localObject22 = ((FailureMessage)localObject4).getSuggestion();
            localStringBuilder = localStringBuilder.append((String)localObject22);
            str2 = localStringBuilder.toString();
          }
        }
        label842: boolean bool7 = TextUtils.isEmpty(str2);
        if (bool7)
          break label949;
      }
      for (localObject3 = str2; ; localObject3 = ((WalletFragment)localObject1).getString(localObject2))
      {
        j = 0;
        Object localObject17 = getActivity();
        localObject22 = EditArtifactFragment.class;
        localObject5 = FragmentUtils.getFragment((FragmentActivity)localObject17, (Class)localObject22);
        localObject5 = (BaseFragment)localObject5;
        if (localObject5 != null)
          break label971;
        localObject17 = getActivity();
        localObject23 = 0;
        localObject1 = localObject17;
        localObject2 = localObject23;
        localObject17 = Toast.makeText((Context)localObject1, (CharSequence)localObject3, localObject2);
        ((Toast)localObject17).show();
        break;
        Object localObject18 = 2131494855;
        localObject1 = this;
        localObject2 = localObject18;
        str2 = ((WalletFragment)localObject1).getString(localObject2);
        break label842;
        label949: localObject18 = 2131494855;
        localObject1 = this;
        localObject2 = localObject18;
      }
      label971: k = 1;
      boolean bool8 = ((BaseFragment)localObject5).isVisible();
      if (bool8)
        break label219;
      j = 1;
      break label219;
      label992: Object localObject19 = 2131494855;
      localObject1 = this;
      localObject2 = localObject19;
      str2 = ((WalletFragment)localObject1).getString(localObject2);
      break;
      label1014: Object localObject20 = getActivity();
      Object localObject23 = 2131494855;
      localObject1 = this;
      localObject2 = localObject23;
      String str9 = ((WalletFragment)localObject1).getString(localObject2);
      int i2 = 0;
      localObject20 = Toast.makeText((Context)localObject20, str9, i2);
      ((Toast)localObject20).show();
      break label219;
      label1061: localObject20 = getLocalListener();
      localObject1 = localObject20;
      ((WalletFragment.OnContainerFragmentListener)localObject1).popFragmentBackStack(str5);
    }
  }

  private boolean possibleAvailabilityIssue()
  {
    boolean bool1 = true;
    AccountModel localAccountModel = AccountModel.getInstance();
    AccountModelAvailability localAccountModelAvailability = localAccountModel.getAvailability();
    if (localAccountModelAvailability != null)
    {
      boolean bool2 = localAccountModelAvailability.isPaymentPreferencesAvailable();
      if (bool2)
      {
        bool2 = localAccountModelAvailability.isCreditAccountsAvailable();
        if (bool2)
        {
          bool2 = localAccountModelAvailability.isCredebitCardsAvailable();
          if (bool2)
          {
            bool2 = localAccountModelAvailability.isBankAccountsAvailable();
            if (bool2)
            {
              bool2 = localAccountModelAvailability.isLoyaltyCardsAvailable();
              if (bool2)
                break label63;
            }
          }
        }
      }
    }
    while (true)
    {
      return bool1;
      label63: bool1 = false;
    }
  }

  public void removeNoFundingOverlay()
  {
    Object localObject = this.mView;
    int i = 2131428564;
    View localView = ((View)localObject).findViewById(i);
    if (localView != null)
    {
      localObject = this.mView;
      localObject = (ViewGroup)localObject;
      ((ViewGroup)localObject).removeView(localView);
    }
  }

  public void renderBalance(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    Object localObject = this.mView;
    int i = 2131427803;
    localObject = ((View)localObject).findViewById(i);
    localObject = (TextView)localObject;
    ((TextView)localObject).setText(paramCharSequence1);
    localObject = this.mView;
    i = 2131427804;
    localObject = ((View)localObject).findViewById(i);
    localObject = (TextView)localObject;
    ((TextView)localObject).setText(paramCharSequence2);
  }

  public void renderBankAccount()
  {
    int n = 2131428044;
    int k = 8;
    int i = 0;
    boolean bool1 = false;
    AccountModel localAccountModel = AccountModel.getInstance();
    AccountModelAvailability localAccountModelAvailability = localAccountModel.getAvailability();
    label84: ExpandableHeightGridView localExpandableHeightGridView;
    Object localObject1;
    if (localAccountModelAvailability != null)
    {
      boolean bool2 = localAccountModelAvailability.isBankAccountsAvailable();
      if (bool2)
      {
        List localList = getBankAccounts();
        if (localList != null)
        {
          int m = localList.size();
          if (m <= 0)
            break label147;
          bool1 = true;
          Object localObject2 = this.mView;
          localObject2 = ((View)localObject2).findViewById(n);
          if (!bool1)
            break label153;
          ((View)localObject2).setVisibility(i);
          if (bool1)
          {
            localExpandableHeightGridView = this.mBankAccountsGridView;
            localObject2 = new com/paypal/android/p2pmobile/adapters/WalletArtifactAdapter;
            localObject1 = getActivity();
            localObject1 = (ActionBarActivity)localObject1;
            ((WalletArtifactAdapter)localObject2).<init>((ActionBarActivity)localObject1, localList);
            localExpandableHeightGridView.setAdapter((ListAdapter)localObject2);
          }
        }
        localObject1 = this.mBankAccountsGridView;
        ((ExpandableHeightGridView)localObject1).setExpanded(bool1);
      }
    }
    while (true)
    {
      return;
      label147: bool1 = localObject1;
      break;
      label153: int j = localExpandableHeightGridView;
      break label84;
      View localView = this.mView;
      localView = localView.findViewById(n);
      localView.setVisibility(localExpandableHeightGridView);
    }
  }

  public void renderEbayCreditBalance()
  {
    int n = 8;
    int i1 = 2131428040;
    AccountModel localAccountModel = AccountModel.getInstance();
    AccountModelAvailability localAccountModelAvailability = localAccountModel.getAvailability();
    Object localObject1;
    String str2;
    if (localAccountModelAvailability != null)
    {
      boolean bool1 = localAccountModelAvailability.isCreditAccountsAvailable();
      if (bool1)
      {
        Artifact localArtifact = getCreditAccount();
        if (localArtifact != null)
        {
          localObject1 = localArtifact;
          localObject1 = (CreditAccount)localObject1;
          Object localObject2 = ((CreditAccount)localObject1).getAvailableCredit();
          String str1 = ((MoneyValue)localObject2).getFormatted();
          localObject2 = this.mView;
          n = 2131427914;
          localObject2 = ((View)localObject2).findViewById(n);
          localObject2 = (TextView)localObject2;
          ((TextView)localObject2).setText(str1);
          boolean bool2 = ((CreditAccount)localObject1).isBml();
          if (bool2)
          {
            int i = 2131494702;
            str2 = getString(i);
            Object localObject3 = this.mView;
            n = 2131428042;
            localObject3 = ((View)localObject3).findViewById(n);
            localObject3 = (TextView)localObject3;
            ((TextView)localObject3).setText(str2);
            localObject3 = this.mView;
            localObject3 = ((View)localObject3).findViewById(i1);
            n = 0;
            ((View)localObject3).setVisibility(n);
          }
        }
      }
    }
    while (true)
    {
      return;
      boolean bool3 = ((CreditAccount)localObject1).isPaypalPluscard();
      if (bool3)
      {
        int j = 2131494716;
        str2 = getString(j);
        break;
      }
      boolean bool4 = ((CreditAccount)localObject1).isEbayMastercard();
      if (bool4)
      {
        int k = 2131494715;
        str2 = getString(k);
        break;
      }
      boolean bool5 = ((CreditAccount)localObject1).isBuyerCredit();
      if (bool5)
      {
        int m = 2131494714;
        str2 = getString(m);
        break;
      }
      str2 = "";
      break;
      View localView = this.mView;
      localView = localView.findViewById(i1);
      localView.setVisibility(n);
      continue;
      localView = this.mView;
      localView = localView.findViewById(i1);
      localView.setVisibility(n);
    }
  }

  public void renderEntireContainerScreen(String paramString1, String paramString2)
  {
    renderBalance(paramString2, paramString1);
    renderBankAccount();
    renderPaymentCards();
    renderEbayCreditBalance();
    renderLoyaltyCards();
    renderGiftCards();
    renderPSBs();
  }

  public void renderGiftCards()
  {
    int j = 2131428052;
    boolean bool1 = false;
    AccountModel localAccountModel = AccountModel.getInstance();
    AccountModelAvailability localAccountModelAvailability = localAccountModel.getAvailability();
    Object localObject2;
    ExpandableHeightGridView localExpandableHeightGridView;
    if (localAccountModelAvailability != null)
    {
      boolean bool2 = localAccountModelAvailability.isGiftCardsAvailable();
      if (bool2)
      {
        Object localObject1 = Config.getInstance();
        localObject1 = ((Config)localObject1).getGiftCardConfig();
        boolean bool3 = ((GiftCardConfig)localObject1).isGiftCardEnabled();
        if (bool3)
        {
          GiftCardManager localGiftCardManager = getGiftCardManager();
          List localList = localGiftCardManager.getGiftCards();
          if (localList != null)
          {
            int i = localList.size();
            if (i <= 0)
              break label159;
            bool1 = true;
            localObject2 = this.mView;
            ViewUtility.showOrHide((View)localObject2, j, bool1);
            if (bool1)
            {
              localExpandableHeightGridView = this.mGiftCardsGridView;
              WalletArtifactAdapter localWalletArtifactAdapter = new com/paypal/android/p2pmobile/adapters/WalletArtifactAdapter;
              localObject2 = getActivity();
              localObject2 = (ActionBarActivity)localObject2;
              localWalletArtifactAdapter.<init>((ActionBarActivity)localObject2, localList);
              localExpandableHeightGridView.setAdapter(localWalletArtifactAdapter);
            }
          }
          localObject2 = this.mGiftCardsGridView;
          ((ExpandableHeightGridView)localObject2).setExpanded(bool1);
        }
      }
    }
    while (true)
    {
      return;
      label159: bool1 = false;
      break;
      localObject2 = this.mView;
      localObject2 = ((View)localObject2).findViewById(localExpandableHeightGridView);
      int k = 8;
      ((View)localObject2).setVisibility(k);
    }
  }

  public void renderLoyaltyCards()
  {
    int n = 2131428050;
    int k = 8;
    int i = 0;
    boolean bool1 = false;
    AccountModel localAccountModel = AccountModel.getInstance();
    AccountModelAvailability localAccountModelAvailability = localAccountModel.getAvailability();
    label119: ExpandableHeightGridView localExpandableHeightGridView;
    Object localObject1;
    if (localAccountModelAvailability != null)
    {
      boolean bool2 = localAccountModelAvailability.isLoyaltyCardsAvailable();
      if (bool2)
      {
        Object localObject2 = Config.getInstance();
        localObject2 = ((Config)localObject2).getLoyaltyConfig();
        boolean bool3 = ((LoyaltyConfig)localObject2).isLoyaltyEnabled();
        if (bool3)
        {
          List localList = getLoyaltyCards();
          if (localList != null)
          {
            Comparator localComparator = LoyaltyCardComparator;
            Collections.sort(localList, localComparator);
            int m = localList.size();
            if (m <= 0)
              break label182;
            bool1 = true;
            Object localObject3 = this.mView;
            localObject3 = ((View)localObject3).findViewById(n);
            if (!bool1)
              break label188;
            ((View)localObject3).setVisibility(i);
            if (bool1)
            {
              localExpandableHeightGridView = this.mLoyaltyCardsGridView;
              localObject3 = new com/paypal/android/p2pmobile/adapters/WalletArtifactAdapter;
              localObject1 = getActivity();
              localObject1 = (ActionBarActivity)localObject1;
              ((WalletArtifactAdapter)localObject3).<init>((ActionBarActivity)localObject1, localList);
              localExpandableHeightGridView.setAdapter((ListAdapter)localObject3);
            }
          }
          localObject1 = this.mLoyaltyCardsGridView;
          ((ExpandableHeightGridView)localObject1).setExpanded(bool1);
        }
      }
    }
    while (true)
    {
      return;
      label182: bool1 = localObject1;
      break;
      label188: int j = localExpandableHeightGridView;
      break label119;
      View localView = this.mView;
      localView = localView.findViewById(n);
      localView.setVisibility(localExpandableHeightGridView);
    }
  }

  public void renderPSBs()
  {
    int k = 8;
    int j = 2131428054;
    Object localObject1 = Config.getInstance();
    localObject1 = ((Config)localObject1).getPSBConfig();
    boolean bool1 = ((PSBConfig)localObject1).isPSBEnabled();
    Object localObject3;
    if (bool1)
    {
      Object localObject2 = AccountModel.getInstance();
      localObject2 = ((AccountModel)localObject2).getAvailability();
      boolean bool2 = ((AccountModelAvailability)localObject2).isPayPalSpecificBalanceAvailable();
      if (bool2);
    }
    else
    {
      localObject3 = this.mView;
      localObject3 = ((View)localObject3).findViewById(j);
      ((View)localObject3).setVisibility(k);
    }
    while (true)
    {
      return;
      localObject3 = AccountModel.getInstance();
      PayPalSpecificBalance localPayPalSpecificBalance = PayPalSpecificBalance.class;
      List localList = ((AccountModel)localObject3).getArtifactsByType(localPayPalSpecificBalance);
      boolean bool3 = localList.isEmpty();
      Object localObject4;
      WalletArtifactAdapter localWalletArtifactAdapter;
      if (!bool3)
      {
        localObject4 = this.mView;
        localObject4 = ((View)localObject4).findViewById(j);
        int i = 0;
        ((View)localObject4).setVisibility(i);
        ExpandableHeightGridView localExpandableHeightGridView = this.mPSBsGridView;
        localWalletArtifactAdapter = new com/paypal/android/p2pmobile/adapters/WalletArtifactAdapter;
        localObject4 = getActivity();
        localObject4 = (ActionBarActivity)localObject4;
        localWalletArtifactAdapter.<init>((ActionBarActivity)localObject4, localList);
        localExpandableHeightGridView.setAdapter(localWalletArtifactAdapter);
        localObject4 = this.mPSBsGridView;
        boolean bool4 = true;
        ((ExpandableHeightGridView)localObject4).setExpanded(bool4);
      }
      else
      {
        localObject4 = this.mView;
        localObject4 = ((View)localObject4).findViewById(localWalletArtifactAdapter);
        ((View)localObject4).setVisibility(k);
      }
    }
  }

  public void renderPaymentCards()
  {
    int n = 2131428047;
    int k = 8;
    int i = 0;
    boolean bool1 = false;
    AccountModel localAccountModel = AccountModel.getInstance();
    AccountModelAvailability localAccountModelAvailability = localAccountModel.getAvailability();
    label84: ExpandableHeightGridView localExpandableHeightGridView;
    Object localObject1;
    if (localAccountModelAvailability != null)
    {
      boolean bool2 = localAccountModelAvailability.isCredebitCardsAvailable();
      if (bool2)
      {
        List localList = getCredebitAccounts();
        if (localList != null)
        {
          int m = localList.size();
          if (m <= 0)
            break label147;
          bool1 = true;
          Object localObject2 = this.mView;
          localObject2 = ((View)localObject2).findViewById(n);
          if (!bool1)
            break label153;
          ((View)localObject2).setVisibility(i);
          if (bool1)
          {
            localExpandableHeightGridView = this.mPaymentCardsGridView;
            localObject2 = new com/paypal/android/p2pmobile/adapters/WalletArtifactAdapter;
            localObject1 = getActivity();
            localObject1 = (ActionBarActivity)localObject1;
            ((WalletArtifactAdapter)localObject2).<init>((ActionBarActivity)localObject1, localList);
            localExpandableHeightGridView.setAdapter((ListAdapter)localObject2);
          }
        }
        localObject1 = this.mPaymentCardsGridView;
        ((ExpandableHeightGridView)localObject1).setExpanded(bool1);
      }
    }
    while (true)
    {
      return;
      label147: bool1 = localObject1;
      break;
      label153: int j = localExpandableHeightGridView;
      break label84;
      View localView = this.mView;
      localView = localView.findViewById(n);
      localView.setVisibility(localExpandableHeightGridView);
    }
  }

  private void renderServiceAvailabilityWarning()
  {
    boolean bool = possibleAvailabilityIssue();
    toggleAvailabilityWarning(bool);
  }

  public void showNoFundingOverlay()
  {
    int k = 0;
    Object localObject2 = this.mView;
    int j = 2131428564;
    View localView = ((View)localObject2).findViewById(j);
    if (localView == null)
    {
      localObject2 = getActivity();
      LayoutInflater localLayoutInflater = ((FragmentActivity)localObject2).getLayoutInflater();
      Object localObject1 = this.mView;
      localObject1 = (ViewGroup)localObject1;
      int i = 2130903311;
      localView = localLayoutInflater.inflate(i, (ViewGroup)localObject1, k);
      ((ViewGroup)localObject1).addView(localView);
    }
    while (true)
    {
      WalletFragment.11 local11 = new com/paypal/android/p2pmobile/fragment/wallet/WalletFragment$11;
      local11.<init>(this);
      localView.setOnClickListener(local11);
      return;
      localView.setVisibility(k);
    }
  }

  private void toggleAvailabilityWarning(boolean paramBoolean)
  {
    int i = 2131428039;
    View localView;
    if (paramBoolean)
    {
      localView = this.mView;
      localView = localView.findViewById(i);
      i = 0;
      localView.setVisibility(i);
    }
    while (true)
    {
      return;
      localView = this.mView;
      localView = localView.findViewById(i);
      i = 8;
      localView.setVisibility(i);
    }
  }

  public void updateBtnVisibility()
  {
    int k = 2131427805;
    int j = 2131427513;
    boolean bool5 = true;
    boolean bool4 = false;
    boolean bool1 = PayPalApp.supportsAddFunds();
    boolean bool3 = PayPalApp.supportsWithdraw();
    boolean bool2 = PayPalApp.supportsDepositCheck();
    View localView;
    if ((!bool1) && (!bool3) && (!bool2))
    {
      localView = this.mView;
      ViewUtility.showOrHide(localView, j, bool4);
      localView = this.mView;
      ViewUtility.showOrHide(localView, k, bool4);
    }
    while (true)
    {
      return;
      localView = this.mView;
      ViewUtility.showOrHide(localView, j, bool5);
      localView = this.mView;
      ViewUtility.showOrHide(localView, k, bool5);
      localView = this.mView;
      int i = 2131427806;
      ViewUtility.showOrHide(localView, i, bool1);
      localView = this.mView;
      i = 2131427807;
      ViewUtility.showOrHide(localView, i, bool3);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WalletFragment
 * JD-Core Version:    0.6.2
 */
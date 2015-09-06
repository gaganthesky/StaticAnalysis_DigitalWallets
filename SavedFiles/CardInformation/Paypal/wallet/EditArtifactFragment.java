package com.paypal.android.p2pmobile.fragment.wallet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.paypal.android.base.Logging;
import com.paypal.android.base.common.Country;
import com.paypal.android.base.server.tracking.TrackPage.Link;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.account.AccountModel;
import com.paypal.android.foundation.account.model.AccountDetails;
import com.paypal.android.foundation.account.model.Artifact;
import com.paypal.android.foundation.account.model.BankAccount;
import com.paypal.android.foundation.account.model.BankAccountType;
import com.paypal.android.foundation.account.model.CredebitCard;
import com.paypal.android.foundation.account.model.MutableCredebitCard;
import com.paypal.android.foundation.core.model.Address;
import com.paypal.android.foundation.core.model.MutableAddress;
import com.paypal.android.foundation.core.model.UniqueId;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.activity.AddCardPersonalInfoActivity;
import com.paypal.android.p2pmobile.adapters.WalletArtifactAdapter;
import com.paypal.android.p2pmobile.common.PayPalUser;
import com.paypal.android.p2pmobile.common.PerCountryData;
import com.paypal.android.p2pmobile.common.PerCountryData.PersonalInfoPage;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.fragment.dialogs.MessageDialog;
import com.paypal.android.p2pmobile.fragment.dialogs.MonthYearPopup;
import com.paypal.android.p2pmobile.fragment.dialogs.MonthYearPopup.OnYMSetListener;
import com.paypal.android.p2pmobile.utils.CardFormatter;
import com.paypal.android.p2pmobile.utils.ViewUtility;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import junit.framework.Assert;

public class EditArtifactFragment extends BaseFragment
  implements MonthYearPopup.OnYMSetListener, View.OnClickListener
{
  public static final String BUNDLE_KEY_POSITION = "position";
  public static final String BUNDLE_KEY_UNIQUE_ID = "unique_id";
  private static final String DIALOG_TAG = "dialog";
  private static final TrackPage.Point EDIT_CREDEBIT_EXP_DATE_TRACK_PAGE;
  private static final TrackPage.Point EDIT_CREDEBIT_MAIN_TRACK_PAGE;
  private static final TrackPage.Point EDIT_CREDEBIT_SELECT_ADDRESS_TRACK_PAGE = (TrackPage.Point)localObject;
  private static final String LOG_TAG;
  private TextView mAccountType;
  private boolean mActionFailed;
  private int mAddressIndex;
  private ArrayList mAddresses;
  private TextView mBillAddress;
  private View mDoneButton;
  MutableCredebitCard mEditedCard;
  private List mModifiedAddressList;
  CredebitCard mOriginalCard;
  private View mRoot;
  private final Calendar mSelectDate;
  private TextView mStatus;
  private UniqueId mUniqueId;
  private TextView mViewExpDate;

  static
  {
    Object localObject = EditArtifactFragment.class;
    localObject = ((Class)localObject).getSimpleName();
    LOG_TAG = (String)localObject;
    localObject = TrackPage.Point.EditCardOverview;
    EDIT_CREDEBIT_MAIN_TRACK_PAGE = (TrackPage.Point)localObject;
    localObject = TrackPage.Point.EditCardSelectExpirationDate;
    EDIT_CREDEBIT_EXP_DATE_TRACK_PAGE = (TrackPage.Point)localObject;
    localObject = TrackPage.Point.EditCardSelectBillingAddress;
  }

  public EditArtifactFragment()
  {
    int i = 0;
    this.mAddressIndex = i;
    this.mUniqueId = localObject;
    this.mOriginalCard = localObject;
    this.mEditedCard = localObject;
    this.mModifiedAddressList = localObject;
    Calendar localCalendar = Calendar.getInstance();
    this.mSelectDate = localCalendar;
    this.mRoot = localObject;
  }

  private String getAccountCountryCode()
  {
    AccountModel localAccountModel = AccountModel.getInstance();
    AccountDetails localAccountDetails = localAccountModel.getDetails();
    if (localAccountDetails != null);
    for (String str = localAccountDetails.getAccountCountryCode(); ; str = null)
      return str;
  }

  private List<Address> getAddressesFromModel()
  {
    AccountModel localAccountModel = AccountModel.getInstance();
    Object localObject;
    if (localAccountModel != null)
      localObject = localAccountModel.getAddresses();
    while (true)
    {
      return localObject;
      localObject = new java/util/ArrayList;
      ((ArrayList)localObject).<init>();
    }
  }

  private MutableCredebitCard getMutableCredebitCard()
  {
    AccountModel localAccountModel = AccountModel.getInstance();
    AccountDetails localAccountDetails = localAccountModel.getDetails();
    String str1 = localAccountDetails.getFirstName();
    String str2 = localAccountDetails.getLastName();
    MutableCredebitCard localMutableCredebitCard = new com/paypal/android/foundation/account/model/MutableCredebitCard;
    CredebitCard localCredebitCard = this.mOriginalCard;
    localMutableCredebitCard.<init>(localCredebitCard);
    localMutableCredebitCard.setCardHolderFirstName(str1);
    localMutableCredebitCard.setCardHolderLastName(str2);
    return localMutableCredebitCard;
  }

  private boolean isBillingAddressChanged()
  {
    Object localObject = this.mOriginalCard;
    Address localAddress = ((CredebitCard)localObject).getBillingAddress();
    localObject = this.mEditedCard;
    MutableAddress localMutableAddress = ((MutableCredebitCard)localObject).getBillingAddress();
    localObject = localAddress.getFormatted();
    String str = localMutableAddress.getFormatted();
    boolean bool = TextUtils.equals((CharSequence)localObject, str);
    if (!bool);
    for (bool = true; ; bool = false)
      return bool;
  }

  private boolean isCardOnEditableBlacklist(AddCardFragment.CardType paramCardType, String paramString)
  {
    boolean bool1 = true;
    if (paramCardType != null)
    {
      AddCardFragment.CardType localCardType1 = AddCardFragment.CardType.Unknown;
      if (paramCardType != localCardType1)
        break label20;
    }
    while (true)
    {
      return bool1;
      label20: int j = 6;
      AddCardFragment.CardType[] arrayOfCardType = new AddCardFragment.CardType[j];
      int k = 0;
      AddCardFragment.CardType localCardType3 = AddCardFragment.CardType.Etoiles;
      arrayOfCardType[k] = localCardType3;
      AddCardFragment.CardType localCardType2 = AddCardFragment.CardType.Cofinoga;
      arrayOfCardType[bool1] = localCardType2;
      int i = 2;
      localCardType2 = AddCardFragment.CardType.CarteAurore;
      arrayOfCardType[i] = localCardType2;
      i = 3;
      localCardType2 = AddCardFragment.CardType.ChinaUnionPay;
      arrayOfCardType[i] = localCardType2;
      i = 4;
      localCardType2 = AddCardFragment.CardType.Maestro;
      arrayOfCardType[i] = localCardType2;
      i = 5;
      localCardType2 = AddCardFragment.CardType.Switch;
      arrayOfCardType[i] = localCardType2;
      boolean bool2 = AddCardFragment.CardType.hasCardMatch(paramCardType, arrayOfCardType);
    }
  }

  private boolean isExpDateChanged()
  {
    CredebitCard localCredebitCard1 = this.mOriginalCard;
    int i = localCredebitCard1.getExpirationYear();
    MutableCredebitCard localMutableCredebitCard1 = this.mEditedCard;
    int m = localMutableCredebitCard1.getExpirationYear();
    if (i == m)
    {
      CredebitCard localCredebitCard2 = this.mOriginalCard;
      j = localCredebitCard2.getExpirationMonth();
      MutableCredebitCard localMutableCredebitCard2 = this.mEditedCard;
      int n = localMutableCredebitCard2.getExpirationMonth();
      if (j == n)
        break label55;
    }
    label55: int k;
    for (int j = 1; ; k = 0)
      return j;
  }

  public static EditArtifactFragment newInstance()
  {
    EditArtifactFragment localEditArtifactFragment = new com/paypal/android/p2pmobile/fragment/wallet/EditArtifactFragment;
    localEditArtifactFragment.<init>();
    return localEditArtifactFragment;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    int i1 = -1;
    int m = 13;
    if (m == paramInt1)
    {
      localObject3 = this.mBillAddress;
      ((TextView)localObject3).setEnabled(bool);
    }
    switch (paramInt2)
    {
    default:
      return;
    case -1:
    }
    Object localObject3 = "addressIndex";
    int i = paramIntent.getIntExtra((String)localObject3, i1);
    localObject3 = "addressList";
    ArrayList localArrayList = paramIntent.getParcelableArrayListExtra((String)localObject3);
    Assert.assertNotNull(localArrayList);
    if (i > i1)
    {
      int n = localArrayList.size();
      if (i >= n);
    }
    while (true)
    {
      Assert.assertTrue(bool);
      if (i <= i1)
        break;
      int j = localArrayList.size();
      if (i >= j)
        break;
      Object localObject2 = getAccountCountryCode();
      localObject2 = CardFormatter.transform(localArrayList, (String)localObject2);
      this.mModifiedAddressList = ((List)localObject2);
      localObject2 = this.mModifiedAddressList;
      Object localObject1 = ((List)localObject2).get(i);
      localObject1 = (MutableAddress)localObject1;
      Assert.assertNotNull(localObject1);
      localObject2 = this.mEditedCard;
      ((MutableCredebitCard)localObject2).setBillingAddress((MutableAddress)localObject1);
      localObject2 = this.mBillAddress;
      List localList = ((MutableAddress)localObject1).getFormattedLines();
      setAddressToTextView((TextView)localObject2, localList);
      break;
      int k = 0;
    }
  }

  public void onClick(View paramView)
  {
    boolean bool3 = false;
    boolean bool1 = ViewUtility.isBaseActivityResumed(paramView);
    if (!bool1);
    while (true)
    {
      return;
      View localView = this.mRoot;
      int j = 2131427923;
      ViewUtility.showOrHide(localView, j, bool3);
      int i = paramView.getId();
      Object localObject1;
      Object localObject3;
      Object localObject2;
      switch (i)
      {
      default:
        break;
      case 2131427489:
        localObject1 = EDIT_CREDEBIT_MAIN_TRACK_PAGE;
        localObject3 = TrackPage.Link.DoneButton;
        PayPalApp.logLinkPress((TrackPage.Point)localObject1, (TrackPage.Link)localObject3);
        localObject1 = getListener();
        localObject1 = (EditArtifactFragment.OnEditCardFragmentListener)localObject1;
        localObject3 = this.mEditedCard;
        ((EditArtifactFragment.OnEditCardFragmentListener)localObject1).onVerifyCSC((MutableCredebitCard)localObject3);
        break;
      case 2131427922:
        localObject1 = EDIT_CREDEBIT_MAIN_TRACK_PAGE;
        localObject3 = TrackPage.Link.RemoveCard;
        PayPalApp.logLinkPress((TrackPage.Point)localObject1, (TrackPage.Link)localObject3);
        localObject1 = getListener();
        localObject1 = (EditArtifactFragment.OnEditCardFragmentListener)localObject1;
        localObject3 = this.mUniqueId;
        ((EditArtifactFragment.OnEditCardFragmentListener)localObject1).onRemoveWalletArtifact((UniqueId)localObject3);
        break;
      case 2131427655:
        localObject1 = EDIT_CREDEBIT_MAIN_TRACK_PAGE;
        localObject3 = TrackPage.Link.CancelButton;
        PayPalApp.logLinkPress((TrackPage.Point)localObject1, (TrackPage.Link)localObject3);
        localObject1 = getListener();
        localObject1 = (EditArtifactFragment.OnEditCardFragmentListener)localObject1;
        ((EditArtifactFragment.OnEditCardFragmentListener)localObject1).onCancelEditCredebit();
        break;
      case 2131427634:
        localObject1 = EDIT_CREDEBIT_MAIN_TRACK_PAGE;
        localObject3 = TrackPage.Link.BillingAddress;
        PayPalApp.logLinkPress((TrackPage.Point)localObject1, (TrackPage.Link)localObject3);
        localObject1 = this.mBillAddress;
        ((TextView)localObject1).setEnabled(bool3);
        boolean bool2 = PayPalApp.haveUser();
        if (bool2)
        {
          localObject2 = PayPalApp.getCurrentUser();
          Country localCountry = ((PayPalUser)localObject2).getUserCountry();
          localObject2 = PerCountryData.PersonalInfoPage.Address;
          localObject2 = PerCountryData.getPageConfiguration(localCountry, (PerCountryData.PersonalInfoPage)localObject2);
          if (localObject2 != null)
          {
            startPersonalInfoActivity();
          }
          else
          {
            localObject2 = getActivity();
            int k = 2131493335;
            localObject2 = ((FragmentActivity)localObject2).getString(k);
            showNotSupportedFeatureDialog((String)localObject2);
          }
        }
        break;
      case 2131427630:
        localObject2 = this.mViewExpDate;
        ((TextView)localObject2).setEnabled(bool3);
        localObject2 = EDIT_CREDEBIT_MAIN_TRACK_PAGE;
        TrackPage.Link localLink = TrackPage.Link.ExpirationDate;
        PayPalApp.logLinkPress((TrackPage.Point)localObject2, localLink);
        localObject2 = this.mViewExpDate;
        CharSequence localCharSequence = ((TextView)localObject2).getText();
        if (localCharSequence != null)
        {
          localObject2 = this.mViewExpDate;
          onDateSelected((View)localObject2);
        }
        break;
      }
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    boolean bool1 = true;
    subscribeToWalletOperationBroadcasts(bool1);
    Object localObject1 = EDIT_CREDEBIT_MAIN_TRACK_PAGE;
    setTrackPage((TrackPage.Point)localObject1);
    localObject1 = getArguments();
    Object localObject11 = "unique_id";
    localObject1 = ((Bundle)localObject1).getParcelable((String)localObject11);
    localObject1 = (UniqueId)localObject1;
    this.mUniqueId = ((UniqueId)localObject1);
    localObject1 = AccountModel.getInstance();
    localObject11 = this.mUniqueId;
    Artifact localArtifact = ((AccountModel)localObject1).getArtifactById((UniqueId)localObject11);
    int i = 2130903196;
    localObject11 = null;
    View localView9 = paramLayoutInflater.inflate(i, (ViewGroup)localObject11);
    this.mRoot = localView9;
    Object localObject14;
    ViewGroup localViewGroup;
    int i2;
    int i14;
    if (localView9 != null)
    {
      i = 2131427489;
      View localView1 = localView9.findViewById(i);
      this.mDoneButton = localView1;
      boolean bool2 = localArtifact instanceof CredebitCard;
      if (!bool2)
        break label768;
      int j = 2131427928;
      View localView2 = localView9.findViewById(j);
      int i13 = 0;
      localView2.setVisibility(i13);
      int k = 2131427929;
      Object localObject2 = localView9.findViewById(k);
      i13 = 8;
      ((View)localObject2).setVisibility(i13);
      localObject2 = localArtifact;
      localObject2 = (CredebitCard)localObject2;
      this.mOriginalCard = ((CredebitCard)localObject2);
      localObject2 = getMutableCredebitCard();
      this.mEditedCard = ((MutableCredebitCard)localObject2);
      int m = 2131427634;
      Object localObject3 = localView9.findViewById(m);
      localObject3 = (TextView)localObject3;
      this.mBillAddress = ((TextView)localObject3);
      localObject3 = this.mDoneButton;
      i13 = 0;
      ((View)localObject3).setEnabled(i13);
      int n = 2131427630;
      Object localObject4 = localView9.findViewById(n);
      localObject4 = (TextView)localObject4;
      this.mViewExpDate = ((TextView)localObject4);
      int i1 = 2131427926;
      Object localObject5 = localView9.findViewById(i1);
      FragmentActivity localFragmentActivity = getActivity();
      boolean bool6 = true;
      Bundle localBundle1 = getArguments();
      localObject14 = "position";
      int i18 = localBundle1.getInt((String)localObject14);
      localObject14 = paramLayoutInflater;
      localViewGroup = paramViewGroup;
      WalletArtifactAdapter.populateView((View)localObject5, localArtifact, localFragmentActivity, bool6, i18, (LayoutInflater)localObject14, localViewGroup);
      localObject5 = this.mEditedCard;
      localObject5 = ((MutableCredebitCard)localObject5).getType();
      AddCardFragment.CardType localCardType = AddCardFragment.CardType.fromCardNameFromAPIName((String)localObject5);
      localObject5 = AccountModel.getInstance();
      localObject5 = ((AccountModel)localObject5).getDetails();
      localObject5 = ((AccountDetails)localObject5).getAccountCountryCode();
      boolean bool3 = isCardOnEditableBlacklist(localCardType, (String)localObject5);
      if (!bool3)
        break label526;
      i2 = 2131427630;
      i14 = 0;
      ViewUtility.showOrHide(localView9, i2, i14);
      i2 = 2131427634;
      i14 = 0;
      ViewUtility.showOrHide(localView9, i2, i14);
      i2 = 2131427932;
      i14 = 0;
      ViewUtility.showOrHide(localView9, i2, i14);
      i2 = 2131427930;
      i14 = 0;
      ViewUtility.showOrHide(localView9, i2, i14);
      i2 = 2131427931;
      i14 = 0;
      ViewUtility.showOrHide(localView9, i2, i14);
    }
    while (true)
    {
      i2 = 2131427655;
      View localView3 = localView9.findViewById(i2);
      localView3.setOnClickListener(this);
      int i3 = 2131427922;
      Object localObject6 = localView9.findViewById(i3);
      ((View)localObject6).setOnClickListener(this);
      return localView9;
      label526: localObject6 = localArtifact.getStatus();
      String str;
      label542: Object localObject12;
      if (localObject6 == null)
      {
        str = "";
        localObject6 = "expired";
        boolean bool8 = str.equalsIgnoreCase((String)localObject6);
        if (bool8)
        {
          int i4 = 2131427927;
          localObject7 = localView9.findViewById(i4);
          i14 = 0;
          ((View)localObject7).setVisibility(i14);
        }
        Object localObject7 = this.mViewExpDate;
        MutableCredebitCard localMutableCredebitCard1 = this.mEditedCard;
        int i15 = localMutableCredebitCard1.getExpirationYear();
        MutableCredebitCard localMutableCredebitCard2 = this.mEditedCard;
        int i17 = localMutableCredebitCard2.getExpirationMonth();
        localObject12 = CardFormatter.formatExpirationDate(i15, i17);
        i17 = 0;
        Object[] arrayOfObject = new Object[i17];
        localObject12 = String.format((String)localObject12, arrayOfObject);
        ((TextView)localObject7).setText((CharSequence)localObject12);
        localObject12 = this.mViewExpDate;
        if (!bool8)
          break label760;
      }
      label760: int i6;
      for (int i5 = -5037289; ; i6 = -13421773)
      {
        ((TextView)localObject12).setTextColor(i5);
        Object localObject8 = this.mEditedCard;
        MutableAddress localMutableAddress = ((MutableCredebitCard)localObject8).getBillingAddress();
        localObject8 = this.mBillAddress;
        localObject12 = localMutableAddress.getFormattedLines();
        setAddressToTextView((TextView)localObject8, (List)localObject12);
        localObject8 = this.mBillAddress;
        ((TextView)localObject8).setOnClickListener(this);
        localObject8 = this.mDoneButton;
        ((View)localObject8).setOnClickListener(this);
        localObject8 = this.mViewExpDate;
        ((TextView)localObject8).setOnClickListener(this);
        updateDoneButton();
        break;
        str = localArtifact.getStatus();
        break label542;
      }
      label768: boolean bool4 = localArtifact instanceof BankAccount;
      if (bool4)
      {
        int i7 = 2131427928;
        View localView4 = localView9.findViewById(i7);
        int i16 = 8;
        localView4.setVisibility(i16);
        int i8 = 2131427929;
        View localView5 = localView9.findViewById(i8);
        i16 = 0;
        localView5.setVisibility(i16);
        int i9 = 2131427813;
        Object localObject9 = localView9.findViewById(i9);
        localObject9 = (TextView)localObject9;
        this.mStatus = ((TextView)localObject9);
        int i10 = 2131427810;
        Object localObject10 = localView9.findViewById(i10);
        localObject10 = (TextView)localObject10;
        this.mAccountType = ((TextView)localObject10);
        localObject10 = this.mStatus;
        Object localObject13 = localArtifact.getStatus();
        ((TextView)localObject10).setText((CharSequence)localObject13);
        localObject13 = this.mAccountType;
        localObject10 = localArtifact;
        localObject10 = (BankAccount)localObject10;
        localObject10 = ((BankAccount)localObject10).getAccountType();
        localObject10 = ((BankAccountType)localObject10).getName();
        ((TextView)localObject13).setText((CharSequence)localObject10);
        int i11 = 2131427926;
        View localView6 = localView9.findViewById(i11);
        localObject13 = getActivity();
        boolean bool7 = true;
        Bundle localBundle2 = getArguments();
        localObject14 = "position";
        int i19 = localBundle2.getInt((String)localObject14);
        localObject14 = paramLayoutInflater;
        localViewGroup = paramViewGroup;
        WalletArtifactAdapter.populateView(localView6, localArtifact, (Context)localObject13, bool7, i19, (LayoutInflater)localObject14, localViewGroup);
        int i12 = 2131427928;
        View localView8 = localView9.findViewById(i12);
        i12 = 8;
        localView8.setVisibility(i12);
        View localView7 = this.mDoneButton;
        boolean bool5 = false;
        localView7.setEnabled(bool5);
      }
    }
  }

  public void onDateSelected(View paramView)
  {
    int n = 0;
    MonthYearPopup localMonthYearPopup = new com/paypal/android/p2pmobile/fragment/dialogs/MonthYearPopup;
    Object localObject = getActivity();
    int m = 2131558701;
    TrackPage.Point localPoint = EDIT_CREDEBIT_EXP_DATE_TRACK_PAGE;
    EditArtifactFragment localEditArtifactFragment = this;
    int i1 = n;
    localMonthYearPopup.<init>((Context)localObject, m, localEditArtifactFragment, n, i1, localPoint);
    localObject = new com/paypal/android/p2pmobile/fragment/wallet/EditArtifactFragment$1;
    ((EditArtifactFragment.1)localObject).<init>(this);
    localMonthYearPopup.setOnDismissListener((DialogInterface.OnDismissListener)localObject);
    Calendar localCalendar2 = Calendar.getInstance();
    Calendar localCalendar1 = Calendar.getInstance();
    int i = 2;
    m = 11;
    localCalendar1.set(i, m);
    i = 1;
    m = 2100;
    localCalendar1.set(i, m);
    localMonthYearPopup.setRange(localCalendar2, localCalendar1);
    MutableCredebitCard localMutableCredebitCard1 = this.mEditedCard;
    int j = localMutableCredebitCard1.getExpirationMonth();
    localMonthYearPopup.setMonth(j);
    MutableCredebitCard localMutableCredebitCard2 = this.mEditedCard;
    int k = localMutableCredebitCard2.getExpirationYear();
    localMonthYearPopup.setYear(k);
    localMonthYearPopup.show();
  }

  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = getActivity();
    localObject = (ActionBarActivity)localObject;
    localObject = ((ActionBarActivity)localObject).getSupportActionBar();
    ((ActionBar)localObject).show();
  }

  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    Object localObject = getActivity();
    localObject = (ActionBarActivity)localObject;
    ActionBar localActionBar = ((ActionBarActivity)localObject).getSupportActionBar();
    if (paramBoolean)
      localActionBar.show();
    while (true)
    {
      return;
      localActionBar.hide();
    }
  }

  public void onPause()
  {
    super.onPause();
    Object localObject = getActivity();
    localObject = (ActionBarActivity)localObject;
    localObject = ((ActionBarActivity)localObject).getSupportActionBar();
    ((ActionBar)localObject).show();
  }

  public void onResume()
  {
    super.onResume();
    Object localObject = getActivity();
    localObject = (ActionBarActivity)localObject;
    localObject = ((ActionBarActivity)localObject).getSupportActionBar();
    ((ActionBar)localObject).hide();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    String str = "addressIndex";
    int i = this.mAddressIndex;
    paramBundle.putInt(str, i);
    str = "addressList";
    ArrayList localArrayList = this.mAddresses;
    paramBundle.putParcelableArrayList(str, localArrayList);
    str = "actionFailed";
    boolean bool = this.mActionFailed;
    paramBundle.putBoolean(str, bool);
  }

  public void onYMSet(Dialog paramDialog, int paramInt1, int paramInt2)
  {
    Object localObject = this.mEditedCard;
    ((MutableCredebitCard)localObject).setExpirationYear(paramInt1);
    localObject = this.mEditedCard;
    ((MutableCredebitCard)localObject).setExpirationMonth(paramInt2);
    localObject = this.mViewExpDate;
    String str = CardFormatter.formatExpirationDate(paramInt1, paramInt2);
    ((TextView)localObject).setText(str);
    updateDoneButton();
    localObject = this.mViewExpDate;
    boolean bool = true;
    ((TextView)localObject).setEnabled(bool);
  }

  private Calendar parseExpirationDate(String paramString)
  {
    Object localObject1;
    if (paramString != null)
    {
      String str1 = paramString.trim();
      int k = str1.length();
      if (k != 0);
    }
    else
    {
      localObject1 = this.mSelectDate;
      ((Calendar)localObject1).clear();
      localObject1 = this.mSelectDate;
    }
    while (true)
    {
      return localObject1;
      try
      {
        StringTokenizer localStringTokenizer = new java/util/StringTokenizer;
        localObject1 = "/";
        localStringTokenizer.<init>(paramString, (String)localObject1);
        boolean bool = localStringTokenizer.hasMoreTokens();
        if (bool)
        {
          Object localObject2 = localStringTokenizer.nextToken();
          localObject2 = Integer.valueOf((String)localObject2);
          int m = ((Integer)localObject2).intValue();
          int i = m + -1;
          Object localObject3 = localStringTokenizer.nextToken();
          localObject3 = Integer.valueOf((String)localObject3);
          int j = ((Integer)localObject3).intValue();
          int n = 1970;
          if ((j >= n) && (i >= 0))
          {
            n = 12;
            if (i < n)
            {
              localObject4 = this.mSelectDate;
              int i1 = 1;
              ((Calendar)localObject4).set(j, i, i1);
            }
          }
        }
        localObject4 = this.mSelectDate;
      }
      catch (Exception localException)
      {
        while (true)
        {
          Object localObject4 = LOG_TAG;
          String str2 = "Unable to parse expiration date";
          Logging.d((String)localObject4, str2);
        }
      }
    }
  }

  private void setAddressToTextView(TextView paramTextView, List<String> paramList)
  {
    String str = CardFormatter.getFormattedAddressAsString(paramList);
    paramTextView.setText(str);
    updateDoneButton();
  }

  protected void showNotSupportedFeatureDialog(String paramString)
  {
    FragmentManager localFragmentManager1 = getFragmentManager();
    String str = "dialog";
    Object localObject = localFragmentManager1.findFragmentByTag(str);
    boolean bool = localObject instanceof DialogFragment;
    if (bool)
    {
      localObject = (DialogFragment)localObject;
      ((DialogFragment)localObject).dismiss();
    }
    int i = 0;
    MessageDialog localMessageDialog = MessageDialog.newInstance(paramString);
    if (localMessageDialog != null)
    {
      FragmentManager localFragmentManager2 = getFragmentManager();
      str = "dialog";
      localMessageDialog.show(localFragmentManager2, str);
    }
  }

  private void startPersonalInfoActivity()
  {
    Object localObject1 = getActivity();
    localObject1 = ((FragmentActivity)localObject1).getWindow();
    int j = 3;
    ((Window)localObject1).setSoftInputMode(j);
    int i1 = 0;
    List localList = getAddressesFromModel();
    if (localList != null);
    int k;
    Object localObject3;
    for (int m = localList.size(); ; m = 0)
    {
      k = 0;
      localObject1 = this.mModifiedAddressList;
      if (localObject1 != null)
        break;
      localObject4 = new java/util/ArrayList;
      ((ArrayList)localObject4).<init>();
      if (localList == null)
        break label139;
      localIterator = localList.iterator();
      while (true)
      {
        boolean bool1 = localIterator.hasNext();
        if (!bool1)
          break;
        localObject3 = localIterator.next();
        localObject3 = (Address)localObject3;
        localObject2 = new com/paypal/android/foundation/core/model/MutableAddress;
        ((MutableAddress)localObject2).<init>((Address)localObject3);
        ((List)localObject4).add(localObject2);
      }
    }
    Object localObject4 = this.mModifiedAddressList;
    label139: Object localObject2 = this.mEditedCard;
    MutableAddress localMutableAddress = ((MutableCredebitCard)localObject2).getBillingAddress();
    Iterator localIterator = ((List)localObject4).iterator();
    while (true)
    {
      boolean bool2 = localIterator.hasNext();
      if (!bool2)
        break;
      localObject3 = localIterator.next();
      localObject3 = (MutableAddress)localObject3;
      String str1 = ((MutableAddress)localObject3).getFormatted();
      str3 = localMutableAddress.getFormatted();
      boolean bool3 = TextUtils.equals(str1, str3);
      if (bool3)
        k = ((List)localObject4).indexOf(localObject3);
    }
    String str2 = getAccountCountryCode();
    ArrayList localArrayList = CardFormatter.transformAddressList((List)localObject4, str2);
    int i = 2131493453;
    String str3 = getString(i);
    int n = 13;
    TrackPage.Point localPoint = EDIT_CREDEBIT_MAIN_TRACK_PAGE;
    EditArtifactFragment localEditArtifactFragment = this;
    AddCardPersonalInfoActivity.start(localEditArtifactFragment, str3, localArrayList, k, m, n, localPoint);
  }

  protected void updateDoneButton()
  {
    boolean bool2 = isExpDateChanged();
    if (!bool2)
    {
      bool2 = isBillingAddressChanged();
      if (!bool2)
        break label32;
    }
    label32: for (boolean bool1 = true; ; bool1 = false)
    {
      View localView = this.mDoneButton;
      localView.setEnabled(bool1);
      return;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.EditArtifactFragment
 * JD-Core Version:    0.6.2
 */
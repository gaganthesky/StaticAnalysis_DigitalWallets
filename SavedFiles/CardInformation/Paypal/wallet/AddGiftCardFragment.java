package com.paypal.android.p2pmobile.fragment.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.paypal.android.base.server.tracking.TrackPage.Link;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.account.model.GiftCard.Id;
import com.paypal.android.foundation.account.model.GiftProgram;
import com.paypal.android.foundation.account.model.GiftProgram.Id;
import com.paypal.android.foundation.account.model.Merchant;
import com.paypal.android.foundation.account.model.MutableGiftCard;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.foundation.core.model.MutableMoneyValue;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.activity.BaseChoreographer;
import com.paypal.android.p2pmobile.activity.WalletActivity;
import com.paypal.android.p2pmobile.core.AppContext;
import com.paypal.android.p2pmobile.core.AppIntentFactory.GiftCardOperation;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.managers.GiftCardManager;
import com.paypal.android.p2pmobile.tracking.GiftCardTrackingHelper;
import com.paypal.android.p2pmobile.utils.GiftCardUtils;
import com.paypal.android.p2pmobile.utils.ImageLoader;
import com.paypal.android.p2pmobile.utils.InputUtils;
import com.paypal.android.p2pmobile.utils.TrackListener;
import com.paypal.android.p2pmobile.utils.ViewUtility;
import com.paypal.android.p2pmobile.utils.WalletDialogUtil;
import com.paypal.android.p2pmobile.utils.WalletDialogUtil.IWalletDialogListener;
import com.paypal.android.p2pmobile.utils.WalletNumberFormatUtil;
import com.paypal.android.p2pmobile.widgets.OutlineDrawable;
import com.paypal.android.p2pmobile.widgets.PicassoCardImageView;
import com.paypal.android.p2pmobile.widgets.RobotoCardEditText;
import com.paypal.android.p2pmobile.widgets.RobotoEditText;
import com.squareup.picasso.Target;
import java.util.Map;

public class AddGiftCardFragment extends BaseFragment
  implements View.OnClickListener, WalletDialogUtil.IWalletDialogListener
{
  public static final String BUNDLE_CARD_NUMBER = "cardNumber";
  public static final String BUNDLE_GIFT_CARD_PROGRAM_ID = "giftCardProgramId";
  public static final String BUNDLE_HAS_AUTO_BALANCE = "hasAutoBalance";
  public static final String BUNDLE_PIN_NUMBER = "pinNumber";
  private static final int GROUP_COUNT = 4;
  private static final DebugLogger L = (DebugLogger)localObject;
  private GiftCard.Id mAddedGiftCardId;
  private String mCardNumberValue;
  private String mGiftCardProgramId;
  private boolean mHasAutoBalance;
  private MutableMoneyValue mManualBalance;
  private String mPinNumberValue;
  private GiftProgram mProgram;
  private View mRoot;

  static
  {
    Object localObject = AddGiftCardFragment.class;
    localObject = DebugLogger.getLogger((Class)localObject);
  }

  private Map<String, String> assembleAdditionalTrackingParameters()
  {
    Object localObject = this.mProgram;
    boolean bool = ((GiftProgram)localObject).isBalanceSupported();
    GiftProgram localGiftProgram = this.mProgram;
    if (bool);
    for (localObject = "addcardautomatedbalance"; ; localObject = "addcardmanualbalance")
    {
      localObject = GiftCardTrackingHelper.getAdditionalParameters(localGiftProgram, (String)localObject);
      return localObject;
    }
  }

  private void createGiftAddCardView()
  {
    Object localObject4 = getGiftCardManager();
    if (localObject4 == null);
    do
    {
      return;
      localObject4 = getGiftCardManager();
      localObject8 = this.mGiftCardProgramId;
      localObject4 = ((GiftCardManager)localObject4).getGiftCardProgram((String)localObject8);
      this.mProgram = ((GiftProgram)localObject4);
      localObject4 = this.mProgram;
    }
    while (localObject4 == null);
    localObject4 = this.mProgram;
    localObject4 = ((GiftProgram)localObject4).getIssuingMerchant();
    String str2 = ((Merchant)localObject4).getName();
    localObject4 = this.mProgram;
    String str1 = ((GiftProgram)localObject4).getFrontImageUri();
    localObject4 = this.mProgram;
    boolean bool2 = ((GiftProgram)localObject4).isBalanceSupported();
    Object localObject8 = this.mRoot;
    int i2 = 2131428070;
    label114: boolean bool1;
    label318: Object localObject9;
    label533: label560: int i3;
    if (!bool2)
    {
      boolean bool3 = true;
      ViewUtility.showOrHide((View)localObject8, i2, bool3);
      if (!bool2)
      {
        Object localObject5 = this.mRoot;
        n = 2131428071;
        Object localObject10 = getResources();
        localObject10 = GiftCardUtils.getManualBalanceHint((Resources)localObject10);
        ViewUtility.setHint((View)localObject5, n, (CharSequence)localObject10);
        localObject5 = this.mProgram;
        localObject5 = ((GiftProgram)localObject5).getCustomerSupportPhone();
        boolean bool4 = TextUtils.isEmpty((CharSequence)localObject5);
        if (bool4)
          break label663;
        View localView1 = this.mRoot;
        n = 2131428072;
        boolean bool7 = true;
        ViewUtility.showOrHide(localView1, n, bool7);
        localView1 = this.mRoot;
        n = 2131428072;
        localObject11 = getResources();
        localObject12 = this.mProgram;
        localObject12 = ((GiftProgram)localObject12).getIssuingMerchant();
        localObject12 = ((Merchant)localObject12).getName();
        Object localObject13 = this.mProgram;
        localObject13 = ((GiftProgram)localObject13).getCustomerSupportPhone();
        localObject11 = GiftCardUtils.getManualBalanceInfoText((Resources)localObject11, (String)localObject12, (String)localObject13);
        ViewUtility.setText(localView1, n, (CharSequence)localObject11);
        localView1 = this.mRoot;
        n = 2131428072;
        Object localObject3 = localView1.findViewById(n);
        localObject3 = (TextView)localObject3;
        if (localObject3 != null)
        {
          int i = 4;
          Linkify.addLinks((TextView)localObject3, i);
        }
      }
      View localView2 = this.mRoot;
      int n = 2131428065;
      Object localObject11 = getResources();
      Object localObject12 = this.mProgram;
      localObject12 = ((GiftProgram)localObject12).getCardNumberLabel();
      localObject11 = GiftCardUtils.getCardNumberHint((Resources)localObject11, (String)localObject12);
      ViewUtility.setHint(localView2, n, (CharSequence)localObject11);
      localView2 = this.mRoot;
      n = 2131428066;
      localObject11 = getResources();
      localObject12 = this.mProgram;
      localObject12 = ((GiftProgram)localObject12).getPinLabel();
      localObject11 = GiftCardUtils.getPinHint((Resources)localObject11, (String)localObject12);
      ViewUtility.setHint(localView2, n, (CharSequence)localObject11);
      localView2 = this.mRoot;
      n = 2131428063;
      Object localObject2 = localView2.findViewById(n);
      localObject2 = (TextView)localObject2;
      if (localObject2 != null)
        ((TextView)localObject2).setText(str2);
      localView2 = this.mRoot;
      n = 2131427933;
      Object localObject1 = localView2.findViewById(n);
      localObject1 = (PicassoCardImageView)localObject1;
      if (localObject1 == null)
        break label736;
      if (str1 == null)
        break label688;
      int j = str1.length();
      if (j <= 0)
        break label688;
      Object localObject6 = AppContext.getImageLoader();
      ((ImageLoader)localObject6).DisplayImageTarget(str1, (Target)localObject1);
      ((PicassoCardImageView)localObject1).setContentDescription(str2);
      localObject6 = this.mRoot;
      n = 2131428061;
      boolean bool8 = true;
      ViewUtility.showOrHide((View)localObject6, n, bool8);
      localObject6 = this.mProgram;
      localObject6 = ((GiftProgram)localObject6).getBackImageUri();
      boolean bool5 = TextUtils.isEmpty((CharSequence)localObject6);
      if (bool5)
        break label761;
      bool1 = true;
      View localView3 = this.mRoot;
      n = 2131428067;
      ViewUtility.showOrHide(localView3, n, bool1);
      if (bool1)
      {
        int k = 2131428075;
        localObject9 = this.mProgram;
        localObject9 = ((GiftProgram)localObject9).getBackImageUri();
        loadImage(k, (String)localObject9);
      }
      localObject9 = this.mRoot;
      i3 = 2131428073;
      Object localObject7 = this.mProgram;
      localObject7 = ((GiftProgram)localObject7).getTermsUri();
      bool6 = TextUtils.isEmpty((CharSequence)localObject7);
      if (bool6)
        break label766;
    }
    label663: label688: label736: label761: label766: int m;
    for (boolean bool6 = true; ; m = 0)
    {
      ViewUtility.showOrHide((View)localObject9, i3, bool6);
      break;
      bool6 = false;
      break label114;
      View localView4 = this.mRoot;
      int i1 = 2131428072;
      i3 = 0;
      ViewUtility.showOrHide(localView4, i1, i3);
      break label318;
      localView4 = this.mRoot;
      i1 = 2131428061;
      boolean bool9 = false;
      ViewUtility.showOrHide(localView4, i1, bool9);
      localView4 = this.mRoot;
      i1 = 2131428062;
      bool9 = true;
      ViewUtility.showOrHide(localView4, i1, bool9);
      break label533;
      localView4 = this.mRoot;
      i1 = 2131428062;
      bool9 = true;
      ViewUtility.showOrHide(localView4, i1, bool9);
      break label533;
      bool1 = false;
      break label560;
    }
  }

  private void createGiftCard(String paramString1, String paramString2, MutableMoneyValue paramMutableMoneyValue, GiftProgram paramGiftProgram)
  {
    showProgressDialog();
    MutableGiftCard localMutableGiftCard = new com/paypal/android/foundation/account/model/MutableGiftCard;
    localMutableGiftCard.<init>();
    GiftProgram.Id localId = paramGiftProgram.getUniqueId();
    localMutableGiftCard.setGiftProgramId(localId);
    localMutableGiftCard.setCardNumber(paramString1);
    boolean bool = TextUtils.isEmpty(paramString2);
    if (!bool)
      localMutableGiftCard.setPin(paramString2);
    if (paramMutableMoneyValue != null)
      localMutableGiftCard.setBalance(paramMutableMoneyValue);
    Object localObject = assembleAdditionalTrackingParameters();
    setAdditionalTrackParameters((Map)localObject);
    localObject = getGiftCardManager();
    if (localObject != null)
    {
      localObject = getGiftCardManager();
      ((GiftCardManager)localObject).createGiftCard(localMutableGiftCard);
    }
  }

  private GiftCardManager getGiftCardManager()
  {
    Object localObject = PayPalApp.getApp();
    FragmentActivity localFragmentActivity = getActivity();
    localObject = ((PayPalApp)localObject).getGiftCardManager(localFragmentActivity);
    return localObject;
  }

  private int getKeyBoardInputTypeFromRegex(String paramString)
  {
    int n = 1;
    int m = 0;
    int i = -1;
    String str1 = "\\w";
    boolean bool1 = paramString.contains(str1);
    int k;
    int j;
    if (!bool1)
    {
      String str2 = "a-z";
      boolean bool2 = paramString.contains(str2);
      if (!bool2);
    }
    else
    {
      k = n;
      String str3 = "\\d";
      boolean bool3 = paramString.contains(str3);
      if (!bool3)
      {
        String str4 = "0-9";
        boolean bool4 = paramString.contains(str4);
        if (!bool4)
          break label105;
      }
      j = n;
      label85: if ((j == 0) || (k != 0))
        break label111;
    }
    label105: label111: for (i = 3; ; i = 524433)
    {
      return i;
      k = m;
      break;
      j = m;
      break label85;
    }
  }

  private AddGiftCardFragment.OnAddGiftCardFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (AddGiftCardFragment.OnAddGiftCardFragmentListener)localObject;
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
      ((AddGiftCardFragment.OnAddGiftCardFragmentListener)localObject).hideProgressDialog();
    }
  }

  private static boolean isWithinRange(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = false;
    if (paramInt1 > 0)
      bool1 = true;
    if (paramInt3 > 0)
    {
      if ((bool1) && (paramInt3 <= paramInt1))
        bool1 = bool2;
    }
    else
    {
      if (paramInt2 <= 0)
        break label60;
      if ((!bool1) || (paramInt1 > paramInt2))
        break label53;
    }
    while (true)
    {
      return bool2;
      bool1 = bool3;
      break;
      label53: bool2 = bool3;
      continue;
      label60: bool2 = bool1;
    }
  }

  private void loadImage(int paramInt, String paramString)
  {
    Object localObject2 = this.mRoot;
    Object localObject1 = ((View)localObject2).findViewById(paramInt);
    localObject1 = (ImageView)localObject1;
    if (localObject1 != null)
    {
      localObject2 = AppContext.getImageLoader();
      ((ImageLoader)localObject2).DisplayImage(paramString, (ImageView)localObject1);
    }
  }

  public static AddGiftCardFragment newInstance()
  {
    AddGiftCardFragment localAddGiftCardFragment = new com/paypal/android/p2pmobile/fragment/wallet/AddGiftCardFragment;
    localAddGiftCardFragment.<init>();
    return localAddGiftCardFragment;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    FragmentActivity localFragmentActivity = getActivity();
    InputUtils.hideSoftInputFromWindow(localFragmentActivity);
  }

  public void onBackPressed()
  {
    AddGiftCardFragment.OnAddGiftCardFragmentListener localOnAddGiftCardFragmentListener1 = getLocalListener();
    if (localOnAddGiftCardFragmentListener1 != null)
    {
      localOnAddGiftCardFragmentListener2 = getLocalListener();
      GiftCard.Id localId = this.mAddedGiftCardId;
      boolean bool = false;
      localOnAddGiftCardFragmentListener2.removeAddedGiftCardSilently(localId, bool);
    }
    AddGiftCardFragment.OnAddGiftCardFragmentListener localOnAddGiftCardFragmentListener2 = null;
    this.mAddedGiftCardId = localOnAddGiftCardFragmentListener2;
  }

  public void onClick(View paramView)
  {
    int k = 1;
    int m = 2131428074;
    int i = paramView.getId();
    switch (i)
    {
    default:
    case 2131428058:
    case 2131428068:
    case 2131428069:
    case 2131428073:
    case 2131428074:
    }
    while (true)
    {
      return;
      Object localObject1 = TrackPage.Link.AddCard;
      logLinkPress((TrackPage.Link)localObject1);
      localObject1 = this.mCardNumberValue;
      Object localObject5 = this.mPinNumberValue;
      Object localObject6 = this.mManualBalance;
      GiftProgram localGiftProgram = this.mProgram;
      createGiftCard((String)localObject1, (String)localObject5, (MutableMoneyValue)localObject6, localGiftProgram);
      continue;
      localObject1 = TrackPage.Link.WhereCanIFindMyInformation;
      logLinkPress((TrackPage.Link)localObject1);
      localObject1 = this.mProgram;
      localObject1 = ((GiftProgram)localObject1).getBackImageUri();
      boolean bool1 = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool1)
      {
        Object localObject2 = TrackPage.Point.GiftCardBackOfCardImage;
        localObject5 = assembleAdditionalTrackingParameters();
        PayPalApp.logPageView((TrackPage.Point)localObject2, (Map)localObject5);
        localObject2 = this.mRoot;
        ViewUtility.showOrHide((View)localObject2, localGiftProgram, localObject6);
        localObject2 = this.mRoot;
        View localView = ((View)localObject2).findViewById(localGiftProgram);
        localView.setFocusableInTouchMode(localObject6);
        localView.requestFocus();
        localObject2 = new com/paypal/android/p2pmobile/fragment/wallet/AddGiftCardFragment$4;
        ((AddGiftCardFragment.4)localObject2).<init>(this);
        localView.setOnKeyListener((View.OnKeyListener)localObject2);
        int j = 2131428075;
        localObject5 = this.mProgram;
        localObject5 = ((GiftProgram)localObject5).getBackImageUri();
        loadImage(j, (String)localObject5);
        continue;
        Object localObject3 = TrackPage.Link.TermsAndConditions;
        logLinkPress((TrackPage.Link)localObject3);
        localObject3 = this.mProgram;
        localObject3 = ((GiftProgram)localObject3).getTermsUri();
        boolean bool2 = TextUtils.isEmpty((CharSequence)localObject3);
        if (!bool2)
        {
          Object localObject4 = getActivity();
          InputUtils.hideSoftInputFromWindow((Activity)localObject4);
          localObject4 = getLocalListener();
          localObject5 = this.mProgram;
          localObject5 = ((GiftProgram)localObject5).getTermsUri();
          ((AddGiftCardFragment.OnAddGiftCardFragmentListener)localObject4).onTermsAndCondition((String)localObject5);
          continue;
          localObject4 = TrackPage.Point.GiftCardBackOfCardImage;
          localObject5 = TrackPage.Link.Close;
          localObject6 = assembleAdditionalTrackingParameters();
          PayPalApp.logLinkPress((TrackPage.Point)localObject4, (TrackPage.Link)localObject5, (Map)localObject6);
          localObject4 = this.mRoot;
          boolean bool3 = false;
          ViewUtility.showOrHide((View)localObject4, localGiftProgram, bool3);
        }
      }
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    Object localObject1 = L;
    String str2 = "onCreate called for add gift card";
    int i = 0;
    Object[] arrayOfObject = new Object[i];
    ((DebugLogger)localObject1).debug(str2, arrayOfObject);
    super.onCreate(paramBundle);
    Object localObject2;
    if (paramBundle == null)
    {
      localObject1 = getArguments();
      str2 = "cardNumber";
      localObject1 = ((Bundle)localObject1).getString(str2);
      this.mCardNumberValue = ((String)localObject1);
      localObject1 = getArguments();
      str2 = "pinNumber";
      localObject1 = ((Bundle)localObject1).getString(str2);
      this.mPinNumberValue = ((String)localObject1);
      localObject1 = getArguments();
      str2 = "hasAutoBalance";
      boolean bool1 = ((Bundle)localObject1).getBoolean(str2);
      this.mHasAutoBalance = bool1;
      localObject2 = getArguments();
      str2 = "giftCardProgramId";
      localObject2 = ((Bundle)localObject2).getString(str2);
    }
    String str1;
    for (this.mGiftCardProgramId = ((String)localObject2); ; this.mGiftCardProgramId = str1)
    {
      return;
      localObject2 = "cardNumber";
      localObject2 = paramBundle.getString((String)localObject2);
      this.mCardNumberValue = ((String)localObject2);
      localObject2 = "pinNumber";
      localObject2 = paramBundle.getString((String)localObject2);
      this.mPinNumberValue = ((String)localObject2);
      localObject2 = "hasAutoBalance";
      boolean bool2 = paramBundle.getBoolean((String)localObject2);
      this.mHasAutoBalance = bool2;
      str1 = "giftCardProgramId";
      str1 = paramBundle.getString(str1);
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    DebugLogger localDebugLogger = L;
    String str = "Creating add gift card view ";
    int i5 = 0;
    Object localObject8 = new Object[i5];
    localDebugLogger.info(str, (Object[])localObject8);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    boolean bool1 = false;
    Object localObject1 = this;
    ((AddGiftCardFragment)localObject1).subscribeToWalletOperationBroadcasts(bool1);
    TrackPage.Point localPoint = TrackPage.Point.GiftCardAddCardAddDetails;
    localObject1 = this;
    ((AddGiftCardFragment)localObject1).setTrackPage(localPoint);
    int m = 2130903223;
    boolean bool2 = false;
    localObject1 = paramLayoutInflater;
    ViewGroup localViewGroup = paramViewGroup;
    View localView2 = ((LayoutInflater)localObject1).inflate(m, localViewGroup, bool2);
    localObject1 = this;
    ((AddGiftCardFragment)localObject1).mRoot = localView2;
    localObject1 = this;
    localView2 = ((AddGiftCardFragment)localObject1).mRoot;
    if (localView2 == null);
    Object localObject7;
    for (localView2 = null; ; localObject7 = ((AddGiftCardFragment)localObject1).mRoot)
    {
      return localView2;
      createGiftAddCardView();
      int n = 5;
      int[] arrayOfInt2 = new int[n];
      arrayOfInt2[0] = 2131428058;
      arrayOfInt2[1] = 2131428069;
      arrayOfInt2[2] = 2131428073;
      arrayOfInt2[3] = 2131428074;
      arrayOfInt2[4] = 2131428068;
      int[] arrayOfInt1 = arrayOfInt2;
      int k = arrayOfInt1.length;
      int i = 0;
      while (i < k)
      {
        int j = arrayOfInt1[i];
        localObject1 = this;
        localView3 = ((AddGiftCardFragment)localObject1).mRoot;
        localView3 = localView3.findViewById(j);
        localObject1 = this;
        localView3.setOnClickListener((WalletDialogUtil.IWalletDialogListener)localObject1);
        i += 1;
      }
      localObject1 = this;
      View localView3 = ((AddGiftCardFragment)localObject1).mRoot;
      int i4 = 2131428065;
      Object localObject2 = localView3.findViewById(i4);
      localObject2 = (RobotoCardEditText)localObject2;
      if (localObject2 != null)
      {
        int i1 = 1;
        Object localObject5 = new InputFilter[i1];
        i4 = 0;
        localObject8 = new android/text/InputFilter$LengthFilter;
        localObject1 = this;
        GiftProgram localGiftProgram1 = ((AddGiftCardFragment)localObject1).mProgram;
        int i6 = localGiftProgram1.getCardNumberMaxLength();
        localObject1 = this;
        GiftProgram localGiftProgram3 = ((AddGiftCardFragment)localObject1).mProgram;
        int i8 = localGiftProgram3.getCardNumberMaxLength();
        i8 /= 4;
        i6 += i8;
        ((InputFilter.LengthFilter)localObject8).<init>(i6);
        localObject5[i4] = localObject8;
        ((RobotoCardEditText)localObject2).setFilters((InputFilter[])localObject5);
        localObject1 = this;
        localObject5 = ((AddGiftCardFragment)localObject1).mProgram;
        localObject5 = ((GiftProgram)localObject5).getCardNumberRegex();
        localObject1 = this;
        int i2 = ((AddGiftCardFragment)localObject1).getKeyBoardInputTypeFromRegex((String)localObject5);
        ((RobotoCardEditText)localObject2).setInputType(i2);
        localObject6 = new com/paypal/android/p2pmobile/fragment/wallet/AddGiftCardFragment$1;
        localObject1 = this;
        ((AddGiftCardFragment.1)localObject6).<init>((AddGiftCardFragment)localObject1);
        ((RobotoCardEditText)localObject2).addTextChangedListener((TextWatcher)localObject6);
      }
      localObject1 = this;
      Object localObject6 = ((AddGiftCardFragment)localObject1).mRoot;
      i4 = 2131428066;
      Object localObject4 = ((View)localObject6).findViewById(i4);
      localObject4 = (RobotoEditText)localObject4;
      if (localObject4 != null)
      {
        localObject1 = this;
        localObject6 = ((AddGiftCardFragment)localObject1).mProgram;
        localObject6 = ((GiftProgram)localObject6).getPinRegex();
        localObject1 = this;
        int i3 = ((AddGiftCardFragment)localObject1).getKeyBoardInputTypeFromRegex((String)localObject6);
        ((RobotoEditText)localObject4).setInputType(i3);
        i3 = 1;
        localObject7 = new InputFilter[i3];
        i4 = 0;
        localObject8 = new android/text/InputFilter$LengthFilter;
        localObject1 = this;
        GiftProgram localGiftProgram2 = ((AddGiftCardFragment)localObject1).mProgram;
        int i7 = localGiftProgram2.getPinMaxLength();
        ((InputFilter.LengthFilter)localObject8).<init>(i7);
        localObject7[i4] = localObject8;
        ((RobotoEditText)localObject4).setFilters((InputFilter[])localObject7);
        localObject7 = new com/paypal/android/p2pmobile/fragment/wallet/AddGiftCardFragment$2;
        localObject1 = this;
        ((AddGiftCardFragment.2)localObject7).<init>((AddGiftCardFragment)localObject1);
        ((RobotoEditText)localObject4).addTextChangedListener((TextWatcher)localObject7);
      }
      localObject1 = this;
      localObject7 = ((AddGiftCardFragment)localObject1).mRoot;
      i4 = 2131428071;
      Object localObject3 = ((View)localObject7).findViewById(i4);
      localObject3 = (RobotoEditText)localObject3;
      if (localObject3 != null)
      {
        localObject7 = new com/paypal/android/p2pmobile/fragment/wallet/AddGiftCardFragment$3;
        localObject1 = this;
        ((AddGiftCardFragment.3)localObject7).<init>((AddGiftCardFragment)localObject1, (RobotoEditText)localObject3);
        ((RobotoEditText)localObject3).addTextChangedListener((TextWatcher)localObject7);
      }
      localObject1 = this;
      localObject7 = ((AddGiftCardFragment)localObject1).mRoot;
      i4 = 2131427837;
      View localView1 = ((View)localObject7).findViewById(i4);
      localObject1 = this;
      ((AddGiftCardFragment)localObject1).setBackGround(localView1);
      localObject1 = this;
      localObject7 = ((AddGiftCardFragment)localObject1).mRoot;
      i4 = 2131427938;
      ((View)localObject7).findViewById(i4);
      localObject7 = assembleAdditionalTrackingParameters();
      localObject1 = this;
      ((AddGiftCardFragment)localObject1).setAdditionalTrackParameters((Map)localObject7);
      localObject1 = this;
    }
  }

  protected void onGiftCardOperation(AppIntentFactory.GiftCardOperation paramGiftCardOperation, Intent paramIntent)
  {
    int[] arrayOfInt = AddGiftCardFragment.5.$SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$GiftCardOperation;
    int k = paramGiftCardOperation.ordinal();
    int i = arrayOfInt[k];
    switch (i)
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      Object localObject1 = getLocalListener();
      ((AddGiftCardFragment.OnAddGiftCardFragmentListener)localObject1).stopProgressLoader();
      hideProgressDialogs();
      localObject1 = "data";
      Object localObject3 = paramIntent.getParcelableExtra((String)localObject1);
      localObject3 = (GiftCard.Id)localObject3;
      if (localObject3 != null)
      {
        this.mAddedGiftCardId = ((GiftCard.Id)localObject3);
        localObject1 = getActivity();
        k = -1;
        int m = 2131494949;
        int n = 2131494950;
        int i1 = 2131494951;
        TrackListener localTrackListener = new com/paypal/android/p2pmobile/utils/TrackListener;
        Object localObject2 = TrackPage.Point.GiftCardAddZeroBalanceDialog;
        TrackPage.Link localLink1 = TrackPage.Link.AddGiftCard;
        TrackPage.Link localLink2 = TrackPage.Link.RemoveCard;
        Map localMap = assembleAdditionalTrackingParameters();
        localTrackListener.<init>((TrackPage.Point)localObject2, localLink1, localLink2, localMap);
        localObject2 = this;
        WalletDialogUtil.showTwoButtonDlg((Context)localObject1, k, m, n, i1, (WalletDialogUtil.IWalletDialogListener)localObject2, localTrackListener);
        continue;
        localObject1 = getLocalListener();
        ((AddGiftCardFragment.OnAddGiftCardFragmentListener)localObject1).stopProgressLoader();
        hideProgressDialogs();
        int j = 2131494855;
        String str = getString(j);
        TrackPage.Point localPoint = TrackPage.Point.GiftCardAddDoneError;
        showErrorMessageBanner(paramIntent, str, localPoint);
      }
    }
  }

  public void onNegativeBtn()
  {
    AddGiftCardFragment.OnAddGiftCardFragmentListener localOnAddGiftCardFragmentListener1 = getLocalListener();
    if (localOnAddGiftCardFragmentListener1 != null)
    {
      localOnAddGiftCardFragmentListener2 = getLocalListener();
      GiftCard.Id localId = this.mAddedGiftCardId;
      boolean bool = true;
      localOnAddGiftCardFragmentListener2.removeAddedGiftCardSilently(localId, bool);
    }
    AddGiftCardFragment.OnAddGiftCardFragmentListener localOnAddGiftCardFragmentListener2 = null;
    this.mAddedGiftCardId = localOnAddGiftCardFragmentListener2;
  }

  public void onPositiveBtn()
  {
    AddGiftCardFragment.OnAddGiftCardFragmentListener localOnAddGiftCardFragmentListener = getLocalListener();
    if (localOnAddGiftCardFragmentListener != null)
    {
      localId = this.mAddedGiftCardId;
      localOnAddGiftCardFragmentListener.onAddCardSuccess(localId);
    }
    GiftCard.Id localId = null;
    this.mAddedGiftCardId = localId;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    String str1 = "cardNumber";
    String str2 = this.mCardNumberValue;
    paramBundle.putString(str1, str2);
    str1 = "pinNumber";
    str2 = this.mPinNumberValue;
    paramBundle.putString(str1, str2);
    str1 = "hasAutoBalance";
    boolean bool = this.mHasAutoBalance;
    paramBundle.putBoolean(str1, bool);
    str1 = "giftCardProgramId";
    String str3 = this.mGiftCardProgramId;
    paramBundle.putString(str1, str3);
  }

  public void onShowDialog()
  {
  }

  private void setBackGround(View paramView)
  {
    Resources localResources = getResources();
    int k = 2131231042;
    int j = localResources.getColor(k);
    k = 2131231068;
    int i = localResources.getColor(k);
    OutlineDrawable localOutlineDrawable = new com/paypal/android/p2pmobile/widgets/OutlineDrawable;
    Object localObject = getResources();
    localObject = ((Resources)localObject).getDisplayMetrics();
    float f = ((DisplayMetrics)localObject).density;
    localOutlineDrawable.<init>(f, j, i);
    OutlineDrawable.setBackground(paramView, localOutlineDrawable);
  }

  private void showProgressDialog()
  {
    Object localObject = getActivity();
    localObject = (WalletActivity)localObject;
    localObject = ((WalletActivity)localObject).getCurrentChoreograph();
    int i = 2131494975;
    String str = getString(i);
    ((BaseChoreographer)localObject).showProgressDialog(str);
  }

  private void validateAndToggleAddBtn(String paramString1, String paramString2)
  {
    boolean bool1 = true;
    boolean bool4 = false;
    GiftCardManager localGiftCardManager = getGiftCardManager();
    if (localGiftCardManager == null);
    GiftProgram localGiftProgram;
    do
    {
      return;
      localGiftCardManager = getGiftCardManager();
      String str1 = this.mGiftCardProgramId;
      localGiftProgram = localGiftCardManager.getGiftCardProgram(str1);
    }
    while (localGiftProgram == null);
    int i = localGiftProgram.getCardNumberMinLength();
    int j = localGiftProgram.getCardNumberMaxLength();
    String str2 = localGiftProgram.getCardNumberRegex();
    boolean bool2 = validateString(paramString1, bool1, i, j, str2);
    boolean bool5 = localGiftProgram.isPinRequired();
    j = localGiftProgram.getPinMinLength();
    int k = localGiftProgram.getPinMaxLength();
    String str3 = localGiftProgram.getPinRegex();
    boolean bool3 = validateString(paramString2, bool5, j, k, str3);
    if ((bool2) && (bool3));
    while (true)
    {
      View localView = this.mRoot;
      j = 2131428058;
      ViewUtility.setEnabled(localView, j, bool1);
      localView = this.mRoot;
      j = 2131427662;
      ViewUtility.showOrHide(localView, j, bool4);
      break;
      bool1 = bool4;
    }
  }

  public static boolean validateString(String paramString1, boolean paramBoolean, int paramInt1, int paramInt2, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    boolean bool3 = TextUtils.isEmpty(paramString1);
    if (bool3)
      if (!paramBoolean);
    while (true)
    {
      return bool1;
      bool1 = bool2;
      continue;
      int i = paramString1.length();
      boolean bool4 = isWithinRange(i, paramInt2, paramInt1);
      if (bool4)
      {
        bool1 = WalletNumberFormatUtil.isValidRegEx(paramString2);
        if (!bool1)
          bool1 = bool2;
        else
          bool1 = paramString1.matches(paramString2);
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddGiftCardFragment
 * JD-Core Version:    0.6.2
 */
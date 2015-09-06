package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ebay.redlasersdk.BarcodeResult;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.account.model.LoyaltyProgram;
import com.paypal.android.foundation.account.model.LoyaltyProgram.Id;
import com.paypal.android.foundation.account.model.Merchant;
import com.paypal.android.foundation.account.model.MutableBarcode;
import com.paypal.android.foundation.account.model.MutableLoyaltyCard;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.activity.BaseChoreographer;
import com.paypal.android.p2pmobile.activity.WalletActivity;
import com.paypal.android.p2pmobile.activity.loyaltycard.LoyaltyCardScannerActivity;
import com.paypal.android.p2pmobile.core.AppContext;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.services.ILoyaltyCardService;
import com.paypal.android.p2pmobile.services.LoyaltyCardService;
import com.paypal.android.p2pmobile.utils.ImageLoader;
import com.paypal.android.p2pmobile.utils.ViewUtility;
import com.paypal.android.p2pmobile.widgets.OutlineDrawable;
import java.util.ArrayList;

public class AddLoyaltyCardFragment extends BaseFragment
{
  private static final int CARD_NUM_MAX_LEN = 49;
  private static final int CARD_NUM_MIN_LEN = 4;
  private static final DebugLogger L = (DebugLogger)localObject;
  private static final int SCAN_REQUEST_ID_ADD_LOYALTY_CARD = 1;
  private View mAddBtn;
  private EditText mCardValue;
  private Handler mHandler;
  private boolean mHasBarcode;
  private boolean mIsBoundToLoyaltyCardService;
  private boolean mIsLaunchingAnotherActivity;
  private ILoyaltyCardService mLoyaltyCardService;
  private ServiceConnection mLoyaltyCardServiceConnection;
  private LoyaltyProgram mProgram;
  private String mPromoCode;
  private View mRoot;
  private ImageButton mScanButton;
  private String mScannedBarcodeString;
  private String mScannedBarcodeType;

  static
  {
    Object localObject = AddLoyaltyCardFragment.class;
    localObject = DebugLogger.getLogger((Class)localObject);
  }

  public AddLoyaltyCardFragment()
  {
    boolean bool = true;
    this.mHasBarcode = bool;
    Object localObject = new android/os/Handler;
    ((Handler)localObject).<init>();
    this.mHandler = ((Handler)localObject);
    localObject = new com/paypal/android/p2pmobile/fragment/wallet/AddLoyaltyCardFragment$5;
    ((AddLoyaltyCardFragment.5)localObject).<init>(this);
    this.mLoyaltyCardServiceConnection = ((ServiceConnection)localObject);
  }

  private void addLoyaltyCard(String paramString)
  {
    MutableLoyaltyCard localMutableLoyaltyCard = createMutableLoyaltyCard(paramString);
    createLoyaltyArtifact(localMutableLoyaltyCard);
  }

  private final void bindToLoyaltyCardService()
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

  private void createLoyaltyAddCardView()
  {
    int m = 8;
    int k = 0;
    Object localObject4 = this.mLoyaltyCardService;
    String str3 = this.mPromoCode;
    localObject4 = ((ILoyaltyCardService)localObject4).getLoyaltyProgram(str3);
    this.mProgram = ((LoyaltyProgram)localObject4);
    localObject4 = this.mProgram;
    if (localObject4 == null);
    while (true)
    {
      return;
      localObject4 = this.mProgram;
      localObject4 = ((LoyaltyProgram)localObject4).getMerchant();
      String str2 = ((Merchant)localObject4).getName();
      localObject4 = this.mProgram;
      String str1 = ((LoyaltyProgram)localObject4).getLogoHeaderImageUri();
      localObject4 = this.mProgram;
      boolean bool = ((LoyaltyProgram)localObject4).isAutoRedeem();
      localObject4 = this.mRoot;
      int j = 2131427934;
      Object localObject2 = ((View)localObject4).findViewById(j);
      localObject2 = (TextView)localObject2;
      if (localObject2 != null)
        ((TextView)localObject2).setText(str2);
      localObject4 = this.mRoot;
      j = 2131427937;
      Object localObject3 = ((View)localObject4).findViewById(j);
      localObject3 = (TextView)localObject3;
      if (localObject3 != null)
      {
        localObject4 = this.mScannedBarcodeString;
        if (localObject4 != null)
        {
          localObject4 = this.mScannedBarcodeString;
          ((TextView)localObject3).setText((CharSequence)localObject4);
          ((TextView)localObject3).requestFocus();
        }
      }
      localObject4 = this.mRoot;
      j = 2131427938;
      View localView = ((View)localObject4).findViewById(j);
      if (localView != null)
      {
        if (!bool)
          break label289;
        localView.setVisibility(k);
      }
      Object localObject1;
      while (true)
      {
        localObject4 = this.mRoot;
        j = 2131427933;
        localObject1 = ((View)localObject4).findViewById(j);
        localObject1 = (ImageView)localObject1;
        if (localObject1 == null)
          break label314;
        if (str1 == null)
          break label298;
        int i = str1.length();
        if (i <= 0)
          break label298;
        ImageLoader localImageLoader = AppContext.getImageLoader();
        localImageLoader.DisplayImage(str1, (ImageView)localObject1);
        ((ImageView)localObject1).setContentDescription(str2);
        break;
        label289: localView.setVisibility(m);
      }
      label298: ((ImageView)localObject1).setVisibility(m);
      ((TextView)localObject2).setVisibility(k);
      continue;
      label314: ((TextView)localObject2).setVisibility(k);
    }
  }

  private void createLoyaltyArtifact(MutableLoyaltyCard paramMutableLoyaltyCard)
  {
    showProgressDialog();
    ILoyaltyCardService localILoyaltyCardService = this.mLoyaltyCardService;
    localILoyaltyCardService.createLoyaltyCard(paramMutableLoyaltyCard);
  }

  private MutableLoyaltyCard createMutableLoyaltyCard(String paramString)
  {
    MutableLoyaltyCard localMutableLoyaltyCard = new com/paypal/android/foundation/account/model/MutableLoyaltyCard;
    localMutableLoyaltyCard.<init>();
    String str = this.mScannedBarcodeType;
    boolean bool = TextUtils.isEmpty(str);
    if (!bool)
    {
      MutableBarcode localMutableBarcode = new com/paypal/android/foundation/account/model/MutableBarcode;
      localMutableBarcode.<init>();
      localObject = this.mScannedBarcodeType;
      localMutableBarcode.setType((String)localObject);
      localObject = this.mScannedBarcodeString;
      localMutableBarcode.setValue((String)localObject);
      localMutableLoyaltyCard.setBarcode(localMutableBarcode);
    }
    localMutableLoyaltyCard.setCardNumber(paramString);
    Object localObject = this.mProgram;
    localObject = ((LoyaltyProgram)localObject).getUniqueId();
    localMutableLoyaltyCard.setLoyaltyProgramId((LoyaltyProgram.Id)localObject);
    return localMutableLoyaltyCard;
  }

  private AddLoyaltyCardFragment.OnAddLoyaltyCardFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (AddLoyaltyCardFragment.OnAddLoyaltyCardFragmentListener)localObject;
    return localObject;
  }

  private static void hideScanBarcode(View paramView)
  {
    int j = 8;
    int i = 2131427628;
    Object localObject2 = paramView.findViewById(i);
    localObject2 = (ImageButton)localObject2;
    i = ((ImageButton)localObject2).getVisibility();
    if (j == i);
    while (true)
    {
      return;
      ((ImageButton)localObject2).setVisibility(j);
      i = 2131427672;
      View localView = paramView.findViewById(i);
      if (localView != null)
      {
        Object localObject1 = localView.getLayoutParams();
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        i = 3;
        j = 2131427938;
        ((RelativeLayout.LayoutParams)localObject1).addRule(i, j);
      }
    }
  }

  public static AddLoyaltyCardFragment newInstance()
  {
    AddLoyaltyCardFragment localAddLoyaltyCardFragment = new com/paypal/android/p2pmobile/fragment/wallet/AddLoyaltyCardFragment;
    localAddLoyaltyCardFragment.<init>();
    return localAddLoyaltyCardFragment;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int k = 0;
    int i = 1;
    if (i == paramInt1)
    {
      i = -1;
      if (i == paramInt2)
      {
        String str1 = "com.ebay.redlasersdk.results";
        ArrayList localArrayList = paramIntent.getParcelableArrayListExtra(str1);
        if (localArrayList != null)
        {
          boolean bool = localArrayList.isEmpty();
          if (!bool)
          {
            Object localObject = localArrayList.get(k);
            localObject = (BarcodeResult)localObject;
            localObject = ((BarcodeResult)localObject).barcodeString;
            this.mScannedBarcodeString = ((String)localObject);
            localObject = localArrayList.get(k);
            localObject = (BarcodeResult)localObject;
            int j = ((BarcodeResult)localObject).barcodeType;
            String str2 = String.valueOf(j);
            this.mScannedBarcodeType = str2;
            str2 = this.mScannedBarcodeString;
            addLoyaltyCard(str2);
          }
        }
      }
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    Object localObject1 = L;
    String str2 = "onCreate called for add loyalty card";
    int i = 0;
    Object[] arrayOfObject = new Object[i];
    ((DebugLogger)localObject1).debug(str2, arrayOfObject);
    super.onCreate(paramBundle);
    Object localObject2;
    if (paramBundle == null)
    {
      localObject1 = getArguments();
      str2 = "promoCode";
      localObject1 = ((Bundle)localObject1).getString(str2);
      this.mPromoCode = ((String)localObject1);
      localObject1 = getArguments();
      str2 = "hasBarcode";
      boolean bool1 = ((Bundle)localObject1).getBoolean(str2);
      this.mHasBarcode = bool1;
      Bundle localBundle = getArguments();
      str2 = "barcodeValue";
      String str1 = localBundle.getString(str2);
      boolean bool2 = TextUtils.isEmpty(str1);
      if (!bool2)
      {
        this.mScannedBarcodeString = str1;
        localObject2 = getArguments();
        str2 = "barcodeType";
        localObject2 = ((Bundle)localObject2).getString(str2);
        this.mScannedBarcodeType = ((String)localObject2);
      }
    }
    while (true)
    {
      return;
      localObject2 = "promoCode";
      localObject2 = paramBundle.getString((String)localObject2);
      this.mPromoCode = ((String)localObject2);
      localObject2 = "hasBarcode";
      boolean bool3 = paramBundle.getBoolean((String)localObject2);
      this.mHasBarcode = bool3;
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i1 = 2131427628;
    boolean bool2 = false;
    DebugLogger localDebugLogger = L;
    String str = "Creating add loyalty card view ";
    Object[] arrayOfObject = new Object[bool2];
    localDebugLogger.info(str, arrayOfObject);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    subscribeToWalletOperationBroadcasts(bool2);
    int i = 2130903260;
    Object localObject1 = paramLayoutInflater.inflate(i, paramViewGroup, bool2);
    this.mRoot = ((View)localObject1);
    localObject1 = this.mRoot;
    localObject1 = ((View)localObject1).findViewById(i1);
    localObject1 = (ImageButton)localObject1;
    this.mScanButton = ((ImageButton)localObject1);
    localObject1 = this.mRoot;
    boolean bool1 = this.mHasBarcode;
    ViewUtility.showOrHide((View)localObject1, i1, bool1);
    localObject1 = this.mRoot;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = this.mRoot;
      int k = 2131428058;
      localObject1 = ((View)localObject1).findViewById(k);
      this.mAddBtn = ((View)localObject1);
      localObject1 = this.mAddBtn;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject1 = this.mAddBtn;
        localObject3 = new com/paypal/android/p2pmobile/fragment/wallet/AddLoyaltyCardFragment$2;
        ((AddLoyaltyCardFragment.2)localObject3).<init>(this);
        ((View)localObject1).setOnClickListener((View.OnClickListener)localObject3);
      }
      localObject1 = this.mScanButton;
      if (localObject1 != null)
      {
        localObject1 = this.mScanButton;
        localObject3 = new com/paypal/android/p2pmobile/fragment/wallet/AddLoyaltyCardFragment$3;
        ((AddLoyaltyCardFragment.3)localObject3).<init>(this);
        ((ImageButton)localObject1).setOnClickListener((View.OnClickListener)localObject3);
      }
      localObject1 = this.mRoot;
      int m = 2131427937;
      localObject1 = ((View)localObject1).findViewById(m);
      localObject1 = (EditText)localObject1;
      this.mCardValue = ((EditText)localObject1);
      localObject1 = this.mCardValue;
      if (localObject1 != null)
      {
        localObject1 = this.mCardValue;
        AddLoyaltyCardFragment.4 local4 = new com/paypal/android/p2pmobile/fragment/wallet/AddLoyaltyCardFragment$4;
        local4.<init>(this);
        ((EditText)localObject1).addTextChangedListener(local4);
      }
      localObject1 = this.mRoot;
      int n = 2131427837;
      View localView = ((View)localObject1).findViewById(n);
      setBackGround(localView);
      localObject1 = this.mRoot;
      n = 2131427938;
      ((View)localObject1).findViewById(n);
      localObject1 = this.mScanButton;
      if (localObject1 == null)
        break label389;
      localObject1 = this.mScanButton;
      int j = ((ImageButton)localObject1).getVisibility();
      n = 8;
      if (j != n)
        break label389;
      localObject2 = TrackPage.Point.LoyaltyCardAddCardAddDetailsNoBarCode;
      PayPalApp.logPageView((TrackPage.Point)localObject2);
    }
    while (true)
    {
      localObject2 = this.mRoot;
      return localObject2;
      label389: localObject2 = TrackPage.Point.LoyaltyCardAddCardAddDetails;
      PayPalApp.logPageView((TrackPage.Point)localObject2);
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
    boolean bool1 = false;
    this.mIsLaunchingAnotherActivity = bool1;
    FragmentActivity localFragmentActivity = getActivity();
    boolean bool2 = LoyaltyCardScannerActivity.isScanningEnabled(localFragmentActivity);
    if (!bool2)
    {
      localObject = getView();
      hideScanBarcode((View)localObject);
    }
    Object localObject = this.mHandler;
    AddLoyaltyCardFragment.1 local1 = new com/paypal/android/p2pmobile/fragment/wallet/AddLoyaltyCardFragment$1;
    local1.<init>(this);
    long l = 1000L;
    ((Handler)localObject).postDelayed(local1, l);
    bindToLoyaltyCardService();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    String str1 = this.mPromoCode;
    if (str1 != null)
    {
      str1 = "promoCode";
      String str2 = this.mPromoCode;
      paramBundle.putString(str1, str2);
      str1 = "hasBarcode";
      boolean bool = this.mHasBarcode;
      paramBundle.putBoolean(str1, bool);
    }
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

  private void setCursorLocation()
  {
    Object localObject = this.mScannedBarcodeString;
    if (localObject != null)
    {
      localObject = this.mScannedBarcodeString;
      int i = ((String)localObject).length();
      localObject = this.mCardValue;
      String str = this.mScannedBarcodeString;
      ((EditText)localObject).setText(str);
      localObject = this.mCardValue;
      ((EditText)localObject).setSelection(i);
    }
  }

  private void showProgressDialog()
  {
    Object localObject = getActivity();
    localObject = (WalletActivity)localObject;
    localObject = ((WalletActivity)localObject).getCurrentChoreograph();
    int i = 2131494942;
    String str = getString(i);
    ((BaseChoreographer)localObject).showProgressDialog(str);
  }

  private final void unbindFromLoyaltyCardService()
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

  private void validateAndToggleAddBtn(String paramString)
  {
    int i = paramString.length();
    int j = 4;
    if (i > j)
    {
      j = 49;
      if (i >= j);
    }
    for (boolean bool = true; ; bool = false)
    {
      View localView = this.mAddBtn;
      localView.setEnabled(bool);
      return;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddLoyaltyCardFragment
 * JD-Core Version:    0.6.2
 */
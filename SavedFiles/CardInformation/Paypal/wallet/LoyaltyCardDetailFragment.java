package com.paypal.android.p2pmobile.fragment.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.BackgroundColorSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.BarcodeFormat;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.core.AppContext;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.utils.ContentUtils;
import com.paypal.android.p2pmobile.utils.ImageLoader;
import com.paypal.android.p2pmobile.utils.ImageTools;
import com.paypal.android.p2pmobile.widgets.BarCodeImageView;

public class LoyaltyCardDetailFragment extends BaseFragment
{
  private static final DebugLogger L;
  private static final BackgroundColorSpan TEXT_HIGHLIGHT = (BackgroundColorSpan)localObject;
  private BarCodeImageView barCodeImageView;
  private boolean hasBarCode;
  private boolean isAutoRedeem;
  private String mBarcodeType;
  private String mBarcodeValue;
  private TextView mCardNumberText;
  private String mCodeNumber;
  private String mLoyaltyCardId;
  private String mMerchantLoyaltyId;
  private String mMerchantName;
  private int mPosition;
  private View mRoot;
  private String mTermsAndConditions;
  private String mheaderUrl;

  static
  {
    Object localObject = LoyaltyCardDetailFragment.class;
    localObject = DebugLogger.getLogger((Class)localObject);
    L = (DebugLogger)localObject;
    localObject = new android/text/style/BackgroundColorSpan;
    int i = 1714664933;
    ((BackgroundColorSpan)localObject).<init>(i);
  }

  public LoyaltyCardDetailFragment()
  {
    int i = -1;
    this.mPosition = i;
  }

  private void createLoyaltyCardView()
  {
    int i1 = 8;
    int n = 0;
    TextView localTextView = this.mCardNumberText;
    Object localObject2;
    View localView2;
    View localView1;
    Object localObject3;
    Object[] arrayOfObject;
    label182: Object localObject1;
    View localView3;
    if (localTextView != null)
    {
      localTextView = this.mCardNumberText;
      String str1 = this.mCodeNumber;
      localTextView.setText(str1);
      int i = Build.VERSION.SDK_INT;
      int j = 11;
      if (i >= j)
      {
        localObject2 = this.mCardNumberText;
        j = 1;
        ((TextView)localObject2).setTextIsSelectable(j);
      }
    }
    else
    {
      localObject2 = this.mCodeNumber;
      View localView4 = this.mRoot;
      generateBarCode((String)localObject2, localView4);
      localObject2 = this.mRoot;
      int k = 2131428095;
      localView2 = ((View)localObject2).findViewById(k);
      localObject2 = this.mRoot;
      k = 2131428230;
      localView1 = ((View)localObject2).findViewById(k);
      boolean bool = this.isAutoRedeem;
      if (!bool)
        break label309;
      localObject3 = L;
      String str2 = "Setting auto redeem section";
      arrayOfObject = new Object[n];
      ((DebugLogger)localObject3).debug(str2, arrayOfObject);
      if (localView2 != null)
        localView2.setVisibility(i1);
      if (localView1 != null)
        localView1.setVisibility(n);
      localObject3 = this.mRoot;
      int m = 2131428236;
      localObject1 = ((View)localObject3).findViewById(m);
      localObject1 = (TextView)localObject1;
      localObject3 = this.mRoot;
      m = 2131428234;
      localView3 = ((View)localObject3).findViewById(m);
      if (localView3 != null)
      {
        localObject3 = this.mTermsAndConditions;
        if (localObject3 == null)
          break label358;
        localView3.setVisibility(n);
        localObject3 = this.mTermsAndConditions;
        ((TextView)localObject1).setText((CharSequence)localObject3);
        ((TextView)localObject1).setVisibility(n);
        localObject3 = LinkMovementMethod.getInstance();
        ((TextView)localObject1).setMovementMethod((MovementMethod)localObject3);
        localObject3 = new com/paypal/android/p2pmobile/fragment/wallet/LoyaltyCardDetailFragment$1;
        ((LoyaltyCardDetailFragment.1)localObject3).<init>(this);
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)localObject3);
      }
    }
    while (true)
    {
      return;
      localObject3 = this.mCardNumberText;
      registerForContextMenu((View)localObject3);
      break;
      label309: localObject3 = L;
      String str3 = "Setting manual redeem section";
      arrayOfObject = new Object[n];
      ((DebugLogger)localObject3).debug(str3, arrayOfObject);
      if (localView2 != null)
        localView2.setVisibility(n);
      if (localView1 == null)
        break label182;
      localView1.setVisibility(i1);
      break label182;
      label358: ((TextView)localObject1).setVisibility(i1);
      localView3.setVisibility(i1);
    }
  }

  private void generateBarCode(String paramString, View paramView)
  {
    int i1 = 0;
    int i = 2131428078;
    Object localObject2 = paramView.findViewById(i);
    localObject2 = (BarCodeImageView)localObject2;
    this.barCodeImageView = ((BarCodeImageView)localObject2);
    localObject2 = this.barCodeImageView;
    if (localObject2 != null)
    {
      boolean bool1 = this.hasBarCode;
      if (bool1)
        break label126;
      BarCodeImageView localBarCodeImageView = this.barCodeImageView;
      int k = 8;
      localBarCodeImageView.setVisibility(k);
    }
    while (true)
    {
      int j = 2131428225;
      Object localObject1 = paramView.findViewById(j);
      localObject1 = (ImageView)localObject1;
      String str1 = this.mheaderUrl;
      boolean bool2 = TextUtils.isEmpty(str1);
      Object localObject3;
      String str2;
      if (!bool2)
      {
        localObject3 = AppContext.getImageLoader();
        str2 = this.mheaderUrl;
        ((ImageLoader)localObject3).DisplayImage(str2, (ImageView)localObject1);
      }
      return;
      try
      {
        label126: localObject3 = this.barCodeImageView;
        str2 = this.mBarcodeType;
        int m = Integer.parseInt(str2);
        localObject4 = ImageTools.redLaserToZxingFormat(m);
        ((BarCodeImageView)localObject3).setValue(paramString, (BarcodeFormat)localObject4);
      }
      catch (Exception localException1)
      {
        try
        {
          localObject3 = this.barCodeImageView;
          ((BarCodeImageView)localObject3).setValue(paramString);
          localObject3 = L;
          localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>();
          String str3 = "Unable to set the mBarcodeType: ";
          localObject4 = ((StringBuilder)localObject4).append(str3);
          str3 = this.mBarcodeType;
          localObject4 = ((StringBuilder)localObject4).append(str3);
          localObject4 = ((StringBuilder)localObject4).toString();
          int n = 0;
          localObject5 = new Object[n];
          ((DebugLogger)localObject3).debug((String)localObject4, (Object[])localObject5);
        }
        catch (Exception localException2)
        {
          localObject3 = L;
          Object localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>();
          Object localObject5 = "Unable to set the mBarcodeType: ";
          localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
          localObject5 = this.mBarcodeType;
          localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
          localObject4 = ((StringBuilder)localObject4).toString();
          localObject5 = new Object[i1];
          ((DebugLogger)localObject3).debug((String)localObject4, (Object[])localObject5);
        }
      }
    }
  }

  private LoyaltyCardDetailFragment.OnLoyaltyDetailsFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (LoyaltyCardDetailFragment.OnLoyaltyDetailsFragmentListener)localObject;
    return localObject;
  }

  public static LoyaltyCardDetailFragment newInstance()
  {
    LoyaltyCardDetailFragment localLoyaltyCardDetailFragment = new com/paypal/android/p2pmobile/fragment/wallet/LoyaltyCardDetailFragment;
    localLoyaltyCardDetailFragment.<init>();
    return localLoyaltyCardDetailFragment;
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getGroupId();
    int j = this.mPosition;
    if (i == j)
    {
      i = paramMenuItem.getItemId();
      j = 2131428226;
      if (i == j)
      {
        Object localObject1 = getActivity();
        j = 2131494914;
        String str = getString(j);
        Object localObject2 = this.mCardNumberText;
        localObject2 = ((TextView)localObject2).getText();
        ContentUtils.setClipboardText((Activity)localObject1, str, (CharSequence)localObject2);
        SpannableString localSpannableString = new android/text/SpannableString;
        localObject1 = this.mCardNumberText;
        localObject1 = ((TextView)localObject1).getText();
        localObject1 = ((CharSequence)localObject1).toString();
        localSpannableString.<init>((CharSequence)localObject1);
        localObject1 = TEXT_HIGHLIGHT;
        localSpannableString.removeSpan(localObject1);
        localObject1 = this.mCardNumberText;
        ((TextView)localObject1).setText(localSpannableString);
        localObject1 = getActivity();
        localObject1 = ((FragmentActivity)localObject1).getApplicationContext();
        int k = 2131495069;
        int m = 0;
        localObject1 = Toast.makeText((Context)localObject1, k, m);
        ((Toast)localObject1).show();
      }
    }
    boolean bool = super.onContextItemSelected(paramMenuItem);
    return bool;
  }

  public void onCreate(Bundle paramBundle)
  {
    Object localObject1 = L;
    String str4 = "onCreate called for loyalty card details";
    int k = 0;
    Object[] arrayOfObject = new Object[k];
    ((DebugLogger)localObject1).info(str4, arrayOfObject);
    super.onCreate(paramBundle);
    Object localObject3;
    if (paramBundle == null)
    {
      localObject1 = getArguments();
      str4 = "id";
      localObject1 = ((Bundle)localObject1).getString(str4);
      this.mLoyaltyCardId = ((String)localObject1);
      localObject1 = getArguments();
      str4 = "merchant_name";
      localObject1 = ((Bundle)localObject1).getString(str4);
      this.mMerchantName = ((String)localObject1);
      localObject1 = getArguments();
      str4 = "loyalty_card_code";
      localObject1 = ((Bundle)localObject1).getString(str4);
      this.mMerchantLoyaltyId = ((String)localObject1);
      localObject1 = getArguments();
      str4 = "isAutoRedeem";
      boolean bool1 = ((Bundle)localObject1).getBoolean(str4);
      this.isAutoRedeem = bool1;
      Bundle localBundle = getArguments();
      str4 = "hasBarCode";
      boolean bool2 = localBundle.getBoolean(str4);
      this.hasBarCode = bool2;
      Object localObject2 = getArguments();
      str4 = "terms_and_conditions";
      localObject2 = ((Bundle)localObject2).getString(str4);
      this.mTermsAndConditions = ((String)localObject2);
      localObject2 = getArguments();
      str4 = "position";
      int i = ((Bundle)localObject2).getInt(str4);
      this.mPosition = i;
      localObject3 = getArguments();
      str4 = "codeNumber";
      localObject3 = ((Bundle)localObject3).getString(str4);
      this.mCodeNumber = ((String)localObject3);
      localObject3 = getArguments();
      str4 = "headerUrl";
      localObject3 = ((Bundle)localObject3).getString(str4);
      this.mheaderUrl = ((String)localObject3);
      localObject3 = getArguments();
      str4 = "barcodeValue";
      localObject3 = ((Bundle)localObject3).getString(str4);
      this.mBarcodeValue = ((String)localObject3);
      localObject3 = getArguments();
      str4 = "barcodeType";
      localObject3 = ((Bundle)localObject3).getString(str4);
    }
    String str3;
    for (this.mBarcodeType = ((String)localObject3); ; this.mBarcodeType = str3)
    {
      return;
      localObject3 = "id";
      localObject3 = paramBundle.getString((String)localObject3);
      this.mLoyaltyCardId = ((String)localObject3);
      localObject3 = "merchant_name";
      localObject3 = paramBundle.getString((String)localObject3);
      this.mMerchantName = ((String)localObject3);
      localObject3 = "loyalty_card_code";
      localObject3 = paramBundle.getString((String)localObject3);
      this.mMerchantLoyaltyId = ((String)localObject3);
      localObject3 = "isAutoRedeem";
      boolean bool3 = paramBundle.getBoolean((String)localObject3);
      this.isAutoRedeem = bool3;
      String str1 = "hasBarCode";
      boolean bool4 = paramBundle.getBoolean(str1);
      this.hasBarCode = bool4;
      String str2 = "terms_and_conditions";
      str2 = paramBundle.getString(str2);
      this.mTermsAndConditions = str2;
      str2 = "position";
      int j = paramBundle.getInt(str2);
      this.mPosition = j;
      str3 = "codeNumber";
      str3 = paramBundle.getString(str3);
      this.mCodeNumber = str3;
      str3 = "headerUrl";
      str3 = paramBundle.getString(str3);
      this.mheaderUrl = str3;
      str3 = "barcodeValue";
      str3 = paramBundle.getString(str3);
      this.mBarcodeValue = str3;
      str3 = "barcodeType";
      str3 = paramBundle.getString(str3);
    }
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    int n = 0;
    int i = this.mPosition;
    int j = paramView.getId();
    int m = 2131495068;
    paramContextMenu.add(i, j, n, m);
    SpannableString localSpannableString = new android/text/SpannableString;
    Object localObject = this.mCardNumberText;
    localObject = ((TextView)localObject).getText();
    localObject = ((CharSequence)localObject).toString();
    localSpannableString.<init>((CharSequence)localObject);
    localObject = TEXT_HIGHLIGHT;
    TextView localTextView = this.mCardNumberText;
    int k = localTextView.length();
    m = 33;
    localSpannableString.setSpan(localObject, n, k, m);
    localObject = this.mCardNumberText;
    ((TextView)localObject).setText(localSpannableString);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool = false;
    DebugLogger localDebugLogger = L;
    String str = "Creating details view ";
    Object[] arrayOfObject = new Object[bool];
    localDebugLogger.info(str, arrayOfObject);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    int i = 2130903262;
    Object localObject = paramLayoutInflater.inflate(i, paramViewGroup, bool);
    this.mRoot = ((View)localObject);
    localObject = this.mRoot;
    int j = 2131428226;
    localObject = ((View)localObject).findViewById(j);
    localObject = (TextView)localObject;
    this.mCardNumberText = ((TextView)localObject);
    createLoyaltyCardView();
    localObject = this.barCodeImageView;
    if (localObject != null)
    {
      localObject = TrackPage.Point.LoyaltyCardViewDetails;
      PayPalApp.logPageView((TrackPage.Point)localObject);
    }
    while (true)
    {
      localObject = this.mRoot;
      return localObject;
      localObject = TrackPage.Point.LoyaltyCardViewDetailsNoBarCode;
      PayPalApp.logPageView((TrackPage.Point)localObject);
    }
  }

  public void onResume()
  {
    super.onResume();
    LoyaltyCardDetailFragment.OnLoyaltyDetailsFragmentListener localOnLoyaltyDetailsFragmentListener = getLocalListener();
    localOnLoyaltyDetailsFragmentListener.closeSoftKeyboard();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    String str1 = this.mLoyaltyCardId;
    String str2;
    if (str1 != null)
    {
      str1 = "id";
      str2 = this.mLoyaltyCardId;
      paramBundle.putString(str1, str2);
    }
    str1 = this.mMerchantName;
    if (str1 != null)
    {
      str1 = "merchant_name";
      str2 = this.mMerchantName;
      paramBundle.putString(str1, str2);
    }
    str1 = this.mMerchantLoyaltyId;
    if (str1 != null)
    {
      str1 = "loyalty_card_code";
      str2 = this.mMerchantLoyaltyId;
      paramBundle.putString(str1, str2);
    }
    str1 = this.mTermsAndConditions;
    if (str1 != null)
    {
      str1 = "terms_and_conditions";
      str2 = this.mTermsAndConditions;
      paramBundle.putString(str1, str2);
    }
    str1 = "position";
    int i = this.mPosition;
    paramBundle.putInt(str1, i);
    str1 = "isAutoRedeem";
    boolean bool = this.isAutoRedeem;
    paramBundle.putBoolean(str1, bool);
    str1 = "hasBarCode";
    bool = this.hasBarCode;
    paramBundle.putBoolean(str1, bool);
    str1 = "codeNumber";
    String str3 = this.mCodeNumber;
    paramBundle.putString(str1, str3);
    str1 = "headerUrl";
    str3 = this.mheaderUrl;
    paramBundle.putString(str1, str3);
    str1 = "barcodeValue";
    str3 = this.mBarcodeValue;
    paramBundle.putString(str1, str3);
    str1 = "barcodeType";
    str3 = this.mBarcodeType;
    paramBundle.putString(str1, str3);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.LoyaltyCardDetailFragment
 * JD-Core Version:    0.6.2
 */
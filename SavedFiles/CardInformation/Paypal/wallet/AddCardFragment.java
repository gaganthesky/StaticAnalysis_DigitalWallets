package com.paypal.android.p2pmobile.fragment.wallet;

import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.paypal.android.base.common.Country;
import com.paypal.android.base.common.PayerInfoObject;
import com.paypal.android.base.server.tracking.TrackPage.Link;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.account.AccountModel;
import com.paypal.android.foundation.account.model.AccountDetails;
import com.paypal.android.foundation.account.model.MutableCredebitCard;
import com.paypal.android.foundation.core.log.DebugLogger;
import com.paypal.android.foundation.core.model.Address;
import com.paypal.android.foundation.core.model.MutableAddress;
import com.paypal.android.foundation.core.model.MutableModelObject;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.activity.AddCardPersonalInfoActivity;
import com.paypal.android.p2pmobile.common.EditFitTextView;
import com.paypal.android.p2pmobile.common.PayPalUser;
import com.paypal.android.p2pmobile.common.PerCountryData;
import com.paypal.android.p2pmobile.common.PerCountryData.PersonalInfoPage;
import com.paypal.android.p2pmobile.core.AppIntentFactory.WalletOperation;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.fragment.dialogs.DatePickerDialog;
import com.paypal.android.p2pmobile.fragment.dialogs.MessageDialog;
import com.paypal.android.p2pmobile.fragment.dialogs.MonthYearPopup.OnYMSetListener;
import com.paypal.android.p2pmobile.fragment.dialogs.PPButtonDialogFragmentInterface;
import com.paypal.android.p2pmobile.fragment.dialogs.PPDialogFragment;
import com.paypal.android.p2pmobile.fragment.dialogs.WaitDialog;
import com.paypal.android.p2pmobile.utils.CardFormatter;
import com.paypal.android.p2pmobile.utils.ViewUtility;
import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCardFragment extends BaseFragment
  implements MonthYearPopup.OnYMSetListener, View.OnClickListener, PPButtonDialogFragmentInterface, DatePickerDialog.OnDateSetListener
{
  private static final String ANDROID_VERSION_2_3_6 = "2.3.6";
  private static final String DIALOG_TAG = "dialog";
  public static final String EXTRA_CAPTURED_CARD_IMAGE = "io.card.payment.capturedCardImage";
  private static final DebugLogger L = (DebugLogger)localObject;
  public static final int MAX_CARD_NUMBER_LENGTH = 19;
  public static final int MAX_CVV_NUMBER_LENGTH = 4;
  private Button addButton;
  private TextView billAdress;
  private final AddCardFragment.CardNumberWatcher cardNumListener;
  private EditText cardNumber;
  private final Calendar currentDate;
  private EditFitTextView cvv;
  private EditFitTextView dateOfBirth;
  private EditFitTextView expDate;
  private EditFitTextView issueNum;
  private int mAddressIndex;
  private AddCardFragment.CardType[] mCountryCardTypes;
  private MutableCredebitCard mCredebit;
  private AddCardFragment.CurrentDateTextView mCurrentDateTextView;
  private AddCardFragment.AddCardEntryPoint mEntryPoint;
  private List mModifiedAddressList;
  private View mRootView;
  private ImageButton scanButton;
  private EditFitTextView startDate;
  private java.text.DateFormat sysDateFormat;

  static
  {
    Object localObject = AddCardFragment.class;
    localObject = DebugLogger.getLogger((Class)localObject);
  }

  public AddCardFragment()
  {
    this.mModifiedAddressList = local1;
    Object localObject = Calendar.getInstance();
    this.currentDate = ((Calendar)localObject);
    localObject = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardNumberWatcher;
    ((AddCardFragment.CardNumberWatcher)localObject).<init>(this, local1);
    this.cardNumListener = ((AddCardFragment.CardNumberWatcher)localObject);
  }

  private void _showDialog(AddCardFragment.DialogType paramDialogType, int paramInt1, int paramInt2)
  {
    String str1 = getString(paramInt1);
    String str2 = getString(paramInt2);
    _showDialog(paramDialogType, str1, str2);
  }

  private void _showDialog(AddCardFragment.DialogType paramDialogType, int paramInt, String paramString)
  {
    String str = getString(paramInt);
    _showDialog(paramDialogType, str, paramString);
  }

  private void _showDialog(AddCardFragment.DialogType paramDialogType, String paramString1, String paramString2)
  {
    Object localObject2 = getActivity();
    localObject2 = ((FragmentActivity)localObject2).getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject2).beginTransaction();
    localObject2 = getActivity();
    localObject2 = ((FragmentActivity)localObject2).getSupportFragmentManager();
    String str2 = "dialog";
    Fragment localFragment = ((FragmentManager)localObject2).findFragmentByTag(str2);
    if (localFragment != null)
      localFragmentTransaction.remove(localFragment);
    Object localObject1 = null;
    localObject2 = AddCardFragment.11.$SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddCardFragment$DialogType;
    int k = paramDialogType.ordinal();
    int i = localObject2[k];
    switch (i)
    {
    default:
    case 3:
    case 5:
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      String str1 = "dialog";
      ((DialogFragment)localObject1).show(localFragmentTransaction, str1);
      return;
      int j = 2131493450;
      Object localObject4 = paramDialogType.toString();
      localObject1 = WaitDialog.newInstance(j, (String)localObject4);
      continue;
      j = getVerificationCodeIcon();
      localObject4 = AddCardFragment.class;
      localObject4 = ((Class)localObject4).getName();
      String str3 = paramDialogType.toString();
      localObject1 = MessageDialog.newInstance(paramString2, j, (String)localObject4, str3);
      continue;
      Object localObject3 = TrackPage.Point.AddCardDone;
      PayPalApp.logPageView((TrackPage.Point)localObject3);
      localObject3 = AddCardFragment.class;
      localObject3 = ((Class)localObject3).getName();
      localObject4 = paramDialogType.toString();
      localObject1 = MessageDialog.newInstance(paramString2, (String)localObject3, (String)localObject4);
    }
  }

  protected void _showDialog(String paramString)
  {
    int i = 0;
    FragmentManager localFragmentManager1 = getFragmentManager();
    String str = "dialog";
    Object localObject = localFragmentManager1.findFragmentByTag(str);
    boolean bool = localObject instanceof DialogFragment;
    if (bool)
    {
      localObject = (DialogFragment)localObject;
      ((DialogFragment)localObject).dismiss();
    }
    MessageDialog localMessageDialog = MessageDialog.newInstance(paramString);
    if (localMessageDialog != null)
    {
      FragmentManager localFragmentManager2 = getFragmentManager();
      str = "dialog";
      localMessageDialog.show(localFragmentManager2, str);
    }
  }

  private void completeAddCardProcess(String paramString)
  {
    removeDialog();
    Object localObject = getActivity();
    int i = 0;
    localObject = Toast.makeText((Context)localObject, paramString, i);
    ((Toast)localObject).show();
    localObject = this.mEntryPoint;
    AddCardFragment.AddCardEntryPoint localAddCardEntryPoint = AddCardFragment.AddCardEntryPoint.SHOP;
    if (localObject == localAddCardEntryPoint)
    {
      localObject = getActivity();
      ((FragmentActivity)localObject).finish();
    }
    while (true)
    {
      return;
      localObject = getActivity();
      localObject = ((FragmentActivity)localObject).getSupportFragmentManager();
      ((FragmentManager)localObject).popBackStackImmediate();
    }
  }

  private void createArtifact()
  {
    Object localObject1 = AddCardFragment.DialogType.PleaseWaitAddCard;
    int i = 2131493449;
    int j = 2131493450;
    _showDialog((AddCardFragment.DialogType)localObject1, i, j);
    localObject1 = AccountModel.getInstance();
    AccountDetails localAccountDetails = ((AccountModel)localObject1).getDetails();
    if (localAccountDetails != null)
    {
      localObject1 = this.mCredebit;
      localObject2 = localAccountDetails.getFirstName();
      ((MutableCredebitCard)localObject1).setCardHolderFirstName((String)localObject2);
      localObject1 = this.mCredebit;
      localObject2 = localAccountDetails.getLastName();
      ((MutableCredebitCard)localObject1).setCardHolderLastName((String)localObject2);
    }
    localObject1 = getLocalListener();
    Object localObject2 = this.mCredebit;
    ((AddCardFragment.OnAddCardFragmentListener)localObject1).createArtifact((MutableModelObject)localObject2);
  }

  private int doLuhn(String paramString)
  {
    boolean bool = false;
    int i = doLuhnValidation(paramString, bool);
    return i;
  }

  private static int doLuhnValidation(String paramString, boolean paramBoolean)
  {
    int k = 0;
    int m = paramString.length();
    int i = m + -1;
    if (i >= 0)
    {
      m = i + 1;
      String str = paramString.substring(i, m);
      int j = Integer.parseInt(str);
      if (paramBoolean)
      {
        j *= 2;
        int n = 9;
        if (j > n)
        {
          n = j % 10;
          j = n + 1;
        }
      }
      k += j;
      if (!paramBoolean);
      for (paramBoolean = true; ; paramBoolean = false)
      {
        i += -1;
        break;
      }
    }
    return k;
  }

  private static boolean doMod11(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    if (bool1)
      bool1 = false;
    while (true)
    {
      return bool1;
      int i1 = 6;
      long[] arrayOfLong = new long[i1];
      arrayOfLong[0] = 2L;
      arrayOfLong[1] = 3L;
      arrayOfLong[2] = 4L;
      arrayOfLong[3] = 5L;
      arrayOfLong[4] = 6L;
      arrayOfLong[5] = 7L;
      i1 = 0;
      int i4 = paramString.length();
      i4 += -1;
      String str1 = paramString.substring(i1, i4);
      long l1 = 0L;
      int k = 0;
      i1 = str1.length();
      int i = i1 + -1;
      long l7;
      while (i >= 0)
      {
        i1 = arrayOfLong.length;
        int n = k % i1;
        i1 = str1.charAt(i);
        Object localObject = String.valueOf(i1);
        localObject = Integer.valueOf((String)localObject);
        int i2 = ((Integer)localObject).intValue();
        l3 = i2;
        l7 = arrayOfLong[n];
        l3 *= l7;
        l1 += l3;
        int m;
        k += 1;
        i += -1;
      }
      long l3 = 11L;
      long l2 = l1 % l3;
      int i3 = paramString.length();
      i3 += -1;
      i3 = paramString.charAt(i3);
      String str2 = String.valueOf(i3);
      int j = Integer.parseInt(str2);
      long l4 = 0L;
      boolean bool2 = l2 < l4;
      if (!bool2)
      {
        long l5 = j;
        boolean bool3 = l2 < l5;
        if (!bool3)
          bool3 = true;
        else
          bool3 = false;
      }
      else
      {
        long l6 = 11L;
        l6 -= l2;
        l7 = j;
        boolean bool4 = l6 < l7;
        if (!bool4)
          bool4 = true;
        else
          bool4 = false;
      }
    }
  }

  private void figureOutCardsForCountry(Country paramCountry)
  {
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    TypedArray localTypedArray = PerCountryData.getCountryCards(paramCountry);
    int i = 0;
    while (true)
    {
      int j = localTypedArray.length();
      if (i >= j)
        break;
      j = 0;
      j = localTypedArray.getResourceId(i, j);
      AddCardFragment.CardType localCardType = AddCardFragment.CardType.getCard(j);
      localArrayList.add(localCardType);
      i += 1;
    }
    int k = localArrayList.size();
    Object localObject = new AddCardFragment.CardType[k];
    localObject = localArrayList.toArray((Object[])localObject);
    localObject = (AddCardFragment.CardType[])localObject;
    this.mCountryCardTypes = ((AddCardFragment.CardType[])localObject);
  }

  private AddCardFragment.CardType findCardforNumber(String paramString, AddCardFragment.CardType[] paramArrayOfCardType)
  {
    Object localObject1 = AddCardFragment.CardType.Unknown;
    ArrayList localArrayList = new java/util/ArrayList;
    localArrayList.<init>();
    int i1 = paramArrayOfCardType.length;
    if (i1 > 0);
    int m;
    AddCardFragment.CardType localCardType1;
    for (AddCardFragment.CardType[] arrayOfCardType = paramArrayOfCardType; ; arrayOfCardType = AddCardFragment.CardType.values())
    {
      m = arrayOfCardType.length;
      int i = 0;
      while (i < m)
      {
        localCardType1 = arrayOfCardType[i];
        String str = localCardType1.getRegex();
        Pattern localPattern = Pattern.compile(str);
        Matcher localMatcher = localPattern.matcher(paramString);
        boolean bool1 = localMatcher.find();
        if (bool1)
        {
          Pair localPair = new android/util/Pair;
          MatchResult localMatchResult = localMatcher.toMatchResult();
          localPair.<init>(localCardType1, localMatchResult);
          localArrayList.add(localPair);
        }
        i += 1;
      }
    }
    int i2 = localArrayList.size();
    if (i2 > 0)
    {
      int k = 0;
      Iterator localIterator = localArrayList.iterator();
      while (true)
      {
        boolean bool2 = localIterator.hasNext();
        if (!bool2)
          break;
        Object localObject2 = localIterator.next();
        localObject2 = (Pair)localObject2;
        Object localObject3 = ((Pair)localObject2).second;
        localObject3 = (MatchResult)localObject3;
        int i3 = ((MatchResult)localObject3).end();
        if (i3 > k)
        {
          localObject4 = ((Pair)localObject2).second;
          localObject4 = (MatchResult)localObject4;
          k = ((MatchResult)localObject4).end();
          localObject1 = ((Pair)localObject2).first;
          localObject1 = (AddCardFragment.CardType)localObject1;
        }
      }
    }
    Object localObject4 = AddCardFragment.CardType.Unknown;
    int n;
    int j;
    if (localObject1 == localObject4)
    {
      int i4 = paramString.length();
      int i5 = 8;
      if (i4 != i5)
      {
        i4 = paramString.length();
        i5 = 9;
        if (i4 != i5);
      }
      else
      {
        n = 0;
        arrayOfCardType = paramArrayOfCardType;
        m = arrayOfCardType.length;
        j = 0;
      }
    }
    while (true)
    {
      if (j < m)
      {
        localCardType1 = arrayOfCardType[j];
        AddCardFragment.CardType localCardType2 = AddCardFragment.CardType.Etoiles;
        if (localCardType1 == localCardType2)
          n = 1;
      }
      else
      {
        if (n != 0)
          localObject1 = AddCardFragment.CardType.Etoiles;
        return localObject1;
      }
      j += 1;
    }
  }

  private void finishAddCard()
  {
    Object localObject = getActivity();
    localObject = ((FragmentActivity)localObject).getSupportFragmentManager();
    ((FragmentManager)localObject).popBackStackImmediate();
  }

  private void flushFilter()
  {
    int k = 1;
    int j = 0;
    InputFilter[] arrayOfInputFilter = new InputFilter[k];
    Object localObject = new android/text/InputFilter$LengthFilter;
    int i = 19;
    ((InputFilter.LengthFilter)localObject).<init>(i);
    arrayOfInputFilter[j] = localObject;
    localObject = this.cardNumber;
    ((EditText)localObject).setFilters(arrayOfInputFilter);
    arrayOfInputFilter = new InputFilter[k];
    localObject = new android/text/InputFilter$LengthFilter;
    i = 4;
    ((InputFilter.LengthFilter)localObject).<init>(i);
    arrayOfInputFilter[j] = localObject;
    localObject = this.cvv;
    ((EditFitTextView)localObject).setFilters(arrayOfInputFilter);
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
    Object localObject = localAccountModel.getAddresses();
    if (localObject != null);
    while (true)
    {
      return localObject;
      localObject = new java/util/ArrayList;
      ((ArrayList)localObject).<init>();
    }
  }

  private static Bitmap getCapturedCardImage(Intent paramIntent)
  {
    Bitmap localBitmap = null;
    if (paramIntent != null)
    {
      String str = "io.card.payment.capturedCardImage";
      boolean bool = paramIntent.hasExtra(str);
      if (bool)
        break label27;
    }
    while (true)
    {
      return localBitmap;
      label27: Object localObject = "io.card.payment.capturedCardImage";
      byte[] arrayOfByte = paramIntent.getByteArrayExtra((String)localObject);
      ByteArrayInputStream localByteArrayInputStream = new java/io/ByteArrayInputStream;
      localByteArrayInputStream.<init>(arrayOfByte);
      localObject = new android/graphics/BitmapFactory$Options;
      ((BitmapFactory.Options)localObject).<init>();
      localBitmap = BitmapFactory.decodeStream(localByteArrayInputStream, localBitmap, (BitmapFactory.Options)localObject);
    }
  }

  private AddCardFragment.CardType getCardFromNumber(String paramString)
  {
    Object localObject = this.mCountryCardTypes;
    localObject = findCardforNumber(paramString, (AddCardFragment.CardType[])localObject);
    return localObject;
  }

  private String getCardNumber()
  {
    Object localObject = this.mCredebit;
    localObject = ((MutableCredebitCard)localObject).getCardNumber();
    return localObject;
  }

  private AddCardFragment.CardType getCredebitCardType()
  {
    Object localObject = this.mCredebit;
    localObject = ((MutableCredebitCard)localObject).getType();
    localObject = AddCardFragment.CardType.fromCardNameFromAPIName((String)localObject);
    return localObject;
  }

  public AddCardFragment.AddCardEntryPoint getEntryPoint()
  {
    AddCardFragment.AddCardEntryPoint localAddCardEntryPoint = this.mEntryPoint;
    return localAddCardEntryPoint;
  }

  private String getFormattedCardNumber()
  {
    int i2 = 1;
    int i1 = 0;
    StringBuilder localStringBuilder = new java/lang/StringBuilder;
    int j = 32;
    localStringBuilder.<init>(j);
    AddCardFragment.CardType localCardType1 = getCredebitCardType();
    j = 3;
    Object localObject1 = new AddCardFragment.CardType[j];
    AddCardFragment.CardType localCardType2 = AddCardFragment.CardType.Visa;
    localObject1[i1] = localCardType2;
    localCardType2 = AddCardFragment.CardType.MasterCard;
    localObject1[i2] = localCardType2;
    int n = 2;
    AddCardFragment.CardType localCardType4 = AddCardFragment.CardType.Discover;
    localObject1[n] = localCardType4;
    boolean bool2 = AddCardFragment.CardType.hasCardMatch(localCardType1, (AddCardFragment.CardType[])localObject1);
    localObject1 = new AddCardFragment.CardType[i2];
    AddCardFragment.CardType localCardType3 = AddCardFragment.CardType.Amex;
    localObject1[i1] = localCardType3;
    boolean bool1 = AddCardFragment.CardType.hasCardMatch(localCardType1, (AddCardFragment.CardType[])localObject1);
    int i = 0;
    localObject1 = this.mCredebit;
    localObject1 = ((MutableCredebitCard)localObject1).getCardNumber();
    int k = ((String)localObject1).length();
    if (i < k)
    {
      Object localObject2;
      if (bool2)
      {
        k = i % 4;
        if ((k == 0) && (i != 0))
        {
          localObject2 = " ";
          localStringBuilder.append((String)localObject2);
        }
      }
      while (true)
      {
        localObject2 = this.mCredebit;
        localObject2 = ((MutableCredebitCard)localObject2).getCardNumber();
        int m = ((String)localObject2).charAt(i);
        localStringBuilder.append(m);
        i += 1;
        break;
        if (bool1)
        {
          m = 4;
          if (i != m)
          {
            m = 10;
            if (i != m);
          }
          else
          {
            str = " ";
            localStringBuilder.append(str);
          }
        }
      }
    }
    String str = localStringBuilder.toString();
    return str;
  }

  private AddCardFragment.OnAddCardFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (AddCardFragment.OnAddCardFragmentListener)localObject;
    return localObject;
  }

  private int getVerificationCodeIcon()
  {
    MutableCredebitCard localMutableCredebitCard = this.mCredebit;
    String str2 = localMutableCredebitCard.getType();
    if (str2 != null)
    {
      int i = 2131493114;
      String str1 = getString(i);
      boolean bool = str2.equalsIgnoreCase(str1);
      if (!bool);
    }
    for (int j = 2130838057; ; j = 2130838056)
      return j;
  }

  private boolean hasValidUserInfo()
  {
    boolean bool1 = false;
    AccountModel localAccountModel = AccountModel.getInstance();
    if (localAccountModel != null)
    {
      AccountDetails localAccountDetails = localAccountModel.getDetails();
      if (localAccountDetails != null)
      {
        List localList = getAddressesFromModel();
        if (localList != null)
        {
          boolean bool2 = localList.isEmpty();
          if (!bool2)
          {
            String str1 = localAccountDetails.getFirstName();
            boolean bool3 = TextUtils.isEmpty(str1);
            if (!bool3)
            {
              String str2 = localAccountDetails.getLastName();
              boolean bool4 = TextUtils.isEmpty(str2);
              if (!bool4)
                bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }

  private boolean isExpirationDateProvided()
  {
    MutableCredebitCard localMutableCredebitCard1 = this.mCredebit;
    int i = localMutableCredebitCard1.getExpirationMonth();
    if (i != 0)
    {
      MutableCredebitCard localMutableCredebitCard2 = this.mCredebit;
      j = localMutableCredebitCard2.getExpirationYear();
      if (j == 0);
    }
    int k;
    for (int j = 1; ; k = 0)
      return j;
  }

  private boolean isIssueStartDateProvided()
  {
    Object localObject = this.mCredebit;
    localObject = ((MutableCredebitCard)localObject).getIssueDate();
    if (localObject != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private boolean isValidCardNumber(AddCardFragment.CardType paramCardType)
  {
    boolean bool1 = false;
    boolean bool3 = requiresLuhnValidation(paramCardType);
    if (bool3)
    {
      Object localObject2 = AddCardFragment.CardType.Unknown;
      if (paramCardType != localObject2)
      {
        localObject2 = this.mCredebit;
        localObject2 = ((MutableCredebitCard)localObject2).getCardNumber();
        int i = doLuhn((String)localObject2);
        i %= 10;
        if (i == 0)
          bool1 = true;
      }
    }
    while (true)
    {
      return bool1;
      boolean bool4 = requiresMod11Validation(paramCardType);
      if (bool4)
      {
        Object localObject1 = this.mCredebit;
        localObject1 = ((MutableCredebitCard)localObject1).getCardNumber();
        boolean bool2 = doMod11((String)localObject1);
      }
    }
  }

  private boolean isValidVerificationNumber()
  {
    boolean bool1 = false;
    Object localObject1 = this.mCredebit;
    localObject1 = ((MutableCredebitCard)localObject1).getCcvNumber();
    boolean bool2 = TextUtils.isEmpty((CharSequence)localObject1);
    if (!bool2)
    {
      AddCardFragment.CardType localCardType = getCredebitCardType();
      int i = localCardType.getCvvLength();
      Object localObject2 = this.mCredebit;
      localObject2 = ((MutableCredebitCard)localObject2).getCcvNumber();
      int j = ((String)localObject2).length();
      if (i == j)
        bool1 = true;
    }
    return bool1;
  }

  public static AddCardFragment newInstance()
  {
    AddCardFragment localAddCardFragment = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment;
    localAddCardFragment.<init>();
    return localAddCardFragment;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i5 = 0;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    int j = 50;
    StringBuilder localStringBuilder;
    Object localObject3;
    Object localObject6;
    Object localObject5;
    if (paramInt1 == j)
    {
      j = CardIOActivity.RESULT_CARD_INFO;
      if (paramInt2 == j)
        if (paramIntent != null)
        {
          String str2 = "io.card.payment.scanResult";
          boolean bool1 = paramIntent.hasExtra(str2);
          if (bool1)
          {
            flushFilter();
            localStringBuilder = new java/lang/StringBuilder;
            int k = 256;
            localStringBuilder.<init>(k);
            Object localObject2 = "io.card.payment.scanResult";
            Object localObject1 = paramIntent.getParcelableExtra((String)localObject2);
            localObject1 = (CreditCard)localObject1;
            localObject2 = "Card Number: ";
            localObject2 = localStringBuilder.append((String)localObject2);
            String str3 = ((CreditCard)localObject1).getRedactedCardNumber();
            localObject2 = ((StringBuilder)localObject2).append(str3);
            str3 = "\n";
            ((StringBuilder)localObject2).append(str3);
            String str1 = ((CreditCard)localObject1).getFormattedCardNumber();
            localObject2 = this.cardNumber;
            ((EditText)localObject2).setText(str1);
            boolean bool2 = ((CreditCard)localObject1).isExpiryValid();
            if (bool2)
            {
              AddCardFragment.CurrentDateTextView localCurrentDateTextView = AddCardFragment.CurrentDateTextView.ExpirationDate;
              this.mCurrentDateTextView = localCurrentDateTextView;
              int m = ((CreditCard)localObject1).expiryYear;
              int i1 = ((CreditCard)localObject1).expiryMonth;
              setDate(m, i1);
              localObject3 = "Expiration Date: ";
              localObject3 = localStringBuilder.append((String)localObject3);
              String str4 = "%02d";
              int i3 = 1;
              localObject6 = new Object[i3];
              int i4 = ((CreditCard)localObject1).expiryMonth;
              Integer localInteger = Integer.valueOf(i4);
              localObject6[i5] = localInteger;
              str4 = String.format(str4, (Object[])localObject6);
              localObject3 = ((StringBuilder)localObject3).append(str4);
              str4 = "/";
              localObject3 = ((StringBuilder)localObject3).append(str4);
              int i2 = ((CreditCard)localObject1).expiryYear;
              localObject3 = ((StringBuilder)localObject3).append(i2);
              localObject5 = "\n";
              ((StringBuilder)localObject3).append((String)localObject5);
              localObject3 = this.addButton;
              ((Button)localObject3).setEnabled(i5);
              localObject3 = L;
              localObject5 = new java/lang/StringBuilder;
              ((StringBuilder)localObject5).<init>();
              localObject6 = "****** Scan Result *******\n";
              localObject5 = ((StringBuilder)localObject5).append((String)localObject6);
              localObject5 = ((StringBuilder)localObject5).append(localStringBuilder);
              localObject5 = ((StringBuilder)localObject5).toString();
              localObject6 = new Object[i5];
              ((DebugLogger)localObject3).debug((String)localObject5, (Object[])localObject6);
            }
          }
        }
    }
    while (true)
    {
      return;
      localObject3 = this.expDate;
      ((EditFitTextView)localObject3).requestFocus();
      break;
      localStringBuilder = new java/lang/StringBuilder;
      localObject3 = "Scan was canceled.";
      localStringBuilder.<init>((String)localObject3);
      localObject3 = this.cardNumber;
      ((EditText)localObject3).requestFocus();
      break;
      int n = 13;
      if (paramInt1 == n)
      {
        n = -1;
        Object localObject4;
        if (paramInt2 == n)
        {
          if (paramIntent != null)
          {
            localObject4 = "addressIndex";
            int i = paramIntent.getIntExtra((String)localObject4, i5);
            localObject4 = "addressList";
            ArrayList localArrayList = paramIntent.getParcelableArrayListExtra((String)localObject4);
            localObject4 = getAccountCountryCode();
            localObject4 = CardFormatter.transform(localArrayList, (String)localObject4);
            this.mModifiedAddressList = ((List)localObject4);
            onAddressSelected(i, localArrayList);
          }
        }
        else if (paramInt2 == 0)
        {
          localObject4 = L;
          localObject5 = "The previous activity was cancelled";
          localObject6 = new Object[i5];
          ((DebugLogger)localObject4).debug((String)localObject5, (Object[])localObject6);
        }
      }
    }
  }

  public void onAddressSelected(int paramInt, List<PayerInfoObject> paramList)
  {
    if (paramList != null)
    {
      boolean bool = paramList.isEmpty();
      if ((!bool) && (paramInt >= 0))
      {
        int i = paramList.size();
        if (paramInt < i)
          break label37;
      }
    }
    while (true)
    {
      return;
      label37: Object localObject1 = paramList.get(paramInt);
      localObject1 = (PayerInfoObject)localObject1;
      Object localObject2 = getAccountCountryCode();
      MutableAddress localMutableAddress = CardFormatter.createMutableAddressFromPayerInfoObject((PayerInfoObject)localObject1, (String)localObject2);
      localObject1 = this.mCredebit;
      ((MutableCredebitCard)localObject1).setBillingAddress(localMutableAddress);
      localObject1 = this.billAdress;
      localObject2 = localMutableAddress.getFormattedLines();
      setAddressToTextView((TextView)localObject1, (List)localObject2);
    }
  }

  public void onCancel(DialogFragment paramDialogFragment)
  {
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    default:
    case 2131427628:
    case 2131427623:
    case 2131427634:
    }
    while (true)
    {
      return;
      onScanPress();
      continue;
      createArtifact();
      continue;
      boolean bool = PayPalApp.haveUser();
      if (bool)
      {
        Object localObject = PayPalApp.getCurrentUser();
        Country localCountry = ((PayPalUser)localObject).getUserCountry();
        localObject = PerCountryData.PersonalInfoPage.Address;
        localObject = PerCountryData.getPageConfiguration(localCountry, (PerCountryData.PersonalInfoPage)localObject);
        if (localObject != null)
        {
          startPersonalInfoActivity();
        }
        else
        {
          localObject = getActivity();
          int j = 2131493335;
          localObject = ((FragmentActivity)localObject).getString(j);
          _showDialog((String)localObject);
        }
      }
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Object localObject5 = 0;
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    boolean bool1 = true;
    subscribeToWalletOperationBroadcasts(bool1);
    int i = 2130903084;
    ViewGroup localViewGroup = null;
    View localView = paramLayoutInflater.inflate(i, localViewGroup);
    this.mRootView = localView;
    localView = this.mRootView;
    String str1;
    if (localView != null)
    {
      boolean bool2 = PayPalApp.isUserLoggedIn();
      if (bool2)
      {
        Object localObject2 = this.mRootView;
        int n = 2131427634;
        localObject2 = ((View)localObject2).findViewById(n);
        localObject2 = (TextView)localObject2;
        this.billAdress = ((TextView)localObject2);
        localObject2 = this.mRootView;
        n = 2131427623;
        localObject2 = ((View)localObject2).findViewById(n);
        localObject2 = (Button)localObject2;
        this.addButton = ((Button)localObject2);
        localObject2 = this.mRootView;
        n = 2131427628;
        localObject2 = ((View)localObject2).findViewById(n);
        localObject2 = (ImageButton)localObject2;
        this.scanButton = ((ImageButton)localObject2);
        localObject2 = this.mRootView;
        n = 2131427629;
        localObject2 = ((View)localObject2).findViewById(n);
        localObject2 = (EditText)localObject2;
        this.cardNumber = ((EditText)localObject2);
        localObject2 = this.cardNumber;
        localObject2 = ((EditText)localObject2).getText();
        localObject2 = localObject2.toString();
        boolean bool3 = TextUtils.isEmpty((CharSequence)localObject2);
        if (bool3)
        {
          localObject3 = this.scanButton;
          ((ImageButton)localObject3).setVisibility(localObject5);
        }
        localObject3 = this.mRootView;
        n = 2131427630;
        localObject3 = ((View)localObject3).findViewById(n);
        localObject3 = (EditFitTextView)localObject3;
        this.expDate = ((EditFitTextView)localObject3);
        localObject3 = this.mRootView;
        n = 2131427624;
        localObject3 = ((View)localObject3).findViewById(n);
        localObject3 = (EditFitTextView)localObject3;
        this.cvv = ((EditFitTextView)localObject3);
        localObject3 = this.cvv;
        n = 2131493437;
        String str2 = getString(n);
        ((EditFitTextView)localObject3).setHint(str2);
        localObject3 = this.mRootView;
        int i1 = 2131427633;
        localObject3 = ((View)localObject3).findViewById(i1);
        localObject3 = (EditFitTextView)localObject3;
        this.startDate = ((EditFitTextView)localObject3);
        localObject3 = this.mRootView;
        i1 = 2131427631;
        localObject3 = ((View)localObject3).findViewById(i1);
        localObject3 = (EditFitTextView)localObject3;
        this.issueNum = ((EditFitTextView)localObject3);
        localObject3 = this.mRootView;
        i1 = 2131427632;
        localObject3 = ((View)localObject3).findViewById(i1);
        localObject3 = (EditFitTextView)localObject3;
        this.dateOfBirth = ((EditFitTextView)localObject3);
        localObject3 = this.billAdress;
        ((TextView)localObject3).setOnClickListener(this);
        localObject3 = this.scanButton;
        ((ImageButton)localObject3).setOnClickListener(this);
        localObject3 = this.addButton;
        ((Button)localObject3).setOnClickListener(this);
        localObject3 = this.addButton;
        i1 = 2131493434;
        Object localObject6 = getString(i1);
        ((Button)localObject3).setText((CharSequence)localObject6);
        localObject3 = this.cardNumber;
        ((EditText)localObject3).requestFocus();
        localObject3 = getActivity();
        localObject3 = android.text.format.DateFormat.getDateFormat((Context)localObject3);
        this.sysDateFormat = ((java.text.DateFormat)localObject3);
        localObject3 = this.cardNumber;
        localObject6 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$1;
        ((AddCardFragment.1)localObject6).<init>(this);
        ((EditText)localObject3).setOnFocusChangeListener((View.OnFocusChangeListener)localObject6);
        localObject3 = this.cardNumber;
        localObject6 = this.cardNumListener;
        ((EditText)localObject3).addTextChangedListener((TextWatcher)localObject6);
        localObject3 = this.expDate;
        localObject6 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$2;
        ((AddCardFragment.2)localObject6).<init>(this);
        ((EditFitTextView)localObject3).setOnTouchListener((View.OnTouchListener)localObject6);
        localObject3 = this.expDate;
        localObject6 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$3;
        ((AddCardFragment.3)localObject6).<init>(this);
        ((EditFitTextView)localObject3).setOnFocusChangeListener((View.OnFocusChangeListener)localObject6);
        localObject3 = this.dateOfBirth;
        localObject6 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$4;
        ((AddCardFragment.4)localObject6).<init>(this);
        ((EditFitTextView)localObject3).setOnTouchListener((View.OnTouchListener)localObject6);
        localObject3 = this.dateOfBirth;
        localObject6 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$5;
        ((AddCardFragment.5)localObject6).<init>(this);
        ((EditFitTextView)localObject3).setOnFocusChangeListener((View.OnFocusChangeListener)localObject6);
        localObject3 = this.startDate;
        localObject6 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$6;
        ((AddCardFragment.6)localObject6).<init>(this);
        ((EditFitTextView)localObject3).setOnTouchListener((View.OnTouchListener)localObject6);
        localObject3 = this.startDate;
        localObject6 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$7;
        ((AddCardFragment.7)localObject6).<init>(this);
        ((EditFitTextView)localObject3).setOnFocusChangeListener((View.OnFocusChangeListener)localObject6);
        localObject3 = this.cvv;
        localObject6 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$8;
        ((AddCardFragment.8)localObject6).<init>(this);
        ((EditFitTextView)localObject3).addTextChangedListener((TextWatcher)localObject6);
        localObject3 = this.cvv;
        localObject6 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$9;
        ((AddCardFragment.9)localObject6).<init>(this);
        ((EditFitTextView)localObject3).setOnFocusChangeListener((View.OnFocusChangeListener)localObject6);
        localObject3 = this.issueNum;
        localObject6 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$10;
        ((AddCardFragment.10)localObject6).<init>(this);
        ((EditFitTextView)localObject3).addTextChangedListener((TextWatcher)localObject6);
        localObject3 = new com/paypal/android/foundation/account/model/MutableCredebitCard;
        ((MutableCredebitCard)localObject3).<init>();
        this.mCredebit = ((MutableCredebitCard)localObject3);
        localObject3 = this.mCredebit;
        localObject6 = "";
        ((MutableCredebitCard)localObject3).setCardNumber((String)localObject6);
        str1 = getAccountCountryCode();
        if (paramBundle != null)
          break label966;
      }
    }
    Object localObject4;
    label966: int m;
    for (Object localObject3 = localObject5; ; m = paramBundle.getInt((String)localObject4, localObject5))
    {
      this.mAddressIndex = localObject3;
      localObject3 = new com/paypal/android/base/common/Country;
      ((Country)localObject3).<init>(str1);
      figureOutCardsForCountry((Country)localObject3);
      List localList = getAddressesFromModel();
      int j = localList.size();
      localObject5 = this.mAddressIndex;
      if (j > localObject5)
      {
        j = this.mAddressIndex;
        Object localObject1 = localList.get(j);
        localObject1 = (Address)localObject1;
        MutableAddress localMutableAddress = new com/paypal/android/foundation/core/model/MutableAddress;
        localMutableAddress.<init>((Address)localObject1);
        MutableCredebitCard localMutableCredebitCard = this.mCredebit;
        localMutableCredebitCard.setBillingAddress(localMutableAddress);
        int k = this.mAddressIndex;
        setAddressFromModel(k);
      }
      localObject4 = TrackPage.Point.AddCardOverview;
      PayPalApp.logPageView((TrackPage.Point)localObject4);
      localObject4 = this.mRootView;
      return localObject4;
      localObject4 = "addressIndex";
    }
  }

  public void onDateSelected(Calendar paramCalendar, EditFitTextView paramEditFitTextView)
  {
    int i = 0;
    int i6 = 2;
    int i5 = 1;
    boolean bool = paramCalendar.isSet(i6);
    if (bool)
    {
      bool = paramCalendar.isSet(i5);
      if (bool)
      {
        localObject2 = this.expDate;
        if (paramEditFitTextView != localObject2)
          break label108;
        localObject2 = this.mCredebit;
        int m = paramCalendar.get(i6);
        ((MutableCredebitCard)localObject2).setExpirationMonth(m);
        localObject2 = this.mCredebit;
        m = paramCalendar.get(i5);
        ((MutableCredebitCard)localObject2).setExpirationYear(m);
      }
    }
    while (true)
    {
      localObject2 = this.dateOfBirth;
      if (paramEditFitTextView != localObject2)
        break;
      showDOBDialog(paramCalendar);
      return;
      label108: localObject2 = this.startDate;
      if (paramEditFitTextView == localObject2)
      {
        localObject2 = this.mCredebit;
        localObject3 = paramCalendar.getTime();
        ((MutableCredebitCard)localObject2).setIssueDate((Date)localObject3);
      }
      else
      {
        localObject2 = this.dateOfBirth;
        if (paramEditFitTextView == localObject2)
        {
          localObject2 = this.mCredebit;
          localObject3 = paramCalendar.getTime();
          ((MutableCredebitCard)localObject2).setCardHolderBirthDate((Date)localObject3);
        }
      }
    }
    Object localObject2 = this.mCurrentDateTextView;
    Object localObject3 = AddCardFragment.CurrentDateTextView.StartDate;
    int i4;
    label198: AddCardFragment.DatePopup localDatePopup;
    int n;
    int i2;
    if (localObject2 == localObject3)
    {
      i4 = i5;
      localDatePopup = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$DatePopup;
      localObject2 = getActivity();
      n = 2131558701;
      MutableCredebitCard localMutableCredebitCard = this.mCredebit;
      i2 = localMutableCredebitCard.getExpirationYear();
      localMutableCredebitCard = this.mCredebit;
      int i1 = localMutableCredebitCard.getExpirationMonth();
      if (i1 != 0)
        break label336;
    }
    label336: int k;
    for (int i3 = i; ; i3 = k + 1)
    {
      AddCardFragment localAddCardFragment1 = this;
      AddCardFragment localAddCardFragment2 = this;
      localDatePopup.<init>(localAddCardFragment1, (Context)localObject2, n, localAddCardFragment2, i2, i3, i4);
      if (i4 == 0)
      {
        Calendar localCalendar = Calendar.getInstance();
        int j = 11;
        localCalendar.set(i6, j);
        j = 2100;
        localCalendar.set(i5, j);
        localObject1 = Calendar.getInstance();
        localDatePopup.setRange((Calendar)localObject1, localCalendar);
      }
      localDatePopup.show();
      break;
      i4 = localObject1;
      break label198;
      Object localObject1 = this.mCredebit;
      k = ((MutableCredebitCard)localObject1).getExpirationMonth();
    }
  }

  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = L;
    Object localObject2 = "onDataSet method for the calendar pop called";
    int j = 0;
    Object[] arrayOfObject = new Object[j];
    ((DebugLogger)localObject1).verbose((String)localObject2, arrayOfObject);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramInt1, paramInt2, paramInt3);
    localObject1 = this.sysDateFormat;
    localObject2 = new java/util/Date;
    long l = localCalendar.getTimeInMillis();
    ((Date)localObject2).<init>(l);
    String str = ((java.text.DateFormat)localObject1).format((Date)localObject2);
    localObject1 = this.dateOfBirth;
    ((EditFitTextView)localObject1).setText(str);
    localObject1 = this.mCredebit;
    localObject2 = localCalendar.getTime();
    ((MutableCredebitCard)localObject1).setCardHolderBirthDate((Date)localObject2);
    localObject1 = this.addButton;
    localObject2 = getCredebitCardType();
    boolean bool = validateCard((AddCardFragment.CardType)localObject2);
    ((Button)localObject1).setEnabled(bool);
    localObject1 = getActivity();
    localObject1 = ((FragmentActivity)localObject1).getWindow();
    int i = 5;
    ((Window)localObject1).setSoftInputMode(i);
  }

  public void onDismiss(DialogFragment paramDialogFragment)
  {
  }

  public void onNegativeClick(PPDialogFragment paramPPDialogFragment)
  {
  }

  public void onPause()
  {
    FragmentActivity localFragmentActivity = getActivity();
    int i = 50;
    localFragmentActivity.finishActivity(i);
    super.onPause();
  }

  public void onPositiveClick(PPDialogFragment paramPPDialogFragment)
  {
    try
    {
      Object localObject = paramPPDialogFragment.getInstanceTag();
      AddCardFragment.DialogType localDialogType = AddCardFragment.DialogType.valueOf((String)localObject);
      localObject = AddCardFragment.11.$SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddCardFragment$DialogType;
      int j = localDialogType.ordinal();
      int i = localObject[j];
      switch (i)
      {
      case 2:
      case 3:
      case 4:
      case 5:
      default:
      case 1:
      }
      while (true)
      {
        label60: return;
        finishAddCard();
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      break label60;
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    String str = "addressIndex";
    int i = this.mAddressIndex;
    paramBundle.putInt(str, i);
  }

  public void onScanPress()
  {
    boolean bool2 = false;
    Intent localIntent = new android/content/Intent;
    Object localObject1 = getActivity();
    Object localObject2 = CardIOActivity.class;
    localIntent.<init>((Context)localObject1, (Class)localObject2);
    localObject1 = "io.card.payment.appToken";
    localObject2 = "370d79f1a6184aaa9c672e3be50d90c2";
    localIntent.putExtra((String)localObject1, (String)localObject2);
    localObject1 = "io.card.payment.noCamera";
    localIntent.putExtra((String)localObject1, bool2);
    localObject1 = "io.card.payment.requireExpiry";
    localIntent.putExtra((String)localObject1, bool2);
    localObject1 = "io.card.payment.requireCVV";
    localIntent.putExtra((String)localObject1, bool2);
    localObject1 = "io.card.payment.requireZip";
    localIntent.putExtra((String)localObject1, bool2);
    localObject1 = "io.card.payment.suppressManual";
    boolean bool1 = true;
    localIntent.putExtra((String)localObject1, bool1);
    localObject1 = "io.card.payment.guideColor";
    int j = -16776961;
    localIntent.putExtra((String)localObject1, j);
    int i = 50;
    startActivityForResult(localIntent, i);
    TrackPage.Point localPoint = TrackPage.Point.AddCardCamera;
    PayPalApp.logPageView(localPoint);
    localPoint = TrackPage.Point.AddCardOverview;
    TrackPage.Link localLink = TrackPage.Link.ScanCard;
    PayPalApp.logLinkPress(localPoint, localLink);
  }

  protected void onWalletOperation(AppIntentFactory.WalletOperation paramWalletOperation, Intent paramIntent)
  {
    int[] arrayOfInt = AddCardFragment.11.$SwitchMap$com$paypal$android$p2pmobile$core$AppIntentFactory$WalletOperation;
    int m = paramWalletOperation.ordinal();
    int i = arrayOfInt[m];
    switch (i)
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      TrackPage.Point localPoint = TrackPage.Point.AddCardDone;
      PayPalApp.logPageView(localPoint);
      int j = 2131493438;
      String str1 = getString(j);
      completeAddCardProcess(str1);
      continue;
      int k = 2131494855;
      String str2 = getString(k);
      completeAddCardProcess(str2);
    }
  }

  public void onYMSet(Dialog paramDialog, int paramInt1, int paramInt2)
  {
    setDate(paramInt1, paramInt2);
  }

  public static boolean optionalIssueNumberAndStartDate(AddCardFragment.CardType paramCardType)
  {
    int i = 1;
    AddCardFragment.CardType[] arrayOfCardType = new AddCardFragment.CardType[i];
    int j = 0;
    AddCardFragment.CardType localCardType = AddCardFragment.CardType.Switch;
    arrayOfCardType[j] = localCardType;
    boolean bool = AddCardFragment.CardType.hasCardMatch(paramCardType, arrayOfCardType);
    return bool;
  }

  public static boolean optionalVerificationCode(AddCardFragment.CardType paramCardType, String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AddCardFragment.CardType localCardType = AddCardFragment.CardType.Maestro;
    int i;
    if (paramCardType == localCardType)
    {
      int k = 11;
      String[] arrayOfString2 = new String[k];
      String str2 = "FR";
      arrayOfString2[bool2] = str2;
      str2 = "IT";
      arrayOfString2[bool1] = str2;
      int m = 2;
      String str3 = "ES";
      arrayOfString2[m] = str3;
      m = 3;
      str3 = "BE";
      arrayOfString2[m] = str3;
      m = 4;
      str3 = "HU";
      arrayOfString2[m] = str3;
      m = 5;
      str3 = "PL";
      arrayOfString2[m] = str3;
      m = 6;
      str3 = "PT";
      arrayOfString2[m] = str3;
      m = 7;
      str3 = "RO";
      arrayOfString2[m] = str3;
      m = 8;
      str3 = "RU";
      arrayOfString2[m] = str3;
      m = 9;
      str3 = "SK";
      arrayOfString2[m] = str3;
      m = 10;
      str3 = "TR";
      arrayOfString2[m] = str3;
      String[] arrayOfString1 = arrayOfString2;
      int j = arrayOfString1.length;
      i = 0;
      if (i < j)
      {
        String str1 = arrayOfString1[i];
        boolean bool3 = str1.equalsIgnoreCase(paramString);
        if (!bool3);
      }
    }
    while (true)
    {
      return bool1;
      i += 1;
      break;
      bool1 = bool2;
    }
  }

  private Calendar parseBirthDate(String paramString)
  {
    Object localObject1;
    if (paramString != null)
    {
      String str = paramString.trim();
      int i = str.length();
      if (i != 0);
    }
    else
    {
      localObject1 = this.currentDate;
      ((Calendar)localObject1).clear();
      localObject1 = this.currentDate;
    }
    while (true)
    {
      return localObject1;
      try
      {
        localObject1 = this.currentDate;
        localObject2 = this.sysDateFormat;
        localObject2 = ((java.text.DateFormat)localObject2).parse(paramString);
        ((Calendar)localObject1).setTime((Date)localObject2);
        localObject1 = this.currentDate;
      }
      catch (Exception localException)
      {
        while (true)
        {
          localObject1 = L;
          Object localObject2 = "Unable to parse expiration date";
          int j = 0;
          Object[] arrayOfObject = new Object[j];
          ((DebugLogger)localObject1).error((String)localObject2, arrayOfObject);
        }
      }
    }
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
      localObject1 = this.currentDate;
      ((Calendar)localObject1).clear();
      localObject1 = this.currentDate;
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
              localObject4 = this.currentDate;
              int i1 = 1;
              ((Calendar)localObject4).set(j, i, i1);
            }
          }
        }
        localObject4 = this.currentDate;
      }
      catch (Exception localException)
      {
        while (true)
        {
          Object localObject4 = L;
          String str2 = "Unable to parse expiration date";
          int i2 = 0;
          Object[] arrayOfObject = new Object[i2];
          ((DebugLogger)localObject4).error(str2, arrayOfObject);
        }
      }
    }
  }

  private void removeDialog()
  {
    Object localObject = getActivity();
    localObject = ((FragmentActivity)localObject).getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
    localObject = getActivity();
    localObject = ((FragmentActivity)localObject).getSupportFragmentManager();
    String str = "dialog";
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(str);
    if (localFragment != null)
      localFragmentTransaction.remove(localFragment);
    localFragmentTransaction.commit();
  }

  private void renderCSCView(AddCardFragment.CardType paramCardType)
  {
    int k = 0;
    Object localObject = this.mRootView;
    int m = 2131427624;
    View localView = ((View)localObject).findViewById(m);
    int i;
    if (localView != null)
    {
      localObject = AddCardFragment.CardType.Etoiles;
      if (paramCardType != localObject)
        break label90;
      i = 1;
      if (i == 0)
        break label97;
    }
    label90: label97: for (int j = 8; ; j = 4)
    {
      String str = getAccountCountryCode();
      boolean bool = requiresVerificationCode(paramCardType, str);
      if (!bool)
      {
        bool = optionalVerificationCode(paramCardType, str);
        if (!bool);
      }
      else
      {
        j = k;
      }
      localView.setVisibility(j);
      return;
      i = k;
      break;
    }
  }

  private void renderCardLogoUI(AddCardFragment.CardType paramCardType)
  {
    int k = 2131427627;
    int j = 4;
    Object localObject3 = 1;
    Object localObject4 = 0;
    Object localObject2 = getActivity();
    Drawable localDrawable = paramCardType.getLogo((Context)localObject2);
    View localView = this.mRootView;
    Object localObject1;
    int i;
    if (localDrawable != null)
    {
      localObject2 = localObject3;
      ViewUtility.showOrHide(localView, k, localObject2);
      localObject2 = this.mRootView;
      localObject1 = ((View)localObject2).findViewById(k);
      localObject1 = (ImageView)localObject1;
      if (localObject1 != null)
      {
        if (localDrawable == null)
          break label130;
        i = localObject3;
        label82: if (i == 0)
          break label137;
        localObject2 = this.scanButton;
        if (localObject2 != null)
        {
          localObject2 = this.scanButton;
          ((ImageButton)localObject2).setVisibility(j);
        }
        ((ImageView)localObject1).setVisibility(localObject4);
        ((ImageView)localObject1).setImageDrawable(localDrawable);
      }
    }
    while (true)
    {
      return;
      localObject2 = localObject4;
      break;
      label130: i = localObject4;
      break label82;
      label137: ((ImageView)localObject1).setVisibility(j);
    }
  }

  private void renderExpirationDateView(AddCardFragment.CardType paramCardType)
  {
    View localView = this.mRootView;
    int i = 2131427630;
    AddCardFragment.CardType localCardType = AddCardFragment.CardType.Etoiles;
    if (paramCardType != localCardType);
    for (boolean bool = true; ; bool = false)
    {
      ViewUtility.showOrHide(localView, i, bool);
      return;
    }
  }

  public static boolean requiresDateOfBirth(AddCardFragment.CardType paramCardType)
  {
    int i = 5;
    AddCardFragment.CardType[] arrayOfCardType = new AddCardFragment.CardType[i];
    int j = 0;
    AddCardFragment.CardType localCardType = AddCardFragment.CardType.Cofinoga;
    arrayOfCardType[j] = localCardType;
    j = 1;
    localCardType = AddCardFragment.CardType.CarteAurore;
    arrayOfCardType[j] = localCardType;
    j = 2;
    localCardType = AddCardFragment.CardType.CartaAura;
    arrayOfCardType[j] = localCardType;
    j = 3;
    localCardType = AddCardFragment.CardType.TarjetaAurora;
    arrayOfCardType[j] = localCardType;
    j = 4;
    localCardType = AddCardFragment.CardType.Etoiles;
    arrayOfCardType[j] = localCardType;
    boolean bool = AddCardFragment.CardType.hasCardMatch(paramCardType, arrayOfCardType);
    return bool;
  }

  public static boolean requiresExpirationDate(AddCardFragment.CardType paramCardType)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AddCardFragment.CardType[] arrayOfCardType = new AddCardFragment.CardType[bool1];
    AddCardFragment.CardType localCardType = AddCardFragment.CardType.Etoiles;
    arrayOfCardType[bool2] = localCardType;
    boolean bool3 = AddCardFragment.CardType.hasCardMatch(paramCardType, arrayOfCardType);
    if (!bool3);
    while (true)
    {
      return bool1;
      bool1 = bool2;
    }
  }

  public static boolean requiresIssueNumberAndStartDate(AddCardFragment.CardType paramCardType)
  {
    int i = 1;
    AddCardFragment.CardType[] arrayOfCardType = new AddCardFragment.CardType[i];
    int j = 0;
    AddCardFragment.CardType localCardType = AddCardFragment.CardType.Solo;
    arrayOfCardType[j] = localCardType;
    boolean bool = AddCardFragment.CardType.hasCardMatch(paramCardType, arrayOfCardType);
    return bool;
  }

  public static boolean requiresLuhnValidation(AddCardFragment.CardType paramCardType)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AddCardFragment.CardType[] arrayOfCardType = new AddCardFragment.CardType[bool1];
    AddCardFragment.CardType localCardType = AddCardFragment.CardType.Etoiles;
    arrayOfCardType[bool2] = localCardType;
    boolean bool3 = AddCardFragment.CardType.hasCardMatch(paramCardType, arrayOfCardType);
    if (!bool3);
    while (true)
    {
      return bool1;
      bool1 = bool2;
    }
  }

  public static boolean requiresMod11Validation(AddCardFragment.CardType paramCardType)
  {
    int i = 1;
    AddCardFragment.CardType[] arrayOfCardType = new AddCardFragment.CardType[i];
    int j = 0;
    AddCardFragment.CardType localCardType = AddCardFragment.CardType.Etoiles;
    arrayOfCardType[j] = localCardType;
    boolean bool = AddCardFragment.CardType.hasCardMatch(paramCardType, arrayOfCardType);
    return bool;
  }

  public static boolean requiresVerificationCode(AddCardFragment.CardType paramCardType, String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    boolean bool3 = optionalVerificationCode(paramCardType, paramString);
    if (bool3)
      return bool2;
    int i = 3;
    AddCardFragment.CardType[] arrayOfCardType = new AddCardFragment.CardType[i];
    AddCardFragment.CardType localCardType1 = AddCardFragment.CardType.Cofinoga;
    arrayOfCardType[bool2] = localCardType1;
    localCardType1 = AddCardFragment.CardType.CarteAurore;
    arrayOfCardType[bool1] = localCardType1;
    int j = 2;
    AddCardFragment.CardType localCardType2 = AddCardFragment.CardType.Etoiles;
    arrayOfCardType[j] = localCardType2;
    boolean bool4 = AddCardFragment.CardType.hasCardMatch(paramCardType, arrayOfCardType);
    if (!bool4);
    while (true)
    {
      bool2 = bool1;
      break;
      bool1 = bool2;
    }
  }

  public void setAddressFromModel(int paramInt)
  {
    this.mAddressIndex = paramInt;
    List localList = getAddressesFromModel();
    int i = this.mAddressIndex;
    Object localObject1 = localList.get(i);
    localObject1 = (Address)localObject1;
    Object localObject2 = this.mCredebit;
    Object localObject3 = new com/paypal/android/foundation/core/model/MutableAddress;
    ((MutableAddress)localObject3).<init>((Address)localObject1);
    ((MutableCredebitCard)localObject2).setBillingAddress((MutableAddress)localObject3);
    localObject2 = this.billAdress;
    localObject3 = ((Address)localObject1).getFormattedLines();
    setAddressToTextView((TextView)localObject2, (List)localObject3);
  }

  private void setAddressToTextView(TextView paramTextView, List<String> paramList)
  {
    String str = CardFormatter.getFormattedAddressAsString(paramList);
    paramTextView.setText(str);
  }

  private void setCardNumber(String paramString)
  {
    MutableCredebitCard localMutableCredebitCard = this.mCredebit;
    localMutableCredebitCard.setCardNumber(paramString);
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1;
    Object localObject2;
    if (!bool)
    {
      localObject1 = this.mCredebit;
      localObject2 = " ";
      String str = "";
      localObject2 = paramString.replace((CharSequence)localObject2, str);
      ((MutableCredebitCard)localObject1).setCardNumber((String)localObject2);
      localObject1 = this.mCredebit;
      localObject1 = ((MutableCredebitCard)localObject1).getCardNumber();
      AddCardFragment.CardType localCardType = getCardFromNumber((String)localObject1);
      localObject1 = this.mCredebit;
      localObject2 = localCardType.getCardAPIName();
      ((MutableCredebitCard)localObject1).setType((String)localObject2);
    }
    while (true)
    {
      return;
      localObject1 = this.mCredebit;
      localObject2 = AddCardFragment.CardType.Unknown;
      localObject2 = ((AddCardFragment.CardType)localObject2).getCardAPIName();
      ((MutableCredebitCard)localObject1).setType((String)localObject2);
    }
  }

  public void setDate(int paramInt1, int paramInt2)
  {
    int m = 0;
    int i3 = 1;
    Calendar localCalendar = Calendar.getInstance();
    if (paramInt2 < i3)
    {
      int i = m;
      localCalendar.set(paramInt1, i, i3);
      int[] arrayOfInt = AddCardFragment.11.$SwitchMap$com$paypal$android$p2pmobile$fragment$wallet$AddCardFragment$CurrentDateTextView;
      AddCardFragment.CurrentDateTextView localCurrentDateTextView = this.mCurrentDateTextView;
      int i2 = localCurrentDateTextView.ordinal();
      int j = arrayOfInt[i2];
      switch (j)
      {
      default:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      Object localObject1 = this.addButton;
      AddCardFragment.CardType localCardType = getCredebitCardType();
      boolean bool = validateCard(localCardType);
      ((Button)localObject1).setEnabled(bool);
      localObject1 = getActivity();
      localObject1 = ((FragmentActivity)localObject1).getWindow();
      int n = 5;
      ((Window)localObject1).setSoftInputMode(n);
      return;
      int k = paramInt2 + -1;
      break;
      Object localObject2 = this.dateOfBirth;
      Object localObject5 = new java/lang/StringBuilder;
      ((StringBuilder)localObject5).<init>();
      String str = "%02d";
      Object[] arrayOfObject = new Object[i3];
      Integer localInteger = Integer.valueOf(paramInt2);
      arrayOfObject[n] = localInteger;
      Object localObject3 = String.format(str, arrayOfObject);
      localObject3 = ((StringBuilder)localObject5).append((String)localObject3);
      localObject5 = "/";
      localObject3 = ((StringBuilder)localObject3).append((String)localObject5);
      localObject3 = ((StringBuilder)localObject3).append(paramInt1);
      localObject3 = ((StringBuilder)localObject3).toString();
      ((EditFitTextView)localObject2).setText((CharSequence)localObject3);
      localObject2 = this.mCredebit;
      localObject3 = localCalendar.getTime();
      ((MutableCredebitCard)localObject2).setCardHolderBirthDate((Date)localObject3);
      continue;
      localObject2 = this.expDate;
      localObject5 = new java/lang/StringBuilder;
      ((StringBuilder)localObject5).<init>();
      str = "%02d";
      arrayOfObject = new Object[i3];
      localInteger = Integer.valueOf(paramInt2);
      arrayOfObject[localObject3] = localInteger;
      localObject3 = String.format(str, arrayOfObject);
      localObject3 = ((StringBuilder)localObject5).append((String)localObject3);
      localObject5 = "/";
      localObject3 = ((StringBuilder)localObject3).append((String)localObject5);
      localObject3 = ((StringBuilder)localObject3).append(paramInt1);
      localObject3 = ((StringBuilder)localObject3).toString();
      ((EditFitTextView)localObject2).setText((CharSequence)localObject3);
      localObject2 = this.mCredebit;
      int i1 = 2;
      i1 = localCalendar.get(i1);
      i1 += 1;
      ((MutableCredebitCard)localObject2).setExpirationMonth(i1);
      localObject2 = this.mCredebit;
      i1 = localCalendar.get(i3);
      ((MutableCredebitCard)localObject2).setExpirationYear(i1);
      continue;
      localObject2 = this.startDate;
      localObject5 = new java/lang/StringBuilder;
      ((StringBuilder)localObject5).<init>();
      str = "%02d";
      arrayOfObject = new Object[i3];
      localInteger = Integer.valueOf(paramInt2);
      arrayOfObject[i1] = localInteger;
      Object localObject4 = String.format(str, arrayOfObject);
      localObject4 = ((StringBuilder)localObject5).append((String)localObject4);
      localObject5 = "/";
      localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
      localObject4 = ((StringBuilder)localObject4).append(paramInt1);
      localObject4 = ((StringBuilder)localObject4).toString();
      ((EditFitTextView)localObject2).setText((CharSequence)localObject4);
      localObject2 = this.mCredebit;
      localObject4 = localCalendar.getTime();
      ((MutableCredebitCard)localObject2).setIssueDate((Date)localObject4);
    }
  }

  public void setEntryPoint(AddCardFragment.AddCardEntryPoint paramAddCardEntryPoint)
  {
    this.mEntryPoint = paramAddCardEntryPoint;
  }

  private void setIssueNumber(String paramString)
  {
    MutableCredebitCard localMutableCredebitCard = this.mCredebit;
    localMutableCredebitCard.setIssueNumber(paramString);
  }

  private void setLongClickable(View paramView, boolean paramBoolean)
  {
    paramView.setLongClickable(paramBoolean);
  }

  private void setVerificationNumber(String paramString)
  {
    MutableCredebitCard localMutableCredebitCard = this.mCredebit;
    localMutableCredebitCard.setCvvNumber(paramString);
  }

  public static boolean shouldUseMaxCardLengthFilter(AddCardFragment.CardType paramCardType)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AddCardFragment.CardType[] arrayOfCardType = new AddCardFragment.CardType[bool1];
    AddCardFragment.CardType localCardType = AddCardFragment.CardType.Etoiles;
    arrayOfCardType[bool2] = localCardType;
    boolean bool3 = AddCardFragment.CardType.hasCardMatch(paramCardType, arrayOfCardType);
    if (!bool3);
    while (true)
    {
      return bool1;
      bool1 = bool2;
    }
  }

  private void showDOBDialog(Calendar paramCalendar)
  {
    int n = 1;
    int m = 0;
    DebugLogger localDebugLogger = L;
    String str1 = "Creating the DOB dialog";
    Object[] arrayOfObject = new Object[m];
    localDebugLogger.verbose(str1, arrayOfObject);
    int i = paramCalendar.get(n);
    int j = 2;
    j = paramCalendar.get(j);
    int k = 5;
    k = paramCalendar.get(k);
    Object localObject2 = AddCardFragment.class;
    localObject2 = ((Class)localObject2).getName();
    String str3 = "dateOfBirth";
    DatePickerDialog localDatePickerDialog = DatePickerDialog.newInstance(i, j, k, (String)localObject2, str3);
    Object localObject1 = new java/util/GregorianCalendar;
    j = 1900;
    ((GregorianCalendar)localObject1).<init>(j, m, n);
    localDatePickerDialog.setMinDate((Calendar)localObject1);
    Calendar localCalendar = Calendar.getInstance();
    localDatePickerDialog.setMaxDate(localCalendar);
    localObject1 = getFragmentManager();
    String str2 = "dialog";
    localDatePickerDialog.show((FragmentManager)localObject1, str2);
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
    label139: Object localObject2 = this.mCredebit;
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
    TrackPage.Point localPoint = TrackPage.Point.AddCardOverview;
    AddCardFragment localAddCardFragment = this;
    AddCardPersonalInfoActivity.start(localAddCardFragment, str3, localArrayList, k, m, n, localPoint);
  }

  private boolean validateCard(AddCardFragment.CardType paramCardType)
  {
    boolean bool2 = isValidCardNumber(paramCardType);
    if (bool2)
    {
      String str = getAccountCountryCode();
      boolean bool3 = requiresVerificationCode(paramCardType, str);
      if (bool3)
      {
        bool3 = isValidVerificationNumber();
        if (!bool3);
      }
      else
      {
        bool3 = requiresExpirationDate(paramCardType);
        if (bool3)
        {
          bool3 = isExpirationDateProvided();
          if (!bool3);
        }
        else
        {
          bool3 = requiresDateOfBirth(paramCardType);
          if (bool3)
          {
            Object localObject1 = this.mCredebit;
            localObject1 = ((MutableCredebitCard)localObject1).getCardHolderBirthDate();
            if (localObject1 == null);
          }
          else
          {
            boolean bool4 = requiresIssueNumberAndStartDate(paramCardType);
            boolean bool5;
            if (bool4)
            {
              bool4 = isIssueStartDateProvided();
              if (bool4)
              {
                Object localObject2 = this.mCredebit;
                localObject2 = ((MutableCredebitCard)localObject2).getIssueNumber();
                bool5 = TextUtils.isEmpty((CharSequence)localObject2);
                if (bool5);
              }
            }
            else
            {
              bool5 = hasValidUserInfo();
              if (!bool5);
            }
          }
        }
      }
    }
    for (boolean bool1 = true; ; bool1 = false)
      return bool1;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddCardFragment
 * JD-Core Version:    0.6.2
 */
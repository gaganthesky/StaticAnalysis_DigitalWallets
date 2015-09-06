package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.paypal.android.base.Logging;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.utils.UI;
import java.util.Currency;

public class PSBDetailsFragment extends BaseFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final String LOG_TAG = (String)localObject;
  String mAmount;
  String mCurrency;
  String mExpireDate;
  private View mRoot;

  static
  {
    Object localObject = PSBDetailsFragment.class;
    localObject = ((Class)localObject).getSimpleName();
  }

  private PSBDetailsFragment.OnPSBDetailsFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (PSBDetailsFragment.OnPSBDetailsFragmentListener)localObject;
    return localObject;
  }

  public static PSBDetailsFragment newInstance()
  {
    PSBDetailsFragment localPSBDetailsFragment = new com/paypal/android/p2pmobile/fragment/wallet/PSBDetailsFragment;
    localPSBDetailsFragment.<init>();
    return localPSBDetailsFragment;
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
  }

  public void onClick(View paramView)
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    Object localObject = LOG_TAG;
    String str = "onCreate called for PSB details";
    Logging.d((String)localObject, str);
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      localObject = getArguments();
      str = "amount";
      localObject = ((Bundle)localObject).getString(str);
      this.mAmount = ((String)localObject);
      localObject = getArguments();
      str = "expireDate";
      localObject = ((Bundle)localObject).getString(str);
      this.mExpireDate = ((String)localObject);
      localObject = getArguments();
      str = "currency";
      localObject = ((Bundle)localObject).getString(str);
    }
    for (this.mCurrency = ((String)localObject); ; this.mCurrency = ((String)localObject))
    {
      return;
      localObject = "amount";
      localObject = paramBundle.getString((String)localObject);
      this.mAmount = ((String)localObject);
      localObject = "expireDate";
      localObject = paramBundle.getString((String)localObject);
      this.mExpireDate = ((String)localObject);
      localObject = "currency";
      localObject = paramBundle.getString((String)localObject);
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    int i = 2130903332;
    ViewGroup localViewGroup = null;
    Object localObject2 = paramLayoutInflater.inflate(i, localViewGroup);
    this.mRoot = ((View)localObject2);
    localObject2 = this.mRoot;
    int j = 2131428592;
    Object localObject3 = this.mAmount;
    UI.setText((View)localObject2, j, (CharSequence)localObject3);
    localObject2 = this.mRoot;
    j = 2131428598;
    localObject3 = new java/lang/StringBuilder;
    ((StringBuilder)localObject3).<init>();
    Object localObject4 = getResources();
    int n = 2131495058;
    localObject4 = ((Resources)localObject4).getString(n);
    localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
    localObject4 = ": ";
    localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
    localObject4 = this.mExpireDate;
    localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
    localObject3 = ((StringBuilder)localObject3).toString();
    UI.setText((View)localObject2, j, (CharSequence)localObject3);
    localObject2 = this.mCurrency;
    Currency localCurrency = Currency.getInstance((String)localObject2);
    localObject2 = getResources();
    j = 2131495059;
    localObject2 = ((Resources)localObject2).getString(j);
    j = 1;
    Object[] arrayOfObject = new Object[j];
    int m = 0;
    localObject4 = new java/lang/StringBuilder;
    ((StringBuilder)localObject4).<init>();
    String str3 = localCurrency.getSymbol();
    localObject4 = ((StringBuilder)localObject4).append(str3);
    str3 = this.mAmount;
    localObject4 = ((StringBuilder)localObject4).append(str3);
    str3 = " ";
    localObject4 = ((StringBuilder)localObject4).append(str3);
    str3 = this.mCurrency;
    localObject4 = ((StringBuilder)localObject4).append(str3);
    localObject4 = ((StringBuilder)localObject4).toString();
    arrayOfObject[m] = localObject4;
    String str1 = String.format((String)localObject2, arrayOfObject);
    localObject2 = this.mRoot;
    int k = 2131428671;
    UI.setText((View)localObject2, k, str1);
    localObject2 = this.mRoot;
    k = 2131428666;
    String str2 = localCurrency.getSymbol();
    UI.setText((View)localObject2, k, str2);
    localObject2 = this.mRoot;
    k = 2131428672;
    Object localObject1 = ((View)localObject2).findViewById(k);
    localObject1 = (Button)localObject1;
    localObject2 = new com/paypal/android/p2pmobile/fragment/wallet/PSBDetailsFragment$1;
    ((PSBDetailsFragment.1)localObject2).<init>(this);
    ((Button)localObject1).setOnClickListener((CompoundButton.OnCheckedChangeListener)localObject2);
    localObject2 = this.mRoot;
    return localObject2;
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    String str1 = this.mAmount;
    if (str1 != null)
    {
      str1 = "id";
      str2 = this.mAmount;
      paramBundle.putString(str1, str2);
    }
    str1 = this.mExpireDate;
    if (str1 != null)
    {
      str1 = "expireDate";
      str2 = this.mExpireDate;
      paramBundle.putString(str1, str2);
    }
    str1 = this.mCurrency;
    if (str1 != null)
    {
      str1 = "currency";
      str2 = this.mCurrency;
      paramBundle.putString(str1, str2);
    }
    str1 = "amount";
    String str2 = this.mAmount;
    paramBundle.putString(str1, str2);
    str1 = "expireDate";
    str2 = this.mExpireDate;
    paramBundle.putString(str1, str2);
    str1 = "currency";
    str2 = this.mCurrency;
    paramBundle.putString(str1, str2);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.PSBDetailsFragment
 * JD-Core Version:    0.6.2
 */
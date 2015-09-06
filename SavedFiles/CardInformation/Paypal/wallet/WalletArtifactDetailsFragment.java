package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.paypal.android.foundation.account.AccountModel;
import com.paypal.android.foundation.account.model.Artifact;
import com.paypal.android.foundation.account.model.BankAccount;
import com.paypal.android.foundation.account.model.BankAccountType;
import com.paypal.android.foundation.account.model.CredebitCard;
import com.paypal.android.foundation.account.model.CredebitCardType;
import com.paypal.android.foundation.core.model.Address;
import com.paypal.android.foundation.core.model.UniqueId;
import com.paypal.android.p2pmobile.PayPalApp;
import com.paypal.android.p2pmobile.adapters.WalletArtifactAdapter;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.utils.CardFormatter;
import com.paypal.android.p2pmobile.utils.UI;
import com.paypal.android.p2pmobile.utils.ViewUtility;
import java.util.List;

public class WalletArtifactDetailsFragment extends BaseFragment
{
  private static final String BUNDLE_KEY_POSITION = "position";
  private static final String BUNDLE_KEY_SHOW_CONTINUE = "show_continue";
  private static final String BUNDLE_KEY_UNIQUE_ID = "unique_id";

  private WalletArtifactDetailsFragment.OnWalletArtifactDetailsFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (WalletArtifactDetailsFragment.OnWalletArtifactDetailsFragmentListener)localObject;
    return localObject;
  }

  public static WalletArtifactDetailsFragment newInstance(UniqueId paramUniqueId, int paramInt)
  {
    WalletArtifactDetailsFragment localWalletArtifactDetailsFragment = new com/paypal/android/p2pmobile/fragment/wallet/WalletArtifactDetailsFragment;
    localWalletArtifactDetailsFragment.<init>();
    Bundle localBundle = new android/os/Bundle;
    localBundle.<init>();
    String str = "position";
    localBundle.putInt(str, paramInt);
    str = "unique_id";
    localBundle.putParcelable(str, paramUniqueId);
    localWalletArtifactDetailsFragment.setArguments(localBundle);
    return localWalletArtifactDetailsFragment;
  }

  public static WalletArtifactDetailsFragment newInstance(UniqueId paramUniqueId, boolean paramBoolean, int paramInt)
  {
    WalletArtifactDetailsFragment localWalletArtifactDetailsFragment = new com/paypal/android/p2pmobile/fragment/wallet/WalletArtifactDetailsFragment;
    localWalletArtifactDetailsFragment.<init>();
    Bundle localBundle = new android/os/Bundle;
    localBundle.<init>();
    String str = "position";
    localBundle.putInt(str, paramInt);
    str = "show_continue";
    localBundle.putBoolean(str, paramBoolean);
    str = "unique_id";
    localBundle.putParcelable(str, paramUniqueId);
    localWalletArtifactDetailsFragment.setArguments(localBundle);
    return localWalletArtifactDetailsFragment;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    int i = 2130903395;
    Object localObject13 = null;
    Object localObject1 = paramLayoutInflater;
    View localView8 = ((LayoutInflater)localObject1).inflate(i, (ViewGroup)localObject13);
    Object localObject2 = getArguments();
    localObject13 = "unique_id";
    Object localObject19 = ((Bundle)localObject2).getParcelable((String)localObject13);
    localObject19 = (UniqueId)localObject19;
    localObject2 = AccountModel.getInstance();
    Object localObject12 = ((AccountModel)localObject2).getArtifactById((UniqueId)localObject19);
    label433: Object localObject14;
    if (localView8 != null)
    {
      int j = 2131427926;
      View localView1 = localView8.findViewById(j);
      localObject13 = getActivity();
      boolean bool11 = true;
      Bundle localBundle = getArguments();
      Object localObject15 = "position";
      int i20 = localBundle.getInt((String)localObject15);
      localObject15 = paramLayoutInflater;
      ViewGroup localViewGroup = paramViewGroup;
      WalletArtifactAdapter.populateView(localView1, (Artifact)localObject12, (Context)localObject13, bool11, i20, (LayoutInflater)localObject15, localViewGroup);
      boolean bool1 = localObject12 instanceof CredebitCard;
      if (!bool1)
        break label678;
      int k = 2131428921;
      View localView2 = localView8.findViewById(k);
      int i15 = 0;
      localView2.setVisibility(i15);
      int m = 2131427929;
      View localView3 = localView8.findViewById(m);
      i15 = 8;
      localView3.setVisibility(i15);
      int n = 2131428922;
      Object localObject18 = localView8.findViewById(n);
      localObject18 = (TextView)localObject18;
      Object localObject3 = localObject12;
      localObject3 = (CredebitCard)localObject3;
      localObject3 = ((CredebitCard)localObject3).getCardType();
      localObject3 = ((CredebitCardType)localObject3).getName();
      ((TextView)localObject18).setText((CharSequence)localObject3);
      localObject3 = localObject12;
      localObject3 = (CredebitCard)localObject3;
      localObject3 = ((CredebitCard)localObject3).getCardType();
      localObject3 = ((CredebitCardType)localObject3).getType();
      AddCardFragment.CardType localCardType = AddCardFragment.CardType.fromCardNameFromAPIName((String)localObject3);
      boolean bool2 = AddCardFragment.requiresExpirationDate(localCardType);
      if (bool2)
        break label523;
      int i1 = 2131428924;
      i15 = 0;
      ViewUtility.showOrHide(localView8, i1, i15);
      i1 = 2131428923;
      int i16 = 0;
      ViewUtility.showOrHide(localView8, i1, i16);
      Object localObject4 = localObject12;
      localObject4 = (CredebitCard)localObject4;
      Address localAddress = ((CredebitCard)localObject4).getBillingAddress();
      if (localAddress != null)
      {
        int i2 = 2131428928;
        Object localObject16 = localView8.findViewById(i2);
        localObject16 = (TextView)localObject16;
        Object localObject5 = localAddress.getFormattedLines();
        localObject5 = CardFormatter.getFormattedAddressAsString((List)localObject5);
        ((TextView)localObject16).setText((CharSequence)localObject5);
      }
      localObject12 = (CredebitCard)localObject12;
      boolean bool3 = ((CredebitCard)localObject12).isExpired();
      if (bool3)
      {
        int i3 = 2131427927;
        localObject6 = localView8.findViewById(i3);
        i16 = 0;
        ((View)localObject6).setVisibility(i16);
      }
      Object localObject6 = getArguments();
      String str1 = "show_continue";
      bool11 = false;
      boolean bool4 = ((Bundle)localObject6).getBoolean(str1, bool11);
      if (!bool4)
        break label929;
      int i4 = 2131428929;
      View localView4 = localView8.findViewById(i4);
      int i17 = 0;
      localView4.setVisibility(i17);
      int i5 = 2131428929;
      View localView5 = localView8.findViewById(i5);
      localObject14 = new com/paypal/android/p2pmobile/fragment/wallet/WalletArtifactDetailsFragment$1;
      localObject1 = this;
      ((WalletArtifactDetailsFragment.1)localObject14).<init>((WalletArtifactDetailsFragment)localObject1);
      localView5.setOnClickListener((View.OnClickListener)localObject14);
    }
    while (true)
    {
      return localView8;
      label523: int i6 = 2131428926;
      Object localObject17 = localView8.findViewById(i6);
      localObject17 = (TextView)localObject17;
      localObject14 = new java/lang/StringBuilder;
      ((StringBuilder)localObject14).<init>();
      Object localObject7 = localObject12;
      localObject7 = (CredebitCard)localObject7;
      int i7 = ((CredebitCard)localObject7).getExpirationMonth();
      Object localObject8 = ((StringBuilder)localObject14).append(i7);
      localObject14 = "/";
      localObject14 = ((StringBuilder)localObject8).append((String)localObject14);
      localObject8 = localObject12;
      localObject8 = (CredebitCard)localObject8;
      int i8 = ((CredebitCard)localObject8).getExpirationYear();
      Object localObject9 = ((StringBuilder)localObject14).append(i8);
      localObject9 = ((StringBuilder)localObject9).toString();
      ((TextView)localObject17).setText((CharSequence)localObject9);
      localObject9 = localObject12;
      localObject9 = (CredebitCard)localObject9;
      boolean bool5 = ((CredebitCard)localObject9).isExpired();
      if (bool5);
      for (int i9 = -5037289; ; i9 = -13421773)
      {
        ((TextView)localObject17).setTextColor(i9);
        break;
      }
      label678: boolean bool6 = localObject12 instanceof BankAccount;
      if (!bool6)
        break label433;
      int i10 = 2131428921;
      View localView6 = localView8.findViewById(i10);
      int i18 = 8;
      localView6.setVisibility(i18);
      int i11 = 2131427929;
      Object localObject10 = localView8.findViewById(i11);
      i18 = 0;
      ((View)localObject10).setVisibility(i18);
      String str2 = "CHECKING";
      localObject10 = localObject12;
      localObject10 = (BankAccount)localObject10;
      localObject10 = ((BankAccount)localObject10).getAccountType();
      localObject10 = ((BankAccountType)localObject10).getName();
      boolean bool7 = str2.equalsIgnoreCase((String)localObject10);
      if (bool7);
      for (int i21 = 2131494686; ; i21 = 2131494687)
      {
        int i12 = 2131427810;
        Object localObject11 = localView8.findViewById(i12);
        localObject11 = (TextView)localObject11;
        localObject1 = this;
        str2 = ((WalletArtifactDetailsFragment)localObject1).getString(i21);
        ((TextView)localObject11).setText(str2);
        boolean bool8 = PayPalApp.getSupportsBankAccountConfirmationStatus();
        if (bool8)
          break label859;
        int i13 = 2131427811;
        boolean bool10 = false;
        ViewUtility.showOrHide(localView8, i13, bool10);
        break;
      }
      label859: localObject12 = (BankAccount)localObject12;
      boolean bool9 = ((BankAccount)localObject12).isConfirmed();
      if (bool9)
      {
        i14 = 2131494778;
        localObject1 = this;
      }
      for (String str3 = ((WalletArtifactDetailsFragment)localObject1).getString(i14); ; str3 = ((WalletArtifactDetailsFragment)localObject1).getString(i14))
      {
        i14 = 2131427813;
        UI.setText(localView8, i14, str3);
        break;
        i14 = 2131494779;
        localObject1 = this;
      }
      label929: int i14 = 2131428929;
      View localView7 = localView8.findViewById(i14);
      int i19 = 8;
      localView7.setVisibility(i19);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WalletArtifactDetailsFragment
 * JD-Core Version:    0.6.2
 */
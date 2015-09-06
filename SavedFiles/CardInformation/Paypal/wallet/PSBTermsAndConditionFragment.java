package com.paypal.android.p2pmobile.fragment.wallet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.paypal.android.p2pmobile.fragment.BaseFragment;
import com.paypal.android.p2pmobile.utils.UI;

public class PSBTermsAndConditionFragment extends BaseFragment
{
  private View mRoot;

  private View layoutView(View paramView)
  {
    int i = 2131428675;
    int j = 2131495055;
    UI.setText(paramView, i, j);
    return paramView;
  }

  public static PSBTermsAndConditionFragment newInstance()
  {
    PSBTermsAndConditionFragment localPSBTermsAndConditionFragment = new com/paypal/android/p2pmobile/fragment/wallet/PSBTermsAndConditionFragment;
    localPSBTermsAndConditionFragment.<init>();
    return localPSBTermsAndConditionFragment;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    int i = 2130903334;
    ViewGroup localViewGroup = null;
    View localView = paramLayoutInflater.inflate(i, localViewGroup);
    this.mRoot = localView;
    localView = this.mRoot;
    localView = layoutView(localView);
    return localView;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.PSBTermsAndConditionFragment
 * JD-Core Version:    0.6.2
 */
package com.paypal.android.p2pmobile.fragment.wallet;

import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.foundation.account.model.MutableCredebitCard;
import com.paypal.android.p2pmobile.fragment.BaseFragment;

public class ConfirmCSCFragment extends BaseFragment
{
  public static final String BUNDLE_KEY_EDITED_CARD = "unique_id";
  private EditText mCSCInputView;
  private TextView mDoneButton;
  private MutableCredebitCard mEditedCard;

  private ConfirmCSCFragment.OnConfirmCSCFragmentListener getLocalListener()
  {
    Object localObject = getListener();
    localObject = (ConfirmCSCFragment.OnConfirmCSCFragmentListener)localObject;
    return localObject;
  }

  public static ConfirmCSCFragment newInstance()
  {
    ConfirmCSCFragment localConfirmCSCFragment = new com/paypal/android/p2pmobile/fragment/wallet/ConfirmCSCFragment;
    localConfirmCSCFragment.<init>();
    return localConfirmCSCFragment;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    TrackPage.Point localPoint = TrackPage.Point.SecurityCodeChallenge;
    setTrackPage(localPoint);
    int i = 2130903187;
    Object localObject4 = null;
    View localView = paramLayoutInflater.inflate(i, (ViewGroup)localObject4);
    if (localView != null)
    {
      Object localObject1 = getArguments();
      localObject4 = "unique_id";
      localObject1 = ((Bundle)localObject1).getParcelable((String)localObject4);
      localObject1 = (MutableCredebitCard)localObject1;
      this.mEditedCard = ((MutableCredebitCard)localObject1);
      int j = 2131427489;
      Object localObject2 = localView.findViewById(j);
      localObject2 = (TextView)localObject2;
      this.mDoneButton = ((TextView)localObject2);
      int k = 2131427898;
      Object localObject3 = localView.findViewById(k);
      localObject3 = (EditText)localObject3;
      this.mCSCInputView = ((EditText)localObject3);
      localObject3 = this.mCSCInputView;
      localObject4 = new com/paypal/android/p2pmobile/fragment/wallet/ConfirmCSCFragment$1;
      ((ConfirmCSCFragment.1)localObject4).<init>(this);
      ((EditText)localObject3).addTextChangedListener((TextWatcher)localObject4);
      localObject3 = this.mDoneButton;
      localObject4 = new com/paypal/android/p2pmobile/fragment/wallet/ConfirmCSCFragment$2;
      ((ConfirmCSCFragment.2)localObject4).<init>(this);
      ((TextView)localObject3).setOnClickListener((View.OnClickListener)localObject4);
    }
    return localView;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.ConfirmCSCFragment
 * JD-Core Version:    0.6.2
 */
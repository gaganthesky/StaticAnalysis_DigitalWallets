package com.paypal.android.p2pmobile.fragment.wallet;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;

class AddLoyaltyCardFragment$4
  implements TextWatcher
{
  final AddLoyaltyCardFragment this$0;

  AddLoyaltyCardFragment$4(AddLoyaltyCardFragment paramAddLoyaltyCardFragment)
  {
  }

  public void afterTextChanged(Editable paramEditable)
  {
    AddLoyaltyCardFragment localAddLoyaltyCardFragment = this.this$0;
    String str = paramEditable.toString();
    AddLoyaltyCardFragment.access$700(localAddLoyaltyCardFragment, str);
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = this.this$0;
    localObject1 = AddLoyaltyCardFragment.access$300((AddLoyaltyCardFragment)localObject1);
    int i = 4;
    ((ImageButton)localObject1).setVisibility(i);
    localObject1 = paramCharSequence.toString();
    boolean bool = ((String)localObject1).isEmpty();
    if (bool)
    {
      Object localObject2 = this.this$0;
      localObject2 = AddLoyaltyCardFragment.access$300((AddLoyaltyCardFragment)localObject2);
      i = 0;
      ((ImageButton)localObject2).setVisibility(i);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddLoyaltyCardFragment.4
 * JD-Core Version:    0.6.2
 */
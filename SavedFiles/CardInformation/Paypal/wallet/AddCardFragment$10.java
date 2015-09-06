package com.paypal.android.p2pmobile.fragment.wallet;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

class AddCardFragment$10
  implements TextWatcher
{
  final AddCardFragment this$0;

  AddCardFragment$10(AddCardFragment paramAddCardFragment)
  {
  }

  public void afterTextChanged(Editable paramEditable)
  {
    Object localObject1 = this.this$0;
    Object localObject2 = paramEditable.toString();
    AddCardFragment.access$2200((AddCardFragment)localObject1, (String)localObject2);
    localObject1 = this.this$0;
    localObject1 = AddCardFragment.access$800((AddCardFragment)localObject1);
    localObject2 = this.this$0;
    Object localObject3 = this.this$0;
    localObject3 = AddCardFragment.access$200((AddCardFragment)localObject3);
    boolean bool = AddCardFragment.access$700((AddCardFragment)localObject2, (AddCardFragment.CardType)localObject3);
    ((Button)localObject1).setEnabled(bool);
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddCardFragment.10
 * JD-Core Version:    0.6.2
 */
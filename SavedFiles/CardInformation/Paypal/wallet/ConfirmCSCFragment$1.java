package com.paypal.android.p2pmobile.fragment.wallet;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

class ConfirmCSCFragment$1
  implements TextWatcher
{
  final ConfirmCSCFragment this$0;

  ConfirmCSCFragment$1(ConfirmCSCFragment paramConfirmCSCFragment)
  {
  }

  public void afterTextChanged(Editable paramEditable)
  {
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    int i = paramCharSequence.length();
    int j = 2;
    Object localObject;
    if (i > j)
    {
      localObject = this.this$0;
      localObject = ConfirmCSCFragment.access$000((ConfirmCSCFragment)localObject);
      ((TextView)localObject).setEnabled(bool2);
      localObject = this.this$0;
      localObject = ConfirmCSCFragment.access$000((ConfirmCSCFragment)localObject);
      ((TextView)localObject).setClickable(bool2);
    }
    while (true)
    {
      return;
      localObject = this.this$0;
      localObject = ConfirmCSCFragment.access$000((ConfirmCSCFragment)localObject);
      ((TextView)localObject).setEnabled(bool1);
      localObject = this.this$0;
      localObject = ConfirmCSCFragment.access$000((ConfirmCSCFragment)localObject);
      ((TextView)localObject).setClickable(bool1);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.ConfirmCSCFragment.1
 * JD-Core Version:    0.6.2
 */
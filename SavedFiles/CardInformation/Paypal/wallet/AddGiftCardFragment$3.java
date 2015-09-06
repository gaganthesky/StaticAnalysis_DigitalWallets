package com.paypal.android.p2pmobile.fragment.wallet;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.paypal.android.foundation.account.model.GiftProgram;
import com.paypal.android.foundation.core.model.MutableMoneyValue;
import com.paypal.android.p2pmobile.utils.WalletNumberFormatUtil;
import com.paypal.android.p2pmobile.widgets.RobotoEditText;

class AddGiftCardFragment$3
  implements TextWatcher
{
  final AddGiftCardFragment this$0;
  final RobotoEditText val$manualBalanceEditText;

  AddGiftCardFragment$3(AddGiftCardFragment paramAddGiftCardFragment, RobotoEditText paramRobotoEditText)
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
    Object localObject1 = this.this$0;
    localObject1 = AddGiftCardFragment.access$400((AddGiftCardFragment)localObject1);
    if (localObject1 == null)
    {
      localObject1 = this.this$0;
      double d = 0.0D;
      localObject2 = Double.valueOf(d);
      localObject3 = this.this$0;
      localObject3 = AddGiftCardFragment.access$000((AddGiftCardFragment)localObject3);
      localObject3 = ((GiftProgram)localObject3).getCurrencyCode();
      localObject2 = MutableMoneyValue.createIfValid((Number)localObject2, (String)localObject3);
      AddGiftCardFragment.access$402((AddGiftCardFragment)localObject1, (MutableMoneyValue)localObject2);
    }
    localObject1 = this.this$0;
    Object localObject2 = this.val$manualBalanceEditText;
    Object localObject3 = this.this$0;
    localObject3 = AddGiftCardFragment.access$400((AddGiftCardFragment)localObject3);
    localObject2 = WalletNumberFormatUtil.getFormattedAmount((EditText)localObject2, this, paramCharSequence, (MutableMoneyValue)localObject3);
    AddGiftCardFragment.access$402((AddGiftCardFragment)localObject1, (MutableMoneyValue)localObject2);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddGiftCardFragment.3
 * JD-Core Version:    0.6.2
 */
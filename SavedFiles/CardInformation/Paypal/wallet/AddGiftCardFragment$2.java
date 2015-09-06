package com.paypal.android.p2pmobile.fragment.wallet;

import android.text.Editable;
import android.text.TextWatcher;
import com.paypal.android.foundation.account.model.GiftProgram;
import com.paypal.android.p2pmobile.utils.WalletNumberFormatUtil;

class AddGiftCardFragment$2
  implements TextWatcher
{
  private static final char space = ' ';
  final AddGiftCardFragment this$0;

  AddGiftCardFragment$2(AddGiftCardFragment paramAddGiftCardFragment)
  {
  }

  public void afterTextChanged(Editable paramEditable)
  {
    Object localObject1 = this.this$0;
    localObject1 = AddGiftCardFragment.access$000((AddGiftCardFragment)localObject1);
    localObject1 = ((GiftProgram)localObject1).getPinRegex();
    Object localObject2 = this.this$0;
    localObject2 = AddGiftCardFragment.access$000((AddGiftCardFragment)localObject2);
    int i = ((GiftProgram)localObject2).getPinMaxLength();
    Object localObject4 = this.this$0;
    localObject4 = AddGiftCardFragment.access$000((AddGiftCardFragment)localObject4);
    int j = ((GiftProgram)localObject4).getPinMaxLength();
    char c = ' ';
    WalletNumberFormatUtil.getFormattedCardNumber(paramEditable, (String)localObject1, i, j, c);
    localObject1 = this.this$0;
    Object localObject3 = paramEditable.toString();
    AddGiftCardFragment.access$202((AddGiftCardFragment)localObject1, (String)localObject3);
    localObject1 = this.this$0;
    localObject3 = this.this$0;
    localObject3 = AddGiftCardFragment.access$100((AddGiftCardFragment)localObject3);
    Object localObject5 = this.this$0;
    localObject5 = AddGiftCardFragment.access$200((AddGiftCardFragment)localObject5);
    AddGiftCardFragment.access$300((AddGiftCardFragment)localObject1, (String)localObject3, (String)localObject5);
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddGiftCardFragment.2
 * JD-Core Version:    0.6.2
 */
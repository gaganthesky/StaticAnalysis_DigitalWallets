package com.paypal.android.p2pmobile.fragment.wallet;

import com.paypal.android.base.metarequest.LoginMetaRequest;
import com.paypal.android.foundation.core.message.FailureMessage;
import com.paypal.android.foundation.core.operations.OperationListener;

class AddMoneyFragment$1 extends OperationListener
{
  final AddMoneyFragment this$0;

  AddMoneyFragment$1(AddMoneyFragment paramAddMoneyFragment)
  {
  }

  public void onFailure(FailureMessage paramFailureMessage)
  {
  }

  public void onSuccess(Object paramObject)
  {
    AddMoneyFragment localAddMoneyFragment = this.this$0;
    LoginMetaRequest localLoginMetaRequest = null;
    AddMoneyFragment.access$000(localAddMoneyFragment, localLoginMetaRequest);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddMoneyFragment.1
 * JD-Core Version:    0.6.2
 */
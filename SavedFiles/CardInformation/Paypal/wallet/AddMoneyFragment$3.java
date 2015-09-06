package com.paypal.android.p2pmobile.fragment.wallet;

class AddMoneyFragment$3
  implements Runnable
{
  final AddMoneyFragment this$0;

  AddMoneyFragment$3(AddMoneyFragment paramAddMoneyFragment)
  {
  }

  public void run()
  {
    AddMoneyFragment localAddMoneyFragment = this.this$0;
    Object localObject = AddMoneyFragment.access$200(localAddMoneyFragment);
    localObject = (AddMoneyFragment.OnAddMoneyFragmentListener)localObject;
    if (localObject != null)
      ((AddMoneyFragment.OnAddMoneyFragmentListener)localObject).onAddMoneyFinish();
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddMoneyFragment.3
 * JD-Core Version:    0.6.2
 */
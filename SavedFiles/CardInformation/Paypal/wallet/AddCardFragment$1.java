package com.paypal.android.p2pmobile.fragment.wallet;

import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

class AddCardFragment$1
  implements View.OnFocusChangeListener
{
  final AddCardFragment this$0;

  AddCardFragment$1(AddCardFragment paramAddCardFragment)
  {
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    String str = Build.VERSION.RELEASE;
    Object localObject2 = "2.3.6";
    boolean bool = str.equals(localObject2);
    Object localObject1;
    if (bool)
    {
      localObject1 = this.this$0;
      AddCardFragment.access$1000((AddCardFragment)localObject1, paramView, paramBoolean);
    }
    Object localObject3;
    if (paramBoolean)
    {
      localObject1 = this.this$0;
      localObject1 = AddCardFragment.access$1200((AddCardFragment)localObject1);
      localObject2 = this.this$0;
      localObject2 = AddCardFragment.access$1100((AddCardFragment)localObject2);
      ((EditText)localObject1).removeTextChangedListener((TextWatcher)localObject2);
      localObject1 = this.this$0;
      localObject1 = AddCardFragment.access$1200((AddCardFragment)localObject1);
      localObject2 = this.this$0;
      localObject2 = AddCardFragment.access$1300((AddCardFragment)localObject2);
      ((EditText)localObject1).setText((CharSequence)localObject2);
      localObject1 = this.this$0;
      localObject1 = AddCardFragment.access$1200((AddCardFragment)localObject1);
      if (localObject1 != null)
      {
        localObject1 = this.this$0;
        localObject1 = AddCardFragment.access$1200((AddCardFragment)localObject1);
        localObject1 = ((EditText)localObject1).getText();
        if (localObject1 != null)
        {
          localObject1 = this.this$0;
          localObject1 = AddCardFragment.access$1200((AddCardFragment)localObject1);
          localObject2 = this.this$0;
          localObject2 = AddCardFragment.access$1200((AddCardFragment)localObject2);
          localObject2 = ((EditText)localObject2).getText();
          int i = ((Editable)localObject2).length();
          ((EditText)localObject1).setSelection(i);
        }
      }
      localObject1 = this.this$0;
      localObject1 = AddCardFragment.access$1200((AddCardFragment)localObject1);
      localObject3 = this.this$0;
      localObject3 = AddCardFragment.access$1100((AddCardFragment)localObject3);
      ((EditText)localObject1).addTextChangedListener((TextWatcher)localObject3);
    }
    while (true)
    {
      return;
      localObject1 = this.this$0;
      localObject1 = AddCardFragment.access$1200((AddCardFragment)localObject1);
      localObject3 = this.this$0;
      localObject3 = AddCardFragment.access$1100((AddCardFragment)localObject3);
      ((EditText)localObject1).removeTextChangedListener((TextWatcher)localObject3);
      localObject1 = this.this$0;
      localObject1 = AddCardFragment.access$1200((AddCardFragment)localObject1);
      localObject3 = this.this$0;
      localObject3 = AddCardFragment.access$1400((AddCardFragment)localObject3);
      ((EditText)localObject1).setText((CharSequence)localObject3);
      localObject1 = this.this$0;
      localObject1 = AddCardFragment.access$1200((AddCardFragment)localObject1);
      localObject3 = this.this$0;
      localObject3 = AddCardFragment.access$1100((AddCardFragment)localObject3);
      ((EditText)localObject1).addTextChangedListener((TextWatcher)localObject3);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddCardFragment.1
 * JD-Core Version:    0.6.2
 */
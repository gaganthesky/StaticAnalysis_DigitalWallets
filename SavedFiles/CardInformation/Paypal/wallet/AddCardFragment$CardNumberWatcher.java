package com.paypal.android.p2pmobile.fragment.wallet;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.paypal.android.p2pmobile.utils.ViewUtility;

class AddCardFragment$CardNumberWatcher
  implements TextWatcher
{
  final AddCardFragment this$0;

  private AddCardFragment$CardNumberWatcher(AddCardFragment paramAddCardFragment)
  {
  }

  AddCardFragment$CardNumberWatcher(AddCardFragment paramAddCardFragment, AddCardFragment.1 param1)
  {
    this(paramAddCardFragment);
  }

  public void afterTextChanged(Editable paramEditable)
  {
    AddCardFragment localAddCardFragment1 = this.this$0;
    String str = paramEditable.toString();
    AddCardFragment.access$100(localAddCardFragment1, str);
    localAddCardFragment1 = this.this$0;
    AddCardFragment.CardType localCardType = AddCardFragment.access$200(localAddCardFragment1);
    boolean bool2 = AddCardFragment.requiresIssueNumberAndStartDate(localCardType);
    if (!bool2)
    {
      bool2 = AddCardFragment.optionalIssueNumberAndStartDate(localCardType);
      if (!bool2)
        break label209;
    }
    label209: for (boolean bool1 = true; ; bool1 = false)
    {
      Object localObject = this.this$0;
      localObject = AddCardFragment.access$300((AddCardFragment)localObject);
      int i = 2131427631;
      ViewUtility.showOrHide((View)localObject, i, bool1);
      localObject = this.this$0;
      localObject = AddCardFragment.access$300((AddCardFragment)localObject);
      i = 2131427633;
      ViewUtility.showOrHide((View)localObject, i, bool1);
      localObject = this.this$0;
      localObject = AddCardFragment.access$300((AddCardFragment)localObject);
      i = 2131427632;
      boolean bool4 = AddCardFragment.requiresDateOfBirth(localCardType);
      ViewUtility.showOrHide((View)localObject, i, bool4);
      localObject = this.this$0;
      AddCardFragment.access$400((AddCardFragment)localObject, localCardType);
      localObject = this.this$0;
      AddCardFragment.access$500((AddCardFragment)localObject, localCardType);
      localObject = this.this$0;
      AddCardFragment.access$600((AddCardFragment)localObject, localCardType);
      localObject = this.this$0;
      localObject = AddCardFragment.access$800((AddCardFragment)localObject);
      AddCardFragment localAddCardFragment2 = this.this$0;
      boolean bool3 = AddCardFragment.access$700(localAddCardFragment2, localCardType);
      ((Button)localObject).setEnabled(bool3);
      return;
    }
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = paramCharSequence.toString();
    boolean bool = str.isEmpty();
    if (bool)
    {
      Object localObject2 = this.this$0;
      localObject2 = AddCardFragment.access$300((AddCardFragment)localObject2);
      int j = 2131427627;
      Object localObject1 = ((View)localObject2).findViewById(j);
      localObject1 = (ImageView)localObject1;
      if (localObject1 != null)
      {
        int i = 4;
        ((ImageView)localObject1).setVisibility(i);
      }
      Object localObject3 = this.this$0;
      localObject3 = AddCardFragment.access$900((AddCardFragment)localObject3);
      if (localObject3 != null)
      {
        localObject3 = this.this$0;
        localObject3 = AddCardFragment.access$900((AddCardFragment)localObject3);
        j = 0;
        ((ImageButton)localObject3).setVisibility(j);
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddCardFragment.CardNumberWatcher
 * JD-Core Version:    0.6.2
 */
package com.paypal.android.p2pmobile.fragment.wallet;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.paypal.android.p2pmobile.common.EditFitTextView;
import java.util.Calendar;

class AddCardFragment$7
  implements View.OnFocusChangeListener
{
  final AddCardFragment this$0;

  AddCardFragment$7(AddCardFragment paramAddCardFragment)
  {
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject1 = this.this$0;
      Object localObject2 = AddCardFragment.CurrentDateTextView.StartDate;
      AddCardFragment.access$1502((AddCardFragment)localObject1, (AddCardFragment.CurrentDateTextView)localObject2);
      localObject1 = this.this$0;
      localObject1 = AddCardFragment.access$2000((AddCardFragment)localObject1);
      if (localObject1 != null)
      {
        localObject1 = this.this$0;
        localObject1 = AddCardFragment.access$2000((AddCardFragment)localObject1);
        localObject1 = ((EditFitTextView)localObject1).getText();
        if (localObject1 != null)
        {
          localObject1 = this.this$0;
          localObject2 = this.this$0;
          localObject2 = AddCardFragment.access$2000((AddCardFragment)localObject2);
          localObject2 = ((EditFitTextView)localObject2).getText();
          localObject2 = localObject2.toString();
          Calendar localCalendar = AddCardFragment.access$1700((AddCardFragment)localObject1, (String)localObject2);
          localObject1 = this.this$0;
          localObject2 = this.this$0;
          localObject2 = AddCardFragment.access$2000((AddCardFragment)localObject2);
          ((AddCardFragment)localObject1).onDateSelected(localCalendar, (EditFitTextView)localObject2);
        }
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddCardFragment.7
 * JD-Core Version:    0.6.2
 */
package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Context;
import android.view.View;
import com.paypal.android.base.server.tracking.TrackPage.Point;
import com.paypal.android.p2pmobile.fragment.dialogs.MonthYearPopup;
import com.paypal.android.p2pmobile.fragment.dialogs.MonthYearPopup.OnYMSetListener;
import com.paypal.android.p2pmobile.widgets.NumberPicker;
import java.util.Calendar;

class AddCardFragment$DatePopup extends MonthYearPopup
{
  private boolean mAllowAllDates;
  final AddCardFragment this$0;

  public AddCardFragment$DatePopup(AddCardFragment paramAddCardFragment, Context paramContext, int paramInt1, MonthYearPopup.OnYMSetListener paramOnYMSetListener, int paramInt2, int paramInt3, boolean paramBoolean)
  {
  }

  public void onChanged(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
  {
    View localView3 = 2131230784;
    int i12 = 2131230778;
    int i15 = 2;
    int i14 = 0;
    int i13 = 1;
    Calendar localCalendar1 = this.startCal;
    int m;
    int n;
    int i;
    int j;
    int k;
    int i1;
    if (localCalendar1 != null)
    {
      localCalendar1 = this.endCal;
      if (localCalendar1 != null)
      {
        localCalendar1 = this.startCal;
        int i2 = localCalendar1.get(i15);
        m = i2 + 1;
        Calendar localCalendar2 = this.startCal;
        n = localCalendar2.get(i13);
        localCalendar2 = this.endCal;
        int i3 = localCalendar2.get(i15);
        i = i3 + 1;
        Object localObject = this.endCal;
        j = ((Calendar)localObject).get(i13);
        k = 1;
        i1 = 1;
        localObject = this.monthPicker;
        if (localObject != paramNumberPicker)
          break label256;
        localObject = this.yearPicker;
        int i4 = ((NumberPicker)localObject).getCurrent();
        if (i4 != n)
          break label214;
        if (paramInt2 < m)
          k = 0;
        NumberPicker localNumberPicker1 = this.yearPicker;
        int i5 = localNumberPicker1.getCurrent();
        if (i5 >= n)
        {
          NumberPicker localNumberPicker2 = this.yearPicker;
          int i6 = localNumberPicker2.getCurrent();
          if (i6 <= j);
        }
        else
        {
          i1 = 0;
        }
      }
    }
    while (true)
    {
      boolean bool = this.mAllowAllDates;
      if (!bool)
        break label401;
      return;
      label214: NumberPicker localNumberPicker3 = this.yearPicker;
      int i7 = localNumberPicker3.getCurrent();
      if ((i7 != j) || (paramInt2 <= i))
        break;
      NumberPicker localNumberPicker4 = this.monthPicker;
      localNumberPicker4.setCurrent(i);
      break;
      label256: localNumberPicker4 = this.yearPicker;
      if (localNumberPicker4 == paramNumberPicker)
      {
        NumberPicker localNumberPicker5;
        if (paramInt2 == j)
        {
          localNumberPicker4 = this.monthPicker;
          int i8 = localNumberPicker4.getCurrent();
          if (i8 > i)
          {
            localNumberPicker5 = this.monthPicker;
            localNumberPicker5.setCurrent(i);
          }
        }
        else if (paramInt2 == n)
        {
          localNumberPicker5 = this.yearPicker;
          localNumberPicker5.setDecrementEnabled(i14);
          localNumberPicker5 = this.monthPicker;
          int i9 = localNumberPicker5.getCurrent();
          if (i9 < m)
            k = 0;
        }
        else if (paramInt2 < n)
        {
          i1 = 0;
        }
        else if (paramInt2 > j)
        {
          i1 = 0;
        }
        else if (paramInt2 > n)
        {
          NumberPicker localNumberPicker6 = this.yearPicker;
          localNumberPicker6.setDecrementEnabled(i13);
        }
      }
    }
    label401: int i10 = 2131428377;
    View localView4 = findViewById(i10);
    label422: label446: View localView2;
    if (k != 0)
    {
      i10 = i12;
      localView4.setBackgroundResource(i10);
      i10 = 2131428379;
      View localView1 = findViewById(i10);
      if (i1 == 0)
        break label496;
      localView1.setBackgroundResource(i12);
      i11 = 2131428381;
      localView2 = findViewById(i11);
      if ((k == 0) || (i1 == 0))
        break label503;
    }
    label496: label503: for (int i11 = i13; ; i11 = i14)
    {
      localView2.setEnabled(i11);
      break;
      i11 = localView3;
      break label422;
      localView2 = localView3;
      break label446;
    }
  }

  protected void onStop()
  {
    super.onStop();
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddCardFragment.DatePopup
 * JD-Core Version:    0.6.2
 */
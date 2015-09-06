package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.TextView;

class EditArtifactFragment$1
  implements DialogInterface.OnDismissListener
{
  final EditArtifactFragment this$0;

  EditArtifactFragment$1(EditArtifactFragment paramEditArtifactFragment)
  {
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Object localObject = this.this$0;
    localObject = EditArtifactFragment.access$000((EditArtifactFragment)localObject);
    boolean bool = true;
    ((TextView)localObject).setEnabled(bool);
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.EditArtifactFragment.1
 * JD-Core Version:    0.6.2
 */
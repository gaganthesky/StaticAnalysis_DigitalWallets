package com.paypal.android.p2pmobile.fragment.wallet;

import com.paypal.android.foundation.account.model.LoyaltyCard;
import com.paypal.android.foundation.account.model.LoyaltyProgram;
import com.paypal.android.foundation.account.model.Merchant;
import java.util.Comparator;

final class WalletFragment$12
  implements Comparator<LoyaltyCard>
{
  public int compare(LoyaltyCard paramLoyaltyCard1, LoyaltyCard paramLoyaltyCard2)
  {
    Object localObject = paramLoyaltyCard1.getLoyaltyProgram();
    localObject = ((LoyaltyProgram)localObject).getMerchant();
    String str1 = ((Merchant)localObject).getName();
    localObject = paramLoyaltyCard2.getLoyaltyProgram();
    localObject = ((LoyaltyProgram)localObject).getMerchant();
    String str2 = ((Merchant)localObject).getName();
    int i = str1.compareToIgnoreCase(str2);
    return i;
  }

  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (LoyaltyCard)paramObject1;
    paramObject2 = (LoyaltyCard)paramObject2;
    int i = compare(paramObject1, paramObject2);
    return i;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.WalletFragment.12
 * JD-Core Version:    0.6.2
 */
package com.paypal.android.p2pmobile.fragment.wallet;

public enum AddCardFragment$CardNetwork
{
  private static final CardNetwork[] $VALUES = arrayOfCardNetwork;
  int mLogoId;

  static
  {
    int i4 = 3;
    int i3 = 2;
    int i2 = 1;
    int i1 = 0;
    int n = 2130837604;
    CardNetwork localCardNetwork1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardNetwork;
    Object localObject = "Visa";
    int k = 2130837932;
    localCardNetwork1.<init>((String)localObject, i1, k);
    Visa = localCardNetwork1;
    localCardNetwork1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardNetwork;
    localObject = "MasterCard";
    k = 2130837902;
    localCardNetwork1.<init>((String)localObject, i2, k);
    MasterCard = localCardNetwork1;
    localCardNetwork1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardNetwork;
    localObject = "Amex";
    k = 2130837848;
    localCardNetwork1.<init>((String)localObject, i3, k);
    Amex = localCardNetwork1;
    localCardNetwork1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardNetwork;
    localObject = "Discover";
    k = 2130837878;
    localCardNetwork1.<init>((String)localObject, i4, k);
    Discover = localCardNetwork1;
    localCardNetwork1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardNetwork;
    localObject = "DinersClub";
    k = 4;
    localCardNetwork1.<init>((String)localObject, k, n);
    DinersClub = localCardNetwork1;
    localCardNetwork1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardNetwork;
    localObject = "Maestro";
    k = 5;
    int m = 2130837700;
    localCardNetwork1.<init>((String)localObject, k, m);
    Maestro = localCardNetwork1;
    localCardNetwork1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardNetwork;
    localObject = "Cofinoga";
    k = 6;
    m = 2130838020;
    localCardNetwork1.<init>((String)localObject, k, m);
    Cofinoga = localCardNetwork1;
    localCardNetwork1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardNetwork;
    localObject = "CarteAurore";
    k = 7;
    m = 2130838018;
    localCardNetwork1.<init>((String)localObject, k, m);
    CarteAurore = localCardNetwork1;
    localCardNetwork1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardNetwork;
    localObject = "Etoiles";
    k = 8;
    localCardNetwork1.<init>((String)localObject, k, n);
    Etoiles = localCardNetwork1;
    localCardNetwork1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardNetwork;
    localObject = "CarteBleue";
    k = 9;
    localCardNetwork1.<init>((String)localObject, k, n);
    CarteBleue = localCardNetwork1;
    localCardNetwork1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardNetwork;
    localObject = "Unknown";
    k = 10;
    localCardNetwork1.<init>((String)localObject, k, n);
    Unknown = localCardNetwork1;
    int i = 11;
    CardNetwork[] arrayOfCardNetwork = new CardNetwork[i];
    localObject = Visa;
    arrayOfCardNetwork[i1] = localObject;
    localObject = MasterCard;
    arrayOfCardNetwork[i2] = localObject;
    localObject = Amex;
    arrayOfCardNetwork[i3] = localObject;
    localObject = Discover;
    arrayOfCardNetwork[i4] = localObject;
    int j = 4;
    CardNetwork localCardNetwork2 = DinersClub;
    arrayOfCardNetwork[j] = localCardNetwork2;
    j = 5;
    localCardNetwork2 = Maestro;
    arrayOfCardNetwork[j] = localCardNetwork2;
    j = 6;
    localCardNetwork2 = Cofinoga;
    arrayOfCardNetwork[j] = localCardNetwork2;
    j = 7;
    localCardNetwork2 = CarteAurore;
    arrayOfCardNetwork[j] = localCardNetwork2;
    j = 8;
    localCardNetwork2 = Etoiles;
    arrayOfCardNetwork[j] = localCardNetwork2;
    j = 9;
    localCardNetwork2 = CarteBleue;
    arrayOfCardNetwork[j] = localCardNetwork2;
    j = 10;
    localCardNetwork2 = Unknown;
    arrayOfCardNetwork[j] = localCardNetwork2;
  }

  private AddCardFragment$CardNetwork(int paramInt)
  {
    this.mLogoId = paramInt;
  }

  public int getCscId()
  {
    CardNetwork localCardNetwork = Amex;
    if (this == localCardNetwork);
    for (int i = 2130838057; ; i = 2130838056)
      return i;
  }

  public int getLogoId()
  {
    int i = this.mLogoId;
    return i;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddCardFragment.CardNetwork
 * JD-Core Version:    0.6.2
 */
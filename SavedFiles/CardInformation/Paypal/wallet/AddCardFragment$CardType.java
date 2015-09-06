package com.paypal.android.p2pmobile.fragment.wallet;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public enum AddCardFragment$CardType
{
  private static final CardType[] $VALUES = arrayOfCardType;
  boolean mActive;
  String mCardAPIName;
  int mCvvLength;
  int mLocalizedId;
  boolean mLuhnValidation;
  AddCardFragment.CardNetwork mNetwork;
  int mNumLength;
  String mRegex;
  int mSpaceLength;

  static
  {
    CardType localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    String str1 = "Visa";
    int k = 0;
    AddCardFragment.CardNetwork localCardNetwork = AddCardFragment.CardNetwork.Visa;
    int m = 16;
    int n = 3;
    int i1 = 3;
    boolean bool1 = true;
    boolean bool2 = true;
    int i2 = 2131427345;
    String str2 = "^4";
    String str3 = "visa";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    Visa = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "VisaElectron";
    k = 1;
    localCardNetwork = AddCardFragment.CardNetwork.Visa;
    m = 16;
    n = 3;
    i1 = 3;
    bool1 = true;
    bool2 = true;
    i2 = 2131427345;
    str2 = "^417500|^4917|^4913|^4508|^4844";
    str3 = "electron";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    VisaElectron = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "MasterCard";
    k = 2;
    localCardNetwork = AddCardFragment.CardNetwork.MasterCard;
    m = 16;
    n = 3;
    i1 = 3;
    bool1 = true;
    bool2 = true;
    i2 = 2131427346;
    str2 = "^5[1-5]";
    str3 = "master_card";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    MasterCard = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "Amex";
    k = 3;
    localCardNetwork = AddCardFragment.CardNetwork.Amex;
    m = 15;
    n = 4;
    i1 = 2;
    bool1 = true;
    bool2 = true;
    i2 = 2131427347;
    str2 = "^34|^37";
    str3 = "amex";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    Amex = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "Discover";
    k = 4;
    localCardNetwork = AddCardFragment.CardNetwork.Discover;
    m = 16;
    n = 3;
    i1 = 3;
    bool1 = true;
    bool2 = true;
    i2 = 2131427348;
    str2 = "^6011|^6[4-5][4-9]";
    str3 = "discover";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    Discover = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "JCB";
    k = 5;
    localCardNetwork = AddCardFragment.CardNetwork.DinersClub;
    m = 16;
    n = 3;
    i1 = 2;
    bool1 = true;
    bool2 = true;
    i2 = 2131427360;
    str2 = "^35[2-8][8-9]";
    str3 = "jcb";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    JCB = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "ChinaUnionPay";
    k = 6;
    localCardNetwork = AddCardFragment.CardNetwork.DinersClub;
    m = 19;
    n = 3;
    i1 = 2;
    bool1 = true;
    bool2 = false;
    i2 = 2131427361;
    str2 = "^622[1-9]2[5-6]|^62[4-6]|^628[2-8]";
    str3 = "china_union_pay";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    ChinaUnionPay = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "Maestro";
    k = 7;
    localCardNetwork = AddCardFragment.CardNetwork.Maestro;
    m = 19;
    n = 3;
    i1 = 2;
    bool1 = true;
    bool2 = true;
    i2 = 2131427362;
    str2 = "^5018|^5020|^5038|^5[6-8]|^6304|^6759|^6761|^6762|^6763";
    str3 = "maestro";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    Maestro = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "Switch";
    k = 8;
    localCardNetwork = AddCardFragment.CardNetwork.Maestro;
    m = 19;
    n = 3;
    i1 = 2;
    bool1 = true;
    bool2 = true;
    i2 = 2131427349;
    str2 = "^4903|^4905|^4911|^4936|^564182|^633110|^6333|^6759";
    str3 = "switch";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    Switch = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "Solo";
    k = 9;
    localCardNetwork = AddCardFragment.CardNetwork.Maestro;
    m = 16;
    n = 3;
    i1 = 2;
    bool1 = false;
    bool2 = true;
    i2 = 2131427350;
    str2 = "^6334|^6767";
    str3 = "solo";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    Solo = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "DinersClubCarteBlanche";
    k = 10;
    localCardNetwork = AddCardFragment.CardNetwork.DinersClub;
    m = 14;
    n = 3;
    i1 = 2;
    bool1 = true;
    bool2 = true;
    i2 = 2131427363;
    str2 = "^30[0-5]";
    str3 = "DinersClubCarteBlanche";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    DinersClubCarteBlanche = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "DinersClubEnRoute";
    k = 11;
    localCardNetwork = AddCardFragment.CardNetwork.DinersClub;
    m = 15;
    n = 3;
    i1 = 2;
    bool1 = false;
    bool2 = false;
    i2 = 2131427364;
    str2 = "^2014|^2149";
    str3 = "DinersClubEnRoute";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    DinersClubEnRoute = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "DinersClubIntl";
    k = 12;
    localCardNetwork = AddCardFragment.CardNetwork.DinersClub;
    m = 14;
    n = 3;
    i1 = 2;
    bool1 = true;
    bool2 = true;
    i2 = 2131427365;
    str2 = "^30[0-5]|^3095|^36|^3[8-9]";
    str3 = "visa";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    DinersClubIntl = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "DinersClubUsaCdn";
    k = 13;
    localCardNetwork = AddCardFragment.CardNetwork.MasterCard;
    m = 16;
    n = 3;
    i1 = 2;
    bool1 = true;
    bool2 = true;
    i2 = 2131427366;
    str2 = "^54|^55";
    str3 = "DinersClubUsaCdn";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    DinersClubUsaCdn = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "DinersClubDiscoverCobranded";
    k = 14;
    localCardNetwork = AddCardFragment.CardNetwork.DinersClub;
    m = 14;
    n = 3;
    i1 = 2;
    bool1 = true;
    bool2 = true;
    i2 = 2131427367;
    str2 = "^36";
    str3 = "discover";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    DinersClubDiscoverCobranded = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "Cofinoga";
    k = 15;
    localCardNetwork = AddCardFragment.CardNetwork.Cofinoga;
    m = 17;
    n = 3;
    i1 = 2;
    bool1 = true;
    bool2 = true;
    i2 = 2131427355;
    str2 = "^30";
    str3 = "confinoga";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    Cofinoga = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "Etoiles";
    k = 16;
    localCardNetwork = AddCardFragment.CardNetwork.Etoiles;
    m = 9;
    n = 3;
    i1 = 2;
    bool1 = true;
    bool2 = true;
    i2 = 2131427356;
    str2 = "";
    str3 = "cofidis";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    Etoiles = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "CarteAurore";
    k = 17;
    localCardNetwork = AddCardFragment.CardNetwork.CarteAurore;
    m = 19;
    n = 3;
    i1 = 2;
    bool1 = true;
    bool2 = true;
    i2 = 2131427353;
    str2 = "^50";
    str3 = "cetelem";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    CarteAurore = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "CarteBleue";
    k = 18;
    localCardNetwork = AddCardFragment.CardNetwork.CarteBleue;
    m = 19;
    n = 3;
    i1 = 2;
    bool1 = true;
    bool2 = true;
    i2 = 2131427354;
    str2 = "^6751";
    str3 = "cb_nationale";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    CarteBleue = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "CartaAura";
    k = 19;
    localCardNetwork = AddCardFragment.CardNetwork.CarteAurore;
    m = 19;
    n = 3;
    i1 = 2;
    bool1 = true;
    bool2 = true;
    i2 = 2131427357;
    str2 = "";
    str3 = "cetelem:IT";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    CartaAura = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "TarjetaAurora";
    k = 20;
    localCardNetwork = AddCardFragment.CardNetwork.CarteAurore;
    m = 0;
    n = 3;
    i1 = 2;
    bool1 = true;
    bool2 = true;
    i2 = 2131427359;
    str2 = "";
    str3 = "cetelem:ES";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    TarjetaAurora = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "BankCard";
    k = 21;
    localCardNetwork = AddCardFragment.CardNetwork.Unknown;
    m = 16;
    n = 3;
    i1 = 2;
    bool1 = false;
    bool2 = true;
    i2 = 2131427368;
    str2 = "^5610|^56022[1-5]";
    str3 = "BankCard";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    BankCard = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "InstaPayment";
    k = 22;
    localCardNetwork = AddCardFragment.CardNetwork.Unknown;
    m = 16;
    n = 3;
    i1 = 2;
    bool1 = false;
    bool2 = true;
    i2 = 2131427369;
    str2 = "^637|^639";
    str3 = "InstaPayment";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    InstaPayment = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "Laser";
    k = 23;
    localCardNetwork = AddCardFragment.CardNetwork.Unknown;
    m = 19;
    n = 3;
    i1 = 2;
    bool1 = true;
    bool2 = true;
    i2 = 2131427370;
    str2 = "^6304|^6706|^6771|^6709";
    str3 = "Laser";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    Laser = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "EuroCard";
    k = 24;
    localCardNetwork = AddCardFragment.CardNetwork.Unknown;
    m = 19;
    n = 3;
    i1 = 2;
    bool1 = false;
    bool2 = true;
    i2 = 0;
    str2 = "";
    str3 = "EuroCard";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    EuroCard = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "PostePay";
    k = 25;
    localCardNetwork = AddCardFragment.CardNetwork.Unknown;
    m = 19;
    n = 3;
    i1 = 2;
    bool1 = false;
    bool2 = true;
    i2 = 0;
    str2 = "";
    str3 = "PostePay";
    localCardType1.<init>(str1, k, localCardNetwork, m, n, i1, bool1, bool2, i2, str2, str3);
    PostePay = localCardType1;
    localCardType1 = new com/paypal/android/p2pmobile/fragment/wallet/AddCardFragment$CardType;
    str1 = "Unknown";
    k = 26;
    localCardType1.<init>(str1, k);
    Unknown = localCardType1;
    int i = 27;
    CardType[] arrayOfCardType = new CardType[i];
    int j = 0;
    CardType localCardType2 = Visa;
    arrayOfCardType[j] = localCardType2;
    j = 1;
    localCardType2 = VisaElectron;
    arrayOfCardType[j] = localCardType2;
    j = 2;
    localCardType2 = MasterCard;
    arrayOfCardType[j] = localCardType2;
    j = 3;
    localCardType2 = Amex;
    arrayOfCardType[j] = localCardType2;
    j = 4;
    localCardType2 = Discover;
    arrayOfCardType[j] = localCardType2;
    j = 5;
    localCardType2 = JCB;
    arrayOfCardType[j] = localCardType2;
    j = 6;
    localCardType2 = ChinaUnionPay;
    arrayOfCardType[j] = localCardType2;
    j = 7;
    localCardType2 = Maestro;
    arrayOfCardType[j] = localCardType2;
    j = 8;
    localCardType2 = Switch;
    arrayOfCardType[j] = localCardType2;
    j = 9;
    localCardType2 = Solo;
    arrayOfCardType[j] = localCardType2;
    j = 10;
    localCardType2 = DinersClubCarteBlanche;
    arrayOfCardType[j] = localCardType2;
    j = 11;
    localCardType2 = DinersClubEnRoute;
    arrayOfCardType[j] = localCardType2;
    j = 12;
    localCardType2 = DinersClubIntl;
    arrayOfCardType[j] = localCardType2;
    j = 13;
    localCardType2 = DinersClubUsaCdn;
    arrayOfCardType[j] = localCardType2;
    j = 14;
    localCardType2 = DinersClubDiscoverCobranded;
    arrayOfCardType[j] = localCardType2;
    j = 15;
    localCardType2 = Cofinoga;
    arrayOfCardType[j] = localCardType2;
    j = 16;
    localCardType2 = Etoiles;
    arrayOfCardType[j] = localCardType2;
    j = 17;
    localCardType2 = CarteAurore;
    arrayOfCardType[j] = localCardType2;
    j = 18;
    localCardType2 = CarteBleue;
    arrayOfCardType[j] = localCardType2;
    j = 19;
    localCardType2 = CartaAura;
    arrayOfCardType[j] = localCardType2;
    j = 20;
    localCardType2 = TarjetaAurora;
    arrayOfCardType[j] = localCardType2;
    j = 21;
    localCardType2 = BankCard;
    arrayOfCardType[j] = localCardType2;
    j = 22;
    localCardType2 = InstaPayment;
    arrayOfCardType[j] = localCardType2;
    j = 23;
    localCardType2 = Laser;
    arrayOfCardType[j] = localCardType2;
    j = 24;
    localCardType2 = EuroCard;
    arrayOfCardType[j] = localCardType2;
    j = 25;
    localCardType2 = PostePay;
    arrayOfCardType[j] = localCardType2;
    j = 26;
    localCardType2 = Unknown;
    arrayOfCardType[j] = localCardType2;
  }

  private AddCardFragment$CardType()
  {
  }

  private AddCardFragment$CardType(AddCardFragment.CardNetwork paramCardNetwork, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, String paramString1, String paramString2)
  {
    this.mNetwork = paramCardNetwork;
    this.mNumLength = paramInt1;
    this.mCvvLength = paramInt2;
    this.mSpaceLength = paramInt3;
    this.mActive = paramBoolean1;
    this.mLuhnValidation = paramBoolean2;
    this.mLocalizedId = paramInt4;
    this.mRegex = paramString1;
    this.mCardAPIName = paramString2;
  }

  public static CardType fromCardNameFromAPIName(String paramString)
  {
    int i;
    CardType localCardType;
    if (paramString != null)
    {
      CardType[] arrayOfCardType = values();
      int j = arrayOfCardType.length;
      i = 0;
      if (i < j)
      {
        localCardType = arrayOfCardType[i];
        String str = localCardType.getCardAPIName();
        boolean bool = paramString.equalsIgnoreCase(str);
        if (!bool);
      }
    }
    while (true)
    {
      return localCardType;
      i += 1;
      break;
      localCardType = Unknown;
    }
  }

  public static CardType fromString(String paramString)
  {
    int i;
    CardType localCardType;
    if (paramString != null)
    {
      CardType[] arrayOfCardType = values();
      int j = arrayOfCardType.length;
      i = 0;
      if (i < j)
      {
        localCardType = arrayOfCardType[i];
        String str = localCardType.name();
        boolean bool = paramString.equalsIgnoreCase(str);
        if (!bool);
      }
    }
    while (true)
    {
      return localCardType;
      i += 1;
      break;
      localCardType = Unknown;
    }
  }

  public String getCannonicalName()
  {
    String str = name();
    return str;
  }

  public static CardType getCard(int paramInt)
  {
    CardType[] arrayOfCardType = values();
    int j = arrayOfCardType.length;
    int i = 0;
    CardType localCardType;
    if (i < j)
    {
      localCardType = arrayOfCardType[i];
      int k = localCardType.mLocalizedId;
      if (k != paramInt);
    }
    while (true)
    {
      return localCardType;
      i += 1;
      break;
      localCardType = Unknown;
    }
  }

  public String getCardAPIName()
  {
    String str = this.mCardAPIName;
    return str;
  }

  public Drawable getCscLogo(Context paramContext)
  {
    Object localObject = Unknown;
    if (this == localObject);
    int i;
    for (localObject = null; ; localObject = ((Resources)localObject).getDrawable(i))
    {
      return localObject;
      localObject = paramContext.getResources();
      AddCardFragment.CardNetwork localCardNetwork = getNetwork();
      i = localCardNetwork.getCscId();
    }
  }

  public int getCvvLength()
  {
    int i = this.mCvvLength;
    return i;
  }

  public String getLocalizedName(Context paramContext)
  {
    String str = "string";
    int i = getResourceId(paramContext, str);
    if (i != 0);
    for (str = paramContext.getString(i); ; str = "")
      return str;
  }

  public Drawable getLogo(Context paramContext)
  {
    Object localObject = "drawable";
    int i = getResourceId(paramContext, (String)localObject);
    if (i != 0)
      localObject = paramContext.getResources();
    for (localObject = ((Resources)localObject).getDrawable(i); ; localObject = null)
      return localObject;
  }

  public AddCardFragment.CardNetwork getNetwork()
  {
    AddCardFragment.CardNetwork localCardNetwork = this.mNetwork;
    return localCardNetwork;
  }

  public int getNumLength()
  {
    int i = this.mNumLength;
    return i;
  }

  public String getRegex()
  {
    String str = this.mRegex;
    return str;
  }

  private int getResourceId(Context paramContext, String paramString)
  {
    try
    {
      Resources localResources = paramContext.getResources();
      int j = this.mLocalizedId;
      String str2 = localResources.getResourcePackageName(j);
      j = this.mLocalizedId;
      String str1 = localResources.getResourceEntryName(j);
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = ((StringBuilder)localObject).append(str2);
      String str3 = ":";
      localObject = ((StringBuilder)localObject).append(str3);
      localObject = ((StringBuilder)localObject).append(paramString);
      str3 = "/";
      localObject = ((StringBuilder)localObject).append(str3);
      localObject = ((StringBuilder)localObject).append(str1);
      localObject = ((StringBuilder)localObject).toString();
      str3 = "";
      String str4 = "";
      i = localResources.getIdentifier((String)localObject, str3, str4);
      return i;
    }
    catch (Exception localException)
    {
      while (true)
        int i = 0;
    }
  }

  public static boolean hasCardMatch(CardType paramCardType, CardType[] paramArrayOfCardType)
  {
    CardType[] arrayOfCardType;
    int i;
    if (paramArrayOfCardType == null)
    {
      arrayOfCardType = values();
      int j = arrayOfCardType.length;
      i = 0;
      label16: if (i >= j)
        break label53;
      CardType localCardType = arrayOfCardType[i];
      if (localCardType != paramCardType)
        break label44;
    }
    label44: label53: for (boolean bool = true; ; bool = false)
    {
      return bool;
      arrayOfCardType = paramArrayOfCardType;
      break;
      i += 1;
      break label16;
    }
  }

  public void setCardAPIName(String paramString)
  {
    this.mCardAPIName = paramString;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.paypal.android.p2pmobile.fragment.wallet.AddCardFragment.CardType
 * JD-Core Version:    0.6.2
 */
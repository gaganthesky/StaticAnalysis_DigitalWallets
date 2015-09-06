package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;

public final class LatLng
  implements SafeParcelable
{
  public static final i CREATOR = locali;
  public final double latitude;
  public final double longitude;
  private final int mVersionCode;

  static
  {
    i locali = new com/google/android/gms/maps/model/i;
    locali.<init>();
  }

  public LatLng(double paramDouble1, double paramDouble2)
  {
  }

  LatLng(int paramInt, double paramDouble1, double paramDouble2)
  {
    this.mVersionCode = paramInt;
    double d1 = -180.0D;
    boolean bool = d1 < paramDouble2;
    if (!bool)
    {
      bool = paramDouble2 < d3;
      if (!bool);
    }
    double d2;
    for (this.longitude = paramDouble2; ; this.longitude = d2)
    {
      d2 = -90.0D;
      d3 = 90.0D;
      d3 = Math.min(d3, paramDouble1);
      d2 = Math.max(d2, d3);
      this.latitude = d2;
      return;
      d2 = paramDouble2 - d3;
      d2 %= d4;
      d2 += d4;
      d2 %= d4;
      d2 -= d3;
    }
  }

  public final int describeContents()
  {
    int i = 0;
    return i;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this == paramObject);
    while (true)
    {
      return bool1;
      boolean bool3 = paramObject instanceof LatLng;
      if (!bool3)
      {
        bool1 = bool2;
      }
      else
      {
        paramObject = (LatLng)paramObject;
        double d1 = this.latitude;
        long l1 = Double.doubleToLongBits(d1);
        double d3 = paramObject.latitude;
        long l3 = Double.doubleToLongBits(d3);
        boolean bool4 = l1 < l3;
        if (!bool4)
        {
          double d2 = this.longitude;
          long l2 = Double.doubleToLongBits(d2);
          double d4 = paramObject.longitude;
          long l4 = Double.doubleToLongBits(d4);
          boolean bool5 = l2 < l4;
          if (!bool5);
        }
        else
        {
          bool1 = bool2;
        }
      }
    }
  }

  final int getVersionCode()
  {
    int i = this.mVersionCode;
    return i;
  }

  public final int hashCode()
  {
    int k = 32;
    double d1 = this.latitude;
    long l1 = Double.doubleToLongBits(d1);
    long l2 = l1 >>> k;
    l1 ^= l2;
    int i = (int)l1;
    i += 31;
    double d2 = this.longitude;
    long l3 = Double.doubleToLongBits(d2);
    i *= 31;
    long l4 = l3 >>> k;
    l3 ^= l4;
    int j = (int)l3;
    i += j;
    return i;
  }

  public final String toString()
  {
    Object localObject = new java/lang/StringBuilder;
    String str = "lat/lng: (";
    ((StringBuilder)localObject).<init>(str);
    double d = this.latitude;
    localObject = ((StringBuilder)localObject).append(d);
    str = ",";
    localObject = ((StringBuilder)localObject).append(str);
    d = this.longitude;
    localObject = ((StringBuilder)localObject).append(d);
    str = ")";
    localObject = ((StringBuilder)localObject).append(str);
    localObject = ((StringBuilder)localObject).toString();
    return localObject;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    boolean bool = aa.qp();
    if (bool)
      j.a(this, paramParcel, paramInt);
    while (true)
    {
      return;
      i.a(this, paramParcel, paramInt);
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     com.google.android.gms.maps.model.LatLng
 * JD-Core Version:    0.6.2
 */
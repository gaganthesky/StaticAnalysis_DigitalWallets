package com.AdX.tag;

import android.os.Build;

public class DeviceSerial
{
  private DeviceSerial()
  {
  }

  DeviceSerial(DeviceSerial paramDeviceSerial)
  {
    this();
  }

  public static String getDeviceSerial()
  {
    String str = Build.SERIAL;
    return str;
  }

  public static DeviceSerial getInstance()
  {
    DeviceSerial localDeviceSerial = DeviceSerial.DeviceSerialHolder.access$0();
    return localDeviceSerial;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Paypal/retargeted/com.paypal.android.p2pmobile_5.11.3_free-www.apkhere.com/
 * Qualified Name:     com.AdX.tag.DeviceSerial
 * JD-Core Version:    0.6.2
 */
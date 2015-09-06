package com.braintreepayments.api.internal;

public class HttpResponse
{
  private String mData;
  private String mResponseBody;
  private int mResponseCode;
  private String mUrl;

  public HttpResponse(int paramInt, String paramString)
  {
    this.mResponseCode = paramInt;
    this.mResponseBody = paramString;
  }

  public String getResponseBody()
  {
    String str = this.mResponseBody;
    return str;
  }

  public int getResponseCode()
  {
    int i = this.mResponseCode;
    return i;
  }

  protected void setData(String paramString)
  {
    this.mData = paramString;
  }

  protected void setUrl(String paramString)
  {
    this.mUrl = paramString;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.braintreepayments.api.internal.HttpResponse
 * JD-Core Version:    0.6.2
 */
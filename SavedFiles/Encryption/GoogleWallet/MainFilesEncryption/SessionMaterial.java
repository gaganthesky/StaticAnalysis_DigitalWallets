package org.keyczar;

import com.google.gson.Gson;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.util.Util;

public final class SessionMaterial
{
  private AesKey key;
  private String nonce;

  public SessionMaterial()
  {
    String str = null;
    this.key = str;
    str = "";
    this.nonce = str;
  }

  public SessionMaterial(AesKey paramAesKey, String paramString)
  {
    String str = null;
    this.key = str;
    str = "";
    this.nonce = str;
    this.key = paramAesKey;
    this.nonce = paramString;
  }

  public final AesKey getKey()
    throws KeyczarException
  {
    Object localObject = this.key;
    if (localObject == null)
    {
      localObject = new org/keyczar/exceptions/KeyczarException;
      String str = "Key has not been initialized";
      ((KeyczarException)localObject).<init>(str);
      throw ((Throwable)localObject);
    }
    localObject = this.key;
    return localObject;
  }

  public final String getNonce()
  {
    String str = this.nonce;
    return str;
  }

  public final String toString()
  {
    Object localObject = Util.gson();
    localObject = ((Gson)localObject).toJson(this);
    return localObject;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.SessionMaterial
 * JD-Core Version:    0.6.2
 */
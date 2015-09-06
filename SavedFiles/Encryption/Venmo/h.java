package com.paypal.android.sdk;

import android.util.Base64;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public final class h
{
  private static String a = (String)localObject;
  private String b;

  static
  {
    Object localObject = h.class;
    localObject = ((Class)localObject).getSimpleName();
  }

  public h(String paramString)
  {
    this.b = paramString;
  }

  private static String a(Exception paramException)
  {
    String str1 = a;
    String str2 = paramException.getMessage();
    Log.e(str1, str2);
    str1 = null;
    return str1;
  }

  public final String a(String paramString)
  {
    Object localObject1;
    if (paramString == null)
      localObject1 = null;
    while (true)
    {
      return localObject1;
      try
      {
        localObject1 = new javax/crypto/spec/DESKeySpec;
        Object localObject2 = this.b;
        Object localObject3 = "UTF8";
        localObject2 = ((String)localObject2).getBytes((String)localObject3);
        ((DESKeySpec)localObject1).<init>((byte[])localObject2);
        localObject2 = "DES";
        localObject2 = SecretKeyFactory.getInstance((String)localObject2);
        localObject1 = ((SecretKeyFactory)localObject2).generateSecret((KeySpec)localObject1);
        localObject2 = "UTF8";
        localObject2 = paramString.getBytes((String)localObject2);
        localObject3 = "DES";
        localObject3 = Cipher.getInstance((String)localObject3);
        int j = 1;
        ((Cipher)localObject3).init(j, (Key)localObject1);
        localObject1 = ((Cipher)localObject3).doFinal((byte[])localObject2);
        int i = 0;
        localObject1 = Base64.encodeToString((byte[])localObject1, i);
      }
      catch (InvalidKeyException localInvalidKeyException)
      {
        String str1 = a(localInvalidKeyException);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        String str2 = a(localUnsupportedEncodingException);
      }
      catch (InvalidKeySpecException localInvalidKeySpecException)
      {
        String str3 = a(localInvalidKeySpecException);
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        String str4 = a(localNoSuchAlgorithmException);
      }
      catch (BadPaddingException localBadPaddingException)
      {
        String str5 = a(localBadPaddingException);
      }
      catch (NoSuchPaddingException localNoSuchPaddingException)
      {
        String str6 = a(localNoSuchPaddingException);
      }
      catch (IllegalBlockSizeException localIllegalBlockSizeException)
      {
        String str7 = a(localIllegalBlockSizeException);
      }
    }
  }

  public final String b(String paramString)
  {
    Object localObject1;
    if (paramString == null)
      localObject1 = null;
    while (true)
    {
      return localObject1;
      try
      {
        localObject1 = new javax/crypto/spec/DESKeySpec;
        Object localObject2 = this.b;
        Object localObject3 = "UTF8";
        localObject2 = ((String)localObject2).getBytes((String)localObject3);
        ((DESKeySpec)localObject1).<init>((byte[])localObject2);
        localObject2 = "DES";
        localObject2 = SecretKeyFactory.getInstance((String)localObject2);
        localObject1 = ((SecretKeyFactory)localObject2).generateSecret((KeySpec)localObject1);
        int i = 0;
        byte[] arrayOfByte = Base64.decode(paramString, i);
        localObject3 = "DES";
        localObject3 = Cipher.getInstance((String)localObject3);
        int j = 2;
        ((Cipher)localObject3).init(j, (Key)localObject1);
        arrayOfByte = ((Cipher)localObject3).doFinal(arrayOfByte);
        localObject1 = new java/lang/String;
        ((String)localObject1).<init>(arrayOfByte);
      }
      catch (InvalidKeyException localInvalidKeyException)
      {
        String str1 = a(localInvalidKeyException);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        String str2 = a(localUnsupportedEncodingException);
      }
      catch (InvalidKeySpecException localInvalidKeySpecException)
      {
        String str3 = a(localInvalidKeySpecException);
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        String str4 = a(localNoSuchAlgorithmException);
      }
      catch (BadPaddingException localBadPaddingException)
      {
        String str5 = a(localBadPaddingException);
      }
      catch (NoSuchPaddingException localNoSuchPaddingException)
      {
        String str6 = a(localNoSuchPaddingException);
      }
      catch (IllegalBlockSizeException localIllegalBlockSizeException)
      {
        String str7 = a(localIllegalBlockSizeException);
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.paypal.android.sdk.h
 * JD-Core Version:    0.6.2
 */
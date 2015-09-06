package com.umeng.common.util;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class b
{
  private static byte[] a;
  private static byte[] b = (byte[])localObject;

  static
  {
    Object localObject = "uLi4/f4+Pb39.T19";
    localObject = ((String)localObject).getBytes();
    a = (byte[])localObject;
    localObject = "nmeug.f9/Om+L823";
    localObject = ((String)localObject).getBytes();
  }

  public static String a(String paramString1, String paramString2)
    throws Exception
  {
    Object localObject1 = "AES/CBC/PKCS5Padding";
    localObject1 = Cipher.getInstance((String)localObject1);
    Object localObject2 = new javax/crypto/spec/SecretKeySpec;
    Object localObject3 = a;
    Object localObject4 = "AES";
    ((SecretKeySpec)localObject2).<init>((byte[])localObject3, (String)localObject4);
    localObject3 = new javax/crypto/spec/IvParameterSpec;
    localObject4 = b;
    ((IvParameterSpec)localObject3).<init>((byte[])localObject4);
    int i = 1;
    ((Cipher)localObject1).init(i, (Key)localObject2, (AlgorithmParameterSpec)localObject3);
    localObject2 = paramString1.getBytes(paramString2);
    localObject1 = ((Cipher)localObject1).doFinal((byte[])localObject2);
    localObject1 = c.d((byte[])localObject1);
    return localObject1;
  }

  public static String b(String paramString1, String paramString2)
    throws Exception
  {
    Object localObject1 = "AES/CBC/PKCS5Padding";
    localObject1 = Cipher.getInstance((String)localObject1);
    Object localObject2 = new javax/crypto/spec/SecretKeySpec;
    Object localObject3 = a;
    Object localObject4 = "AES";
    ((SecretKeySpec)localObject2).<init>((byte[])localObject3, (String)localObject4);
    localObject3 = new javax/crypto/spec/IvParameterSpec;
    localObject4 = b;
    ((IvParameterSpec)localObject3).<init>((byte[])localObject4);
    int i = 2;
    ((Cipher)localObject1).init(i, (Key)localObject2, (AlgorithmParameterSpec)localObject3);
    localObject2 = c.b(paramString1);
    localObject1 = ((Cipher)localObject1).doFinal((byte[])localObject2);
    localObject2 = new java/lang/String;
    ((String)localObject2).<init>((byte[])localObject1, paramString2);
    return localObject2;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Lemon/retargeted/com.lemonhq/
 * Qualified Name:     com.umeng.common.util.b
 * JD-Core Version:    0.6.2
 */
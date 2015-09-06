package org.keyczar.i18n;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class Messages
{
  private static ResourceBundle RESOURCE_BUNDLE = (ResourceBundle)localObject;

  static
  {
    Object localObject = "org.keyczar.i18n.messages";
    localObject = ResourceBundle.getBundle((String)localObject);
  }

  public static String getString(String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject1 = RESOURCE_BUNDLE;
      localObject1 = ((ResourceBundle)localObject1).getString(paramString);
      localObject1 = MessageFormat.format((String)localObject1, paramArrayOfObject);
      return localObject1;
    }
    catch (MissingResourceException localMissingResourceException)
    {
      while (true)
      {
        Object localObject2 = new java/lang/StringBuilder;
        String str1 = String.valueOf(paramString);
        int i = str1.length();
        i += 2;
        ((StringBuilder)localObject2).<init>(i);
        String str2 = "!";
        localObject2 = ((StringBuilder)localObject2).append(str2);
        localObject2 = ((StringBuilder)localObject2).append(paramString);
        str2 = "!";
        localObject2 = ((StringBuilder)localObject2).append(str2);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.i18n.Messages
 * JD-Core Version:    0.6.2
 */
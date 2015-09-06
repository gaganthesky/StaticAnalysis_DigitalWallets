package org.keyczar.interfaces;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.keyczar.DefaultKeyType;

public final class KeyType$KeyTypeDeserializer
  implements JsonDeserializer<KeyType>
{
  private static Map typeMap;

  static
  {
    HashMap localHashMap = new java/util/HashMap;
    localHashMap.<init>();
    typeMap = localHashMap;
    DefaultKeyType[] arrayOfDefaultKeyType = DefaultKeyType.values();
    int j = arrayOfDefaultKeyType.length;
    int i = 0;
    while (i < j)
    {
      DefaultKeyType localDefaultKeyType = arrayOfDefaultKeyType[i];
      registerType(localDefaultKeyType);
      i += 1;
    }
  }

  public final Object deserialize(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
    throws JsonParseException
  {
    KeyType localKeyType = deserialize(paramJsonElement, paramType, paramJsonDeserializationContext);
    return localKeyType;
  }

  private static KeyType deserialize(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
    throws JsonParseException
  {
    Object localObject1 = paramJsonElement.getAsJsonPrimitive();
    String str1 = ((JsonPrimitive)localObject1).getAsString();
    localObject1 = typeMap;
    boolean bool = ((Map)localObject1).containsKey(str1);
    if (!bool)
    {
      localObject2 = new java/lang/IllegalArgumentException;
      Object localObject3 = new java/lang/StringBuilder;
      String str2 = String.valueOf(str1);
      int i = str2.length();
      i += 52;
      ((StringBuilder)localObject3).<init>(i);
      String str3 = "Cannot deserialize ";
      localObject3 = ((StringBuilder)localObject3).append(str3);
      localObject3 = ((StringBuilder)localObject3).append(str1);
      str3 = " no such key has been registered.";
      localObject3 = ((StringBuilder)localObject3).append(str3);
      localObject3 = ((StringBuilder)localObject3).toString();
      ((IllegalArgumentException)localObject2).<init>((String)localObject3);
      throw ((Throwable)localObject2);
    }
    Object localObject2 = typeMap;
    localObject2 = ((Map)localObject2).get(str1);
    localObject2 = (KeyType)localObject2;
    return localObject2;
  }

  private static void registerType(KeyType paramKeyType)
  {
    String str1 = paramKeyType.getName();
    Map localMap = typeMap;
    boolean bool = localMap.containsKey(str1);
    if (bool)
    {
      IllegalArgumentException localIllegalArgumentException = new java/lang/IllegalArgumentException;
      String str2 = "Attempt to map two key types to the same name ";
      localObject = String.valueOf(str1);
      int i = ((String)localObject).length();
      if (i != 0)
        localObject = str2.concat((String)localObject);
      while (true)
      {
        localIllegalArgumentException.<init>((String)localObject);
        throw localIllegalArgumentException;
        localObject = new java/lang/String;
        ((String)localObject).<init>(str2);
      }
    }
    Object localObject = typeMap;
    ((Map)localObject).put(str1, paramKeyType);
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.interfaces.KeyType.KeyTypeDeserializer
 * JD-Core Version:    0.6.2
 */
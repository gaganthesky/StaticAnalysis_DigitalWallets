package org.keyczar.interfaces;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public final class KeyType$KeyTypeSerializer
  implements JsonSerializer<KeyType>
{
  public final JsonElement serialize(Object paramObject, Type paramType, JsonSerializationContext paramJsonSerializationContext)
  {
    paramObject = (KeyType)paramObject;
    JsonElement localJsonElement = serialize(paramObject, paramType, paramJsonSerializationContext);
    return localJsonElement;
  }

  private static JsonElement serialize(KeyType paramKeyType, Type paramType, JsonSerializationContext paramJsonSerializationContext)
  {
    JsonPrimitive localJsonPrimitive = new com/google/gson/JsonPrimitive;
    String str = paramKeyType.getName();
    localJsonPrimitive.<init>(str);
    return localJsonPrimitive;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.interfaces.KeyType.KeyTypeSerializer
 * JD-Core Version:    0.6.2
 */
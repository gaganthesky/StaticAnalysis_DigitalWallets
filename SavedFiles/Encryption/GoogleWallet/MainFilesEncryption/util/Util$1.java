package org.keyczar.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.keyczar.interfaces.KeyType;
import org.keyczar.interfaces.KeyType.KeyTypeDeserializer;
import org.keyczar.interfaces.KeyType.KeyTypeSerializer;

final class Util$1 extends ThreadLocal<Gson>
{
  private static Gson initialValue()
  {
    Object localObject1 = new com/google/gson/GsonBuilder;
    ((GsonBuilder)localObject1).<init>();
    localObject1 = ((GsonBuilder)localObject1).excludeFieldsWithoutExposeAnnotation();
    KeyType localKeyType = KeyType.class;
    Object localObject2 = new org/keyczar/interfaces/KeyType$KeyTypeSerializer;
    ((KeyType.KeyTypeSerializer)localObject2).<init>();
    localObject1 = ((GsonBuilder)localObject1).registerTypeAdapter(localKeyType, localObject2);
    localKeyType = KeyType.class;
    localObject2 = new org/keyczar/interfaces/KeyType$KeyTypeDeserializer;
    ((KeyType.KeyTypeDeserializer)localObject2).<init>();
    localObject1 = ((GsonBuilder)localObject1).registerTypeAdapter(localKeyType, localObject2);
    localObject1 = ((GsonBuilder)localObject1).create();
    return localObject1;
  }

  protected final Object initialValue()
  {
    Gson localGson = initialValue();
    return localGson;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.util.Util.1
 * JD-Core Version:    0.6.2
 */
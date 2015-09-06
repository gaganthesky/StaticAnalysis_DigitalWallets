package org.keyczar;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.keyczar.enums.KeyPurpose;
import org.keyczar.interfaces.KeyType;
import org.keyczar.util.Util;

public class KeyMetadata
{
  boolean encrypted;
  String name;
  KeyPurpose purpose;
  KeyType type;
  protected Map versionMap;
  List versions;

  public KeyMetadata()
  {
    Object localObject = "";
    this.name = ((String)localObject);
    localObject = KeyPurpose.TEST;
    this.purpose = ((KeyPurpose)localObject);
    localObject = DefaultKeyType.TEST;
    this.type = ((KeyType)localObject);
    localObject = new java/util/ArrayList;
    ((ArrayList)localObject).<init>();
    this.versions = ((List)localObject);
    boolean bool = false;
    this.encrypted = bool;
    HashMap localHashMap = new java/util/HashMap;
    localHashMap.<init>();
    this.versionMap = localHashMap;
  }

  public KeyMetadata(String paramString, KeyPurpose paramKeyPurpose, KeyType paramKeyType)
  {
    Object localObject = "";
    this.name = ((String)localObject);
    localObject = KeyPurpose.TEST;
    this.purpose = ((KeyPurpose)localObject);
    localObject = DefaultKeyType.TEST;
    this.type = ((KeyType)localObject);
    localObject = new java/util/ArrayList;
    ((ArrayList)localObject).<init>();
    this.versions = ((List)localObject);
    boolean bool = false;
    this.encrypted = bool;
    HashMap localHashMap = new java/util/HashMap;
    localHashMap.<init>();
    this.versionMap = localHashMap;
    this.name = paramString;
    this.purpose = paramKeyPurpose;
    this.type = paramKeyType;
  }

  public final boolean addVersion(KeyVersion paramKeyVersion)
  {
    int i = paramKeyVersion.getVersionNumber();
    Map localMap = this.versionMap;
    Integer localInteger = Integer.valueOf(i);
    boolean bool1 = localMap.containsKey(localInteger);
    if (!bool1)
    {
      Object localObject = this.versionMap;
      localInteger = Integer.valueOf(i);
      ((Map)localObject).put(localInteger, paramKeyVersion);
      localObject = this.versions;
      ((List)localObject).add(paramKeyVersion);
    }
    for (boolean bool2 = true; ; bool2 = false)
      return bool2;
  }

  public final KeyPurpose getPurpose()
  {
    KeyPurpose localKeyPurpose = this.purpose;
    return localKeyPurpose;
  }

  public final KeyType getType()
  {
    KeyType localKeyType = this.type;
    return localKeyType;
  }

  public final List<KeyVersion> getVersions()
  {
    List localList = this.versions;
    return localList;
  }

  public final boolean isEncrypted()
  {
    boolean bool = this.encrypted;
    return bool;
  }

  public static KeyMetadata read(String paramString)
  {
    Object localObject3 = Util.gson();
    KeyMetadata localKeyMetadata = KeyMetadata.class;
    Object localObject1 = ((Gson)localObject3).fromJson(paramString, localKeyMetadata);
    localObject1 = (KeyMetadata)localObject1;
    localObject3 = ((KeyMetadata)localObject1).getVersions();
    localObject3 = ((List)localObject3).iterator();
    while (true)
    {
      boolean bool = ((Iterator)localObject3).hasNext();
      if (!bool)
        break;
      Object localObject2 = ((Iterator)localObject3).next();
      localObject2 = (KeyVersion)localObject2;
      Map localMap = ((KeyMetadata)localObject1).versionMap;
      int i = ((KeyVersion)localObject2).getVersionNumber();
      Integer localInteger = Integer.valueOf(i);
      localMap.put(localInteger, localObject2);
    }
    return localObject1;
  }

  public String toString()
  {
    Object localObject = Util.gson();
    localObject = ((Gson)localObject).toJson(this);
    return localObject;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.KeyMetadata
 * JD-Core Version:    0.6.2
 */
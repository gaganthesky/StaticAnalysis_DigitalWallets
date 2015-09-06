package org.keyczar;

import java.util.ArrayList;
import java.util.List;
import org.keyczar.enums.KeyPurpose;
import org.keyczar.enums.KeyStatus;
import org.keyczar.interfaces.KeyczarReader;

public final class ImportedKeyReader
  implements KeyczarReader
{
  private final List keys;
  private final KeyMetadata metadata;

  ImportedKeyReader(AesKey paramAesKey)
  {
    Object localObject = new org/keyczar/KeyMetadata;
    String str = "Imported AES";
    KeyPurpose localKeyPurpose = KeyPurpose.DECRYPT_AND_ENCRYPT;
    DefaultKeyType localDefaultKeyType = DefaultKeyType.AES;
    ((KeyMetadata)localObject).<init>(str, localKeyPurpose, localDefaultKeyType);
    this.metadata = ((KeyMetadata)localObject);
    KeyVersion localKeyVersion = new org/keyczar/KeyVersion;
    localObject = KeyStatus.PRIMARY;
    localKeyVersion.<init>(i, (KeyStatus)localObject, i);
    localObject = this.metadata;
    ((KeyMetadata)localObject).addVersion(localKeyVersion);
    localObject = new java/util/ArrayList;
    ((ArrayList)localObject).<init>();
    this.keys = ((List)localObject);
    localObject = this.keys;
    ((List)localObject).add(paramAesKey);
  }

  public final String getKey(int paramInt)
  {
    Object localObject = this.keys;
    localObject = ((List)localObject).get(paramInt);
    localObject = (KeyczarKey)localObject;
    localObject = ((KeyczarKey)localObject).toString();
    return localObject;
  }

  public final String getMetadata()
  {
    Object localObject = this.metadata;
    localObject = ((KeyMetadata)localObject).toString();
    return localObject;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.ImportedKeyReader
 * JD-Core Version:    0.6.2
 */
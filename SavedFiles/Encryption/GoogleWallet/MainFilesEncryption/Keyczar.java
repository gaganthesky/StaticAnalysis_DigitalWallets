package org.keyczar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.keyczar.enums.KeyPurpose;
import org.keyczar.enums.KeyStatus;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.i18n.Messages;
import org.keyczar.interfaces.EncryptedReader;
import org.keyczar.interfaces.KeyType;
import org.keyczar.interfaces.KeyType.Builder;
import org.keyczar.interfaces.KeyczarReader;

public abstract class Keyczar
{
  public static final byte[] FORMAT_BYTES = arrayOfByte;
  private static final Logger LOG;
  final HashMap hashMap;
  final KeyMetadata kmd;
  KeyVersion primaryVersion;
  final HashMap versionMap;

  static
  {
    int j = 0;
    Object localObject = Keyczar.class;
    localObject = Logger.getLogger((Class)localObject);
    LOG = (Logger)localObject;
    int i = 1;
    byte[] arrayOfByte = new byte[i];
    arrayOfByte[j] = j;
  }

  public Keyczar(KeyczarReader paramKeyczarReader)
    throws KeyczarException
  {
    Object localObject2 = new java/util/HashMap;
    ((HashMap)localObject2).<init>();
    this.versionMap = ((HashMap)localObject2);
    localObject2 = new java/util/HashMap;
    ((HashMap)localObject2).<init>();
    this.hashMap = ((HashMap)localObject2);
    localObject2 = paramKeyczarReader.getMetadata();
    localObject2 = KeyMetadata.read((String)localObject2);
    this.kmd = ((KeyMetadata)localObject2);
    localObject2 = this.kmd;
    localObject2 = ((KeyMetadata)localObject2).getPurpose();
    boolean bool1 = isAcceptablePurpose((KeyPurpose)localObject2);
    String str2;
    Object localObject7;
    Object localObject8;
    if (!bool1)
    {
      localObject3 = new org/keyczar/exceptions/KeyczarException;
      str2 = "Keyczar.UnacceptablePurpose";
      localObject7 = new Object[k];
      localObject8 = this.kmd;
      localObject8 = ((KeyMetadata)localObject8).getPurpose();
      localObject7[j] = localObject8;
      str2 = Messages.getString(str2, (Object[])localObject7);
      ((KeyczarException)localObject3).<init>(str2);
      throw ((Throwable)localObject3);
    }
    Object localObject3 = this.kmd;
    boolean bool2 = ((KeyMetadata)localObject3).isEncrypted();
    if (bool2)
    {
      bool2 = paramKeyczarReader instanceof EncryptedReader;
      if (!bool2)
      {
        localObject4 = new org/keyczar/exceptions/KeyczarException;
        str2 = "Keyczar.NeedEncryptedReader";
        localObject7 = new Object[j];
        str2 = Messages.getString(str2, (Object[])localObject7);
        ((KeyczarException)localObject4).<init>(str2);
        throw ((Throwable)localObject4);
      }
    }
    Object localObject4 = this.kmd;
    localObject4 = ((KeyMetadata)localObject4).getVersions();
    localObject4 = ((List)localObject4).iterator();
    while (true)
    {
      boolean bool3 = ((Iterator)localObject4).hasNext();
      if (!bool3)
        break;
      Object localObject1 = ((Iterator)localObject4).next();
      localObject1 = (KeyVersion)localObject1;
      Object localObject5 = ((KeyVersion)localObject1).getStatus();
      localObject7 = KeyStatus.PRIMARY;
      if (localObject5 == localObject7)
      {
        localObject5 = this.primaryVersion;
        if (localObject5 != null)
        {
          localObject4 = new org/keyczar/exceptions/KeyczarException;
          localObject5 = "Keyczar.SinglePrimary";
          localObject7 = new Object[j];
          localObject5 = Messages.getString((String)localObject5, (Object[])localObject7);
          ((KeyczarException)localObject4).<init>((String)localObject5);
          throw ((Throwable)localObject4);
        }
        this.primaryVersion = ((KeyVersion)localObject1);
      }
      int i = ((KeyVersion)localObject1).getVersionNumber();
      String str1 = paramKeyczarReader.getKey(i);
      Object localObject6 = this.kmd;
      localObject6 = ((KeyMetadata)localObject6).getType();
      localObject6 = ((KeyType)localObject6).getBuilder();
      KeyczarKey localKeyczarKey = ((KeyType.Builder)localObject6).read(str1);
      localObject6 = LOG;
      localObject7 = "Keyczar.ReadVersion";
      localObject8 = new Object[k];
      localObject8[j] = localObject1;
      localObject7 = Messages.getString((String)localObject7, (Object[])localObject8);
      ((Logger)localObject6).debug(localObject7);
      localObject6 = this.hashMap;
      localObject7 = new org/keyczar/Keyczar$KeyHash;
      localObject8 = localKeyczarKey.hash();
      Keyczar.1 local1 = null;
      ((Keyczar.KeyHash)localObject7).<init>(this, (byte[])localObject8, local1);
      ((HashMap)localObject6).put(localObject7, localKeyczarKey);
      localObject6 = this.versionMap;
      ((HashMap)localObject6).put(localObject1, localKeyczarKey);
    }
  }

  final KeyczarKey getKey(byte[] paramArrayOfByte)
  {
    Object localObject = this.hashMap;
    Keyczar.KeyHash localKeyHash = new org/keyczar/Keyczar$KeyHash;
    Keyczar.1 local1 = null;
    localKeyHash.<init>(this, paramArrayOfByte, local1);
    localObject = ((HashMap)localObject).get(localKeyHash);
    localObject = (KeyczarKey)localObject;
    return localObject;
  }

  final KeyczarKey getPrimaryKey()
  {
    Object localObject = this.primaryVersion;
    if (localObject == null);
    for (localObject = null; ; localObject = (KeyczarKey)localObject)
    {
      return localObject;
      localObject = this.versionMap;
      KeyVersion localKeyVersion = this.primaryVersion;
      localObject = ((HashMap)localObject).get(localKeyVersion);
    }
  }

  abstract boolean isAcceptablePurpose(KeyPurpose paramKeyPurpose);

  public String toString()
  {
    Object localObject = this.kmd;
    localObject = ((KeyMetadata)localObject).toString();
    return localObject;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.Keyczar
 * JD-Core Version:    0.6.2
 */
package org.keyczar;

import org.apache.log4j.Logger;
import org.keyczar.enums.KeyPurpose;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.interfaces.KeyczarReader;

public class Verifier extends Keyczar
{
  private static final Logger LOG = (Logger)localObject;
  private final StreamCache VERIFY_CACHE;

  static
  {
    Object localObject = Verifier.class;
    localObject = Logger.getLogger((Class)localObject);
  }

  public Verifier(KeyczarReader paramKeyczarReader)
    throws KeyczarException
  {
    super(paramKeyczarReader);
    StreamCache localStreamCache = new org/keyczar/StreamCache;
    localStreamCache.<init>();
    this.VERIFY_CACHE = localStreamCache;
  }

  boolean isAcceptablePurpose(KeyPurpose paramKeyPurpose)
  {
    KeyPurpose localKeyPurpose = KeyPurpose.VERIFY;
    if (paramKeyPurpose != localKeyPurpose)
    {
      localKeyPurpose = KeyPurpose.SIGN_AND_VERIFY;
      if (paramKeyPurpose != localKeyPurpose)
        break label23;
    }
    label23: for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.Verifier
 * JD-Core Version:    0.6.2
 */
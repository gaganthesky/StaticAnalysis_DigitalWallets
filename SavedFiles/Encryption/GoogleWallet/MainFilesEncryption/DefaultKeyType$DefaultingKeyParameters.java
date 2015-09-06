package org.keyczar;

import java.util.List;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.keyparams.KeyParameters;

class DefaultKeyType$DefaultingKeyParameters
  implements KeyParameters
{
  protected final KeyParameters baseParameters;
  final DefaultKeyType this$0;

  public DefaultKeyType$DefaultingKeyParameters(DefaultKeyType paramDefaultKeyType, KeyParameters paramKeyParameters)
  {
    this.baseParameters = paramKeyParameters;
  }

  public final int getKeySize()
    throws KeyczarException
  {
    KeyParameters localKeyParameters1 = this.baseParameters;
    int m;
    Object localObject;
    if (localKeyParameters1 != null)
    {
      localKeyParameters1 = this.baseParameters;
      int i = localKeyParameters1.getKeySize();
      m = -1;
      if (i != m);
    }
    else
    {
      localObject = this.this$0;
      localObject = DefaultKeyType.access$100((DefaultKeyType)localObject);
      m = 0;
      localObject = ((List)localObject).get(m);
      localObject = (Integer)localObject;
    }
    KeyParameters localKeyParameters2;
    int k;
    for (int j = ((Integer)localObject).intValue(); ; k = localKeyParameters2.getKeySize())
    {
      return j;
      localKeyParameters2 = this.baseParameters;
    }
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.DefaultKeyType.DefaultingKeyParameters
 * JD-Core Version:    0.6.2
 */
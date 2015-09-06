package com.google.wallet.proto;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

public final class NanoWalletEntities$PhysicalLocation extends ExtendableMessageNano<PhysicalLocation>
{
  public Float accuracy;
  public Double latitude;
  public Double longitude;

  public NanoWalletEntities$PhysicalLocation()
  {
    clear();
  }

  private PhysicalLocation clear()
  {
    Object localObject = null;
    this.latitude = localObject;
    this.longitude = localObject;
    this.accuracy = localObject;
    this.unknownFieldData = localObject;
    int i = -1;
    this.cachedSize = i;
    return this;
  }

  protected final int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Double localDouble1 = this.latitude;
    if (localDouble1 != null)
    {
      int j = 1;
      Double localDouble3 = this.latitude;
      double d1 = localDouble3.doubleValue();
      j = CodedOutputByteBufferNano.computeDoubleSize(j, d1);
      i += j;
    }
    Double localDouble2 = this.longitude;
    if (localDouble2 != null)
    {
      int k = 2;
      Double localDouble4 = this.longitude;
      double d2 = localDouble4.doubleValue();
      k = CodedOutputByteBufferNano.computeDoubleSize(k, d2);
      i += k;
    }
    Float localFloat1 = this.accuracy;
    if (localFloat1 != null)
    {
      int m = 3;
      Float localFloat2 = this.accuracy;
      float f = localFloat2.floatValue();
      m = CodedOutputByteBufferNano.computeFloatSize(m, f);
      i += m;
    }
    return i;
  }

  public final MessageNano mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
    throws IOException
  {
    PhysicalLocation localPhysicalLocation = mergeFrom(paramCodedInputByteBufferNano);
    return localPhysicalLocation;
  }

  private PhysicalLocation mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
    throws IOException
  {
    while (true)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      double d;
      Double localDouble;
      switch (i)
      {
      default:
        boolean bool = storeUnknownField(paramCodedInputByteBufferNano, i);
        if (bool);
        break;
      case 0:
        return this;
      case 9:
        d = paramCodedInputByteBufferNano.readDouble();
        localDouble = Double.valueOf(d);
        this.latitude = localDouble;
        break;
      case 17:
        d = paramCodedInputByteBufferNano.readDouble();
        localDouble = Double.valueOf(d);
        this.longitude = localDouble;
        break;
      case 29:
        float f = paramCodedInputByteBufferNano.readFloat();
        Float localFloat = Float.valueOf(f);
        this.accuracy = localFloat;
      }
    }
  }

  public final void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
    throws IOException
  {
    Double localDouble1 = this.latitude;
    Object localObject;
    double d;
    if (localDouble1 != null)
    {
      int i = 1;
      localObject = this.latitude;
      d = ((Double)localObject).doubleValue();
      paramCodedOutputByteBufferNano.writeDouble(i, d);
    }
    Double localDouble2 = this.longitude;
    if (localDouble2 != null)
    {
      int j = 2;
      localObject = this.longitude;
      d = ((Double)localObject).doubleValue();
      paramCodedOutputByteBufferNano.writeDouble(j, d);
    }
    Float localFloat = this.accuracy;
    if (localFloat != null)
    {
      int k = 3;
      localObject = this.accuracy;
      float f = ((Float)localObject).floatValue();
      paramCodedOutputByteBufferNano.writeFloat(k, f);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     com.google.wallet.proto.NanoWalletEntities.PhysicalLocation
 * JD-Core Version:    0.6.2
 */
package com.google.wallet.proto;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

public final class NanoWalletLogging$ActionOutcome extends ExtendableMessageNano<ActionOutcome>
{
  public Integer action;
  public Integer bank;
  public Long elapsedMillis;
  public String encodedCplc;
  public Integer environment;
  public String imei;
  public NanoWalletLogging.NetworkDetails networkDetails;
  public String partnerId;
  public String returnCode;
  public String sessionId;
  public Integer status;

  public NanoWalletLogging$ActionOutcome()
  {
    clear();
  }

  private ActionOutcome clear()
  {
    Object localObject = null;
    this.action = localObject;
    this.bank = localObject;
    this.environment = localObject;
    this.status = localObject;
    this.returnCode = localObject;
    this.elapsedMillis = localObject;
    this.sessionId = localObject;
    this.encodedCplc = localObject;
    this.imei = localObject;
    this.partnerId = localObject;
    this.networkDetails = localObject;
    this.unknownFieldData = localObject;
    int i = -1;
    this.cachedSize = i;
    return this;
  }

  protected final int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Integer localInteger1 = this.action;
    if (localInteger1 != null)
    {
      int j = 1;
      Integer localInteger5 = this.action;
      int i8 = localInteger5.intValue();
      j = CodedOutputByteBufferNano.computeInt32Size(j, i8);
      i += j;
    }
    Integer localInteger2 = this.bank;
    if (localInteger2 != null)
    {
      int k = 2;
      Integer localInteger6 = this.bank;
      int i9 = localInteger6.intValue();
      k = CodedOutputByteBufferNano.computeInt32Size(k, i9);
      i += k;
    }
    Integer localInteger3 = this.environment;
    if (localInteger3 != null)
    {
      int m = 3;
      Integer localInteger7 = this.environment;
      int i10 = localInteger7.intValue();
      m = CodedOutputByteBufferNano.computeInt32Size(m, i10);
      i += m;
    }
    Integer localInteger4 = this.status;
    if (localInteger4 != null)
    {
      int n = 4;
      Integer localInteger8 = this.status;
      int i11 = localInteger8.intValue();
      n = CodedOutputByteBufferNano.computeInt32Size(n, i11);
      i += n;
    }
    String str1 = this.returnCode;
    Object localObject1;
    if (str1 != null)
    {
      int i1 = 5;
      localObject1 = this.returnCode;
      i1 = CodedOutputByteBufferNano.computeStringSize(i1, (String)localObject1);
      i += i1;
    }
    Long localLong = this.elapsedMillis;
    if (localLong != null)
    {
      int i2 = 6;
      localObject1 = this.elapsedMillis;
      long l = ((Long)localObject1).longValue();
      i2 = CodedOutputByteBufferNano.computeInt64Size(i2, l);
      i += i2;
    }
    String str2 = this.sessionId;
    Object localObject2;
    if (str2 != null)
    {
      int i3 = 7;
      localObject2 = this.sessionId;
      i3 = CodedOutputByteBufferNano.computeStringSize(i3, (String)localObject2);
      i += i3;
    }
    String str3 = this.encodedCplc;
    if (str3 != null)
    {
      int i4 = 8;
      localObject2 = this.encodedCplc;
      i4 = CodedOutputByteBufferNano.computeStringSize(i4, (String)localObject2);
      i += i4;
    }
    String str4 = this.imei;
    if (str4 != null)
    {
      int i5 = 9;
      localObject2 = this.imei;
      i5 = CodedOutputByteBufferNano.computeStringSize(i5, (String)localObject2);
      i += i5;
    }
    String str5 = this.partnerId;
    if (str5 != null)
    {
      int i6 = 10;
      localObject2 = this.partnerId;
      i6 = CodedOutputByteBufferNano.computeStringSize(i6, (String)localObject2);
      i += i6;
    }
    NanoWalletLogging.NetworkDetails localNetworkDetails = this.networkDetails;
    if (localNetworkDetails != null)
    {
      int i7 = 11;
      localObject2 = this.networkDetails;
      i7 = CodedOutputByteBufferNano.computeMessageSize(i7, (MessageNano)localObject2);
      i += i7;
    }
    return i;
  }

  public final MessageNano mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
    throws IOException
  {
    ActionOutcome localActionOutcome = mergeFrom(paramCodedInputByteBufferNano);
    return localActionOutcome;
  }

  private ActionOutcome mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano)
    throws IOException
  {
    while (true)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      int j;
      Object localObject1;
      Object localObject2;
      switch (i)
      {
      default:
        boolean bool = storeUnknownField(paramCodedInputByteBufferNano, i);
        if (bool);
        break;
      case 0:
        return this;
      case 8:
        j = paramCodedInputByteBufferNano.readInt32();
        switch (j)
        {
        default:
          break;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:
        case 16:
        case 17:
        case 18:
        case 19:
        case 20:
        case 21:
        case 22:
        case 23:
        case 24:
        case 25:
        case 26:
        case 27:
        case 28:
        case 29:
        case 30:
        case 31:
        case 32:
        case 33:
        case 34:
        case 35:
        case 36:
        case 37:
        case 38:
        case 39:
        case 40:
        case 41:
        case 42:
        case 43:
        case 44:
        case 45:
        case 46:
        case 47:
        case 48:
          localObject1 = Integer.valueOf(j);
          this.action = ((Integer)localObject1);
        }
        break;
      case 16:
        j = paramCodedInputByteBufferNano.readInt32();
        switch (j)
        {
        default:
          break;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
          localObject1 = Integer.valueOf(j);
          this.bank = ((Integer)localObject1);
        }
        break;
      case 24:
        j = paramCodedInputByteBufferNano.readInt32();
        switch (j)
        {
        default:
          break;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
          localObject1 = Integer.valueOf(j);
          this.environment = ((Integer)localObject1);
        }
        break;
      case 32:
        j = paramCodedInputByteBufferNano.readInt32();
        switch (j)
        {
        default:
          break;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        case 13:
          localObject1 = Integer.valueOf(j);
          this.status = ((Integer)localObject1);
        }
        break;
      case 42:
        localObject1 = paramCodedInputByteBufferNano.readString();
        this.returnCode = ((String)localObject1);
        break;
      case 48:
        long l = paramCodedInputByteBufferNano.readInt64();
        localObject2 = Long.valueOf(l);
        this.elapsedMillis = ((Long)localObject2);
        break;
      case 58:
        localObject2 = paramCodedInputByteBufferNano.readString();
        this.sessionId = ((String)localObject2);
        break;
      case 66:
        localObject2 = paramCodedInputByteBufferNano.readString();
        this.encodedCplc = ((String)localObject2);
        break;
      case 74:
        localObject2 = paramCodedInputByteBufferNano.readString();
        this.imei = ((String)localObject2);
        break;
      case 82:
        localObject2 = paramCodedInputByteBufferNano.readString();
        this.partnerId = ((String)localObject2);
        break;
      case 90:
        localObject2 = this.networkDetails;
        if (localObject2 == null)
        {
          localObject2 = new com/google/wallet/proto/NanoWalletLogging$NetworkDetails;
          ((NanoWalletLogging.NetworkDetails)localObject2).<init>();
          this.networkDetails = ((NanoWalletLogging.NetworkDetails)localObject2);
        }
        localObject2 = this.networkDetails;
        paramCodedInputByteBufferNano.readMessage((MessageNano)localObject2);
      }
    }
  }

  public final void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
    throws IOException
  {
    Integer localInteger1 = this.action;
    if (localInteger1 != null)
    {
      int i = 1;
      Integer localInteger5 = this.action;
      int i7 = localInteger5.intValue();
      paramCodedOutputByteBufferNano.writeInt32(i, i7);
    }
    Integer localInteger2 = this.bank;
    if (localInteger2 != null)
    {
      int j = 2;
      Integer localInteger6 = this.bank;
      int i8 = localInteger6.intValue();
      paramCodedOutputByteBufferNano.writeInt32(j, i8);
    }
    Integer localInteger3 = this.environment;
    if (localInteger3 != null)
    {
      int k = 3;
      Integer localInteger7 = this.environment;
      int i9 = localInteger7.intValue();
      paramCodedOutputByteBufferNano.writeInt32(k, i9);
    }
    Integer localInteger4 = this.status;
    if (localInteger4 != null)
    {
      int m = 4;
      Integer localInteger8 = this.status;
      int i10 = localInteger8.intValue();
      paramCodedOutputByteBufferNano.writeInt32(m, i10);
    }
    String str1 = this.returnCode;
    Object localObject;
    if (str1 != null)
    {
      int n = 5;
      localObject = this.returnCode;
      paramCodedOutputByteBufferNano.writeString(n, (String)localObject);
    }
    Long localLong = this.elapsedMillis;
    if (localLong != null)
    {
      int i1 = 6;
      localObject = this.elapsedMillis;
      long l = ((Long)localObject).longValue();
      paramCodedOutputByteBufferNano.writeInt64(i1, l);
    }
    String str2 = this.sessionId;
    if (str2 != null)
    {
      int i2 = 7;
      localObject = this.sessionId;
      paramCodedOutputByteBufferNano.writeString(i2, (String)localObject);
    }
    String str3 = this.encodedCplc;
    if (str3 != null)
    {
      int i3 = 8;
      localObject = this.encodedCplc;
      paramCodedOutputByteBufferNano.writeString(i3, (String)localObject);
    }
    String str4 = this.imei;
    if (str4 != null)
    {
      int i4 = 9;
      localObject = this.imei;
      paramCodedOutputByteBufferNano.writeString(i4, (String)localObject);
    }
    String str5 = this.partnerId;
    if (str5 != null)
    {
      int i5 = 10;
      localObject = this.partnerId;
      paramCodedOutputByteBufferNano.writeString(i5, (String)localObject);
    }
    NanoWalletLogging.NetworkDetails localNetworkDetails = this.networkDetails;
    if (localNetworkDetails != null)
    {
      int i6 = 11;
      localObject = this.networkDetails;
      paramCodedOutputByteBufferNano.writeMessage(i6, (MessageNano)localObject);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     com.google.wallet.proto.NanoWalletLogging.ActionOutcome
 * JD-Core Version:    0.6.2
 */
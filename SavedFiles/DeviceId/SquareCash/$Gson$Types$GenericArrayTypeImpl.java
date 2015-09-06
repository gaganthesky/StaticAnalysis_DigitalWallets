package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class $Gson$Types$GenericArrayTypeImpl
  implements GenericArrayType, Serializable
{
  private static final long serialVersionUID = 0L;
  private final Type componentType;

  public $Gson$Types$GenericArrayTypeImpl(Type paramType)
  {
    Type localType = .Gson.Types.canonicalize(paramType);
    this.componentType = localType;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = paramObject instanceof Serializable;
    if (bool)
    {
      paramObject = (Serializable)paramObject;
      bool = .Gson.Types.equals(this, paramObject);
      if (!bool);
    }
    for (bool = true; ; bool = false)
      return bool;
  }

  public Type getGenericComponentType()
  {
    Type localType = this.componentType;
    return localType;
  }

  public int hashCode()
  {
    Type localType = this.componentType;
    int i = localType.hashCode();
    return i;
  }

  public String toString()
  {
    Object localObject1 = new java/lang/StringBuilder;
    ((StringBuilder)localObject1).<init>();
    Object localObject2 = this.componentType;
    localObject2 = .Gson.Types.typeToString((Type)localObject2);
    localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
    localObject2 = "[]";
    localObject1 = ((StringBuilder)localObject1).append((String)localObject2);
    localObject1 = ((StringBuilder)localObject1).toString();
    return localObject1;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Square/retargeted/com.squareup.cash_2.5.1_[www.apk-dl.com]/
 * Qualified Name:     com.google.gson.internal..Gson.Types.GenericArrayTypeImpl
 * JD-Core Version:    0.6.2
 */
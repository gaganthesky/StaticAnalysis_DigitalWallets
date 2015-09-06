package com.flurry.sdk;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

public class cl
  implements cn.b, ei.a
{
  static int a = 0;
  static int b = 0;
  static int c = 0;
  static int d = 0;
  static int e = 0;
  static int f = 0;
  private static final String g;
  private byte A;
  private boolean B;
  private String C;
  private byte D;
  private long E;
  private long F;
  private final Map G;
  private final List H;
  private boolean I;
  private int J;
  private final List K;
  private int L;
  private int M;
  private final by N;
  private Map O;
  private final Handler P;
  private cn Q;
  private cl.a R;
  private int S;
  private boolean T;
  private final AtomicInteger h;
  private final AtomicInteger i;
  private final AtomicInteger j;
  private File k;
  private volatile boolean l;
  private String m;
  private String n;
  private List o;
  private final Map p;
  private boolean q;
  private long r;
  private List s;
  private String t;
  private long u;
  private long v;
  private long w;
  private long x;
  private String y;
  private String z;

  static
  {
    Object localObject = cl.class;
    localObject = ((Class)localObject).getSimpleName();
    g = (String)localObject;
    int i1 = 100;
    a = i1;
    i1 = 10;
    b = i1;
    i1 = 1000;
    c = i1;
    i1 = 160000;
    d = i1;
    i1 = 50;
    e = i1;
    i1 = 20;
  }

  public cl(Context paramContext, String paramString, cl.a parama)
  {
    Object localObject1 = new java/util/concurrent/atomic/AtomicInteger;
    ((AtomicInteger)localObject1).<init>(i2);
    this.h = ((AtomicInteger)localObject1);
    localObject1 = new java/util/concurrent/atomic/AtomicInteger;
    ((AtomicInteger)localObject1).<init>(i2);
    this.i = ((AtomicInteger)localObject1);
    localObject1 = new java/util/concurrent/atomic/AtomicInteger;
    ((AtomicInteger)localObject1).<init>(i2);
    this.j = ((AtomicInteger)localObject1);
    localObject1 = null;
    this.k = ((File)localObject1);
    this.l = i2;
    localObject1 = new java/util/HashMap;
    ((HashMap)localObject1).<init>();
    this.p = ((Map)localObject1);
    localObject1 = new java/util/ArrayList;
    ((ArrayList)localObject1).<init>();
    this.s = ((List)localObject1);
    localObject1 = "";
    this.y = ((String)localObject1);
    localObject1 = "";
    this.z = ((String)localObject1);
    byte b1 = -1;
    this.A = b1;
    Object localObject2 = new java/util/HashMap;
    ((HashMap)localObject2).<init>();
    this.G = ((Map)localObject2);
    localObject2 = new java/util/ArrayList;
    ((ArrayList)localObject2).<init>();
    this.H = ((List)localObject2);
    localObject2 = new java/util/ArrayList;
    ((ArrayList)localObject2).<init>();
    this.K = ((List)localObject2);
    localObject2 = new com/flurry/sdk/by;
    ((by)localObject2).<init>();
    this.N = ((by)localObject2);
    this.T = i2;
    int i1 = 4;
    Object localObject5 = g;
    String str = "Initializing new Flurry session";
    ex.a(i1, (String)localObject5, str);
    Object localObject3 = new android/os/HandlerThread;
    localObject5 = new java/lang/StringBuilder;
    ((StringBuilder)localObject5).<init>();
    str = "FlurryAgentSession_";
    localObject5 = ((StringBuilder)localObject5).append(str);
    localObject5 = ((StringBuilder)localObject5).append(paramString);
    localObject5 = ((StringBuilder)localObject5).toString();
    ((HandlerThread)localObject3).<init>((String)localObject5);
    ((HandlerThread)localObject3).start();
    localObject5 = new android/os/Handler;
    localObject3 = ((HandlerThread)localObject3).getLooper();
    ((Handler)localObject5).<init>((Looper)localObject3);
    this.P = ((Handler)localObject5);
    u();
    localObject3 = new com/flurry/sdk/cn;
    ((cn)localObject3).<init>(this);
    this.Q = ((cn)localObject3);
    this.R = parama;
    this.m = paramString;
    localObject3 = z();
    localObject3 = paramContext.getFileStreamPath((String)localObject3);
    this.k = ((File)localObject3);
    localObject3 = ep.a();
    this.n = ((String)localObject3);
    long l1 = 4294967295L;
    this.w = l1;
    this.L = i2;
    Object localObject4 = TimeZone.getDefault();
    localObject4 = ((TimeZone)localObject4).getID();
    this.z = ((String)localObject4);
    localObject4 = new java/lang/StringBuilder;
    ((StringBuilder)localObject4).<init>();
    localObject5 = Locale.getDefault();
    localObject5 = ((Locale)localObject5).getLanguage();
    localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
    localObject5 = "_";
    localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
    localObject5 = Locale.getDefault();
    localObject5 = ((Locale)localObject5).getCountry();
    localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
    localObject4 = ((StringBuilder)localObject4).toString();
    this.y = ((String)localObject4);
    boolean bool = true;
    this.I = bool;
    this.J = i2;
    this.M = i2;
    r();
  }

  private int A()
  {
    AtomicInteger localAtomicInteger = this.h;
    int i1 = localAtomicInteger.incrementAndGet();
    return i1;
  }

  private int B()
  {
    AtomicInteger localAtomicInteger = this.i;
    int i1 = localAtomicInteger.incrementAndGet();
    return i1;
  }

  private String C()
  {
    String str = this.t;
    return str;
  }

  private Location D()
  {
    Object localObject = bx.a();
    localObject = ((bx)localObject).n();
    return localObject;
  }

  static String a(cl paramcl, String paramString)
  {
    paramcl.t = paramString;
    return paramString;
  }

  Map<String, List<String>> a()
  {
    Map localMap = this.O;
    return localMap;
  }

  private void a(long paramLong)
  {
    List localList = this.H;
    Iterator localIterator = localList.iterator();
    while (true)
    {
      boolean bool1 = localIterator.hasNext();
      if (!bool1)
        break;
      Object localObject = localIterator.next();
      localObject = (cb)localObject;
      boolean bool2 = ((cb)localObject).a();
      if (bool2)
      {
        bool2 = ((cb)localObject).b();
        if (!bool2)
          ((cb)localObject).a(paramLong);
      }
    }
  }

  private void a(Context paramContext)
  {
    try
    {
      Object localObject1 = em.a();
      if (localObject1 != null)
      {
        int i1 = 3;
        localObject2 = g;
        str = "Fetched hashed IMEI";
        ex.a(i1, (String)localObject2, str);
        Map localMap = this.p;
        localObject2 = ej.b;
        localObject1 = ByteBuffer.wrap((byte[])localObject1);
        localMap.put(localObject2, localObject1);
      }
      c(paramContext);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        int i2 = 6;
        Object localObject2 = g;
        String str = "";
        ex.a(i2, (String)localObject2, str, localThrowable);
      }
    }
  }

  static void a(cl paramcl, Context paramContext)
  {
    paramcl.d(paramContext);
  }

  public void a(fi paramfi)
  {
    Handler localHandler = this.P;
    localHandler.post(paramfi);
  }

  public void a(String paramString, Object paramObject)
  {
    int i3 = 4;
    String str1 = "Gender";
    boolean bool1 = paramString.equals(str1);
    String str2;
    Object localObject;
    if (bool1)
    {
      paramObject = (Byte)paramObject;
      byte b1 = paramObject.byteValue();
      this.D = b1;
      str2 = g;
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      String str7 = "onSettingUpdate, Gender = ";
      localObject = ((StringBuilder)localObject).append(str7);
      int i2 = this.D;
      localObject = ((StringBuilder)localObject).append(i2);
      localObject = ((StringBuilder)localObject).toString();
      ex.a(i3, str2, (String)localObject);
    }
    while (true)
    {
      return;
      str2 = "UserId";
      boolean bool2 = paramString.equals(str2);
      String str3;
      String str8;
      if (bool2)
      {
        paramObject = (String)paramObject;
        this.C = paramObject;
        str3 = g;
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        str8 = "onSettingUpdate, UserId = ";
        localObject = ((StringBuilder)localObject).append(str8);
        str8 = this.C;
        localObject = ((StringBuilder)localObject).append(str8);
        localObject = ((StringBuilder)localObject).toString();
        ex.a(i3, str3, (String)localObject);
      }
      else
      {
        str3 = "LogEvents";
        boolean bool3 = paramString.equals(str3);
        String str4;
        if (bool3)
        {
          paramObject = (Boolean)paramObject;
          bool3 = paramObject.booleanValue();
          this.B = bool3;
          str4 = g;
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          str8 = "onSettingUpdate, LogEvents = ";
          localObject = ((StringBuilder)localObject).append(str8);
          boolean bool6 = this.B;
          localObject = ((StringBuilder)localObject).append(bool6);
          localObject = ((StringBuilder)localObject).toString();
          ex.a(i3, str4, (String)localObject);
        }
        else
        {
          str4 = "Age";
          boolean bool4 = paramString.equals(str4);
          String str5;
          if (bool4)
          {
            paramObject = (Long)paramObject;
            long l1 = paramObject.longValue();
            this.E = l1;
            str5 = g;
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            String str9 = "onSettingUpdate, Birthdate = ";
            localObject = ((StringBuilder)localObject).append(str9);
            long l3 = this.E;
            localObject = ((StringBuilder)localObject).append(l3);
            localObject = ((StringBuilder)localObject).toString();
            ex.a(i3, str5, (String)localObject);
          }
          else
          {
            str5 = "ContinueSessionMillis";
            boolean bool5 = paramString.equals(str5);
            if (bool5)
            {
              paramObject = (Long)paramObject;
              long l2 = paramObject.longValue();
              this.F = l2;
              String str6 = g;
              localObject = new java/lang/StringBuilder;
              ((StringBuilder)localObject).<init>();
              String str10 = "onSettingUpdate, ContinueSessionMillis = ";
              localObject = ((StringBuilder)localObject).append(str10);
              long l4 = this.F;
              localObject = ((StringBuilder)localObject).append(l4);
              localObject = ((StringBuilder)localObject).toString();
              ex.a(i3, str6, (String)localObject);
            }
            else
            {
              int i1 = 6;
              localObject = g;
              String str11 = "onSettingUpdate internal error!";
              ex.a(i1, (String)localObject, str11);
            }
          }
        }
      }
    }
  }

  public void a(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    int i1 = 0;
    if (paramString1 != null);
    while (true)
    {
      String str4;
      String str5;
      String str6;
      Throwable localThrowable;
      Object localObject6;
      try
      {
        String str2 = "uncaught";
        boolean bool2 = str2.equals(paramString1);
        if (bool2)
        {
          bool2 = true;
          int i6 = this.L;
          i6 += 1;
          this.L = i6;
          List localList = this.K;
          int i7 = localList.size();
          int i8 = e;
          if (i7 < i8)
          {
            long l1 = System.currentTimeMillis();
            Long localLong = Long.valueOf(l1);
            localObject1 = new com/flurry/sdk/ca;
            int i4 = B();
            long l3 = localLong.longValue();
            str4 = paramString1;
            str5 = paramString2;
            str6 = paramString3;
            localThrowable = paramThrowable;
            ((ca)localObject1).<init>(i4, l3, str4, str5, str6, localThrowable);
            localObject4 = this.K;
            ((List)localObject4).add(localObject1);
            localObject4 = g;
            localObject6 = new java/lang/StringBuilder;
            ((StringBuilder)localObject6).<init>();
            String str3 = "Error logged: ";
            localObject6 = ((StringBuilder)localObject6).append(str3);
            localObject1 = ((ca)localObject1).c();
            localObject1 = ((StringBuilder)localObject6).append((String)localObject1);
            localObject1 = ((StringBuilder)localObject1).toString();
            ex.e((String)localObject4, (String)localObject1);
          }
        }
        else
        {
          localObject4 = localObject1;
          continue;
        }
        if (localObject4 == 0)
          break label415;
        i9 = localObject1;
        Object localObject1 = this.K;
        int i2 = ((List)localObject1).size();
        if (i9 >= i2)
          continue;
        Object localObject2 = this.K;
        localObject2 = ((List)localObject2).get(i9);
        localObject2 = (ca)localObject2;
        Object localObject4 = ((ca)localObject2).c();
        if (localObject4 != null)
        {
          localObject4 = "uncaught";
          localObject2 = ((ca)localObject2).c();
          boolean bool1 = ((String)localObject4).equals(localObject2);
          if (!bool1)
          {
            long l2 = System.currentTimeMillis();
            localObject6 = Long.valueOf(l2);
            ca localca = new com/flurry/sdk/ca;
            int i5 = B();
            long l4 = ((Long)localObject6).longValue();
            str4 = paramString1;
            str5 = paramString2;
            str6 = paramString3;
            localThrowable = paramThrowable;
            localca.<init>(i5, l4, str4, str5, str6, localThrowable);
            localObject5 = this.K;
            ((List)localObject5).set(i9, localca);
            continue;
          }
        }
      }
      finally
      {
      }
      int i3 = i9 + 1;
      int i9 = i3;
      continue;
      label415: String str1 = g;
      Object localObject5 = "Max errors logged. No more errors logged.";
      ex.e(str1, (String)localObject5);
    }
  }

  public void a(String paramString, Map<String, String> paramMap)
  {
    while (true)
    {
      try
      {
        List localList = this.H;
        Iterator localIterator = localList.iterator();
        boolean bool1 = localIterator.hasNext();
        Object localObject1;
        String str1;
        if (bool1)
        {
          localObject1 = localIterator.next();
          localObject1 = (cb)localObject1;
          boolean bool2 = ((cb)localObject1).a(paramString);
          if (!bool2)
            continue;
          long l1 = SystemClock.elapsedRealtime();
          long l2 = this.v;
          l1 -= l2;
          if (paramMap != null)
          {
            int i1 = paramMap.size();
            if (i1 > 0)
            {
              i1 = this.J;
              int i3 = d;
              if (i1 < i3)
              {
                i1 = this.J;
                i3 = ((cb)localObject1).d();
                i1 -= i3;
                HashMap localHashMap = new java/util/HashMap;
                Map localMap1 = ((cb)localObject1).c();
                localHashMap.<init>(localMap1);
                ((cb)localObject1).a(paramMap);
                int i4 = ((cb)localObject1).d();
                i4 += i1;
                int i6 = d;
                if (i4 > i6)
                  break label309;
                Map localMap2 = ((cb)localObject1).c();
                int i5 = localMap2.size();
                i6 = b;
                if (i5 <= i6)
                  continue;
                str1 = g;
                Object localObject3 = new java/lang/StringBuilder;
                ((StringBuilder)localObject3).<init>();
                Object localObject4 = "MaxEventParams exceeded on endEvent: ";
                localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
                localObject4 = ((cb)localObject1).c();
                int i7 = ((Map)localObject4).size();
                localObject3 = ((StringBuilder)localObject3).append(i7);
                localObject3 = ((StringBuilder)localObject3).toString();
                ex.e(str1, (String)localObject3);
                ((cb)localObject1).b(localHashMap);
              }
            }
          }
          ((cb)localObject1).a(l1);
        }
        return;
        str3 = ((cb)localObject1).d();
        str1 += str3;
        this.J = i2;
        continue;
      }
      finally
      {
      }
      label309: localObject2.b(str3);
      int i2 = 0;
      this.I = i2;
      i2 = d;
      this.J = i2;
      String str2 = g;
      String str3 = "Event Log size exceeded. No more event details logged.";
      ex.e(str2, str3);
    }
  }

  public void a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    while (true)
    {
      long l3;
      try
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = this.v;
        l3 = l1 - l2;
        String str4 = fh.a(paramString);
        int i1 = str4.length();
        if (i1 == 0)
          return;
        Object localObject1 = this.G;
        localObject1 = ((Map)localObject1).get(str4);
        localObject1 = (bx.a)localObject1;
        if (localObject1 != null)
          break label399;
        localObject1 = this.G;
        int i2 = ((Map)localObject1).size();
        int i5 = a;
        if (i2 < i5)
        {
          Object localObject2 = new com/flurry/sdk/bx$a;
          ((bx.a)localObject2).<init>();
          i5 = 1;
          ((bx.a)localObject2).a = i5;
          Object localObject5 = this.G;
          ((Map)localObject5).put(str4, localObject2);
          localObject2 = g;
          localObject5 = new java/lang/StringBuilder;
          ((StringBuilder)localObject5).<init>();
          localObject8 = "Event count started: ";
          localObject5 = ((StringBuilder)localObject5).append((String)localObject8);
          localObject5 = ((StringBuilder)localObject5).append(str4);
          localObject5 = ((StringBuilder)localObject5).toString();
          ex.e((String)localObject2, (String)localObject5);
          boolean bool1 = this.B;
          if (!bool1)
            break label618;
          List localList1 = this.H;
          int i3 = localList1.size();
          int i6 = c;
          if (i3 >= i6)
            break label618;
          i3 = this.J;
          i6 = d;
          if (i3 >= i6)
            break label618;
          if (paramMap != null)
            break label630;
          localObject8 = Collections.emptyMap();
          i3 = ((Map)localObject8).size();
          i6 = b;
          if (i3 <= i6)
            break label473;
          String str1 = g;
          localObject6 = new java/lang/StringBuilder;
          ((StringBuilder)localObject6).<init>();
          str4 = "MaxEventParams exceeded: ";
          localObject6 = ((StringBuilder)localObject6).append(str4);
          i10 = ((Map)localObject8).size();
          localObject6 = ((StringBuilder)localObject6).append(i10);
          localObject6 = ((StringBuilder)localObject6).toString();
          ex.e(str1, (String)localObject6);
          continue;
        }
      }
      finally
      {
      }
      Object localObject4 = g;
      Object localObject6 = new java/lang/StringBuilder;
      ((StringBuilder)localObject6).<init>();
      Object localObject8 = "Too many different events. Event not counted: ";
      localObject6 = ((StringBuilder)localObject6).append((String)localObject8);
      localObject6 = ((StringBuilder)localObject6).append(i10);
      localObject6 = ((StringBuilder)localObject6).toString();
      ex.e((String)localObject4, (String)localObject6);
      continue;
      label399: int i7 = ((bx.a)localObject4).a;
      i7 += 1;
      ((bx.a)localObject4).a = i7;
      localObject4 = g;
      Object localObject7 = new java/lang/StringBuilder;
      ((StringBuilder)localObject7).<init>();
      localObject8 = "Event count incremented: ";
      localObject7 = ((StringBuilder)localObject7).append((String)localObject8);
      localObject7 = ((StringBuilder)localObject7).append(i10);
      localObject7 = ((StringBuilder)localObject7).toString();
      ex.e((String)localObject4, (String)localObject7);
      continue;
      label473: localObject4 = new com/flurry/sdk/cb;
      int i8 = A();
      boolean bool3 = paramBoolean;
      ((cb)localObject4).<init>(i8, i10, (Map)localObject8, l3, bool3);
      i8 = ((cb)localObject4).d();
      int i10 = this.J;
      i8 += i10;
      i10 = d;
      int i4;
      if (i8 <= i10)
      {
        List localList2 = this.H;
        localList2.add(localObject4);
        int i9 = this.J;
        i4 = ((cb)localObject4).d();
        i4 += i9;
        this.J = i4;
      }
      else
      {
        i4 = d;
        this.J = i4;
        i4 = 0;
        this.I = i4;
        String str2 = g;
        String str3 = "Event Log size exceeded. No more event details logged.";
        ex.e(str2, str3);
        continue;
        label618: boolean bool2 = false;
        this.I = bool2;
        continue;
        label630: localObject8 = paramMap;
      }
    }
  }

  public void a(Map<String, List<String>> paramMap)
  {
    this.O = paramMap;
  }

  private void a(byte[] paramArrayOfByte)
  {
    Object localObject1 = bx.a();
    localObject1 = ((bx)localObject1).o();
    Object localObject2 = new java/lang/StringBuilder;
    ((StringBuilder)localObject2).<init>();
    Object localObject3 = "";
    localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
    localObject3 = bx.a();
    int i1 = ((bx)localObject3).b();
    localObject2 = ((StringBuilder)localObject2).append(i1);
    localObject2 = ((StringBuilder)localObject2).toString();
    String str = this.m;
    ((cd)localObject1).b(paramArrayOfByte, str, (String)localObject2);
  }

  static boolean a(cl paramcl)
  {
    boolean bool = paramcl.l;
    return bool;
  }

  static List b(cl paramcl)
  {
    List localList = paramcl.s;
    return localList;
  }

  public void b()
  {
    boolean bool = true;
    this.q = bool;
  }

  private void b(Context paramContext)
  {
    try
    {
      try
      {
        List localList = this.s;
        int i1 = localList.size();
        if (i1 > 0);
        for (i1 = 1; ; i1 = 0)
        {
          if (i1 != 0)
            c(paramContext);
          return;
        }
      }
      finally
      {
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        int i2 = 6;
        String str1 = g;
        String str2 = "";
        ex.a(i2, str1, str2, localThrowable);
      }
    }
  }

  static void b(cl paramcl, Context paramContext)
  {
    paramcl.a(paramContext);
  }

  public void c()
  {
    try
    {
      cn localcn1 = this.Q;
      boolean bool1 = localcn1.b();
      if (bool1)
      {
        cn localcn2 = this.Q;
        localcn2.a();
      }
      x();
      boolean bool2 = this.T;
      if (!bool2)
      {
        s();
        bool2 = true;
        this.T = bool2;
      }
      while (true)
      {
        return;
        t();
      }
    }
    finally
    {
    }
  }

  private void c(Context paramContext)
  {
    int i1 = 3;
    try
    {
      Object localObject3 = g;
      localObject4 = "generating agent report";
      ex.a(i1, (String)localObject3, (String)localObject4);
      localObject3 = new com/flurry/sdk/cc;
      cl localcl = this;
      localObject4 = localcl.m;
      localcl = this;
      localObject5 = localcl.n;
      Object localObject6 = C();
      localcl = this;
      boolean bool1 = localcl.q;
      localcl = this;
      long l1 = localcl.r;
      localcl = this;
      long l2 = localcl.u;
      localcl = this;
      List localList = localcl.s;
      localcl = this;
      Map localMap1 = localcl.p;
      localcl = this;
      Object localObject1 = localcl.N;
      boolean bool2 = false;
      Map localMap2 = ((by)localObject1).a(bool2);
      Map localMap3 = a();
      long l3 = System.currentTimeMillis();
      ((cc)localObject3).<init>((String)localObject4, (String)localObject5, (String)localObject6, bool1, l1, l2, localList, localMap1, localMap2, localMap3, l3);
      localObject1 = new java/util/ArrayList;
      localcl = this;
      localObject4 = localcl.s;
      ((ArrayList)localObject1).<init>((Collection)localObject4);
      localcl = this;
      localcl.o = ((List)localObject1);
      Object localObject2;
      if (localObject3 != null)
      {
        localObject1 = ((cc)localObject3).a();
        if (localObject1 != null)
        {
          int i2 = 3;
          localObject4 = g;
          localObject5 = new java/lang/StringBuilder;
          ((StringBuilder)localObject5).<init>();
          localObject6 = "generated report of size ";
          localObject5 = ((StringBuilder)localObject5).append((String)localObject6);
          localObject6 = ((cc)localObject3).a();
          int i4 = localObject6.length;
          localObject5 = ((StringBuilder)localObject5).append(i4);
          Object localObject7 = " with ";
          localObject5 = ((StringBuilder)localObject5).append((String)localObject7);
          localcl = this;
          localObject7 = localcl.s;
          int i5 = ((List)localObject7).size();
          localObject5 = ((StringBuilder)localObject5).append(i5);
          String str = " reports.";
          localObject5 = ((StringBuilder)localObject5).append(str);
          localObject5 = ((StringBuilder)localObject5).toString();
          ex.a(i2, (String)localObject4, (String)localObject5);
          localObject2 = ((cc)localObject3).a();
          localcl = this;
          localcl.a((byte[])localObject2);
          localcl = this;
          localObject2 = localcl.s;
          localcl = this;
          localObject3 = localcl.o;
          ((List)localObject2).removeAll((Collection)localObject3);
          localObject2 = null;
          localcl = this;
          localcl.o = ((List)localObject2);
          w();
        }
      }
      while (true)
      {
        return;
        localObject2 = g;
        localObject3 = "Error generating report";
        ex.e((String)localObject2, (String)localObject3);
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        int i3 = 6;
        Object localObject4 = g;
        Object localObject5 = "";
        ex.a(i3, (String)localObject4, (String)localObject5, localThrowable);
      }
    }
  }

  static void c(cl paramcl)
  {
    paramcl.w();
  }

  static void c(cl paramcl, Context paramContext)
  {
    paramcl.b(paramContext);
  }

  public void d()
  {
    try
    {
      String str1 = g;
      String str2 = "Trying to end session";
      ex.e(str1, str2);
      boolean bool = this.T;
      if (!bool);
      while (true)
      {
        return;
        int i1 = i();
        if (i1 > 0)
          y();
        i1 = i();
        if (i1 == 0)
        {
          cn localcn = this.Q;
          long l1 = this.F;
          localcn.a(l1);
        }
      }
    }
    finally
    {
    }
  }

  // ERROR //
  private void d(Context paramContext)
  {
    // Byte code:
    //   0: nop
    //   1: aload_0
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 586	com/flurry/sdk/cl:k	Ljava/io/File;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 285	java/io/File:exists	()Z
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +345 -> 359
    //   17: iconst_4
    //   18: istore_2
    //   19: getstatic 378	com/flurry/sdk/cl:g	Ljava/lang/String;
    //   22: astore_3
    //   23: new 797	java/lang/StringBuilder
    //   26: astore 4
    //   28: aload 4
    //   30: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 794
    //   36: astore 5
    //   38: aload 4
    //   40: aload 5
    //   42: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: astore 4
    //   47: aload_0
    //   48: getfield 586	com/flurry/sdk/cl:k	Ljava/io/File;
    //   51: astore 5
    //   53: aload 5
    //   55: invokevirtual 301	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   58: astore 5
    //   60: aload 4
    //   62: aload 5
    //   64: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: astore 4
    //   69: aload 4
    //   71: invokevirtual 789	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 4
    //   76: iload_2
    //   77: aload_3
    //   78: aload 4
    //   80: invokestatic 709	com/flurry/sdk/ex:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   83: aconst_null
    //   84: astore 4
    //   86: new 270	java/io/FileInputStream
    //   89: astore_2
    //   90: aload_0
    //   91: getfield 586	com/flurry/sdk/cl:k	Ljava/io/File;
    //   94: astore_3
    //   95: aload_2
    //   96: aload_3
    //   97: invokespecial 594	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   100: new 84	java/io/DataInputStream
    //   103: astore_3
    //   104: aload_3
    //   105: aload_2
    //   106: invokespecial 288	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   109: new 148	com/flurry/sdk/cm
    //   112: astore_2
    //   113: aload_2
    //   114: invokespecial 545	com/flurry/sdk/cm:<init>	()V
    //   117: aload_0
    //   118: getfield 107	com/flurry/sdk/cl:m	Ljava/lang/String;
    //   121: astore 4
    //   123: aload_2
    //   124: aload_3
    //   125: aload 4
    //   127: invokevirtual 24	com/flurry/sdk/cm:a	(Ljava/io/DataInputStream;Ljava/lang/String;)Z
    //   130: istore 4
    //   132: aload_0
    //   133: iload 4
    //   135: putfield 37	com/flurry/sdk/cl:l	Z
    //   138: aload_0
    //   139: getfield 37	com/flurry/sdk/cl:l	Z
    //   142: istore 4
    //   144: iload 4
    //   146: ifeq +37 -> 183
    //   149: aload_2
    //   150: invokevirtual 410	com/flurry/sdk/cm:a	()Z
    //   153: istore 4
    //   155: aload_0
    //   156: iload 4
    //   158: putfield 694	com/flurry/sdk/cl:q	Z
    //   161: aload_2
    //   162: invokevirtual 154	com/flurry/sdk/cm:c	()J
    //   165: lstore 4
    //   167: aload_0
    //   168: lload 4
    //   170: putfield 474	com/flurry/sdk/cl:r	J
    //   173: aload_2
    //   174: invokevirtual 700	com/flurry/sdk/cm:b	()Ljava/util/List;
    //   177: astore_2
    //   178: aload_0
    //   179: aload_2
    //   180: putfield 466	com/flurry/sdk/cl:s	Ljava/util/List;
    //   183: aload_3
    //   184: invokestatic 688	com/flurry/sdk/fh:a	(Ljava/io/Closeable;)V
    //   187: aload_0
    //   188: getfield 37	com/flurry/sdk/cl:l	Z
    //   191: istore_2
    //   192: iload_2
    //   193: ifne +35 -> 228
    //   196: aload_0
    //   197: getfield 586	com/flurry/sdk/cl:k	Ljava/io/File;
    //   200: astore_2
    //   201: aload_2
    //   202: invokevirtual 507	java/io/File:delete	()Z
    //   205: istore_2
    //   206: iload_2
    //   207: ifeq +105 -> 312
    //   210: iconst_3
    //   211: istore_2
    //   212: getstatic 378	com/flurry/sdk/cl:g	Ljava/lang/String;
    //   215: astore_3
    //   216: ldc_w 475
    //   219: astore 4
    //   221: iload_2
    //   222: aload_3
    //   223: aload 4
    //   225: invokestatic 709	com/flurry/sdk/ex:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   228: aload_0
    //   229: getfield 37	com/flurry/sdk/cl:l	Z
    //   232: istore_2
    //   233: iload_2
    //   234: ifne +27 -> 261
    //   237: iconst_0
    //   238: istore_2
    //   239: aload_0
    //   240: iload_2
    //   241: putfield 694	com/flurry/sdk/cl:q	Z
    //   244: aload_0
    //   245: getfield 10	com/flurry/sdk/cl:u	J
    //   248: lstore_2
    //   249: aload_0
    //   250: lload_2
    //   251: putfield 474	com/flurry/sdk/cl:r	J
    //   254: iconst_1
    //   255: istore_2
    //   256: aload_0
    //   257: iload_2
    //   258: putfield 37	com/flurry/sdk/cl:l	Z
    //   261: aload_0
    //   262: monitorexit
    //   263: return
    //   264: astore_2
    //   265: aload_2
    //   266: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   269: goto -86 -> 183
    //   272: astore_2
    //   273: getstatic 378	com/flurry/sdk/cl:g	Ljava/lang/String;
    //   276: astore 4
    //   278: ldc 215
    //   280: astore 5
    //   282: aload 4
    //   284: aload 5
    //   286: aload_2
    //   287: invokestatic 464	com/flurry/sdk/ex:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   290: aload_3
    //   291: invokestatic 688	com/flurry/sdk/fh:a	(Ljava/io/Closeable;)V
    //   294: goto -107 -> 187
    //   297: astore_2
    //   298: aload_0
    //   299: monitorexit
    //   300: aload_2
    //   301: athrow
    //   302: astore_2
    //   303: aload 4
    //   305: astore_3
    //   306: aload_3
    //   307: invokestatic 688	com/flurry/sdk/fh:a	(Ljava/io/Closeable;)V
    //   310: aload_2
    //   311: athrow
    //   312: bipush 6
    //   314: istore_2
    //   315: getstatic 378	com/flurry/sdk/cl:g	Ljava/lang/String;
    //   318: astore_3
    //   319: ldc_w 711
    //   322: astore 4
    //   324: iload_2
    //   325: aload_3
    //   326: aload 4
    //   328: invokestatic 709	com/flurry/sdk/ex:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   331: goto -103 -> 228
    //   334: astore_2
    //   335: bipush 6
    //   337: istore_3
    //   338: getstatic 378	com/flurry/sdk/cl:g	Ljava/lang/String;
    //   341: astore 4
    //   343: ldc 41
    //   345: astore 5
    //   347: iload_3
    //   348: aload 4
    //   350: aload 5
    //   352: aload_2
    //   353: invokestatic 519	com/flurry/sdk/ex:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   356: goto -128 -> 228
    //   359: iconst_4
    //   360: istore_2
    //   361: getstatic 378	com/flurry/sdk/cl:g	Ljava/lang/String;
    //   364: astore_3
    //   365: ldc_w 790
    //   368: astore 4
    //   370: iload_2
    //   371: aload_3
    //   372: aload 4
    //   374: invokestatic 709	com/flurry/sdk/ex:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   377: goto -149 -> 228
    //   380: astore_2
    //   381: goto -75 -> 306
    //   384: astore_2
    //   385: aload 4
    //   387: astore_3
    //   388: goto -115 -> 273
    //   391: nop
    //
    // Exception table:
    //   from	to	target	type
    //   109	113	264	java/io/IOException
    //   117	123	264	java/io/IOException
    //   132	138	264	java/io/IOException
    //   149	153	264	java/io/IOException
    //   155	161	264	java/io/IOException
    //   167	173	264	java/io/IOException
    //   178	183	264	java/io/IOException
    //   109	113	272	java/lang/Throwable
    //   117	123	272	java/lang/Throwable
    //   132	138	272	java/lang/Throwable
    //   149	153	272	java/lang/Throwable
    //   155	161	272	java/lang/Throwable
    //   167	173	272	java/lang/Throwable
    //   178	183	272	java/lang/Throwable
    //   265	269	272	java/lang/Throwable
    //   3	8	297	finally
    //   19	23	297	finally
    //   28	33	297	finally
    //   38	45	297	finally
    //   47	53	297	finally
    //   60	67	297	finally
    //   69	74	297	finally
    //   76	83	297	finally
    //   183	187	297	finally
    //   187	192	297	finally
    //   196	201	297	finally
    //   212	216	297	finally
    //   221	228	297	finally
    //   228	233	297	finally
    //   239	244	297	finally
    //   249	254	297	finally
    //   256	261	297	finally
    //   290	294	297	finally
    //   306	310	297	finally
    //   315	319	297	finally
    //   324	331	297	finally
    //   338	343	297	finally
    //   347	356	297	finally
    //   361	365	297	finally
    //   370	377	297	finally
    //   86	90	302	finally
    //   95	100	302	finally
    //   104	109	302	finally
    //   187	192	334	java/lang/Throwable
    //   196	201	334	java/lang/Throwable
    //   212	216	334	java/lang/Throwable
    //   221	228	334	java/lang/Throwable
    //   315	319	334	java/lang/Throwable
    //   324	331	334	java/lang/Throwable
    //   109	113	380	finally
    //   117	123	380	finally
    //   132	138	380	finally
    //   149	153	380	finally
    //   155	161	380	finally
    //   167	173	380	finally
    //   178	183	380	finally
    //   265	269	380	finally
    //   273	278	380	finally
    //   282	290	380	finally
    //   86	90	384	java/lang/Throwable
    //   95	100	384	java/lang/Throwable
    //   104	109	384	java/lang/Throwable
  }

  public void e()
  {
    try
    {
      int i1 = i();
      String str2;
      if (i1 != 0)
      {
        i1 = 6;
        str2 = g;
        Object localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        String str3 = "Error! Session with apiKey = ";
        localObject3 = ((StringBuilder)localObject3).append(str3);
        str3 = k();
        localObject3 = ((StringBuilder)localObject3).append(str3);
        str3 = " was ended while getSessionCount() is not 0";
        localObject3 = ((StringBuilder)localObject3).append(str3);
        localObject3 = ((StringBuilder)localObject3).toString();
        ex.a(i1, str2, (String)localObject3);
      }
      boolean bool1 = this.T;
      if (!bool1);
      while (true)
      {
        return;
        String str1 = g;
        str2 = "Ending session";
        ex.e(str1, str2);
        int i2 = 0;
        this.S = i2;
        cn localcn1 = this.Q;
        boolean bool2 = localcn1.b();
        if (bool2)
        {
          cn localcn2 = this.Q;
          localcn2.a();
        }
        long l1 = SystemClock.elapsedRealtime();
        long l2 = this.v;
        l1 -= l2;
        this.w = l1;
        l1 = this.w;
        a(l1);
        v();
        Object localObject1 = this.R;
        if (localObject1 != null)
        {
          localObject1 = this.R;
          str2 = k();
          ((cl.a)localObject1).d(str2);
        }
        localObject1 = eh.a();
        str2 = "Gender";
        ((ei)localObject1).b(str2, this);
        localObject1 = eh.a();
        str2 = "UserId";
        ((ei)localObject1).b(str2, this);
        localObject1 = eh.a();
        str2 = "Age";
        ((ei)localObject1).b(str2, this);
        localObject1 = eh.a();
        str2 = "LogEvents";
        ((ei)localObject1).b(str2, this);
        localObject1 = eh.a();
        str2 = "ContinueSessionMillis";
        ((ei)localObject1).b(str2, this);
        localObject1 = this.P;
        localObject1 = ((Handler)localObject1).getLooper();
        ((Looper)localObject1).quit();
      }
    }
    finally
    {
    }
  }

  cj f()
  {
    try
    {
      Object localObject5 = new com/flurry/sdk/ck;
      ((ck)localObject5).<init>();
      String str1 = this.n;
      ((ck)localObject5).a(str1);
      long l1 = this.u;
      ((ck)localObject5).a(l1);
      l1 = this.w;
      ((ck)localObject5).b(l1);
      l1 = this.x;
      ((ck)localObject5).c(l1);
      String str2 = l();
      ((ck)localObject5).b(str2);
      str2 = m();
      ((ck)localObject5).c(str2);
      int i1 = this.A;
      ((ck)localObject5).a(i1);
      Object localObject1 = j();
      ((ck)localObject5).d((String)localObject1);
      localObject1 = D();
      ((ck)localObject5).a((Location)localObject1);
      int i2 = h();
      ((ck)localObject5).b(i2);
      i2 = this.D;
      ((ck)localObject5).a(i2);
      long l2 = this.E;
      Object localObject2 = Long.valueOf(l2);
      ((ck)localObject5).a((Long)localObject2);
      localObject2 = q();
      ((ck)localObject5).a((Map)localObject2);
      localObject2 = o();
      ((ck)localObject5).a((List)localObject2);
      boolean bool = this.I;
      ((ck)localObject5).a(bool);
      List localList = p();
      ((ck)localObject5).b(localList);
      int i3 = this.L;
      ((ck)localObject5).c(i3);
      String str3 = null;
      try
      {
        cj localcj = new com/flurry/sdk/cj;
        localcj.<init>((ck)localObject5);
        if (localcj == null)
        {
          str3 = g;
          localObject5 = "New session report wasn't created";
          ex.e(str3, (String)localObject5);
        }
        return localcj;
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          localIOException.printStackTrace();
          Object localObject3 = str3;
        }
      }
    }
    finally
    {
    }
  }

  int h()
  {
    int i1 = this.M;
    return i1;
  }

  int i()
  {
    int i1 = this.S;
    return i1;
  }

  String j()
  {
    String str = this.C;
    if (str == null);
    for (str = ""; ; str = this.C)
      return str;
  }

  public String k()
  {
    String str = this.m;
    return str;
  }

  public String l()
  {
    String str = this.y;
    return str;
  }

  public String m()
  {
    String str = this.z;
    return str;
  }

  public void n()
  {
    e();
  }

  List<cb> o()
  {
    List localList = this.H;
    return localList;
  }

  List<ca> p()
  {
    List localList = this.K;
    return localList;
  }

  Map<String, bx.a> q()
  {
    Map localMap = this.G;
    return localMap;
  }

  private void r()
  {
    int i2 = 4;
    Object localObject4 = eh.a();
    Object localObject1 = "Gender";
    localObject1 = ((ei)localObject4).a((String)localObject1);
    localObject1 = (Byte)localObject1;
    byte b1 = ((Byte)localObject1).byteValue();
    this.D = b1;
    Object localObject2 = "Gender";
    ((ei)localObject4).a((String)localObject2, this);
    localObject2 = g;
    Object localObject5 = new java/lang/StringBuilder;
    ((StringBuilder)localObject5).<init>();
    String str2 = "initSettings, Gender = ";
    localObject5 = ((StringBuilder)localObject5).append(str2);
    int i1 = this.D;
    localObject5 = ((StringBuilder)localObject5).append(i1);
    localObject5 = ((StringBuilder)localObject5).toString();
    ex.a(i2, (String)localObject2, (String)localObject5);
    localObject2 = "UserId";
    localObject2 = ((ei)localObject4).a((String)localObject2);
    localObject2 = (String)localObject2;
    this.C = ((String)localObject2);
    localObject2 = "UserId";
    ((ei)localObject4).a((String)localObject2, this);
    localObject2 = g;
    localObject5 = new java/lang/StringBuilder;
    ((StringBuilder)localObject5).<init>();
    String str3 = "initSettings, UserId = ";
    localObject5 = ((StringBuilder)localObject5).append(str3);
    str3 = this.C;
    localObject5 = ((StringBuilder)localObject5).append(str3);
    localObject5 = ((StringBuilder)localObject5).toString();
    ex.a(i2, (String)localObject2, (String)localObject5);
    localObject2 = "LogEvents";
    localObject2 = ((ei)localObject4).a((String)localObject2);
    localObject2 = (Boolean)localObject2;
    boolean bool1 = ((Boolean)localObject2).booleanValue();
    this.B = bool1;
    Object localObject3 = "LogEvents";
    ((ei)localObject4).a((String)localObject3, this);
    localObject3 = g;
    localObject5 = new java/lang/StringBuilder;
    ((StringBuilder)localObject5).<init>();
    str3 = "initSettings, LogEvents = ";
    localObject5 = ((StringBuilder)localObject5).append(str3);
    boolean bool2 = this.B;
    localObject5 = ((StringBuilder)localObject5).append(bool2);
    localObject5 = ((StringBuilder)localObject5).toString();
    ex.a(i2, (String)localObject3, (String)localObject5);
    localObject3 = "Age";
    localObject3 = ((ei)localObject4).a((String)localObject3);
    localObject3 = (Long)localObject3;
    long l1 = ((Long)localObject3).longValue();
    this.E = l1;
    localObject3 = "Age";
    ((ei)localObject4).a((String)localObject3, this);
    localObject3 = g;
    Object localObject6 = new java/lang/StringBuilder;
    ((StringBuilder)localObject6).<init>();
    String str4 = "initSettings, BirthDate = ";
    localObject6 = ((StringBuilder)localObject6).append(str4);
    long l4 = this.E;
    localObject6 = ((StringBuilder)localObject6).append(l4);
    localObject6 = ((StringBuilder)localObject6).toString();
    ex.a(i2, (String)localObject3, (String)localObject6);
    localObject3 = "ContinueSessionMillis";
    localObject3 = ((ei)localObject4).a((String)localObject3);
    localObject3 = (Long)localObject3;
    long l2 = ((Long)localObject3).longValue();
    this.F = l2;
    localObject3 = "ContinueSessionMillis";
    ((ei)localObject4).a((String)localObject3, this);
    localObject3 = g;
    localObject4 = new java/lang/StringBuilder;
    ((StringBuilder)localObject4).<init>();
    String str1 = "initSettings, ContinueSessionMillis = ";
    localObject4 = ((StringBuilder)localObject4).append(str1);
    long l3 = this.F;
    localObject4 = ((StringBuilder)localObject4).append(l3);
    localObject4 = ((StringBuilder)localObject4).toString();
    ex.a(i2, (String)localObject3, (String)localObject4);
  }

  private void s()
  {
    String str1 = g;
    String str2 = "Start session";
    ex.e(str1, str2);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = System.currentTimeMillis();
    this.u = l2;
    this.v = l1;
    cl.1 local1 = new com/flurry/sdk/cl$1;
    local1.<init>(this);
    a(local1);
  }

  private void t()
  {
    Object localObject1 = g;
    Object localObject2 = "Continuing previous session";
    ex.e((String)localObject1, (String)localObject2);
    localObject1 = this.s;
    boolean bool = ((List)localObject1).isEmpty();
    if (!bool)
    {
      List localList = this.s;
      localObject2 = this.s;
      int i1 = ((List)localObject2).size();
      i1 += -1;
      localList.remove(i1);
    }
  }

  private void u()
  {
    String str = this.t;
    boolean bool = TextUtils.isEmpty(str);
    if (bool)
    {
      cl.2 local2 = new com/flurry/sdk/cl$2;
      local2.<init>(this);
      a(local2);
    }
  }

  private void v()
  {
    Object localObject = eg.a();
    localObject = ((eg)localObject).b();
    cl.3 local3 = new com/flurry/sdk/cl$3;
    local3.<init>(this, (Context)localObject);
    a(local3);
  }

  // ERROR //
  private void w()
  {
    // Byte code:
    //   0: nop
    //   1: aload_0
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 586	com/flurry/sdk/cl:k	Ljava/io/File;
    //   7: astore_1
    //   8: aload_1
    //   9: invokestatic 323	com/flurry/sdk/et:a	(Ljava/io/File;)Z
    //   12: istore_1
    //   13: iload_1
    //   14: ifne +18 -> 32
    //   17: getstatic 378	com/flurry/sdk/cl:g	Ljava/lang/String;
    //   20: astore_1
    //   21: ldc 140
    //   23: astore_2
    //   24: aload_1
    //   25: aload_2
    //   26: invokestatic 706	com/flurry/sdk/ex:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: new 185	java/io/FileOutputStream
    //   35: astore_1
    //   36: aload_0
    //   37: getfield 586	com/flurry/sdk/cl:k	Ljava/io/File;
    //   40: astore_2
    //   41: aload_1
    //   42: aload_2
    //   43: invokespecial 388	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   46: new 571	java/io/DataOutputStream
    //   49: astore_2
    //   50: aload_2
    //   51: aload_1
    //   52: invokespecial 619	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   55: new 148	com/flurry/sdk/cm
    //   58: astore_1
    //   59: aload_1
    //   60: invokespecial 545	com/flurry/sdk/cm:<init>	()V
    //   63: aload_0
    //   64: getfield 694	com/flurry/sdk/cl:q	Z
    //   67: istore_3
    //   68: aload_1
    //   69: iload_3
    //   70: invokevirtual 46	com/flurry/sdk/cm:a	(Z)V
    //   73: aload_0
    //   74: getfield 474	com/flurry/sdk/cl:r	J
    //   77: lstore_3
    //   78: aload_1
    //   79: lload_3
    //   80: invokevirtual 63	com/flurry/sdk/cm:a	(J)V
    //   83: aload_0
    //   84: getfield 466	com/flurry/sdk/cl:s	Ljava/util/List;
    //   87: astore_3
    //   88: aload_1
    //   89: aload_3
    //   90: invokevirtual 173	com/flurry/sdk/cm:a	(Ljava/util/List;)V
    //   93: aload_0
    //   94: getfield 107	com/flurry/sdk/cl:m	Ljava/lang/String;
    //   97: astore_3
    //   98: aload_0
    //   99: invokespecial 685	com/flurry/sdk/cl:C	()Ljava/lang/String;
    //   102: astore 4
    //   104: aload_1
    //   105: aload_2
    //   106: aload_3
    //   107: aload 4
    //   109: invokevirtual 620	com/flurry/sdk/cm:a	(Ljava/io/DataOutputStream;Ljava/lang/String;Ljava/lang/String;)V
    //   112: goto -83 -> 29
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 313	java/io/FileNotFoundException:printStackTrace	()V
    //   120: goto -91 -> 29
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   133: goto -104 -> 29
    //   136: nop
    //
    // Exception table:
    //   from	to	target	type
    //   32	36	115	java/io/FileNotFoundException
    //   41	46	115	java/io/FileNotFoundException
    //   50	55	115	java/io/FileNotFoundException
    //   59	63	115	java/io/FileNotFoundException
    //   68	73	115	java/io/FileNotFoundException
    //   78	83	115	java/io/FileNotFoundException
    //   88	93	115	java/io/FileNotFoundException
    //   98	102	115	java/io/FileNotFoundException
    //   104	112	115	java/io/FileNotFoundException
    //   3	8	123	finally
    //   17	21	123	finally
    //   24	29	123	finally
    //   32	36	123	finally
    //   41	46	123	finally
    //   50	55	123	finally
    //   59	63	123	finally
    //   68	73	123	finally
    //   78	83	123	finally
    //   88	93	123	finally
    //   98	102	123	finally
    //   104	112	123	finally
    //   116	120	123	finally
    //   129	133	123	finally
    //   32	36	128	java/io/IOException
    //   41	46	128	java/io/IOException
    //   50	55	128	java/io/IOException
    //   59	63	128	java/io/IOException
    //   68	73	128	java/io/IOException
    //   78	83	128	java/io/IOException
    //   88	93	128	java/io/IOException
    //   98	102	128	java/io/IOException
    //   104	112	128	java/io/IOException
  }

  private void x()
  {
    int i1 = this.S;
    i1 += 1;
    this.S = i1;
  }

  private void y()
  {
    int i1 = this.S;
    i1 += -1;
    this.S = i1;
  }

  private String z()
  {
    Object localObject = new java/lang/StringBuilder;
    ((StringBuilder)localObject).<init>();
    String str1 = ".flurryagent.";
    localObject = ((StringBuilder)localObject).append(str1);
    str1 = this.m;
    int i1 = str1.hashCode();
    int i2 = 16;
    String str2 = Integer.toString(i1, i2);
    localObject = ((StringBuilder)localObject).append(str2);
    localObject = ((StringBuilder)localObject).toString();
    return localObject;
  }
}

/* Location:           /home/gagan/Desktop/Output2/Venmo/retargeted/com.venmo_6.7.2_[www.apk-dl.com]/
 * Qualified Name:     com.flurry.sdk.cl
 * JD-Core Version:    0.6.2
 */
package org.keyczar;

import java.util.concurrent.ConcurrentHashMap;
import org.keyczar.interfaces.Stream;

final class StreamCache<T extends Stream>
{
  private final ConcurrentHashMap cacheMap;

  StreamCache()
  {
    ConcurrentHashMap localConcurrentHashMap = new java/util/concurrent/ConcurrentHashMap;
    localConcurrentHashMap.<init>();
    this.cacheMap = localConcurrentHashMap;
  }

  final T get(KeyczarKey paramKeyczarKey)
  {
    Object localObject = getQueue(paramKeyczarKey);
    localObject = ((StreamQueue)localObject).poll();
    localObject = (Stream)localObject;
    return localObject;
  }

  private StreamQueue<T> getQueue(KeyczarKey paramKeyczarKey)
  {
    ConcurrentHashMap localConcurrentHashMap = this.cacheMap;
    Object localObject2 = localConcurrentHashMap.get(paramKeyczarKey);
    localObject2 = (StreamQueue)localObject2;
    Object localObject1;
    if (localObject2 != null)
      localObject1 = localObject2;
    while (true)
    {
      return localObject1;
      localObject1 = new org/keyczar/StreamQueue;
      ((StreamQueue)localObject1).<init>();
      localConcurrentHashMap = this.cacheMap;
      localObject2 = localConcurrentHashMap.putIfAbsent(paramKeyczarKey, localObject1);
      localObject2 = (StreamQueue)localObject2;
      if (localObject2 != null)
        localObject1 = localObject2;
    }
  }

  final void put(KeyczarKey paramKeyczarKey, T paramT)
  {
    StreamQueue localStreamQueue = getQueue(paramKeyczarKey);
    localStreamQueue.add(paramT);
  }
}

/* Location:           /home/gagan/Desktop/Output2/GoogleWallet/retargeted/com.google.android.apps.walletnfcrel-9.0-R206-v12-920612400-minAPI15/
 * Qualified Name:     org.keyczar.StreamCache
 * JD-Core Version:    0.6.2
 */
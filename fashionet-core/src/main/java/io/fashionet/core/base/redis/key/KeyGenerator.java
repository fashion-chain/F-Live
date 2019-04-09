package io.fashionet.core.base.redis.key;

import io.fashionet.core.base.redis.RedisOperator;

public interface KeyGenerator<K, V> {
    K generateKey(RedisOperator operator);

    K key(V instance);
}

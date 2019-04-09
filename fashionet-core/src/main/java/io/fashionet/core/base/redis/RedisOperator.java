package io.fashionet.core.base.redis;

import org.springframework.data.redis.core.*;

public interface RedisOperator<K, HK, V> {
    RedisTemplate<K, V> getRedisTemplate();

    ZSetOperations<K, V> opsForZSet();

    SetOperations<K, V> opsForSet();

    HashOperations<K, HK, V> opsForHash();

    ValueOperations<K, V> opsForValue();

    ListOperations<K, V> opsForList();
}

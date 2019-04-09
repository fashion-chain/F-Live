package io.fashionet.core.base.redis;

import org.springframework.data.redis.core.*;

public abstract class RedisOperatorBase<K, HK, V> implements RedisOperator<K, HK, V> {
    private RedisTemplate<K, V> redisTemplate;

    public RedisOperatorBase(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public RedisTemplate<K, V> getRedisTemplate() {
        return redisTemplate;
    }

    @Override
    public ListOperations<K, V> opsForList() {
        return redisTemplate.opsForList();
    }

    @Override
    public ZSetOperations<K, V> opsForZSet() {
        return redisTemplate.opsForZSet();
    }

    @Override
    public SetOperations<K, V> opsForSet() {
        return redisTemplate.opsForSet();
    }

    @Override
    public HashOperations<K, HK, V> opsForHash() {
        return redisTemplate.opsForHash();
    }

    @Override
    public ValueOperations<K, V> opsForValue() {
        return redisTemplate.opsForValue();
    }
}

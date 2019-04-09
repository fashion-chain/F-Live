package io.fashionet.core.base.redis;

import com.sun.javafx.binding.StringFormatter;
import io.fashionet.core.base.redis.exception.RedisOperatorEngineKeyExistsException;
import io.fashionet.core.base.redis.exception.RedisOperatorEngineKeyNotFoundException;
import io.fashionet.core.base.redis.key.KeyGenerator;
import io.fashionet.core.base.utils.CommonUtil;

import java.util.HashMap;

public class RedisOperatorEngine {
    private HashMap<Class, RedisOperator> redisTemplateMapper;
    private HashMap<Class, KeyGenerator> redisKeyMapper;

    public RedisOperatorEngine() {
        this.redisTemplateMapper = new HashMap<>();
        this.redisKeyMapper = new HashMap<>();
    }

    public void registerRedisOperator(Class clazz, RedisOperator redisOperator, KeyGenerator keyGenerator) throws Exception {
        if (this.redisTemplateMapper.containsKey(clazz) || this.redisKeyMapper.containsKey(clazz)) {
            throw new RedisOperatorEngineKeyExistsException(StringFormatter
                    .format("redis operator engine key: %s registered exception",
                            CommonUtil.getClassName(clazz)).getValue());
        }
        this.redisTemplateMapper.put(clazz, redisOperator);
        this.redisKeyMapper.put(clazz, keyGenerator);
    }

    public RedisOperator getRedisOperator(Class clazz) throws Exception {
        if (!this.redisTemplateMapper.containsKey(clazz)) {
            throw new RedisOperatorEngineKeyNotFoundException(StringFormatter
                    .format("redis operator engine key: %s not exist exception",
                            CommonUtil.getClassName(clazz)).getValue());
        }
        return this.redisTemplateMapper.get(clazz);
    }

    public KeyGenerator getKeyGenerator(Class clazz) throws Exception {
        if (!this.redisKeyMapper.containsKey(clazz)) {
            throw new RedisOperatorEngineKeyNotFoundException(StringFormatter
                    .format("redis key generator for key: %s not exist exception",
                            CommonUtil.getClassName(clazz)).getValue());
        }
        return this.redisKeyMapper.get(clazz);
    }
}

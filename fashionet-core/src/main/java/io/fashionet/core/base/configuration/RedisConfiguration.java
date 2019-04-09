package io.fashionet.core.base.configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fashionet.core.base.redis.RedisOperatorEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@PropertySource(value={"classpath:application.yml"},
        ignoreResourceNotFound=false,
        encoding="UTF-8")
public class RedisConfiguration {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public LettuceConnectionFactory redisConnectionFactory(@Value("${spring.redis.host}")String host,
                                                           @Value("${spring.redis.port}")int port) {
        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration(host, port);
        return new LettuceConnectionFactory(rsc);
    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration rcc = RedisCacheConfiguration.defaultCacheConfig();
        return RedisCacheManager.RedisCacheManagerBuilder.fromCacheWriter(RedisCacheWriter.lockingRedisCacheWriter(connectionFactory))
                .cacheDefaults(rcc)
                .build();
    }

    @Bean
    public RedisOperatorEngine redisOperatorEngine() {
        return new RedisOperatorEngine();
    }

    @Bean
    public RedisTemplate<String, Object> objectRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jacksonSeial.setObjectMapper(om);

        template.setValueSerializer(jacksonSeial);
        template.setKeySerializer(new StringRedisSerializer());

        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jacksonSeial);
        template.afterPropertiesSet();
        return template;
    }
}

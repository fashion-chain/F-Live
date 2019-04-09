package io.fashionet.community.community.configuration;

import io.fashionet.community.community.model.Fet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CommunityRedisConfiguration {

    @Bean
    public RedisTemplate<String, Fet> fetRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Fet> fetRedisTemplate = new RedisTemplate<>();
        fetRedisTemplate.setConnectionFactory(redisConnectionFactory);
        fetRedisTemplate.setKeySerializer(new StringRedisSerializer());
        fetRedisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Fet.class));
        fetRedisTemplate.afterPropertiesSet();
        return fetRedisTemplate;
    }

}

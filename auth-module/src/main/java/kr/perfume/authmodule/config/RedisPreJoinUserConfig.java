package kr.perfume.authmodule.config;

import kr.perfume.authmodule.entity.PreJoinUser;
import kr.perfume.commonmodule.config.RedisConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisPreJoinUserConfig {

    @Bean
    public RedisTemplate<String, PreJoinUser> UserRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, PreJoinUser> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<PreJoinUser>(PreJoinUser.class));

        return redisTemplate;
    }
}

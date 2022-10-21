package kr.perfume.commonmodule.config;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
@RequiredArgsConstructor
public class RedisConfiguration {

    private final RedisProperties redisProperties;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisURI redisURI = RedisURI.create(redisProperties.getHost(), redisProperties.getPort());
        redisURI.setPassword(redisProperties.getPassword());

        org.springframework.data.redis.connection.RedisConfiguration configuration = LettuceConnectionFactory.createRedisConfiguration(redisURI);

        LettuceConnectionFactory factory = new LettuceConnectionFactory(configuration);
        factory.afterPropertiesSet();
        return factory;
    }
}

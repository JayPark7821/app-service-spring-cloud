package kr.perfume.authmodule.Repository;

import kr.perfume.authmodule.entity.PreJoinUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Optional;


@Slf4j
@Repository
@RequiredArgsConstructor
public class PreJoinUserRedisRepository {

    private final RedisTemplate<String, PreJoinUser> preJoinUserRedisTemplate;
    private final static Duration USER_CACHE_TTL = Duration.ofMinutes(30);


    public PreJoinUser savePreJoinUser(PreJoinUser user) {
        String key = getKey(user.getUserId());
        log.info("Set PreJoinUser to Redis {} = {} ", key, user);
        preJoinUserRedisTemplate.opsForValue().setIfAbsent(key, user);
        return user;
    }

    public Optional<PreJoinUser> getUserByEmail(String userId) {
        String key = getKey(userId);
        PreJoinUser user = preJoinUserRedisTemplate.opsForValue().get(key);
        log.info("Get data from Redis {} = {} ", key, user);
        return Optional.ofNullable(user);
    }

    private String getKey(String userId) {
        return "USER:" + userId;
    }
}

package com.smallcode.sample.sample.springboot.cache.redis.config;


import com.smallcode.sample.sample.springboot.cache.redis.model.Article;
import java.util.LinkedHashSet;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class SampleRedisConfig {

//  @Bean
//  @ConditionalOnMissingBean(name = "redisTemplate")
//  public RedisTemplate<Object, Object> redisTemplate(
//      RedisConnectionFactory redisConnectionFactory) {
//    RedisTemplate<Object, Object> template = new RedisTemplate<>();
//    template.setConnectionFactory(redisConnectionFactory);
//    Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<Object>(
//        Object.class);
//    template.setDefaultSerializer(serializer);
//    return template;
//  }


  @Bean
  public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory,
      ResourceLoader resourceLoader) {
//    //初始化一个RedisCacheWriter
//    RedisCacheWriter redisCacheWriter = RedisCacheWriter
//        .nonLockingRedisCacheWriter(connectionFactory);
//    //设置CacheManager的值序列化方式为 fastJsonRedisSerializer,但其实RedisCacheConfiguration默认使用StringRedisSerializer序列化key，
//    ClassLoader loader = this.getClass().getClassLoader();
//
//    Jackson2JsonRedisSerializer fastJsonRedisSerializer = new Jackson2JsonRedisSerializer(
//        loader.getClass());
//    RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
//        .fromSerializer(fastJsonRedisSerializer);
//    RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
//        .serializeValuesWith(pair);
//    RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
//    return cacheManager;

    RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();

    config = config.serializeKeysWith(
        RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
        .serializeValuesWith(RedisSerializationContext.SerializationPair
            .fromSerializer(new GenericJackson2JsonRedisSerializer()));

    // 关闭前缀
    config = config.disableKeyPrefix();

    RedisCacheManager cacheManager = RedisCacheManager.builder(connectionFactory)
        .cacheDefaults(config).build();

    return cacheManager;
  }

}

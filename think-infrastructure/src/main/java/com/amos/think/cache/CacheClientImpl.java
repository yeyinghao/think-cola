/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2023.10
 */

package com.amos.think.cache;

import com.amos.think.cache.config.CacheConfig;
import com.amos.think.cache.enums.CalEnum;
import com.amos.think.common.template.impl.CalExecuteTemplate;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.redisson.api.*;
import org.redisson.client.codec.StringCodec;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 缓存服务实现
 *
 * @author yeyinghao
 * @date 2024/04/04
 */
@Service
@RequiredArgsConstructor
public class CacheClientImpl implements CacheClient {

	/**
	 * redisson client对象
	 */
	private final RedissonClient redissonClient;

	/**
	 * redisson配置
	 */
	private final CacheConfig redissonConfig;

	@Override
	public <T> T get(String key) {
		return CalExecuteTemplate.execute(CalEnum.GET, () -> {
			RBucket<T> bucket = redissonClient.getBucket(key);
			return bucket.get();
		});
	}

	@Override
	public <T> void save(String key, T value) {
		CalExecuteTemplate.execute(CalEnum.SAVE, () -> {
			RBucket<T> bucket = redissonClient.getBucket(key);
			bucket.set(value, redissonConfig.getDefaultExpiredSecond(), TimeUnit.SECONDS);
		});
	}

	@Override
	public <T> void saveExpire(String key, T value, long expired) {
		CalExecuteTemplate.execute(CalEnum.SAVE_EXPIRE, () -> {
			RBucket<T> bucket = redissonClient.getBucket(key);
			bucket.set(value, redissonConfig.getExpired(expired), TimeUnit.SECONDS);
		});
	}

	@Override
	public <T> boolean trySave(String key, T value) {
		return CalExecuteTemplate.execute(CalEnum.TRY_SAVE, () -> {
			RBucket<T> bucket = redissonClient.getBucket(key, StringCodec.INSTANCE);
			return bucket.trySet(value);
		});
	}

	@Override
	public <T> boolean trySaveExpire(String key, T value, long expired) {
		return CalExecuteTemplate.execute(CalEnum.TRY_SAVE_EXPIRE, () -> {
			RBucket<T> bucket = redissonClient.getBucket(key, StringCodec.INSTANCE);
			return bucket.trySet(value, redissonConfig.getExpired(expired), TimeUnit.SECONDS);
		});
	}

	@Override
	public void delete(String key) {
		CalExecuteTemplate.execute(CalEnum.DELETE, () -> {
			redissonClient.getBucket(key).delete();
		});
	}

	@Override
	public boolean isExists(String key) {
		return CalExecuteTemplate.execute(CalEnum.IS_EXISTS, () -> {
			return redissonClient.getBucket(key).isExists();
		});
	}

	@Override
	public <T> RList<T> getList(String key) {
		return CalExecuteTemplate.execute(CalEnum.GET_LIST, () -> {
			return redissonClient.getList(key);
		});
	}

	@Override
	public <K, V> RMapCache<K, V> getMapCache(String key) {
		return CalExecuteTemplate.execute(CalEnum.GET_MAP_CACHE, () -> {
			return redissonClient.getMapCache(key);
		});
	}

	@Override
	public <K, V> RMap<K, V> getMap(String key) {
		return CalExecuteTemplate.execute(CalEnum.GET_MAP, () -> {
			return redissonClient.getMap(key);
		});
	}

	@Override
	public <T> RSet<T> getSet(String key) {
		return CalExecuteTemplate.execute(CalEnum.GET_SET, () -> {
			return redissonClient.getSet(key);
		});
	}

	@Override
	public <T> RScoredSortedSet<T> getScoredSortedSet(String key) {
		return CalExecuteTemplate.execute(CalEnum.GET_SCORED_SORTED_SET, () -> {
			return redissonClient.getScoredSortedSet(key);
		});
	}

	@Override
	public RLock getLock(String key) {
		return CalExecuteTemplate.execute(CalEnum.GET_LOCK, () -> {
			return redissonClient.getLock(key);
		});
	}

	@Override
	public long remainTimeToLive(String key) {
		return CalExecuteTemplate.execute(CalEnum.REMAIN_TIME_TO_LIVE, () -> {
			return redissonClient.getKeys().remainTimeToLive(key);
		});
	}

	@PreDestroy
	public void destroy() {
		// 在程序关闭时，添加一个钩子函数用来释放链接资源 关闭Redisson客户端
		if (!redissonClient.isShutdown()) {
			Runtime.getRuntime().addShutdownHook(new Thread(redissonClient::shutdown));
		}
	}
}

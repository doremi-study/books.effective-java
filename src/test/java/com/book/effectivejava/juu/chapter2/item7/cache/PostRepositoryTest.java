package com.book.effectivejava.juu.chapter2.item7.cache;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class PostRepositoryTest {

	@Test
	void cache() throws InterruptedException {
		PostRepository postRepository = new PostRepository();
		CacheKey key = new CacheKey(1); // p1 = 1;
		//weakHashMap을 쓸거면 reference 객체를 만들어서 사용하자. 그래야 비워야짐
		postRepository.getPostById(key);
		assertFalse(postRepository.getCache().isEmpty());

		key = null;
		// TODO run gc
		System.out.println("run gc");
		System.gc();
		System.out.println("wait");
		Thread.sleep(3000L);

		assertTrue(postRepository.getCache().isEmpty());
		//hashMap 일땐 false, weakHashMap은 true
	}

	   @Test
	   void backgroundThread() throws InterruptedException {
	       ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
	       PostRepository postRepository = new PostRepository();
	       CacheKey key1 = new CacheKey(1);
	       postRepository.getPostById(key1);

		   //주기적으로 정리해주는 작업
	       Runnable removeOldCache = () -> {
	           System.out.println("running removeOldCache task");
	           Map<CacheKey, Post> cache = postRepository.getCache();
	           Set<CacheKey> cacheKeys = cache.keySet();
	           Optional<CacheKey> key = cacheKeys.stream().min(Comparator.comparing(CacheKey::getCreated));
	           key.ifPresent((k) -> {
	               System.out.println("removing " + k);
	               cache.remove(k);
	           });
	       };

	      // System.out.println("The time is : " + new Date());

	       executor.scheduleAtFixedRate(removeOldCache,
	               1, 3, TimeUnit.SECONDS);

	       Thread.sleep(20000L);

	       executor.shutdown();
	   }
}
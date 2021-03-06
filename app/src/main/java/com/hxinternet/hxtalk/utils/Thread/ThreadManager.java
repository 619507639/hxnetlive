package com.hxinternet.hxtalk.utils.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {

    private static ThreadManager mInstance;
    private static ExecutorService mFixedPoolThread;
    private static ExecutorService singleThreadPool;
    private static ExecutorService mCacheThreadPool;

    public static ThreadManager getInstance() {
        if (mInstance == null) {
            synchronized (ThreadManager.class) {
                if (mInstance == null) {
                    mInstance = new ThreadManager();
                }
            }
        }
        return mInstance;
    }

    // 创建核心线程池
    public ExecutorService getFixedPoolThread() {
        if (mFixedPoolThread == null) {
            mFixedPoolThread = Executors.newFixedThreadPool(3);
        }
        return mFixedPoolThread;
    }

    // 创建单线程线程池
    public ExecutorService getSinglePoolThread() {
        if (singleThreadPool == null) {
            singleThreadPool = Executors.newSingleThreadExecutor();
        }
        return singleThreadPool;
    }

    // 创建非核心线程池
    public ExecutorService getCachePoolThread() {
        if (mCacheThreadPool == null) {
            mCacheThreadPool = Executors.newCachedThreadPool();
        }
        return mCacheThreadPool;
    }
}

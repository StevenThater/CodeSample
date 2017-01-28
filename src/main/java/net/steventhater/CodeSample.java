package net.steventhater;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by Steven Thater on 1/27/2017.
 */
public final class CodeSample {

    private final ScheduledExecutorService executorService;

    public static void main(String[] args) {
        new CodeSample();
    }

    private CodeSample() {
        this.executorService = new ScheduledThreadPoolExecutor(4);
    }

    public ScheduledExecutorService getExecutorService() {
        return executorService;
    }
}

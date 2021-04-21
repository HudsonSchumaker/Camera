package br.com.schumaker.camera.core;

import java.util.concurrent.ThreadFactory;

/**
 *
 * @author hudson
 */
public class MyThreadFactory implements ThreadFactory {
    
    private static int number = 1;
    
    @Override
    public Thread newThread(Runnable task) {
        Thread thread = new Thread(task, "task " + number);
        number++;
        thread.setUncaughtExceptionHandler(new MyExceptionHandler());
        return thread;
    }
}

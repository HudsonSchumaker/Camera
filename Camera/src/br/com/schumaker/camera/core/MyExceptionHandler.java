package br.com.schumaker.camera.core;

/**
 *
 * @author hudson
 */
public class MyExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        System.out.println("Exception " + thread.getName() + ": " + ex.getMessage());
    }
}

package br.com.schumaker.camera.terminal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author hudson
 */
public class Terminal implements Cmd {

    private ExecutorService threadPool = Executors.newCachedThreadPool();

    @Override
    public void executeCommand(String[] commands) {
        for (String command : commands) {

        }
    }
}

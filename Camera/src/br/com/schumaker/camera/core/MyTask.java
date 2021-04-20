package br.com.schumaker.camera.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author hudson
 */
public class MyTask implements Runnable {

    private final String command;
    private Process process = null;
    
    public MyTask(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        try {
            process = Runtime.getRuntime().exec(command);
            System.err.println(process.isAlive());
            var in = process.getInputStream();
            var buffer = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = buffer.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            process.destroy();
        }
    }
    
    public boolean isTaskRunning() {
        return process.isAlive();
    }
}

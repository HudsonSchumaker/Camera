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
            String line;
            process = Runtime.getRuntime().exec(command);// "ffmpeg -i ep3.mp4 video.avi -hide_banner"
            BufferedReader bre = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            while ((line = bre.readLine()) != null) {
                System.out.print("..." + "\r");
            }
            bre.close();
            
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

package br.com.schumaker.camera.terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hudson 
 */
public class Terminal implements Cmd {

    private List<String> output = new ArrayList<>();

    @Override
    public void executeCommand(String[] commands) {
        new Thread(() -> {
            Process process = null;
            try {
                for (String command : commands) {
                    process = Runtime.getRuntime().exec(command);
                    var in = process.getInputStream();
                    var buffer = new BufferedReader(new InputStreamReader(in));
                    String line;
                    while ((line = buffer.readLine()) != null) {
                        output.add(line);
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } finally {
                process.destroy();
            }
        }).start();
    }
    
    public List<String> getOuput() {
        return output;
    }
}

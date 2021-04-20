package br.com.schumaker.camera.run;

import br.com.schumaker.camera.terminal.Terminal;

/**
 *
 * @author hudson
 */
public class Main {
    
    public static void main(String[] args) {
        var cmd = new Terminal();
        
        cmd.executeCommand(new String[]{
            "ffmpeg -i ep3.mp4 video.avi",
            "ffmpeg -i ep3.mp4 video.flv",
            "ffmpeg -i ep3.mp4 video.mpeg",
            "ffmpeg -i ep3.mp4 video.mpg"});
    }
}

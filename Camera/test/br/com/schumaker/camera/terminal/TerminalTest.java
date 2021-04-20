package br.com.schumaker.camera.terminal;

import junit.framework.Assert;
import org.junit.Test;



/**
 *
 * @author hudson
 */
public class TerminalTest {
    
    @Test
    public void executeCommandTest() {
        
        var tested = new Terminal();
        tested.executeCommand(new String[]{"pwd"});
        
        var result = tested.getOuput();
        Assert.assertTrue(result.size() > 0);
    }
}

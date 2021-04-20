package br.com.schumaker.camera.terminal;

import br.com.schumaker.camera.core.MyTask;
import br.com.schumaker.camera.core.MyThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 *
 * @author hudson
 */
public class Terminal implements Cmd {

    public static int getNumberProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }
    
    private MyThreadFactory factory = new MyThreadFactory();
    private ExecutorService   executor = new ThreadPoolFi(getNumberProcessors(), factory);

    @Override
    public void executeCommand(String[] commands) {
        for (String command : commands) {
            executor.execute(new MyTask(command));
        }
        executor.shutdown();
    }
}

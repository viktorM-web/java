package com.viktor.javalevel2.regularexpressions.homework.thread;

import com.viktor.javalevel2.regularexpressions.homework.dto.LogFileRow;
import com.viktor.javalevel2.regularexpressions.homework.parse.LogFileParse;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ProducerUpdate implements Runnable {
    private static final long TIME_WAITING = 50000L;
    private static final Path PATH = Path.of("resources", "log.txt");
    private static final LogFileParse LOG_FILE_PARSE = new LogFileParse();

    private final BlockingQueue<LogFileRow> blockingDeque;

    private List<LogFileRow> lastLogFile;

    public ProducerUpdate(BlockingQueue<LogFileRow> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        while (true) {
            try {
                List<LogFileRow> currentLogFileRows = LOG_FILE_PARSE.parse(PATH);
                if (lastLogFile != null) {
                    List<LogFileRow> transit = lastLogFile;
                    lastLogFile = currentLogFileRows;
                    currentLogFileRows.removeAll(transit);
                } else {
                    lastLogFile = currentLogFileRows;
                }
                blockingDeque.addAll(currentLogFileRows);
                Thread.sleep(TIME_WAITING);
                System.out.println("обновление листа жалоб");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

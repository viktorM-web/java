package com.viktor.javalevel2.regularexpressions.homework.thread;

import com.viktor.javalevel2.regularexpressions.homework.dto.LogFileRow;
import com.viktor.javalevel2.regularexpressions.homework.dto.ReportFileRow;
import com.viktor.javalevel2.regularexpressions.homework.util.DataTimeUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.BlockingQueue;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class Consumer implements Runnable {

    private static final long TIME_CALL = 4000L;
    private static final Path PATH = Path.of("resources", "report.txt");
    BlockingQueue<LogFileRow> blockingDeque;

    public Consumer(BlockingQueue<LogFileRow> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        while (true) {
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(PATH, CREATE, APPEND)) {

                LogFileRow logFileRow = blockingDeque.take();
                ReportFileRow reportFileRow = new ReportFileRow(logFileRow.getNumber(),
                        DataTimeUtil.LocalDateTimeForReport(), logFileRow.getTelephone());

                Thread.sleep(TIME_CALL);
                bufferedWriter.write(reportFileRow.toString());
                bufferedWriter.newLine();
                System.out.println("обработка жалобы");
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

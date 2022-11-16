package com.viktor.javalevel2.regularexpressions.homework.thread;

import com.viktor.javalevel2.regularexpressions.homework.util.DataTimeUtil;
import com.viktor.javalevel2.regularexpressions.homework.util.RandomUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.APPEND;

public class Producer implements Runnable {
    private static int numberComplain = 16;
    private static final long TIME_OF_FILING = 2000L;
    private static final Path PATH = Path.of("resources", "log.txt");

    @Override
    public void run() {
        while (true) {
            String complain = generateComplain();
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(PATH, APPEND)) {
                Thread.sleep(TIME_OF_FILING);
                bufferedWriter.newLine();
                bufferedWriter.write(complain);
                System.out.println("новая жалоба");
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String generateComplain() {
        return numberComplain++ + ", " + DataTimeUtil.LocalDateTimeForLog() + ", " +
                RandomUtil.getName() + ", " + RandomUtil.getTelephone() + ", " + RandomUtil.getComplaints();

    }
}

package com.viktor.javalevel2.regularexpressions.homework;

import com.viktor.javalevel2.regularexpressions.homework.dto.LogFileRow;
import com.viktor.javalevel2.regularexpressions.homework.thread.Consumer;
import com.viktor.javalevel2.regularexpressions.homework.thread.Producer;
import com.viktor.javalevel2.regularexpressions.homework.thread.ProducerUpdate;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;


public class Runner {
    public static void main(String[] args) {

        BlockingQueue<LogFileRow> blockingDeque = new LinkedBlockingDeque<>();
        ExecutorService threads = Executors.newFixedThreadPool(5);

        threads.submit(new ProducerUpdate(blockingDeque));
        threads.submit(new Consumer(blockingDeque));
        threads.submit(new Consumer(blockingDeque));
        threads.submit(new Consumer(blockingDeque));
        threads.submit(new Producer());
    }
}
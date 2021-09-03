package com.solvians.feedgenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class CertificateUpdaterMainClass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Number of threads : ");
        int noOfThreads = in.nextInt();
        System.out.println("Number of certificate updates : ");
        int noOfCertificates = in.nextInt();

        runCertificateUpdater(noOfThreads, noOfCertificates);


    }

    public static void runCertificateUpdater(int noOfThreads, int noOfCertificates) {
        ExecutorService executor = Executors.newFixedThreadPool(noOfThreads);
        List<Future<String>> list = new ArrayList<Future<String>>();
        Callable<String> callable = new FeedGeneratorTask();
        for(int i=0; i< noOfCertificates; i++){
            Future<String> future = executor.submit(callable);
            list.add(future);
        }
        for(Future<String> fut : list){
            try {
                System.out.println(fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }

    public static String runCertificateUpdaterForAPI(int noOfThreads, int noOfCertificates) {
        ExecutorService executor = Executors.newFixedThreadPool(noOfThreads);
        List<Future<String>> list = new ArrayList<Future<String>>();
        Callable<String> callable = new FeedGeneratorTask();
        for(int i=0; i< noOfCertificates; i++){
            Future<String> future = executor.submit(callable);
            list.add(future);
        }

        StringBuilder sb = new StringBuilder();
        for(Future<String> fut : list){
            try {
                sb.append(fut.get()).append("\n");
                System.out.println(fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        return sb.toString();
    }

    public  String runCertificateUpdaterMethod(int noOfThreads, int noOfCertificates) {
        runCertificateUpdater(noOfThreads, noOfCertificates);
        return "success";
    }



}

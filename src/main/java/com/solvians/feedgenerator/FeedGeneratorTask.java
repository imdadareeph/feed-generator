package com.solvians.feedgenerator;

import com.solvians.feedgenerator.model.Certificates;

import java.util.concurrent.Callable;

public class FeedGeneratorTask implements Callable<String> {


    Certificates certificates = new Certificates();
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        Certificates certificates= CertificateGenerator.generateCertificates();
        Thread.sleep(1000);
        return Thread.currentThread().getName()+" :: "+certificates.toString();
    }
}

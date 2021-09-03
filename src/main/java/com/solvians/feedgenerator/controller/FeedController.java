package com.solvians.feedgenerator.controller;

import com.solvians.feedgenerator.CertificateUpdaterMainClass;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedController {

    @RequestMapping(path = "/certificates/{noOfThreads}/{noOfCertificates}", method = RequestMethod.GET)
    public String getCertificatesList(@PathVariable int noOfThreads, @PathVariable int noOfCertificates) {
        String certificatesList= new String();
        certificatesList= CertificateUpdaterMainClass.runCertificateUpdaterForAPI(noOfThreads,noOfCertificates);
        return certificatesList;
    }
}

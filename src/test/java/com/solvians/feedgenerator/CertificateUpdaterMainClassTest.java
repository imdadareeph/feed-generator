package com.solvians.feedgenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CertificateUpdaterMainClass Test")
class CertificateUpdaterMainClassTest {

    @InjectMocks
    private CertificateUpdaterMainClass certificateUpdaterMainClass;
    int noOfThreads = 2;
    int noOfCertificates = 4;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        noOfThreads = 2;
        noOfCertificates = 4;

    }

    @Test
    public void runCertificateUpdater(){
        certificateUpdaterMainClass = new CertificateUpdaterMainClass();
       String actual= certificateUpdaterMainClass.runCertificateUpdaterMethod(noOfThreads,noOfCertificates);
        Assertions.assertEquals("success",actual);

    }


}
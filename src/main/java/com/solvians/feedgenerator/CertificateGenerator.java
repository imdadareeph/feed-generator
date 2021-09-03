package com.solvians.feedgenerator;

import com.solvians.feedgenerator.model.Certificates;
import com.solvians.feedgenerator.util.LettersToNumbersConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Random;

public class CertificateGenerator {

    public static Certificates generateCertificates() {
        Certificates certificates = new Certificates();
        certificates.setTimestamp(Timestamp.from(Instant.now()));
        certificates.setIsin(randomISIN());
        certificates.setBidPrice(generateRandomDoubles());
        certificates.setBidSize(1000);
        certificates.setAskPrice(generateRandomDoubles());
        certificates.setAskSize(1000);

        //System.out.println(certificates);
        return certificates;
    }

    public static String randomISIN() {
        String alphabetsInUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String allCharacters =  numbers;
        StringBuffer randomNum = new StringBuffer();
        StringBuffer randomString = new StringBuffer();

        Random randomGenerator = new Random(System.currentTimeMillis());

        for (int i = 1; i < 9; i++) {
            int randomIndex = randomGenerator.nextInt(allCharacters.length());
            randomNum.append(allCharacters.charAt(randomIndex));
        }
        for (int i = 1; i < 3; i++) {
            int randomIndex = randomGenerator.nextInt(allCharacters.length());
            randomString.append(alphabetsInUpperCase.charAt(randomIndex));
        }
        int checkDigit=LettersToNumbersConverter.checkDigit(randomString.toString());

        randomString.append(randomNum).append(checkDigit);

        return randomString.toString();
    }

    public static double generateRandomDoubles(){
        double min = 1000;
        double max = 9999;
        Random randomGenerator = new Random(System.currentTimeMillis());
        double randomValue = min + (max - min) * randomGenerator.nextDouble();
        BigDecimal bd=new BigDecimal(randomValue).setScale(2,RoundingMode.HALF_DOWN);
        return bd.doubleValue();
    }

}

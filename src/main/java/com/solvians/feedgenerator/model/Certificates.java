package com.solvians.feedgenerator.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Certificates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Timestamp timestamp;

    private String isin;

    private double BidPrice;

    private int BidSize;

    private double askPrice;

    private int askSize;

    @Override
    public String toString() {
        return "Certificates{" +
                "timestamp=" + timestamp +
                ", isin='" + isin + '\'' +
                ", BidPrice=" + BidPrice +
                ", BidSize=" + BidSize +
                ", askPrice=" + askPrice +
                ", askSize=" + askSize +
                '}';
    }
}


/*
 Timestamp (number of milliseconds since January 1, 1970, 00:00:00 GMT)
 ISIN (string, 2 random uppercase alphabets + 9 random alphanumeric characters + 1 check digit)
 Bid Price (random number, 2 decimal places, range between 100.00 and 200.00 inclusive)
 Bid Size (random number, 0 decimal place, range between 1,000 and 5,000 inclusive)
 Ask Price (random number, 2 decimal places, range between 100.00 and 200.00 inclusive)
 Ask Size (random number, 0 decimal place, range between 1,000 and 10,000 inclusive)
 */
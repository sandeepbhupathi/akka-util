package com.sample.scheduled;

import akka.actor.AbstractActor;

import java.sql.Timestamp;

/**
 * Created by sande on 6/3/2017.
 */
public class SampleActor extends AbstractActor {


    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class,message ->{
            System.out.println("invoked with the scheduled........."+message+"-----"+
                    new Timestamp(System.currentTimeMillis()).getTime());
        }).build();
    }
}

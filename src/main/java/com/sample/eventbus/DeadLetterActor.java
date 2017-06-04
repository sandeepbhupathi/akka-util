package com.sample.eventbus;

import akka.actor.AbstractActor;
import akka.actor.DeadLetter;

/**
 * Created by sande on 6/3/2017.
 */
public class DeadLetterActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(DeadLetter.class, message ->{
            System.out.println("dead letter message"+message);
        }).build();
    }
}

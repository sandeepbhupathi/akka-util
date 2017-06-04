package com.sample.eventbus;

import akka.actor.AbstractActor;

class Listener extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Jazz.class, msg ->
                        System.out.printf("%s is listening to: %s%n", getSelf().path().name(), msg)
                )
                .match(Electronic.class, msg ->
                        System.out.printf("%s is listening to: %s%n", getSelf().path().name(), msg)
                )
                .build();
    }
}
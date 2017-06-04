package com.sample.logging;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.util.Optional;

/**
 * Created by sande on 6/3/2017.
 */
public class MySampleLogginActor extends AbstractActor {
    LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public void preStart() {
        log.debug(".......Starting...");
    }

    @Override
    public void preRestart(Throwable reason, Optional<Object> message) {
        log.error(reason, "Restarting due to [{}] when processing [{}]",
                reason.getMessage(), message.isPresent() ? message.get() : "");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("test", msg ->
                        log.info("Received test")
                )
                .matchAny(msg ->
                        log.warning("Received unknown message: {}", msg)
                )
                .build();
    }


}

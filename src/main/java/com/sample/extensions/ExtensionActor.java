package com.sample.extensions;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by sande on 6/4/2017.
 */
public class ExtensionActor extends AbstractActor {

    LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    // typically you would use static import of the Settings.SettingsProvider field
    final SettingsImpl settings =
            Settings.SettingsProvider.get(getContext().getSystem());;


    @Override
    public void preStart() throws Exception {
        super.preStart();
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class,message->{
            log.info("logging configuration......."+message);
            log.info("logging configuration......."+settings.DB_URI);
            log.info("logging configuration......."+settings.CIRCUIT_BREAKER_TIMEOUT);
        }).build();
    }
}

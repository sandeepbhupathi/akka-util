package com.sample.extensions;

import akka.actor.Extension;
import com.typesafe.config.Config;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * Created by sande on 6/4/2017.
 */
public class SettingsImpl implements Extension {
    public final String DB_URI;
    public final Duration CIRCUIT_BREAKER_TIMEOUT;

    public SettingsImpl(Config config){
        DB_URI = config.getString("myapp.db.uri");
        CIRCUIT_BREAKER_TIMEOUT = Duration.create(config.getDuration("myapp.circuit-breaker.timeout",
                TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS);
    }

}

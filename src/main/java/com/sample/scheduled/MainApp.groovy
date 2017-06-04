package com.sample.scheduled

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Cancellable
import akka.actor.Props

import java.sql.Timestamp
import scala.concurrent.duration.Duration;
import java.util.concurrent.TimeUnit

def system = ActorSystem.create("scheduled")
def actorref = system.actorOf(Props.create(SampleActor.class),"scheduledActor")

Cancellable cancellable = system.scheduler().schedule(Duration.Zero(),
        Duration.create(50, TimeUnit.MILLISECONDS), actorref,new Timestamp(System.currentTimeMillis()).getTime().toString(),
        system.dispatcher(), ActorRef.noSender());

//cancellable.cancel();

//invoked after 50 ms
/*system.scheduler().scheduleOnce(Duration.create(50, TimeUnit.MILLISECONDS), {
    actorref.tell(new Timestamp(System.currentTimeMillis()).getTime().toString(),ActorRef.noSender())
},system.dispatcher());*/

/*actorref.tell(new Timestamp(System.currentTimeMillis()).getTime().toString(),ActorRef.noSender())

system.terminate();*/

package com.sample.eventbus

import akka.actor.ActorSystem
import akka.actor.DeadLetter
import akka.actor.Props

def system = ActorSystem.create("DeadLetterSample")
def actorRef = system.actorOf(Props.create(DeadLetterActor.class),"DeadLetterSampleActor")

system.eventStream().subscribe(actorRef,DeadLetter.class)


system.eventStream().publish(DeadLetter.class)
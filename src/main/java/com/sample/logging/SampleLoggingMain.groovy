package com.sample.logging

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import com.typesafe.config.ConfigFactory


def system = ActorSystem.create("loggingsystem",ConfigFactory.load())
println(system.settings())
def actorRef = system.actorOf(Props.create(MySampleLogginActor.class),"loggingActor")

actorRef.tell("test",ActorRef.noSender())

system.terminate()

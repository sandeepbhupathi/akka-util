package com.sample.extensions

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props

def system = ActorSystem.create("ExtensionSystem")
def actorRef = system.actorOf(Props.create(ExtensionActor),"extApp")

actorRef.tell("Hello from main",ActorRef.noSender())
package com.sample.eventbus

import akka.actor.AbstractActor
import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.DeadLetter
import akka.actor.Props


/*event bus needs event,subscriber and classifier
Types of classifiers:
1.Lookup classifier
2.Sub Channel Classifier
3.Scanning Classifier
4.Actor Classifier
best place to learn more about the event bus is
http://doc.akka.io/docs/akka/current/java/event-bus.html#subchannel-classification
default actor system uses sun channel classifier
*/
def system = ActorSystem.create("DeadLetterSample")

final ActorRef actor = system.actorOf(Props.create(DeadLetterActor.class));
system.eventStream().subscribe(actor, DeadLetter.class);

final ActorRef jazzListener = system.actorOf(Props.create(Listener.class));
final ActorRef musicListener = system.actorOf(Props.create(Listener.class));
system.eventStream().subscribe(jazzListener, Jazz.class);
system.eventStream().subscribe(musicListener, AllKindsOfMusic.class);

// only musicListener gets this message, since it listens to *all* kinds of music:
system.eventStream().publish(new Electronic("Parov Stelar"));

// jazzListener and musicListener will be notified about Jazz:
system.eventStream().publish(new Jazz("Sonny Rollins"));

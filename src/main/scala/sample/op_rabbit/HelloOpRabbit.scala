package sample.op_rabbit

import akka.actor.{ ActorSystem, Props }
import com.spingo.op_rabbit._
import scala.concurrent.{ ExecutionContext, Await }
import scala.concurrent.duration._

object HelloOpRabbit extends App {
  import ExecutionContext.Implicits.global
  val actorSystem = ActorSystem("HelloOpRabbit")
  val rabbitControl = actorSystem.actorOf(Props[RabbitControl])

  /*
   Let's start up our first consumer!
   */
  val helloConsumerRef = Subscription.register(rabbitControl) {
    import Directives._
    channel(qos = 1) {
      consume(queue("hello", durable = false, autoDelete = true)) {
        body(as[String]) { name =>
          println(s"Hello consumer greets ${name}")
          ack
        }
      }
    }
  }

  /*
   Since our consumer also declares the message queue on which it
   listens, let's wait for our consumer to initialize, first, as to
   not lose any messages.
   */
  Await.result(helloConsumerRef.initialized, 5 seconds)

  /*
   Slowly send a list of names, one a time, one per second.
   */
  for (name <- List("Tim", "George", "Fred", "Jim", "Mary", "Sue", "Tom", "Dick", "Harry", "Greg", "Samson", "Alice", "Kramson")) {
    Thread.sleep(1000)
    rabbitControl ! QueueMessage(name, queue = "hello")
  }

  /*
    Cleanup! Calling close() and waiting for closed will make sure our consumer can finish what it was working on 
   */
  helloConsumerRef.close()
  Await.result(helloConsumerRef.closed, 5 seconds)

  actorSystem.shutdown()
}

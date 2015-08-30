## Hello Op-Rabbit

The simplest of examples is a Direct Exchange, from one publisher to one consumer.

![img/01-p-to-c.png](tutorial/img/01-p-to-c.png)

[HelloOpRabbit.scala](#code/src/main/scala/sample/op_rabbit/HelloOpRabbit.scala)

The minimum steps required to do this are:

- Instantiate an Akka `ActorSystem`.
- Create a `RabbitControl` actor.
- Create a `consumer` (Subscription), which declares the queue to which it listens, if it doesn't already exist.
- Publish some messages to that `consumer`.

### A few terms:

#### RabbitControl

RabbitControl is the top-level management actor for `Op-Rabbit`. A few of it's responsibilities:

- Keep a connection to the RabbitMQ Broker; recover topology after disconnect / reconnect.
- Ensure that every active consumer has a channel.
- Send message
- Manage and supervise all active consumers.

#### Subscription

In `Op-Rabbit`, a subscription is a declarative configuration for a consumer. It's responsible for:

- Defining how a channel is configured (qos).
- How a queue is to be declared and configured.
- How messages are to be processed when received.

#### QoS

QoS stands for "Quality of Service" and represents the number of concurrent messages delivered to a consumer at any given time. This is a good way to limit the number of concurrent tasks your consumer will perform, however, this limit only applies per-consumer.

In `Op-Rabbit`, all consumers explicitly acknowledge. (If performance is a concern, you can access a channel directly and manually set up your own consumer where needed).

### Code / Run

- Sample code: [HelloOpRabbit.scala](#code/src/main/scala/sample/op_rabbit/HelloOpRabbit.scala)
- Configuration: [application.conf](#code/src/main/resources/application.conf)
- Run: Go to the [Run](#run), select the `sample.op_rabbit.HelloOpRabbit` class in the 'Main file' menu, and click the 'Run' button.


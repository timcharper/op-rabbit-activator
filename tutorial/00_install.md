## Installation

These tutorials depend on you having `rabbitmq-server` `v3.5.0` or higher installed on your computer; Also, to help you see what's happening, you'll want to install the management Web-UI plugin (standard with most distros).

### Install RabbitMQ Server

See the Section "Installation Guides" on the [RabbitMQ Downloads Page](https://www.rabbitmq.com/download.html).

#### OS X (Homebrew)

The best way to install `rabbitmq-server` on OS X is with [Homebrew](http://brew.sh/). Once `Homebrew` is installed on your system, run the following:

    brew install rabbitmq-server

Then, launch rabbitmq-server in a separate terminal session:

    rabbitmq-server

If it worked, you should see this:

    $ rabbitmq-server

                  RabbitMQ 3.5.1. Copyright (C) 2007-2014 GoPivotal, Inc.
      ##  ##      Licensed under the MPL.  See http://www.rabbitmq.com/
      ##  ##
      ##########  Logs: /usr/local/var/log/rabbitmq/rabbit@localhost.log
      ######  ##        /usr/local/var/log/rabbitmq/rabbit@localhost-sasl.log
      ##########
                  Starting broker... completed with 10 plugins.


[More information])(https://www.rabbitmq.com/install-homebrew.html)

#### Windows

See [https://www.rabbitmq.com/install-windows.html](Installing on Windows using the Installer)

#### Linux

See the Section "Installation Guides" on the [RabbitMQ Downloads Page](https://www.rabbitmq.com/download.html).

### Launching

Once you've installed and have started RabbitMQ on your local machine, you should be able to open the [RabbitMQ Management Plugin](http://127.0.0.1:15672/). The default password is usually `guest` / `guest`.

### Configuration

Fresh installs of RabbitMQ are usually configured as follows:

- **port**: `5762`
- **host**: `127.0.0.1`
- **user**: `guest`
- **pass**: `guest`

If you've customized any of this, you'll need to update your configuration in [application.conf](#code/src/main/resources/application.conf) accordingly.

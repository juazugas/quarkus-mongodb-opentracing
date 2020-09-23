package com.example.mongodb.tracing;

import com.mongodb.event.CommandFailedEvent;
import com.mongodb.event.CommandListener;
import com.mongodb.event.CommandStartedEvent;
import com.mongodb.event.CommandSucceededEvent;
import io.opentracing.contrib.mongo.common.TracingCommandListener;
import io.opentracing.util.GlobalTracer;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class DelegatedTracingCommandListener implements CommandListener {

    private static Logger logger = LoggerFactory.getLogger(DelegatedTracingCommandListener.class); 

    private TracingCommandListener delegate;

    public DelegatedTracingCommandListener() {
        this.delegate = new TracingCommandListener.Builder(GlobalTracer.get()).build();
        logger.info("delegated TracingCommandListener created");
    }

    @Override
    public void commandStarted(CommandStartedEvent event) {
        logger.info("commandStarted event " + event.getCommandName());
        delegate.commandStarted(event);
    }

    @Override
    public void commandFailed(CommandFailedEvent event) {
        logger.info("commandFailed event " + event.getCommandName());
        delegate.commandFailed(event);
    }

    @Override
    public void commandSucceeded(CommandSucceededEvent event) {
        logger.info("commandSucceded event " + event.getCommandName());
        delegate.commandSucceeded(event);
    }

}

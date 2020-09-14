package com.example.mongodb.tracing;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import com.mongodb.event.CommandListener;
import io.opentracing.Tracer;
import io.opentracing.contrib.mongo.common.TracingCommandListener;
import io.quarkus.arc.Unremovable;

public class TracingCommandListenerProducer {

    @Default
    @ApplicationScoped
    @Produces
    @Unremovable
    public CommandListener tracingCommandListener(Tracer tracer) {
        return new TracingCommandListener.Builder(tracer).build();
    }

}

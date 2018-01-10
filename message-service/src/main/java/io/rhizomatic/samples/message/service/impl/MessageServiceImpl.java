package io.rhizomatic.samples.message.service.impl;

import io.rhizomatic.samples.message.service.api.MessageService;
import io.rhizomatic.api.Monitor;
import io.rhizomatic.api.annotations.Eager;
import io.rhizomatic.api.annotations.Init;
import io.rhizomatic.api.annotations.Service;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Scanned service implementation.
 */
@Service
@Eager
@Singleton
public class MessageServiceImpl implements MessageService {

    @Inject
    protected Monitor monitor;   // provided by Rhizomatic

    @Init
    public void init() {
        monitor.info(() -> "Initialized service completed ");
    }

    public String message() {
        return "Hello from the message service!";
    }
}
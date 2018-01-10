package io.rhizomatic.integration;

import io.rhizomatic.inject.api.InjectionModule;
import io.rhizomatic.kernel.Rhizomatic;
import io.rhizomatic.samples.message.api.MessageController;
import io.rhizomatic.samples.message.service.api.MessageService;
import io.rhizomatic.samples.message.service.impl.MessageServiceImpl;
import io.rhizomatic.web.api.WebModule;
import org.easymock.EasyMock;
import org.junit.Test;

/**
 *
 */
public class TestRhizomatic {

    @Test
    public void testBoot() {
        InjectionModule.install();
        WebModule.install();

        Rhizomatic.Builder builder = Rhizomatic.Builder.newInstance();
        Rhizomatic rhizomatic = builder.moduleMode(false).silent(true).services(MessageServiceImpl.class, MessageController.class).build();

        rhizomatic.start();
        rhizomatic.shutdown();
    }

    @Test
    public void testMockBoot() {
        InjectionModule.install();
        WebModule.install();

        Rhizomatic.Builder builder = Rhizomatic.Builder.newInstance();
        MessageService messageServiceMock = EasyMock.createNiceMock(MessageService.class);
        Rhizomatic rhizomatic = builder.moduleMode(false).silent(true).instances(messageServiceMock).services(MessageController.class).build();

        rhizomatic.start();
        rhizomatic.shutdown();
    }

}

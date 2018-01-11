package io.rhizomatic.integration;

import io.rhizomatic.inject.api.InjectionModule;
import io.rhizomatic.kernel.Rhizomatic;
import io.rhizomatic.samples.message.service.impl.MessageServiceImpl;
import org.junit.Test;

/**
 *
 */
public class TestRhizomatic {

    @Test
    public void testBoot() {
        InjectionModule.install();

        Rhizomatic.Builder builder = Rhizomatic.Builder.newInstance();
        Rhizomatic rhizomatic = builder.moduleMode(false).silent(true).services(MessageServiceImpl.class).build();

        rhizomatic.start();
        rhizomatic.shutdown();
    }

}

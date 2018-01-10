package io.rhizomatic.samples.message.api;

import io.rhizomatic.api.annotations.Service;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * A JAX-RS message body writer.
 *
 * Writers can be injected with services using {@code @Inject}.
 */
@Provider
@Produces("text/html")
@Service
public class TextMessageBodyWriter implements MessageBodyWriter<String> {

    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == String.class;
    }

    public void writeTo(String user, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream out) throws IOException, WebApplicationException {
        Writer writer = new PrintWriter(out);
        writer.write(user);
        writer.flush();
        writer.close();
    }
}

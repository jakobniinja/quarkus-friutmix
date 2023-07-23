package org.acme.utils;

import com.mongodb.MongoWriteException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DuplicateKeyException implements ExceptionMapper<MongoWriteException> {
    @Override
    public Response toResponse(MongoWriteException e) {
        return Response.status(Response.Status.ACCEPTED).
                entity(new ErrorMessage("Request is valid, please try again!")).build();
    }
}

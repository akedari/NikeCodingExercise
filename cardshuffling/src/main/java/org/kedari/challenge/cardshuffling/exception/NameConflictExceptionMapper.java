package org.kedari.challenge.cardshuffling.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.kedari.challenge.cardshuffling.model.ErrorMessage;


@Provider
public class NameConflictExceptionMapper implements  ExceptionMapper<NameConflictException> {

    /**
     * If runtime we found new request for deck is already exists then, we can use this exception.
     * @return response with
     *      Status Code: Status.CONFLICT
     *      Entity: errorMessage provided
     */
    
    @Override
    public Response toResponse(NameConflictException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), Status.CONFLICT.getStatusCode());  
        return Response.status(Status.CONFLICT )
                .entity(errorMessage) 
                .build();
    }
}

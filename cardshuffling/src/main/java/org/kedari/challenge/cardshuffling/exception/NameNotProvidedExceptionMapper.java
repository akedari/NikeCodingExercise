package org.kedari.challenge.cardshuffling.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.kedari.challenge.cardshuffling.model.ErrorMessage;

@Provider
public class NameNotProvidedExceptionMapper implements  ExceptionMapper<NameNotProvidedException> {

    /**
     * If runtime request is not proper or illegal, we can use this exception.
     * @return response with
     *      Status Code: 404
     *      Entity: errorMessage provided
     */
    
    @Override
    public Response toResponse(NameNotProvidedException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), Status.NOT_FOUND.getStatusCode());  
        return Response.status(Status.NOT_FOUND )
                .entity(errorMessage) 
                .build();
    }

}

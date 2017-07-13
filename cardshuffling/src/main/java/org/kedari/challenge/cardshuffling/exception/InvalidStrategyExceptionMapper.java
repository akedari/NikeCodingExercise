package org.kedari.challenge.cardshuffling.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.kedari.challenge.cardshuffling.model.ErrorMessage;

@Provider
public class InvalidStrategyExceptionMapper implements  ExceptionMapper<InvalidStrategyException> {

    /**
     * If runtime we found requested Strategy is not valid, we can use this exception.
     * @return response with
     *      Status Code: 409
     *      Entity: errorMessage provided
     */
    
    @Override
    public Response toResponse(InvalidStrategyException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), Status.NOT_ACCEPTABLE.getStatusCode());  
        return Response.status(Status.NOT_ACCEPTABLE )
                .entity(errorMessage) 
                .build();
    }

}

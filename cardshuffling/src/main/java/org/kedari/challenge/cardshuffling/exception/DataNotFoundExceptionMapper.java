package org.kedari.challenge.cardshuffling.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.kedari.challenge.cardshuffling.model.ErrorMessage;


@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

    
    /**
     * If runtime requested data not found in memory/DB, we can use this exception.
     * @return response with
     *      Status Code: 404
     *      Entity: errorMessage provided
     */
    
    @Override
    public Response toResponse(DataNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404);  
        return Response.status(Status.NOT_FOUND)
                .entity(errorMessage) 
                .build();
    }

}

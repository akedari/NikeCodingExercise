package org.kedari.challenge.cardshuffling.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.kedari.challenge.cardshuffling.model.ErrorMessage;

@Provider
public class ConfigFileNotFoundExceptionMapper implements ExceptionMapper<ConfigFileNotFoundException>{

    /**
     * If config.properties file is missing from resources directory, we can use this exception.
     * @return response with
     *      Status Code: 404
     *      Entity: errorMessage provided
     */
    
    @Override
    public Response toResponse(ConfigFileNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404);  
        return Response.status(Status.NOT_FOUND)
                .entity(errorMessage) 
                .build();
    }
}

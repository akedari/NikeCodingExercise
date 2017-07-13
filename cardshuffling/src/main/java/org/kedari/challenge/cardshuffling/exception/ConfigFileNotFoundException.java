package org.kedari.challenge.cardshuffling.exception;

public class ConfigFileNotFoundException extends RuntimeException {

    /**
     * If config.properties file is missing from resources directory, we can use this exception.
     * @return response with
     *      Status Code: 404
     *      Entity: errorMessage provided
     */
    
    private static final long serialVersionUID = 1L;

    public ConfigFileNotFoundException(String message){
         super(message);
    }
}

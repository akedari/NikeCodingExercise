package org.kedari.challenge.cardshuffling.exception;

public class DataNotFoundException extends RuntimeException {

    
    /**
     * If runtime requested data not found in memory/DB, we can use this exception.
     * @return response with
     *      Status Code: 404
     *      Entity: errorMessage provided
     */
    
    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String message){
         super(message);
    }
}

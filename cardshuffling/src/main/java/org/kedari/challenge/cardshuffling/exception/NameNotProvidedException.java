package org.kedari.challenge.cardshuffling.exception;

public class NameNotProvidedException extends RuntimeException {

    /**
     * If runtime request is not proper or illegal, we can use this exception.
     * @return response with
     *      Status Code: 404
     *      Entity: errorMessage provided
     */
    
    private static final long serialVersionUID = 1L;

    public NameNotProvidedException(String message){
        super(message);
   }

}

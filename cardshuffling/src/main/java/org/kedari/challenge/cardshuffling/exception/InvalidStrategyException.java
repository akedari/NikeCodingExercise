package org.kedari.challenge.cardshuffling.exception;

public class InvalidStrategyException extends RuntimeException {

    /**
     * If runtime we found requested Strategy is not valid, we can use this exception.
     * @return response with
     *      Status Code: 409
     *      Entity: errorMessage provided
     */
    
    private static final long serialVersionUID = 1L;
    
    public InvalidStrategyException(String message){
        super(message);
   }

}

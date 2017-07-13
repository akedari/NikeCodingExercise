package org.kedari.challenge.cardshuffling.exception;

public class NameConflictException extends RuntimeException {

    /**
     * If runtime we found new request for deck is already exists then, we can use this exception.
     * @return response with
     *      Status Code: Status.CONFLICT
     *      Entity: errorMessage provided
     */
    
    private static final long serialVersionUID = 1L;
    
    public NameConflictException(String message){
        super(message);
   }
    
}

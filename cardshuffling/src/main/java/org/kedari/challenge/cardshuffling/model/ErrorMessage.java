 package org.kedari.challenge.cardshuffling.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ErrorMessage {
    
    /**
     * This is Model class for error message, used in Exception handling
     * 
     */

    private String erroeMessage;
    private int errorCode;
    
    public ErrorMessage() {
    }
    
    public ErrorMessage(String erroeMessage, int errorCode) {
        super();
        this.erroeMessage = erroeMessage;
        this.errorCode = errorCode;
    }
    public String getErroeMessage() {
        return erroeMessage;
    }
    public void setErroeMessage(String erroeMessage) {
        this.erroeMessage = erroeMessage;
    }
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}

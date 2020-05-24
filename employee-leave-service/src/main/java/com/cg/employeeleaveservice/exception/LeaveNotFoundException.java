/**
 * @author Pranav
 */

package com.cg.employeeleaveservice.exception;

public class LeaveNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 5512565657286379434L;

    public LeaveNotFoundException() {
        super();
    }

    public LeaveNotFoundException(String message) {
        super(message);
    }

}
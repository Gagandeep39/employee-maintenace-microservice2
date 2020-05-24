/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-06 02:09:37
 * @modify date 2020-05-06 02:09:37
 * @desc Custom Exception - thrown when a user is not found in database
 */

package com.cg.employeeleaveservice.exception;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5512565657286379434L;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
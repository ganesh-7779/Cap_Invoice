/**
 * Purpose : To Throw  custom Exception for Enhance Invoice
 * @author : Ganesh Gavhad
 * @since : 10/8/2021
 * @Version : 1.0
 */
package com.bridgelabz;

public class EnhanceGeneratorException extends Exception {

    public enum exception {

        SERVICE_NULL_EXCEPTION
    }

    public exception Type;

    public EnhanceGeneratorException(exception Type) {
        this.Type = Type;

    }

}

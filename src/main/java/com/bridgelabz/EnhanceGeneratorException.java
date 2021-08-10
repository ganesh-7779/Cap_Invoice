package com.bridgelabz;
/**
 * Purpose : To Throw  custom Exception for Enhance Invoice
 * @author : Ganesh Gavhad
 * @since  : 10.08.2021
 * @Version : 1.0
 */

public class EnhanceGeneratorException extends Exception {

    public enum exception {

        SERVICE_NULL_EXCEPTION
    }

    public exception Type;

    public EnhanceGeneratorException(exception Type) {
        this.Type = Type;

    }

}

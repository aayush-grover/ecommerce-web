package com.project.shopping.shopping.Exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class CartItemNotFoundException extends Exception{
    private final String code;
    private final String errorMessage;

    public CartItemNotFoundException(final String code, final String errorMessage){
        this.code = code;
        this.errorMessage = errorMessage;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
    }

    public String getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}

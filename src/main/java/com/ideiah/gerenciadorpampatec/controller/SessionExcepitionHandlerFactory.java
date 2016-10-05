/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 *
 * @author Pedro
 */
public class SessionExcepitionHandlerFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory parent;

    public SessionExcepitionHandlerFactory(ExceptionHandlerFactory parent) {
        this.parent = parent;
    }

    @Override
    public ExceptionHandler getExceptionHandler() {
        ExceptionHandler result
                = new SessionExcepitionHandler(parent.getExceptionHandler());
        return result;
    }

}
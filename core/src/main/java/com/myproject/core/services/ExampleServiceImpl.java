package com.myproject.core.services;

import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;

@Component(service = { ExampleService.class })
public class ExampleServiceImpl implements ExampleService {
    /**
     * @return
     */
    @Override
    public String execute() {
        return "Message from ExampleServiceImpl . .";
    }
}

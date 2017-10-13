package com.example.service;

import com.example.demo.beans.ExampleBean;

/**
 * a Mock class to show how some other layer
 * (a persistence layer, for instance)
 * could be used inside a Camel
 * 
 */
public class ExampleServices {

    public static void exampleRestAPI(final ExampleBean body) {
        body.setName( "My name is Bond, " + body.getName() );
        body.setId(body.getId()*10);
    }
}
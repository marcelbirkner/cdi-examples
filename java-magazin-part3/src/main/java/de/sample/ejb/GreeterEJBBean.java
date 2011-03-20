package de.sample.ejb;

import javax.ejb.Stateless;

@Stateless
public class GreeterEJBBean implements GreeterEJB {
    public String welcome( String name ) {
        return "Welcome to my world " + name;
    }
}

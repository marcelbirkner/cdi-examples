package de.sample.ejb;

import javax.ejb.Local;

@Local
public interface GreeterEJB {
    public String welcome(String name);
}


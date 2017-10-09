package com.tmaapi.rest;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class RSApplication extends Application
{
    public Set<Class<?>> getClasses()
    {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(JSONService.class);
        return s;
    }
}
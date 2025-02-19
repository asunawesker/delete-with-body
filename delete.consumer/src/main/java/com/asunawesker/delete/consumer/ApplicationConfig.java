package com.asunawesker.delete.consumer;

import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(DeleteResource.class);
        return set;
    }

    @Override
    public Set<Object> getSingletons() {
        return Collections.emptySet();
    }
}
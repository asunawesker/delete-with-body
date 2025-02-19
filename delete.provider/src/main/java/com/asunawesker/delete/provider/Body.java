package com.asunawesker.delete.provider;

public class Body {
    private String name;
    private Integer value;

    // Standard constructors, getters and setters

    public Body() {}

    public Body(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Body{name='" + name + "', value=" + value + '}';
    }
}

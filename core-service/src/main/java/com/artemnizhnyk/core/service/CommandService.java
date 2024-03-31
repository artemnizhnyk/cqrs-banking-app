package com.artemnizhnyk.core.service;

public interface CommandService<T> {

    void create(final T object);
}

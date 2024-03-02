package com.artemnizhnyk.cqrsbankingapp.service;

public interface CommandService<T> {

    void create(final T object);
}

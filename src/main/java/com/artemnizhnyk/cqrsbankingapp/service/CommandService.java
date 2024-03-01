package com.artemnizhnyk.cqrsbankingapp.service;

public interface CommandService<T> {

    void create(T object);
}

package com.artemnizhnyk.cqrsbankingapp.service;

import java.util.UUID;

public interface QueryService<T> {

    T getById(final UUID id);
}

package com.artemnizhnyk.cqrsbankingapp.service.transaction;

import java.util.UUID;

public interface QueryService<T> {

    T getById(UUID id);
}

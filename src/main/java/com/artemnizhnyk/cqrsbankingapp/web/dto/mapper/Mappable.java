package com.artemnizhnyk.cqrsbankingapp.web.dto.mapper;

import java.util.List;

public interface Mappable<E, D> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dto);

    List<D> toDto(List<E> entity);
}

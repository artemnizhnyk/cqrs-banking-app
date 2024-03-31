package com.artemnizhnyk.core.web.dto.mapper;

import com.artemnizhnyk.common.domain.model.Card;
import com.artemnizhnyk.core.web.dto.CardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {
}

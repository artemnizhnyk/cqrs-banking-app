package com.artemnizhnyk.cqrsbankingapp.web.dto.mapper;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Client;
import com.artemnizhnyk.cqrsbankingapp.web.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
}

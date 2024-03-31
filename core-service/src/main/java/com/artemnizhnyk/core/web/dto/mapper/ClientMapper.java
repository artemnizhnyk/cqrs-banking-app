package com.artemnizhnyk.core.web.dto.mapper;

import com.artemnizhnyk.common.domain.model.Client;
import com.artemnizhnyk.core.web.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {
}

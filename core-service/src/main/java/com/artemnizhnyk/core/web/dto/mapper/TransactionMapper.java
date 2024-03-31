package com.artemnizhnyk.core.web.dto.mapper;

import com.artemnizhnyk.common.domain.model.Transaction;
import com.artemnizhnyk.core.web.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends Mappable<Transaction, TransactionDto> {
}

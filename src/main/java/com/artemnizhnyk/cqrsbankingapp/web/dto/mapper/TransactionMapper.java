package com.artemnizhnyk.cqrsbankingapp.web.dto.mapper;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Transaction;
import com.artemnizhnyk.cqrsbankingapp.web.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends Mappable<Transaction, TransactionDto> {
}

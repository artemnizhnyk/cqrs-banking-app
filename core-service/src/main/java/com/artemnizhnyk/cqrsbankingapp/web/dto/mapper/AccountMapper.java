package com.artemnizhnyk.cqrsbankingapp.web.dto.mapper;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Account;
import com.artemnizhnyk.cqrsbankingapp.web.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}

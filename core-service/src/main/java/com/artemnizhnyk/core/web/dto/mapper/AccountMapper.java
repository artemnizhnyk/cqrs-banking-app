package com.artemnizhnyk.core.web.dto.mapper;

import com.artemnizhnyk.common.domain.model.Account;
import com.artemnizhnyk.core.web.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {
}

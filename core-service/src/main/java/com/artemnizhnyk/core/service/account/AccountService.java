package com.artemnizhnyk.core.service.account;

import com.artemnizhnyk.common.domain.model.Account;
import com.artemnizhnyk.core.service.CommandService;
import com.artemnizhnyk.core.service.QueryService;

public interface AccountService extends QueryService<Account>, CommandService<Account> {
}

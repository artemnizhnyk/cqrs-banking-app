package com.artemnizhnyk.cqrsbankingapp.service.account;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Account;
import com.artemnizhnyk.cqrsbankingapp.service.CommandService;
import com.artemnizhnyk.cqrsbankingapp.service.QueryService;

public interface AccountService extends QueryService<Account>, CommandService<Account> {
}

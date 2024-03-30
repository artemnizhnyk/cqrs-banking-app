package com.artemnizhnyk.cqrsbankingapp.service.transaction;

import com.artemnizhnyk.cqrsbankingapp.domain.model.Transaction;
import com.artemnizhnyk.cqrsbankingapp.service.CommandService;
import com.artemnizhnyk.cqrsbankingapp.service.QueryService;

public interface TransactionService extends QueryService<Transaction>, CommandService<Transaction> {
}

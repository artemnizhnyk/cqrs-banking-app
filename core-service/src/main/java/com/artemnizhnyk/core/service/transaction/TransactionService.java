package com.artemnizhnyk.core.service.transaction;

import com.artemnizhnyk.common.domain.model.Transaction;
import com.artemnizhnyk.core.service.CommandService;
import com.artemnizhnyk.common.service.QueryService;

public interface TransactionService extends QueryService<Transaction>, CommandService<Transaction> {
}

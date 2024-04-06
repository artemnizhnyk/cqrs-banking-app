package com.artemnizhnyk.eventhandler.service.transaction;

import com.artemnizhnyk.common.domain.model.Transaction;

public interface TransactionService {

    Transaction create(final Transaction transaction);
}

package com.bf.tx.demo3;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author bofei
 * @date 2018/9/20 9:44
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    private TransactionTemplate transactionTemplate;
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transfer(String from, String to, Double money) {
        accountDao.outMoney(from, money);
                int a = 10/0; // 模拟异常
        accountDao.inMoney(to, money);
    }
}

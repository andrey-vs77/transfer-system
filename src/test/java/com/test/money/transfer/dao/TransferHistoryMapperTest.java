package com.test.money.transfer.dao;

import com.test.money.transfer.BaseIntegrationTest;
import com.test.money.transfer.model.Account;
import com.test.money.transfer.model.Transfer;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TransferHistoryMapperTest extends BaseIntegrationTest {

    @Test
    public void save(){
        //Arrange
        Transfer transfer = new Transfer();
        Account from = new Account();
        from.setId(1);
        transfer.setFrom(from);
        Account to =new Account();
        to.setId(2);
        transfer.setTo(to);
        Date date = new Date();
        transfer.setDate(date);
        transfer.setFinished(true);
        BigDecimal amount = new BigDecimal(10).setScale(2);
        transfer.setAmount(amount);

        //Act
        transferHistoryDao.save(transfer);

        //Assert
        assertNotNull(transfer.getId());
    }

    @Test
    public void findAll(){
        //Arrange
        final int NOT_EXPECTED_SIZE = 0;
        List<Transfer> transfers = transferHistoryDao.findAll();

        //Assert
        assertNotEquals(NOT_EXPECTED_SIZE, transfers.size());
    }
}
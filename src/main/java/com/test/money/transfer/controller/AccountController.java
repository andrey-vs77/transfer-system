package com.test.money.transfer.controller;

import com.test.money.transfer.model.Account;
import com.test.money.transfer.service.AccountService;
import com.test.money.transfer.util.JsonConverter;
import com.test.money.transfer.validator.NullValueValidatorImpl;

import javax.inject.Inject;

import static spark.Spark.*;

public class AccountController extends AbstractController {

    private AccountService accountService;
    private NullValueValidatorImpl<Account> nullValueValidator;

    @Override
    public void init() {
        get("/account/:id", (req, resp) -> {
            resp.type(JSON_FORMAT);
            return accountService.findById(Integer.valueOf(req.params(":id")));
        }, JsonConverter::convertToJson);

        post("/accounts", (req, resp) -> {
            Account account = JsonConverter.convertFromJson(req, Account.class);
            resp.type(JSON_FORMAT);
            return accountService.create(account, nullValueValidator);
        }, JsonConverter::convertToJson);

        put("/account/:id", (req, resp) -> {
            Account account = JsonConverter.convertFromJson(req, Account.class);
            resp.type(JSON_FORMAT);
            return accountService.update(account, nullValueValidator);
        }, JsonConverter::convertToJson);
    }

    public AccountController() {
        init();
    }

    @Inject
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Inject
    public void setNullValueValidator(NullValueValidatorImpl<Account> nullValueValidator) {
        this.nullValueValidator = nullValueValidator;
    }
}

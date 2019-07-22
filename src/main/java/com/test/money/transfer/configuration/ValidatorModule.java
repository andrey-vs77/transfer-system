package com.test.money.transfer.configuration;

import com.google.inject.AbstractModule;
import com.test.money.transfer.validator.NullValueValidatorImpl;

public class ValidatorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(NullValueValidatorImpl.class);
    }
}

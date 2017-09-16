package com.sxli.service.Impl;

import com.sxli.service.sayHello;
import org.springframework.stereotype.Service;

@Service
public class sayHelloImpl implements sayHello {

    @Override
    public long returnThreadId() {
        return Thread.currentThread().getId();
    }
}

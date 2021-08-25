package com.kodilla.patterns2.facade;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OrderWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderWatcher.class);

    @After("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
        "&&target(object)")
    public void logEvent(final Object object){
        LOGGER.info("Class : " + object.getClass().getName() + " method processOrder finished");
    }
}

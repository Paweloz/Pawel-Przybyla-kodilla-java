package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;git
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    @Test
    void getLastLog() {
        //Given
        Logger logger = Logger.INSTANCE;
        //When
        logger.log("some text");
        String result = logger.getLastLog();
        //Then
        Assertions.assertEquals("some text", result);
    }
}

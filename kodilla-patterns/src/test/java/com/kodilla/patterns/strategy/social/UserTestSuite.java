package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        Millenials millenials = new Millenials("Adam");
        YGeneration yGeneration = new YGeneration("Marcin");
        ZGeneration zGeneration = new ZGeneration("Piotr");

        //When
        String millenialsSharePostStrategy = millenials.sharePost();
        String yGenerationSharePostStrategy = yGeneration.sharePost();
        String zGenerationSharePostStrategy = zGeneration.sharePost();

        //Then
        assertEquals("Facebook", millenialsSharePostStrategy);
        assertEquals("Twitter",yGenerationSharePostStrategy);
        assertEquals("Snapchat",zGenerationSharePostStrategy);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        Millenials millenials = new Millenials("Adam");
        millenials.setSocialPublisher(new SnapchatPublisher());

        //When
        String millenialsChangedSharePostStrategy = millenials.sharePost();

        //Then
        assertEquals("Snapchat", millenialsChangedSharePostStrategy);
    }
}

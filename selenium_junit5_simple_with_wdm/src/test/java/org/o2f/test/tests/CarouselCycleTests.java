package org.o2f.test.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.o2f.pages.CaroucelCyclePage;
import org.o2f.test.TestBaseLifeCycle;

public class CarouselCycleTests extends TestBaseLifeCycle {

    private static CaroucelCyclePage caroucelCyclePage;

    @BeforeAll
    static void setup(){
        caroucelCyclePage = new CaroucelCyclePage(driver);
    }

    @Test
    void answerTest(){
        /*
        * This test was an experiment for a stackexchange question that I replied
        */
        caroucelCyclePage.deltaTimeForCarouselElementSelect();
    }
}

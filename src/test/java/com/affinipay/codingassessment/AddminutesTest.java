package com.affinipay.codingassessment;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AddminutesTest {

    private Addminutes addminutes;
    private DateCalculator dateCalculator;

    @BeforeEach
    void initEachTest()
    {
        addminutes = new Addminutes();
        dateCalculator = new DateCalculator();
    }

    @Test
    void passingPositiveMinutesTest(){
        assertEquals("12:30 PM", dateCalculator.addMinutes("09:10 AM",200),"Adding 200 minutes to 09:10 AM");
    }

    @Test
    void passingNextDayTimeTest(){
        assertEquals("09:10 AM", dateCalculator.addMinutes("09:10 AM",1440),"Adding 24 hours to 09:10 AM");
    }

    @Test
    void passingBeforeDayTimeTest(){
        assertEquals("09:10 AM", dateCalculator.addMinutes("09:10 AM",-1440),"Adding -24 hours to 09:10 AM");
    }

    @Test
    void passingSameDayAt12Test(){
        assertEquals("12:10 AM", dateCalculator.addMinutes("12:00 AM",10),"Adding 10 minutes to 12:00 AM");
    }

    @Test
    void passingBeforeDayAt12Test(){
        assertEquals("11:50 PM", dateCalculator.addMinutes("12:00 AM",-10),"Adding -10 minutes to 12:00 AM");
    }

    @Test
    void passingNextDayTimeat12Test(){
        assertEquals("12:00 AM", dateCalculator.addMinutes("12:00 AM",1440),"Adding 24 hours to 12:00 AM");
    }

    @Test
    void passingBeforeDayTimeat12Test(){
        assertEquals("12:00 AM", dateCalculator.addMinutes("12:00 AM",-1440),"Adding -24 hours to 12:00 AM");
    }

    @Test
    void passingNext36hoursTimeat12Test(){
        assertEquals("12:00 PM", dateCalculator.addMinutes("12:00 AM",2160),"Adding 36 hours to 12:00 AM");
    }

    @Test
    void passingBefore36hoursTimeat12Test(){
        assertEquals("12:00 PM", dateCalculator.addMinutes("12:00 AM",-2160),"Adding -36 hours to 12:00 AM");
    }

    @Test
    void passingPositivezerominutesTest(){
        assertEquals("12:00 AM", dateCalculator.addMinutes("12:00 AM",0),"Adding 0 mins to 12:00 AM");
    }

    @Test
    void passingNegativezerominutesTest(){
        assertEquals("12:00 AM", dateCalculator.addMinutes("12:00 AM",-0),"Adding -0 mins to 12:00 AM");
    }

    @Test
    void passingNext12hoursTimeat12Test(){
        assertEquals("12:00 PM", dateCalculator.addMinutes("12:00 AM",720),"Adding 12 hours to 12:00 AM");
    }

    @Test
    void passingBefore12hoursTimeat12Test(){
        assertEquals("12:00 PM", dateCalculator.addMinutes("12:00 AM",-720),"Adding -12 hours to 12:00 AM");
    }

    @Test
    void passingNext12hoursTimeTest(){
        assertEquals("09:59 PM", dateCalculator.addMinutes("09:59 AM",720),"Adding 12 hours to 09:59 AM");
    }

    @Test
    void passingBefore12hoursTimeTest(){
        assertEquals("09:59 PM", dateCalculator.addMinutes("09:59 AM",-720),"Adding -12 hours to 09:59 AM");
    }

    @Test
    void positiveEdgeCaseScenarioTest(){
        assertEquals("12:00 PM", dateCalculator.addMinutes("11:59 AM",1),"Adding 1 min to 11:59 AM");
    }

    @Test
    void negativeEdgeCaseScenarioTest(){
        assertEquals("12:00 AM", dateCalculator.addMinutes("12:01 AM",-1),"Adding -1 min to 12:01 AM");
    }

    @Test
    void negativeEdgeCase2ScenarioTest(){
        assertEquals("11:59 PM", dateCalculator.addMinutes("12:00 AM",-1),"Adding -1 min to 12:00 AM");
    }

    @Test
    void passingNegativeMinutesTest(){
        assertEquals("08:59 AM", dateCalculator.addMinutes("09:10 AM",-11),"Adding -11 minutes to 09:10 AM");
    }

    @Test
    void passingInvalidHourTimeTest(){
        assertThrows(IllegalArgumentException.class,() -> dateCalculator.addMinutes("13:10 AM",200),"Sending an Invalid Hour");
    }

    @Test()
    void passingInvalidMinuteTimeTest(){
        assertThrows(IllegalArgumentException.class,() -> dateCalculator.addMinutes("12:61 AM",200),"Sending an Invalid Minutes");
    }

    @Test
    void passingInvalidTimeTest(){
        assertThrows(IllegalArgumentException.class,() -> dateCalculator.addMinutes("12:00 FM",200),"Sending an Invalid Time");
    }

    @Test
    void passingNullHourTimeTest(){
        assertThrows(IllegalArgumentException.class,() -> dateCalculator.addMinutes(":10 AM",200),"Sending an Null value for Hour");
    }

    @Test()
    void passingNullMinuteTimeTest(){
        assertThrows(IllegalArgumentException.class,() -> dateCalculator.addMinutes("12: AM",200),"Sending an Null value for Minutes");
    }

    @Test
    void passingNullTimeTest(){
        assertThrows(IllegalArgumentException.class,() -> dateCalculator.addMinutes("12:00",200),"Sending an Null value for AM/PM Format");
    }


}

package examples;

import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;

public class SamplesTestRunner {

    @BeforeAll
    public static void setup(){
        System.setProperty("karate.env", "qa");
    }

    @Karate.Test
    Karate firstTest(){
        return Karate.run("../FirstTest").relativeTo(getClass());
    }

    @Karate.Test
    Karate secondTest(){
        return Karate.run("../SecondTest").relativeTo(getClass());
    }
}

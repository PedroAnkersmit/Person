package person;

import org.example.person.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    /**
     * Tests
     * 1-Lista vacía
     */
    Person persona;
    @BeforeEach
    void initiate(){
        persona = new Person(null,0,null);
    }
    @AfterEach
    void shutdown(){
        persona = null;
    }
    @Test
    void averageOfEmpty(){
        double[] obtainedValue = persona.averageAgePerGender(new ArrayList<Person>());
        double[] expectedValue = new double[2];
        expectedValue[0] = 0.0;
        expectedValue[1] = 0.0;
        assertEquals(obtainedValue[0], expectedValue[0]);
        assertEquals(obtainedValue[1],expectedValue[1]);
    }

}

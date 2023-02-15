package person;

import org.example.person.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    /**
     * Tests
     * 1-Media de Null
     * 2-Media de Lista Vacía
     * 3-Media de Lista sin Hombres
     * 4-Media de Lista sin Mujeres
     * 5-Media igual para ambos sexos
     * 6-Medias diferentes
     * 7-Prueba del Getter del nombre
     */
    Person persona;
    List<Person> lista;
    @BeforeEach
    void initiate(){
        persona = new Person(null,0,null);
        lista = new ArrayList<Person>();
    }
    @AfterEach
    void shutdown(){
        persona = null;
        lista = null;
    }
    @Test
    void averageOfNull(){
        double[] obtainedValue = persona.averageAgePerGender(null);
        double[] expectedValue = new double[2];
        expectedValue[0] = 0.0;
        expectedValue[1] = 0.0;
        assertEquals(obtainedValue[0], expectedValue[0]);
        assertEquals(obtainedValue[1],expectedValue[1]);
    }
    @Test
    void averageOfEmpty(){
        double[] obtainedValue = persona.averageAgePerGender(lista);
        double[] expectedValue = new double[2];
        expectedValue[0] = 0.0;
        expectedValue[1] = 0.0;
        assertEquals(obtainedValue[0], expectedValue[0]);
        assertEquals(obtainedValue[1],expectedValue[1]);
    }
    @Test
    void averageWithNoMales(){
        lista.add(new Person("Ana", 20, "Female"));
        lista.add(new Person("Maria", 40, "Female"));
        lista.add(new Person("Julia", 24, "Female"));
        lista.add(new Person("Tomasa", 36, "Female"));
        double[] obtainedValue = persona.averageAgePerGender(lista);
        double[] expectedValue = new double[2];
        expectedValue[0] = 0.0;
        expectedValue[1] = 30.0;
        assertEquals(obtainedValue[0], expectedValue[0]);
        assertEquals(obtainedValue[1],expectedValue[1]);
    }
    @Test
    void averageWithNoFemales(){
        lista.add(new Person("Andres", 20, "Male"));
        lista.add(new Person("Marcos", 40, "Male"));
        lista.add(new Person("Julian", 24, "Male"));
        lista.add(new Person("Tomy", 36, "Male"));
        double[] obtainedValue = persona.averageAgePerGender(lista);
        double[] expectedValue = new double[2];
        expectedValue[0] = 30.0;
        expectedValue[1] = 0.0;
        assertEquals(obtainedValue[0], expectedValue[0]);
        assertEquals(obtainedValue[1],expectedValue[1]);
    }
    @Test
    void sameAverageForBoth(){
        lista.add(new Person("Andres", 20, "Male"));
        lista.add(new Person("Marcos", 40, "Male"));
        lista.add(new Person("Julian", 24, "Male"));
        lista.add(new Person("Tomy", 36, "Male"));
        lista.add(new Person("Ana", 20, "Female"));
        lista.add(new Person("Maria", 40, "Female"));
        lista.add(new Person("Julia", 24, "Female"));
        lista.add(new Person("Tomasa", 36, "Female"));
        double[] obtainedValue = persona.averageAgePerGender(lista);
        double[] expectedValue = new double[2];
        expectedValue[0] = 30.0;
        expectedValue[1] = 30.0;
        assertEquals(obtainedValue[0], expectedValue[0]);
        assertEquals(obtainedValue[1],expectedValue[1]);
    }
    @Test
    void differentAverage(){
        lista.add(new Person("Andres", 20, "Male"));
        lista.add(new Person("Marcos", 40, "Male"));
        lista.add(new Person("Julian", 24, "Male"));
        lista.add(new Person("Tomy", 36, "Male"));
        lista.add(new Person("Ana", 20, "Female"));
        lista.add(new Person("Maria", 40, "Female"));
        lista.add(new Person("Julia", 28, "Female"));
        lista.add(new Person("Tomasa", 52, "Female"));
        double[] obtainedValue = persona.averageAgePerGender(lista);
        double[] expectedValue = new double[2];
        expectedValue[0] = 30.0;
        expectedValue[1] = 35.0;
        assertEquals(obtainedValue[0], expectedValue[0]);
        assertEquals(obtainedValue[1],expectedValue[1]);
    }
    @Test
    void nameGetter(){
        persona = new Person("Julia", 28, "Female");
        String obtainedValue = persona.getName();
        String expectedValue = "Julia";
        assertEquals(obtainedValue, expectedValue);
    }
}

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVParserTest {

    private final static String SEPARATOR = " , ";
    private static final String NEW_LINE = "\n";

    @CSVEntity
    private class Parsable {
    }

    private class NotParsable {
    }

    @CSVEntity
    private class HasFields {
        @CSVField
        public String name;
    }

    @Test
    public void isParsable() {
        assertTrue(new CSVParser().isParsable(new Parsable()));
    }
    @Test
    public void isNotParsable() {
        assertFalse(new CSVParser().isParsable(new NotParsable()));
    }

    @Test
    public void getFields() {
        Field expectedField = HasFields.class.getDeclaredFields()[0];
        Field actualField = new CSVParser().getFields(new HasFields()).get(0);
        assertEquals(expectedField, actualField);
    }

    @Test
    public void parse() {
        Person person1 = new Person("Anna", 20, 160);
        Person person2 = new Person("Berta", 30, 180);
        Person person3 = new Person("Carlo", 40, 170);

        List<Person> persons = new ArrayList<>(Arrays.asList(person1, person2, person3));
        String expectedCSV = """
                name , height
                Anna , 160
                Berta , 180
                Carlo , 170""" + NEW_LINE;
        String actualCSV = new CSVParser().parse(persons);

        assertEquals(expectedCSV, actualCSV);
    }

    @Test
    public void generateCSVHeader() {
        String expectedCSVHeader = "name" + SEPARATOR + "height" + NEW_LINE;
        String actualCSVHeader = new CSVParser().generateCSVHeader(new Person());  // braucht man default constructor in Person Klasse

        assertEquals(expectedCSVHeader, actualCSVHeader);
    }

    @Test
    public void generateCSVContent() {
        Person person1 = new Person("Anna", 20, 160);
        Person person2 = new Person("Berta", 30, 180);
        Person person3 = new Person("Carlo", 40, 170);

        List<Person> persons = new ArrayList<>(Arrays.asList(person1, person2, person3));

        String expectedCSVContent = """
                Anna , 160
                Berta , 180
                Carlo , 170""" + NEW_LINE;
        String actualCSVContent = new CSVParser().generateCSVContent(persons);

        assertEquals(expectedCSVContent, actualCSVContent);
    }
}
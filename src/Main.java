
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("Anna", 20, 160);
        Person person2 = new Person("Berta", 30, 180);
        Person person3 = new Person("Carlo", 40, 170);

        List<Person> persons = new ArrayList<>(Arrays.asList(person1, person2, person3));

        Boolean parsable = new CSVParser().isParsable(persons);

        System.out.println("Is it parsable? " + parsable);


        String csv = new CSVParser().parse(persons); // Liste "persons" (collection of objects) wird in eine CSV-Datei umgewandelt

        System.out.println(csv);

    }
}

// erstellt drei Objekte
//erstellt eine Liste welche die drei Objekte enthält
// Klasse CSVParser wandelt Klassen in CSV-Datei um;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// Klasse CSVParser wandelt Klassen in CSV-Datei um;
public class CSVParser {

    private final static String SEPARATOR = " , ";
    private static final String NEW_LINE = "\n";

    /**
     * Checks if an object is parsable by checking if the @CSVEntity annotation is present at the class of the object
     *
     * @param obj The object to check
     * @return If the object is parsable to a csv string
     */

    public boolean isParsable(Object obj) {
        return obj.getClass().getAnnotation(CSVEntity.class) != null; // warum false?
    }


    /**
     * Gets all fields for the csv export which are annotated with @CSVField
     *
     * @param obj The object to extract all fields
     * @return All fields which are necessary for a csv export
     */

    public List<Field> getFields(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        List<Field> csvFields = new ArrayList<>();

        for (Field f : fields) {
            if (f.getAnnotation(CSVField.class) != null) {      //check if annotated
                csvFields.add(f);                               // if so, added to csvFields List
            }
        }
        return csvFields;
    }


    /**
     * Parse a collection of java objects to a csv file
     *
     * @param persons The persons to write to the csv file
     * @return the csv string
     */

    public String parse(List<Person> persons) {
        if (persons.isEmpty()) return ""; // if empty list is provided

        StringBuilder csv = new StringBuilder(); // create csv file
        csv.append(generateCSVHeader(persons.get(0))); // erstellt header
        csv.append(generateCSVContent(persons));

        return csv.toString(); // csv string file
    }


    /**
     * Generate the csv header for the provided object
     *
     * @param person - The object to extract the header
     * @return - The header in csv format
     */

    public String generateCSVHeader(Person person) {
        StringBuilder header = new StringBuilder();

        List<Field> fields = this.getFields(person);
        for (int i = 0; i < fields.size(); i++) {
            header.append(fields.get(i).getName()); // add attribute name
            if (i != fields.size() - 1) {  // if not last attribute add separator
                header.append(SEPARATOR);
            } else {  // if last attribute add new line
                header.append(NEW_LINE);
            }
        }
        return header.toString();
    }


    public String generateCSVContent(List<Person> persons) {
        StringBuilder csvContent = new StringBuilder();
        try {
            for(Person person : persons) {
                List<Field> fields = this.getFields(person);
                for (int i = 0; i < fields.size(); i++) {
                    csvContent.append(fields.get(i).get(person)); // add attribute content for each person
                    if (i != fields.size() - 1) {  // if not last attribute add separator
                        csvContent.append(SEPARATOR);
                    } else {  // if last attribute add new line
                        csvContent.append(NEW_LINE);
                    }
                }
            }
        } catch(Exception e) {
            System.out.println("Could not access value");
        }
        return csvContent.toString();
    }


}

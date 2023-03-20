import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main_Reflections {

    public static void main(String[] args) {

        Field[] personFields = Person.class.getFields();

        for (Field field : personFields) {
            System.out.println(field.getName());
        }

        System.out.println();

        Method[] personMethods = Person.class.getMethods();

        for (Method field : personMethods) {
           // System.out.println(method.getName());
        }

        System.out.println("Methods that return String: ");
    }
}

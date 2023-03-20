import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Annotation to mark fields as parsable
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface CSVField {
}

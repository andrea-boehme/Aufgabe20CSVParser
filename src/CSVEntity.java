import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Annotation to mark classes as parsable
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface CSVEntity {

}

import java.util.Objects;

// mark class Person with CSVEntity
// class should be converted to CSV
// mark fields with CSVField; they are relevant when export to CSV file
@CSVEntity
public class Person {

    @CSVField
    public String name; // name marked with annotation

    public Integer age; // age not marked with annotation

    @CSVField
    public Integer height; // height marked with annotation

    /**
     * constructor method used to initialize objects. It is called when an object of a class is created.
     * @param name
     * @param age
     */
    public Person(String name, Integer age, Integer height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public void getPerson() {
        System.out.println(name);
        System.out.println(age);
        System.out.println(height);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getName(), person.getName()) && Objects.equals(getAge(), person.getAge()) && Objects.equals(getHeight(), person.getHeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getHeight());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return age.equals(person.age) && firstName.equals(person.firstName) && lastName.equals(person.lastName) && height.equals(person.height) && weight.equals(person.weight);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && height == person.height && weight == person.weight && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
  }


    @Override
    public int hashCode() {
        return Objects.hash(age, firstName, lastName, height, weight);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

     */
}


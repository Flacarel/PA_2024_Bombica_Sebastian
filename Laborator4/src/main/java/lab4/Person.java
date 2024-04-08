package lab4;


import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@Setter
public class Person {
    String name;
    int age;
    String destination;

    public boolean isDriver(Person p) {
        return p instanceof Driver;
    }
}

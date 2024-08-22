package peaksoft.springbootlessonjava13.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(
            generator = "user_gen",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "user_gen",
            sequenceName = "user_seq",
            allocationSize = 1
    )
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL})
    private List<Post>posts;

    public User(String firstName, String lastName, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }
}

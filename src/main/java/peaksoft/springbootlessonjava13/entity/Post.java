package peaksoft.springbootlessonjava13.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "post_gen")
    @SequenceGenerator(name = "post_gen",sequenceName = "post_seq",allocationSize = 1)
    private Long id;
    private String title;
    private String description;
    private String image;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private User user;


    public Post(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }
}

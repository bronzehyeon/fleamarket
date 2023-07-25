package project.fleamarket;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class User {


    @Id @GeneratedValue
    @Column(name = "user_id")
    private long id;

    private String userName;//아이디?

    private String Name;

    private String password;

    private String nickname;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();


}

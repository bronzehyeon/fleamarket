package project.fleamarket.Member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.fleamarket.Post.Post;

import java.util.ArrayList;
import java.util.List;
@Entity
@Getter @Setter
public class Member {


    @Id @GeneratedValue
    @Column(name = "member_id")
    private long id;

    private String userId;//아이디?

    private String name;

    private String password;

    private String nickname;

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

}


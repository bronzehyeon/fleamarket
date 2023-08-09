package project.fleamarket.Member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import project.fleamarket.Post.Post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter @Setter
public class Member {
    public Member() {

    }

    public Member(@NonNull String userId, @NonNull String name, @NonNull String password, @NonNull String nickname) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.joinDate = LocalDate.now();
    }

    @Id @GeneratedValue
    @Column(name = "member_id")
    private long id;

    @NonNull
    private String userId;//아이디?

    @NonNull
    private String name;

    @NonNull
    private String password;

    @NonNull()
    private String nickname;

    private LocalDate joinDate;

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

}


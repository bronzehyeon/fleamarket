package project.fleamarket.Post.Comment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.fleamarket.Post.Post;
import project.fleamarket.Member.Member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member writer;

    private String text;

    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "comment")
    private List<SubComment> sub_comments = new ArrayList<>();

}

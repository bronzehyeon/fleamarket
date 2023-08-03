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

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member writer;

    private String text;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "comment")
    private List<Sub_comment> sub_comments = new ArrayList<>();

}

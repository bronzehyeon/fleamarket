package project.fleamarket.Post.Comment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.fleamarket.Member.Member;

import java.util.Date;

@Entity
@Getter @Setter
public class SubComment {

    @Id
    @GeneratedValue
    @Column(name = "sub_comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member writer;

    private String text;

    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

}

package project.fleamarket;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User writer;

    private String text;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "comment")
    private List<Sub_comment> sub_comments = new ArrayList<>();

}

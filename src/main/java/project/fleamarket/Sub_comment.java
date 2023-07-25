package project.fleamarket;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sub_comment {

    @Id
    @GeneratedValue
    @Column(name = "sub_comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User writer;

    private String text;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;



}

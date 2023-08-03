package project.fleamarket.Post;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.fleamarket.Category;
import project.fleamarket.Post.Comment.Comment;
import project.fleamarket.Member.Member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Post {
    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String title;

    private String item;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private int price;

    private Date date;

//    private TradeType tradeType;

    private String Text;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

}
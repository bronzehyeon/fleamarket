package project.fleamarket.Post;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import project.fleamarket.Category.Category;
import project.fleamarket.Post.Comment.Comment;
import project.fleamarket.Member.Member;
import project.fleamarket.TradeType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Post {
    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    public Post() {

    }

    public Post(Long id, @NonNull String title, Category category, int price, LocalDateTime localDateTime, @NonNull TradeType tradeType, String text) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.localDateTime = localDateTime;
        this.tradeType = tradeType;
        this.text = text;
    }

    @NonNull
    private String title;

//    private String item;

    @Enumerated
    private Category category;

    @NonNull
    private int price;

    private LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    @NonNull
    private TradeType tradeType;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

}

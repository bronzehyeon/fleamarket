package project.fleamarket;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String title;

    private String item;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private String category;

    private int price;

    private Date date;

    private TradeType tradeType;

    private String Text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();
}

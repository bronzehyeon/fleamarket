package project.fleamarket;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Post> posts = new ArrayList<>();
}

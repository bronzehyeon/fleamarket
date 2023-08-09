package project.fleamarket.Post;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.fleamarket.Member.Member;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(Post post) {
        em.persist(post);
    }

    public Post findOne(Long id) {
        return em.find(Post.class, id);
    }

    public List<Post> findAll() {
        return em.createQuery("select p from Post p", Post.class)
                .getResultList();
    }

    public List<Post> findByCategory(String categoryName) {//카테고리에 해당하는 게시글들 반환
        return em.createQuery("select p from Post p where p.category = :categoryName", Post.class)
                .setParameter("categoryName", categoryName)
                .getResultList();
    }

    public List<Post> findByWriter(Long id) {//유저가 작성한 게시물 리스트
        return em.createQuery("select p from Post p where p.member.id = :id", Post.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Post> findByTitle(String title) {//제목을 통한 검색 들어있는지 검색
        return em.createQuery("select p from Post p where p.title like :keyword", Post.class)
                .setParameter("keyword", "%" + title + "%")
                .getResultList();
    }

//    public List<Post> findByWordInText(String word) {//본문에 단어가 포함되어 있는지 검색
//        return em.createQuery("select p from Post p where p.title like :keyword", Post.class)
//                .setParameter("keyword", "%" + word + "%")
//                .getResultList();
//    }
    public List<Post> findByWordInTextOrTitle(String word) {//제목 또는 본문에 단어가 포함되어 있는지 검색
        return em.createQuery("select p from Post p where p.title like :keyword or p.text like :keyword", Post.class)
                .setParameter("keyword", "%" + word + "%")
                .getResultList();
    }



}

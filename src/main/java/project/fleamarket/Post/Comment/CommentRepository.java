package project.fleamarket.Post.Comment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.fleamarket.Post.Post;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(Comment comment) {
        em.persist(comment);
    }

    public List<Comment> findByPost(Long postId) {//게시물의 댓글 리스트
        return em.createQuery("select c from Comment c where c.id = :id", Comment.class)
                .setParameter("id", postId)
                .getResultList();
    }
}

package project.fleamarket.Post.Comment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubCommentRepository {


    @PersistenceContext
    private final EntityManager em;

    public void save(SubComment subcomment) {
        em.persist(subcomment);
    }

    public List<SubComment> findByComment(Long CommentId) {//댓글의 대댓글 리스트
        return em.createQuery("select s from SubComment s where c.id = :id", SubComment.class)
                .setParameter("id", CommentId)
                .getResultList();
    }
}

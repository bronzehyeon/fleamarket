package project.fleamarket.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public Long posting(Post post) {
        postRepository.save(post);
        return post.getId();
    }

    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    public List<Post> findPostByWord(String word){//검색 방식 선택에 따라 제목, 또는 제목 + 본문에 해당하는 단어가 있는지 검색
        if(true){//검색 방식이 제목으로 선택되어 있는 경우
            return postRepository.findByTitle(word);
        }
        else{
            return postRepository.findByWordInTextOrTitle(word);
        }
    }

}

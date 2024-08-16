package me.yeonkaeun.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import me.yeonkaeun.springbootdeveloper.domain.Article;
import me.yeonkaeun.springbootdeveloper.dto.AddArticleRequest;
import me.yeonkaeun.springbootdeveloper.dto.UpdateArticleRequest;
import me.yeonkaeun.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }
    //블로그  글 하나를 조회하는 메서드
    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+ id ));
    }

    //데이터베이스에서 데이터를 삭제
    public void delete(long id){
        blogRepository.deleteById(id);
    }
    //글을 수정하는 메서드
    @Transactional //트랜잭션 메서드
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+ id));
        article.update(request.getTitle(),request.getContent());
        return article;
    }
}

package me.yeonkaeun.springbootdeveloper.repository;

import me.yeonkaeun.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article,Long> {
}

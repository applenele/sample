package com.dxy.lenny.sample.boot.dao;

import com.dxy.lenny.sample.boot.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author niele
 * @date 2018/7/5
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}

package com.smallcode.sample.sample.springboot.cache.redis.dao;

import com.smallcode.sample.sample.springboot.cache.redis.model.Article;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

/**
 * @Auther: lenny
 * @Date: 2018/12/1 23:42
 * @Description:
 */
@Mapper
public interface ArticleMapper {

  @Select("select * from b_article")
  List<Article> getAll();

  @Select("select * from b_article where id=#{id}")
  @Cacheable(cacheNames = {"article"})
  Article getById(Integer id);
}

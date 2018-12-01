package com.smallcode.sample.springboot.mybatis.dao;

import java.util.List;

import com.smallcode.sample.springboot.mybatis.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: lenny
 * @Date: 2018/12/1 23:42
 * @Description:
 */
//@Mapper
public interface ArticleMapper {

	@Select("select * from b_article")
	List<Article> getAll();
}

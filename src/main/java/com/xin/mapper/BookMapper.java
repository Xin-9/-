package com.xin.mapper;

import com.xin.entity.Book;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BookMapper {
   
    int deleteByPrimaryKey(String bid);

    int insert(Book record);

    Book selectByPrimaryKey(String bid);

   
    List<Book> selectAll();

   
    int updateByPrimaryKey(Book record);

	

	List<Book> selectBooksLikeBnameOrAuthorOrPress(@Param("word") String word);

	List<Book> selectBooksLikeBnameOrAuthor(@Param("keyword1")String keyword1,@Param("keyword2") String keyword2);

	

	List<Book> selectBooksByExample(Book book);
}
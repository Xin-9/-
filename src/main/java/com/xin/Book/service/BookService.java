package com.xin.Book.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xin.entity.Book;
import com.xin.mapper.BookMapper;

@Service
public class BookService {
	@Autowired
	private BookMapper bookMapper;

	
	public Book getBooksByBid(String bid) {
		// TODO Auto-generated method stub
		return bookMapper.selectByPrimaryKey(bid);
	}

	
	public List<Book> getBooksBySearch(List<String> keyword_list) {
		int size = keyword_list.size();
		List<Book> books = null;
		switch (size) {
		case 0:
			// 查询所有
			return bookMapper.selectAll();

		case 1:
			// 有可能是 书名的一部分， 还有可能 是 作者 一部分， 还有可能 出版社
			books = bookMapper.selectBooksLikeBnameOrAuthorOrPress(keyword_list.get(0));
			Set<Book> set = new HashSet<Book>(books);
			books = new ArrayList<Book>(set);
			return books;
		case 2:
		default:
			//
			books = bookMapper.selectBooksLikeBnameOrAuthor(keyword_list.get(0), keyword_list.get(1));
			Set<Book> set2 = new HashSet<Book>(books);
			books = new ArrayList<Book>(set2);
			return books;

		}

	}

	
	public List<Book> getBooksByExample(Book book) {
		// TODO Auto-generated method stub
		
		return bookMapper.selectBooksByExample(book);
	}

}


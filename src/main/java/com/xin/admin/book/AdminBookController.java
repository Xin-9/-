package com.xin.admin.book;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xin.Book.service.BookService;
import com.xin.entity.Book;

	
	@Controller
	@RequestMapping("/book1")
	public class AdminBookController {

		@Autowired
		private BookService bookService;
		
		@ModelAttribute
		public void getUrl(Model model, HttpServletRequest request) throws Exception {
			
			String uri = request.getRequestURI();
			Map<String, String[]> map = request.getParameterMap();

			if (map.size() != 0) {
				uri = uri + "?xxx=xxx";
				Set<String> set = map.keySet();
				List<String> keys = new ArrayList<String>(set);
				for (String param_name : keys) {
					String param_value = map.get(param_name)[0];
				
					System.out.println(param_value);
					
					//param_value =  new String(param_value.getBytes("iso8859-1"),"utf-8");
					param_value  =new String(param_value.getBytes("iso8859-1"),"utf-8");
					if (!param_name.equals("pageNum") && !param_name.equals("xxx")) {
						/// uri
						uri = uri + "&" + param_name + "=" + param_value;
					}
				}
			}
			System.out.println(uri);
			
			model.addAttribute("url", uri);

		}
		
		@RequestMapping("/getBooksByExample.action")
		public  String  getBooksByExample(Book  book,  Model model,@RequestParam(defaultValue="1")Integer pageNum) throws Exception {
			if(book.getBid()!=null&&!book.getBid().equals("")) {
				book =   bookService.getBooksByBid(book.getBid());
				model.addAttribute("book", book);
				return  "adminjsps/admin/book/desc";
			}
			if(book.getAuthor()!=null&&!book.getAuthor().equals("")) {
				book.setAuthor(new String(book.getAuthor().getBytes("iso8859-1"),"utf-8"));
			}
			
			if(book.getPress()!=null&&!book.getPress().equals("")) {
				book.setPress(new String(book.getPress().getBytes("iso8859-1"),"utf-8"));
			}
			if(book.getBname()!=null&&!book.getBname().equals("")) {
				book.setBname(new String(book.getBname().getBytes("iso8859-1"),"utf-8"));
			}
			
			PageHelper.startPage(pageNum, 8);
			List<Book>  books = bookService.getBooksByExample(book);
			PageInfo<Book>   info =  new PageInfo<Book>(books);
			model.addAttribute("info", info);
			model.addAttribute("books", books);
			return    "adminjsps/admin/book/list";
		}
	
		
	}



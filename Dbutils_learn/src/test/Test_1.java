package test;

import dao.AuthorDao;
import entity.Author;
import org.junit.Test;

public class Test_1 {
	@Test
	public void Add() {
		Author author=new Author();
		author.setId("2");
		author.setUsername("aa");
		author.setPassword("321");
		author.setEmail("123@qq.com");
		AuthorDao t=new AuthorDao();
		t.add(author);
	}
	@Test
	public void Upadet() {
		Author author=new Author();
		author.setId("1");
		author.setUsername("bb");
		author.setPassword("123");
		author.setEmail("abc@qq.com");
		AuthorDao t=new AuthorDao();
		t.update(author);
	}
	@Test
	public void Delete() {
		
		AuthorDao t=new AuthorDao();
		t.delete("1");
	}
	@Test
	public void findById() {
		
		AuthorDao t=new AuthorDao();
		System.out.println(t.findById("2"));
	}
	@Test
	public void findAll() {
		
		AuthorDao t=new AuthorDao();
		System.out.println(t.findAll());
	}
}

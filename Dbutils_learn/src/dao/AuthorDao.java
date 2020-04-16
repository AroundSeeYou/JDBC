package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.Author;
import util.C3p0Util;
import util.DBCPUtil;
import util.DuridUtil;


public class AuthorDao {
	public void add(Author author) {
		QueryRunner qr=new QueryRunner();
		try {
			Connection conn=DuridUtil.getConn();
			String sql = "insert into author(id, username, password, email) values(?, ?, ?, ?)";
			qr.update(conn, sql, author.getId(),author.getUsername(),author.getPassword(),author.getEmail());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void update(Author author) {
		QueryRunner qr=new QueryRunner();
		try {
			
			Connection conn=C3p0Util.getConn();
			String sql = "update author set username=?,password=?,email=? where id=?";
			qr.update(conn, sql,author.getUsername(),author.getPassword(),author.getEmail(),author.getId());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String id) {
		QueryRunner qr=new QueryRunner();
		try {
			Connection conn=C3p0Util.getConn();
			//System.out.println("数据库连接成功！");
			String sql = "delete from author where id=?";
			qr.update(conn, sql,id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Author findById(String id) {
		Author author = null;
		QueryRunner qr=new QueryRunner();
		ResultSetHandler<Author> r=new BeanHandler<Author>(Author.class);
		try {
			Connection conn=DBCPUtil.getConn();
			String sql = "select * from author where id = ?";
			author= qr.query(conn, sql, r, id); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return author;
	}
	
	public List<Author> findAll(){
		List<Author> authors = new ArrayList<Author>();
		QueryRunner qr=new QueryRunner();
		ResultSetHandler<List<Author>> r=new BeanListHandler<Author>(Author.class);
		try{
			Connection conn=C3p0Util.getConn();
			String sql = "select * from author";
			authors=qr.query(conn, sql, r);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return authors;
	}
}

package util;
import org.apache.commons.dbcp2.BasicDataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;



import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;



import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
public class C3p0Util {
	static Connection conn;
	static {
		Properties properties=new Properties();
		InputStream is=C3p0Util.class.getResourceAsStream("/dp.properties");
		try {
			properties.load(is);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			try {
				ComboPooledDataSource ds = new ComboPooledDataSource();
				
				ds.setDriverClass(properties.getProperty("driverClassName"));
				ds.setJdbcUrl(properties.getProperty("url"));
				ds.setUser(properties.getProperty("username"));
				ds.setPassword(properties.getProperty("password"));
				 conn=ds.getConnection();
				System.out.println("656"+conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static Connection getConn() {
		return conn;
	}
}

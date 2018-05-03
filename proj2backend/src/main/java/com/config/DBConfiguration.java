package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.BlogComment;
import com.model.BlogPost;
import com.model.BlogPostLikes;
import com.model.Friend;
import com.model.Job;
import com.model.Notification;
import com.model.ProfilePicture;
import com.model.User;



@Configuration
@EnableTransactionManagement
public class DBConfiguration {

	public DBConfiguration(){
		System.out.println("DBConfiguration class and instantiated");
	}
	
	@Bean
	public SessionFactory sessionFactory()
	{
		LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(getDataSource()); 
		Properties p=new Properties();
		p.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		p.put("hibernate.hbm2ddl.auto","update");
		p.put("hibernate.show_sql","true");
		lsfb.addProperties(p);
		Class classes[]=new Class[]{User.class,Job.class,BlogPost.class,Notification.class,BlogPostLikes.class,BlogComment.class,ProfilePicture.class,Friend.class};
		return lsfb.addAnnotatedClasses(classes).buildSessionFactory();
	}
	
	@Bean
	public DataSource getDataSource()
	{
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/tushar10");
		datasource.setUsername("sa");
		datasource.setPassword("");
		System.out.println("h2 config");
		return datasource;
	}
	
	@Bean
	public HibernateTransactionManager hibTransManagement()
	   {
			return new  HibernateTransactionManager(sessionFactory());
			
	   }

}

package com.dao;

import java.util.List;

import com.model.BlogComment;
import com.model.BlogPost;

public interface BlogPostDao {

	void addBlogPost(BlogPost blogPost);
	List<BlogPost> listOfBlogs(int approved);
	BlogPost getBlog(int id);
	void reject(BlogPost blog,String rejectionReason);
	void approve(BlogPost blog);
	void addBlogComment(BlogComment blogComment);
	List<BlogComment> getAllBlogComments(int blogPostId);
}

package com.dao;

import com.model.BlogPost;
import com.model.BlogPostLikes;

public interface BlogPostLikesDao {

	BlogPostLikes hasUserLikedBlog(int blogId,String email);

	BlogPost updateLikes(int id, String email);
}

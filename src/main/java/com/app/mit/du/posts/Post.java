package com.app.mit.du.posts;

import com.app.mit.du.interfaces.Likeable;

public class Post implements Likeable {
	String content;
	int likes;

	public Post(String content, int likes) {
		this.content = content;
		this.likes = likes;
	}

	@Override
	public void like() {

	}

	@Override
	public void unlike() {

	}
}

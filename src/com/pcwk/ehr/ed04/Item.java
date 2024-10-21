package com.pcwk.ehr.ed04;

public class Item {

//	"title":"<b>홍대<\/b> 맛집 상수 카페 예쁜 정원이 있는 :: 수상한 <b>베이글<\/b> <b>홍대<\/b>",
//	"link":"https:\/\/blog.naver.com\/h_dnii\/223621413178",
//	"description":"<b>베이글<\/b>과 싱그러운 분위기의 <b>홍대<\/b> 맛집 상수 카페, 수상한 <b>베이글<\/b> <b>홍대<\/b> #마포카페 #마포데이트 #마포맛집 #마포<b>베이글<\/b> #상수카페 #상수데이트 #상수<b>베이글<\/b> #상수베이커리맛집 #수상한<b>베이글<\/b> #수상한<b>베이글<\/b><b>홍대<\/b>",
//	"bloggername":"오늘의 여행일지",
//	"bloggerlink":"blog.naver.com\/h_dnii",
//	"postdate":"20241016"

	private String title; // 제목

	public Item(String title, String link, String description, String bloggername, String bloggerlink,
			String postdate) {
		super();
		this.title = title;
		this.link = link;
		this.description = description;
		this.bloggername = bloggername;
		this.bloggerlink = bloggerlink;
		this.postdate = postdate;
	}

	private String link; // 링크
	private String description; // 설명
	private String bloggername; // 블로거 이름
	private String bloggerlink; // 블로거 링크
	private String postdate; // 작성일

	public Item() {
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getDescription() {
		return description;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getBloggername() {
		return bloggername;
	}

	public String getBloggerlink() {
		return bloggerlink;
	}

	public String getPostdate() {
		return postdate;
	}

	public void setBloggername(String bloggername) {
		this.bloggername = bloggername;
	}

	public void setBloggerlink(String bloggerlink) {
		this.bloggerlink = bloggerlink;
	}

	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [title=" + title + ", link=" + link + ", description=" + description + ", bloggername="
				+ bloggername + ", bloggerlink=" + bloggerlink + ", postdate=" + postdate + "]";
	}

}

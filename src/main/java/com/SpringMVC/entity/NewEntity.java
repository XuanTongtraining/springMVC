package com.SpringMVC.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity//khia báo cái này thì có trường id mới mapping dc database
@Table(name = "new")
public class NewEntity extends BaseEntity {
	
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "thumbnail")
	private String thumbnail;
	
	@Column(name = "shortdescription", columnDefinition = "TEXT")
	private String shortDescription;
	//mắc định của String là vachar 255, số lượng ký tự ít ko đủ
	//ta phải sử dụng thủ thuật để định nghĩa nó là text để ko giới hạn ký tự
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
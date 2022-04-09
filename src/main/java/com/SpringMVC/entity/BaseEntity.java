package com.SpringMVC.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass//để các entity kế thừa nó có thể mapping các feil như id,....
@EntityListeners(AuditingEntityListener.class)//để sử dụng cơ chế JPAuditing hỗ trợ creatdate, modifidate...
public abstract class BaseEntity {
	
	//Thêm abstract để đúng cấu trúc, 1 class pojo đúng nghĩa thì nó sẽ mapper với 1 table trong mysql,
	//còn cái Base này chỉ là class chung để các class khác kế thừa -> bản chất nó là abstract class
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//bắt buộc phải có, ko thì sẽ lỗi
	private Long id;
	
	@Column(name = "createddate")
	@CreatedDate
	private Date createdDate;
	
	@Column(name = "modifieddate")
	@LastModifiedDate
	private Date modifiedDate;
	
	@Column(name = "createdby")
	@CreatedBy
	private String createdBy;
	
	@Column(name = "modifiedby")
	@LastModifiedBy
	private String modifiedBy;

	public Long getId() {
		return id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}
}
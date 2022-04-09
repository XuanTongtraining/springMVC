package com.SpringMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringMVC.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{
	// dang tais su dung tinhs nang cua jpaRepository
	//thay thế gennericDao trong JDBC các hàm thao tác dữ liệu
	//tham số 1: Lấy dữ liệu bảng ta thao tác lên
	//tham số 2:kiểu dữ liệu của khóa chính: id Long

}

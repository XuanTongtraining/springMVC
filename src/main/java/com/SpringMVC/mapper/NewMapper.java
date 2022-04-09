package com.SpringMVC.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.SpringMVC.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		try {
			NewModel news = new NewModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("category_id"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			news.setCreatedDate(resultSet.getTimestamp("created_date"));
			news.setCreatedBy(resultSet.getString("created_by"));
			if (resultSet.getTimestamp("modified_date") != null) {
				news.setModifiedDate(resultSet.getTimestamp("modified_date"));
			}
			if (resultSet.getString("modified_by") != null) {
				news.setModifiedBy(resultSet.getString("modified_by"));
			}
			return news;
		} catch (SQLException e) {
			return null;
		}	
	}
}

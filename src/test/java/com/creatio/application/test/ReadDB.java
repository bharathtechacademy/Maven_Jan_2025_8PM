package com.creatio.application.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.creatio.framework.utilities.DBUtil;

public class ReadDB {

	public static void main(String[] args) throws SQLException {

		String query = "SELECT FILM.TITLE AS MOVIE, CATEGORY.NAME AS CATEGORYNAME, LANGUAGE.NAME as LANGUAGE FROM CATEGORY JOIN FILM_CATEGORY ON CATEGORY.category_id =FILM_CATEGORY.category_id JOIN FILM ON FILM_CATEGORY.FILM_ID = FILM.FILM_ID JOIN LANGUAGE ON FILM.LANGUAGE_ID = LANGUAGE.LANGUAGE_ID WHERE CATEGORY.NAME = 'Horror' ORDER BY  FILM.TITLE ASC LIMIT 10";

		List<Map<String, String>> data = DBUtil.readData(query);

		System.out.println(data);

		for (Map<String, String> row : data) {
			System.out.println(row);
		}

	}

}

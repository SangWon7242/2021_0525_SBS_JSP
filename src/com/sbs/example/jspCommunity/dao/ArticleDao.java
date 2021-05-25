package com.sbs.example.jspCommunity.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sbs.example.jspCommunity.dto.Article;
import com.sbs.example.jspCommunity.dto.Board;
import com.sbs.example.mysqlutil.MysqlUtil;
import com.sbs.example.mysqlutil.SecSql;

public class ArticleDao {

	public List<Article> getForPrintArticlesByBoardId(int boardId) {
		List<Article> articles = new ArrayList<>();
		
		SecSql sql = new SecSql();
		
		sql.append("SELECT A.*");
		sql.append(", M.name AS extra__writer");
		sql.append(", B.name AS extra__boardName");
		sql.append(", B.code AS extra__boardCode");
		sql.append("FROM article AS A");
		sql.append("INNER JOIN `member` AS M");
		sql.append("ON A.memberId = M.id");
		sql.append("INNER JOIN `board` AS B");
		sql.append("ON A.boardId = B.id");
		
		if(boardId != 0) {
			sql.append("WHERE A.boardId = ?", boardId);
		}
		sql.append("ORDER BY A.id DESC");
		
		List<Map<String, Object>> articleMapList = MysqlUtil.selectRows(sql);
		
		for(Map<String, Object> articleMap : articleMapList) {
			articles.add(new Article(articleMap));
		}
		
		return articles;
	}

	public Article getForPrintArticleById(int id) {
		
		SecSql sql = new SecSql();
		
		sql.append("SELECT A.*");
		sql.append(", M.name AS extra__writer");
		sql.append(", B.name AS extra__boardName");
		sql.append(", B.code AS extra__boardCode");
		sql.append("FROM article AS A");
		sql.append("INNER JOIN `member` AS M");
		sql.append("ON A.memberId = M.id");
		sql.append("INNER JOIN `board` AS B");
		sql.append("ON A.boardId = B.id");
		sql.append("WHERE A.id =?", id);
		
		Map<String, Object> map = MysqlUtil.selectRow(sql);
		
		if(map.isEmpty()) {
			return null;
		} // 원하는 id 번호가 없다면 null 반환
		
		return new Article(map); // 그렇지 않으면 map에 담긴 id 리턴
	}

	public Board getBoardById(int id) {
		SecSql sql = new SecSql();
		sql.append("SELECT B.*");
		sql.append("FROM board AS B");
		sql.append("WHERE B.id = ?", id);
		
		Map<String, Object> map = MysqlUtil.selectRow(sql);
		
		if(map.isEmpty()) {
			return null;
		}
		
		return new Board(map);
	}

}

package com.sbs.example.jspCommunity.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class Article {
	public int id;
	public LocalDateTime regDate;
	public LocalDateTime updateDate;
	public String title;
	public String body;
	public int memeberId;
	public int boardId;
	public int hitsCount;
	
	public String extra__writer;
	public String extra__boardName;
	public String extra__boardCode;
	
	public Article(Map<String, Object> map) {
		this.id = (int)map.get("id");
		this.regDate = (LocalDateTime)map.get("regDate");
		this.updateDate = (LocalDateTime)map.get("updateDate");
		this.title = (String)map.get("title");
		this.body = (String)map.get("body");
		this.memeberId = (int)map.get("memeberId");
		this.boardId = (int)map.get("boardId");
		this.hitsCount = (int)map.get("hitsCount");
		
		if(map.containsKey("extra__writer")) {
			this.extra__writer = (String) map.get("extra__writer");
		}
		if(map.containsKey("extra__boardName")) {
			this.extra__boardName = (String) map.get("extra__boardName");
		}
		if(map.containsKey("extra__boardCode")) {
			this.extra__boardCode = (String) map.get("extra__boardCode");
		}
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", regDate=" + regDate + ", updateDate=" + updateDate + ", title=" + title
				+ ", body=" + body + ", memeberId=" + memeberId + ", boardId=" + boardId + ", hitsCount=" + hitsCount
				+ ", extra__writer=" + extra__writer + ", extra__boardName=" + extra__boardName + ", extra_boardcode="
				+ extra__boardCode + "]";
	}
	
	
}

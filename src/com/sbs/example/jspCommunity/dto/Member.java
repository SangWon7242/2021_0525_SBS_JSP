package com.sbs.example.jspCommunity.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class Member {
	public int id;
	public LocalDateTime regDate;
	public LocalDateTime updateDate;
	public String loginId;
	public String loginPw;
	public String name;
	public String nickname;
	public String email;
	public int authLevel; // 인증코드
	
	public String extra__writer;
	public String extra__boardName;
	public String extra__boardCode;
	
	public Member(Map<String, Object> map) {
		this.id = (int)map.get("id");
		this.regDate = (LocalDateTime)map.get("regDate");
		this.updateDate = (LocalDateTime)map.get("updateDate");
		this.loginId = (String)map.get("loginId");
		this.loginPw = (String)map.get("loginPw");
		this.name = (String)map.get("name");
		this.nickname = (String)map.get("nickname");
		this.email = (String)map.get("email");
		this.authLevel = (int)map.get("authLevel");
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", regDate=" + regDate + ", updateDate=" + updateDate + ", loginId=" + loginId
				+ ", loginPw=" + loginPw + ", name=" + name + ", nickname=" + nickname + ", email=" + email
				+ ", authLevel=" + authLevel + ", extra__writer=" + extra__writer + ", extra__boardName="
				+ extra__boardName + ", extra__boardCode=" + extra__boardCode + "]";
	}
			
}

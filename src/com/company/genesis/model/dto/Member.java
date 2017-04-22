package com.company.genesis.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Member {
	
	@Id
	@Size(min=8, max=20, message="아이디는 8~20자여야 합니다.")
	private String id;
	
	@NotNull
	@Size(min=8, max=20, message="비밀번호는 8~20여야 합니다.")
	private String pw1;
	
	@NotNull
	@Size(min=8, max=20, message="비밀번호는 8~20여야 합니다.")
	private String pw2;
	
	@NotNull
	@Size(min=2, max=50, message="이름을 입력하세요.")
	private String name;
	
	@NotNull
	@Size(min=2, max=200, message="주소를 입력하십시오.")
	private String address;
	
	@NotNull
	@Pattern(regexp="^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$", message="올바른 이메일을 입력하십시오.")
	private String email;
	
	@NotNull
	private String rank;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw1() {
		return pw1;
	}
	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}
	public String getPw2() {
		return pw2;
	}
	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
}

package com.company.genesis.model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Member {
	
	@Id
	@Size(min=8, max=20, message="���̵�� 8~20�ڿ��� �մϴ�.")
	private String id;
	
	@NotNull
	@Size(min=8, max=20, message="��й�ȣ�� 8~20���� �մϴ�.")
	private String pw1;
	
	@NotNull
	@Size(min=8, max=20, message="��й�ȣ�� 8~20���� �մϴ�.")
	private String pw2;
	
	@NotNull
	@Size(min=2, max=50, message="�̸��� �Է��ϼ���.")
	private String name;
	
	@NotNull
	@Size(min=2, max=200, message="�ּҸ� �Է��Ͻʽÿ�.")
	private String address;
	
	@NotNull
	@Pattern(regexp="^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$", message="�ùٸ� �̸����� �Է��Ͻʽÿ�.")
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

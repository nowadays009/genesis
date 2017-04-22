package com.company.genesis.mapper;

import java.util.ArrayList;

import com.company.genesis.model.dto.Member;

public interface MemberMapper {
	//dao
	public void insertMember(Member member);
	public ArrayList<Member> getAllMembers();
	public Member getMember(String id);
	public void updateMember(Member member);
	public void deleteMember(String id);
}

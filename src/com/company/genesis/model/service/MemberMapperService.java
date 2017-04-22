package com.company.genesis.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.genesis.mapper.MemberMapper;
import com.company.genesis.model.dto.Member;

@Service
public class MemberMapperService implements MemberMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertMember(Member member) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertMember(member);
	}

	@Override
	public ArrayList<Member> getAllMembers() {
		ArrayList<Member> members = new ArrayList<Member>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		members = memberMapper.getAllMembers();
		
		return members;
	}

	@Override
	public Member getMember(String id) {
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		
		return memberMapper.getMember(id);
	}
	
	@Override
	public void updateMember(Member member) {

		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.updateMember(member);
	}

	public void deleteMember(String id) {

		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.deleteMember(id);
		
	}

}

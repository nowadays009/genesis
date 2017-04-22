package com.company.genesis.model.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.genesis.mapper.GenesisBoardMapper;
import com.company.genesis.model.dto.GenesisBoard;
import com.company.genesis.model.dto.GenesisBoardReply;
import com.company.genesis.model.dto.Paging;

@Service
public class GenesisBoardMapperService implements GenesisBoardMapper {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<GenesisBoard> getAllBoards() {
		
		ArrayList<GenesisBoard> boards = new ArrayList<GenesisBoard>();
		GenesisBoardMapper genesisBoardMapper = sqlSession.getMapper(GenesisBoardMapper.class);
		boards = genesisBoardMapper.getAllBoards();
		
		return boards;
	}
	
	public ArrayList<GenesisBoard> getAllSearchBoards(Paging searchPaging) {
		ArrayList<GenesisBoard> boards = new ArrayList<GenesisBoard>();
		GenesisBoardMapper genesisBoardMapper = sqlSession.getMapper(GenesisBoardMapper.class);
		boards = genesisBoardMapper.getAllSearchBoards(searchPaging);
		return boards;
	}

	@Override
	public ArrayList<GenesisBoard> getBoards(Paging paging) {
		
		ArrayList<GenesisBoard> boards = new ArrayList<GenesisBoard>();
		GenesisBoardMapper genesisBoardMapper = sqlSession.getMapper(GenesisBoardMapper.class);
		boards = genesisBoardMapper.getBoards(paging);

		return boards;
	}
	
	public ArrayList<GenesisBoard> getSearchBoards(Paging paging) {
		ArrayList<GenesisBoard> boards = new ArrayList<GenesisBoard>();
		GenesisBoardMapper genesisBoardMapper = sqlSession.getMapper(GenesisBoardMapper.class);
		boards = genesisBoardMapper.getSearchBoards(paging);

		return boards;
	}

	public void insertBoard(GenesisBoard board) {
		
		GenesisBoardMapper genesisBoardMapper = sqlSession.getMapper(GenesisBoardMapper.class);
		genesisBoardMapper.insertBoard(board);
	}
	
	public void insertBoardPaging() {
		
		GenesisBoardMapper genesisBoardMapper = sqlSession.getMapper(GenesisBoardMapper.class);
		genesisBoardMapper.insertBoardPaging();
	}

	public GenesisBoard getBoard(int b_id) {
		
		GenesisBoard board = new GenesisBoard();
		GenesisBoardMapper genesisBoardMapper = sqlSession.getMapper(GenesisBoardMapper.class);
		board = genesisBoardMapper.getBoard(b_id);
		
		return board;
	}

	public void updateBoardCount(int b_id) {
		
		GenesisBoardMapper genesisBoardMapper = sqlSession.getMapper(GenesisBoardMapper.class);
		genesisBoardMapper.updateBoardCount(b_id);
	}

	public void deleteBoard(int b_id) {

		GenesisBoardMapper genesisBoardMapper = sqlSession.getMapper(GenesisBoardMapper.class);
		genesisBoardMapper.deleteBoard(b_id);
	}

	public void updateBoard(GenesisBoard board) {
		GenesisBoardMapper genesisBoardMapper = sqlSession.getMapper(GenesisBoardMapper.class);
		genesisBoardMapper.updateBoard(board);
		
	}

	public void insertBoardReply(GenesisBoardReply re_board) {
		GenesisBoardMapper genesisBoardMapper = sqlSession.getMapper(GenesisBoardMapper.class);
		genesisBoardMapper.insertBoardReply(re_board);
		
	}

	public void insertBoardStepUp(GenesisBoard parentBoard) {
		GenesisBoardMapper genesisBoardMapper = sqlSession.getMapper(GenesisBoardMapper.class);
		genesisBoardMapper.insertBoardStepUp(parentBoard);
		
	}


}

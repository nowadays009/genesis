package com.company.genesis.mapper;

import java.util.ArrayList;

import com.company.genesis.model.dto.GenesisBoard;
import com.company.genesis.model.dto.GenesisBoardReply;
import com.company.genesis.model.dto.Paging;

public interface GenesisBoardMapper {
	public ArrayList<GenesisBoard> getAllBoards();
	public ArrayList<GenesisBoard> getBoards(Paging paging);
	public void insertBoard(GenesisBoard board);
	public void insertBoardPaging();
	public GenesisBoard getBoard(int b_id);
	public void updateBoardCount(int b_id);
	public void deleteBoard(int b_id);
	public void updateBoard(GenesisBoard board);
	public void insertBoardReply(GenesisBoardReply re_board);
	public void insertBoardStepUp(GenesisBoard parentBoard);
	public ArrayList<GenesisBoard> getAllSearchBoards(Paging searchPaging);
	public ArrayList<GenesisBoard> getSearchBoards(Paging paging);
}

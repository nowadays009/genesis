package com.company.genesis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.company.genesis.model.dto.GenesisBoard;
import com.company.genesis.model.dto.GenesisBoardReply;
import com.company.genesis.model.dto.Paging;
import com.company.genesis.model.service.GenesisBoardMapperService;

@Controller
public class GenesisBoardController {
	
	@Autowired
	GenesisBoardMapperService genesisBoardService;
	
	
	@RequestMapping("/boardList")
	public ModelAndView boardList(String pageNum, String searchField, String searchValue){
		
		System.out.println("searchField : "+searchField);
		System.out.println("searchValue: "+searchValue);
		Paging searchPaging = new Paging();
		ModelAndView mav = new ModelAndView();
		ArrayList<GenesisBoard> boards;
		//검색어가 있는경우와 없는경우에 따른 비지니스처리
		if(searchField==null||searchValue==null){
			
			System.out.println("boardList 검색어랑 값이 둘다 null일 경우");
			boards = genesisBoardService.getAllBoards();
			
			
		}else{
			
			
			searchPaging.setSearchField(searchField);
			searchPaging.setSearchValue(searchValue);
			System.out.println("else searchField : "+searchField);
			System.out.println("else searchValue: "+searchValue);
			System.out.println("boardList 검색어랑 값이 둘다 있을 경우");
			boards = genesisBoardService.getAllSearchBoards(searchPaging);
			System.out.println("보드 갯수 : "+boards.size());
		}
		
		
		
		//처음 게시글 보기를 누루면 pageNum이 없기 때문에 null 처리 해주어야 합니다.
		if(pageNum==null){
			pageNum="1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int pageSize=5; 			//화면에 보여질 게시글의 갯수를 지정
		int pageBlock=3;			//페이지 블락수
		int count=boards.size();	//전체 글의 갯수
		System.out.println("count : "+count);
		int number=count - (currentPage-1) * pageSize;  			//테이블에 표시할 번호를 설정
		int pageCount=(count/pageSize)+(count%pageSize==0 ? 0 : 1); //총페이지수
		int startPage=((currentPage/pageBlock)-1)*(pageBlock) +1;   //시작페이지
		if(currentPage%pageBlock != 0){
			startPage=(currentPage/pageBlock)*(pageBlock)+1;
		}
		int endPage=startPage+pageBlock-1; //끝페이지
		if(endPage > pageCount){
			endPage = pageCount;
		}
		//현제 페이지에 보여줄 시작 번호를 설정 = 데이터 베이스에서 불러올 시작 번호를 의미
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		
		List<GenesisBoard> boardList = null; //가변길이로 데이터를 저장
		
		Paging paging = new Paging(pageSize, pageBlock, pageCount, count, number, currentPage, startPage, endPage, startRow, endRow, searchField, searchValue);
		System.out.println("pageSize"+pageSize+"pageBlock"+pageBlock+"pageCount"+pageCount+"count"+count+"number"+number+"currentPage"+currentPage+"startPage"+startPage+"endPage"+endPage+"startRow"+startRow+"endRow"+endRow+"searchField"+searchField+"searchValue"+searchValue);
		
		//게시글이 존재한다면
		if(count>0){
			
			if(searchField==null||searchValue==null){
				
				//10개를 기준으로 데이터를 데이터 베이스에서 읽어드림
				System.out.println("게시글이 존재한다면 검색어랑 값이 둘다 null일 경우");
				boardList = genesisBoardService.getBoards(paging);
				
			}else{
				
				System.out.println("게시글이 존재한다면 검색어랑 값이 둘다 있을 경우");
				boardList = genesisBoardService.getSearchBoards(paging);
				
			}
			
			
		}
		
		mav.addObject("searchField", searchField);
		mav.addObject("searchValue", searchValue);
		mav.addObject("boards", boardList);
		mav.addObject("paging", paging);
		mav.setViewName("/genesisBoard/boardList");
		
		return mav;
	}
		
	@RequestMapping("/insertBoard")
	public ModelAndView insertBoard(GenesisBoard board){
		ModelAndView mav = new ModelAndView();
		mav.addObject("board",new GenesisBoard());
		mav.setViewName("/genesisBoard/insertBoard");
		
		return mav;
	}
	
	@RequestMapping("/insertBoardProc")
	public String insertBoardProc(GenesisBoard board, HttpServletRequest request){
		
		board.setRe_group(1);	//답변형 게시판 부모 글을 삽입할 경우 re_group의 값은 무조건 1로 초기화
		board.setRe_step(1);	//답변형 게시판 부모 글을 삽입할 경우 re_step의 값은 무조건 1로 초기화
		board.setRe_level(0);	//답변형 게시판 부모 글을 삽입할 경우 re_level의 값은 무조건0으로 초기화
		board.setIp(request.getRemoteAddr());
		
		genesisBoardService.insertBoardPaging();	//답변형 게시판을 위해 게시판에 존재하는 모든 글의 re_group를 1증가하는 로직
		genesisBoardService.insertBoard(board);
		
		return "redirect:/boardList";
	}
	
	@RequestMapping("/detailBoard")
	public ModelAndView detailBoard(int b_id, String number){
		
		ModelAndView mav = new ModelAndView();
		GenesisBoard board = new GenesisBoard();
		board = genesisBoardService.getBoard(b_id);
		genesisBoardService.updateBoardCount(b_id);
		
		mav.addObject("board", board);
		mav.addObject("number", number);
		mav.setViewName("/genesisBoard/detailBoard");
		
		return mav;
	}
	
	@RequestMapping("/deleteBoard")
	public String deleteBoard(int b_id){
		
		genesisBoardService.deleteBoard(b_id);
		
		return "redirect:/boardList";
	}
	
	@RequestMapping("/updateBoard")
	public ModelAndView updateBoard(int b_id){
		
		ModelAndView mav = new ModelAndView();
		GenesisBoard board = genesisBoardService.getBoard(b_id);
		
		mav.addObject("board",board);
		mav.setViewName("/genesisBoard/updateBoard");
		return mav;
	}
	
	@RequestMapping("/updateBoardProc")
	public String updateBoardProc(GenesisBoard board){
		
		ModelAndView mav = new ModelAndView();
		genesisBoardService.updateBoard(board);
		
		return "redirect:/boardList";
	}
	
	@RequestMapping("/replyBoard")
	public ModelAndView replyBoard(String b_id){
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("parent_b_id",b_id);
		mav.addObject("boardReply",new GenesisBoardReply());
		mav.setViewName("/genesisBoard/replyBoard");
		return mav;
	}
	
	@RequestMapping("/replyBoardProc")
	public String replyBoard(GenesisBoardReply boardReply,HttpServletRequest request){
		
		
		GenesisBoard parentBoard = genesisBoardService.getBoard(boardReply.getParent_b_id());
		GenesisBoardReply re_board = boardReply;
		
		
		re_board.setRe_group(parentBoard.getRe_group());	//답변형 게시판 답변 글을 삽입할 경우 re_group의 값은 부모글의 re_group 값으로 초기화
		re_board.setRe_step(parentBoard.getRe_step()+1);	//답변형 게시판 답변 글을 삽입할 경우 re_step의 값은 부모글의 (re_step+1) 값으로 초기화
		re_board.setRe_level(parentBoard.getRe_level()+1);	//답변형 게시판 답변 글을 삽입할 경우 re_level의 값은 부모글의 (re_level+1) 값으로 초기화
		re_board.setIp(request.getRemoteAddr());
		
		genesisBoardService.insertBoardStepUp(parentBoard);	//부모글의 정보를 넘겨줌 부모글의 re_step값을 비교하기 위해서
		genesisBoardService.insertBoardReply(re_board);
		
		return "redirect:/boardList";
		
	}
}


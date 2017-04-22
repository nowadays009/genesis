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
		//�˻�� �ִ°��� ���°�쿡 ���� �����Ͻ�ó��
		if(searchField==null||searchValue==null){
			
			System.out.println("boardList �˻���� ���� �Ѵ� null�� ���");
			boards = genesisBoardService.getAllBoards();
			
			
		}else{
			
			
			searchPaging.setSearchField(searchField);
			searchPaging.setSearchValue(searchValue);
			System.out.println("else searchField : "+searchField);
			System.out.println("else searchValue: "+searchValue);
			System.out.println("boardList �˻���� ���� �Ѵ� ���� ���");
			boards = genesisBoardService.getAllSearchBoards(searchPaging);
			System.out.println("���� ���� : "+boards.size());
		}
		
		
		
		//ó�� �Խñ� ���⸦ ����� pageNum�� ���� ������ null ó�� ���־�� �մϴ�.
		if(pageNum==null){
			pageNum="1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int pageSize=5; 			//ȭ�鿡 ������ �Խñ��� ������ ����
		int pageBlock=3;			//������ �����
		int count=boards.size();	//��ü ���� ����
		System.out.println("count : "+count);
		int number=count - (currentPage-1) * pageSize;  			//���̺� ǥ���� ��ȣ�� ����
		int pageCount=(count/pageSize)+(count%pageSize==0 ? 0 : 1); //����������
		int startPage=((currentPage/pageBlock)-1)*(pageBlock) +1;   //����������
		if(currentPage%pageBlock != 0){
			startPage=(currentPage/pageBlock)*(pageBlock)+1;
		}
		int endPage=startPage+pageBlock-1; //��������
		if(endPage > pageCount){
			endPage = pageCount;
		}
		//���� �������� ������ ���� ��ȣ�� ���� = ������ ���̽����� �ҷ��� ���� ��ȣ�� �ǹ�
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		
		List<GenesisBoard> boardList = null; //�������̷� �����͸� ����
		
		Paging paging = new Paging(pageSize, pageBlock, pageCount, count, number, currentPage, startPage, endPage, startRow, endRow, searchField, searchValue);
		System.out.println("pageSize"+pageSize+"pageBlock"+pageBlock+"pageCount"+pageCount+"count"+count+"number"+number+"currentPage"+currentPage+"startPage"+startPage+"endPage"+endPage+"startRow"+startRow+"endRow"+endRow+"searchField"+searchField+"searchValue"+searchValue);
		
		//�Խñ��� �����Ѵٸ�
		if(count>0){
			
			if(searchField==null||searchValue==null){
				
				//10���� �������� �����͸� ������ ���̽����� �о�帲
				System.out.println("�Խñ��� �����Ѵٸ� �˻���� ���� �Ѵ� null�� ���");
				boardList = genesisBoardService.getBoards(paging);
				
			}else{
				
				System.out.println("�Խñ��� �����Ѵٸ� �˻���� ���� �Ѵ� ���� ���");
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
		
		board.setRe_group(1);	//�亯�� �Խ��� �θ� ���� ������ ��� re_group�� ���� ������ 1�� �ʱ�ȭ
		board.setRe_step(1);	//�亯�� �Խ��� �θ� ���� ������ ��� re_step�� ���� ������ 1�� �ʱ�ȭ
		board.setRe_level(0);	//�亯�� �Խ��� �θ� ���� ������ ��� re_level�� ���� ������0���� �ʱ�ȭ
		board.setIp(request.getRemoteAddr());
		
		genesisBoardService.insertBoardPaging();	//�亯�� �Խ����� ���� �Խ��ǿ� �����ϴ� ��� ���� re_group�� 1�����ϴ� ����
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
		
		
		re_board.setRe_group(parentBoard.getRe_group());	//�亯�� �Խ��� �亯 ���� ������ ��� re_group�� ���� �θ���� re_group ������ �ʱ�ȭ
		re_board.setRe_step(parentBoard.getRe_step()+1);	//�亯�� �Խ��� �亯 ���� ������ ��� re_step�� ���� �θ���� (re_step+1) ������ �ʱ�ȭ
		re_board.setRe_level(parentBoard.getRe_level()+1);	//�亯�� �Խ��� �亯 ���� ������ ��� re_level�� ���� �θ���� (re_level+1) ������ �ʱ�ȭ
		re_board.setIp(request.getRemoteAddr());
		
		genesisBoardService.insertBoardStepUp(parentBoard);	//�θ���� ������ �Ѱ��� �θ���� re_step���� ���ϱ� ���ؼ�
		genesisBoardService.insertBoardReply(re_board);
		
		return "redirect:/boardList";
		
	}
}


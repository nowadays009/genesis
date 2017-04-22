package com.company.genesis.model.dto;

import javax.persistence.Entity;

@Entity
public class PagingOrigin {
	
	private int pageSize;		//*���������� ȭ�鿡 ������ �Խñ��� ��
	private int pageBlock;		//*������ ��
	private int pageCount;		//������ ��
	private int count;			//*��ü �Խñ��� ��
	private int number;			//*�ѹ�
	private int currentPage;	//*���� ������
	private int startPage;
	private int endPage;
	private int startRow;
	private int endRow;
	
	public PagingOrigin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PagingOrigin(int pageSize, int pageBlock, int pageCount, int count, int number, int currentPage, int startPage,
			int endPage, int startRow, int endRow) {
		super();
		this.pageSize = pageSize;
		this.pageBlock = pageBlock;
		this.pageCount = pageCount;
		this.count = count;
		this.number = number;
		this.currentPage = currentPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.startRow = startRow;
		this.endRow = endRow;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	

}

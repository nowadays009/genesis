package com.company.genesis.model.dto;

import javax.persistence.Entity;

@Entity
public class Paging {
	
	private int pageSize;		//*한페이지당 화면에 보여질 게시글의 수
	private int pageBlock;		//*페이지 블럭
	private int pageCount;		//페이지 수
	private int count;			//*전체 게시글의 수
	private int number;			//*넘버
	private int currentPage;	//*현재 페이지
	private int startPage;
	private int endPage;
	private int startRow;
	private int endRow;
	private String searchField;
	private String searchValue;
	
	public Paging() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Paging(int pageSize, int pageBlock, int pageCount, int count, int number, int currentPage, int startPage,
			int endPage, int startRow, int endRow, String searchField, String searchValue) {
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
		this.searchField = searchField;
		this.searchValue = searchValue;
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
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	
}

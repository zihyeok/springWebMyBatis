package com.jdbc.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.jdbc.dto.BoardDTO;

public class BoardDAO2 {
	
	private SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) throws Exception {
		this.sessionTemplate = sessionTemplate;
		
	}
	
	//num�� max�� 
	public int getMaxNum() {
		
		int maxNum = 0;
		
		maxNum = sessionTemplate.selectOne("com.board.maxNum");
		
		return maxNum;
		
	}
	
	//�Է�
	public void insertData(BoardDTO dto) {
		
		sessionTemplate.insert("com.board.insertData",dto);
		
	}
	
	
	//��ü �������� ����
	public int getDataCount(String searchKey,String searchValue) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("searchKey",searchKey);
		params.put("searchValue",searchValue);
		
		
		int totalCount = sessionTemplate.selectOne("com.board.getDataCount",params);
			
		return totalCount;
		
	}
	
	
	
	//��ü����Ʈ
	public List<BoardDTO> getLists(int start, int end, 
			String searchKey, String searchValue){
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("start", start);
		params.put("end", end);
		params.put("searchKey",searchKey);
		params.put("searchValue",searchValue);
		
		List<BoardDTO> lists =
				sessionTemplate.selectList("com.board.getLists",params);
		
		return lists;
		
	}
	
	//��ȸ�� ����
	public void updateHitCount(int num) {
		
		sessionTemplate.update("com.board.updateHitCount",num);
		
		
	}
	
	//num���� ��ȸ�� �Ѱ��� ������
	public BoardDTO getReadData(int num) {
		
		BoardDTO dto = 
				sessionTemplate.selectOne("com.board.getReadData",num);
		
		return dto;		
	}
	
	//����
	public void updateData(BoardDTO dto) {
		
		sessionTemplate.update("com.board.updateData",dto);
		
	}
	
	public void deleteData(int num) {
		
		sessionTemplate.delete("com.board.deleteData",num);
		
	}
	

}




























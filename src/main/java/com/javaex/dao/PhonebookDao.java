package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PhonebookVo;

@Repository
public class PhonebookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<PhonebookVo> addSelectList() {
		System.out.println("PhonebookDao.addSelectList");
		
		List<PhonebookVo> phonebookList = sqlSession.selectList("phonebook.selectList");
		System.out.println(phonebookList);
		
		return phonebookList;
	}
	
	//등록
	
	public int insertSelectKey(PhonebookVo phonebookVo) {
		System.out.println("PhonebookDao.insertSelectKey()");
		
		int count = sqlSession.insert("phonebook.insertSelectKey", phonebookVo);
		
		
		return count;
	}
	
	//삭제
	
	public int idDelete(PhonebookVo phonebookVo) {
		System.out.println("PhonebookDao.idDelete()");
		
		int count = sqlSession.delete("phonebook.delete", phonebookVo);
		
		return count;
	}
	
	//수정폼
	public PhonebookVo selectOne(int no) {
		System.out.println("PhonebookDao.selectOne()");
		PhonebookVo pVo = sqlSession.selectOne("phonebook.selectOne", no);
		
		return pVo;
	}
	
	//수정
	public int modifyUser(PhonebookVo phonebookVo) {
		System.out.println("PhonebookDao.modifyPhone()");
		
		int count = sqlSession.update("phonebook.modify",phonebookVo);
		return count;
	}

}
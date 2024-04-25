package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PhonebookVo;

@Service
public class PhonebookService {
	
	@Autowired
	private PhonebookDao phonebookDao;
	
	//리스트
	public List<PhonebookVo> exeList() {
		System.out.println("PhonebookService.exeList()");
		
		List<PhonebookVo> phonebookList = phonebookDao.addSelectList();
		System.out.println(phonebookList);
		return phonebookList;
	}
	
	//등록
	public int exeAddList(PhonebookVo phonebookVo) {
		System.out.println("PhonebookService.exeAddList");
		
		int count = phonebookDao.insertSelectKey(phonebookVo);
		
		return count;
	}
	
	//삭제
	
	public int exeDelete(PhonebookVo phonebookVo) {
		System.out.println("PhonebookService.exeDelete()");
		
		int count = phonebookDao.idDelete(phonebookVo);
		
		return count;
	}
	
	//수정폼
	public PhonebookVo exeModifyForm(int personId) {
		System.out.println("PhonebookService.exeModifyForm()");
		PhonebookVo pVo = phonebookDao.selectOne(personId);
		
		return pVo;
	}
	
	//수정
	public int exeModify(PhonebookVo phonebookVo) {
		System.out.println("PhonebookService.exeModify");
		
		int count = phonebookDao.modifyUser(phonebookVo);
		
		return count;
		
	}
	
}
package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PhonebookVo;

@RestController
public class PhoneController {
	
	@Autowired
	private PhonebookService phonebookService; //1234
	
	//리스트
	@GetMapping(value="/api/phone/list")
	public List<PhonebookVo> list(Model model){
		System.out.println("PhonebookController.list()");
		
		List<PhonebookVo> phonebookList = phonebookService.exeList();
		model.addAttribute("phonebookList", phonebookList);
		System.out.println(phonebookList);
		return phonebookList;
	}
	
	//등록
	@PostMapping(value="/api/phone/write")
	public String addList(@RequestBody PhonebookVo phonebookVo) {
		System.out.println("PhonebookController.addList()");
		System.out.println(phonebookVo);
		
		int count = phonebookService.exeAddList(phonebookVo);
		String result = "{\"count\":"+count+"}";
		
		return result;
	}
	
	//삭제
	@DeleteMapping(value="/api/phone/delete/{personId}")
	public String exeDelete(@RequestBody PhonebookVo phonebookVo, @PathVariable("personId") int personId) {
		System.out.println("PhonebookService.exeDelete()");
		
		int count = phonebookService.exeDelete(phonebookVo);
		String result = "{\"count\":"+count+"}";
		
		return result;
	}
	
	//수정폼부르기(1개 부르기)
	@GetMapping(value="/api/phone/modify/{personId}")
	public PhonebookVo modifyForm(@PathVariable("personId") int personId) {
		System.out.println("phonebookController.modifyForm()");
		System.out.println(personId);
		PhonebookVo pVo = phonebookService.exeModifyForm(personId);
		
		return pVo;
	}
	
	//수정
	@PutMapping(value="/api/phone/modify/{personId}")
	public String modifyId(@PathVariable("personId")int personId, @RequestBody PhonebookVo phonebookVo) {
		System.out.println("PhonebookController.modifyId()");
		
		int count = phonebookService.exeModify(phonebookVo);
		String result = "{\"count\":"+count+"}";
		return result;
	}
	

}
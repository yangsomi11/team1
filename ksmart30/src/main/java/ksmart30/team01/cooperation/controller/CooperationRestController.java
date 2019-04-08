/*
 * @file     com.cafe24.ksmart30.team01.cooperation.controller.CooperationRestController.java
 * @brief    cooperation controller
 * @author   ksmart30 김동열
 */
package ksmart30.team01.cooperation.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ksmart30.team01.cooperation.domain.CooperationSearchRequest;
import ksmart30.team01.cooperation.domain.cooperationSangseRequest;
import ksmart30.team01.cooperation.service.CooperationService;


@RestController
public class CooperationRestController {

	@Autowired CooperationService cooperationService;
	
	@PostMapping("/project/cooperation/in_search")
	public List<Map<String,Object>> projectCooperationInSearch(){
		
		return null;
	}
	//3.1.2 외주계약서 검색
	// 외주관리 - 외주계약서관리 - 외주계약서 검색 - 리스트 요청
	/* /cooperationSearch url을 POST로 호출시 실행
	 * @param  POST CooperationSearchRequestVo 객체로 검색 조건 들을 받는다.(문자열)
	 * @brief    projectCooperationManageService객체의 cooperationListSearch 메서드 호출
	 * @return  List<Map<String,Object>> re - json방식
	 */	
	@PostMapping("/cooperationSearch")
	public List<Map<String,Object>> projectCooperationSearch(CooperationSearchRequest vo) {
		System.out.print("용역계약서 검색 CooperationRestController 실행");
		System.out.print("cooperationSearch 담긴값 : "+vo);
		List<Map<String,Object>> re = cooperationService.cooperationSelect(vo);
		System.out.print("re 담긴값 : "+re);
		return re;	
	}
	// 3.1.1 외주계약서 입력 - 조회
	//외주관리 - 외주계약서관리 - 외주계약서 입력 - PJT 에 따른 외주계약서 리스트  및 예산현황 요청 
	/* /cooperationPJTYesanList url을 POST로 호출시 실행
	 * @param  POST String 으로 PJT_CD 받기
	 * @brief    projectCooperationManageService객체의 cooperationPJTYesanSelect 메서드 호출
	 * @return  Map<String,Object> re - json방식
	 */
	@PostMapping("/cooperationPJTYesanList")
	public Map<String,Object> cooperationPJTYesanList(String PJT_CD){
		System.out.println("받은값 : "+PJT_CD);
		return cooperationService.cooperationPJTYesanSelect(PJT_CD);		
	}
	// 3.1.1 외주계약서 입력 - 조회
	//외주관리 - 외주계약서관리 - 외주계약서 입력 - 외주계약서 상세 내역 출력 
	/* /cooperationPJTYesanList url을 POST로 호출시 실행
	 * @param  POST cooperationSangseRequest 으로 vo 받기
	 * @brief    projectCooperationManageService객체의 cooperationSangseSelect 메서드 호출
	 * @return  List<Map<String,Object>> re - json방식
	 */
	@PostMapping("/cooperationPJTSangse")
	public Map<String,Object> cooperationPJTSangse(cooperationSangseRequest vo){
		System.out.println("받은값 : "+vo);
		return cooperationService.cooperationSangseSelect(vo);
	}
}
/*
 * @file	ProjectManageService.java
 * @brief   용역계약서 Service
 * @author  ksmart30 YDE
 */
package ksmart30.team01.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart30.team01.project.domain.ProjectHistory;
import ksmart30.team01.project.mapper.ProjectManageMapper;

@Service
public class ProjectManageService {
	@Autowired
	ProjectManageMapper projectManageMapper;

	// 전체 발주처를 조회하는 메서드
	public List<Map<String, Object>> getCustList(String column, String columnValue) {
		System.out.println("Service getClientList 메서드 실행");
		Map<String, String> searchMap = new HashMap<String, String>();
		System.out.println("column : " + column);
		System.out.println("columnValue : "+ columnValue);
		if(column.equals("CUST_CD")) {
			System.out.println("CUST_CD입니당");
			searchMap.put("CUST_CD", columnValue);
		} else {
			System.out.println("CUST_NM입니당");
			searchMap.put("CUST_NM", columnValue);
		}
		return projectManageMapper.getCustList(searchMap);
	}
	
	
	// ===================================================용역계약서 입력을 위한 프로젝트 조회 START===================================================
	// 전체 프로젝트 대장을 조회하는 메서드
	public List<Map<String, Object>> getBusinessManagerList(String PJT_CD, String DEPT_CD, String YEAR, String pjtRadioValue) {
		System.out.println("Service getBusinessManagerList 메서드 실행");
		System.out.println(PJT_CD + DEPT_CD + YEAR + pjtRadioValue);
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("PJT_CD", PJT_CD);
		searchMap.put("DEPT_CD", DEPT_CD);
		searchMap.put("YEAR", YEAR);
		List<Map<String, Object>> resultMap = null;
		switch(pjtRadioValue) {
			case "1":
				// 검토
				break;
			case "2":
				// 계약
				break;
			case "3":
				// 예산
				resultMap = projectManageMapper.getProjectManageYesanList(searchMap);
				break;
			case "4":
				// 승인
				resultMap = projectManageMapper.getProjectManageSeunginList(searchMap);
				break;
			case "5":
				// 종료
				resultMap = projectManageMapper.getProjectManageEndList(searchMap);
				break;
			case "6":
				// ALL
				resultMap = projectManageMapper.getProjectManageList(searchMap);
				break;	
			default:
				resultMap = projectManageMapper.getProjectManageList(searchMap);
				break;
		}
		return resultMap;
	}
	// ===================================================용역계약서 입력을 위한 프로젝트 조회 END===================================================

	// 1번 이상 변경된 이력이 있는 용역계약서를 조회하는 메서드
	public List<Map<String, ProjectHistory>> getProjectHistoryList(String PJT_CD, String DEPT_CD, String YEAR) {
		System.out.println("Service getProjectManageHistoryList 메서드 실행");
		System.out.println(PJT_CD);
		System.out.println(DEPT_CD);
		System.out.println(YEAR);
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("PJT_CD", PJT_CD);
		searchMap.put("DEPT_CD", DEPT_CD);
		searchMap.put("YEAR", YEAR);
		return projectManageMapper.getProjectHistoryList(searchMap);
	}

	// 변경된 용역계약서 중 하나를 선택하면, 그에 대한 변경 현황 리스트를 조회하는 메서드
	public List<Map<String, Object>> getProjectManageChangeHyunhwangList(String PJT_CD) {
		System.out.println("Service getProjectManageChangeHyunhwangList 메서드 실행");
		System.out.println(PJT_CD);
		return projectManageMapper.getProjectManageHistoryHyunhwangList(PJT_CD);
	}

	// 변경된 용역계약서 현황에서 하나를 선택하면, 해당하는 변경 구분의 상세 페이지를 조회하는 메서드
	public Map<String, Object> getProjectManageChangeSangse(String PJT_CD, String PJT_SEQ) {
		System.out.println("Service getProjectManageChangeSangse 메서드 실행");
		// 매개변수 저장용 Map
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("PJT_CD", PJT_CD);
		map.put("PJT_SEQ", PJT_SEQ);
		// 결과 리턴용 Map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 변경 현황별로 용역계약서 상세 조회
		resultMap.put("sangse", projectManageMapper.getProjectManageChangeSangse(map));
		// 원계약 정보 조회
		resultMap.put("one", projectManageMapper.getProjectManageChangeSangseOne(PJT_CD));
		// 이전(변경전) 시퀀스 생성
		// 현재의 시퀀스에서 1만큼을 빼 이전 시퀀스로 만든다.
		int temp = Integer.parseInt(PJT_SEQ) - 1;
		String PJT_SEQ_BEFORE = String.valueOf(temp);
		// 매개변수 map 이전 시퀀스 저장
		map.put("PJT_SEQ_BEFORE", PJT_SEQ_BEFORE);
		// 발주처 변경 전 조회 결과
		resultMap.put("owner_before", projectManageMapper.getProjectManageChangeOwnerBefore(map));
		// 발주처 변경 후 조회 결과
		resultMap.put("owner_after", projectManageMapper.getProjectManageChangeOwnerAfter(map));
		// 기성단계 변경 전,후 조회 결과
		resultMap.put("giseongList", projectManageMapper.getProjectManageChangeGiseong(map));
		// 기성단계 변경 전 조회 결과
		resultMap.put("giseong_before", projectManageMapper.getProjectManageChangeGiseongBefore(map));
		// 기성단계 변경 후 조회 결과
		resultMap.put("giseong_after", projectManageMapper.getProjectManageChangeGiseongAfter(map));
		return resultMap;
	}
}

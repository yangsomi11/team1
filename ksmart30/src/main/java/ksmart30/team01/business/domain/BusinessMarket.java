package ksmart30.team01.business.domain;

public class BusinessMarket {
	
	private String BUSI_YY;  //년도
	private String UP_SU;		//지상층수
	private String UP_SU2;      //지상층수 검색때 필요
	private String YAREA_P;	 //연면적
	private String YAREA_P2;  //연면적 검색때 필요
	
	public String getUP_SU2() {
		return UP_SU2;
	}
	public void setUP_SU2(String uP_SU2) {
		UP_SU2 = uP_SU2;
	}
	public String getYAREA_P2() {
		return YAREA_P2;
	}
	public void setYAREA_P2(String yAREA_P2) {
		YAREA_P2 = yAREA_P2;
	}
	public String getBUSI_YY() {
		return BUSI_YY;
	}
	public void setBUSI_YY(String bUSI_YY) {
		BUSI_YY = bUSI_YY;
	}
	public String getUP_SU() {
		return UP_SU;
	}
	public void setUP_SU(String uP_SU) {
		UP_SU = uP_SU;
	}
	public String getYAREA_P() {
		return YAREA_P;
	}
	public void setYAREA_P(String yAREA_P) {
		YAREA_P = yAREA_P;
	}
	@Override
	public String toString() {
		return "BusinessMarket [BUSI_YY=" + BUSI_YY + ", UP_SU=" + UP_SU + ", UP_SU2=" + UP_SU2 + ", YAREA_P=" + YAREA_P
				+ ", YAREA_P2=" + YAREA_P2 + "]";
	}
	
	
}

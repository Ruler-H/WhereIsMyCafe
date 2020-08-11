package gmail.elwl5515.portfolio.domain;

import lombok.Data;

@Data
public class ClientPreferenceElement {
	private String clientNickname;	//clientNickname 테이블의 유저 닉네임(외래키)
	private String preferWifi;		//와이파이 보유 선호 여부
	private String preferRefill;	//리필 서비스 보유 선호 여부
	private String preferConcent;	//콘센트 보유 선호 여부
	private String preferParking;	//주차장 보유 선호 여부
	private String preferPat;		//애완동물 동반 선호 여부
	private String preferNoKidsZone;//노키즈존 보유 선호 여부
}

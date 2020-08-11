package gmail.elwl5515.portfolio.domain;

import lombok.Data;

@Data
public class CafeMain {
	private String cafeNickname;	//메인 테이블 카페 닉네임
	private String cafeName;		//카페 이름
	private String cafeAddress;		//카페 주소
	private String signatureDrink;	//시그니처 음료
	private String signatureDesert;	//시그니처 디저트
	private String cafeWifi;		//와이파이 보유 여부
	private String cafeParking;		//주차 가능 여부
	private String cafeRefill;		//리필 가능 여부
	private String cafeTableNum;	//전체 테이블 수
	private int concentTableNum;	//콘센트 사용 가능 테이블 수
	private String cafeLogo;		//카페 로고
	private String cafePhoneNum;	//카페 전화번호
	private String cafeImage;		//카페 사진
	private String cafeCommentary;	//카페 한줄 설명
}

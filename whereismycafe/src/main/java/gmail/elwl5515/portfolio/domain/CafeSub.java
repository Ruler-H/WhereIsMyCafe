package gmail.elwl5515.portfolio.domain;

import lombok.Data;

@Data
public class CafeSub {
	private String cafeNickname;	//cafeMain 테이블의 카페 닉네임(외래키)
	private String tumblerDiscount;	//텀블러 보유 시 할인 여부
	private String noKidsZone;		//노키즈존 보유 여부
	private String cafeHomepage;	//카페 홈페이지 주소
	private String sirenOrder;		//사이렌 오더 가능 여부
	private String cafeCoupon;		//쿠폰 서비스 보유 여부
	private int outdoorTableNum;	//야외 테이블 수
	private String cafeSNS;			//카페 SNS
	private int toiletGrade;		//화장실 평점
}

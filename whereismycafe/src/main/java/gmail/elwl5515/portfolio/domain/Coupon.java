package gmail.elwl5515.portfolio.domain;

import lombok.Data;

@Data
public class Coupon {
	private String cafeClientNickname;	//카페_고객 닉네임으로 구성된 기본키
	private int drankNum;				//마신 잔수
}

package gmail.elwl5515.portfolio.domain;

import lombok.Data;

@Data
public class CafeClient {
	private String cafeClientNickname;	//카페_고객 닉네임으로 구성된 기본키
	private String cafeVisitDate;		//카페 방문일 내역
	private String cafeOrderHistory;	//카페 주문 내역
}

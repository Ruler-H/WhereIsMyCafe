package gmail.elwl5515.portfolio.domain;

import lombok.Data;

@Data
public class CafeReviewSNS {
	private int SNSNum;				//SNS 일련번호
	private String cafeNickname;	//cafeMain 테이블의 카페 닉네임(외래키)
	private String SNSAddress;		//sns 경로
}

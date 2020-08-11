package gmail.elwl5515.portfolio.domain;

import lombok.Data;

@Data
public class CafeOperationHours {
	private String dayOfWeek;		//요일
	private String cafeNickname;	//cafeMain 테이블의 카페 닉네임(외래키)
	private String operationHour;	//영업 시간
	private String lastOrder;		//라스트 오더
}

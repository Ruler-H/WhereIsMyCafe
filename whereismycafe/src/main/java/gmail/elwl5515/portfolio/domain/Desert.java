package gmail.elwl5515.portfolio.domain;

import lombok.Data;

@Data
public class Desert {
	private int desertNum;			//디저트 일련번호
	private String cafeNickname;	//cafeMain 테이블의 카페 닉네임(외래키)
	private String desertName;		//디저트 이름
	private int desertCost;			//디저트 가격
	private int desertGrade;		//디저트 평점
	private String desertImage;		//디저트 이미지
}

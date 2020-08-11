package gmail.elwl5515.portfolio.domain;

import lombok.Data;

@Data
public class Drink {
	private int drinkNum;			//--음료 일련번호
	private String cafeNickname;	//cafeMain 테이블의 카페 닉네임(외래키)
	private String drinkName;		//음료 이름
	private int drinkCost;			//음료 가격
	private int drinkGrade;			//음료 평점
	private String drinkImage;		//음료 이미지
}

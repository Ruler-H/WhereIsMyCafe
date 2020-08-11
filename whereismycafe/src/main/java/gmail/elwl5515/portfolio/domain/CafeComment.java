package gmail.elwl5515.portfolio.domain;

import lombok.Data;

@Data
public class CafeComment {
	private int cafeCommentNum;		//댓글 일련번호
	private String cafeNickname;	//cafeMain 테이블의 카페 닉네임(외래키)
	private String clientNickname;	//client 테이블의 고객 닉네임(외래키)
	private String reply;			//댓글
}

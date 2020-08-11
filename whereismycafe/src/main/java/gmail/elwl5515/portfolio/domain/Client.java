package gmail.elwl5515.portfolio.domain;

import lombok.Data;

@Data
public class Client {
	private String clientNickname;		//사용자 닉네임
	private String clientEmail;			//사용자 이메일
	private String clientName;			//사용자 이름
	private String clientPassword;		//사용자 비밀번호
	private String clientProfileImage;	//사용자 프로필 사진
	private int clientAge;				//사용자 나이
	private String clientAddress;		//사용자 주소
	private String clientPhoneNum;		//사용자 전화번호
}

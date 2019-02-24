package kr.purred.startboot2.model.fcm;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FcmNotiData
{
	/**
	 * FCM 토큰
	 */
	private String token;

	/**
	 * 회원 아이디
	 */
	private String memberID;

	/**
	 * 타이틀
	 */
	private String title;

	/**
	 * Body
	 */
	private String body;

	/**
	 * 타입
	 */
	private String type;

	/**
	 * 이미지
	 */
	private String image;

	/**
	 * 통지 아이디
	 */
	private String notiID;

	/**
	 * 추가 데이터
	 */
	private Map<String, String> addonData;

}

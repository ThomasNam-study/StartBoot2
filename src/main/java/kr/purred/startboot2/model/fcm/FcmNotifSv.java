package kr.purred.startboot2.model.fcm;

public interface FcmNotifSv
{
	/**
	 * FCM 통지 데이터 전송
	 * @param notiData 통지 데이터
	 * @throws Exception 예외
	 */
	boolean pushFCMNotification (FcmNotiData notiData) throws Exception;
}

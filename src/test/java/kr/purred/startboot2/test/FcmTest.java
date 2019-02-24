package kr.purred.startboot2.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import kr.purred.startboot2.model.fcm.FcmNotiData;
import kr.purred.startboot2.model.fcm.FcmNotifSv;

@RunWith (SpringRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FcmTest
{
	@Autowired FcmNotifSv fcmNotifSv;

	@Test
	public void test ()
	{
		FcmNotiData data = new FcmNotiData ();

		data.setTitle ("테스트");
		data.setBody ("테스트");

		Map<String, String> datas = new HashMap<> ();

		datas.put ("eventCode", "EVENT_SHARE_SCHEDULE");
		datas.put ("eventData1", "29");
		datas.put ("eventTitleData1", "네비웍스");
		datas.put ("menuNo", "schedule");

		data.setAddonData (datas);

		try
		{
			fcmNotifSv.pushFCMNotification (data);
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
	}
}

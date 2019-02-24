package kr.purred.startboot2.model.fcm;

import net.minidev.json.JSONObject;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import kr.purred.startboot2.model.StrLib;

@Service
public class FcmNotifSvImp implements FcmNotifSv
{
	private final static String AUTH_KEY_FCM = "";

	private final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

	@Override
	public boolean pushFCMNotification (FcmNotiData notiData)
	{
		if (notiData == null)
			return false;

		if (StrLib.isEmptyStr (notiData.getToken ()) || StrLib.isEmptyStr (notiData.getTitle ()) || StrLib.isEmptyStr (notiData.getBody ()))
			return false;

		try
		{
			URL url = new URL (API_URL_FCM);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection ();

			conn.setUseCaches (false);
			conn.setDoInput (true);
			conn.setDoOutput (true);

			conn.setRequestMethod ("POST");
			conn.setRequestProperty ("Authorization", "key=" + AUTH_KEY_FCM);
			conn.setRequestProperty ("Content-Type", "application/json");

			JSONObject notification = new JSONObject ();
			JSONObject data = new JSONObject ();

			//notification.put ("title", notiData.getTitle ()); // Notification title
			//notification.put ("body", notiData.getBody ()); // Notification body

			data.put ("id", notiData.getNotiID ());


			if (StrLib.isExistStr (notiData.getImage ()))
				data.put ("image", notiData.getImage ());

			data.put ("type", notiData.getType ());

			JSONObject json = new JSONObject ();

			if (notiData.getAddonData () != null && notiData.getAddonData ().size () > 0)
			{
				JSONObject responseJson = new JSONObject ();

				for (Map.Entry<String, String> en : notiData.getAddonData ().entrySet ())
				{
					responseJson.put (en.getKey (), en.getValue ());
				}

				data.put ("response", responseJson);
			}

			json.put ("notification", notification);
			json.put ("data", data);
			json.put ("to", notiData.getToken ().trim ());

			OutputStreamWriter wr = new OutputStreamWriter (conn.getOutputStream ());

			wr.write (json.toString ());
			wr.flush ();

			InputStreamReader rw = new InputStreamReader (conn.getInputStream ());

			BufferedReader br = new BufferedReader (rw);

			StringBuilder result = new StringBuilder ();

			String line;

			while ((line = br.readLine ()) != null)
			{
				result.append (line).append ("\n");
			}

			br.close ();
			rw.close ();
			conn.disconnect ();

			System.out.println (result);

			return true;
		}
		catch (Exception e)
		{
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace ();

			return false;
		}
	}

}

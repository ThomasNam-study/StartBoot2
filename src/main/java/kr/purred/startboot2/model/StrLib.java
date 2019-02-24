package kr.purred.startboot2.model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.MessageFormat;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Pattern;

public class StrLib
{
	static private final String codeList = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * 문자열 null 체크  null 이거나 빈공백이면 true 리턴
	 */
	public static boolean isEmptyStr (String str)
	{
		return str == null || str.equals ("") || str.equals ("null");

	}

	/**
	 * 숫자 null 체크  0이면 true 리턴
	 */
	public static boolean isEmptyNum(int no)
	{
		return no == 0;
	}

	/**
	 * 스트링 null 체크 null 이면 "" 을 리턴.
	 */
	public static String notNull (String str)
	{
		return (str == null) ? "" : str;
	}

	public static  String makeLocalMoblieForm(String mobileNum)
	{
		if(mobileNum.startsWith("0"))
			return mobileNum;
		else
			return "0"+mobileNum;
	}

	public static  String makeGlobalMoblieForm(String mobileNum)
	{
		if(mobileNum.startsWith("0"))
			return mobileNum.substring(1);
		else
			return mobileNum;
	}

	public static String noData (String str)
	{
		return (str == null) ? "미입력" : str;
	}

	/**
	 *  String 바인딩 1개 바인딩
	 *  StrLib.getStrFormatOne (R.L("RESOURCE_9000"), String.valueOf (mailCnt)));
	 * @param templete
	 * @param data
	 * @return
	 */
	static public String getStrFormatOne (String templete, String data)
	{
		MessageFormat messageFormat = new MessageFormat (templete);

		String [] datas = new String [1];

		datas[0] = data;

		return messageFormat.format (datas);
	}

	/**
	 *   String 바인딩 2개 바인딩
	 *	 StrLib.getStrFormatOne (R.L("RESOURCE_9000"), String.valueOf (mailCnt)));
	 * @param templete
	 * @param data
	 * @param date2
	 * @return
	 */
	static public String getStrFormatTwo (String templete, String data, String date2)
	{
		MessageFormat messageFormat = new MessageFormat (templete);

		String [] datas = new String [2];
		datas[0] = String.valueOf (data);
		datas[1] = String.valueOf (date2);

		return messageFormat.format (datas);
	}

	/**
	 * 전부 str :aacccc delim: a =>[ , , cccc]
	 */
	public static Vector<String> getTokens (String str, String delim)
	{
		StringTokenizer st 		= new StringTokenizer (str, delim, true);
		Vector<String> 	vTokens = new Vector<String> ();

		String prevToken = null;
		String curToken = null;

		while (st.hasMoreTokens ())
		{
			curToken = st.nextToken ();

			if (curToken.equals (delim))
			{
				if (prevToken == null || prevToken.equals (delim))
				{
					vTokens.addElement ("");
				}
			}
			else
			{
				vTokens.addElement (curToken);
			}

			prevToken = curToken;
		}

		if (prevToken.equals (delim))
		{
			vTokens.addElement ("");
		}

		return vTokens;
	}

	public static String subStr (String str, int len, String tail)
	{
		try
		{
			if (str == null)
				return "";

			byte[] arrStr = str.getBytes ("UTF8");
			byte[] retStr;

			if (arrStr.length <= len)
				return (str);

			int i = 0;
			double more = 0;

			for (i = 0; i < len; i++)
			{
				if ((int) arrStr[i] > 127 || (int) arrStr[i] < 0)
				{
					if (i != len - 2)
					{
						i += 2;
						more += 0.9;
					}
					else
						break;
					if (more >= 4)
					{
						len += Math.round (more);
						more = 0;
					}
				}
				if (len >= arrStr.length)
					return (str);
			}

			retStr = new byte[i];
			for (int j = 0; j < i; j++)
				retStr[j] = arrStr[j];

			return (new String (retStr, "UTF8") + tail);
		}
		catch (Exception e)
		{
			e.printStackTrace ();
			System.out.println (e.getMessage ());
		}

		return ("");
	}

	/**
	 * 엔터,<,>," " = 변환
	 */
	public static String printComment (String str)
	{
		str = str.replaceAll ("<","&lt;");
		str = str.replaceAll (">", "&gt;");
		str = str.replaceAll ("\n", "<br>");
		str = str.replaceAll (" ", "&nbsp;");

		return str;
	}

	/**
	 *  [ " ] => [ 특수문자 " 로 변환 ]
	 */
	public static String encodeInputText (String str)
	{
		str = str.replace ("\"", "&quot;");

		return str;
	}

	/**
	 *   [ ' ] => [ 특수문자 ' 로 변환 ]
	 * @param str
	 * @return
	 */
	public static String encodeInputText2 (String str)
	{
		str = str.replace ("\'", "&#39");

		return str;
	}

	/**
	 * Url 인코드
	 * @param url
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String urlEncode (String url) throws UnsupportedEncodingException
	{
		return URLEncoder.encode (url, "UTF-8");
	}

	/**
	 * 동 주소를 출력한다.
	 * @param dong
	 * @return
	 */
	public static String printDongAddr (String dong)
	{
		String [] d = dong.split (" ");

		if (d.length <= 2)
			return dong;

		StringBuffer sb = new StringBuffer ();

		for (int i = 2; i < d.length; i++)
		{
			if (i > 2)
				sb.append (" ");

			sb.append (d[i]);
		}

		return sb.toString ();
	}

	public static boolean isNumeric (String str)
	{
		try
		{
			Double.parseDouble (str);
		}
		catch (NumberFormatException nfe)
		{
			return false;
		}
		return true;
	}

	/**
	 * 전화번호를 나눈다.
	 * @param phone 전화번호
	 * @return
	 */
	static public String [] getPhoneSplit (String phone)
	{
		if (phone == null)
			return null;

		String [] phones = null;

		if (phone.length () == 11)
		{
			phones = new String [3];

			phones[0] = phone.substring (0, 3);
			phones[1] = phone.substring (3, 7);
			phones[2] = phone.substring (7, 11);
		}
		else if (phone.length () == 10)
		{
			phones = new String [3];

			if (phone.startsWith ("02"))
			{
				phones[0] = phone.substring (0, 2);
				phones[1] = phone.substring (2, 6);
				phones[2] = phone.substring (6, 10);
			}
			else
			{
				phones[0] = phone.substring (0, 3);
				phones[1] = phone.substring (3, 6);
				phones[2] = phone.substring (6, 10);
			}
		}

		return phones;
	}

	static public boolean isFirstChar (char c)
	{
		if (c == 'ㄱ')
			return true;
		else if (c == 'ㄴ')
			return true;
		else if (c == 'ㄷ')
			return true;
		else if (c == 'ㄹ')
			return true;
		else if (c == 'ㅁ')
			return true;
		else if (c == 'ㅂ')
			return true;
		else if (c == 'ㅅ')
			return true;
		else if (c == 'ㅇ')
			return true;
		else if (c == 'ㅈ')
			return true;
		else if (c == 'ㅊ')
			return true;
		else if (c == 'ㅋ')
			return true;
		else if (c == 'ㅌ')
			return true;
		else if (c == 'ㅍ')
			return true;
		else if (c == 'ㅎ')
			return true;

		return false;
	}

	/**
	 * \n 만 <br> 로 바꾼다.
	 * @param str
	 * @return
	 */
	public static String nl2br (String str)
	{
		str = str.replaceAll ("\n", "<br>");

		return str;
	}

	public static String generateToken ()
	{
		SecureRandom random = new SecureRandom ();

		return new BigInteger (130, random).toString(32);
	}

	public static String getRndNum (int loopCount)
	{
		StringBuilder str = new StringBuilder ();
		int d;

		for (int i = 1; i <= loopCount; i++)
		{
			Random r = new Random();

			d = r.nextInt (9);

			str.append (Integer.toString (d));
		}

		return str.toString ();
	}

	public static String getRandomCode(int len)
	{
		Random random =new Random();
		char alphaNum[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
		String str = "";
		for(int j = 0; j < len ; j++)
			str = str + alphaNum[ Math.abs(random.nextInt()) % 36 ];

		return str;
	}

	/**
	 * 모바일에 있는 특수 문자를 삭제한다.
	 * @param mobile 핸드폰 번호
	 * @return 특수 문자 삭제된 핸드폰 번호
	 */
	public static String getRemoveMobileChar (String mobile)
	{
		if (mobile == null)
			return "";

		mobile = mobile.replaceAll ("-", "");
		mobile = mobile.replaceAll (" ", "");

		return mobile;
	}

	public static String onlyMobileCode (String mobile)
	{
		if (StrLib.isEmptyStr (mobile))
			return "";

		return StrLib.onlyDigit (mobile);
	}

	public static String addMobileCode (String mobile)
	{
		if (StrLib.isEmptyStr (mobile))
			return "";

		String mobile1 = StrLib.onlyDigit (mobile);

		if (!mobile1.startsWith ("0"))
			mobile1 = "0" + mobile1;

		return mobile1;
	}



	public static String mergeMobile (String cCode, String mobile)
	{
		if ("82".equals (cCode))
		{
			if (!mobile.startsWith ("0"))
				return "0" + mobile;
			else
				return mobile;
		}
		else
			return mobile;
	}

	public static boolean checkMobile(String mobile){
		return Pattern.matches(" ^01(?:0|1|[6-9]) - (?:\\d{3}|\\d{4}) - \\d{4}$",mobile);
	}


	/**
	 * 마지막 문자열 변경
	 */
	public static String replaceLast(String string, String toReplace, String replacement)
	{
		int pos = string.lastIndexOf(toReplace);

		return (pos > -1) ? string.substring(0, pos)+ replacement + string.substring(pos +   toReplace.length(), string.length()) : string;
	}

	public static String onlyDigit (String data)
	{
		return data.replaceAll ("[^0-9]", "");
	}

	public static String notNullObj (Object obj)
	{
		return (obj == null) ? "" : obj.toString ();
	}

	public static boolean isExistStr (String str)
	{
		return !isEmptyStr (str);
	}

	public static long getCodeNum (String source)
	{
		StringBuilder sb = new StringBuilder (source);
		String rbs = sb.reverse ().toString ();

		long num = 0;
		long codeLen = 62;

		int len = rbs.length ();

		for (int i = 0; i < len; i++)
		{
			int index = codeList.indexOf (rbs.charAt (i));

			num += Math.pow (codeLen, i) * (index);
		}

		return num;
	}

	public static String getNumCode(long num)
	{
		long codeLen = 62;
		StringBuilder hex = new StringBuilder ();

		while (num > 0)
		{
			long remaind = num % codeLen;

			num     = (int) Math.floor (num / codeLen);

			hex.insert (0, codeList.substring ((int) remaind, (int) remaind + 1));
		}

		return hex.toString ();
	}

}

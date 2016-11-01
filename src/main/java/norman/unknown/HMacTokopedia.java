package norman.unknown;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import norman.template.template;

public class HMacTokopedia extends template{

	public HMacTokopedia() {
		super("HMacTokopedia", "HMacTokopedia", WINDOWS);
	}

	@Override
	public void doSomething() {
		// hot list example
//		System.out.println(md5("{per_page=6, hash=4c761f170e016836ff84498202b99827, page=1, query=}"));
//		System.out.println(md5("{per_page=6, query=, page=1, hash=4c761f170e016836ff84498202b99827}"));
//		String userId = "1055391";
//		String deviceId = "APA91bF8CYl1j3Mw2Sp_RsrQ17xWLwk9-tInb_9PrhWCg6mqqibmC8dJVXfxD2KMlUQk-07aCEAzJ063YyVXqrurCgXzLnKkjGh2zzr3HDrXNt6Oi70IWbg3V-uSF_c5Ha_U7udEUmay";
//		getHotList(userId, deviceId);
		
		// login example
//		login("tkpd.qc+04@gmail.com", "1", "007Tokopedia", "", "APA91bF8CYl1j3Mw2Sp_RsrQ17xWLwk9-tInb_9PrhWCg6mqqibmC8dJVXfxD2KMlUQk-07aCEAzJ063YyVXqrurCgXzLnKkjGh2zzr3HDrXNt6Oi70IWbg3V-uSF_c5Ha_U7udEUmay");
		
		// login example with uuid
//		login("tkpd.qc+04@gmail.com", "1", "007Tokopedia", "7387a7d21156556cb293e218ba1ce978", "APA91bF8CYl1j3Mw2Sp_RsrQ17xWLwk9-tInb_9PrhWCg6mqqibmC8dJVXfxD2KMlUQk-07aCEAzJ063YyVXqrurCgXzLnKkjGh2zzr3HDrXNt6Oi70IWbg3V-uSF_c5Ha_U7udEUmay");
		
		// question form example 
//		getQuestionForm("1", "0", "1055391","APA91bF8CYl1j3Mw2Sp_RsrQ17xWLwk9-tInb_9PrhWCg6mqqibmC8dJVXfxD2KMlUQk-07aCEAzJ063YyVXqrurCgXzLnKkjGh2zzr3HDrXNt6Oi70IWbg3V-uSF_c5Ha_U7udEUmay");
		
		// answer question
//		getAnswerQuestion("085664011839", "Masukkan nomor HP Anda yang sudah terverifikasi di Tokopedia:", "1", "0", "1055391", "APA91bF8CYl1j3Mw2Sp_RsrQ17xWLwk9-tInb_9PrhWCg6mqqibmC8dJVXfxD2KMlUQk-07aCEAzJ063YyVXqrurCgXzLnKkjGh2zzr3HDrXNt6Oi70IWbg3V-uSF_c5Ha_U7udEUmay");
		
	}

	private void getHotList(String userId, String deviceId) {
		String beforeHash = userId + "~" + deviceId;
//		String hash = md5(beforeHash);
		String hash = md5("~");
		Map<String, String> md5Content = new HashMap<String, String>();
		
		// example of user not log
		
		// hotlist
		md5Content.put("page", "155");
		md5Content.put("per_page", "6");
		md5Content.put("query", "");
		
		md5Content.put("user_id", "");// userId
		md5Content.put("device_id", "");// deviceId
		md5Content.put("hash", hash);
		md5Content.put("device_time", (System.currentTimeMillis() / 1000L) + "");//new Date().getTime()+""
		
		System.out.println(md5Content.toString());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss ZZZ", Locale.ENGLISH);
		
//		map.clear();
		
		Map<String, String> temp =new HashMap<>();
		
		String x = md5(md5Content.toString());
		System.out.println("md5 >>> "+x);
		Date date = new Date();
		String curDate = dateFormat.format(date);
		
		// hot list 
		temp.put("Content-MD5", x);
		temp.put("Date", curDate);
		temp.put("Authorization", "TKPD Tokopedia:" 
				+generateHMACSignature(generateTkpdAuthString("GET", x, "", curDate, "/v4/hotlist/get_hotlist.pl")));
		temp.put("X-Method", "GET");
		System.out.println(temp.toString());
	}
	
	void login(String user_email, String os_type, String user_password, String uuid, String device_id){
		Map<String, String> md5Content = new HashMap<String, String>();
		// login 
		md5Content.put("user_email", user_email);
		md5Content.put("os_type",os_type);
		md5Content.put("user_password",user_password);
		md5Content.put("uuid", uuid);
		
		// karena belum login makanya dikasih kosong aja 
		String user_id ="";
		md5Content.put("device_id", device_id);
		md5Content.put("user_id", user_id);
		String hash = md5(user_id+"~"+device_id);
		md5Content.put("hash", hash);
		
		System.out.println(md5Content.toString());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss ZZZ", Locale.ENGLISH);
		
//		map.clear();
		
		Map<String, String> result =new HashMap<>();
		
		String x = md5(md5Content.toString());
		System.out.println("md5 >>> "+x);
		Date date = new Date();
		String curDate = dateFormat.format(date);
		
		// login
		result.put("Content-MD5", x);
		result.put("Date", curDate);
		result.put("Authorization", "TKPD Tokopedia:" 
				+generateHMACSignature(generateTkpdAuthString("POST", x, "application/x-www-form-urlencoded", curDate, "/v4/session/login.pl")));
		result.put("X-Method", "POST");
		System.out.println(result.toString());
	}
	
	void getQuestionForm(String user_check_security_1, String user_check_security_2, String userId, String deviceId){
		Map<String, String> md5Content = new HashMap<String, String>();
		
		// get question
		md5Content.put("user_check_security_1", user_check_security_1);
		md5Content.put("user_check_security_2",user_check_security_2);
		md5Content.put("user_id",userId);
		md5Content.put("device_id", userId);
		String hash = md5(userId+"~"+userId);
		md5Content.put("hash", hash);
		System.out.println(md5Content.toString());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss ZZZ", Locale.ENGLISH);
		
//		map.clear();
		
		Map<String, String> result =new HashMap<>();
		
		String x = md5(md5Content.toString());
		System.out.println("md5 >>> "+x);
		Date date = new Date();
		String curDate = dateFormat.format(date);
		
		//get question
		result.put("Content-MD5", x);
		result.put("Date", curDate);
		result.put("Authorization", "TKPD Tokopedia:" 
				+generateHMACSignature(generateTkpdAuthString("GET", x, "", curDate, "/v4/interrupt/get_question_form.pl")));
		result.put("X-Method", "GET");
		System.out.println(result.toString());
	}
	
	
	void getAnswerQuestion(String answer, String question, String user_check_security_1, String user_check_security_2, String userId, String deviceId){
Map<String, String> md5Content = new HashMap<String, String>();
		
		// get question
		md5Content.put("answer", answer);
		md5Content.put("question",question);
		md5Content.put("user_check_security_1",user_check_security_1);
		md5Content.put("user_check_security_2",user_check_security_2);
		md5Content.put("user_id",userId);
		md5Content.put("device_id", userId);
		String hash = md5(userId+"~"+userId);
		md5Content.put("hash", hash);
		System.out.println(md5Content.toString());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss ZZZ", Locale.ENGLISH);
		
//		map.clear();
		
		Map<String, String> result =new HashMap<>();
		
		String x = md5(md5Content.toString());
		System.out.println("md5 >>> "+x);
		Date date = new Date();
		String curDate = dateFormat.format(date);
		
		result.put("Content-MD5", x);
		result.put("Date", curDate);
		result.put("Authorization", "TKPD Tokopedia:" 
				+generateHMACSignature(generateTkpdAuthString("POST", x, "application/x-www-form-urlencoded", curDate, "/v4/action/interrupt/answer_question.pl")));
		result.put("X-Method", "POST");
		System.out.println(result.toString());
	}
	
	
	String generateHMACSignature(String auth) {
        ///auth = "POST\\n1234567890asdfghjkl\\napplication/x-www-form-urlencoded\\nThu, 27 Aug 2015 17:59:05 +0700\\n/v4/home/get_hotlist.pl\"";
        String hmacSignature = "";
        String key = "web_service_v4";
        try {

            hmacSignature = calculateRFC2104HMAC(auth, key);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        return hmacSignature;
    }
	 static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	
	static String calculateRFC2104HMAC(String data, String key)
	        throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
	    {
	        System.out.println(key);
	        System.out.println(data);
	        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
	        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
	        mac.init(signingKey);
	        byte[] rawHmac = mac.doFinal(data.getBytes());
	        String asB64 = Base64.getEncoder().encodeToString(rawHmac);
	        System.out.println(asB64);
	        return asB64;
	    }
	
	String generateTkpdAuthString(String  Request_Method, String Content_MD5, String Content_Type,
	        String Date, String X_Tkpd_Path  ){
	        String temp = "";
	        temp += Request_Method + breakString +
	                Content_MD5 + breakString +
	                Content_Type + breakString +
	                Date + breakString +
	                X_Tkpd_Path;
	        return temp;
	    }

    final static String breakString = "\n";
	
	String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte[] messageDigest = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();

            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b & 0xff));
            }

            //Create hex String
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}

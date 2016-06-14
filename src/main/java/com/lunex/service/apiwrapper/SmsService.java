package com.lunex.service.apiwrapper;

import java.util.HashMap;
import java.util.Map;

import com.lunex.service.apiwrapper.sms.SmsException;
import com.lunex.service.apiwrapper.sms.SmsResponse;

public class SmsService extends BaseXmlApi {

  public SmsService(String target) {
    super(target);
  }

  public void sendSms(String srcNum, String dstNum, String data) throws SmsException {
    Map<String, String> params = new HashMap<String, String>();
    params.put("srcnum", srcNum);
    params.put("dstnum", dstNum);

    String url = String.format("type/Refill/lang/en/");
    SmsResponse smsResponse = this.post(url, params, data, SmsResponse.class);
    if (smsResponse.code < 0) {
      throw new SmsException(smsResponse.code, smsResponse.message);
    }
  }

  public static void main(String[] args) {
    String data =
        new StringBuilder()
            .append("<Data xmlns:i='http://www.w3.org/2001/XMLSchema-instance'>")
            .append(
                "<AccessNumList><AccessNum><Phone>%s</Phone></AccessNum></AccessNumList>")
            .append(
                "<Order><Amount>0</Amount><Bonus>%s</Bonus><Balance>0</Balance></Order>")
            .append(
                "<Company><Name>%s</Name><HomeUrl>%s</HomeUrl><CsPhone>%s</CsPhone></Company>")
            .append("</Data>").toString();

    String accessNum = "2605856146";
    String orderBonus = "10";
    String companyName = "1ClicMax";
    String companyUrl = "www.LunexTelecom.com";
    String csPhone = "8883332404";
    data = String.format(data, accessNum, orderBonus, companyName, companyUrl, csPhone);

    SmsService s = new SmsService("http://192.168.93.160:8081/sms/");
    String srcNum = "6784003701";
    String dstNum = "7272334556";

    try {
      s.sendSms(srcNum, dstNum, data);
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }
}

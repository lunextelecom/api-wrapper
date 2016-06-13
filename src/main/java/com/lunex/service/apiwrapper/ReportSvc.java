package com.lunex.service.apiwrapper;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import com.lunex.service.apiwrapper.reportsvc.CompanyInfo;
import com.lunex.service.apiwrapper.reportsvc.CompanyInfoResponse;
import com.lunex.service.apiwrapper.reportsvc.ReportSvcException;

public class ReportSvc extends BaseRawJsonApi {

  public ReportSvc(String target) {
    super(target);
  }

  public CompanyInfo getCompanyInfo(int companyId) throws ReportSvcException {
    Map<String, String> params = new HashMap<String, String>();
    params.put("id", String.valueOf(companyId));
    CompanyInfoResponse companyInfoResponse = this.get(String.format("lookup/company/?id=%s", companyId), MediaType.APPLICATION_JSON, null, CompanyInfoResponse.class);
    if (companyInfoResponse.code < 0) {
      throw new ReportSvcException(companyInfoResponse.code, companyInfoResponse.message);
    }
    return companyInfoResponse.companyInfo;
  }

  public static void main(String[] args) {
    ReportSvc r = new ReportSvc("http://10.9.9.62:8090/reportsvc/");
    try {
      CompanyInfo ci = r.getCompanyInfo(10);
      System.out.println(ci.toString());
    } catch(Exception ex) {
      System.out.println(ex);
    }

  }
}

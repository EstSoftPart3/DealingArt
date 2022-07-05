package com.da.fo.service;
import javax.servlet.http.HttpServletRequest;

public class CommonUtils {

	private static String localUri = "local";
	
	public static String getHostUri(HttpServletRequest request) {

		String domainName = request.getServerName();
		
		if(domainName.startsWith(localUri)) {
			return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
		} else {
			//return request.getScheme() + "://" + request.getServerName();
			return "https://" + request.getServerName();
		}
		
	}
	
	public static String getHostUriFile(HttpServletRequest request) {
		
		return request.getServletPath();
		
	}
}
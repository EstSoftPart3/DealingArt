package com.da.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ScriptUtils {
	
	public static void init(HttpServletResponse response) {
        response.setContentType("text/html; charset=euc-kr");
        response.setCharacterEncoding("euc-kr");
    }
	
	public static void alert(HttpServletResponse response, String alertText, String objText) throws IOException {
        init(response);
        PrintWriter out = response.getWriter();
        //out.println("<script>alert('" + alertText + "');</script> ");
        out.println("<script>window.opener.modalAlertShow('" + alertText + "','"+ objText +"')</script> ");
        out.flush();
    }

	public static void windowClose(HttpServletResponse response) throws IOException {
        init(response);
        PrintWriter out = response.getWriter();
        out.println("<script>window.close(); </script> ");
        out.flush();
    }	
	
	public static void windowReload(HttpServletResponse response) throws IOException {
        init(response);
        PrintWriter out = response.getWriter();
        out.println("<script> opener.location.reload(); </script> ");
        out.flush();
    }	

}

package com.TagHandler;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class WordCountTagHandler extends SimpleTagSupport{
	
	public void doTag() throws JspException, IOException {
	
		JspWriter out = getJspContext().getOut();
		int i=0;
		int count_is=0;
		int count_a=0;
		int count_the=0;
		
		StringWriter stringwriter = new StringWriter();
		StringBuffer body = new StringBuffer();
		
		getJspBody().invoke(stringwriter);
		
		body.append(stringwriter.getBuffer());
		String bodycontent = body.toString();
		
		String [] words = bodycontent.split(" ");
		
		for(i=0;i<words.length;i++)
		{
			if("is".equals(words[i].toLowerCase()))
			{
				count_is++;
			}
			if("a".equals(words[i].toLowerCase()))
			{
				count_a++;
			}
			if("the".equals(words[i].toLowerCase()))
			{
				count_the++;
			}
		}
		
		out.println(bodycontent);
		out.println("<br><br><br>");
		out.println("Total Number of 'is' = "+count_is);
		out.println("<br>");
		out.println("Total Number of 'a' = "+count_a);
		out.println("<br>");
		out.println("Total Number of 'the' = "+count_the);
	}

}

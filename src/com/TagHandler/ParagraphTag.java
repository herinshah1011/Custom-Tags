package com.TagHandler;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import jdk.nashorn.internal.runtime.linker.InvokeByName;

public class ParagraphTag extends SimpleTagSupport{
	
	public void doTag() throws JspException, IOException {
	
		JspWriter out = getJspContext().getOut();
		int i=0,countis=0,counta=0,countthe=0;
		
		StringWriter sw = new StringWriter();
		StringBuffer body = new StringBuffer();
		
		getJspBody().invoke(sw);
		
		body.append(sw.getBuffer());
		String bodyContent = body.toString();
		
		String [] words = bodyContent.split(" ");
		
		for(i=0;i<words.length;i++)
		{
			if("is".equals(words[i].toLowerCase()))
			{
				countis++;
			}
			if("a".equals(words[i].toLowerCase()))
			{
				counta++;
			}
			if("the".equals(words[i].toLowerCase()))
			{
				countthe++;
			}
		}
		
		out.println(bodyContent);
		out.println("<br><br><br>");
		out.println("Total Number of 'is' = "+countis);
		out.println("<br>");
		out.println("Total Number of 'a' = "+counta);
		out.println("<br>");
		out.println("Total Number of 'the' = "+countthe);
	}

}

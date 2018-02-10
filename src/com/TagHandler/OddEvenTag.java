package com.TagHandler;
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

public class OddEvenTag extends SimpleTagSupport{
	
	private int number;

	public void setNumber(int number) {
		this.number = number;
	}
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
				
		if ( number % 2 == 0 )
			out.println("Entered Number = "+number+" is Even");
		else
			out.println("Entered Number = "+number+" is Odd");
	}

}

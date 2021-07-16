package com.fis.webapp.service;

import org.springframework.stereotype.Component;

@Component
public class getNameDomain {

		public String getName(String email) {
			return email.substring(0,(email.indexOf("@")));
		}
		public String getDomain(String email) {
			
			return email.substring(email.indexOf("@")+1);
			
		}

	    

}

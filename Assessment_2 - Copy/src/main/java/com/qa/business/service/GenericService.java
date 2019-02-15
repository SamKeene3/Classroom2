package com.qa.business.service;

public interface GenericService {
	
	String createSomething(String creatable );
	
	String getEverything();
	
	String getSomething(Long anID);
	
	String updateSomething(String update, Long anID);
	
	String deleteSomething(Long anID);

}

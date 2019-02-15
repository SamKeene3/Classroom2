package com.qa.persistence.repository;

public interface GenericRepo {
	
	String getSomthing(Long anID);
	
	String createSomething(String trainee);
	
	String getEverything();
	
	String updateSomething(Long id, String update);
	
	String deleteSomething(Long anid);
	
}

 
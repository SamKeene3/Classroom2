package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.GenericService;

public class TraineeEndpoint {
	
	@Inject
	GenericService svc;

	@Path("/getAllTrainee")
	@GET
	@Produces("application/json") 
	public String getSEverything() {
		return svc.getEverything();
	}

	@Path("/createATrainee")
	@POST
	@Produces("application/json")
	public String createSomething(String creatable) {
		return svc.createSomething(creatable);
	}

	@Path("/deleteATrainee/{id}")
	@DELETE
	@Produces("application/json")
	public String deleteSomething(@PathParam("id") Long anID) {
		return svc.deleteSomething(anID);
	}

	@Path("/getTrainee/{id}")
	@GET
	@Produces("application/json")
	public String getSomething(@PathParam("id") Long anID) {
		return svc.getSomething(anID);
	}

	@Path("/updateTrainee/{id}")
	@PUT
	@Produces("application/json")
	public String updateSomething(@PathParam("id") Long anID, String update) {
		return svc.updateSomething(update, anID);
	}

	public void setService(GenericService svc2) {
		this.svc = svc2;
		
	}

}

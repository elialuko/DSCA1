package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.Customer;
import entities.Deposits;
import entities.Loans;

@Path("/DepositsCRUD")
public class DepositsCRUD {

	private static Map<String, Deposits> deposits = new HashMap<String, Deposits>();
	
	static {
		Deposits dep = new Deposits();
		dep.setId(1);
		dep.setDate("1/10/23");
		dep.setAmount(100);
		deposits.put(dep.getDate(), dep);
	}

	
	@GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello(){
        return "Hello World"; 
	}
	
	@GET
    @Path("/helloworld")
    @Produces("text/plain")
    public String helloWorld(){
        return "Hello World New";    
    }
	
	@GET
    @Path("/echo/{message}")
    @Produces("text/plain")
    public String echo(@PathParam("message")String message){
        return message;  
    }
	
	@GET
    @Path("/newEcho/{message}")
    @Produces("text/plain")
    public String newEcho(@PathParam("message")String message){
        return message;  
    }
	
	@GET
    @Path("/Deposits")
    @Produces("application/xml")
    public List<Deposits> listDeposits(){
        return new ArrayList<Deposits>(deposits.values());
    }
	
	@GET
    @Path("/deposits/{depositid}")
    @Produces("application/xml")
    public Deposits getDeposits(@PathParam("depositid")String depositId){
		return deposits.get(depositId);		
    }
	
	@POST
	@Path("/createxml")
    @Consumes("application/xml")
    public String addDeposit(Deposits deposit){
		
		return "Deposit added " +deposit.getAmount();		
    }
	
	@POST
	@Path("/createjson")
    @Consumes("application/json")
    public String addJSONDeposit(Deposits deposit){
		return "Deposit added " +deposit.getAmount();		
    }
	
	@GET
    @Path("/json/deposits/")
    @Produces("application/json")
    public List<Deposits> listDepositJSON(){
		return new ArrayList<Deposits>(deposits.values());
    }
	
	@GET
    @Path("/json/deposits/{depositid}")
    @Produces("application/json")
    public Deposits getDepositJSON(@PathParam("depositid")String depositId){
		return deposits.get(depositId);		
    }
	
	@GET
    @Path("/depositsxmlfromdb")
    @Produces("application/xml")
    public List<Deposits> getDepositsFromDB(){
        DepositsDAO dao = new DepositsDAO();
        return dao.getAllDeposits();
    }
	
	@GET
    @Path("/depositsjsonfromdb")
    @Produces("application/json")
    public List<Deposits> getJSONDepositsFromDB(){
		DepositsDAO dao = new DepositsDAO();
        return dao.getAllDeposits();
    }
	
	@POST
	@Path("/newDeposit")
    @Consumes("application/json")
    public String addDepositToDBJSON(Deposits deposit){
		DepositsDAO dao = new DepositsDAO();
		dao.persist(deposit);
		return "Deposit added to DB from JSON Param "+deposit.getAmount();	
    }
	
	@PUT
    @Path("/updateDeposit/")
    @Produces("application/json")
    public Deposits updateDeposit(Deposits deposit){
		DepositsDAO dao = new DepositsDAO();
		return dao.merge(deposit);	
    }
	
	//@DELETE
    //@Path("/deleteDeposit/{depositName}")
    //@Produces("text/plain")
    //public String deleteDeposit(@PathParam("depositName")String depositName){
		//DepositsDAO dao = new DepositsDAO();
		//Deposits d = dao.getCustomerByUsername(depositName);
		//dao.remove(d);	
		//return "Deposit "+d+" deleted";
    //}
}

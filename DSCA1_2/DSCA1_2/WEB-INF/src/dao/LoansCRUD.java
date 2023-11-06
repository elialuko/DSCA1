package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.Customer;
import entities.Loans;

@Path("/LoansCRUD")
public class LoansCRUD {

	private static Map<String, Loans> loans = new HashMap<String, Loans>();
	
	static {
		Loans loan = new Loans();
		loan.setId(1);
		loan.setDesc("Description");
		loan.setLoan_amount(100);
		loans.put(loan.getDesc(), loan);
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
    @Path("/Loans")
    @Produces("application/xml")
    public List<Loans> listLoans(){
        return new ArrayList<Loans>(loans.values());
    }
	
	@GET
    @Path("/loans/{loanid}")
    @Produces("application/xml")
    public Loans getLoan(@PathParam("loanid")String loanId){
		return loans.get(loanId);		
    }
	
	@POST
	@Path("/createxml")
    @Consumes("application/xml")
    public String addLoan(Loans loan){
		
		return "Loan added " +loan.getDesc();		
    }
	
	@POST
	@Path("/createjson")
    @Consumes("application/json")
    public String addJSONLoan(Loans loan){
		return "Loan added " +loan.getDesc();		
    }
	
	@GET
    @Path("/json/loans/")
    @Produces("application/json")
    public List<Loans> listLoanJSON(){
		return new ArrayList<Loans>(loans.values());
    }
	
	@GET
    @Path("/json/loans/{loanid}")
    @Produces("application/json")
    public Loans getLoanJSON(@PathParam("loanid")String loanId){
		return loans.get(loanId);		
    }
	
	@GET
    @Path("/loansxmlfromdb")
    @Produces("application/xml")
    public List<Loans> getLoansFromDB(){
        LoansDAO dao = new LoansDAO();
        return dao.getAllLoans();
    }
	
	@GET
    @Path("/loansjsonfromdb")
    @Produces("application/json")
    public List<Loans> getJSONLoansFromDB(){
		LoansDAO dao = new LoansDAO();
        return dao.getAllLoans();
    }
	
	
	@POST
	@Path("/newLoan")
    @Consumes("application/json")
    public String addLoanToDBJSON(Loans loan){
		LoansDAO dao = new LoansDAO();
		dao.persist(loan);
		return "Loan added to DB from JSON Param "+loan.getDesc();	
    }
	
	@PUT
    @Path("/updateLoan/")
    @Produces("application/json")
    public Loans updateLoan(Loans loan){
		LoansDAO dao = new LoansDAO();
		return dao.merge(loan);	
    }
	
	//@DELETE
    //@Path("/deleteLoan/{loanName}")
    //@Produces("text/plain")
    //public String deleteLoan(@PathParam("loanName")String loanName){
		//LoansDAO dao = new LoansDAO();
		//Loans l = dao.getCustomerByUsername(loanName);
		//dao.remove(l);	
		//return "Customer "+l+" deleted";
    //}
}

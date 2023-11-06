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

@Path("/CustomerCRUD")
public class CustomerCRUD {

	private static Map<String, Customer> customers = new HashMap<String, Customer>();
	
	static {
		Customer cust = new Customer();
		cust.setId(1);
		cust.setName("John");
		cust.setNumber("087111");
		cust.setAddress("123 Rd");
		cust.setAnn_sal(100);
		customers.put(Integer.toString(cust.getId()), cust);
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
    @Path("/Customer")
    @Produces("application/xml")
    public List<Customer> listCustomer(){
        return new ArrayList<Customer>(customers.values());
    }
	
	@GET
    @Path("/customer/{customerid}")
    @Produces("application/xml")
    public Customer getCustomer(@PathParam("customerid")String customerId){
		return customers.get(customerId);		
    }
	
	@POST
	@Path("/createxml")
    @Consumes("application/xml")
    public String addCustomer(Customer customer){
		
		return "Customer added " +customer.getName();		
    }
	
	@POST
	@Path("/createjson")
    @Consumes("application/json")
    public String addJSONCustomer(Customer customer){
		return "Customer added " +customer.getName();		
    }
	
	@GET
    @Path("/json/customers/")
    @Produces("application/json")
    public List<Customer> listCustomerJSON(){
		return new ArrayList<Customer>(customers.values());
    }
	
	@GET
    @Path("/json/customer/{customerid}")
    @Produces("application/json")
    public Customer getCustomerJSON(@PathParam("customerid")String customerId){
		return customers.get(customerId);		
    }
	
	@GET
    @Path("/customersxmlfromdb")
    @Produces("application/xml")
    public List<Customer> getCustomersFromDB(){
        CustomerDOA dao = new CustomerDOA();
        return dao.getAllCustomers();
    }
	
	@GET
    @Path("/customersjsonfromdb")
    @Produces("application/json")
    public List<Customer> getJSONCustomersFromDB(){
		CustomerDOA dao = new CustomerDOA();
        return dao.getAllCustomers();
    }
	
	@GET
    @Path("/jsonDB/customer/{customerName}")
    @Produces("application/json")
    public Customer getCustomerByNameFromDBJSON(@PathParam("customerName")String customerName){
		CustomerDOA dao = new CustomerDOA();
		return dao.getCustomerByUsername(customerName);		
    }
	
	@GET
    @Path("/customerfromDBXML/{customerName}")
    @Produces("application/xml")
    public Customer getCustomerByUsernameFromDBXML(@PathParam("customerName")String customerName){
		CustomerDOA dao = new CustomerDOA();
		return dao.getCustomerByUsername(customerName);	
    }
	
	@POST
	@Path("/newCustomer")
    @Consumes("application/json")
    public String addCustomerToDBJSON(Customer customer){
		CustomerDOA dao = new CustomerDOA();
		dao.persist(customer);
		return "Customer added to DB from JSON Param "+customer.getName();	
    }
	
	@PUT
    @Path("/updateCustomer/")
    @Produces("application/json")
    public Customer updateCustomer(Customer customer){
		CustomerDOA dao = new CustomerDOA();
		return dao.merge(customer);	
    }
	
	@DELETE
    @Path("/deleteCustomer/{customerName}")
    @Produces("text/plain")
    public String deleteCustomer(@PathParam("customerName")String customerName){
		CustomerDOA dao = new CustomerDOA();
		Customer cus = dao.getCustomerByUsername(customerName);
		dao.remove(cus);	
		return "Customer "+cus+" deleted";
    }
}

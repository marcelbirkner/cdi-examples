package de.sample;

import java.util.List;

import javax.inject.Inject;
import javax.jws.*;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.sample.entities.Customer;
import de.sample.transactions.CustomerServiceTransaction;

/**
 * Standard JAX-WS annotations
 * 
 * @WebParam describes parameter names
 * @WebMethod describes method names
 * @WebResult describes the name of the return value
 * @WebService describes the webservice service name and namespace
 * @SOAPBinding describes the webservice parameterStyle, in this case its document-literal-wrapped
 */
@WebService(serviceName = "CustomerServiceImpl", name = "CustomerServiceImpl", targetNamespace = "http://sample.de/customerservice/")
@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT, use = Use.LITERAL)
public class CustomerServiceImpl {

	@Inject CustomerServiceContext context;

	private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@WebMethod(operationName = "createNewCustomer")
	@WebResult(name = "successful")
	public boolean createNewCustomer( @WebParam(name = "customer") Customer customer ) {
		logger.info("createNewCustomer :: " + customer.getCustomerId() );
		return getTransaction().createNewCustomer( customer ) ;
	}

	@WebMethod(operationName = "getCustomerFor")
	@WebResult(name = "customer")
	public List<Customer> getCustomerFor( @WebParam(name = "customerId") int customerId ) {
		logger.info("getCustomerFor :: " + customerId);
		return getTransaction().getCustomerFor( customerId );
	}
	
	@WebMethod(operationName = "findCustomerByCustomerId")
	@WebResult(name = "customer")
	public Customer findCustomerByCustomerId( @WebParam(name = "customerId") int customerId ) {
		logger.info("findCustomerByCustomerId :: " + customerId);
		return getTransaction().findCustomerByCustomerId( customerId );
	}
	
	private CustomerServiceTransaction getTransaction() {
		EntityManager em = context.createEntityManager();
		CustomerServiceTransaction transaction = new CustomerServiceTransaction( em );
		return transaction;
	}
}

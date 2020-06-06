  
package com.amey.mockito.interfaces;

import com.amey.mockito.Customer;
import com.amey.mockito.exceptions.DAOException;

public interface CustomerController {
	boolean customerApplication(Customer customer) throws DAOException;

}
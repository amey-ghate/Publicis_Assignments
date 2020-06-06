  
package com.amey.mockito.dao;

import com.amey.mockito.Customer;
import com.amey.mockito.exceptions.DAOException;
import com.amey.mockito.interfaces.CustomerDAO;

public class CustomerDAOImpl implements CustomerDAO {

	public void addCustomer(Customer customer) throws DAOException {
		System.out.println("The customer has been added");
	}

}
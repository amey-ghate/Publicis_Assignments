package com.amey.mockito.interfaces;

import com.amey.mockito.Customer;
import com.amey.mockito.exceptions.DAOException;

public interface CustomerDAO {

	void addCustomer(Customer customer) throws DAOException;

}
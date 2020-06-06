package com.amey.mockito.interfaces;

import com.amey.mockito.Customer;
import com.amey.mockito.exceptions.DAOException;

public interface CustomerValidation {

	boolean checkLength(Customer customer) throws DAOException;

}
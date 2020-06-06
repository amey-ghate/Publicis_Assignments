package com.amey.mockito.controller;

import com.amey.mockito.Customer;
import com.amey.mockito.exceptions.DAOException;
import com.amey.mockito.interfaces.CustomerController;
import com.amey.mockito.service.CustomerValidationImpl;

public class CustomerControllerImpl implements CustomerController {

	private CustomerValidationImpl validate;

	public boolean customerApplication(Customer customer) throws DAOException {
		try {
			boolean result = validate.checkLength(customer);
			if (result == false) {
				return false;
			}
		} catch (DAOException e) {
			throw new DAOException();
		}
		return true;
	}

	public CustomerValidationImpl getValidate() {
		return validate;
	}

	public void setValidate(CustomerValidationImpl validate) {
		this.validate = validate;
	}

}
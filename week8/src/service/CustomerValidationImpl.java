package com.amey.mockito.service;

import com.amey.mockito.Customer;
import com.amey.mockito.dao.CustomerDAOImpl;
import com.amey.mockito.exceptions.DAOException;
import com.amey.mockito.interfaces.CustomerValidation;

public class CustomerValidationImpl implements CustomerValidation {

	private CustomerDAOImpl daoImpl;

	public boolean checkLength(Customer customer) throws DAOException {
		try {
			String nameString = customer.getNameString();
			if (nameString.length() < 4) {
				return false;
			} else {
				daoImpl.addCustomer(customer);
			}
		} catch (DAOException e) {
			throw new DAOException();
		}
		return true;

	}

	public CustomerDAOImpl getDaoImpl() {
		return daoImpl;
	}

	public void setDaoImpl(CustomerDAOImpl daoImpl) {
		this.daoImpl = daoImpl;
	}

}
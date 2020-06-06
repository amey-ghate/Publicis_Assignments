package com.amey.mockito.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.amey.mockito.Customer;
import com.amey.mockito.dao.CustomerDAOImpl;
import com.amey.mockito.exceptions.DAOException;

public class CustomerValidationImplTest {

	@Mock
	CustomerDAOImpl dao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void checking_Whether_Customer_created_sucessfully() throws DAOException {
		CustomerValidationImpl validationImpl = new CustomerValidationImpl();
		validationImpl.setDaoImpl(dao);

		Customer customer = new Customer();
		customer.setNameString("Abinash");
		doNothing().when(dao).addCustomer(customer);
		boolean result = validationImpl.checkLength(customer);
		verify(dao).addCustomer(customer);

	}

	@Test(expected = DAOException.class)
	public void checking_Whether_throws_Exception() throws DAOException {
		CustomerValidationImpl validationImpl = new CustomerValidationImpl();
		validationImpl.setDaoImpl(dao);

		Customer customer = new Customer();
		customer.setNameString("Abinash");
		doThrow(DAOException.class).when(dao).addCustomer(customer);
		boolean result = validationImpl.checkLength(customer);

	}

}
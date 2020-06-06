package com.amey.mockito.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.amey.mockito.Customer;
import com.amey.mockito.controller.CustomerControllerImpl;
import com.amey.mockito.exceptions.DAOException;
import com.amey.mockito.service.CustomerValidationImpl;

public class CustomerControllerImplTest {

	@Mock
	CustomerValidationImpl validate;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void checking_For_Validity_Of_Cusotmer() throws DAOException {
		CustomerControllerImpl customerControllerImpl = new CustomerControllerImpl();
		customerControllerImpl.setValidate(validate);

		Customer customer = new Customer();
		when(validate.checkLength(customer)).thenReturn(new Boolean(true));

		boolean result = customerControllerImpl.customerApplication(customer);
		assertTrue(result);
		verify(validate).checkLength(customer);
	}

	@Test
	public void checking_For_Non_Validity_Of_Cusotmer() throws DAOException {
		CustomerControllerImpl customerControllerImpl = new CustomerControllerImpl();
		customerControllerImpl.setValidate(validate);

		Customer customer = new Customer();
		when(validate.checkLength(customer)).thenReturn(new Boolean(false));

		boolean result = customerControllerImpl.customerApplication(customer);
		assertFalse(result);
		verify(validate).checkLength(customer);
	}

	@Test(expected = DAOException.class)
	public void checking_For_Exception() throws DAOException {
		CustomerControllerImpl customerControllerImpl = new CustomerControllerImpl();
		customerControllerImpl.setValidate(validate);

		Customer customer = new Customer();
		when(validate.checkLength(customer)).thenThrow(DAOException.class);
		boolean result = customerControllerImpl.customerApplication(customer);
	}

}
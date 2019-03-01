package com.cg.payroll.test;
import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;

import com.cg.payroll.exceptions.AssociateDetailsNotfoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class PayrollServicesTest {
/*	private static PayrollServices services;
	@BeforeClass
	public static void setUpTestEnv() {
		services=new PayrollServicesImpl();
	}
	@Before
	public void setUpTestData() {
		Associate associate1=new Associate(101,126000, "Abhi","Kumar","Production", "Manager", "ss3fs", "abhi@123", new Salary(100000, 30000, 30000, 25000, 20000, 548000, 1000, 1000, 2460000, 1912000), new BankDetails(12323, "HDFC", "HDFC32"));
		Associate associate2=new Associate(102,150000, "Arun","Singh","Training", "Manager", "ss3rytfs", "abdshi@123", new Salary(2540, 21132, 23454, 22434, 87324, 24298, 8532, 67242, 288424, 566464), new BankDetails(1442323, "HD66FC", "HD32FC32"));
		PayrollDBUtil.associates.put(associate1.getAssociateId(), associate1);
		PayrollDBUtil.associates.put(associate2.getAssociateId(), associate2);
		
		PayrollDBUtil.ASSOCIATE_ID_COUNTER=102;
	}
	@Test(expected=AssociateDetailsNotfoundException.class)
	public void testGetAssociateDetailsForInvalidAssociateId() throws AssociateDetailsNotfoundException {
		Associate actualAssociate=services.getAssociateDetails(10234);
	}
	@Test
	public void testGetAssociateDetailsForValidAssociateId() throws AssociateDetailsNotfoundException {
		Associate expectedAssociate=new Associate(102,150000, "Arun","Singh","Training", "Manager", "ss3rytfs", "abdshi@123", new Salary(2540, 21132, 23454, 22434, 87324, 24298, 8532, 67242, 288424, 566464), new BankDetails(1442323, "HD66FC", "HD32FC32"));
		Associate actualAssociate=services.getAssociateDetails(102);
	}
	@Test
	public void testAcceptAssociateDetailsForValidData() throws AssociateDetailsNotfoundException {
		int expectedId=103;
		int actualId=services.acceptAssociateDetails("ABD","singh", "adsafd","dsfsf","fsf", "fdsf",24323, 213213,1000, 2232, 234324, "jlkds","hkjw");
		Assert.assertEquals(expectedId, actualId);
	}
	@Test(expected=AssociateDetailsNotfoundException.class)
	public void testCalCulateNetSalaryForInvalidAssociateId() throws AssociateDetailsNotfoundException {
		services.calculateNetSalary(1234);
	}
	@Test
	public void testCalCulateNetSalaryForValidAssociateId() throws AssociateDetailsNotfoundException {
		int expectedSalary=1912000;
		int actualSalary=services.calculateNetSalary(101);
		Assert.assertEquals(expectedSalary, actualSalary);
	}
	@Test
	public void testgetAllAssociateDetails() throws AssociateDetailsNotfoundException{
		Associate associate1=new Associate(101,126000, "Abhi","Kumar","Production", "Manager", "ss3fs", "abhi@123", new Salary(100000, 30000, 30000, 25000, 20000, 548000, 1000, 1000, 2460000, 1912000), new BankDetails(12323, "HDFC", "HDFC32"));
		Associate associate2=new Associate(102,150000, "Arun","Singh","Training", "Manager", "ss3rytfs", "abdshi@123", new Salary(2540, 21132, 23454, 22434, 87324, 24298, 8532, 67242, 288424, 566464), new BankDetails(1442323, "HD66FC", "HD32FC32"));
		ArrayList<Associate>expectedList=new ArrayList<>();
		expectedList.add(associate1);
		expectedList.add(associate2);
		ArrayList<Associate>actualList=(ArrayList<Associate>) services.getAllAssociateDetails();
	}
	@After
	public void tearDownTestData() {
		PayrollDBUtil.associates.clear();
		PayrollDBUtil.ASSOCIATE_ID_COUNTER=100;
	}
	@AfterClass
	public static void tearDownTestEnv() {
		services=null;
	}
	*/

}
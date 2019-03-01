package com.cg.payroll.services;
import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.daoservices.AssociateDAOImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotfoundException;

public class PayrollServicesImpl implements PayrollServices{
	private AssociateDAO associateDao=new AssociateDAOImpl();
	@Override
	public int acceptAssociateDetails(String firstName, String lastName, String emailId, String department,
			String designation, String pancard, int yearlyInvestmentUnder80C, int basicSalary, int epf, int companyPf,
			int accountNumber, String bankName, String ifscCode) {
		Associate associate= new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, new BankDetails(accountNumber, bankName, ifscCode),new Salary(basicSalary, epf, companyPf));
		associate=associateDao.save(associate);
		return associate.getAssociateId();
	}
	@Override
	        public int calculateNetSalary(int associateId) throws AssociateDetailsNotfoundException {
			Associate associate=getAssociateDetails(associateId);
			Salary salary=associate.getSalary();
			int netSal=0,netMonSal=0,tax=0,netAunSal=0;
			int basicSalary=salary.getBasicSalary();
			int hra=(int)(basicSalary*(0.3));
			int coonveyenceAllowance=(int)(basicSalary*0.3);
			int otherAllowance=(int)(basicSalary*0.25);
			int	personalAllowance=(int)(basicSalary*0.2);
			salary.setHra(hra); salary.setConveyenceAllowance(coonveyenceAllowance); salary.setOtherAllowance(otherAllowance);
			salary.setPersonalAllowance(personalAllowance); 
			int totalSalary=((basicSalary+hra+coonveyenceAllowance+otherAllowance+personalAllowance+salary.getEpf()+salary.getCompanyPf())*12);
			salary.setGrossSalary(totalSalary);
			if(salary.getGrossSalary()>=1000000){
				int grossSalary=salary.getGrossSalary();
				int excessAmount=salary.getGrossSalary()-1000000;
				tax=(int)(excessAmount*(0.3));
				salary.setGrossSalary(salary.getGrossSalary()-excessAmount);
				int excessAmount1=salary.getGrossSalary()-500000;
				tax=tax+ (int)(excessAmount1*(0.2));
				salary.setGrossSalary(salary.getGrossSalary()-excessAmount1);
				int excessAmount2=salary.getGrossSalary()-250000;
				int fixedInvest=150000;
				int invest=Math.abs(fixedInvest-(((salary.getEpf()+salary.getCompanyPf())*12)+associate.getYearlyInvestmentUnder80C()));
				tax=(int) (tax+((invest+100000)*0.1));	
				 netAunSal=grossSalary-((salary.getEpf()+salary.getCompanyPf())*12)-tax;
				 netSal=netAunSal/12;
			}
			else if((salary.getGrossSalary()>=500000)&&(salary.getGrossSalary()<1000000)){
				int grossSalary=salary.getGrossSalary();
				int excessAmount1=salary.getGrossSalary()-500000;
				tax=tax+ (int)(excessAmount1*(0.2));
				salary.setGrossSalary(salary.getGrossSalary()-excessAmount1);
				int excessAmount2=salary.getGrossSalary()-250000;
				int fixedInvest=150000;
				int invest=Math.abs(fixedInvest-(((salary.getEpf()+salary.getCompanyPf())*12)+associate.getYearlyInvestmentUnder80C()));
				tax=(int) (tax+((invest+100000)*0.1));
				 netAunSal=grossSalary-((salary.getEpf()+salary.getCompanyPf())*12)-tax;
				 netSal=netAunSal/12;
			}
			else if((salary.getGrossSalary()>=250000)&&(salary.getGrossSalary()<500000)){
				int grossSalary=salary.getGrossSalary();
				int excessAmount2=salary.getGrossSalary()-250000;
				int fixedInvest=150000;
				int invest=Math.abs(fixedInvest-(((salary.getEpf()+salary.getCompanyPf())*12)+associate.getYearlyInvestmentUnder80C()));
				tax=(int) (tax+((invest+100000)*0.1));
				 netAunSal=grossSalary-((salary.getEpf()+salary.getCompanyPf())*12)-tax;
				 netSal=netAunSal/12;
			}
			else{
				int grossSalary=salary.getGrossSalary();
				 netAunSal=grossSalary-((salary.getEpf()+salary.getCompanyPf())*12);
				 netSal=netAunSal/12;
			}
			salary.setNetSalary(netSal);
			salary.setMonthlyTax(tax/12);
			associateDao.update(associate);
		return netSal;
	}

	@Override
	public Associate getAssociateDetails(int associateId) throws AssociateDetailsNotfoundException {
		Associate associate=associateDao.findOne(associateId);
		if(associate==null)
			throw new AssociateDetailsNotfoundException("Invalid Associate ID="+associateId);
		return associate;
	}

	@Override
	public List<Associate> getAllAssociateDetails() {	
		return associateDao.findAll() ;
	}
}
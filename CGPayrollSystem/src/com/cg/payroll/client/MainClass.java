package com.cg.payroll.client;
import java.util.Scanner;
import com.cg.payroll.exceptions.AssociateDetailsNotfoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
public class MainClass {
	public static void main(String[] args) throws AssociateDetailsNotfoundException  {
		PayrollServices services=new PayrollServicesImpl();
		Scanner scan=new Scanner(System.in);
		System.out.println("Choose option");
		
		int associateId=0;
		char ch=' ';
		do
		{
			System.out.println("1)Create Record 2)NetSalary 3)MonthlyTax 4)Associate Details 5)All Details");
		    int choice=scan.nextInt();
			switch(choice){  
			case 1:		System.out.println("Enter First Name=");
								String firstName=scan.next();
								System.out.println("Enter Last Name=");
								String lastName=scan.next();
								System.out.println("Enter emailId=");
								String emailId=scan.next();
								System.out.println("Enter department=");
								String department=scan.next();
								System.out.println("Enter designation=");
								String designation=scan.next();
								System.out.println("Enter pancard=");
								String pancard=scan.next();
								System.out.println("Enter Account Number=");
								int accountNumber=scan.nextInt();
								System.out.println("Enter bankName=");
								String bankName=scan.next();
								System.out.println("Enter ifscCode=");
								String ifscCode=scan.next();
								System.out.println("Enter yearlyInvestmentUnder8oC");
								int yearlyInvestmentUnder80C=scan.nextInt();
								System.out.println("Enter basic salary");
								int basicSalary=scan.nextInt();
								System.out.println("Enter companyPf");
								int companyPf=scan.nextInt();
								System.out.println("Enter epf");
								int epf=scan.nextInt();
								associateId=services.acceptAssociateDetails(firstName, lastName, emailId, department, designation, pancard, yearlyInvestmentUnder80C, basicSalary, epf, companyPf, accountNumber, bankName, ifscCode);
								System.out.println("Record Saved Successfully");
								System.out.println("Your Generated AssociateId="+associateId);
								break;
			case 2 :     
								System.out.println("Enter Associate ID");
								associateId=scan.nextInt();
								try {
											System.out.println("Monthly Salary="+services.calculateNetSalary(associateId));
									} catch (Exception e) {
										
										System.out.println(e);
									}
								break;
								
			case 3 :     
							System.out.println("Enter Associate ID for Tax");
							associateId=scan.nextInt();
							try {
								System.out.println("Monthly tax="+services.getAssociateDetails(associateId).getSalary().getMonthlyTax());
							} catch (Exception e) {
								
								System.out.println(e);
							}
							break;
			case 4 :     
							System.out.println("Enter Associate ID for Details");
							associateId=scan.nextInt();
							try {
								System.out.println("Associate Details="+services.getAssociateDetails(associateId));
							} catch (Exception e) {
								
								System.out.println(e);
							}
							break;
			case 5:
				           System.out.println("full details"+services.getAllAssociateDetails());
				break;
			default : System.out.println("Wrong choice");
								break;
			}
			System.out.println("Want to continue ");
			ch=scan.next().charAt(0);
		}while(ch=='Y');
		
	}
}
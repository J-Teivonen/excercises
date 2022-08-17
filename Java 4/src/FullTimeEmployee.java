
public class FullTimeEmployee extends Employee {
	private double weeklySalary;
	private double benefitDeduction;
	
	public void setWeeklySalary(double weeklySalaryIn) {
		weeklySalary = weeklySalaryIn;
	}
	
	public void setBenefitDeduction(double benefitDedIn) {
		benefitDeduction = benefitDedIn;
	}
	
	public double getBenefitDeduction() {
		return benefitDeduction;
	}
	
	public double findPaymentAmount() {
		return weeklySalary - benefitDeduction;
	}
}

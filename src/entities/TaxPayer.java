package entities;

public class TaxPayer {
	
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	
	
	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending, Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}
	
	public Double getSalaryIncome() {
		return salaryIncome;
	}
	
	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}
	
	public Double getServicesIncome() {
		return servicesIncome;
	}
	
	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}
	
	public Double getCapitalIncome() {
		return capitalIncome;
	}
	
	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}
	
	public Double getHealthSpending() {
		return healthSpending;
	}
	
	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}
	
	public Double getEducationSpending() {
		return educationSpending;
	}
	
	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public double salaryTax() {
		double perMonth = salaryIncome / 12;
		if (perMonth < 3000.00) {
			return 0.0;
		}
		else if (perMonth < 5000.00) {
			return salaryIncome * 0.1;
		}
		else {
			return salaryIncome * 0.2;
		}
	}
	
	public double serviceTax() {
		return servicesIncome * 0.15;
	}
	
	public double capitalTax() {
		return capitalIncome * 0.2;
	}
	
	public double grossTax() {
		return salaryTax() + serviceTax() + capitalTax(); 
	}
	
	public double taxRebate() {
		double gastoDedutivel, maximoDedutivel;
		gastoDedutivel = healthSpending + educationSpending;
		maximoDedutivel = grossTax() * 0.3;
		if(gastoDedutivel > maximoDedutivel) {
			return maximoDedutivel;
		}
		else {
			return gastoDedutivel;
		}
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}
	
	@Override
	public String toString() {
		return  "Imposto bruto total: "
				+ String.format("%.2f%n", grossTax())
				+ "Abatimento: "
				+ String.format("%.2f%n", taxRebate())
				+ "Imposto devido: "
				+ String.format("%.2f%n", netTax());
	}
	
}

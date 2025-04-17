public class BankAccount implements Comparable<BankAccount>{
	
	private String branch;
	private int accNum;
	private String accHName;
	private double balance;
	
	public BankAccount(int accNum, String accHName, double balance, String branch) {
		this.accNum = accNum;
		this.accHName = accHName;
		this.balance = balance;
		this.branch = branch;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getAccNum() {

		return accNum;
	}
	
	public String getAccHName() {
		return accHName;
	}

	public void setAccHName(String accHName) {
		this.accHName = accHName;
	}

	public void deposit(double amt) {
		this.balance = balance + amt;
	}
	
	public void withdraw(double amt) {
		this.balance = balance - amt;
	}
	
	public void curretBalance() {
		System.out.println(balance);
	}

	@Override
	public int hashCode() { //return common property by which objects are grouped
		System.out.println("In hc "+ this);
		
		//return branch.hashCode();  //wrong design, because there will be a change same hash code number is generated for the two different branches
									//The correct design is: assign branchID to each branch separately by yourself in the program
									//and return that id from this hashCode() method
		return BranchMap.getBranchId(branch);
	}
	
	@Override
	public boolean equals(Object obj) { //compare common property and unique property by which one object is diff from other objects in this group
		System.out.println("In eq: "+ this + "  " + obj);
		if(obj instanceof BankAccount) {
			BankAccount acc = (BankAccount)obj;
			
			return this.branch.equals(acc.branch) &&
					this.accNum == acc.accNum;
		}
		
		return false;
	}
	
	@Override
	public int compareTo(BankAccount acc) {
		int diff = this.branch.compareToIgnoreCase(acc.branch);
		if(diff==0) {
			return this.accNum - acc.accNum;  //we must return -ve/+ve/0 value
											//for storing
		}
		return diff;
	}									   
		
	
	@Override
	public String toString() {
		return "\nBankAccount(" + accNum + ", " + accHName + ", " + balance + ", "+branch+")";
	}
	
}

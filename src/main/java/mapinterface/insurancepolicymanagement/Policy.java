package mapinterface.insurancepolicymanagement;

import java.util.Date;
import java.util.Objects;

public class Policy implements Comparable<Policy> {
    private int policyNumber;
    private String policyHolderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(int policyNumber, String policyHolderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Policy policy = (Policy) other;
        return policyNumber == policy.policyNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(policyNumber);
    }

    @Override
    public String toString() {
        return "  Policy Number : " + policyNumber +
                "\n  Policy Holder Name : " + policyHolderName +
                "\n  Expiry Date : " + expiryDate +
                "\n  Coverage Type : " + coverageType +
                "\n  Premium Amount : INR " + premiumAmount + "\n";
    }
}
package bigInt;

public interface Number {
	public BigInt add(BigInt b);
	public BigInt sub(BigInt b);
	public BigInt multiply(BigInt b);
	public BigInt divide(BigInt b);
	public boolean greaterThan(BigInt b);
}

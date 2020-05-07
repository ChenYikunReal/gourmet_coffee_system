public class Product {
	private String code;
	private String description;
	private double price;

	public Product(String var1, String var2, double var3) {
		this.code = var1;
		this.description = var2;
		this.price = var3;
	}

	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}

	public double getPrice() {
		return this.price;
	}

	public boolean equals(Object var1) {
		return var1 instanceof Product && this.getCode().equals(((Product)var1).getCode());
	}

	public String toString() {
		return this.getCode() + "_" + this.getDescription() + "_" + this.getPrice();
	}
}

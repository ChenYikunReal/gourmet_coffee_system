public class CoffeeBrewer extends Product {
	private String model;
	private String waterSupply;
	private int numberOfCups;

	public CoffeeBrewer(String var1, String var2, double var3, String var5, String var6, int var7) {
		super(var1, var2, var3);
		this.model = var5;
		this.waterSupply = var6;
		this.numberOfCups = var7;
	}

	public String getModel() {
		return this.model;
	}

	public String getWaterSupply() {
		return this.waterSupply;
	}

	public int getNumberOfCups() {
		return this.numberOfCups;
	}

	public String toString() {
		return super.toString() + "_" + this.getModel() + "_" + this.getWaterSupply() + "_" + this.getNumberOfCups();
	}
}

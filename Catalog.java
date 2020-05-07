import java.util.ArrayList;
import java.util.Iterator;

public class Catalog implements Iterable<Product> {
	private ArrayList<Product> products = new ArrayList<>();

	public Catalog() {
	}

	public void addProduct(Product var1) {
		this.products.add(var1);
	}

	public Iterator<Product> iterator() {
		return this.products.iterator();
	}

	public Product getProduct(String var1) {
		Iterator var2 = this.products.iterator();

		Product var3;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			var3 = (Product)var2.next();
		} while(!var3.getCode().equals(var1));

		return var3;
	}

	public int getNumberOfProducts() {
		return this.products.size();
	}
}

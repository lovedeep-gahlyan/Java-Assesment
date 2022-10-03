package Assesment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Product{
	private String productID;
	private String productName;
	private double price;
	private int quantity;
	
	
	
	public Product(String productID, String productName, double price, int quantity) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
}
public class ProductLoader{
	ArrayList<Product> a = new ArrayList<>();
	public void loadProduct() throws NumberFormatException, IOException
	{
		
		File file = new File("C:\\work\\Java\\src\\Assesment\\product.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		while(line!=null) {
			String[] arr = line.split(",");
			int p = Integer.parseInt(arr[2]);
			double price = (double)p;
			int quantity = Integer.parseInt(arr[3]);
			String productId = arr[0];
			String productName = arr[1];
			Product mp = new Product(productId,productName,price,quantity);
			a.add(mp);
			line = br.readLine();
		}
	
		br.close();
	}
	
	public ArrayList<Product> getProductList()
	{
		
		return a;
		
	}
	
	public Object searchProduct(String id)
	{
		Product obj = null;
		for(int i=0;i<a.size();i++) {
			Product ob = (Product) a.get(i);
			if(ob.getProductID().equals(id)) {
				obj = ob;
			}
		}
		return obj;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		ProductLoader pl = new ProductLoader();
		pl.loadProduct();
		ArrayList arr = pl.getProductList();
		System.out.println(arr);
		Product p = (Product) pl.searchProduct("P101");
		System.out.println(p.getProductName());
	}
}




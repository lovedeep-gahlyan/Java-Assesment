package Assesment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.*;

public class TestProduct {
public static void main(String[] args) throws NumberFormatException, IOException {
	Scanner s = new Scanner(System.in);
	ProductLoader pl = new ProductLoader();
	pl.loadProduct();
	ArrayList<Product> arr = pl.getProductList();
	for(int i=0; i<arr.size();i++) {
		Product ob = (Product) arr.get(i);
		System.out.println(ob.getProductName());
	}
	System.out.println("Size of arraylist is " + arr.size());
	System.out.println("Enter any product id: ");
	String id = s.next();
	Product p = (Product) pl.searchProduct(id);
	if(p!=null) {
		System.out.println(p.getProductName() + " is what you searched for");	
	}
	else {
		System.out.println("Enter new product details for " + id);
		String productName = s.next();
		int price = s.nextInt();
		int quantity = s.nextInt();
		Product newPrd = new Product(id,productName,price,quantity);
		arr.add(newPrd);
		String s_for_price = Integer.toString(price);
		String s_for_quantity = Integer.toString(quantity);
		String str = "\n" + id + "," + productName + "," +  s_for_price + "," + s_for_quantity;
		
		FileWriter fstream = new FileWriter("C:\\work\\Java\\src\\Assesment\\product.txt",true);
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(str);
		out.close();
		
		
	}
	s.close();
}
}

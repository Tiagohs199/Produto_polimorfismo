import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i =0;i<n;i++) {
			System.out.println("Product #"+i+1+"data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char t = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(t == 'u') {
				System.out.print("Manufacture date (dd/mm/yyyy): ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name,price,date));
			}else 
				if(t == 'i') {
					System.out.print("Customs fee: ");
					double fee = sc.nextDouble();
					list.add(new ImportedProduct(name,price,fee));
				}
				else {
					list.add(new Product(name,price));
				}
		}
		System.out.println("Price tags: ");
		for(Product pro: list) {
			System.out.println(pro.priceTag());
		}
		
		sc.close();
	}
}

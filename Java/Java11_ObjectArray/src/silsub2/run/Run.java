package silsub2.run;

import silsub2.model.vo.Product;

public class Run {

	public static void main(String[] args) {
		Product pd = new Product();
		
		pd.setPName("Galaxy Note10+");
		pd.setPrice(110);
		pd.setBrand("SAMSUNG");
		
		System.out.println(pd.information());

	}
}
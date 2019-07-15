package myPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    } 
    
    public String getName() {
    	return name;
    }
    
    public int getId() {
    	return id;
    }
    
    @Override
    public String toString() {
    	return "id="+id+"name="+name+"price="+price;
    }
}  
public class JavaStreams {  

	public static void main(String[] args) {  
        List<Product> productsList = new ArrayList<Product>();  
        
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));  
        List<Float> productPriceList = new ArrayList<Float>();
        
        //java 7
        for(Product product: productsList){               
            // filtering data of list  
            if(product.price<30000){  
                productPriceList.add(product.price);    // adding price to a productPriceList  
            }  
        }  
        System.out.println(productPriceList);   // displaying data  
        
        //java 8
        List productsNewList = productsList.stream().filter(n -> n.price <30000f)
        											.limit(1)  
        											.map(n -> n.name)
        					 						.collect(Collectors.toList())        					 						;
        System.out.println(productsNewList);
        
        //direct display
        productsList.stream().filter(n -> n.price <30000f)
        					 .limit(2)
							 .map(Product::getId)
							 .forEach(System.out::println);
        
        //operations
        System.out.println(productsList.stream().map(Product::getId).reduce(Integer::sum));
        
        //max and min
        System.out.println(productsList.stream().max((p1,p2)-> p1.id>p2.id?1:-1).get());
        
    }  
}  
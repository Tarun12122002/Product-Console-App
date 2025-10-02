package simple1;
import java.util.*;
public class admin {
	
	int pid;
	String name;
	int price;
	int stock;
	protected static ArrayList<admin> arrl=new ArrayList<admin>();
	admin(int pid, String name, int price, int stock)
	{
		this.pid=pid;
		this.name=name;
		this.price=price;
		this.stock=stock;
	}
	@Override
	public String toString() {
		return "PID: "+pid+" "+"Name:"+name+" "+"Price: "+price+" "+"Stock: "+stock;
	}
	public static void add()
	{
		Scanner in=new Scanner(System.in);
		
		System.out.println(" Enter no of products you want to add");
		int n=in.nextInt();
		for(int i=0; i<n;i++)
		{
			System.out.println("Enter PID");
			int p=in.nextInt();
			in.nextLine();
			System.out.println("Enter Name");
			String name=in.nextLine();
			String na;
			if(name==null || name.trim().isEmpty())
			{
				throw new IllegalArgumentException(" Name Cannot be empty");
			}
			if(!name.matches("[A-Z a-z]+"))
			{
				throw new IllegalArgumentException(" Name must contain only Letters and Space");
			}
			else {
				na=name;
			}
			System.out.println("Enter Price");
			int pr=in.nextInt();
			System.out.println("Enter stock");
			int s=in.nextInt();
			admin pro=new admin(p,na,pr,s);
			arrl.add(pro);
		}
		System.out.println(" Product details added successfully! ");
		
	}
	public static void view()
	{
		for(admin pro:arrl)
		{
			System.out.println(pro+" ");
		}
	}
	public static void update()
	{
		if (arrl.isEmpty())
		{
			System.out.println("No products to update.");
			return;
		}
		Scanner in2=new Scanner(System.in);
		for(int i=0; i<arrl.size();i++)
		{
			System.out.println((i+1)+":"+arrl.get(i));
		}
		System.out.println(" Enter the number of product to update ( 1 to"+arrl.size()+"):");
		int idx=in2.nextInt()-1;
		if(idx<0||idx>=arrl.size())
		{
			System.out.println("Invalid index");
			return;
		}
		System.out.println("What do you want to update?");
	    System.out.println(" 1. Add Products\\r\\n\"\r\n"
	    		+ "            		+ \"2.View Product\\r\\n\"\r\n"
	    		+ "            		+ \"3. Update product\\\"\\r\\n\"\r\n"
	    		+ "            		+\"4. Remove product\\r\\n\"\r\n"
	    		+ "            		+ \"5. Back");
	    int field = in2.nextInt();
	    in2.nextLine(); // consume the remaining newline

	    admin product = arrl.get(idx);

	    switch (field) {
	        case 1:
	            System.out.print("Enter new PID: ");
	            product.pid = in2.nextInt();
	            break;
	        case 2:
	            System.out.print("Enter new Name: ");
	            product.name = in2.nextLine();
	            break;
	        case 3:
	            System.out.print("Enter new Price: ");
	            product.price = in2.nextInt();
	            break;
	        case 4:
	            System.out.print("Enter new Stock: ");
	            product.stock = in2.nextInt();
	            break;
	        default:
	            System.out.println("Invalid choice!");
	            return;
	    }
	    System.out.println("Product details updated successfully!");
	
	}
	public static void delete()
	{
		if (arrl.isEmpty())
		{
			System.out.println("No products to remove.");
			return;
		}
		System.out.println("There are "+arrl.size()+" Products");
		System.out.println(" Which product do you need to update ?");
		
		for(int i=0;i<arrl.size();i++)
		{
			System.out.println("Product: "+i+1+ arrl.get(i));
		}
		
		System.out.println(" Which product you need to remove ?"+" Write numbers based on index values. 0 for 1st product, 1 for 2nd product and so on");
		Scanner d=new Scanner(System.in);
		int uin=d.nextInt();
		arrl.remove(uin);
		System.out.println(arrl);
		System.out.println(" Product removed successfully! ");
		System.out.println(" Add any product in future if needed ");
		
	}
	public static void adminMenu() 
	{
		System.out.println(" Admin Menu ");
		while(true)
		{
			
			System.out.println(" Enter any number between 1 to 5");
			System.out.println("1. Add Products\r\n"
            		+ "2. View Products\r\n"
            		+ "3. Update Product details\"\r\n"
            		+"4. Deete product details\r\n"
            		+ "5. Back");
			Scanner in1=new Scanner(System.in);
			int no=in1.nextInt();
			switch(no)
			{
			case 1:
				add();
				break;
			case 2:
				view();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:	
				return;
			}
			
				

		}
		
		
	}


}

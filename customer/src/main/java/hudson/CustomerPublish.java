package hudson;

public class CustomerPublish {

	public String sayHello(String name) {
       return "Hello " + name;
   }

   public static void main(String[] args) {
       CustomerPublish instance = new CustomerPublish();
     
       if (args.length == 1) {
           System.out.println(instance.sayHello(args[0]));
       } else {
           System.out.println(instance.sayHello("customer"));
       }
   }
}
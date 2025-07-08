@FunctionalInterface
 public interface MyInterface {

    String sayHello();

    default void sayBye(){
        System.out.println("This is default method in interface");
    }

    static void gmorning(){
        System.out.println("It's static method");

    }
}

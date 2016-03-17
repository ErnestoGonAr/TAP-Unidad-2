public class UsaSimpleInterface{

  public static void main(String[] args) {
    SimpleInterface obj = () -> System.out.println("Hola Lambda");
    obj.hasAlgo();
  }

}

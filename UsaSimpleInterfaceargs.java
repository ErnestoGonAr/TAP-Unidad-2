public class UsaSimpleInterfaceargs {
  public static void main(String[] args) {
    SimpleInterfaceargs obj = (v1,v2) -> {
      int result = v1*v2;
      System.out.println("El resultado es "+result);
    };
    SimpleInterfaceargs obj1  = (x,y) ->{
      int area = x*y;
      int perimetro = 2*x + 2*y;
      System.out.println("El area es: "+area);
      System.out.println("El perimetro es: "+perimetro);
    };

    obj.hasAlgo(10,10);
    obj.hasAlgo(60,80);
    obj1.calcula(5,5);
  }
}

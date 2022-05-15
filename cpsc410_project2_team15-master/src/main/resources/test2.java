public class test2 implements test4{

    public static void main(String[] args) {
        ClassB b = new ClassB();
        b.print();
    }
}

class ClassB {
  public void print(){
      ClassA a = new ClassA();
      a.printA();
      System.out.println("I am Class B!");
  }
}

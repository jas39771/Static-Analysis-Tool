public class test {
    public static void main(String[] args) {
        ClassA a = new ClassA();
        a.printA();
    }
}

class ClassA {
    private static int globalVar;
    private static String stringVar = "ThisIsString";
  public void printA(){
      globalVar = 5;
      String tempString = "testString";
      tempString = "changedString";
      System.out.println("I am Class A!");
  }
}

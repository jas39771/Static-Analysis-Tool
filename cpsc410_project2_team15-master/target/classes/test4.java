public interface test4 {

    public static void main(String[] args) {
        ClassB b = new ClassB();
        b.print();
    }
}

class ClassD {
  public void print(){
    System.out.println("I am Class B!");
  }
}

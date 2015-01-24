public class Main {
    public static void main(String[] args) {
        
        // primeiro uma instância de uma classe base concreta
        BaseClass myObj = new ConcreteBase1();
        // agora decoramos
        myObj = new ConcreteDecorator1(myObj);
        myObj = new ConcreteDecorator2(myObj);
        myObj = new ConcreteDecorator1(myObj); // adicionamos duas vezes!
        
        // chamamos o método getDescription()
        System.out.println(myObj.getDescription());
        
    }
}

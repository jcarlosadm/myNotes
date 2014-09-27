public abstract class Duck {
    
    /** instância de algum comportamento de voar */
    FlyBehavior flyBehavior;
    /** instância de algum comportamento de grasnar */
    QuackBehavior quackBehavior;
    
    /** métodos delegados para as classes de comportamento */
    public void performFly() {
        flyBehavior.fly();
    }
    public void performQuack() {
        quackBehavior.quack();
    }
    
    // outros métodos que não mudam...
    // ...
    
}

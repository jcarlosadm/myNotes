public class MallardDuck extends Duck {
    
    // construtor
    public MallardDuck() {
        /** veja que atribuímos as implementações de 
            cada interface para as variáveis de instância
            herdadas */
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    
    // outros métodos ...
    // ...
    
}

public class ConcreteDecorator2 implements BaseDecorator{
    BaseClass baseClass;
    
    public ConcreteDecorator2(BaseClass baseClass){
        this.baseClass = baseClass;
    }
    
    public String getDescription(){
        return this.baseClass.getDescription() + ", concreteDec2";
    }
}

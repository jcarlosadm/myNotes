public class ConcreteDecorator1 implements BaseDecorator {
    BaseClass baseClass;
    
    public ConcreteDecorator1(BaseClass baseClass){
        this.baseClass = baseClass;
    }
    
    public String getDescription(){
        return this.baseClass.getDescription() + ", concreteDec";
    }
}

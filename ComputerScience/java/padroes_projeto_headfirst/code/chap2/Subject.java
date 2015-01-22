/**
 * Interface a ser aplicada na classe observável
 */
public interface Subject {

    /**
     * Registra observadores para receberem notificações
     */
    public void registerObserver(Observer o);
    
    /**
     * Remove observadores para que não mais recebam
     * notificações
     */
    public void removeObserver(Observer o);
    
    /**
     * Notifica os observadores da lista que alguma mudança
     * ocorreu
     */
    public void notifyObservers();
}

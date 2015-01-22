/**
 * Interface a ser aplicada na classe observadora
 */
public interface Observer {
    
    /**
     * Atualiza a classe observadora quando a classe
     * observável mudar
     */
    public void update(Object observable);
}

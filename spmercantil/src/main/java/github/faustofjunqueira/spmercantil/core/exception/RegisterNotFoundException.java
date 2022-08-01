package github.faustofjunqueira.spmercantil.core.exception;

/**
 * Exception para disparar quando não localizar a feira
 *
 * @author Fausto Junqueira
 * @since 01/08/2022
 */
public class RegisterNotFoundException extends Exception {

    /**
     * Emite a exceção com messagem padrão
     */
    public RegisterNotFoundException() {
        super("register not found");
    }

    /**
     * Emite a exceção com messagem customizada
     * @param message String mensagem customizada
     */
    public RegisterNotFoundException(String message) {
        super(message);
    }
}

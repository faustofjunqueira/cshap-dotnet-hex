package github.faustofjunqueira.spmercantil.core.exception;

/**
 * Exception para ser emitida quando o registro já esta cadastrado na base de dados
 *
 * @author Fausto Junqueira
 * @since 01/08/2022
 */
public class RegisterAlreadyExistsException extends Exception {

    /**
     * Emite a exceção com messagem padrão
     */
    public RegisterAlreadyExistsException() {
        super("register already exists");
    }

    /**
     * Emite a exceção com messagem customizada
     * @param message String mensagem customizada
     */
    public RegisterAlreadyExistsException(String message) {
        super(message);
    }

}

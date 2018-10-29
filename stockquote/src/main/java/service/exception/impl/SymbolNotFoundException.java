package service.exception.impl;

public class SymbolNotFoundException extends AccessDeniedException {

    public SymbolNotFoundException(String message) {
        super(message);
    }
}

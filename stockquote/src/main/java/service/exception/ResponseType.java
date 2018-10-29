package service.exception;

public enum ResponseType {

    PLAIN_TEXT("text/plain");

    private final String value;

    ResponseType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

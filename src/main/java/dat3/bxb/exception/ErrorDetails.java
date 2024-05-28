package dat3.bxb.exception;

import lombok.Getter;

@Getter
public class ErrorDetails {
    private final String message;
    private final String details;

    public ErrorDetails(String message, String details) {
        this.message = message;
        this.details = details;
    }
}

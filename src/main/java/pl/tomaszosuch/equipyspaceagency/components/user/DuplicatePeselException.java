package pl.tomaszosuch.equipyspaceagency.components.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Klient z takim nr pesel już istnieje")
public class DuplicatePeselException extends RuntimeException {
}

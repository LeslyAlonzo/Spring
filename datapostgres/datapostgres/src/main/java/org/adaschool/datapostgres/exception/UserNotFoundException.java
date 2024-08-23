package org.adaschool.datapostgres.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "usuario no encontrado")
public class UserNotFoundException extends RuntimeException{
}

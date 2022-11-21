package br.ufms.danilo.pacotesviagensapi.exceptions.handler;

import br.ufms.danilo.pacotesviagensapi.dto.ExceptionMessageDto;
import br.ufms.danilo.pacotesviagensapi.exceptions.BadRequestException;
import br.ufms.danilo.pacotesviagensapi.exceptions.InvalidDocumentException;
import br.ufms.danilo.pacotesviagensapi.exceptions.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PacoteExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(BadRequestException.class)
  public final ResponseEntity<ExceptionMessageDto> handlerBadResquestException(
    Exception e
  ) {
    ExceptionMessageDto errorMessage = new ExceptionMessageDto()
      .setMessage(e.getMessage())
      .setStatus(HttpStatus.BAD_REQUEST)
      .build();

    return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NotFoundException.class)
  public final ResponseEntity<ExceptionMessageDto> handlerNotFoundException(
    Exception e
  ) {
    ExceptionMessageDto errorMessage = new ExceptionMessageDto()
      .setMessage(e.getMessage())
      .setStatus(HttpStatus.NOT_FOUND)
      .build();

      return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(InvalidDocumentException.class)
  public final ResponseEntity<ExceptionMessageDto> handlerInvalidDocumentException(
    Exception e
  ) {
    ExceptionMessageDto errorMessage = new ExceptionMessageDto()
      .setMessage(e.getMessage())
      .setStatus(HttpStatus.CONFLICT)
      .build();

      return new ResponseEntity<>(errorMessage,HttpStatus.CONFLICT);
  }
}

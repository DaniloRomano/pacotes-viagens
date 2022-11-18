package br.ufms.danilo.pacotesviagensapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PacotesViagensApiApplicationTests {

  public static void main(String[] args) {
    try {
      SpringApplication.run(PacotesViagensApiApplicationTests.class, args);
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }
}

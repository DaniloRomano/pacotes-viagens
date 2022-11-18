package br.ufms.danilo.pacotesviagensapi.service;

import br.ufms.danilo.pacotesviagensapi.repository.DestinoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class DestinoServiceTest {

    @InjectMocks
    private DestinoService destinoService;

    @Mock
    private DestinoRepository destinoRepository;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllByFilterTest() {
        destinoService.findAllByFilter(Pageable.unpaged(), "");
        verify(destinoRepository, times(1)).findAll(any(Example.class), any(Pageable.class));
    }
}

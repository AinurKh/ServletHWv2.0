package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import project.dtos.PersonDTO;
import project.service.PersonService;
import project.servlet.PersonServlet;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServletTest {
    @Mock
    private PersonService personService;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher requestDispatcher;
    @InjectMocks
    private PersonServlet personServlet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDoGet() throws Exception{
        List<PersonDTO> list = new ArrayList<>();
        PersonDTO personDTO = new PersonDTO();

        personDTO.setName("Ainur");
        personDTO.setAge(22);
        list.add(personDTO);

        when(personService.getDTOList()).thenReturn(list);
        when(request.getRequestDispatcher("/WEB-INF/view/Person.jsp")).thenReturn(requestDispatcher);

        personServlet.doGet(request, response);
        verify(request).setAttribute("peopleDTOList",list);
        verify(requestDispatcher).forward(request,response);
    }

    @Test
    void testDoPost() throws Exception{
        when(request.getParameter("name")).thenReturn("Ainur");
        when(request.getParameter("age")).thenReturn("22");

        personServlet.doPost(request,response);

        verify(personService).saveDTO(any(PersonDTO.class));
        verify(response).sendRedirect(request.getContextPath() + "/people");
    }

    @Test
    void testDoPut() throws Exception{
        String json = "{\"name\":\"Ainur\",\"age\":22}";
        StringReader stringReader = new StringReader(json);
        BufferedReader reader = new BufferedReader(stringReader);

        when(request.getReader()).thenReturn(reader);
        when(request.getPathInfo()).thenReturn("/0");

        personServlet.doPut(request, response);

        verify(personService).updateDTO(any(PersonDTO.class), eq(0));
    }

    @Test
    void testDoDelete() throws Exception{
        when(request.getPathInfo()).thenReturn("/0");

        personServlet.doDelete(request,response);
        verify(personService).delete(0);
    }
}

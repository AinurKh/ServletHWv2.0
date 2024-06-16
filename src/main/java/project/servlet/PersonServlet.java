package project.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.dtos.PersonDTO;
import project.service.PersonService;
import project.springConfig.SpringConfig;


import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/people/*")
public class PersonServlet extends HttpServlet {
    private PersonService personService;

    public void init() {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        personService =  context.getBean(PersonService.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<PersonDTO> personDTOList = null;
        personDTOList = personService.getDTOList();

        req.setAttribute("peopleDTOList", personDTOList);
            req.getRequestDispatcher("/WEB-INF/view/Person.jsp").forward(req, resp);

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PersonDTO personDTO = new PersonDTO();
        personDTO.setName(req.getParameter("name"));
        personDTO.setAge(Integer.parseInt(req.getParameter("age")));

        personService.saveDTO(personDTO);
        resp.sendRedirect(req.getContextPath() + "/people");
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo();
        String[] pathParts = pathInfo.split("/");

        BufferedReader reader = req.getReader();
        StringBuilder jsonBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonBuilder.append(line);
        }
        String json = jsonBuilder.toString();

        // Преобразуем JSON в объект Java с помощью библиотеки Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        PersonDTO person = objectMapper.readValue(json, PersonDTO.class);

        personService.updateDTO(person, person.getId());
    }


    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo != null && pathInfo.length() > 1) {

            String[] pathParts = pathInfo.split("/");
            int personId = Integer.parseInt(pathParts[1]);

            personService.delete(personId);
        }
    }
}

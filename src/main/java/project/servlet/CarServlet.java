package project.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.dtos.CarDTO;
import project.service.CarService;
import project.service.PersonService;
import project.springConfig.SpringConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/cars/*")
public class CarServlet extends HttpServlet {
    private CarService carService;

    public void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        carService = context.getBean(CarService.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CarDTO> carDTOS = carService.getDTOList();
        req.setAttribute("carDTOS", carDTOS);

        System.out.println(carDTOS);

        req.getRequestDispatcher("/WEB-INF/view/Car.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarDTO carDTO = new CarDTO();

        // Получаем параметры из запроса и устанавливаем их в DTO
        String personIdStr = req.getParameter("personId");
        if (personIdStr != null && !personIdStr.isEmpty()) {
            carDTO.setPersonId(Long.parseLong(personIdStr));
        } else {
            throw new IllegalArgumentException("Person ID is missing or empty");
        }

        carDTO.setModel(req.getParameter("model"));
        carDTO.setHorsePower(Integer.parseInt(req.getParameter("horsePower")));

        carService.saveDTO(carDTO);
        resp.sendRedirect(req.getContextPath() + "/cars");
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
        CarDTO carDTO = objectMapper.readValue(json, CarDTO.class);
        carService.updateDTO(carDTO,carDTO.getId());
    }


    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo != null && pathInfo.length() > 1) {

            String[] pathParts = pathInfo.split("/");
            int carId = Integer.parseInt(pathParts[1]);

            carService.delete(carId);
        }
    }
}

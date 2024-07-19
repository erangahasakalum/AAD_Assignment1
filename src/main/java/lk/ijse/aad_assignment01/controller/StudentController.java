package lk.ijse.aad_assignment01.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.aad_assignment01.dto.StudentDto;

import java.io.IOException;

@WebServlet(name = "/student")
public class StudentController extends HttpServlet {
    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Serializable
        StudentDto personDTO = new StudentDto("Eranga","23","erangahasakalum6761@gmail.com","0766553787");
        Jsonb jsonb = JsonbBuilder.create();
        String person = jsonb.toJson(personDTO);
        response.getWriter().write(person.toString());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        if (!request.getContentType().toLowerCase().startsWith("application/json") || request.getContentType() == null){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        //deserializable
        Jsonb jsonb = JsonbBuilder.create();
        StudentDto studentDto = jsonb.fromJson(request.getReader(), StudentDto.class);
        System.out.println(studentDto);
    }
}


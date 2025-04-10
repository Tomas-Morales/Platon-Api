package co.edu.poli.ces3.platonapi.servlet;

import co.edu.poli.ces3.platonapi.dao.CursoDAO;
import co.edu.poli.ces3.platonapi.model.Curso;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CursoServlet", urlPatterns = {"/cursos", "/cursos/facultad"})
public class CursoServlet extends HttpServlet {

    private final Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        BufferedReader reader = request.getReader();
        Curso curso = gson.fromJson(reader, Curso.class);

        boolean agregado = CursoDAO.agregarCurso(curso);

        if (agregado) {
            response.setStatus(HttpServletResponse.SC_CREATED);
            out.print("{\"mensaje\":\"Curso creado correctamente\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"error\":\"Id o código duplicado\"}");
        }
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        String uri = request.getRequestURI();
        String facultad = request.getParameter("nombre");

        List<Curso> resultado;

        if (uri.contains("/facultad") && facultad != null) {
            resultado = CursoDAO.buscarPorFacultad(facultad);
        } else {
            resultado = CursoDAO.listarCursos();
        }

        String json = gson.toJson(resultado);
        out.print(json);
        out.flush();
    }
}

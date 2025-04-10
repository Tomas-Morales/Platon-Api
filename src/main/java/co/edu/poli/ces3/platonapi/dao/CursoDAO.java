package co.edu.poli.ces3.platonapi.dao;

import co.edu.poli.ces3.platonapi.model.Curso;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CursoDAO {

    private static final List<Curso> cursos = new ArrayList<>();
    public static boolean agregarCurso(Curso curso) {
        boolean existeCodigo = cursos.stream()
                .anyMatch(c -> c.getCodigo().equalsIgnoreCase(curso.getCodigo()));
        if (existeCodigo || curso.getCupoMaximo() <= 0) {
            return false;
        }

        cursos.add(curso);

        return true;
    }

    public static List<Curso> listarCursos() {
        return cursos;
    }

    public static List<Curso> buscarPorFacultad(String facultad) {
        return cursos.stream()
                .filter(c -> c.getFacultad().equalsIgnoreCase(facultad))
                .collect(Collectors.toList());
    }
}


package co.edu.poli.ces3.platonapi.model;

public class Curso {
    private int id;
    private String nombre;
    private String codigo;
    private String profesor;
    private int cupoMaximo;
    private int estudiantesInscritos;
    private String facultad;

    public Curso() {
    }

    public Curso(int id, String nombre, String codigo, String profesor,
                 int cupoMaximo, int estudiantesInscritos, String facultad) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.profesor = profesor;
        this.cupoMaximo = cupoMaximo;
        this.estudiantesInscritos = estudiantesInscritos;
        this.facultad = facultad;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProfesor() {
        return profesor;
    }
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }
    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public int getEstudiantesInscritos() {
        return estudiantesInscritos;
    }
    public void setEstudiantesInscritos(int estudiantesInscritos) {
        this.estudiantesInscritos = estudiantesInscritos;
    }

    public String getFacultad() {
        return facultad;
    }
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
}


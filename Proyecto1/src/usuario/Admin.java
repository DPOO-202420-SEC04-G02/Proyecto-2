package usuario;

import java.util.List;

import logica.LearningPath;

public class Admin extends Usuario {
	private List<LearningPath> cursosCreados;
	

	public Admin(String correo, String contrasena, String rol) {
		super("Admin123", "Admin", "Admin");
	}
    public void crearLearningPath(LearningPath curso) {
        cursosCreados.add(curso);
        System.out.println("Learning Path creado: " + curso.getTitulo() + " por el profesor " + getNombre());
    }

    // Método para editar un Learning Path existente
    public void editarLearningPath(int index, String nuevoTitulo, String nuevaDescripcion) {
        if (index >= 0 && index < cursosCreados.size()) {
            LearningPath curso = cursosCreados.get(index);
            curso.setTitulo(nuevoTitulo);
            curso.setDescripcion(nuevaDescripcion);
            System.out.println("Learning Path actualizado: " + curso.getTitulo() + " por el profesor " + getNombre());
        } else {
            System.out.println("Error: Índice fuera de rango en la lista de cursos creados.");
        }
    }

    // Método para eliminar un Learning Path de la lista de cursos creados
    public void eliminarLearningPath(int index) {
        if (index >= 0 && index < cursosCreados.size()) {
            LearningPath curso = cursosCreados.remove(index);
            System.out.println("Learning Path eliminado: " + curso.getTitulo() + " por el profesor " + getNombre());
        } else {
            System.out.println("Error: Índice fuera de rango en la lista de cursos creados.");
        }
    }

    // Método para obtener la lista de cursos creados
    public List<LearningPath> obtenerCursosCreados() {
        return cursosCreados;
    }
}

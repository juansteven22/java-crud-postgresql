import com.tuempresa.dao.UsuarioDAO;
import com.tuempresa.modelo.Usuario;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Crear un usuario
        Usuario nuevoUsuario = new Usuario(0, "Juan Pérez", "juan@example.com");
        usuarioDAO.crearUsuario(nuevoUsuario);
        System.out.println("Usuario creado");

        // Leer un usuario
        Usuario usuarioLeido = usuarioDAO.leerUsuario(1);
        if (usuarioLeido != null) {
            System.out.println("Usuario leído: " + usuarioLeido.getNombre());
        }

        // Actualizar un usuario
        if (usuarioLeido != null) {
            usuarioLeido.setEmail("juan.perez@example.com");
            usuarioDAO.actualizarUsuario(usuarioLeido);
            System.out.println("Usuario actualizado");
        }

        // Listar usuarios
        System.out.println("Lista de usuarios:");
        for (Usuario u : usuarioDAO.listarUsuarios()) {
            System.out.println(u.getId() + ": " + u.getNombre() + " (" + u.getEmail() + ")");
        }

        // Eliminar un usuario
        usuarioDAO.eliminarUsuario(1);
        System.out.println("Usuario eliminado");
    }
}
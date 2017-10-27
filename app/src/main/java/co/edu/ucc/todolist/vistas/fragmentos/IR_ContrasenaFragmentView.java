package co.edu.ucc.todolist.vistas.fragmentos;

/**
 * Created by Jailer on 24/10/2017.
 */

public interface IR_ContrasenaFragmentView {

    void mostrarProgress();
    void ocultarProgress();
    void mostrarError(String mensaje);
    void irALogin();
    void finalizarRecuperarPassword();
}

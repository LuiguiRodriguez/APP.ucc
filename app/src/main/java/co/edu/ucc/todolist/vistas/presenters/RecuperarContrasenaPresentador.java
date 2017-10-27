package co.edu.ucc.todolist.vistas.presenters;

import co.edu.ucc.todolist.dominio.CallBackInteractor;
import co.edu.ucc.todolist.dominio.ILUsuario;
import co.edu.ucc.todolist.dominio.LUsuario;
import co.edu.ucc.todolist.vistas.fragmentos.IR_ContrasenaFragmentView;

/**
 * Created by Jailer on 24/10/2017.
 */

public class RecuperarContrasenaPresentador implements IRecuperarContrasenaPresentador {

    private IR_ContrasenaFragmentView view;
    private ILUsuario lUsuario;

     public RecuperarContrasenaPresentador(IR_ContrasenaFragmentView view) {
        this.view = view;
        lUsuario = new LUsuario();
    }

    @Override
    public void recuperarContrasena(String email) {
     view.mostrarProgress();

        try {
        lUsuario.recuperarPassword(email,new CallBackInteractor<Boolean>() {
        @Override
        public void success(Boolean data) {

            view.ocultarProgress();
            view.finalizarRecuperarPassword();

        }

        @Override
        public void error(String error) {

        view.mostrarError(error);
            view.ocultarProgress();

        }
    });
        } catch (Exception e) {
            view.ocultarProgress();
            view.mostrarError(e.getMessage());

        }
    }
}

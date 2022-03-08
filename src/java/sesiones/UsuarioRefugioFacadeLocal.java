/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones;

import entidades.UsuarioRefugio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rockerzega
 */
@Local
public interface UsuarioRefugioFacadeLocal {

    void create(UsuarioRefugio usuarioRefugio);

    void edit(UsuarioRefugio usuarioRefugio);

    void remove(UsuarioRefugio usuarioRefugio);

    UsuarioRefugio find(Object id);

    List<UsuarioRefugio> findAll();

    List<UsuarioRefugio> findRange(int[] range);

    int count();
    
}

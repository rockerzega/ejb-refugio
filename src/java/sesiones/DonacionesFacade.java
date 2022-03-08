/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones;

import entidades.Donaciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rockerzega
 */
@Stateless
public class DonacionesFacade extends AbstractFacade<Donaciones> implements DonacionesFacadeLocal {

    @PersistenceContext(unitName = "ejb-refugioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DonacionesFacade() {
        super(Donaciones.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones;

import entidades.AdmBeneficio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rockerzega
 */
@Stateless
public class AdmBeneficioFacade extends AbstractFacade<AdmBeneficio> implements AdmBeneficioFacadeLocal {

    @PersistenceContext(unitName = "ejb-refugioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdmBeneficioFacade() {
        super(AdmBeneficio.class);
    }
    
}
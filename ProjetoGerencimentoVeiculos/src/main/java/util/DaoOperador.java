/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import modelo.Operador;

/**
 *
 * @author prog2
 */
public class DaoOperador {

    public boolean autenticar(Operador operador) {
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Operador> query
                = manager.createNamedQuery("Operador.autenticar", Operador.class);
        query.setParameter("login", operador.getLogin());
        query.setParameter("senha", operador.getSenha());
        try {
            if (query.getSingleResult() != null) {
                return true;
            } else {
                return false;
            }
        } catch (NoResultException e) {
            return false;
        }
    }
}

package frm.utn;

import frm.utn.entidades.Domicilio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import frm.utn.entidades.Cliente;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            /* EntityManager -> Contexto de Persistencia */
            entityManager.getTransaction().begin();
            /*
            Domicilio domicilio = Domicilio.builder()
                    .nombreCalle("Calle Falsa")
                    .numero(123)
                    .build();
            Cliente persona = Cliente.builder()
                    .nombre("Pedro")
                    .apellido("Perez")
                    .dni(12345678)
                    .domicilio(domicilio)
                    .build();
            domicilio.setCliente(persona);
            entityManager.persist(persona);
            */
            Cliente persona = entityManager.find(Cliente.class, 1L);
            Domicilio domicilio = entityManager.find(Domicilio.class, persona.getDomicilio().getId());
            entityManager.getTransaction().commit();

            System.out.printf("Persona: %s\n", persona);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.printf("Error al guardar: %s\n", e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
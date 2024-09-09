package frm.utn;

import frm.utn.entidades.Domicilio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import frm.utn.entidades.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            /* EntityManager -> Inicio Contexto de Persistencia */
            entityManager.getTransaction().begin();

            /* Domicilio */
            Domicilio dom1 = Domicilio.builder()
                    .nombreCalle("Calle Falsa")
                    .numero(123)
                    .build();
            Domicilio dom2 = Domicilio.builder()
                    .nombreCalle("Calle Real")
                    .numero(456)
                    .build();
            Domicilio dom3 = Domicilio.builder()
                    .nombreCalle("Otra Calle Falsa")
                    .numero(789)
                    .build();

            /* Cliente */
            Cliente cli1 = Cliente.builder()
                    .nombre("Homero")
                    .apellido("Simpson")
                    .dni(12345678)
                    .domicilio(dom1)
                    .build();
            Cliente cli2 = Cliente.builder()
                    .nombre("Marge")
                    .apellido("Simpson")
                    .dni(87654321)
                    .domicilio(dom2)
                    .build();
            Cliente cli3 = Cliente.builder()
                    .nombre("Bart")
                    .apellido("Simpson")
                    .dni(12348765)
                    .domicilio(dom3)
                    .build();

            /* Categoria */
            Categoria cat1 = Categoria.builder()
                    .denominacion("Electrodomesticos")
                    .build();
            Categoria cat2 = Categoria.builder()
                    .denominacion("Alimentos")
                    .build();

            /* Articulo */
            Articulo art1 = Articulo.builder()
                    .cantidad(10)
                    .denominacion("Televisor")
                    .precio(1000)
                    .build();
            Articulo art2 = Articulo.builder()
                    .cantidad(20)
                    .denominacion("Heladera")
                    .precio(2000)
                    .build();
            Articulo art3 = Articulo.builder()
                    .cantidad(30)
                    .denominacion("Cocina")
                    .precio(3000)
                    .build();
            Articulo art4 = Articulo.builder()
                    .cantidad(40)
                    .denominacion("Lavarropas")
                    .precio(4000)
                    .build();
            Articulo art5 = Articulo.builder()
                    .cantidad(50)
                    .denominacion("Cafetera")
                    .precio(5000)
                    .build();
            Articulo art6 = Articulo.builder()
                    .cantidad(60)
                    .denominacion("Cafe")
                    .precio(6000)
                    .build();
            Articulo art7 = Articulo.builder()
                    .cantidad(70)
                    .denominacion("Leche")
                    .precio(7000)
                    .build();
            Articulo art8 = Articulo.builder()
                    .cantidad(80)
                    .denominacion("Pan")
                    .precio(8000)
                    .build();
            Articulo art9 = Articulo.builder()
                    .cantidad(90)
                    .denominacion("Azucar")
                    .precio(9000)
                    .build();
            /* Relacion Articulo - Categoria */
            art1.getCategorias().add(cat1);
            art2.getCategorias().add(cat1);
            art3.getCategorias().add(cat1);
            art4.getCategorias().add(cat1);
            art5.getCategorias().add(cat1);
            art6.getCategorias().add(cat2);
            art7.getCategorias().add(cat2);
            art8.getCategorias().add(cat2);
            art9.getCategorias().add(cat2);

            cat1.getArticulos().add(art1);
            cat1.getArticulos().add(art2);
            cat1.getArticulos().add(art3);
            cat1.getArticulos().add(art4);
            cat1.getArticulos().add(art5);
            cat2.getArticulos().add(art6);
            cat2.getArticulos().add(art7);
            cat2.getArticulos().add(art8);
            cat2.getArticulos().add(art9);

            /* Detalle - Factura 1 */
            DetalleFactura det1 = DetalleFactura.builder()
                    .cantidad(1)
                    .subtotal(1000)
                    .articulo(art1)
                    .build();
            DetalleFactura det2 = DetalleFactura.builder()
                    .cantidad(2)
                    .subtotal(4000)
                    .articulo(art2)
                    .build();
            DetalleFactura det3 = DetalleFactura.builder()
                    .cantidad(3)
                    .subtotal(9000)
                    .articulo(art3)
                    .build();
            art1.getDetalleFacturas().add(det1);
            art2.getDetalleFacturas().add(det2);
            art3.getDetalleFacturas().add(det3);

            Factura fac1 = Factura.builder()
                    .numero(1)
                    .total(14000)
                    .fecha("25/12/2024")
                    .cliente(cli1)
                    .build();
            fac1.getDetalleFacturas().add(det1);
            fac1.getDetalleFacturas().add(det2);
            fac1.getDetalleFacturas().add(det3);

            det1.setFactura(fac1);
            det2.setFactura(fac1);
            det3.setFactura(fac1);

            /* Detalle - Factura 2 */
            DetalleFactura det4 = DetalleFactura.builder()
                    .cantidad(4)
                    .subtotal(16000)
                    .articulo(art4)
                    .build();
            DetalleFactura det5 = DetalleFactura.builder()
                    .cantidad(5)
                    .subtotal(25000)
                    .articulo(art5)
                    .build();
            DetalleFactura det6 = DetalleFactura.builder()
                    .cantidad(6)
                    .subtotal(36000)
                    .articulo(art6)
                    .build();
            art4.getDetalleFacturas().add(det4);
            art5.getDetalleFacturas().add(det5);
            art6.getDetalleFacturas().add(det6);

            Factura fac2 = Factura.builder()
                    .numero(2)
                    .total(77000)
                    .fecha("09/09/2024")
                    .cliente(cli2)
                    .build();
            fac2.getDetalleFacturas().add(det4);
            fac2.getDetalleFacturas().add(det5);
            fac2.getDetalleFacturas().add(det6);

            det4.setFactura(fac2);
            det5.setFactura(fac2);
            det6.setFactura(fac2);

            /* Detalle - Factura 3 */
            DetalleFactura det7 = DetalleFactura.builder()
                    .cantidad(7)
                    .subtotal(49000)
                    .articulo(art7)
                    .build();
            DetalleFactura det8 = DetalleFactura.builder()
                    .cantidad(8)
                    .subtotal(64000)
                    .articulo(art8)
                    .build();
            DetalleFactura det9 = DetalleFactura.builder()
                    .cantidad(9)
                    .subtotal(81000)
                    .articulo(art9)
                    .build();
            art7.getDetalleFacturas().add(det7);
            art8.getDetalleFacturas().add(det8);
            art9.getDetalleFacturas().add(det9);

            Factura fac3 = Factura.builder()
                    .numero(3)
                    .total(194000)
                    .fecha("01/01/2024")
                    .cliente(cli3)
                    .build();
            fac3.getDetalleFacturas().add(det7);
            fac3.getDetalleFacturas().add(det8);
            fac3.getDetalleFacturas().add(det9);

            det7.setFactura(fac3);
            det8.setFactura(fac3);
            det9.setFactura(fac3);

            /* Cliente - Factura */
            cli1.getFacturas().add(fac1);
            cli2.getFacturas().add(fac2);
            cli3.getFacturas().add(fac3);

            /* Persistencia */
            entityManager.persist(fac1);
            entityManager.persist(fac2);
            entityManager.persist(fac3);

            /* EntityManager -> Fin Contexto de Persistencia */
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
package frm.utn.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int cantidad;
    @Column
    private String denominacion;
    @Column
    private int precio;

    @OneToMany(mappedBy = "articulo")
    @Builder.Default
    private List<DetalleFactura> detalleFacturas = new ArrayList<DetalleFactura>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Builder.Default
    @JoinTable(name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "fk_articulo"),
            inverseJoinColumns = @JoinColumn(name = "fk_categoria"))
    private List<Categoria> categorias = new ArrayList<Categoria>();
}

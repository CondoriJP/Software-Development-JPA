package frm.utn.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
import org.hibernate.envers.Audited;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "factura")
@Audited
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int numero;
    @Column
    private int total;
    @Column
    private String fecha;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    /* Relación OneToMany con DetalleFactura bidireccional */
    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<DetalleFactura> detalleFacturas = new ArrayList<DetalleFactura>();
}

/*
Relación OneToMany con DetalleFactura unidiereccional
@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
@Builder.Default
private List<DetalleFactura> detalleFacturas = new ArrayList<DetalleFactura>();
 */

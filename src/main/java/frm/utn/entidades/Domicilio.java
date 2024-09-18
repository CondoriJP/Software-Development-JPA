package frm.utn.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;
import org.hibernate.envers.Audited;

@Getter
@Setter
@ToString(exclude = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "domicilio ")
@Audited
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_calle")
    private String nombreCalle;
    @Column
    private int numero;

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;
}

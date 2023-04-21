package pawtropolis.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "bag")
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class BagVO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private int maxSlots;

    private int availableSlots;

    @ManyToMany(mappedBy = "bags")
    private Set<ItemVO> items;
}
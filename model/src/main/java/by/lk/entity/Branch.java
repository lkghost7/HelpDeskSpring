package by.lk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "branches")
@ToString
@NoArgsConstructor
public class Branch extends BaseEntity {
    @Setter
    @Getter
    @Column(name = "name")
    private String name;

    public static Branch newInstanceAllArgs(Long id, String name) {
        Branch branch = new Branch();
        branch.setId(id);
        branch.setName(name);
        return branch;
    }
}
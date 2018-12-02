package by.lk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "privileges")
@ToString
@NoArgsConstructor
public class Privilege extends BaseEntity {
    @Setter
    @Getter
    @Column(name = "name")
    private String namePrivilege;
}
package by.lk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "listeners")
@ToString
@NoArgsConstructor
public class Listener extends BaseEntity {
    @Setter
    @Getter
    @Column(name = "name")
    private String name;

    public static Listener newInstanceAllArgs(Long id, String name) {
        Listener listener = new Listener();
        listener.setId(id);
        listener.setName(name);
        return listener;
    }
}

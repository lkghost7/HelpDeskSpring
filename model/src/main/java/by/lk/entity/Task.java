package by.lk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
@ToString
@NoArgsConstructor
@Setter
@Getter
public class Task extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name = "system_user_id")
    private SystemUser systemUser;
    @ManyToOne
    @JoinColumn(name = "operator_id")
    private SystemUser operator;
    @ManyToOne
    @JoinColumn(name = "executor_id")
    private SystemUser executor;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
}
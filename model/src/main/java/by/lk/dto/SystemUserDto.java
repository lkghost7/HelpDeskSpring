package by.lk.dto;

import by.lk.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class SystemUserDto extends BaseEntity {
    private String nameUser;
    private String familyUser;
    private String email;
    private String passwordUser;
    private Long privilegeId;
    private Long branchId;
    private String branchName;
    private Long subdivisionId;
    private String subdivisionName;
}

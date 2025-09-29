package com.du.validation.dto;


import com.du.validation.entity.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequest {

    @NotBlank(message = "이름은 반드시 입력해야 합니다.")
    private String name;

    @NotBlank(message = "이메일은 반드시 입력해야 합니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    @Size(min = 6, max=20, message = "비밀번호는 6자 이상 20자 이하로 입력해야 합니다.")
    private String password;


    // DTO -> Entity 변환 메서드
    public UserEntity toEntity(){
        return UserEntity.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }

    public UserEntity toEntity(String hashedPassword){
        return UserEntity.builder()
                .name(name)
                .email(email)
                .password(hashedPassword)
                .build();
    }

}

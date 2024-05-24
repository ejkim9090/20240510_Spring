package kh.mclass.demo6;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class JoinDto {
	@NotBlank(message = "상품명은 필수 입력 값입니다.")
	private String username;
	
	@Min(value=5, message = "bbbbb")
	@Max(value=20)
	private String pwd;
	
	private String email;
	private String addr;
	private String creditNo;
}

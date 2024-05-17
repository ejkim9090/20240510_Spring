package kh.mclass.test1r.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class MemberRes {
	private String memId;
	private String memId2;
	private String memPwd;
	private String memEmail;
	
}

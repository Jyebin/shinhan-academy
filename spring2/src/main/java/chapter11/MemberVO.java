package chapter11;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonInclude(value=Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) //이 클래스를 스네이크 표기법으로 변환
public class MemberVO {
	private int no;
	private String id;
	private String name;
	private String email;
	@JsonProperty("nick_name") //json의 속성명을 nick_name으로 변경. 안쓰면 default로 nickName이 들어감
	private String nickName;
}
package member;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	private String id;
   private String pwd;
   private String name;
   private String email;
   private Date joinDate;
}

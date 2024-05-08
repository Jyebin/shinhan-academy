package sec04.ex03;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private String id;
   private String pwd;
   private String name;
   private String email;
   private Date joinDate;
       
}

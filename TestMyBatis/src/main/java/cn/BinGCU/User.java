package cn.BinGCU;



import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
public class User  implements Serializable {

    private  Integer userID;
    private String userName;
    private Date birthdate;

}

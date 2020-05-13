package cn.BinGCU;

import java.io.Serializable;
import java.util.Date;

public class User  implements Serializable {

    private  Integer user_id;
    private String user_name;
    private Date birthdate;

    public User() {
    }


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}

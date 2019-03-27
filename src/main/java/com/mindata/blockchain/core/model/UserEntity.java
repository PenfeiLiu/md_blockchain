package com.mindata.blockchain.core.model;


import com.mindata.blockchain.core.model.base.BaseEntity;


import javax.persistence.*;

@Entity
@Table(name="user")
public class UserEntity extends BaseEntity{

  private   String name;
  private    String password;
  private    Long id;



    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}

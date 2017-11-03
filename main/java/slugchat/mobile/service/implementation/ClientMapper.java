package main.java.slugchat.mobile.service.implementation;

import org.apache.ibatis.annotations.Select;

/**
 * Created by lorabit on 02/11/2017.
 */
public interface ClientMapper {
    @Select("select * from tbl_client where id=#{userId}")
    User
}

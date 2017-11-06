package main.java.slugchat.mobile.service.mapper;

import org.apache.ibatis.annotations.*;
import main.java.slugchat.mobile.service.domain.Client;

public interface ClientMapper {

    @Select("SELECT * FROM tbl_clients WHERE clientId = #{clientId}")
    Client getClient(@Param("clientId") Long clientId);

    @Insert("INSERT INTO tbl_clients(deviceToken, createTime) values(#{deviceToken},#{createTime})")
    @Options(useGeneratedKeys=true, keyProperty="clientId")
//    @SelectKey(keyProperty = "id",resultType = Integer.class, before = false, statement = "SELECT LAST_INSERT_ID();")
//    Client createClient(@Param("deviceToken") String deviceToken, @Param("platform") int platform);
    int createClient(Client client);

}

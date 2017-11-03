package main.java.slugchat.mobile.service.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import main.java.slugchat.mobile.service.domain.Client;

public interface ClientMapper {

    @Select("SELECT * FROM tbl_client WHERE id = #{clientId}")
    Client getClient(@Param("clientId") int clientId);

}

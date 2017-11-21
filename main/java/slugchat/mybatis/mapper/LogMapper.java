package main.java.slugchat.mybatis.mapper;

import main.java.slugchat.mybatis.domain.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface LogMapper {
    @Insert("INSERT INTO tbl_logs(logId, profileId, logType, content, createTime) values(#{logId},#{profileId},"
            +"#{logType},#{content},#{createTime})")
    @Options(useGeneratedKeys=true, keyProperty="logId")
    int createLog(Log log);
}

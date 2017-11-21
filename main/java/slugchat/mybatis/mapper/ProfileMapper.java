package main.java.slugchat.mybatis.mapper;

import main.java.slugchat.mybatis.domain.Profile;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProfileMapper {

    @Select("SELECT * FROM tbl_profiles WHERE clientId=#{clientId}")
    List<Profile> listProfilesUnderClient(@Param("clientId") Long clientId);

    @Insert("INSERT INTO tbl_profiles(clientId, name, avatar, createTime) values(#{clientId},#{name},#{avatar},#{createTime})")
    @Options(useGeneratedKeys=true, keyProperty="profileId")
    int createProfile(Profile profile);

}

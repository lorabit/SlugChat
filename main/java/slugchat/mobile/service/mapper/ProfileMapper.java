package main.java.slugchat.mobile.service.mapper;

import main.java.slugchat.mobile.service.domain.Profile;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProfileMapper {

    @Select("SELECT * FROM tbl_profiles WHERE clientId=#{clientId}")
    List<Profile> listProfilesUnderClient(@Param("clientId") int clientId);

    @Insert("INSERT INTO tbl_profiles(clientId, name, avatar, createTime) values(#{clientId},#{name},#{avatar},#{createTime})")
    @Options(useGeneratedKeys=true, keyProperty="profileId")
    int createProfile(Profile profile);

}

package main.java.slugchat.mobile.service.implementation;

import com.google.inject.Inject;
import com.kidschat.service.mobile.ListProfilesRequest;
import com.kidschat.service.mobile.ListProfilesResponse;
import main.java.slugchat.mybatis.domain.Profile;
import main.java.slugchat.mybatis.impl.MobileService;

public class ListProfilesUnderClient {

    @Inject
    private MobileService mobileService;

    public ListProfilesResponse listProfilesUnderClient(ListProfilesRequest request){
        ListProfilesResponse.Builder builder = ListProfilesResponse.newBuilder();
        for (Profile profile:mobileService.listProfileUnderClient(request.getClientId())) {
             builder.addProfiles(profile.toProto());
        }
        return builder.build();
    }
}

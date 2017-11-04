package main.java.slugchat.mobile.service.implementation;

import com.google.inject.Inject;
import com.kidschat.service.mobile.ListProfilesRequest;
import com.kidschat.service.mobile.ListProfilesResponse;
import main.java.slugchat.mobile.service.domain.Profile;

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

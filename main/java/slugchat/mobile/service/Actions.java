package main.java.slugchat.mobile.service;

import com.google.inject.Inject;
import com.kidschat.service.mobile.*;
import io.grpc.stub.StreamObserver;

/**
 * Created by lorabit on 02/11/2017.
 */
class Actions extends MobileGrpc.MobileImplBase {

    @Inject


    @Override
    public void createProfile(Profile profile, StreamObserver<Profile> streamObserver) {
        super.createProfile(profile, streamObserver);
    }

    @Override
    public void registerClient(RegisterClientRequest registerClientRequest, StreamObserver<RegisterClientResponse> streamObserver) {
        super.registerClient(registerClientRequest, streamObserver);
    }

    @Override
    public void listProfiles(ListProfilesRequest listProfilesRequest, StreamObserver<ListProfilesResponse> streamObserver) {
        super.listProfiles(listProfilesRequest, streamObserver);
    }
}

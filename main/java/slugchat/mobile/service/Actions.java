package main.java.slugchat.mobile.service;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.kidschat.service.mobile.*;
import io.grpc.stub.StreamObserver;
import main.java.slugchat.mobile.service.implementation.CreateProfile;
import main.java.slugchat.mobile.service.implementation.ListProfilesUnderClient;
import main.java.slugchat.mobile.service.implementation.RegisterClient;
import org.mybatis.guice.MyBatisModule;

import static com.google.inject.Guice.createInjector;

/**
 * Created by lorabit on 02/11/2017.
 */
class Actions extends MobileGrpc.MobileImplBase {

    Injector injector;

    @Inject
    RegisterClient registerClient;

    @Inject
    CreateProfile createProfile;

    @Inject
    ListProfilesUnderClient listProfilesUnderClient;

    Actions(){
        injector = createInjector(
                new SlugChatMyBatisModule()
        );
        injector.injectMembers(this);
    }

    @Override
    public void createProfile(Profile profile, StreamObserver<Profile> streamObserver) {
        streamObserver.onNext(createProfile.createProfile(profile));
        streamObserver.onCompleted();
    }

    @Override
    public void registerClient(RegisterClientRequest registerClientRequest, StreamObserver<RegisterClientResponse> streamObserver) {
        streamObserver.onNext(registerClient.registerClient(registerClientRequest));
        streamObserver.onCompleted();
    }

    @Override
    public void listProfiles(ListProfilesRequest listProfilesRequest, StreamObserver<ListProfilesResponse> streamObserver) {
        streamObserver.onNext(listProfilesUnderClient.listProfilesUnderClient(listProfilesRequest));
        streamObserver.onCompleted();
    }
}

package main.java.slugchat.mobile.service;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.kidschat.service.mobile.*;
import io.grpc.stub.StreamObserver;
import main.java.slugchat.mobile.service.implementation.*;
import org.apache.log4j.Logger;
import org.mybatis.guice.MyBatisModule;

import static com.google.inject.Guice.createInjector;

/**
 * Created by lorabit on 02/11/2017.
 */
class Actions extends MobileGrpc.MobileImplBase {



    static Logger logger = Logger.getLogger(Actions.class);

    Injector injector;

    @Inject
    RegisterClient registerClient;

    @Inject
    CreateProfile createProfile;

    @Inject
    ListProfilesUnderClient listProfilesUnderClient;

    @Inject
    GetChatbotResponse getChatbotResponse;

    @Inject
    CreateLog createLog;


    Actions(String dbUrl){
        injector = createInjector(
                new SlugChatMyBatisModule(dbUrl),
                new DialogflowModule()
        );
        injector.injectMembers(this);
    }

    @Override
    public void getChatbotResponse(UserRequest userRequest, StreamObserver<ChatbotResponse> streamObserver) {
        try{
            streamObserver.onNext(getChatbotResponse.getChatbotResponse(userRequest));
            streamObserver.onCompleted();
        }
        catch (Exception exception){
            logger.error(exception);
            streamObserver.onError(exception);
        }
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

    @Override
    public void createLog(Log request, StreamObserver<Log> responseObserver) {
        responseObserver.onNext(createLog.createLog(request));
        responseObserver.onCompleted();
    }
}

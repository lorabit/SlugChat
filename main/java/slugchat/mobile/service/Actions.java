package main.java.slugchat.mobile.service;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.kidschat.service.mobile.*;
import io.grpc.stub.StreamObserver;
import main.java.slugchat.mybatis.SlugChatMyBatisModule;
import main.java.slugchat.mobile.service.implementation.*;
import main.java.slugchat.mybatis.impl.MobileService;
import org.apache.log4j.Logger;

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
    CreateLog createLog;

    @Inject
    private MobileService mobileService;


    private String dialogflowApiKey;

    Actions(String dbUrl, String _dialogflowApiKey){
        injector = createInjector(
                new SlugChatMyBatisModule(dbUrl)
        );
        injector.injectMembers(this);
        dialogflowApiKey = _dialogflowApiKey;
    }

    @Override
    public void getChatbotResponse(UserRequest userRequest, StreamObserver<ChatbotResponse> streamObserver) {
        try{
            streamObserver.onNext(new GetChatbotResponse(mobileService, dialogflowApiKey).getChatbotResponse(userRequest));
            streamObserver.onCompleted();
        }
        catch (Exception exception){
            exception.printStackTrace();
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

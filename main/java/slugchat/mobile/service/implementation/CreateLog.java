package main.java.slugchat.mobile.service.implementation;

import com.google.inject.Inject;
import com.kidschat.service.mobile.Log;
import main.java.slugchat.mobile.service.implementation.models.MobileService;
import org.joda.time.Instant;

public class CreateLog {

    @Inject
    private MobileService mobileService;

    public Log createLog(Log log){
        main.java.slugchat.mobile.service.domain.Log logWithTimestamp =
                new main.java.slugchat.mobile.service.domain.Log(log);
        logWithTimestamp.setCreateTime(Instant.now().getMillis());
        return mobileService.createLog(logWithTimestamp).toProto();
    }
}

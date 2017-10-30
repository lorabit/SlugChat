package main.java.com.lorabit;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Created by lorabit on 2017/7/26.
 */
public class ServletConfig extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return null;
    }
}

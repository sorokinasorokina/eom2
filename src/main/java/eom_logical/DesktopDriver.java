package eom_logical;


import org.testng.annotations.BeforeMethod;

public interface DesktopDriver extends Capabilities{

    @BeforeMethod(alwaysRun = true)
    default void initDriver(){
        //String peremennayaOkruzheniya = System.getenv("grid_url"); // grid_url - переменная окружения из дженкинса
        //initRemoteCapabilities(peremennayaOkruzheniya, "internetBrowser");

        initRemoteCapabilities("123", "internetBrowser");
    };
}
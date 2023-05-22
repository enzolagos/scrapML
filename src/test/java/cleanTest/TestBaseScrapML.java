package cleanTest;

import pages.ElementPage;
import pages.HomePage;
import pages.Navbar;
import utils.GetProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import singletonSession.Session;

import java.util.ArrayList;
import java.util.List;

public class TestBaseScrapML {

    protected ElementPage elementPage = new ElementPage();
    protected HomePage homePage = new HomePage();
    protected Navbar navbar = new Navbar();

    List<String[]> data = new ArrayList<String[]>();
    @BeforeEach
    public void setup(){
        // todo create properties file
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }

}


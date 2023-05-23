package cleanTest;

import org.junit.jupiter.api.AfterAll;
import pages.CategoryPage;
import pages.ElementPage;
import pages.HomePage;
import pages.Navbar;
import utils.GetProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import singletonSession.Session;

import java.util.ArrayList;
import java.util.List;

import static utils.CsvWriter.writeDataAtOnce;

public class TestBaseScrapML {

    protected ElementPage elementPage = new ElementPage();
    protected HomePage homePage = new HomePage();
    protected Navbar navbar = new Navbar();
    protected CategoryPage categoryPage = new CategoryPage();


    protected static List<String[]> data = new ArrayList<String[]>();
    @BeforeEach
    public void setup(){
        // todo create properties file
        System.out.println("holaa");
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }

    @AfterAll
    public static void writeCsv(){
        writeDataAtOnce("csvData.csv", data);
    }


}


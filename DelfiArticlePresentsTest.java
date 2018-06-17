package firtTest;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

    public class DelfiArticlePresentsTest {
        private final String ARTICLE_NAME = "Uz Jūrmalas šosejas avarējušas vismaz sešas automašīnas";
        private final String HOME_PAGE = "http://www.delfi.lv/";
        private final By ARTICLE_ITEM = By.xpath(".//*[@class='top2012-title']");

        @Test
        public void findingAnArticle () {
            System.setProperty("webdriver.gecko.driver","c:/geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(HOME_PAGE);

            List<WebElement> articleItems = new ArrayList<WebElement>();
            articleItems = driver.findElements(ARTICLE_ITEM);

            boolean isArticlefound = false;
            for (int i = 0; i < articleItems.size(); i++) {
                if (articleItems.get(i).getText().equals(ARTICLE_NAME)) {
                    isArticlefound = true;
                    break;
                }
            }
            Assert.assertTrue("No Article Item is found", isArticlefound);

        }
    }


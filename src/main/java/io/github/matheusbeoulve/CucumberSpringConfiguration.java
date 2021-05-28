package io.github.matheusbeoulve;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import io.github.matheusbeoulve.configuration.EyesConfiguration;
import io.github.matheusbeoulve.configuration.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@ComponentScan
@ConfigurationPropertiesScan
public class CucumberSpringConfiguration {

    @Autowired
    WebDriverConfiguration webDriverConfiguration;

    @Autowired
    EyesConfiguration eyesConfiguration;

    @Bean
    WebDriver webDriver() {
        return RemoteWebDriver.builder()
                .url(webDriverConfiguration.getUrl())
                .oneOf(new ChromeOptions(),
                        new FirefoxOptions(),
                        new EdgeOptions(),
                        new InternetExplorerOptions())
                .build();
    }

    @Bean
    Eyes eyes() {

        VisualGridRunner visualGridRunner = new VisualGridRunner(eyesConfiguration.getConcurrency());

        Eyes eyes = new Eyes(visualGridRunner);

        Configuration configuration = new Configuration();

        configuration.setApiKey(eyesConfiguration.getApiKey());
        configuration.setBatch(new BatchInfo(eyesConfiguration.getBatchInfo()));
        configuration.setBranchName(eyesConfiguration.getBranchName());

        configuration.addBrowser(
                eyesConfiguration.getViewportY(),
                eyesConfiguration.getViewportX(),
                BrowserType.FIREFOX
        );

        configuration.addDeviceEmulation(
                DeviceName.iPhone_11_Pro_Max,
                ScreenOrientation.PORTRAIT
        );

        configuration.addDeviceEmulation(
                DeviceName.Pixel_2,
                ScreenOrientation.PORTRAIT
        );

        eyes.setConfiguration(configuration);

        return eyes;
    }
}

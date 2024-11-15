package Week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyingTittleAndURL {
    WebDriver driver;
@BeforeTest
    public void setDriver(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.saucedemo.com");
}
@Test
    public void getTitleOFWebPage(){
 String Tittle =   driver.getTitle();
 String ExpectedTittle = "Swag Labs";
    Assert.assertEquals(Tittle, ExpectedTittle);
    System.out.println(Tittle);
}
@Test
public void getUrlofThePage(){
String ActualUrl =    driver.getCurrentUrl();
String ExpectedUrl = "https://www.saucedemo.com/";
Assert.assertEquals(ActualUrl, ExpectedUrl);
}
@Test
public void getSourcePage(){
    String ActualPageSource = driver.getPageSource();
    String ExpectedPageSource = "<html lang=\"en\"><head><meta charset=\"utf-8\"><link rel=\"icon\" href=\"/favicon.ico\"><meta name=\"robots\" content=\"noindex\"><meta name=\"viewport\" content=\"width=device-width,initial-scale=1\"><meta name=\"theme-color\" content=\"#ffffff\"><meta name=\"description\" content=\"Sauce Labs Swag Labs app\"><link rel=\"apple-touch-icon\" href=\"/icon/icon-192x192.png\"><link rel=\"manifest\" href=\"/manifest.json\"><script type=\"text/javascript\">!function(n){if(\"/\"===n.search[1]){var a=n.search.slice(1).split(\"&\").map((function(n){return n.replace(/~and~/g,\"&\")})).join(\"?\");window.history.replaceState(null,null,n.pathname.slice(0,-1)+a+n.hash)}}(window.location)</script><link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=DM+Mono:wght@400;500&amp;family=DM+Sans:wght@400;500\"><title>Swag Labs</title><link href=\"/static/css/main.f6c64be5.chunk.css\" rel=\"stylesheet\"></head><body><noscript>You need to enable JavaScript to run this app.</noscript><div id=\"root\"><div class=\"login_container\"><div class=\"login_logo\">Swag Labs</div><div class=\"login_wrapper\" data-test=\"login-container\"><div class=\"login_wrapper-inner\"><div id=\"login_button_container\" class=\"form_column\"><div class=\"login-box\"><form><div class=\"form_group\"><input class=\"input_error form_input\" placeholder=\"Username\" type=\"text\" data-test=\"username\" id=\"user-name\" name=\"user-name\" autocorrect=\"off\" autocapitalize=\"none\" value=\"\"></div><div class=\"form_group\"><input class=\"input_error form_input\" placeholder=\"Password\" type=\"password\" data-test=\"password\" id=\"password\" name=\"password\" autocorrect=\"off\" autocapitalize=\"none\" value=\"\"></div><div class=\"error-message-container\"></div><input type=\"submit\" class=\"submit-button btn_action\" data-test=\"login-button\" id=\"login-button\" name=\"login-button\" value=\"Login\"></form></div></div></div><div class=\"login_credentials_wrap\" data-test=\"login-credentials-container\"><div class=\"login_credentials_wrap-inner\"><div id=\"login_credentials\" class=\"login_credentials\" data-test=\"login-credentials\"><h4>Accepted usernames are:</h4>standard_user<br>locked_out_user<br>problem_user<br>performance_glitch_user<br>error_user<br>visual_user<br></div><div class=\"login_password\" data-test=\"login-password\"><h4>Password for all users:</h4>secret_sauce</div></div></div></div></div></div><script>!function(e){function r(r){for(var n,p,l=r[0],a=r[1],f=r[2],c=0,s=[];c<l.length;c++)p=l[c],Object.prototype.hasOwnProperty.call(o,p)&&o[p]&&s.push(o[p][0]),o[p]=0;for(n in a)Object.prototype.hasOwnProperty.call(a,n)&&(e[n]=a[n]);for(i&&i(r);s.length;)s.shift()();return u.push.apply(u,f||[]),t()}function t(){for(var e,r=0;r<u.length;r++){for(var t=u[r],n=!0,l=1;l<t.length;l++){var a=t[l];0!==o[a]&&(n=!1)}n&&(u.splice(r--,1),e=p(p.s=t[0]))}return e}var n={},o={1:0},u=[];function p(r){if(n[r])return n[r].exports;var t=n[r]={i:r,l:!1,exports:{}};return e[r].call(t.exports,t,t.exports,p),t.l=!0,t.exports}p.m=e,p.c=n,p.d=function(e,r,t){p.o(e,r)||Object.defineProperty(e,r,{enumerable:!0,get:t})},p.r=function(e){\"undefined\"!=typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:\"Module\"}),Object.defineProperty(e,\"__esModule\",{value:!0})},p.t=function(e,r){if(1&r&&(e=p(e)),8&r)return e;if(4&r&&\"object\"==typeof e&&e&&e.__esModule)return e;var t=Object.create(null);if(p.r(t),Object.defineProperty(t,\"default\",{enumerable:!0,value:e}),2&r&&\"string\"!=typeof e)for(var n in e)p.d(t,n,function(r){return e[r]}.bind(null,n));return t},p.n=function(e){var r=e&&e.__esModule?function(){return e.default}:function(){return e};return p.d(r,\"a\",r),r},p.o=function(e,r){return Object.prototype.hasOwnProperty.call(e,r)},p.p=\"/\";var l=this[\"webpackJsonpsample-app-web\"]=this[\"webpackJsonpsample-app-web\"]||[],a=l.push.bind(l);l.push=r,l=l.slice();for(var f=0;f<l.length;f++)r(l[f]);var i=a;t()}([])</script><script src=\"/static/js/2.84a5cbf3.chunk.js\"></script><script src=\"/static/js/main.018d2d1e.chunk.js\"></script></body></html>";
    Assert.assertEquals(ActualPageSource, ExpectedPageSource);
    System.out.println(ActualPageSource);
}
    @AfterTest
    public void afterTest(){
    if (driver !=  null){
        driver.quit();
    }
}

}

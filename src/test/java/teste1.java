import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class teste1 {

    private WebDriver driver;
    //private String url;

    @BeforeMethod
    public void before(){

        String caminhoDriver =  "C:\\driver\\chromedriver.exe";
        //url = System.getProperty("user.dir")+"/src/paginas/olaMundo.html";
        System.setProperty("webdriver.chrome.driver", caminhoDriver);//instancia do driver
        driver = new ChromeDriver(); //instancia do navegador



    }

    // @Test
    // public void teste() throws InterruptedException {
    //String nome = "Aline Zanin";
    //Assert.assertEquals(nome,"Aline Zanin");
    //Assert.assertTrue(nome.contains("Aline"));
    //Assert.assertFalse(nome.contains("Carol"));
    //Hancrest
    //thread.sleep( mills: 1500)
    //driver.get("https://www.google.com");
    //WebElement pesquisa = driver.findElement(By.name("q"));
    //pesquisa.sendKeys(" free fire download");
    // Thread.sleep(1500);
    // WebElement clicarnonome = driver.findElement(By.className("wM6W7d"));
    // clicarnonome.click();
    //}


    @Test
    public void tpengenharia() throws InterruptedException {
        driver.get(System.getProperty("user.dir")+"/src/paginas/componentes.html");

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Joylly");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sincura");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();

        Select listaescolaridade = new Select(driver.findElement(By.id("elementosForm:escolaridade")));
        listaescolaridade.selectByVisibleText("Doutorado");

        Select esporte = new Select(driver.findElement((By.id("elementosForm:esportes"))));
        esporte.selectByVisibleText("Natacao");

        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste para ver se esta informando as sugestoes");
        driver.findElement(By.xpath("//*[@id=\"elementosForm:tableUsuarios\"]/tbody/tr[2]/td[4]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"elementosForm:tableUsuarios\"]/tbody/tr[2]/td[3]/input")).click();
        Thread.sleep(1500);
        Alert botaomaria =  driver.switchTo().alert();
        botaomaria.accept();

        driver.findElement(By.xpath("//*[@id=\"elementosForm:tableUsuarios\"]/tbody/tr[3]/td[5]/table/tbody/tr/td/input")).click();
        driver.findElement(By.xpath("//*[@id=\"elementosForm:tableUsuarios\"]/tbody/tr[3]/td[3]/input")).click();
        Thread.sleep(1500);
        Alert botaousuarioA =  driver.switchTo().alert();
        botaousuarioA.accept();

        driver.findElement(By.xpath("//*[@id=\"elementosForm:tableUsuarios\"]/tbody/tr[5]/td[6]/input")).sendKeys("Preencher");
        driver.findElement(By.xpath("//*[@id=\"elementosForm:tableUsuarios\"]/tbody/tr[5]/td[3]/input")).click();
        Thread.sleep(1500);
        Alert botaousuarioB =  driver.switchTo().alert();
        botaousuarioB.accept();

        driver.findElement(By.id("elementosForm:cadastrar")).click();

        String cadastrado = driver.findElement(By.xpath("//*[@id=\"resultado\"]/span")).getText();
        Assert.assertEquals(cadastrado,"Cadastrado!");

        String nome = driver.findElement(By.xpath("//*[@id=\"descNome\"]/span")).getText();
        Assert.assertEquals(nome, "Joylly");

        String sobrenome = driver.findElement(By.xpath("//*[@id=\"descSobrenome\"]/span")).getText();
        Assert.assertEquals(sobrenome, "Sincura");

        String sexo = driver.findElement(By.xpath("//*[@id=\"descSexo\"]/span")).getText();
        Assert.assertEquals(sexo, "Masculino");

        String comida = driver.findElement(By.xpath("//*[@id=\"descComida\"]/span")).getText();
        Assert.assertEquals(comida, "Carne Frango");

        String escolaridade = driver.findElement(By.xpath("//*[@id=\"descEscolaridade\"]/span")).getText();
        Assert.assertEquals(escolaridade, "doutorado");

        String esportes = driver.findElement(By.xpath("//*[@id=\"descEsportes\"]/span")).getText();
        Assert.assertEquals(esportes, "Natacao");

        String sugestao = driver.findElement(By.xpath("//*[@id=\"descSugestoes\"]/span")).getText();
        Assert.assertEquals(sugestao, "Teste para ver se esta informando as sugestoes");


        driver.findElement(By.id("confirm")).click();

        Thread.sleep(1500);

        Alert alerta =  driver.switchTo().alert();
        alerta.accept();

        Thread.sleep(1500);

        Alert alertadois =  driver.switchTo().alert();
        alertadois.accept();

    }





    @AfterMethod
    public void after(){
        System.out.println("After");
    }
}

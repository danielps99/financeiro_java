package br.com.bdws.financeiro;

import br.com.bdws.financeiro.service.LoadDadosIniciaisService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FinanceiroApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(FinanceiroApplication.class, args);
        //Isso usado somente durante o desenvolviemnto
        inserirDadosIniciaisDuranteODesenvolvimento(applicationContext);
    }

    private static void inserirDadosIniciaisDuranteODesenvolvimento(ApplicationContext applicationContext) {
        LoadDadosIniciaisService tituloService = applicationContext.getBean(LoadDadosIniciaisService.class);
        tituloService.inserirDadosIniciais();
    }
}

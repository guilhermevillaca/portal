package br.com.villaca.portal.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.villaca.portal.model.Categoria;
import br.com.villaca.portal.model.Noticia;
import br.com.villaca.portal.model.Pessoa;
import br.com.villaca.portal.repository.CategoriaRepository;
import br.com.villaca.portal.repository.NoticiaRepository;
import br.com.villaca.portal.repository.PessoaRepository;

@Component
public class DBInsert implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    NoticiaRepository noticiaRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria("Eletrônicos", "Produtos eletrônicos em geral", null);
        categoriaRepository.save(cat1);
        Categoria cat2 = new Categoria("Roupas", "Roupas para todas as estações", null);
        categoriaRepository.save(cat2);
        // Categorias Filhas
        Categoria cat3 = new Categoria("Celulares", "Smartphones e acessórios", cat1);
        categoriaRepository.save(cat3);
        Categoria cat4 = new Categoria("TVs", "Televisões de alta definição", cat1);
        categoriaRepository.save(cat4);
        Categoria cat5 = new Categoria("Camisetas", "Camisetas casuais", cat2);
        categoriaRepository.save(cat5);
        Categoria cat6 = new Categoria("Calças", "Calças jeans e de tecido", cat2);
        categoriaRepository.save(cat6);
        Categoria cat7 = new Categoria("Capas de celular", "Capas protetoras para smartphones", cat3);
        categoriaRepository.save(cat7);
        Categoria cat8 = new Categoria("Fones de ouvido", "Fones de ouvido com fio e sem fio", cat3);
        categoriaRepository.save(cat8);
        Categoria cat9 = new Categoria("Smart TVs", "Televisões inteligentes", cat4);
        categoriaRepository.save(cat9);
        Categoria cat10 = new Categoria("Roupas íntimas", "Roupas íntimas para todas as idades", cat5);
        categoriaRepository.save(cat10);

        List<Categoria> cats = Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10);

         // Gerador de números aleatórios
        Random random = new Random();

        // Criação das 20 instâncias de Noticia com valores aleatórios
        for (int i = 1; i <= 20; i++) {
            Noticia noticia = new Noticia();

            // Geração de valores aleatórios para os atributos            
            noticia.setTitulo("Título da Notícia " + (random.nextInt(100) + 1));
            noticia.setCorpo("Este é o corpo da notícia número " + i + ", com detalhes variados sobre o tema " + (random.nextInt(50) + 1) + ".");

            // Data aleatória para publicação
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, -random.nextInt(365)); // data no último ano
            noticia.setData_publicacao(calendar.getTime());

            // URL de imagem aleatória
            noticia.setImagem_url("https://site.com/imagem" + (random.nextInt(50) + 1) + ".jpg");

            // Escolhe uma categoria aleatória
            noticia.setCategoria(cats.get(random.nextInt(cats.size())));

            // Adiciona a instância de Noticia na lista
            noticiaRepository.save(noticia);
        }

        Pessoa p1 = new Pessoa("João Silva");
        pessoaRepository.save(p1);
        Pessoa p2 = new Pessoa("Maria Oliveira");
        pessoaRepository.save(p2);
        Pessoa p3 = new Pessoa("Carlos Souza");
        pessoaRepository.save(p3);
        Pessoa p4 = new Pessoa("Ana Costa");
        pessoaRepository.save(p4);
        Pessoa p5 = new Pessoa("Pedro Fernandes");
        pessoaRepository.save(p5);
        Pessoa p6 = new Pessoa("Lucia Mendes");
        pessoaRepository.save(p6);
        Pessoa p7 = new Pessoa("Marcos Lima");
        pessoaRepository.save(p7);
        Pessoa p8 = new Pessoa("Fernanda Ribeiro");
        pessoaRepository.save(p8);
        Pessoa p9 = new Pessoa("José Almeida");
        pessoaRepository.save(p9);
        Pessoa p10 = new Pessoa("Paula Moreira");
        pessoaRepository.save(p10);

        System.out.println("----------All Data saved into Database----------------------");
    }

}

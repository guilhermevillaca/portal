package br.com.villaca.portal.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import br.com.villaca.portal.modelo.Autor;
import br.com.villaca.portal.modelo.Categoria;
import br.com.villaca.portal.modelo.Noticia;
import br.com.villaca.portal.modelo.Pessoa;
import br.com.villaca.portal.modelo.Posicao;
import br.com.villaca.portal.modelo.Publicidade;
import br.com.villaca.portal.modelo.Usuario;
import br.com.villaca.portal.repository.AutorRepository;
import br.com.villaca.portal.repository.CategoriaRepository;
import br.com.villaca.portal.repository.NoticiaRepository;
import br.com.villaca.portal.repository.PessoaRepository;
import br.com.villaca.portal.repository.PosicaoRepository;
import br.com.villaca.portal.repository.PublicidadeRepository;
import br.com.villaca.portal.repository.UsuarioRepository;

@Component
public class DataFixture implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    NoticiaRepository noticiaRepository;

    @Autowired
    PosicaoRepository posicaoRepository;

    @Autowired
    PublicidadeRepository publicidadeRepository;

    @Override
    public void run(String... args) throws Exception {

        // Gerador de números aleatórios
        Random random = new Random();

        Categoria categoria = new Categoria();
        categoria.setNome("Esportes");
        categoria.setDescricao("Esportes");
        categoria.setDestaque(false);
        categoriaRepository.save(categoria);

        Categoria categoria2 = new Categoria();
        categoria2.setNome("Futebol");
        categoria2.setDescricao("Futebol");
        categoria2.setCategoria(categoria);
        categoria2.setDestaque(false);
        categoriaRepository.save(categoria2);

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Guilherme Villaca");
        pessoa.setEmail("guilherme.villaca@docente.pr.senac.br");
        pessoaRepository.save(pessoa);

        Autor autor = new Autor();
        autor.setBiografia("Professor do Senac");
        autor.setPessoa(pessoa);
        autorRepository.save(autor);

        Pessoa pessoa2 = new Pessoa();
        pessoa.setNome("Luís Guilherme");
        pessoa.setEmail("luisguilherme@gmail.com");
        pessoaRepository.save(pessoa2);

        Usuario usuario = new Usuario();
        usuario.setLogin("luis");
        usuario.setSenha("123456");
        usuario.setPessoa(pessoa2);
        usuarioRepository.save(usuario);

        Lorem lorem = LoremIpsum.getInstance();

        Noticia noticia1 = new Noticia();
        noticia1.setAutor(autor);
        noticia1.setTitulo(lorem.getTitle(3));
        noticia1.setCorpo(lorem.getParagraphs(3, 6));
        noticia1.setCategoria(categoria2);
        noticia1.setDataPublicacao(LocalDate.now());
        noticia1.setImagem_url("https://picsum.photos/id/" + (random.nextInt(50) + 1) + "/1920/1280");
        noticia1.setDestaque(true);
        noticiaRepository.save(noticia1);

        Categoria cat1 = new Categoria("Tecnologia", "Notícias sobre tecnologia", null, true);
        categoriaRepository.save(cat1);
        Categoria cat2 = new Categoria("Esporte", "Notícias sobre esporte", null, true);
        categoriaRepository.save(cat2);
        // Categorias Filhas
        Categoria cat3 = new Categoria("Politica", "Notícias sobre politica", null, true);
        categoriaRepository.save(cat3);
        Categoria cat4 = new Categoria("Economia", "Notícias sobre economia", null, true);
        categoriaRepository.save(cat4);
        Categoria cat5 = new Categoria("Saude", "Notícias saude ", null, true);
        categoriaRepository.save(cat5);
        Categoria cat6 = new Categoria("Cinema", "Calças jeans e de tecido", null, false);
        categoriaRepository.save(cat6);
        Categoria cat7 = new Categoria("Televisão", "Capas protetoras para smartphones", null, false);
        categoriaRepository.save(cat7);
        Categoria cat8 = new Categoria("Futebol", "Noticia sobre futebol", cat1, false);
        categoriaRepository.save(cat8);
        Categoria cat9 = new Categoria("Campeonato Brasileiro Série A", "Noticias sobre o campeonato brasileiro", cat8,
                false);
        categoriaRepository.save(cat9);
        Categoria cat10 = new Categoria("Libertadores", "Notícias sobre a Libertadores", cat8, false);
        categoriaRepository.save(cat10);

        List<Categoria> cats = Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10);

        // Criação das 20 instâncias de Noticia com valores aleatórios
        for (int i = 1; i <= 20; i++) {
            Noticia noticia = new Noticia();

            // Geração de valores aleatórios para os atributos
            noticia.setTitulo(lorem.getTitle(4));
            noticia.setCorpo(lorem.getParagraphs(3, 8));

            // Data aleatória para publicação
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, -random.nextInt(365)); // data no último ano
            noticia.setDataPublicacao(LocalDate.now());

            // URL de imagem aleatória
            noticia.setImagem_url("https://picsum.photos/id/" + (random.nextInt(50) + 1) + "/1920/1280");

            // Escolhe uma categoria aleatória
            noticia.setCategoria(cats.get(random.nextInt(cats.size())));

            // Adiciona a instância de Noticia na lista
            noticiaRepository.save(noticia);
        }

        Pessoa p1 = new Pessoa("João Silva", "joaosilva@gmail.com");
        pessoaRepository.save(p1);
        Pessoa p2 = new Pessoa("Maria Oliveira", "email@email.com.br");
        pessoaRepository.save(p2);
        Pessoa p3 = new Pessoa("Carlos Souza", "email@email.com.br");
        pessoaRepository.save(p3);
        Pessoa p4 = new Pessoa("Ana Costa", "email@email.com.br");
        pessoaRepository.save(p4);
        Pessoa p5 = new Pessoa("Pedro Fernandes", "email@email.com.br");
        pessoaRepository.save(p5);
        Pessoa p6 = new Pessoa("Lucia Mendes", "email@email.com.br");
        pessoaRepository.save(p6);
        Pessoa p7 = new Pessoa("Marcos Lima", "email@email.com.br");
        pessoaRepository.save(p7);
        Pessoa p8 = new Pessoa("Fernanda Ribeiro", "email@email.com.br");
        pessoaRepository.save(p8);
        Pessoa p9 = new Pessoa("José Almeida", "email@email.com.br");
        pessoaRepository.save(p9);
        Pessoa p10 = new Pessoa("Paula Moreira", "email@email.com.br");
        pessoaRepository.save(p10);

        System.out.println("----------All Data saved into Database----------------------");

        System.out.println("inserindo publi");

        List<Posicao> posicoes = new ArrayList<>();
        posicoes.add(new Posicao("topo"));
        posicoes.add(new Posicao("rodape"));
        posicoes.add(new Posicao("sidebar_esquerda"));
        posicoes.add(new Posicao("sidebar_direita"));
        posicaoRepository.saveAll(posicoes);

        Publicidade pub1 = new Publicidade(
                "Anúncio de Curso Java",
                "https://placehold.co/1200x200/purple/black?text=Publicidade+Topo",
                "https://cursos.meusite.com/java",
                LocalDate.of(2025, 6, 1),
                LocalDate.of(2025, 7, 1),
                true,
                posicaoRepository.findById(1).get(),
                cat8 // Apenas ID necessário
        );

        publicidadeRepository.save(pub1);

        Publicidade pub2 = new Publicidade(
                "Promoção de Hospedagem",
                "https://placehold.co/1000x150/black/red?text=Publicidade+Rodap%C3%A9",
                "https://hospedagem.com/promo",
                LocalDate.of(2025, 6, 5),
                LocalDate.of(2025, 8, 1),
                true,
                posicaoRepository.findById(2).get(),
                cat1);

        publicidadeRepository.save(pub2);

        Publicidade pub3 = new Publicidade(
                "Anuncie no nosso portal!",
                "https://placehold.co/300x600/orange/gray?text=Publicidade+Sidebar+Esquerda",
                "https://meusite.com/contato",
                LocalDate.of(2025, 6, 1),
                LocalDate.of(2025, 12, 31),
                true,
                posicaoRepository.findById(3).get(),
                cat2);

        publicidadeRepository.save(pub3);


        Publicidade pub4 = new Publicidade(
                "Seja Sócio!",
                "https://placehold.co/300x250/green/pink?text=Publicidade+Sidebar+Direita",
                "https://meusite.com/contato",
                LocalDate.of(2025, 6, 1),
                LocalDate.of(2025, 12, 31),
                true,
                posicaoRepository.findById(4).get(),
                cat2);

        publicidadeRepository.save(pub4);

        System.out.println("fim inserindo publi");

    }

}

package school.sptech.acervo_musical;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@RestController
@RequestMapping("/musicas")
@CrossOrigin // permite que o frontend faça requisições para o Controller.
public class MusicaController {

    private final JdbcTemplate jdbctemplate;
    public MusicaController(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    // inserir musica
    @PostMapping
    public ResponseEntity<Musica> criar(@RequestBody Musica musicaCriada) {
        String sql = "INSERT INTO musica (titulo, artista, fk_genero, lancamento, duracao, album, versao, explicita, cover," +
                " remix, trilha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbctemplate.update( con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, musicaCriada.getTitulo());
            ps.setString(2, musicaCriada.getArtista());
            ps.setInt(3, musicaCriada.getFkGenero());;
            ps.setDate(4, java.sql.Date.valueOf(musicaCriada.getLancamento()));
            ps.setInt(5, musicaCriada.getDuracao());
            ps.setString(6, musicaCriada.getAlbum());
            ps.setString(7, musicaCriada.getVersao());
            ps.setBoolean(8, musicaCriada.getExplicita());
            ps.setBoolean(9, musicaCriada.getCover());
            ps.setBoolean(10, musicaCriada.getRemix());
            ps.setBoolean(11, musicaCriada.getTrilha());
            return ps;
        }, keyHolder);

        Integer idGerado = keyHolder.getKeyAs(Integer.class);
        musicaCriada.setId(idGerado);

        return ResponseEntity.status(201).body(musicaCriada);
    }

    // obter todas as músicas cadastradas
    @GetMapping
    public ResponseEntity<List<Musica>> listarMusicas() {
        String sql = "SELECT musica.*, genero.nome AS genero FROM musica JOIN genero ON musica.fk_genero = genero.id";
        List<Musica> musicas = jdbctemplate.query(sql, new BeanPropertyRowMapper<>(Musica.class));
        return ResponseEntity.status(200).body(musicas);
    }

    // obter generos
    @GetMapping("/generos")
    public ResponseEntity<List<Genero>> listarGeneros() {
        String sql = "SELECT * FROM genero";
        List<Genero> generos = jdbctemplate.query(sql, new BeanPropertyRowMapper<>(Genero.class));
        return ResponseEntity.status(200).body(generos);
    }

}

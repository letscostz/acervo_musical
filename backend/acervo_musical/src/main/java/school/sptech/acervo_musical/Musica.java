package school.sptech.acervo_musical;

import java.time.LocalDate;

public class Musica {
    private Integer id;
    private String titulo;
    private String artista;
    private String genero;
    private LocalDate lancamento;
    private Integer duracao;
    private String album;
    private String versao;
    private Boolean explicita;
    private Boolean cover;
    private Boolean remix;
    private Boolean trilha;

    public Musica() {
    }

    public Musica(Integer id, String titulo, String artista, String genero, LocalDate lancamento, Integer duracao,
                  String album, String versao, Boolean explicita, Boolean cover, Boolean remix, Boolean trilha) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.lancamento = lancamento;
        this.duracao = duracao;
        this.album = album;
        this.versao = versao;
        this.explicita = explicita;
        this.cover = cover;
        this.remix = remix;
        this.trilha = trilha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public Boolean getExplicita() {
        return explicita;
    }

    public void setExplicita(Boolean explicita) {
        this.explicita = explicita;
    }

    public Boolean getCover() {
        return cover;
    }

    public void setCover(Boolean cover) {
        this.cover = cover;
    }

    public Boolean getRemix() {
        return remix;
    }

    public void setRemix(Boolean remix) {
        this.remix = remix;
    }

    public Boolean getTrilha() {
        return trilha;
    }

    public void setTrilha(Boolean trilha) {
        this.trilha = trilha;
    }
}

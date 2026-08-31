CREATE TABLE IF NOT EXISTS genero (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS musica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    artista VARCHAR(255) NOT NULL,
    fk_genero INT NOT NULL,
    lancamento DATE NOT NULL,
    duracao INT NOT NULL,
    album VARCHAR(100) NOT NULL,
    versao VARCHAR(100) NOT NULL,
    CONSTRAINT chk_versao CHECK (versao IN ('Estúdio', 'Ao vivo', 'Acústica')),
    explicita BOOLEAN NOT NULL,
    cover BOOLEAN NOT NULL,
    remix BOOLEAN NOT NULL,
    trilha BOOLEAN NOT NULL,
    CONSTRAINT fk_musica_genero FOREIGN KEY (fk_genero) REFERENCES genero(id)
    );

INSERT INTO genero (nome) VALUES
    ('Pop'), ('Rock'), ('Rap'), ('Sertanejo'), ('Hip-Hop'), ('Pagode'),
    ('Funk'), ('Jazz'), ('Eletrônica'), ('MPB'), ('Clássica'), ('Outros');
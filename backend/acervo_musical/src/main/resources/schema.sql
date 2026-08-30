CREATE TABLE IF NOT EXISTS musica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    artista VARCHAR(255) NOT NULL,
    genero VARCHAR(255) NOT NULL,
    lancamento DATE NOT NULL,
    duracao INT NOT NULL,
    album VARCHAR(100) NOT NULL,
    versao VARCHAR(100) NOT NULL,
    CONSTRAINT chk_versao CHECK (versao IN ('Estúdio', 'Ao vivo', 'Acústica')),
    explicita BOOLEAN NOT NULL,
    cover BOOLEAN NOT NULL,
    remix BOOLEAN NOT NULL,
    trilha BOOLEAN NOT NULL
);
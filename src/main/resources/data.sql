-- Inserindo Artistas
INSERT INTO artista (nome_artista) VALUES ('Artista A');
INSERT INTO artista (nome_artista) VALUES ('Artista B');

-- Inserindo Álbum
INSERT INTO album (nome_album, artista_id) VALUES ('Album 1', 1); -- Supondo que 'Artista A' tem ID 1
INSERT INTO album (nome_album, artista_id) VALUES ('Album 2', 2); -- Supondo que 'Artista B' tem ID 2

-- Inserindo Músicas
INSERT INTO musica (titulo, album_id, artista_id) VALUES ('Música 1', 1, 1); -- Música do 'Album 1' do 'Artista A'
INSERT INTO musica (titulo, album_id, artista_id) VALUES ('Música 2', 1, 1); -- Música do 'Album 1' do 'Artista A'
INSERT INTO musica (titulo, album_id, artista_id) VALUES ('Música 3', 2, 2); -- Música do 'Album 2' do 'Artista B'

-- Inserindo Usuário
INSERT INTO usuario (email, nome, senha) VALUES ('usuario@example.com', 'Usuário Exemplo', 'senha123');

-- Inserindo Playlist
INSERT INTO playlist (nome_playlist, usuario_id) VALUES ('Playlist 1', 1); -- Supondo que 'Usuário Exemplo' tem ID 1

-- Inserindo Relações (Usuário e Música Favorita)
INSERT INTO usuario_musica (usuario_id, musica_id) VALUES (1, 1); -- Usuário favorito a Música 1
INSERT INTO usuario_musica (usuario_id, musica_id) VALUES (1, 2); -- Usuário favorito a Música 2
INSERT INTO usuario_musica (usuario_id, musica_id) VALUES (1, 3); -- Usuário favorito a Música 3

-- Inserindo Relações (Playlist e Música)
INSERT INTO playlist_musica (playlist_id, musica_id) VALUES (1, 1); -- Música 1 na Playlist 1
INSERT INTO playlist_musica (playlist_id, musica_id) VALUES (1, 2); -- Música 2 na Playlist 1
INSERT INTO playlist_musica (playlist_id, musica_id) VALUES (1, 3); -- Música 3 na Playlist 1

-- Inserindo Relações (Usuário e Artista Seguido)
INSERT INTO usuario_artista (usuario_id, artista_id) VALUES (1, 1); -- Usuário seguindo Artista A
INSERT INTO usuario_artista (usuario_id, artista_id) VALUES (1, 2); -- Usuário seguindo Artista B

CREATE DATABASE sistema_de_musicas_2;

USE sistema_de_musicas_2;

CREATE TABLE IF NOT EXISTS tb_usuarios(
	id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nome_usuario VARCHAR (200) UNIQUE NOT NULL,
    senha_usuario VARCHAR (20) NOT NULL    
);


CREATE TABLE IF NOT EXISTS tb_musicas(
	id_musica INT PRIMARY KEY AUTO_INCREMENT,
    nome_musica VARCHAR (200),
    nome_artista VARCHAR (200),
    qtde_notas_usuarios INT,
	soma_notas_musica INT,
    media_notas_musica DOUBLE,
    nota_musica INT DEFAULT 0
);


CREATE TABLE IF NOT EXISTS tb_generos(
	id_genero INT PRIMARY KEY AUTO_INCREMENT,
    nome_genero VARCHAR (200) UNIQUE       
);


CREATE TABLE IF NOT EXISTS tb_usuario_tem_genero(
	id_genero INT,
    id_usuario INT,
    data_genero DATE, #CURDATE é data atual? como usar CURDATE?
    PRIMARY KEY (id_genero, id_usuario),
    UNIQUE (id_genero, id_usuario),
    FOREIGN KEY (id_genero) REFERENCES tb_generos(id_genero) ON DELETE NO ACTION,
    FOREIGN KEY (id_usuario) REFERENCES tb_usuarios(id_usuario) ON DELETE NO ACTION
);


CREATE TABLE IF NOT EXISTS tb_musicas_tem_genero(
	id_genero INT,
    id_musica INT,
    PRIMARY KEY (id_genero, id_musica),
    UNIQUE (id_genero, id_musica),
    FOREIGN KEY (id_genero) REFERENCES tb_generos(id_genero) ON DELETE NO ACTION,
    FOREIGN KEY (id_musica) REFERENCES tb_musicas(id_musica) ON DELETE NO ACTION
);

#versao 01
CREATE TABLE IF NOT EXISTS tb_usuario_avalia(
	id_usuario INT,
    id_musica INT,
    nota_usuario INT DEFAULT 0,
    PRIMARY KEY (id_usuario, id_musica),
    UNIQUE (id_usuario, id_musica),
    FOREIGN KEY (id_usuario) REFERENCES tb_usuarios(id_usuario) ON DELETE NO ACTION,
    FOREIGN KEY (id_musica) REFERENCES tb_musicas(id_musica) ON DELETE NO ACTION
);


INSERT INTO tb_musicas(nome_musica, nome_artista) VALUES ('Fat Lip', 'Sum 41');
INSERT INTO tb_musicas(nome_musica, nome_artista) VALUES ('All Star', 'Smash Mouth');
INSERT INTO tb_musicas(nome_musica, nome_artista) VALUES ('Wonderwall', 'Oasis');
INSERT INTO tb_musicas(nome_musica, nome_artista) VALUES ('My Way', 'Limp Bizkit');
INSERT INTO tb_musicas(nome_musica, nome_artista) VALUES ('Numb', 'Linkin Park');

INSERT INTO tb_musicas(nome_musica, nome_artista) VALUES ('Oh Juliana', 'Nack');
INSERT INTO tb_musicas(nome_musica, nome_artista) VALUES ('Azul Piscina', 'Mc Livinho');
INSERT INTO tb_musicas(nome_musica, nome_artista) VALUES ('Fuleragem', 'Mc WM');
INSERT INTO tb_musicas(nome_musica, nome_artista) VALUES ('Ritmo Mexicano', 'Mc Gw');
INSERT INTO tb_musicas(nome_musica, nome_artista) VALUES ('Rabiola', 'Mc Kevinho');

INSERT INTO tb_musicas(nome_musica, nome_artista) VALUES ('Hotline Bling', 'Drake');
INSERT INTO tb_musicas(nome_musica, nome_artista) VALUES ('Rap God', 'Eminem');
INSERT INTO tb_musicas(nome_musica, nome_artista) VALUES ('Humble', 'Kendrick Lamar');
INSERT INTO tb_musicas(nome_musica, nome_artista) VALUES ('Rack City', 'Tyga');
INSERT INTO tb_musicas(nome_musica, nome_artista) VALUES ('Window Shopper', '50 Cent');

INSERT INTO tb_generos(nome_genero) VALUES ('Rock');
INSERT INTO tb_generos(nome_genero) VALUES ('Funk');
INSERT INTO tb_generos(nome_genero) VALUES ('Hip Hop');


INSERT INTO tb_musicas_tem_genero(id_genero, id_musica) VALUES ('1', '1');
INSERT INTO tb_musicas_tem_genero(id_genero, id_musica) VALUES ('1', '2');
INSERT INTO tb_musicas_tem_genero(id_genero, id_musica) VALUES ('1', '3');
INSERT INTO tb_musicas_tem_genero(id_genero, id_musica) VALUES ('1', '4');
INSERT INTO tb_musicas_tem_genero(id_genero, id_musica) VALUES ('1', '5');

INSERT INTO tb_musicas_tem_genero(id_genero, id_musica) VALUES ('2', '6');
INSERT INTO tb_musicas_tem_genero(id_genero, id_musica) VALUES ('2', '7');
INSERT INTO tb_musicas_tem_genero(id_genero, id_musica) VALUES ('2', '8');
INSERT INTO tb_musicas_tem_genero(id_genero, id_musica) VALUES ('2', '9');
INSERT INTO tb_musicas_tem_genero(id_genero, id_musica) VALUES ('2', '10');

INSERT INTO tb_musicas_tem_genero(id_genero, id_musica) VALUES ('3', '11');
INSERT INTO tb_musicas_tem_genero(id_genero, id_musica) VALUES ('3', '12');
INSERT INTO tb_musicas_tem_genero(id_genero, id_musica) VALUES ('3', '13');
INSERT INTO tb_musicas_tem_genero(id_genero, id_musica) VALUES ('3', '14');
INSERT INTO tb_musicas_tem_genero(id_genero, id_musica) VALUES ('3', '15');

 
select * from tb_usuario_tem_genero;
select * from tb_usuario_avalia;
select * from tb_usuarios;
select * from tb_generos;

 
#Usuario se cadastra
INSERT INTO tb_usuarios(nome_usuario, senha_usuario) VALUES ('admin', 'admin');
INSERT INTO tb_usuarios(nome_usuario, senha_usuario) VALUES ('admin2', 'admin2');
INSERT INTO tb_usuarios(nome_usuario, senha_usuario) VALUES ('admin3', 'admin3');
SELECT * FROM tb_usuarios;


#Usuario deleta avaliação
DELETE FROM  tb_usuario_avalia WHERE id_musica = 1;
select * from tb_usuario_avalia;



#Usuario adiciona genero na sua coleção
INSERT INTO tb_usuario_tem_genero (id_usuario, id_genero) VALUES ('1', '1');
INSERT INTO tb_usuario_tem_genero (id_usuario, id_genero) VALUES (1, 3);
INSERT INTO tb_usuario_tem_genero (id_usuario, id_genero) VALUES ('2', '2');


#Usuario remove genero da sua coleção
DELETE FROM tb_usuario_tem_genero WHERE id_usuario = 1 AND id_genero = 3;


#Usuario clica em Meus Generos Preferidos e aparece os generos de sua colecao
SELECT tb_generos.id_genero, tb_generos.nome_genero 
FROM tb_generos
INNER JOIN tb_usuario_tem_genero
ON tb_generos.id_genero = tb_usuario_tem_genero.id_genero
WHERE id_usuario = 1;


    
    
#DEU CERTO !Teste Usuario clica em Adicionar Genero e aparece os generos que ele nao adicionou
SELECT tb_generos.id_genero, tb_generos.nome_genero
FROM tb_generos
WHERE tb_generos.nome_genero NOT IN
	(SELECT tb_generos.nome_genero 
	FROM tb_generos
	INNER JOIN tb_usuario_tem_genero
	ON tb_generos.id_genero = tb_usuario_tem_genero.id_genero
	WHERE id_usuario = 1); #AND id_usuario = 1;    





#Usuario avalia a musica versao 01
INSERT INTO tb_usuario_avalia(id_usuario, id_musica, nota_usuario) VALUES ('1', '1', 5);
INSERT INTO tb_usuario_avalia(id_usuario, id_musica, nota_usuario) VALUES ('2', '1', 4);
INSERT INTO tb_usuario_avalia(id_usuario, id_musica, nota_usuario) VALUES ('2', '2', 4);
INSERT INTO tb_usuario_avalia(id_usuario, id_musica, nota_usuario) VALUES ('2', '3', 3);
INSERT INTO tb_usuario_avalia(id_usuario, id_musica, nota_usuario) VALUES ('2', '4', 1);


#Usuario reavalia a musica versao 01
#UPDATE tb_usuario_avalia SET id_usuario = 1, id_musica = 1, nota_usuario = 1;
UPDATE tb_usuario_avalia SET nota_usuario = 5 WHERE id_musica = 1 and id_usuario = 1;


#Atualiza a media de notas da musica logo depois que o usuario avaliou a musica
UPDATE tb_musicas SET media_notas_musica = 
	(SELECT AVG(nota_usuario) FROM tb_usuario_avalia WHERE id_musica = 1) 
    WHERE id_musica = 1;
    
    UPDATE tb_musicas SET media_notas_musica = 
	(SELECT AVG(nota_usuario) FROM tb_usuario_avalia WHERE id_musica = 2) 
    WHERE id_musica = 2;
    
    UPDATE tb_musicas SET media_notas_musica = 
	(SELECT AVG(nota_usuario) FROM tb_usuario_avalia WHERE id_musica = 3) 
    WHERE id_musica = 3;
    
    UPDATE tb_musicas SET media_notas_musica = 
	(SELECT AVG(nota_usuario) FROM tb_usuario_avalia WHERE id_musica = 4) 
    WHERE id_musica = 4;




#Usuario clica em "Minhas avaliações" Aparece lista de musicas que o usuario avaliou
SELECT tb_musicas.id_musica, tb_generos.nome_genero, tb_musicas.nome_artista, tb_musicas.nome_musica, tb_usuario_avalia.nota_usuario
FROM tb_musicas_tem_genero
INNER JOIN tb_musicas 
ON tb_musicas.id_musica = tb_musicas_tem_genero.id_musica
INNER JOIN tb_generos
ON tb_musicas_tem_genero.id_genero = tb_generos.id_genero
INNER JOIN tb_usuario_avalia
ON tb_musicas_tem_genero.id_musica = tb_usuario_avalia.id_musica
where id_usuario = 1;

    
    
#Usuario clica em "avaliar músicas" e aparece a lista de musicas que ele ainda não avaliou
SELECT tb_musicas.id_musica, tb_generos.nome_genero, tb_musicas.nome_artista, tb_musicas.nome_musica, tb_musicas.nota_musica
FROM tb_musicas_tem_genero
INNER JOIN tb_musicas 
ON tb_musicas.id_musica = tb_musicas_tem_genero.id_musica
INNER JOIN tb_generos
ON tb_musicas_tem_genero.id_genero = tb_generos.id_genero
where tb_musicas.nome_musica NOT IN 
	(SELECT tb_musicas.nome_musica
	FROM tb_musicas_tem_genero
	INNER JOIN tb_musicas 
	ON tb_musicas.id_musica = tb_musicas_tem_genero.id_musica
	INNER JOIN tb_generos
	ON tb_musicas_tem_genero.id_genero = tb_generos.id_genero
	INNER JOIN tb_usuario_avalia
	ON tb_musicas_tem_genero.id_musica = tb_usuario_avalia.id_musica
	where id_usuario = 1);
    
    
    
#DEU CERTO! RECOMENDAÇÕES POR GENERO PREFERIDO E MÚSICA NAO AVALIADA!    
SELECT tb_musicas.id_musica, tb_generos.nome_genero, tb_musicas.nome_artista, tb_musicas.nome_musica, tb_musicas.media_notas_musica
FROM tb_musicas_tem_genero
INNER JOIN tb_musicas 
ON tb_musicas.id_musica = tb_musicas_tem_genero.id_musica
INNER JOIN tb_generos
ON tb_musicas_tem_genero.id_genero = tb_generos.id_genero
	WHERE tb_musicas.nome_musica !=
	(SELECT tb_musicas.nome_musica
	FROM tb_musicas_tem_genero
	INNER JOIN tb_musicas 
	ON tb_musicas.id_musica = tb_musicas_tem_genero.id_musica
	INNER JOIN tb_generos
	ON tb_musicas_tem_genero.id_genero = tb_generos.id_genero
	INNER JOIN tb_usuario_avalia
	ON tb_musicas_tem_genero.id_musica = tb_usuario_avalia.id_musica
	where id_usuario = 1)
		AND tb_generos.nome_genero = 
		(SELECT tb_generos.nome_genero 
		FROM tb_generos
		INNER JOIN tb_usuario_tem_genero
		ON tb_generos.id_genero = tb_usuario_tem_genero.id_genero
		WHERE id_usuario = 1);
    
    
#Recomendações
SELECT tb_generos.nome_genero, tb_musicas.nome_artista, tb_musicas.nome_musica, tb_musicas.media_notas_musica 
FROM tb_musicas_tem_genero
INNER JOIN tb_musicas 
ON tb_musicas.id_musica = tb_musicas_tem_genero.id_musica
INNER JOIN tb_generos
ON tb_musicas_tem_genero.id_genero = tb_generos.id_genero
	WHERE tb_musicas.nome_musica NOT IN
	(SELECT tb_musicas.nome_musica
	FROM tb_musicas_tem_genero
	INNER JOIN tb_musicas 
	ON tb_musicas.id_musica = tb_musicas_tem_genero.id_musica
	INNER JOIN tb_generos
	ON tb_musicas_tem_genero.id_genero = tb_generos.id_genero
	INNER JOIN tb_usuario_avalia
	ON tb_musicas_tem_genero.id_musica = tb_usuario_avalia.id_musica
	where id_usuario = 1)
		AND tb_generos.nome_genero IN  
		(SELECT tb_generos.nome_genero 
		FROM tb_generos
		INNER JOIN tb_usuario_tem_genero
		ON tb_generos.id_genero = tb_usuario_tem_genero.id_genero
		WHERE id_usuario = 1);
        


        
DROP TABLE tb_generos;
DROP TABLE tb_musicas;
DROP TABLE tb_usuarios;
DROP TABLE tb_musicas_tem_genero;
DROP TABLE tb_usuario_tem_genero;
DROP TABLE tb_usuario_avalia;        
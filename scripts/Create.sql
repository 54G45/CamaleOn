DROP DATABASE IF EXISTS dbbitshow;
CREATE DATABASE dbbitshow;
USE dbbitshow;

SET SQL_SAFE_UPDATES = 0;

create table usuario(
	id int not null auto_increment primary key,
    usuario varchar(50) not null,
    e_mail varchar(100) unique not null, 
    telefone varchar(15) not null,
    senha varchar(50) not null
);

create table produto(
	id int not null auto_increment primary key,
    nome varchar(50) not null,
    descricao text not null,
    categoria varchar(45) not null,
    preco varchar(50) not null,
    idusuario int
    -- nome, descrição, categoria, preço
);

create table carrinho(
	id int not null auto_increment primary key,
    idproduto int,
    idusuario int
);

create table categoria(
	id int not null auto_increment primary key,
    nome varchar(45)
);

select*from usuario;
select*from produto;
select*from carrinho;
insert into carrinho values(null, 1, 2);

select produto.* from produto left join carrinho on carrinho.idproduto = produto.id where carrinho.idusuario = 1;



insert into produto values(null, "Placa Mãe Asus tuf B550m plus", "socket Am4 Refrigeração abrangente: dissipadores de calor no VRM, dissipador de calor sem ventoinha no PCH, dissipador de calor M.2, header de ventoinha híbridos e utilitário Fan Xpert 2+", "Placa-mãe", "1555", 1 );
insert into produto values(null, "Placa Mãe Asus tuf z570 plus", "socket Am4 Refrigeração abrangente: dissipadores de calor no VRM, dissipador de calor sem ventoinha no PCH, dissipador de calor M.2, header de ventoinha híbridos e utilitário Fan Xpert 2+", "Placa-mãe", "2000", 1 );
insert into produto values(null, "Placa Mãe Asus rog strix x570e ", "AMD AM4 Socket 3ª e 2ª AMD Ryzen ™ / 2ª e 1ª Geração AMD Ryzen ™ com Processadores Gráficos Radeon ™ Vega ", "Placa-mãe", "1890", 1 );
insert into produto values(null, "Placa Mãe Asus ROG Strix Z690-A Gaming WiF", "ntel Socket LGA1700 para processadores Intel Core, Pentium Gold e Celeron de 12ª geração Suporta Tecnologia Intel Turbo Boost 2.0 e Tecnologia Intel Turbo Boost Max 3.0 Consulte www.asus.com para obter a lista de suporte de CPU O suporte da Intel Turbo Boost Max Technology 3.0 depende dos tipos de CPU", "Placa mãe", "2660", 1 );
insert into produto values(null, "Placa Mãe Gigabyte B450M Gaming", "AM4: Suporta AMD Ryzen série 5000 / 3ª Geração Ryzen / 2ª Geração Ryzen  / 1ª Geração Ryzen  / 2ª Geração Ryzen com Radeon Vega Graphics / 1ª Geração Ryzen com Radeon Vega Graphics / Athlon com Radeon ™ Processadores Gráficos Vega", "Placa-mãe", "999", 1 );
insert into produto values(null, "Placa Mãe Biostar B550MH", "AMD Socket AM4, suporte para: Processadores AMD Ryzen™ 5000 G-Series/ AMD Ryzen™ 5000 Series Processors/ AMD Ryzen™ 4000 G-Series Processors/ AMD Ryzen™ 3000 Series Processors", "Placa-mãe", "1555", 1 );
insert into produto values(null, "Placa Mãe Gigabyte A520M K V2", "socket Am4 Refrigeração abrangente: dissipadores de calor no VRM, dissipador de calor sem ventoinha no PCH, dissipador de calor M.2, header de ventoinha híbridos e utilitário Fan Xpert 2+", "Placa-mãe", "1555", 1);
insert into produto values(null, "Placa Mãe AsRock B550M Steel Legend", "Suporta processadores AMD AM4 Ryzen ™ de 3ª geração / futuros AMD Ryzen Design Digi Power Design em 10 fases de energia", "Placa-mãe", "1195", 1 );
insert into produto values(null, "Placa Mãe MSI MAG B660M BAZOOKA", "intel B660 Socket: intel 1700 CPU (Suporte Máximo):i9 Canal de memória: Dual", "Placa-mãe", "1890", 1 );
insert into produto values(null, "Processador AMD Ryzen 5 3600", "Marca: AMDNúcleo: 6 core Nº de threads: 12 Frequencia de Operação: 3.6 GHz Frequencia Max Turbo: 4.2 GHz Cache L3: 32MB Potência: 65 W CMOS: 7nm", "CPU", "599", 1 );
insert into produto values(null, "Processador  Intel Core i7 13700F", "Marca:Intel Socket: LGA 1700 Gráfico Integrado: Não possui Frequência base: Frequência de Base P-core (GHz): 2,1 Frequência de Base E-core (GHz): 1,5 Frequência turbo max: Frequência P-core Max Turbo (GHz): Até 5.1 Frequência E-core Max Turbo (GHz): Até 4.1 Cache L2: 24MB Cache L3: 30MB Núcleos: 16-Core (8P+8E) Threads: 24 Revisão PCI express: 5,0 Tamanho máximo da memória (dependendo do tipo de memória): 128GB Tipos de memória: DDR5 5600 MT/s DDR4 3200 MT/s Número máximo de memória: 2 Número máximo de pistas PCI Express: 20 Potência base do processador: 65W Potência turbo máxima: 219W", "CPU", "2599", 1 );
insert into produto values(null, "Memória DDR4 Kingston Fury Beast", "Marca:Kingston Quantidade de Memória: 8GB Tipo: DDR4 Velocidade: 3200Mhz, CL16 Consumo: 1,35v", "RAM", "159", 1 );
insert into produto values(null, "SSD Kingston NV2, 500GB, M.2 NVMe", "Marca: Kingston Modelo: SNV2S/500G Formato: M.2 2280 Interface: NVMe PCIe 4.0 x 4 Capacidade: 500GB Leitura: 3500MBs Gravação: 2100MBs Resistência: 160 TBW Temperatura de armazenamento: -40 ° C ~ 85 ° C Temperatura de operação: 0 ° C ~ 70 ° C Dimensões: 22 mm x 80 mm x 2,2 mm Operação de vibração: 2,17G (7-800 Hz) Vibração não operacional: 20G (20-1000Hz) MTBF: 1.500.000 de horas", "SSD", "179", 1 );















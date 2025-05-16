# 🎟️ Projeto CodeTickets – Spring Batch

Este projeto é uma aplicação Java usando **Spring Boot** e **Spring Batch** para processar arquivos CSV com dados de ingressos, armazenar essas informações em um banco de dados relacional e mover os arquivos processados para uma pasta de arquivos importados.

---

## ✅ Funcionalidades

- **Leitura de Arquivos CSV** com informações de ingressos
- **Processamento e cálculo de taxa administrativa** com base no tipo de ingresso
- **Persistência dos dados** em banco via JDBC
- **Movimentação dos arquivos processados** para uma pasta de destino (`imported-files`)
- **Execução do job via endpoint REST** (`/importar`)

---

## 🧱 Estrutura do Projeto

```
codetickets/
├── files/                    # Pasta de entrada com arquivos .csv a serem processados
├── imported-files/           # Pasta onde os arquivos processados são movidos
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.ernandes.neponuceno.codetickets/
│   │   │       ├── CodeticketsApplication.java
│   │   │       ├── DataSourceConfig.java
│   │   │       ├── Importacao.java
│   │   │       ├── ImportacaoController.java
│   │   │       ├── ImportacaoJobConfiguration.java
│   │   │       ├── ImportacaoMapper.java
│   │   │       └── ImportacaoProcessor.java
│   └── resources/
│       └── application.properties
```

---

## 💾 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.5
- Spring Batch 5.2.2
- Spring Data JPA
- PostgreSQL
- Maven

---

## 🔁 Como o Job funciona?

1. O usuário envia uma requisição GET para `/importar`.
2. O Spring Batch:
   - Lê o arquivo `files/data.csv`.
   - Processa cada linha, aplicando a taxa de administração:
     - `VIP` → R$ 130,00
     - `Camarote` → R$ 80,00
     - Outros → R$ 50,00
   - Persiste os dados no banco de dados (tabela `importacao`).
   - Move o arquivo processado para a pasta `imported-files/`.

---

## ⚙️ Como executar

1. Clone o repositório:
```bash
git clone https://github.com/ErnandesNeponuceno/java-spring-batch-codetickets
cd codetickets
```

2. Configure o banco no `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/sua_base
spring.datasource.jdbcUrl=jdbc:postgresql://localhost/sua_base
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.batch.jdbc.initialize-schema=always
spring.jpa.hibernate.ddl-auto=update
```

3. Compile e execute:
```bash
./mvnw spring-boot:run
```

4. Coloque o arquivo `data.csv` dentro da pasta `files/` com o seguinte formato:
```csv
cpf;cliente;nascimento;evento;data;tipoIngresso;valor
12345678900;João Silva;1990-01-01;Festival Rock;2025-06-20;VIP;500.00
```

5. Acesse a URL no navegador ou via Postman:
```
GET http://localhost:8080/importar
```

---

## 🧪 Exemplo de entrada

**CSV de entrada:**
```
cpf;cliente;nascimento;evento;data;tipoIngresso;valor
12345678900;João Silva;1990-01-01;Festival Rock;2025-06-20;VIP;500.00
```

**Inserção esperada no banco:**
```sql
INSERT INTO importacao (cpf, cliente, nascimento, evento, data, tipo_ingresso, valor, hora_importacao, taxa_adm)
VALUES ('12345678900', 'João Silva', '1990-01-01', 'Festival Rock', '2025-06-20', 'VIP', 500.00, CURRENT_TIMESTAMP, 130.00);
```

---

## 📁 Após execução

- O arquivo CSV será movido de `files/` para `imported-files/`.

---

## ✨ Créditos

Projeto desenvolvido para fins de estudo sobre **Spring Batch** com leitura de arquivos, processamento de dados e movimentação de arquivos.

Aplicação desenvolvida pela **Alura** como projeto educacional no Curso de
Java e Spring: Realizando processamento em lote com Spring Batch.
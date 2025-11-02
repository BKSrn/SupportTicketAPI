# Support Ticket API

API RESTful para gerenciamento de chamados de suporte técnico, desenvolvida com Spring Boot 3.5.4 e Java 21.

## 📋 Sobre o Projeto

Esta API permite o gerenciamento completo de tickets de suporte, incluindo criação, listagem, atualização e exclusão de chamados. O sistema categoriza os tickets por tipo de problema, prioridade e status de atendimento.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.4**
- **Spring Data JPA** - Persistência de dados
- **Spring Validation** - Validação de dados
- **PostgreSQL** - Banco de dados
- **Lombok** - Redução de código boilerplate
- **Maven** - Gerenciamento de dependências

## 📦 Estrutura do Projeto

```
SupportTicketAPI/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── SupportTicketAPI/SupportTicketAPI/
│   │   │       ├── controller/
│   │   │       │   ├── ChamadoController.java
│   │   │       │   └── ExceptionHandlerController.java
│   │   │       ├── dto/
│   │   │       │   ├── ChamadoDTO.java
│   │   │       │   ├── ChamadoRequestDTO.java
│   │   │       │   └── ApiExceptionDTO.java
│   │   │       ├── model/
│   │   │       │   ├── Chamado.java
│   │   │       │   ├── Categoria.java
│   │   │       │   ├── Prioridade.java
│   │   │       │   └── Status.java
│   │   │       ├── repository/
│   │   │       │   └── ChamadoRepository.java
│   │   │       ├── service/
│   │   │       │   └── ChamadoService.java
│   │   │       └── SupportTicketApiApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## 🔧 Configuração

### Pré-requisitos

- Java 21 ou superior
- Maven 3.6+
- PostgreSQL 12+

### Variáveis de Ambiente

Configure as seguintes variáveis de ambiente:

```properties
DB_HOST=localhost:5432
DB_USER=seu_usuario
DB_PASSWORD=sua_senha
```

### Banco de Dados

A aplicação criará automaticamente a tabela `chamados` no banco de dados `support_ticket_db`.

## 🏃 Como Executar

### Usando Maven Wrapper (recomendado)

```bash
# Linux/Mac
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

### Usando Maven instalado

```bash
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

## 📡 Endpoints da API

### Criar Chamado

```http
POST /chamados
Content-Type: application/json

{
  "titulo": "Problema com impressora",
  "descricao": "Impressora não está imprimindo documentos",
  "categoria": "Impressora",
  "prioridade": "Alta",
  "status": "Aberto"
}
```

### Listar Todos os Chamados

```http
GET /chamados
```

### Atualizar Chamado

```http
PUT /chamados/{id}
Content-Type: application/json

{
  "titulo": "Problema com impressora - Resolvido",
  "descricao": "Toner substituído e impressora funcionando",
  "categoria": "Impressora",
  "prioridade": "Baixa",
  "status": "Finalizado"
}
```

### Excluir Chamado

```http
DELETE /chamados/{id}
```

## 📊 Enumerações

### Categorias Disponíveis

- Sistema
- Rede
- Hardware
- Software
- Acesso
- Email
- Impressora
- Banco de Dados
- Servidor
- Outros

### Prioridades

- Baixa
- Media
- Alta

### Status

- Aberto
- Em Andamento / Em Progresso
- Finalizado / Concluído

## ✅ Validações

A API implementa validações para garantir a integridade dos dados:

- **Título**: obrigatório, entre 1 e 50 caracteres
- **Descrição**: obrigatória, entre 1 e 100 caracteres
- **Categoria**: obrigatória, deve ser uma categoria válida
- **Prioridade**: obrigatória, deve ser uma prioridade válida
- **Status**: obrigatório, deve ser um status válido

## 🛠️ Tratamento de Erros

A API possui um sistema centralizado de tratamento de exceções que retorna respostas padronizadas:

### Exemplo de Resposta de Erro (Validação)

```json
{
  "errorList": [
    "titulo: não deve ser nulo",
    "descricao: tamanho deve estar entre 1 e 100"
  ]
}
```

### Exemplo de Resposta de Erro (Categoria Inválida)

```json
{
  "errorList": [
    "Categoria não encontrada: InvalidCategory"
  ]
}
```

## 📝 Exemplo de Uso Completo

```bash
# 1. Criar um novo chamado
curl -X POST http://localhost:8080/chamados \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Sistema lento",
    "descricao": "Sistema de vendas está muito lento",
    "categoria": "Sistema",
    "prioridade": "Alta",
    "status": "Aberto"
  }'

# 2. Listar todos os chamados
curl http://localhost:8080/chamados

# 3. Atualizar o chamado (assumindo id=1)
curl -X PUT http://localhost:8080/chamados/1 \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Sistema lento",
    "descricao": "Cache otimizado, sistema normalizado",
    "categoria": "Sistema",
    "prioridade": "Baixa",
    "status": "Finalizado"
  }'

# 4. Deletar o chamado
curl -X DELETE http://localhost:8080/chamados/1
```

## 🧪 Testes

Execute os testes com:

```bash
./mvnw test
```

## 📄 Licença

Este projeto é um exemplo educacional para demonstração de conceitos de API REST com Spring Boot.

## 👤 Autor

Desenvolvido como projeto de estudo de Spring Boot e APIs RESTful.

---

Para mais informações sobre as tecnologias utilizadas, consulte a documentação oficial:
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [PostgreSQL](https://www.postgresql.org/docs/)

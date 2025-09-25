Clínica API — Spring Boot 
## Requisitos
- Java 21
- Maven 3.9+
- Docker (para rodar testes com Testcontainers) e PostgreSQL local (para desenvolvimento)

## Como rodar
```bash
mvn spring-boot:run
# Swagger UI:
# http://localhost:8080/swagger-ui.html
```

## Banco de Desenvolvimento
A aplicação espera um Postgres local:
- URL: `jdbc:postgresql://localhost:5432/clinica`
- user: `clinica`
- password: `secret`

Use o script do Flyway (automaticamente aplicado) em `src/main/resources/db/migration/V1__init.sql`.

## Endpoints iniciais
- `POST /pacientes` — cria paciente (201)
- `GET  /pacientes` — lista paginada
## Endpoints da API

As rotas expostas pela aplicação seguem o padrão REST e retornam `application/json`. Todos os exemplos abaixo assumem que a aplicação está rodando em `http://localhost:8080`.

### Pacientes

| Método & Rota | Descrição |
| --- | --- |
| `POST /pacientes` | Cadastra um novo paciente. |
| `GET /pacientes/{id}` | Busca os dados de um paciente específico. |
| `GET /pacientes/procurar?especialidades=...` | Lista médicos disponíveis para a especialidade informada. |
| `GET /pacientes/HealthCheck` | Endpoint simples de verificação de disponibilidade da API. |

**Regras e exemplos**

`POST /pacientes`

```http
POST /pacientes
Content-Type: application/json

{
  "nome": "Maria Silva",
  "cpf": "12345678901",
  "email": "maria.silva@example.com"
}
```

- **Validações**: todos os campos são obrigatórios. `cpf` deve conter exatamente 11 dígitos numéricos e `email` deve ser válido.
- **Resposta**: `201 Created` sem corpo e cabeçalho `Location: /pacientes/{id}` apontando para o novo recurso.

`GET /pacientes/{id}`

```http
GET /pacientes/1
```

Resposta (`200 OK`):

```json
{
  "id": 1,
  "nome": "Maria Silva",
  "cpf": "12345678901",
  "email": "maria.silva@example.com"
}
```

`GET /pacientes/procurar?especialidades=CARDIOLOGIA`

Retorna uma lista de médicos cadastrados na especialidade informada. O valor do parâmetro deve ser um dos membros do enum `Especialidades` (por exemplo: `CARDIOLOGIA`, `PEDIATRIA`, `DERMATOLOGIA`, ...).

Resposta (`200 OK`):

```json
[
  {
    "crm": "12345-SP",
    "nome": "Dra. Ana Souza",
    "especialidade": "CARDIOLOGIA",
    "id": 7
  }
]
```

### Médicos

| Método & Rota | Descrição |
| --- | --- |
| `POST /Medicos` | Cadastra um novo médico. *(Atenção: a rota utiliza "M" maiúsculo conforme definido no controlador.)* |

**Regras e exemplos**

```http
POST /Medicos
Content-Type: application/json

{
  "crm": "12345-SP",
  "nome": "Dra. Ana Souza",
  "especialidade": "CARDIOLOGIA"
}
```

- **Validações**: todos os campos são obrigatórios; `especialidade` deve ser um valor válido do enum `Especialidades`.
- **Resposta**: `201 Created` sem corpo e cabeçalho `Location: /medicos/{id}` do recurso recém-criado.

### Consultas

| Método & Rota | Descrição |
| --- | --- |
| `POST /consultas` | Agenda uma nova consulta associando paciente, médico e data/hora. |

**Regras e exemplos**

```http
POST /consultas
Content-Type: application/json

{
  "pacienteId": 1,
  "medicoId": 7,
  "dataHora": "2024-08-21T14:30:00"
}
```

- **Validações**: todos os campos são obrigatórios; `dataHora` deve ser uma data futura no formato ISO-8601 (`yyyy-MM-dd'T'HH:mm:ss`).
- **Resposta**: `201 Created` com o corpo da consulta marcada.

```json
{
  "pacienteId": 1,
  "medicoId": 7,
  "dataHora": "2024-08-21T14:30:00"
}
```

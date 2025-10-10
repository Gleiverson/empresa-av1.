# empresa-av1.
# 🏢 Sistema Empresa - Projeto AV1

Este projeto foi desenvolvido como parte da **Avaliação AV1**, com o objetivo de criar um **sistema básico de gerenciamento de departamentos e funcionários** utilizando **Spring Boot**.

---

## ⚙️ Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.3.5**
- **Maven**
- **Spring Web**
- **Spring Data JPA**
- **Banco de dados H2 (em memória)**
- **Lombok**

---

## 📁 Estrutura do Projeto

src/
└── main/
├── java/com/example/empresa/
│ ├── controller/ → Controladores REST
│ ├── model/ → Classes de modelo (entidades)
│ ├── repository/ → Interfaces JPA
│ └── EmpresaApplication.java → Classe principal
└── resources/
└── application.properties



---

## 🚀 Como Executar o Projeto

### ✅ Opção 1 – Gitpod (sem instalar nada)
1. Acesse:  
   [https://gitpod.io/#https://github.com/Gleiverson/empresa-av1_](https://gitpod.io/#https://github.com/Gleiverson/empresa-av1_)
2. Quando abrir, digite no terminal:


3. Após iniciar, abra o link gerado pelo Gitpod (porta 8080).

### ✅ Opção 2 – Localmente
1. Tenha o **Java 17** e o **Maven** instalados.
2. No terminal, rode:



3. Acesse no navegador:  
[http://localhost:8080](http://localhost:8080)

---

## 📚 Endpoints Principais

### Departamentos
| Método | Endpoint | Descrição |
|--------|-----------|------------|
| GET | `/departamentos` | Lista todos os departamentos |
| POST | `/departamentos` | Cadastra um novo departamento |
| PUT | `/departamentos/{id}` | Atualiza um departamento |
| DELETE | `/departamentos/{id}` | Remove um departamento |

### Funcionários
| Método | Endpoint | Descrição |
|--------|-----------|------------|
| GET | `/funcionarios` | Lista todos os funcionários |
| POST | `/funcionarios` | Cadastra um novo funcionário |
| PUT | `/funcionarios/{id}` | Atualiza um funcionário |
| DELETE | `/funcionarios/{id}` | Remove um funcionário |

---

## 👨‍💻 Autor
**Gleiverson Vinagre**  
Projeto acadêmico desenvolvido para a disciplina da AV1 Estrurura de aplicação WEB.

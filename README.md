# Projeto de Autenticação com Keycloak

Este projeto utiliza o **Keycloak** como provedor de identidade e gerenciador de autenticação, integrando usuários, clientes e roles com suporte a *Service Accounts*.

## 📂 Upload do Realm

A pasta `upload-realm` contém o JSON de configuração do **realm `auth-keycloak-realm`**, que pode ser importado diretamente no Keycloak. Esse arquivo define:

- O cliente `auth-keycloak`
- A role `AUTH-KEYCLOAK` associada ao cliente
- O usuário `teste` com a role atribuída via *client role*
- Outras configurações úteis (redirect URIs, protocolos, etc.)

### 🔁 Como importar

Você pode importar o JSON manualmente via interface do Keycloak:

1. Acesse o painel administrativo do Keycloak.
2. Vá em **Realm Settings > Import**.
3. Selecione o arquivo `upload-realm/realm-export.json`.
4. Clique em **Create**.

Ou via terminal (container Docker):

docker cp upload-realm/realm-export.json <nome-do-container>:/opt/keycloak/data/import
docker exec -it <nome-do-container> /opt/keycloak/bin/kc.sh import --file=/opt/keycloak/data/import/realm-export.json --override

🧪 Tecnologias Utilizadas
Java 21
Keycloak 21.1.1 – Gerenciador de autenticação e autorização

Quarkus 2.13.7.Final – Framework Java leve e nativo

Docker – Containerização dos ambientes (Keycloak, DB, etc.)

OpenID Connect (OIDC) – Protocolo de autenticação baseado em OAuth2

Service Account Roles – Uso de credenciais do cliente para autenticação automática entre sistemas

PostgreSQL / H2 – Suporte a bancos de dados relacionais

👤 Usuário de Teste
Usuário criado no realm para testes rápidos com roles atribuídas:

Usuário: teste 
Senha: testpass
Role: AUTH-KEYCLOAK (vinculada ao client auth-keycloak)

```bash

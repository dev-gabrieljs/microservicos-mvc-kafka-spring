# Microserviço de Carro e Proprietário

Este microserviço tem como objetivo gerenciar anúncios de venda de carros e informações dos proprietários desses carros. Ele oferece funcionalidades de CRUD para os dois recursos (CarPost e OwnerPost), além de integrar com o Kafka para consumir mensagens e processá-las de forma assíncrona.

## Funcionalidades

### CarPost (Postagem de Carro)

- **Criação de anúncios de carros**: Permite a criação de um novo anúncio para venda de carros, associando-os a um proprietário.
- **Listagem de anúncios de carros**: Exibe todos os anúncios de carros registrados no sistema.
- **Edição de anúncio de carro**: Permite alterar os detalhes de um anúncio existente.
- **Remoção de anúncio de carro**: Exclui um anúncio de carro do sistema.

### OwnerPost (Proprietário)

- **Criação de proprietário**: Permite a criação de um novo proprietário para ser associado aos carros.
- **Listagem de proprietários**: Exibe todos os proprietários cadastrados.

## Integração com Kafka

O microserviço consome mensagens de um tópico Kafka (`car-post-topic`) para processar e salvar os dados de carros recebidos de outro sistema (o Portal API).

- **Kafka Consumer**: Recebe as postagens de carro e as insere no banco de dados.

# Iniando Projeto:

Após iniciar o serviço, a aplicação estará disponível na porta 8080 por padrão. Você pode acessar os endpoints da API através de:

[**http://localhost:8080**](http://localhost:8080)

## Estrutura do Projeto
``` Plaintex
📁 controller
│   ├── CarPostController.java
│   └── OwnerPostController.java

📁 dto
│   ├── CarPostDTO.java
│   └── OwnerPostDTO.java

📁 entity
│   ├── CarPostEntity.java
│   └── OwnerPostEntity.java

📁 mapper
│   ├── CarPostMapper.java
│   └── OwnerPostMapper.java

📁 message
│   ├── config
│   │   └── KafkaConfigs.java
│   └── consumer
│       └── KafkaConsumerMessage.java

📁 exception
│   ├── handler
│   │   └── GlobalExceptionHandler.java
│   ├── response
│   │   └── ErrorResponse.java
│   └── custom
│       ├── ValidationException.java
│       └── EntityNotFoundException.java

📁 repository
│   ├── CarPostRepository.java
│   └── OwnerPostRepository.java

📁 service
│   ├── api
│   │   ├── CarPostStoreService.java
│   │   └── OwnerPostService.java
│   └── impl
│       ├── CarPostStoreServiceImpl.java
│       └── OwnerPostServiceImpl.java

📁 util
│   └── ValidationUtils.java

📄 CarApplication.java

````


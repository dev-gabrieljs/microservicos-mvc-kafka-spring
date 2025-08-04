# Portal API

A **Portal API** é uma aplicação de gerenciamento de carros e proprietários para um sistema de vendas, utilizando a integração com Kafka para troca de mensagens e comunicação com um sistema de backend de posts de carros. A API permite a criação de usuários (proprietários de carros), gerenciamento de carros para venda, e a comunicação de eventos de venda de carros por meio do Kafka.


# Estrutura do Projeto

```plaintext
📁 client  
│   ├── CarPostStoreClient  
│   └── config  
│       └── RestTemplateConfig  
│ 
📁 controller  
│   ├── CarPostController  
│   └── OwnerPostController  
│ 
📁 dto  
│   ├── CarPostDTO  
│   └── OwnerPostDTO  
│ 
📁 events  
│   ├── config  
│   │   └── KafkaProducerConfig  
│   ├── producer  
│   │   └── EventProducer  
│   └── topic  
│       └── Topic  
│ 
📁 exception  
│   ├── handler  
│   │   └── GlobalExceptionHandler  
│   ├── response  
│   │   └── ErrorResponse  
│   └── custom  
│       ├── ValidationException  
│       ├── Exception  
│       └── HttpServerErrorException  
│ 
📁 service  
│   ├── api  
│   │   ├── CarPostStoreService  
│   │   └── OwnerPostService  
│   └── impl  
│       ├── CarPostStoreServiceImpl  
│       └── OwnerPostServiceImpl  

📄 ApiApplication  

````

## Descrição dos Componentes

### client
Contém classes que são responsáveis pela comunicação com serviços externos (via RestTemplate).

- **CarPostStoreClient**: Responsável por fazer as requisições REST para o serviço de carros e usuários.
- **RestTemplateConfig**: Configuração do RestTemplate para definir tempo de timeout.

### controller
Contém os controladores responsáveis pelas rotas da API.

- **CarPostController**: Controlador que lida com a criação, alteração, listagem e remoção de carros para venda.
- **OwnerPostController**: Controlador que lida com a criação de novos donos de carros.

### dto
Contém os objetos de transferência de dados (DTOs).

- **CarPostDTO**: Representa os dados de um carro para ser postado.
- **OwnerPostDTO**: Representa os dados de um proprietário de carro.

### events
Configurações e produtores de eventos Kafka.

- **KafkaProducerConfig**: Configura o Kafka Producer.
- **EventProducer**: Envia mensagens para o Kafka.
- **Topic**: Define o tópico Kafka utilizado pela aplicação.

### exception
Lida com exceções personalizadas e tratamento global de erros.

- **GlobalExceptionHandler**: Trata exceções globais e retorna respostas de erro adequadas.
- **ErrorResponse**: Representa a resposta de erro em caso de falhas.
- **ValidationException, HttpServerErrorException, Exception**: Exceções personalizadas utilizadas no projeto.

### service
Contém a lógica de negócio da aplicação.

- **OwnerPostService**: Define a interface para o serviço de gerenciamento de donos de carros.
- **CarPostStoreService**: Define a interface para o serviço de gerenciamento de carros para venda.
- **OwnerPostServiceImpl**: Implementação do serviço de gerenciamento de donos de carros.
- **CarPostStoreServiceImpl**: Implementação do serviço de gerenciamento de carros para venda.

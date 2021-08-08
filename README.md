# invillia-reinvent





### Elastic Search 

Este tutorial utiliza o Elastic Search como repositório de dados, o mesmo que banco de dados. O Elastic Search 
possui operações para indexar (adicionar ou atualizar) e consultar dados. 

No Elastic Search os dados são organizados em classes de documentos (Document) e mantidos em índices (index). Fazendo
uma analogia com banco de dados relacional, o índice é equivalente a uma tabela, enquanto que o documento equivale a 
um registro na tabela. 

Ambos documento no caso do Elastic Search ou registro em um banco de dados relacional, possuem
campos (fields) que armazenam valores como o `código do produto` ou `nome do cliente`. Os valores possuem tipos diferentes,
`numérico` no caso do `código do produto` ou `alphanumérico`no caso do `nome do cliente`.  

O Elastic Search possui um poderoso motor de busca, permitindo criar consultas complexas e personalizadas, sendo utilizado 
por e-commerces que usam o Elastic Search para entregar produtos mais relevantes para o usuário. 

Para simplificar, usaremos o Docker para instânciar do Elastic Search e mante-lo ouvindo na porta 9200.

Excute o seguinte comando no terminal do seu sistema operacional:

```
docker run -d --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:7.6.2
```


### Spring Data

Em uma aplicação Spring, o responsável por simplificar o acesso ao repositório de dados é o Spring Data. Sem o Spring 
Data o desenvolvedor(a) teria que criar uma camada de acesso a dados também conhecido como DAO Layer. Normalmente, 
a implementação de DAO requer gerar vários artefatos de configuração e controle de acesso tornando o código mais
verboso.

https://spring.io/projects/spring-data

O Spring Data visa eliminar a complexidade evitando o chamado boilerplate code. Por exemplo, se você definir uma 
interface que extende ElasticsearchRepository, esta interface irá prover as operações CRUD, permitindo indexar e 
consultar documentos no Elastic Search com chamadas simples para os métodos da interface. 










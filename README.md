Neste projeto procurei criar uma interação entre  “marca” e os “produtos”, o objetivo inicial do meu Feign Client era fazer um sistema de vendas porém depois de muito esforço não foi para frente.
Com isso criei um “mostruário de produtos” e um “estoque de tênis", apliquei o Feign Client seguindo todas as boas práticas que me foram passadas. Planejei de uma forma que, um micro serviço apenas armazena as informações dos tênis e outra apenas mostra de forma organizada as marcas e os produtos correspondentes.

Neste link, você tem acesso aos ténis sem organização por marcas apenas pelos nomes dos tênis:http://localhost:8011/tech4tenis/api/tenis

Neste link tem acesso aos produtos/marcas: http://localhost:8011/tech4produtos/api/produtos

Já neste link, passando o id da marca desejada, você verá os produtos já organizados: http://localhost:8011/tech4produtos/api/produtos/624879a48375780902d86cba

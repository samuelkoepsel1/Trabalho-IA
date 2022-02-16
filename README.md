<!-- Visualizador online: https://stackedit.io/ -->
 ![Logo da UDESC Alto Vale](http://www1.udesc.br/imagens/id_submenu/2019/marca_alto_vale_horizontal_assinatura_rgb_01.jpg)

---

# Classificador de tipos de vidro

Atividade desenvolvida para a disciplina de Inteligência Computacional do [Centro de Educação Superior do Alto Vale do Itajaí (CEAVI/UDESC)](https://www.udesc.br/ceavi)

## [Equipe](#equipe)
 - [**José Carlos Bernardes Brümmer**](mailto:josecarlosb.brummer@gmail.com) - [José Carlos Bernardes Brümmer](https://github.com/jcbebr)
 - [**Samuel Koepsel**](mailto:skoepsel@hotmail.com.br) - [Samuel Koepsel](https://github.com/samuelkoepsel1)
 
## [Problema](#problema)

O problema proposto neste trabalho é identificar o tipo de vidro. O algorítmo deve receber as informações da composição do vidro e classificar a qual tipo de vidro pertence. 

## [Dataset](#dataset)

O dataset utilizado avalia o indídce refrativo do vidro e a sua composição química, retornando qual é o tipo do vidro. 

Serão analisadas 9 colunas, o índice refrativo e 8 compostos químicos, que é medido com a porcentagem do peso do composto em relação ao vidro que ele compõe;

1. Índice refrativo;
2. Sódio;
3. Magnésio;
4. Alumínio;
5. Silício;
6. Potássio;
7. Cálcio;
8. Bário;
9. Ferro;

- https://www.kaggle.com/uciml/glass

## [Técnica](#tecnica)

Para fazer a análise do tipo do vidro será utilizado a rede Multilayer Perceptron como classificador. Para fazer alguns testes utilizamos o software [WEKA](https://www.cs.waikato.ac.nz/ml/weka/), que auxiliou a transformar o csv em um arquivo .arff para ser analisado na ferramenta e também geramos um modelo de previsão de resultados pelo Weka, esse modelo e o arquivo do data-set foram importados em uma aplicação java. A aplicação importa a própria biblioteca do Weka para fazer a previsão do tipo de vidro. O usuário então insere na tela os valores dos componentes do vidro e a aplicação insere ele no modelo de previsão, que após executar as épocas de treinamento ele faz a previsão do tipo de vidro em questão.

## [Resultados](#resultados)

Na parte inicial do trabalho pegamos o arquivos csv do data-set e geramos um arquivo .arff que é gerado pela própria ferramenta do Weka, é feito isso, pois esse modelo de arquivo é mais compatível com a ferramenta do Weka e facilita o desenvolvimento de um modelo de previsão.

Após carregar o data-set no Weka executamos alguns testes de configurações de treinamento do modelo, porém a taxa de erro era muito alta:

<img src=”(https://imgur.com/7Wvzz4F)”>
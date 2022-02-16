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

![image](https://i.imgur.com/7Wvzz4F.png)

Já que a configuração base do modelo não era muito eficaz, testamos algumas configurações diferentes, alterando o tipo de teste de cross-validation para use training set, percebeu que as taxas de erros diminuiram:

=== Summary ===

Correlation coefficient                  0.916 <br />
Mean absolute error                      0.6689 <br />
Root mean squared error                  1.0314 <br />
Relative absolute error                 38.9104 % <br />
Root relative squared error             49.1427 % <br />
Total Number of Instances              214

Pra melhorar a qualidade da previsão a próxima alteração feita foi aumenta o número de épocas do treinamento, testamos algumas configurações que obteram os seguintes resultados:

Num. de Épocas: 3000

=== Summary ===

Correlation coefficient                  0.9362 <br />
Mean absolute error                      0.6393 <br />
Root mean squared error                  0.9434 <br />
Relative absolute error                 37.1904 % <br />
Root relative squared error             44.9493 % <br />
Total Number of Instances              214       

Num. de Épocas: 5000

=== Summary ===

Correlation coefficient                  0.9447 <br />
Mean absolute error                      0.5761 <br />
Root mean squared error                  0.8329 <br />
Relative absolute error                 33.5149 % <br />
Root relative squared error             39.6853 % <br />
Total Number of Instances              214     

Num. de Épocas: 12000

=== Summary ===

Correlation coefficient                  0.9517 <br />
Mean absolute error                      0.5448 <br />
Root mean squared error                  0.7541 <br />
Relative absolute error                 31.6908 % <br />
Root relative squared error             35.9311 % <br />
Total Number of Instances              214  


Continumaos aumentando o número de treinamentos porém os resultados estavam piorando, então mantivemos o número de épocas de treinamento e buscamos outras configurações que poderiam melhorar o resultado do nosso modelo. Estudando outros modelos que utilizavam a ferramenta do Weka como base percebemos que outra configuração importante para a nossa aplicação de previsão, seria configucar as camadas ocultas corretamente.

Organizando a quantidade de neurônios nas camadas ocultas desta forma: 10, 5, 2, obteve-se o seguinte resultado:

=== Summary ===

Correlation coefficient                  0.9928 <br />
Mean absolute error                      0.16 <br /> 
Root mean squared error                  0.2525 <br />
Relative absolute error                  9.3071 % <br />
Root relative squared error             12.0313 % <br />
Total Number of Instances              214   
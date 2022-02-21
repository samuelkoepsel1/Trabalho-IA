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

Após essa alterações foram feitos vários testes e não houve mais grandes melhoras, reorganizando os neurônios das camadas ocultas conseguimos diminuir mais a taxa de erro, mas não foram alcançados os resultados desejados, ela ainda está alta a taxa de erro:

Camadas ocultas: 15, 5, 2
Resultados:

=== Summary ===

Correlation coefficient                  0.9969 <br />
Mean absolute error                      0.1325 <br />
Root mean squared error                  0.1829 <br />
Relative absolute error                  7.7106 % <br />
Root relative squared error              8.7143 % <br />
Total Number of Instances              214

Após vários testes de configurações diferentes, indetificamos uma configuração que diminuia a taxa de erro para 2%, o que já seria uma taxa mais satisfatória para a nossa aplicação, no entanto para chegar nesse valor era necessário subir o número de épocas para 50 mil, o que tornava a aplicação muito lenta, mas os resultados da configuração foram esses:

=== Summary ===

Correlation coefficient                  0.9998 <br />
Mean absolute error                      0.0301 <br />
Root mean squared error                  0.0422 <br />
Relative absolute error                  1.7529 % <br />
Root relative squared error              2.0117 % <br />
Total Number of Instances              214

Analisando os resultados dos nossos modelos então geramos um gráfico para relatar como foram as experiências com o Weka e fundamentar a decisão do modelo que seria implementado em nossa aplicação. Segue o gráfico:

![image](https://i.imgur.com/hxQT27M.jpg)

Como falado anteriormente, buscando uma maneira de não tornar a aplicação muito lenta optamos pela seguinte configuração:

![image](https://i.imgur.com/K9V2e4P.jpg)

O Weka disponibiliza a opção de salvar o modelo de previsão, após gerado esse arquivo, criamos uma aplicação java para executar nosso modelo, foi desenvolvido uma tela simples onde o usuário insere os valores dos componentes químicos do vidro e o índice de refrativo do vidro e a aplicação retorno o tipo de vidro.

![image](https://i.imgur.com/MbWb2Q3.jpg)

Para analisar os campos de entrada foi importada a biblioteca do Weka e utilizado o Multilayer Perceptron que a biblioteca disponibiliza, a aplicação insere o data-set em arquivo .arff e a Model com as configurações que selecionamos, e por último inserimos os valores que o usuário passou e o sistema retorna o tipo do vidro informado.

## [Uso do Sistema](#uso)

Para utilizar o sistema o usuário deve inserir os valores dos componentes químicos e o índice refrativo do vidro em seus respectivos campos e clicar no botão de resultado para obter qual é o tipo do vidro que ele possui.

## [Vídeo](#video)

https://youtu.be/-_meQbRYPXM

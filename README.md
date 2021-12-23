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
Para fazer a análise do tipo do vidro será utilizado a rede Multilayer Perceptron como classificador. Será utilizado também o software [WEKA](https://www.cs.waikato.ac.nz/ml/weka/), pois ele é uma ferramenta que pode ser utilizado para fazer o aprendizado, aplicado para a resolução do problema e funciona muito bem com redes Multilayer Perceptron.
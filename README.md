# Final Project

Turn in final project deliverables here.

## [Project Report](https://docs.google.com/document/d/1bmzZ2TO4tE5mYmTCUBtwjCCvIJoKpjykm1uF5LLd-HY/edit?usp=sharing)
https://docs.google.com/document/d/1bmzZ2TO4tE5mYmTCUBtwjCCvIJoKpjykm1uF5LLd-HY/edit?usp=sharing

-----

## Dataset
The dataset we chose is [Amazon review dataset 2018](http://deepyeti.ucsd.edu/jianmo/amazon/index.html). It includes reviews (ratings, text, helpfulness votes), product metadata (descriptions, category information, price, brand, and image features), and links (also viewed/also bought graphs), and all products metadata.   
This dataset is in Json format, and we would like to parse the original reviews to tsv format.  


## Project Plan

It is unlikely that people just put a single product to a cart while shopping on Amazon.
Instead, we would probably choose different products at the same time. For example, if I want to buy
a package of ground coffee, I probably would also put filter papers into my purchase listing. There
would be plenty of combinations among these reviews, our goal is to discover every possibility and
relationship for each product. In other words, we want to find out how much relevance that 
two(or more)products will be bought at the same time(or very close time).

----
1. Before we start the analysis, we would like to pre-process the dataset to make sure our data is fine.
The original dataset is a 120GB single json file. As we only care about three fields: asin(product’s ID),
user’s ID, and ReviewDate. Therefore, we stored the data to HDFS, processed it on Hadoop, filtered out other fields, And then, we got the tsv format.  [Code1](https://github.com/usf-cs677-fa20/P4-jerry-jiachen-p4/blob/main/data_transform.ipynb), [Code2](https://github.com/usf-cs677-fa20/P4-jerry-jiachen-p4/blob/main/amazon_data_parser.ipynb)  
2. We will want to use spark sql to analyze, so the csv file will be read into Spark sql. 
3. Before we start to analyze the relavance, we also want to know what the most popular and hatest products for some categories. [reviews](https://github.com/usf-cs677-fa20/P4-jerry-jiachen-p4/blob/main/task3_top_review.ipynb), [Hot product](https://github.com/usf-cs677-fa20/P4-jerry-jiachen-p4/blob/main/task3_hot_product_average_score.ipynb), [good/bad products](https://github.com/usf-cs677-fa20/P4-jerry-jiachen-p4/blob/main/task3_good_bad_hot_products.ipynb)
4. We will map each user and purchased products, and count the occurence every two products. Then we will sum up these values and calculate the relevance. [Code](https://github.com/usf-cs677-fa20/P4-jerry-jiachen-p4/blob/main/products_relationship.ipynb)



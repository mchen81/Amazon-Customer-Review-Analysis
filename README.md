# Final Project

Turn in final project deliverables here.

## [Project Report](https://docs.google.com/document/d/1bmzZ2TO4tE5mYmTCUBtwjCCvIJoKpjykm1uF5LLd-HY/edit?usp=sharing)
https://docs.google.com/document/d/1bmzZ2TO4tE5mYmTCUBtwjCCvIJoKpjykm1uF5LLd-HY/edit?usp=sharing

-----

## Dataset

(We already did a lab on this, but you may have changed your mind since then,
so please fill this out):

* Dataset description: The dataset we chose is Amazon review dataset. It includes reviews (ratings, text, helpfulness votes), product metadata (descriptions, category information, price, brand, and image features), and links (also viewed/also bought graphs)
* Format: To make the data easier to analyze, we used Hadoop to transform the raw JSON data to CSV format.
* How you will obtain the data: You can check and download the dataset form here http://deepyeti.ucsd.edu/jianmo/amazon/index.html
* What features are available: Basically, there are three fields we care about: asin(product’s ID), user’s ID, and ReviewDate.

If you are going to use a new system we didn't cover in class, describe it here.
Your project can focus more on using/learning new technologies rather than analysis
if you'd prefer. You may also choose to implement a system for processing big data.

## Project Plan

Please provide a high-level description of what you hope to achieve with your analysis. You have
flexibility here; doing one cool or interesting thing is better than doing many straightforward
things. Imagine that you are going to make a poster to present the project to the rest of the
CS department --- what would be the most important insight you'd want others to gain from your
work?

In some cases, even the best laid plans will go awry. However, you will be evaluated on:

1. Whether you did what you said you'd do
2. The work you put in
3. Presentation of the work

Please provide a brief, one or two paragraph description of your project and what you hope to
analyze:

It is unlikely that people just put a single product to a cart while shopping on Amazon.
Instead, we would probably choose different products at the same time. For example, if I want to buy
a package of ground coffee, I probably would also put filter papers into my purchase listing. There
would be plenty of combinations among these reviews, our goal is to discover every possibility and
relationship for each product. In other words, we want to find out how many possibilities that 
two(or more)products will be bought at the same time(or very close time).


Provide a list of the deliverables you will turn in:

1. We'll clean our dataset and store it in ABC
2. We will implement DEF algorithm
3. Then we will process the data using GHI
4. Finally, we will do X, Y, and Z.

----
1. Before we start the analysis, we would like to pre-process the dataset to make sure our data is fine.
The original dataset is a 88GB single json file. As we only care about three fields: asin(product’s ID),
user’s ID, and ReviewDate. Therefore, we stored the data to HDFS, processed it on Hadoop, filtered out other fields, And then, we got the CSV format data we want.
2. We will want to use spark sql to analyze, so the csv file will be read into Spark sql. 
3. We will map each user and purchased products, and count the occurence every two products. Then we will sum up these values and calculate the possibilities.
4. We will also try to use machine learning to analyze and compare the accuracy

This project will be worth about 10 points, so ~4 deliverables is reasonable (2 pts per deliverable).
Aim for about 1.5 weeks' worth of consistent effort. In other words, this project will be very
focused but you should try to go "deep" in your analysis.

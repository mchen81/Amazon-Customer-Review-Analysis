# Final Project

Turn in final project deliverables here.

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

(add your description here)

Provide a list of the deliverables you will turn in:

1. We'll clean our dataset and store it in ABC
2. We will implement DEF algorithm
3. Then we will process the data using GHI
4. Finally, we will do X, Y, and Z.

----
1. Before we start the analysis, we would like to pre-process the dataset to make sure our data is fine.
The original dataset is a 88GB single json file. As we only care about three fields: asin(product’s ID),
user’s ID, and ReviewDate. Therefore, we stored the data to HDFS, processed it on Hadoop, filtered out other fields, And then, we got the CSV format data we want.
2.
3.
4.

This project will be worth about 10 points, so ~4 deliverables is reasonable (2 pts per deliverable).
Aim for about 1.5 weeks' worth of consistent effort. In other words, this project will be very
focused but you should try to go "deep" in your analysis.

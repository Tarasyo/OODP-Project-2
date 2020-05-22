# OODP_CA2
Project Title

CCT College Dublin Object Orientation Design Patterns CA2. Strudent: Taras Boreyko Teacher: Amilcar Aponte
## Assignment Introduction

The task to design and implement a simulator of a simplified model of a stock market.
The program is going to simulate both companies and investors, following the specific requirements described below.
When the simulation has been completed, the program must present to the user a menu with the list of possible reports for them to see the result.

For this project one of the main goals was to use 3 different Design Patterns and at least two of them
must be structural or behavioural patterns. 

The system must create dynamically 100 companies. All of them must have:
* A unique ID
* A random number of shares (between 500 and 1000)
* A random share price (between 10 and 100)
* Any other attribute that you consider relevant to the context
The system must create dynamically 100 investors. All of them must have:
* A unique ID
* A random budget between 1000 and 10000
* Any other attribute that you consider relevant to the context
Once all the companies have been created, the simulator should run a “trading day”. 
This will run transactions were investors buy shares in the companies that exist, following the rules below:
* If a company sells 10 shares, the share price should double up.
* If any 10 shares are sold (from any company), and a company hasn’t sold any, the price must reduce by 2%.
* Investors can do as many transactions as they like but must buy only one share per transaction. 
Investors must try to buy shares in as many companies as possible to guarantee the safety of their investment.
* The simulator should stop when all shares have been sold, or all investors have spent all their money.

The client program must present the user with a menu with the following options after the simulation:

* Company with the highest capital (number of shares times latest share price)
* Company with the lowest capital (number of shares times latest share price)
* If there is more than one company at the top or bottom position, they all should be
displayed in the result.
* Investor with the highest number of shares
* Investor with the lowest number of shares
* It there is more than one investor in any of the positions, they all should be displayed
in the result.

## Design Patterns Used 
### Singleton enum Pattern
It is important to keep the data safe and if we can create just one instance of the class to all users access just from one point is good.
In this CA used ENUM singleton because it was a good method to have one instance of variables that check when the sale day should to finish.

### Chain of Responsibility Pattern
This is a behavioural design pattern which was used in this CA because it is handy for picking a processing strategy at processing-time, 
and it was possible to do different commands step by step and run the sale day with some conditions. 

### Iterator Pattern
It gives a possibility to access the elements of an object without exposing its underlying representation. 
Which was used in this CA to find the data that the user needed and separate as possible user interaction directly with data.  



